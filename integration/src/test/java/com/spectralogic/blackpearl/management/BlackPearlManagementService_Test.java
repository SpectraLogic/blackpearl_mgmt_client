/*
 * ****************************************************************************
 *   Copyright 2016 Spectra Logic Corporation. All Rights Reserved.
 *   Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *   this file except in compliance with the License. A copy of the License is located at
 *   http://www.apache.org/licenses/LICENSE-2.0
 *   or in the "license" file accompanying this file.
 *   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *   CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *   specific language governing permissions and limitations under the License.
 * **************************************************************************
 */

package com.spectralogic.blackpearl.management;

import com.spectralogic.blackpearl.management.models.*;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class BlackPearlManagementService_Test {

    private static BlackPearlManagementService managementService;

    @BeforeClass
    public static void setup() throws Exception {
        final String endpoint = getEnvVar("BP_MGMT_ENDPOINT");
        final String username = getEnvVar("BP_MGMT_USERNAME");
        final String password = getEnvVar("BP_MGMT_PASSWORD");

        managementService = BlackPearlManagementService.getInstance(endpoint, username, password);
    }

    private static String getEnvVar(final String key) throws Exception {
        final String envVar = System.getenv(key);
        if (envVar == null) {
            throw new Exception("'" + key + "' was not set");
        }
        return envVar;
    }

    @Test
    public void getUsers() throws IOException {
        final Single<Users> users = managementService.users();
        final List<User> userList = users.map(Users::getUsers).blockingGet();

        assertThat(userList).isNotNull();
        assertThat(userList.isEmpty()).isFalse();
        assertThat(containsAdminUser(userList)).isTrue();
    }

    @Test
    public void getActivationKeys() {
        final List<ActivationKey> activationKeys = managementService.activationKeys().map(ActivationKeys::getKeys).blockingGet();

        assertThat(activationKeys).isNotNull();
        assertThat(activationKeys).isNotEmpty();

        assertThat(activationKeys.stream().map(ActivationKey::getKeyType).anyMatch(keyType -> keyType.equals("em_s3"))).isTrue();
    }

    @Test
    public void getUserKeys() {
        final Integer adminUserId = managementService.users()
                .map(Users::getUsers)
                .flatMapObservable(Observable::fromIterable)
                .filter(BlackPearlManagementService_Test::isAdminOrSpectraUser)
                .map(User::getId)
                .firstOrError()
                .blockingGet();

        final List<UserKey> userKeys = managementService.key(adminUserId).map(UserKeys::getKeys).blockingGet();

        assertThat(userKeys).isNotNull();
        assertThat(userKeys).isNotEmpty();

        final UserKey userKey = userKeys.get(0);

        assertThat(userKey).isNotNull();
        assertThat(userKey.getAuthId()).isNotBlank();
        assertThat(userKey.getSecretKey()).isNotBlank();
    }

    @Test
    public void getNetworkInterfaces() {
        final NetworkInterface data = managementService.networkInterfaces()
                .map(NetworkInterfaces::getNetworkInterfaceList)
                .flatMapObservable(Observable::fromIterable)
                .doOnNext(ni -> {
                    System.out.println(ni.getName());
                    System.out.println(ni.getLaggId());
                    System.out.println(ni.getLinkStatus());
                })
                .filter(ni -> ni.getName().contains("Data"))
                .filter(ni -> ni.getAddresses() != null)
                .firstOrError()
                .blockingGet();


        data.getAddresses().forEach(System.out::println);

        assertThat(data).isNotNull();
        assertThat(data.getAddresses()).isNotEmpty();
    }

    private static boolean containsAdminUser(final List<User> users) {
        return users.stream().anyMatch(BlackPearlManagementService_Test::isAdminOrSpectraUser);
    }

    private static boolean isAdminOrSpectraUser(final User user) {
        final String userName = user.getName();
            return userName.equalsIgnoreCase("Administrator") || userName.equalsIgnoreCase("spectra");
    }
}

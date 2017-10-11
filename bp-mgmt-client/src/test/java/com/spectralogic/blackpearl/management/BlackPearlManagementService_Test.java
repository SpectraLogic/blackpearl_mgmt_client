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

import com.spectralogic.blackpearl.management.models.User;
import com.spectralogic.blackpearl.management.models.Users;
import org.junit.BeforeClass;
import org.junit.Test;
import retrofit2.Call;

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
        final Call<Users> users = managementService.users();
        final Users body = users.execute().body();

        assertThat(body).isNotNull();
        assertThat(containsAdminUser(body.getUsers())).isTrue();
    }


    private boolean containsAdminUser(final List<User> users) {
        return users.stream().anyMatch(user -> {
            final String userName = user.getName();
            return userName.equalsIgnoreCase("Administrator") || userName.equalsIgnoreCase("spectra");
        });
    }
}


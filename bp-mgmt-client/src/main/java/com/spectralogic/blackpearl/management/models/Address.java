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

package com.spectralogic.blackpearl.management.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty("address")
    private final String address;

    @JsonProperty("autoconf")
    private final boolean autoconf;

    @JsonCreator
    public Address(@JsonProperty("address") final String address, @JsonProperty("autoconf") final boolean autoconf) {
        this.address = address;
        this.autoconf = autoconf;
    }

    public String getAddress() {
        return address;
    }

    public boolean isAutoconf() {
        return autoconf;
    }
}
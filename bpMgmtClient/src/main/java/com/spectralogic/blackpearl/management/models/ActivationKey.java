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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * {
 * "action":"add",
 * "created_at":1499277423,
 * "current":true,
 * "expires_at":0,
 * "id":1,
 * "key_data":100,
 * "key_type":"em_s3_sas_count",
 * "raw_key":"UVX6B4HLXB7MAYP",
 * "updated_at":1499277423,
 * "decoded_key_data":100,
 * "decoded_key_data_str":"100"
 * }
 */
public class ActivationKey {
    @JsonProperty("action")
    private String action;
    @JsonProperty("created_at")
    private long createdAt;
    @JsonProperty("current")
    private boolean current;
    @JsonProperty("expires_at")
    private long expiresAt;
    @JsonProperty("key_data")
    private long keyData;
    @JsonProperty("key_type")
    private String keyType;
    @JsonProperty("raw_key")
    private String rawKey;
    @JsonProperty("updated_at")
    private long updatedAt;
    @JsonProperty("decoded_key_data")
    private long decodedKeyData;
    @JsonProperty("decoded_key_data_str")
    private String decodedKeyDataStr;

    public String getAction() {
        return action;
    }

    public void setAction(final String action) {
        this.action = action;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final long createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(final boolean current) {
        this.current = current;
    }

    public long getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(final long expiresAt) {
        this.expiresAt = expiresAt;
    }

    public long getKeyData() {
        return keyData;
    }

    public void setKeyData(final long keyData) {
        this.keyData = keyData;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(final String keyType) {
        this.keyType = keyType;
    }

    public String getRawKey() {
        return rawKey;
    }

    public void setRawKey(final String rawKey) {
        this.rawKey = rawKey;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getDecodedKeyData() {
        return decodedKeyData;
    }

    public void setDecodedKeyData(final long decodedKeyData) {
        this.decodedKeyData = decodedKeyData;
    }

    public String getDecodedKeyDataStr() {
        return decodedKeyDataStr;
    }

    public void setDecodedKeyDataStr(final String decodedKeyDataStr) {
        this.decodedKeyDataStr = decodedKeyDataStr;
    }
}

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

import java.util.List;
import java.util.UUID;

public class User {

    @JsonProperty("created_at")
    private long createdAt;
    @JsonProperty("email")
    private String email;
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("role")
    private int role;
    @JsonProperty("session_timeout")
    private int sessionTimeout;
    @JsonProperty("updated_at")
    private long updatedAt;
    @JsonProperty("username")
    private String username;
    @JsonProperty("remote_support_enabled")
    private boolean remoteSupportEnabled;
    @JsonProperty("default_data_policy_id")
    private UUID defaultDataPolicyId;
    @JsonProperty("global_bucket_acl_permissions")
    private List<String> globalBucketAclPermissions;
    @JsonProperty("global_data_policy_acl_enabled")
    private boolean globalDataPolicyAclEnabled;

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final long createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(final int role) {
        this.role = role;
    }

    public int getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(final int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public boolean isRemoteSupportEnabled() {
        return remoteSupportEnabled;
    }

    public void setRemoteSupportEnabled(final boolean remoteSupportEnabled) {
        this.remoteSupportEnabled = remoteSupportEnabled;
    }

    public UUID getDefaultDataPolicyId() {
        return defaultDataPolicyId;
    }

    public void setDefaultDataPolicyId(final UUID defaultDataPolicyId) {
        this.defaultDataPolicyId = defaultDataPolicyId;
    }

    public List<String> getGlobalBucketAclPermissions() {
        return globalBucketAclPermissions;
    }

    public void setGlobalBucketAclPermissions(final List<String> globalBucketAclPermissions) {
        this.globalBucketAclPermissions = globalBucketAclPermissions;
    }

    public boolean isGlobalDataPolicyAclEnabled() {
        return globalDataPolicyAclEnabled;
    }

    public void setGlobalDataPolicyAclEnabled(final boolean globalDataPolicyAclEnabled) {
        this.globalDataPolicyAclEnabled = globalDataPolicyAclEnabled;
    }
}

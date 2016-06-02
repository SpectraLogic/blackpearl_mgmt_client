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

public class PowerSupply implements HardwareStatus {
    @JsonProperty("case_id")
    private String caseId;
    @JsonProperty("created_at")
    private long createdAt;
    @JsonProperty("id")
    private String id;
    @JsonProperty("physical_path")
    private String physicalPath;
    @JsonProperty("pmbus_errors")
    private List<String> pmbusErrors;
    @JsonProperty("powered")
    private boolean powered;
    @JsonProperty("slot")
    private long slot;
    @JsonProperty("status")
    private String status;
    @JsonProperty("updated_at")
    private long updatedAt;
    @JsonProperty("watts")
    private int watts;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(final String caseId) {
        this.caseId = caseId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final long createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getPhysicalPath() {
        return physicalPath;
    }

    public void setPhysicalPath(final String physicalPath) {
        this.physicalPath = physicalPath;
    }

    public List<String> getPmbusErrors() {
        return pmbusErrors;
    }

    public void setPmbusErrors(final List<String> pmbusErrors) {
        this.pmbusErrors = pmbusErrors;
    }

    public boolean isPowered() {
        return powered;
    }

    public void setPowered(final boolean powered) {
        this.powered = powered;
    }

    public long getSlot() {
        return slot;
    }

    public void setSlot(final long slot) {
        this.slot = slot;
    }

    @Override
    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getWatts() {
        return watts;
    }

    public void setWatts(final int watts) {
        this.watts = watts;
    }
}

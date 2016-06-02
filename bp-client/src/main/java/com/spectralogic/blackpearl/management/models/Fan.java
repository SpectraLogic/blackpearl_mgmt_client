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

public class Fan implements HardwareStatus {
    @JsonProperty("case_id")
    private String caseId;
    @JsonProperty("created_at")
    private long createdAt;
    @JsonProperty("id")
    private long id;
    @JsonProperty("physical_path")
    private String physicalPath;
    @JsonProperty("powered")
    private boolean powered;
    @JsonProperty("slot")
    private int slot;
    @JsonProperty("speed")
    private long speed;
    @JsonProperty("status")
    private String status;
    @JsonProperty("updated_at")
    private long updatedAt;

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

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getPhysicalPath() {
        return physicalPath;
    }

    public void setPhysicalPath(final String physicalPath) {
        this.physicalPath = physicalPath;
    }

    public boolean isPowered() {
        return powered;
    }

    public void setPowered(final boolean powered) {
        this.powered = powered;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(final int slot) {
        this.slot = slot;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(final long speed) {
        this.speed = speed;
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
}

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

public class Cpu implements HardwareStatus {
    @JsonProperty("case_id")
    private String caseId;
    @JsonProperty("created_at")
    private long createdAt;
    @JsonProperty("hyperthreading")
    private boolean hyperthreading;
    @JsonProperty("id")
    private long id;
    @JsonProperty("temperature")
    private double temperature;
    @JsonProperty("tjmax")
    private double tjmax;
    @JsonProperty("updated_at")
    private long updatedAt;
    @JsonProperty("slot")
    private int slot;
    @JsonProperty("status")
    private String status;

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

    public boolean isHyperthreading() {
        return hyperthreading;
    }

    public void setHyperthreading(final boolean hyperthreading) {
        this.hyperthreading = hyperthreading;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(final double temperature) {
        this.temperature = temperature;
    }

    public double getTjmax() {
        return tjmax;
    }

    public void setTjmax(final double tjmax) {
        this.tjmax = tjmax;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(final int slot) {
        this.slot = slot;
    }

    @Override
    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }
}

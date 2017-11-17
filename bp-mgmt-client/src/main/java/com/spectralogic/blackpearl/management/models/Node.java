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

public class Node {
    @JsonProperty("name")
    private String name;
    @JsonProperty("part_number")
    private String partNumber;
    @JsonProperty("software_version")
    private String softwareVersion;
    @JsonProperty("safe_mode")
    private boolean safeMode;
    @JsonProperty("serial_number")
    private String serialNumber;
    @JsonProperty("cod_restore_in_progress")
    private boolean codRestoreInProgress;
    @JsonProperty("manufacturing_mode")
    private boolean manufacturingMode;
    @JsonProperty("run_state")
    private String runState;
    @JsonProperty("pending_shutdown")
    private boolean pendingShutdown;
    @JsonProperty("memory")
    private long memory;
    @JsonProperty("expansion_cards")
    private List<ExpansionCard> expansionCards;
    @JsonProperty("hotpair_status")
    private HotpairStatus hotpairStatus;
    @JsonProperty("created_at")
    private long createdAt;
    @JsonProperty("updated_at")
    private long updatedAt;
    @JsonProperty("id")
    private String id;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(final String partNumber) {
        this.partNumber = partNumber;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(final String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public boolean isSafeMode() {
        return safeMode;
    }

    public void setSafeMode(final boolean safeMode) {
        this.safeMode = safeMode;
    }

    public boolean isCodRestoreInProgress() {
        return codRestoreInProgress;
    }

    public void setCodRestoreInProgress(final boolean codRestoreInProgress) {
        this.codRestoreInProgress = codRestoreInProgress;
    }

    public boolean isManufacturingMode() {
        return manufacturingMode;
    }

    public void setManufacturingMode(final boolean manufacturingMode) {
        this.manufacturingMode = manufacturingMode;
    }

    public String getRunState() {
        return runState;
    }

    public void setRunState(final String runState) {
        this.runState = runState;
    }

    public boolean isPendingShutdown() {
        return pendingShutdown;
    }

    public void setPendingShutdown(final boolean pendingShutdown) {
        this.pendingShutdown = pendingShutdown;
    }

    public long getMemory() {
        return memory;
    }

    public void setMemory(final long memory) {
        this.memory = memory;
    }

    public List<ExpansionCard> getExpansionCards() {
        return expansionCards;
    }

    public void setExpansionCards(final List<ExpansionCard> expansionCards) {
        this.expansionCards = expansionCards;
    }

    public HotpairStatus getHotpairStatus() {
        return hotpairStatus;
    }

    public void setHotpairStatus(final HotpairStatus hotpairStatus) {
        this.hotpairStatus = hotpairStatus;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public static class ExpansionCard {
        @JsonProperty("slot")
        private int slot;
        @JsonProperty("type")
        private String type;
        @JsonProperty("address")
        private List<Integer> address;
        @JsonProperty("devname")
        private String devname;
        @JsonProperty("unit")
        private int unit;
        @JsonProperty("devices")
        private List<String> devices;

        public int getSlot() {
            return slot;
        }

        public void setSlot(final int slot) {
            this.slot = slot;
        }

        public String getType() {
            return type;
        }

        public void setType(final String type) {
            this.type = type;
        }

        public List<Integer> getAddress() {
            return address;
        }

        public void setAddress(final List<Integer> address) {
            this.address = address;
        }

        public String getDevname() {
            return devname;
        }

        public void setDevname(final String devname) {
            this.devname = devname;
        }

        public int getUnit() {
            return unit;
        }

        public void setUnit(final int unit) {
            this.unit = unit;
        }

        public List<String> getDevices() {
            return devices;
        }

        public void setDevices(final List<String> devices) {
            this.devices = devices;
        }
    }

    public static class HotpairStatus {
        @JsonProperty("active_hostid")
        private String activeHostid;
        @JsonProperty("hotpair")
        private boolean hotpair;
        @JsonProperty("local_serial")
        private String localSerial;
        @JsonProperty("local_state")
        private String localState;
        @JsonProperty("peer_serial")
        private String peer_serial;
        @JsonProperty("active_zfs_hostid")
        private String activeZfsHostid;
        @JsonProperty("state")
        private String state;
        @JsonProperty("peer_state")
        private String peer_state;

        public String getActiveHostid() {
            return activeHostid;
        }

        public void setActiveHostid(final String activeHostid) {
            this.activeHostid = activeHostid;
        }

        public boolean isHotpair() {
            return hotpair;
        }

        public void setHotpair(final boolean hotpair) {
            this.hotpair = hotpair;
        }

        public String getLocalSerial() {
            return localSerial;
        }

        public void setLocalSerial(final String localSerial) {
            this.localSerial = localSerial;
        }

        public String getLocalState() {
            return localState;
        }

        public void setLocalState(final String localState) {
            this.localState = localState;
        }

        public String getPeer_serial() {
            return peer_serial;
        }

        public void setPeer_serial(final String peer_serial) {
            this.peer_serial = peer_serial;
        }

        public String getActiveZfsHostid() {
            return activeZfsHostid;
        }

        public void setActiveZfsHostid(final String activeZfsHostid) {
            this.activeZfsHostid = activeZfsHostid;
        }

        public String getState() {
            return state;
        }

        public void setState(final String state) {
            this.state = state;
        }

        public String getPeer_state() {
            return peer_state;
        }

        public void setPeer_state(final String peer_state) {
            this.peer_state = peer_state;
        }
    }
}

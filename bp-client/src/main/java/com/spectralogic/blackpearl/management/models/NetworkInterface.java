/*
 * *****************************************************************************
 *   Copyright 2016 Spectra Logic Corporation. All Rights Reserved.
 *   Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *   this file except in compliance with the License. A copy of the License is located at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   or in the "license" file accompanying this file.
 *   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *   CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *   specific language governing permissions and limitations under the License.
 * ***************************************************************************
 */

package com.spectralogic.blackpearl.management.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class NetworkInterface {
    @JsonProperty("link_status")
    private String linkStatus;
    @JsonProperty("default_gateway")
    private String defaultGateway;
    @JsonProperty("dhcp")
    private boolean dhcp;
    @JsonProperty("fib")
    private int fib;
    @JsonProperty("fqdn")
    private String fqdn;
    @JsonProperty("ifname")
    private String ifname;
    @JsonProperty("lagg_id")
    private String laggId;
    @JsonProperty("link_speed")
    private long linkSpeed;
    @JsonProperty("mac")
    private String mac;
    @JsonProperty("mtu")
    private int mtu;
    @JsonProperty("peername")
    private String peername;
    @JsonProperty("port_type")
    private String portType;
    @JsonProperty("slot")
    private int slot;
    @JsonProperty("supported_media")
    private List<String> supportedMedia;
    @JsonProperty("up")
    private boolean up;
    @JsonProperty("addresses")
    private List<String> addresses;
    @JsonProperty("hotpair_addresses")
    private String hotpairAddresses;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("name_servers")
    private List<String> nameServers;
    @JsonProperty("name")
    private String name;
    @JsonProperty("search_domains")
    private List<String> searchDomains;
    @JsonProperty("dns")
    private String dns;

    public String getLinkStatus() {
        return linkStatus;
    }

    public void setLinkStatus(final String linkStatus) {
        this.linkStatus = linkStatus;
    }

    public String getDefaultGateway() {
        return defaultGateway;
    }

    public void setDefaultGateway(final String defaultGateway) {
        this.defaultGateway = defaultGateway;
    }

    public boolean isDhcp() {
        return dhcp;
    }

    public void setDhcp(final boolean dhcp) {
        this.dhcp = dhcp;
    }

    public int getFib() {
        return fib;
    }

    public void setFib(final int fib) {
        this.fib = fib;
    }

    public String getFqdn() {
        return fqdn;
    }

    public void setFqdn(final String fqdn) {
        this.fqdn = fqdn;
    }

    public String getIfname() {
        return ifname;
    }

    public void setIfname(final String ifname) {
        this.ifname = ifname;
    }

    public String getLaggId() {
        return laggId;
    }

    public void setLaggId(final String laggId) {
        this.laggId = laggId;
    }

    public long getLinkSpeed() {
        return linkSpeed;
    }

    public void setLinkSpeed(final long linkSpeed) {
        this.linkSpeed = linkSpeed;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(final String mac) {
        this.mac = mac;
    }

    public int getMtu() {
        return mtu;
    }

    public void setMtu(final int mtu) {
        this.mtu = mtu;
    }

    public String getPeername() {
        return peername;
    }

    public void setPeername(final String peername) {
        this.peername = peername;
    }

    public String getPortType() {
        return portType;
    }

    public void setPortType(final String portType) {
        this.portType = portType;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(final int slot) {
        this.slot = slot;
    }

    public List<String> getSupportedMedia() {
        return supportedMedia;
    }

    public void setSupportedMedia(final List<String> supportedMedia) {
        this.supportedMedia = supportedMedia;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(final boolean up) {
        this.up = up;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(final List<String> addresses) {
        this.addresses = addresses;
    }

    public String getHotpairAddresses() {
        return hotpairAddresses;
    }

    public void setHotpairAddresses(final String hotpairAddresses) {
        this.hotpairAddresses = hotpairAddresses;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<String> getNameServers() {
        return nameServers;
    }

    public void setNameServers(final List<String> nameServers) {
        this.nameServers = nameServers;
    }
}

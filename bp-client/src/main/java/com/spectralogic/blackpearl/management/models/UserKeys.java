package com.spectralogic.blackpearl.management.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserKeys {
    @JsonProperty("data")
    private List<UserKey> keys;

    public List<UserKey> getKeys() {
        return keys;
    }

    public void setKeys(final List<UserKey> keys) {
        this.keys = keys;
    }
}

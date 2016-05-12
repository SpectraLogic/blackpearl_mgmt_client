package com.spectralogic.blackpearl.management.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Logs {

    @JsonProperty("data")
    private List<LogSet> logs;

    public List<LogSet> getLogs() {
        return logs;
    }

    public void setLogs(final List<LogSet> logs) {
        this.logs = logs;
    }


}

package com.example.assignment01date.model;

import lombok.Getter;
import lombok.Setter;

public class RequestBodyModel {
    private Long unixTime;

    public Long getUnixTime() {
        return unixTime;
    }

    public void setUnixTime(Long unixTime) {
        this.unixTime = unixTime;
    }
}

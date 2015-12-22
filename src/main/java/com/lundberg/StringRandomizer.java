package com.lundberg;

import java.util.UUID;

public class StringRandomizer {

    private String uuid;

    public void execute() {
        uuid = getRandomUUID();
    }

    public String getUuid() {
        return uuid;
    }

    private String getRandomUUID() {
        return UUID.randomUUID().toString();
    }
}

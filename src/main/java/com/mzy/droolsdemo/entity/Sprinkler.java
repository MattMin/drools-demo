package com.mzy.droolsdemo.entity;

import lombok.Data;

@Data
public class Sprinkler {
    private Room room;
    private boolean on;

    public Sprinkler(Room room) {
        this.room = room;
    }
}

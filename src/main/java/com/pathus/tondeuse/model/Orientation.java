package com.pathus.tondeuse.model;

import lombok.Getter;

@Getter
public enum Orientation {
    NORTH("N"), WEST("W"), SOUTH("S"), EAST("E");

    private final String direction;
    Orientation(String direction) {
        this.direction = direction;
    }
}

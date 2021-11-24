package com.pathus.tondeuse.model;

import lombok.Getter;

@Getter
public enum Turn {
    LEFT("G"),
    RIGHT("D"),
    MOVE("A");

    private final String code;

    Turn(String code) {
        this.code = code;
    }


}

package com.pathus.tondeuse.utils;

import com.pathus.tondeuse.model.Orientation;
import com.pathus.tondeuse.model.Turn;

/**
 * Contains utility methods for the checks.
 *
 */
public final class MowerCheckUtil {

    /** Prevent instances. */
    private MowerCheckUtil(){
    }

    /**
     * Returns whether an action if valid or not
     *
     * @param action the action to check
     * @return true, if action is a valid move.
     */
    public static boolean isValidMove(String action) {
        return action.equalsIgnoreCase(Turn.MOVE.getCode())
                || action.equalsIgnoreCase(Turn.LEFT.getCode())
                || action.equalsIgnoreCase(Turn.RIGHT.getCode());
    }

    /**
     * check if the mower has a valid direction
     * @param direction his directIon
     * @return true if valid or false
     */
    public static boolean checkDirectionValidity(String direction) {
        return direction.equalsIgnoreCase(Orientation.EAST.getDirection())
                || direction.equalsIgnoreCase(Orientation.NORTH.getDirection())
                || direction.equalsIgnoreCase(Orientation.SOUTH.getDirection())
                || direction.equalsIgnoreCase(Orientation.WEST.getDirection());
    }

    /**
     * check is the string is a numeric
     * @param str string as numeric
     * @return true if the string is a numeric or false
     */
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

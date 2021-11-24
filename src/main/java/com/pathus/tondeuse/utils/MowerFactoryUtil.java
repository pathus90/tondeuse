package com.pathus.tondeuse.utils;

import com.pathus.tondeuse.exception.MowerException;
import com.pathus.tondeuse.model.Orientation;
import com.pathus.tondeuse.model.Mower;
import com.pathus.tondeuse.model.Lawn;
import com.pathus.tondeuse.model.Position;
import com.pathus.tondeuse.model.Constant;

/**
 * Contains utility methods for the Mower.
 */
public final class MowerFactoryUtil {

    /**
     * get mower orientation
     * @param direction mower direction
     * @return mower orientation
     */
    private static Orientation getOrientation(String direction) {
        Orientation orientation;
        switch (direction) {
            case "N":
                orientation = Orientation.NORTH;
                break;
            case "E":
                orientation = Orientation.EAST;
                break;
            case "W":
                orientation = Orientation.WEST;
                break;
            case "S":
                orientation = Orientation.SOUTH;
                break;
            default:
                throw new MowerException("Unexpected direction: " + direction);
        }
        return orientation;
    }

    /**
     * method is used to create mower
     * @param line mower line from the file
     * @return created mower
     */
    public static Mower createMower(String line) {
        final String [] mowerPosOrientation = line.split(Constant.BLANK);
        if (mowerPosOrientation.length != Constant.CHARACTER_LENGTH) {
            throw new MowerException("la première ligne doit contenir la position la tondeuse, ainsi que son orientation");
        }
        String direction = mowerPosOrientation[2];
        if (!MowerCheckUtil.checkDirectionValidity(direction)) {
            throw new MowerException("l'orientation de la tondeuse n'est pas valide");
        }
        if (!MowerCheckUtil.isNumeric(mowerPosOrientation[0]) || !MowerCheckUtil.isNumeric(mowerPosOrientation[1])) {
            throw new MowerException("la position de la tondeuse est invalide");
        }
        int posX = Integer.parseInt(mowerPosOrientation[0]);
        int posY = Integer.parseInt(mowerPosOrientation[1]);

        return new Mower(new Position(posX,posY), getOrientation(direction));
    }

    /**
     * method is used to create Lawn
     * @param line lawn line from the file
     * @return created lawn
     */
    public static Lawn createLawn(String line) {
        final String [] lawnPos = line.split(Constant.BLANK);
        if (lawnPos.length != Constant.LAWN_CHARACTER_LENGTH) {
            throw new MowerException("la position de la pelouse est invalide");
        }
        if (!MowerCheckUtil.isNumeric(lawnPos[0]) || !MowerCheckUtil.isNumeric(lawnPos[1])) {
            throw new MowerException("la position de la pelouse est invalide");
        }
        int posX = Integer.parseInt(lawnPos[0]);
        int posY = Integer.parseInt(lawnPos[1]);
        return new Lawn(new Position(posX, posY));
    }
}

package com.pathus.tondeuse.model;

import com.pathus.tondeuse.exception.MowerException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.NonNull;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Mower {

    @NonNull
    private Position position;
    @NonNull
    private Orientation orientation;
    private char[] instructions;

    public void turnLeft90Degrees(){
        if (orientation.getDirection().equalsIgnoreCase(Orientation.NORTH.getDirection())) {
            orientation = Orientation.WEST;
        } else if (orientation.getDirection().equalsIgnoreCase(Orientation.WEST.getDirection())) {
            orientation = Orientation.SOUTH;
        } else if (orientation.getDirection().equalsIgnoreCase(Orientation.SOUTH.getDirection())) {
            orientation = Orientation.EAST;
        } else if (orientation.getDirection().equalsIgnoreCase(Orientation.EAST.getDirection())) {
            orientation = Orientation.NORTH;
        }
    }

    public void turnRight90Degrees(){
        if (orientation.getDirection().equalsIgnoreCase(Orientation.NORTH.getDirection())) {
            orientation = Orientation.EAST;
        } else if (orientation.getDirection().equalsIgnoreCase(Orientation.EAST.getDirection())) {
            orientation = Orientation.SOUTH;
        } else if (orientation.getDirection().equalsIgnoreCase(Orientation.SOUTH.getDirection())) {
            orientation = Orientation.WEST;
        } else if (orientation.getDirection().equalsIgnoreCase(Orientation.WEST.getDirection())){
            orientation = Orientation.NORTH;
        }
    }

    public void moveForward(Lawn lawn) {
        String direction = this.getOrientation().getDirection();
        switch (direction) {
            case "N":
                if (this.getPosition().getY() < lawn.getPosition().getY()) {
                    this.getPosition().setY(this.getPosition().getY()+1);
                }
                break;
            case "E":
                if (this.getPosition().getX() < lawn.getPosition().getX()) {
                    this.getPosition().setX(this.getPosition().getX()+1);
                }
                break;
            case "W":
                if (this.getPosition().getX() > 0) {
                    this.getPosition().setX(this.getPosition().getX()-1);
                }
                break;
            case "S":
                if (this.getPosition().getY() > 0) {
                    this.getPosition().setY(this.getPosition().getY()-1);
                }
                break;
            default:
                throw new MowerException("Unexpected direction: " + direction);
        }
    }

    public String displayFinalPositionOfTheMower(){
        return String.join(" ",
                String.valueOf(position.getX()),
                String.valueOf(position.getY()),
                orientation.getDirection());
    }
}

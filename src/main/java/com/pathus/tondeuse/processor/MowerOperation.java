package com.pathus.tondeuse.processor;

import com.pathus.tondeuse.exception.MowerException;
import com.pathus.tondeuse.model.Mower;
import com.pathus.tondeuse.model.Lawn;
import com.pathus.tondeuse.utils.MowerCheckUtil;
import com.pathus.tondeuse.utils.MowerFactoryUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public final class MowerOperation {

    /** Prevent instances. */
    private MowerOperation() {
    }

    /**
     * method is used to move mowers presents inside the input file
     * @param filename input file
     * @return list of mowers
     * @throws FileNotFoundException if the file does not exist or cannot be read
     */
    public static List<Mower> moveMowers(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        List<Mower> mowers = null;
        if (scanner.hasNext()) {
            Lawn lawn = MowerFactoryUtil.createLawn(scanner.nextLine());
            mowers = new ArrayList<>();
            while (scanner.hasNext()) {
                Mower mower = MowerFactoryUtil.createMower(scanner.nextLine());
                if (scanner.hasNext()) {
                    mower.setInstructions(scanner.nextLine().toCharArray());
                    processInstructions(mower, lawn);
                    mowers.add(mower);
                }
            }
        }
        return mowers;
    }

    /**
     * process mower instructions
     * @param mower the mower
     * @param lawn the lawn
     */
    private static void processInstructions(Mower mower, Lawn lawn) {
        for (char c : mower.getInstructions()) {
            String action = String.valueOf(c);
            if (!MowerCheckUtil.isValidMove(action)) {
                throw new MowerException("Les lettres possibles sont « D », « G » et « A ».");
            } else {
                switch (action) {
                    case "G":
                        mower.turnLeft90Degrees();
                        break;
                    case "D":
                        mower.turnRight90Degrees();
                        break;
                    case "A":
                        mower.moveForward(lawn);
                        break;
                    default:
                        throw new MowerException("Unexpected action: " + action);
                }
            }
        }
    }
}

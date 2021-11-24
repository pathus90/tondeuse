package com.pathus.tondeuse;

import com.pathus.tondeuse.model.Mower;
import com.pathus.tondeuse.processor.MowerOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.util.List;

@SpringBootApplication
public class MowerApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(MowerApplication.class, args);
		lunchLowers();
	}

	public static void lunchLowers() throws FileNotFoundException {
		List<Mower> mowerList = MowerOperation.moveMowers("src/main/resources/files/mowers.txt");
		for (Mower mower : mowerList) {
			System.out.println(mower.displayFinalPositionOfTheMower());
		}
	}

}

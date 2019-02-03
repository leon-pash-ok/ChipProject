package com.leonpasha.corp.chip.chip_generator;

import com.leonpasha.corp.chip.pojo.Chip;
import com.leonpasha.corp.chip.pojo.ChipTypeOfCargo;

import java.security.InvalidParameterException;
import java.util.Optional;
import java.util.Random;

public class ChipGenerator {
    private static int maxCountOfShip = 10;
    private static int countOfCreatedShip = 0;

    public static Optional<Chip> generateChip(){
        if ( !isEnough()) {
            ChipTypeOfCargo cargo = generateTypeOfCargo(generateInt());
            int roominess = generateRoominess(generateInt());
            Chip chip = new Chip(cargo, roominess);
            System.out.println("New chip created.  " + chip.toString());
            countOfCreatedShip++;
            System.out.println("countOfCreatedShip =  " + countOfCreatedShip);
            return Optional.of(chip);
        } else{
            return Optional.empty();
        }
    }

    private static int generateInt(){
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    private static ChipTypeOfCargo generateTypeOfCargo(int num){
        return ChipTypeOfCargo.getType(num);
    }

    private static int generateRoominess(int num){
        switch (num){
            case 1: return 10;
            case 2: return 50;
            case 3: return 100;
            default:
                throw new InvalidParameterException("Invalid number: " + num);
        }
    }

    public static boolean isEnough(){
        return maxCountOfShip < countOfCreatedShip;
    }
}

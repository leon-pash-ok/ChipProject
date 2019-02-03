package com.leonpasha.corp.chip.pojo;

import java.security.InvalidParameterException;

public enum ChipTypeOfCargo {

    BREAD(1),
    BANANA(2),
    CLOTHES(3);

    private int typeNum;

    ChipTypeOfCargo(int typeNum){
        this.typeNum =typeNum;
    }

    public int getTypeNum() {
        return typeNum;
    }

    public static ChipTypeOfCargo getType(int num) {
        for (ChipTypeOfCargo type : ChipTypeOfCargo.values()) {
            if (type.getTypeNum() == num)
                return type;
        }
        throw new InvalidParameterException("Invalid number: " + num);
    }
}

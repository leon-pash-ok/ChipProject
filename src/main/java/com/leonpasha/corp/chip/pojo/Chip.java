package com.leonpasha.corp.chip.pojo;

public class Chip {
    ChipTypeOfCargo cargo;
    int roominess;

    public Chip(ChipTypeOfCargo cargo, int roominess) {
        this.cargo = cargo;
        this.roominess = roominess;
    }

    public ChipTypeOfCargo getCargo() {
        return cargo;
    }

    public int getRoominess() {
        return roominess;
    }

    @Override
    public String toString() {
        return "Chip{" +
                "cargo=" + cargo +
                ", roominess=" + roominess +
                '}';
    }
}

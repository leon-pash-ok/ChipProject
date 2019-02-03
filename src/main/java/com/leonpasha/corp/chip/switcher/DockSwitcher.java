package com.leonpasha.corp.chip.switcher;

import com.leonpasha.corp.chip.chip_generator.ChipGenerator;
import com.leonpasha.corp.chip.pojo.Chip;
import com.leonpasha.corp.chip.pojo.ChipTypeOfCargo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static com.leonpasha.corp.chip.chip_generator.ChipGenerator.isEnough;

public class DockSwitcher {
    private List<Chip> ships = new ArrayList<>();

    private void init() {
        int count = 5;
        for (int i = 0; i < count; i ++) {
            addChip(ChipGenerator.generateChip());
        }
        for (int i = 0; i < count; i ++) {
            ships.get(i).toString();
        }
    }

    private void addChip(Optional<Chip> chip){
        if (chip.isPresent()) {
            ships.add(chip.get());
        }
    }
    public DockSwitcher(){
        init();
    }

    public synchronized Optional<Chip> getChip(ChipTypeOfCargo cargo) {
        return getChipDependsOfTypeAndAddNewChip(cargo);
    }

    private Optional<Chip> getChipDependsOfTypeAndAddNewChip(ChipTypeOfCargo cargo) {
        try {
            if (!isEnough()) {
                Optional<Chip> chip = getChipDependsOfType(filterChipByTypeCargo(cargo));
                if (chip.isPresent()) {
                    ships.remove(chip.get());
                    addChip(ChipGenerator.generateChip());
                }
                return chip;
            } else {
                System.out.println("0 < There are no ships");
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private Predicate<Chip> filterChipByTypeCargo(ChipTypeOfCargo cargo) {
        return chip -> chip.getCargo() == cargo;
    }

    private Optional<Chip> getChipDependsOfType(Predicate<Chip> predicate) {
        return ships.stream()
                .filter(predicate)
                .findFirst();
    }
}

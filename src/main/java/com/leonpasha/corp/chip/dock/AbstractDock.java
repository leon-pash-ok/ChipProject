package com.leonpasha.corp.chip.dock;

import com.leonpasha.corp.chip.pojo.Chip;
import com.leonpasha.corp.chip.pojo.ChipTypeOfCargo;
import com.leonpasha.corp.chip.switcher.DockSwitcher;

import java.util.Optional;

public abstract class AbstractDock implements Runnable{
    ChipTypeOfCargo cargo;
    DockSwitcher switcher;

    public void unload(Chip chip){
        try {
            int netto = chip.getRoominess()/10;
            for ( int i = 0; i < netto; i++){
                Thread.sleep(100);
                System.out.println("Загружаю " + chip.getCargo());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        while (true) {
            try {
                System.out.println("------- run " + cargo + " Dock");
                Optional<Chip> chip = switcher.getChip(cargo);
                if (chip.isPresent()) {
                    unload(chip.get());
                }
                System.out.println("------- end run " + cargo + " Dock");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

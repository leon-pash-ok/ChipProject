package com.leonpasha.corp.chip.dock;

import com.leonpasha.corp.chip.pojo.ChipTypeOfCargo;
import com.leonpasha.corp.chip.switcher.DockSwitcher;

public class ClothesDock extends AbstractDock {

    public ClothesDock(DockSwitcher switcher) {
        this.switcher = switcher;
        cargo = ChipTypeOfCargo.CLOTHES;
    }

}

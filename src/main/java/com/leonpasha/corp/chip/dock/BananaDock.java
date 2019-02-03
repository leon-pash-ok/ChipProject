package com.leonpasha.corp.chip.dock;

import com.leonpasha.corp.chip.pojo.ChipTypeOfCargo;
import com.leonpasha.corp.chip.switcher.DockSwitcher;

public class BananaDock extends AbstractDock {
    public BananaDock(DockSwitcher switcher) {
        this.switcher = switcher;
        cargo = ChipTypeOfCargo.BANANA;
    }
}

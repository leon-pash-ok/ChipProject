package com.leonpasha.corp.chip.dock;

import com.leonpasha.corp.chip.pojo.ChipTypeOfCargo;
import com.leonpasha.corp.chip.switcher.DockSwitcher;

public class BreadDock extends AbstractDock {

    public BreadDock(DockSwitcher switcher) {
        this.switcher = switcher;
        cargo = ChipTypeOfCargo.BREAD;
    }
}

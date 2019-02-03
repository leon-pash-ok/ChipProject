package com.leonpasha.corp.chip.main;

import com.leonpasha.corp.chip.dock.BananaDock;
import com.leonpasha.corp.chip.dock.BreadDock;
import com.leonpasha.corp.chip.dock.ClothesDock;
import com.leonpasha.corp.chip.switcher.DockSwitcher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Available number of cores: " + Runtime.getRuntime().availableProcessors());
        DockSwitcher switcher = new DockSwitcher();

        ClothesDock clothesDock = new ClothesDock(switcher);
        BananaDock bananaDock = new BananaDock(switcher);
        BreadDock breadDock = new BreadDock(switcher);

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(clothesDock);
        service.execute(bananaDock);
        service.execute(breadDock);

        service.shutdown();
    }

}

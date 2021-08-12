package net.trollheim.security.ctf;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Click {
    public static void main(String[] args) throws InterruptedException, AWTException {
        Robot r = new Robot();
        System.out.println("start");
        Thread.sleep(2000);
        for (int i = 0; i < 100; i++) {
            Thread.sleep(50);
            r.keyPress(KeyEvent.VK_E);
            Thread.sleep(50);
            r.keyRelease(KeyEvent.VK_E);
        }
        System.out.println("stop");
    }
}

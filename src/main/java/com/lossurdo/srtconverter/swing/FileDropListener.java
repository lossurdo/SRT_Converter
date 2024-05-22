package com.lossurdo.srtconverter.swing;

import java.awt.Component;
import java.io.File;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;

class FileDropListener implements FileDrop.Listener {

    private static final Logger LOGGER = Logger.getLogger(FileDropListener.class.getName());
    private final Component component;

    public FileDropListener(Component component) {
        this.component = component;
    }

    @Override
    public void filesDropped(File[] files) {
        try {
            for (File srt : files) {
                LOGGER.info("Reading: " + srt);
                String txt = FileUtils.readFileToString(srt, "UTF-8");
                File iso = new File(srt.getAbsolutePath() + "_ISO-8859-1");
                LOGGER.info("Converting: " + iso);
                FileUtils.write(iso, txt, "ISO-8859-1");
                LOGGER.info("Conversion successfully: " + iso);
            }            
            new Thread() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(component, "SRT Subtitles converted successfully!");
                }
            }.start();
        } catch (Exception e) {
            LOGGER.severe("Problem while converting subtitle: " + e.getMessage());
            throw new RuntimeException("Problem while converting subtitle:\r\n" + e.getMessage());
        }
    }
}

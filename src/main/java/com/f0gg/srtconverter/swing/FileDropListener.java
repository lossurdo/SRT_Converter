package com.f0gg.srtconverter.swing;

import java.awt.Component;
import java.io.File;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

class FileDropListener implements FileDrop.Listener {

    private static final Logger logger = Logger.getLogger(FileDropListener.class);
    private final Component component;

    public FileDropListener(Component component) {
        this.component = component;
    }

    @Override
    public void filesDropped(File[] files) {
        try {
            for (File srt : files) {
                logger.debug("Reading: " + srt);
                String txt = FileUtils.readFileToString(srt, "UTF-8");
                File iso = new File(srt.getAbsolutePath() + "_ISO-8859-1");
                logger.debug("Converting: " + iso);
                FileUtils.write(iso, txt, "ISO-8859-1");
                logger.debug("Conversion successfully: " + iso);
            }            
            new Thread() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(component, "SRT Subtitles converted successfully!");
                }
            }.start();
        } catch (Exception e) {
            logger.error("Problem while converting subtitle", e);
            throw new RuntimeException("Problem while converting subtitle:\r\n" + e.getMessage());
        }
    }
}

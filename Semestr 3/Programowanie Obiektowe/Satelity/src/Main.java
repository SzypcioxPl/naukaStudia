import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import scraper.SatBeamScraper;
import test.TestTranslation;

import javax.swing.*;
import java.awt.*;

public class Main {

    protected static final Logger main = LogManager.getLogger();

    private static SatBeamScraper scraper = new SatBeamScraper();

    private static TestTranslation testTranslation = new TestTranslation();

    public Main() {}

    public static void main(String[] args) throws Exception {
        main.info("Start of APP\n\n");

        // possible status = 'any', 'active', 'retires', 'failed', 'deorbited'
//        testTranslation.checkWhetherSatBeamListIsScrapedProperly(1, 608, "deorbited");

//        testTranslation.checkWhetherSatBeamIsTranslatedToWebsiteSatellites(78);               // status of Sat in test 'any'
//        testTranslation.checkWhetherSatBeamDataIsTranslatedToExistingWebsiteSatellite(56);    // status of Sat in test 'any'
//        testTranslation.checkWhetherSatBeamListIsTranslatedToWebsiteSatellitesList(1, 608);   // status of Sat in test 'any'

        // crating frame
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);


        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Put range: ");
        JTextField tf1 = new JTextField(10); // accepts upto 10 characters
        JTextField tf2 = new JTextField(10); // accepts upto 10 characters
        tf1.setText("Start");
        tf2.setText("End");
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf1);
        panel.add(tf2);
        panel.add(send);
        panel.add(reset);
        // Text Area at the Center
        JTextArea ta = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);

        // adding button
        JButton button = new JButton("Scrape Sat's Boi");
        button.setSize(50,50);
        frame.getContentPane().add(button); // Adds Button to content pane of frame
        frame.setVisible(true);

    }
}
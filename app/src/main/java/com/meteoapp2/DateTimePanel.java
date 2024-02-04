package com.meteoapp2;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimePanel extends JPanel {

    private JLabel dateTimeLabel;

    public DateTimePanel() {
        setLayout(new BorderLayout());
        dateTimeLabel = new JLabel();
        dateTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(dateTimeLabel, BorderLayout.CENTER);

        updateTime();
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();

        setOpaque(false);
    }

    private void updateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        dateTimeLabel.setText(now.format(formatter));
    }
}

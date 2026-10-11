import javax.swing.*;
import java.awt.*;

public class ClickPanel extends JPanel {

    private int count = 0;
    private final JLabel counterLabel = new JLabel("Кликов: 0");

    public ClickPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 40));

        counterLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JButton clickButton = new JButton("Клик");
        JButton resetButton = new JButton("Сброс");

        clickButton.addActionListener(e -> {
            count++;
            if (count >= 10) {
                counterLabel.setText("Хватит кликать!");
            } else {
                counterLabel.setText("Кликов: " + count);
            }
        });

        resetButton.addActionListener(e -> {
            count = 0;
            counterLabel.setText("Кликов: 0");
        });

        add(counterLabel);
        add(clickButton);
        add(resetButton);
    }
}
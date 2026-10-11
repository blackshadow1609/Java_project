import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomPanel extends JPanel {

    private final JTextField fromField = new JTextField();
    private final JTextField toField = new JTextField();
    private final JLabel resultLabel = new JLabel("—");
    private final Random random = new Random();

    public RandomPanel() {
        setLayout(new GridLayout(4, 2, 8, 8));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        add(new JLabel("От:"));
        add(fromField);

        add(new JLabel("До:"));
        add(toField);

        JButton generateButton = new JButton("Сгенерировать");
        generateButton.addActionListener(e -> generate());
        add(new JLabel());
        add(generateButton);

        add(new JLabel("Результат:"));
        resultLabel.setForeground(Color.BLUE);
        resultLabel.setFont(resultLabel.getFont().deriveFont(Font.BOLD));
        add(resultLabel);
    }

    private void generate() {
        try {
            int from = Integer.parseInt(fromField.getText().trim());
            int to = Integer.parseInt(toField.getText().trim());

            if (from > to) {
                resultLabel.setForeground(Color.RED);
                resultLabel.setText("Ошибка: «от» больше «до»");
                return;
            }

            int value = from + random.nextInt(to - from + 1);
            resultLabel.setForeground(Color.BLUE);
            resultLabel.setText(String.valueOf(value));

        } catch (NumberFormatException ex) {
            resultLabel.setForeground(Color.RED);
            resultLabel.setText("Ошибка: введите числа!");
        }
    }
}
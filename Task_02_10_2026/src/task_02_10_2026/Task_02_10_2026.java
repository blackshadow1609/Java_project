import javax.swing.*;

public class Task_02_10_2026 extends JFrame {

    public Task_02_10_2026() {
        setTitle("Домашнее задание 02.10.2026");
        setSize(450, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Генератор чисел", new RandomPanel());
        tabs.addTab("Счётчик кликов", new ClickPanel());

        add(tabs);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task_02_10_2026::new);
    }
}
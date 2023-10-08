import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterGUI {
    private JFrame frame;
    private JTextField amountField;
    private JComboBox<String> currencyComboBox;
    private JButton convertButton;
    private JLabel resultLabel;

    public CurrencyConverterGUI() {
        frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));

        amountField = new JTextField();
        currencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "GBP"});
        convertButton = new JButton("Convert");
        resultLabel = new JLabel();

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Enter the amount to convert: "));
        panel1.add(amountField);

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Select the target currency: "));
        panel2.add(currencyComboBox);

        JPanel panel3 = new JPanel();
        panel3.add(convertButton);

        JPanel panel4 = new JPanel();
        panel4.add(resultLabel);

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    String targetCurrency = (String) currencyComboBox.getSelectedItem();

                    // Tutaj wywołujemy funkcję przeliczającą waluty
                    double convertedAmount = convertCurrency(amount, targetCurrency);

                    resultLabel.setText("Converted amount in " + targetCurrency + ": " + convertedAmount);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid amount.");
                }
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    // Funkcja do przeliczania waluty (możesz dostosować ją do swoich potrzeb)
    private double convertCurrency(double amount, String targetCurrency) {
        // Tutaj możesz umieścić kod do przeliczania waluty
        // Możesz wykorzystać swój istniejący kod lub dostosować go do tej funkcji
        return amount * 1.0; // Na razie to prosta konwersja
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CurrencyConverterGUI();
            }
        });
    }
}

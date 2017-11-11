import javax.swing.*;
import java.awt.*;
import static java.lang.String.valueOf;

/**
 * Created by Andrzej on 2017-09-07.
 */
public class MainFrame {
    public MainFrame() {

        JFrame jFrame = new JFrame("Kalkux");
        StringBuilder calcScreen = new StringBuilder();
        JTextField numberField = new JTextField(valueOf(calcScreen));
        jFrame.setLayout(new GridBagLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 5,2,2));
        MathOps math = new MathOps();
        JButton[] button = new JButton[20];
        String[] buttonText = {"1", "2", "3", " + ", "C",
                               "4", "5", "6", " - ", "del",
                               "7", "8", "9", " * ", " mod ",
                               ".", "0", "=", " / ", "sqrt"};

        for (int i = 0; i < button.length; i++) {
            button[i] = new JButton("");
            panel.add(button[i]);
            button[i].setText(buttonText[i]);
            button[i].addActionListener(e -> {
                try {
                    JButton butt = (JButton) e.getSource();
                    if (!butt.getText().equals("=") && !butt.getText().equals("C")
                            && !butt.getText().equals("sqrt") && !butt.getText().equals("del")) {
                        calcScreen.append(butt.getText());
                        numberField.setText(calcScreen.toString());

                    } else if (butt.getText().equals("=")) {
                        double res = math.calculate(numberField.getText());
                        calcScreen.delete(0, calcScreen.length());
                        calcScreen.append(res);
                        numberField.setText(calcScreen.toString());

                    } else if (butt.getText().equals("C")) {
                        calcScreen.delete(0, calcScreen.length());
                        numberField.setText("");

                    } else if (butt.getText().equals("sqrt")) {
                        double res = math.calculate(numberField.getText());
                        res = Math.sqrt(res);
                        calcScreen.delete(0, calcScreen.length());
                        calcScreen.append(res);
                        numberField.setText(calcScreen.toString());

                    } else if (butt.getText().equals("del")) {
                        if (calcScreen.charAt(calcScreen.length()-1) == ' ') {
                            calcScreen.delete(calcScreen.length() - 3, calcScreen.length() - 1);
                            numberField.setText(calcScreen.toString());

                        } else {
                            calcScreen.deleteCharAt(calcScreen.length() - 1);
                            numberField.setText(calcScreen.toString());
                        }
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
        }

        panel.setSize(375, 300);
        numberField.setSize(375, 75);
        numberField.setEditable(false);
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;
        gc.gridy = 0;
        jFrame.add(numberField, gc);
        gc.insets = new Insets(5,0,5,0);
        gc.gridx = 0;
        gc.gridy = 1;
        jFrame.add(panel, gc);
        jFrame.setSize(375,350);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
    }
}

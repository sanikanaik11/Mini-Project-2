package Basic_Project;
import java.awt.event.*;
import javax.swing.*;
public class Cafe {
        public static void main(String[] args) {
            JFrame frame = new JFrame("Food App");
            frame.setSize(400, 400);
            frame.setLayout(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel heading = new JLabel("🍽 Welcome to our cafe 🍽");
            heading.setBounds(100, 10, 200, 30);
            frame.add(heading);

            JLabel totalLabel = new JLabel("Total: ₹0");
            totalLabel.setBounds(140, 300, 200, 30);
            totalLabel.setVisible(false);
            frame.add(totalLabel);

            JButton menu = new JButton("Show Menu🍽");
            menu.setBounds(120, 50, 150, 30);
            frame.add(menu);

            JButton bill = new JButton("Show Bill");
            bill.setBounds(120, 250, 150, 30);
            bill.setVisible(false);
            frame.add(bill);

            int[] total = {0};
            int[] qty = {0, 0, 0, 0};
            int[] prices = {80, 150, 50, 40};
            String[] items = {"Burger ₹80", "Pizza ₹150", "Fries ₹50", "Drink ₹40"};
            JLabel[] itemLabels = new JLabel[4];
            JLabel[] qtyLabels = new JLabel[4];
            JButton[] plus = new JButton[4];
            JButton[] minus = new JButton[4];

            for (int i = 0; i < 4; i++) {
                int j = 100 + i * 30;
                itemLabels[i] = new JLabel(items[i]);
                itemLabels[i].setBounds(50, j, 100, 25);
                itemLabels[i].setVisible(false);
                frame.add(itemLabels[i]);

                qtyLabels[i] = new JLabel("0");
                qtyLabels[i].setBounds(220, j, 20, 25);
                qtyLabels[i].setVisible(false);
                frame.add(qtyLabels[i]);

                plus[i] = new JButton("+");
                plus[i].setBounds(250, j, 45, 25);
                plus[i].setVisible(false);
                frame.add(plus[i]);

                minus[i] = new JButton("-");
                minus[i].setBounds(300, j, 45, 25);
                minus[i].setVisible(false);
                frame.add(minus[i]);

                final int index = i;
                plus[i].addActionListener(e ->{
                    qty[index]++;
                    total[0] += prices[index];
                    qtyLabels[index].setText("" + qty[index]);
                });

                minus[i].addActionListener(e -> {
                    if (qty[index] > 0) {
                        qty[index]--;
                        total[0] -= prices[index];
                        qtyLabels[index].setText("" + qty[index]);
                    }
                });
            }
            menu.addActionListener(e -> {
                for (int i = 0; i < 4; i++) {
                    itemLabels[i].setVisible(true);
                    qtyLabels[i].setVisible(true);
                    plus[i].setVisible(true);
                    minus[i].setVisible(true);
                }
                bill.setVisible(true);
            });
            bill.addActionListener(e -> {
                totalLabel.setText("Total: ₹" + total[0]);
                totalLabel.setVisible(true);
            });
            frame.setVisible(true);
        }
    }

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Calculator {
    public static void main(String[] args) {
        JFrame frame= new JFrame("Calculator");
        frame.setSize(500,300);
        frame.setLayout(new GridLayout(2,1));

        JPanel outputPanel=new JPanel();
        outputPanel.setBounds(0,10,500,100);

        JPanel textPanel= new JPanel();
        textPanel.setLayout(new GridLayout(3,1,0,10));

        JPanel btnPanel=new JPanel();
        btnPanel.setLayout(new GridBagLayout());
        btnPanel.setBounds(0,110,485,110);

        JLabel firstnumber = new JLabel("Enter First Number:");
        JTextField firstNumber= new JTextField(5);

        JLabel secondnumber = new JLabel("Enter Second Number:");
        JTextField secondNumber= new JTextField(5);
        JLabel resultLabel = new JLabel("Result:");
        JTextField result= new JTextField(5);
        result.setText("0");
        result.setEditable(false);

        JButton addBtn = new JButton("+");
        addBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        JButton subBtn = new JButton("-");
        subBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        JButton multBtn = new JButton("*");
        multBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        JButton divBtn = new JButton("/");
        divBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        JButton clearBtn = new JButton("Clear");
        clearBtn.setFont(new Font("Arial", Font.PLAIN, 16));

        textPanel.add(firstnumber);
        textPanel.add(firstNumber);
        textPanel.add(secondnumber);
        textPanel.add(secondNumber);
        textPanel.add(resultLabel);
        textPanel.add(result);

        outputPanel.add(textPanel);

        GridBagConstraints gbc= new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx=150;
        gbc.ipady=5;
        gbc.gridx=0;
        gbc.gridy=0;
        btnPanel.add(addBtn, gbc);
        gbc.gridx=1;
        gbc.gridy=0;
        btnPanel.add(subBtn, gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        btnPanel.add(multBtn, gbc);
        gbc.gridx=1;
        gbc.gridy=1;
        btnPanel.add(divBtn, gbc);
        gbc.gridwidth=2;
        gbc.gridx=0;
        gbc.gridy=2;
        btnPanel.add(clearBtn, gbc);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                    double num1=Double.parseDouble(firstNumber.getText());
                    double num2=Double.parseDouble(secondNumber.getText());
                    double res=0;
                    String operation = event.getActionCommand();
                    switch (operation) {
                        case "+":
                            res=num1+num2;
                            result.setText(String.valueOf(res));
                            break;
                        case "-":
                            res=num1-num2;
                            result.setText(String.valueOf(res));
                            break;
                        case "*":
                            res=num1*num2;
                            result.setText(String.valueOf(res));
                            break;
                        case "/":
                            res=num1/num2;
                            result.setText(String.valueOf(res));
                            break;
                        case "Clear":
                            firstNumber.setText("");
                            secondNumber.setText(" ");
                            result.setText(" ");
                            break;
                    }
            }
        };

        addBtn.addActionListener(actionListener);
        subBtn.addActionListener(actionListener);
        multBtn.addActionListener(actionListener);
        divBtn.addActionListener(actionListener);
        clearBtn.addActionListener(actionListener);

        frame.add(outputPanel);
        frame.add(btnPanel);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TextEditor extends JFrame {
    private JTextArea textArea;
    private JFileChooser fileChooser;

    public TextEditor() {
        setTitle("Text Editor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a text area
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create a "File" menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        // Create "Open" menu item
        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });
        fileMenu.add(openMenuItem);

        // Create "Save" menu item
        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });
        fileMenu.add(saveMenuItem);

        setVisible(true);
    }

    private void openFile() {
        fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                StringBuilder content = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                reader.close();
                textArea.setText(content.toString());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error opening file", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void saveFile() {
        fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(textArea.getText());
                writer.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving file", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TextEditor();
            }
        });
    }
}

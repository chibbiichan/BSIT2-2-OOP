import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.*;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class FileManagement extends JFrame {

    private JTextArea fileDisplayArea;
    private JButton browseImageButton;
    private JButton viewImageButton;
    private JButton browseSoundButton;
    private JButton playSoundButton;
    private JButton browseVideoButton;
    private JButton playVideoButton;
    private JFXPanel videoPanel;
    private MediaPlayer mediaPlayer;

    public FileManagagement() {
        super("File Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Create components
        browseImageButton = new JButton("Browse Image");
        viewImageButton = new JButton("View Image");
        browseSoundButton = new JButton("Browse Sound");
        playSoundButton = new JButton("Play Sound");
        browseVideoButton = new JButton("Browse Video");
        playVideoButton = new JButton("Play Video");
        fileDisplayArea = new JTextArea();
        fileDisplayArea.setEditable(false);

        // Create JFXPanel for JavaFX components
        videoPanel = new JFXPanel();

        // Add ActionListeners to the buttons
        browseImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFileChooser("Image Files", "png", "jpg", "jpeg", "gif");
            }
        });

        viewImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewImage();
            }
        });

        browseSoundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFileChooser("Sound Files", "wav", "mp3");
            }
        });

        playSoundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playMedia();
            }
        });

        browseVideoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFileChooser("Video Files", "mp4", "avi");
            }
        });

        playVideoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playMedia();
            }
        });

        // Set layout manager
        setLayout(new BorderLayout());

        // Add components to the frame
        JPanel imagePanel = new JPanel();
        imagePanel.add(browseImageButton);
        imagePanel.add(viewImageButton);

        JPanel soundPanel = new JPanel();
        soundPanel.add(browseSoundButton);
        soundPanel.add(playSoundButton);

        JPanel videoPanel = new JPanel();
        videoPanel.add(browseVideoButton);
        videoPanel.add(playVideoButton);

        add(fileDisplayArea, BorderLayout.CENTER);
        add(imagePanel, BorderLayout.NORTH);
        add(soundPanel, BorderLayout.WEST);
        add(videoPanel, BorderLayout.EAST);
        add(this.videoPanel, BorderLayout.SOUTH);
    }

    private void showFileChooser(String description, String... extensions) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileNameExtensionFilter(description, extensions));

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            displayFileDetails(selectedFile);
        }
    }

    private void displayFileDetails(File file) {
        fileDisplayArea.setText("Selected file:\n" + file.getName());
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    private void viewImage() {
        File selectedImageFile = showFileChooserAndGetSelectedFile("Image Files", "png", "jpg", "jpeg", "gif");
        if (selectedImageFile != null) {
            displayImage(selectedImageFile);
        }
    }

    private void displayImage(File imageFile) {
        try {
            BufferedImage image = ImageIO.read(imageFile);
            ImageIcon icon = new ImageIcon(image);
            JOptionPane.showMessageDialog(this, icon, "Image Viewer", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void playMedia() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }

        File selectedMediaFile = null;

        if (playSoundButton.isEnabled()) {
            selectedMediaFile = showFileChooserAndGetSelectedFile("Sound Files", "wav", "mp3");
        } else if (playVideoButton.isEnabled()) {
            selectedMediaFile = showFileChooserAndGetSelectedFile("Video Files", "mp4", "avi");
        }

        if (selectedMediaFile != null) {
            String mediaPath = selectedMediaFile.toURI().toString();
            Media media = new Media(mediaPath);
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        }
    }

    private File showFileChooserAndGetSelectedFile(String description, String... extensions) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileNameExtensionFilter(description, extensions));

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }

        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileManagement().setVisible(true);
            }
        });
    }
}

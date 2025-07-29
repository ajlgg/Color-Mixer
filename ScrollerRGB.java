import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ScrollerRGB {

    public static void main(String[] args) {
        JFrame window = new JFrame("Scroller Screen");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        // create the window screen

        // Create main panel with absolute layout
        SliderPanel panel = new SliderPanel();
        panel.setLayout(null); // Allows us to place sliders/buttons manually
        window.add(panel);

        window.setVisible(true);
    }

    static class SliderPanel extends JPanel {
        // creating the color sliders, setting the color values
        private int red = 255, green = 255, blue = 255;

        private final JSlider redSlider;
        private final JSlider greenSlider;
        private final JSlider blueSlider;
        private final JButton resetButton;

        public SliderPanel() {
            setBackground(Color.WHITE);

            // Red Slider
            redSlider = createColorSlider(0, 255, red);
            redSlider.setBounds(150, 400, 150, 30);
            add(redSlider);

            // Green Slider
            greenSlider = createColorSlider(0, 255, green);
            greenSlider.setBounds(350, 400, 150, 30);
            add(greenSlider);

            // Blue Slider
            blueSlider = createColorSlider(0, 255, blue);
            blueSlider.setBounds(550, 400, 150, 30);
            add(blueSlider);

            // Reset Button
            resetButton = new JButton("Reset");
            resetButton.setBounds(80, 200, 100, 50);
            add(resetButton);

            // Slider Listeners
            // listeners to create the event of changing the color values with the sliders
            ChangeListener sliderListener = new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    red = redSlider.getValue();
                    green = greenSlider.getValue();
                    blue = blueSlider.getValue();
                    repaint(); // Re-draw with new color
                }
            };

            redSlider.addChangeListener(sliderListener);
            greenSlider.addChangeListener(sliderListener);
            blueSlider.addChangeListener(sliderListener);
            // adding listeners for the sliders for when they are used

            // Reset Button Listener
            // resets the color values to 255
            resetButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    redSlider.setValue(255);
                    greenSlider.setValue(255);
                    blueSlider.setValue(255);
                }
            });
        }

        // Create a sliders
        private JSlider createColorSlider(int min, int max, int initial) {
            JSlider slider = new JSlider(JSlider.HORIZONTAL, min, max, initial);
            slider.setFocusable(false);
            return slider;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // colorContainer
            g.setColor(new Color(red, green, blue));
            g.fillRect(200, 200, 400, 100);
            g.setColor(Color.BLACK);
            g.drawRect(200, 200, 400, 100);

            // Draw text inside colorContainer
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 16));
            g.drawString("color(r = " + red + ", g = " + green + ", b = " + blue + ")", 270, 250);

            // Outline boxes to make the sliders more visiable
            g.drawRect(150, 400, 150, 30); // Red
            g.drawRect(350, 400, 150, 30); // Green
            g.drawRect(550, 400, 150, 30); // Blue
        }
    }
}



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * Class Paint
 *
 * <p>Purdue University -- CS18000 -- Spring 2024</p>
 *
 * @author Jiauxn Li
 * @version April 08, 2024
 */
public class Paint extends JComponent implements Runnable {
    JButton clearButton;
    JButton fillButton;
    JButton eraseButton;
    JButton randomButton;
    JTextField hexTextField;
    JButton hexButton;
    JTextField rTextField;
    JTextField gTextField;
    JTextField bTextField;
    JButton rgbButton;
    Image image;
    Graphics2D graphics2D;
    int curX;
    int curY;
    int oldX;
    int oldY;

    Color colorPen = Color.BLACK;
    Color colorCanvas = Color.WHITE;

    Paint paint;


    public Paint() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                oldX = e.getX();
                oldY = e.getY();
            }
        });


        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                curX = e.getX();
                curY = e.getY();
                graphics2D.drawLine(oldX, oldY, curX, curY);

                repaint();
                oldX = curX;
                oldY = curY;
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Paint());

    }

    public void run() {
        JFrame frame = new JFrame("Paint");
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        paint = new Paint();
        content.add(paint, BorderLayout.CENTER);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paint.clear();
                hexTextField.setText("#");
                rTextField.setText("");
                gTextField.setText("");
                bTextField.setText("");
            }
        });
        fillButton = new JButton("Fill");
        fillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paint.fill();
                hexTextField.setText("#");
                rTextField.setText("");
                gTextField.setText("");
                bTextField.setText("");
            }
        });

        eraseButton = new JButton("Erase");
        eraseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paint.erase();
            }
        });

        randomButton = new JButton("Random");
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int r = random.nextInt(256);
                int g = random.nextInt(256);
                int b = random.nextInt(256);
                Color color = new Color(r, g, b);
                hexTextField.setText(String.format("#%02x%02x%02x", r, g, b));
                rTextField.setText(r + "");
                gTextField.setText(g + "");
                bTextField.setText(b + "");
                paint.setColor(color);
            }
        });
        JPanel panel1 = new JPanel();
        panel1.add(clearButton);
        panel1.add(fillButton);
        panel1.add(eraseButton);
        panel1.add(randomButton);
        content.add(panel1, BorderLayout.NORTH);

        hexTextField = new JTextField(10);
        hexTextField.setText("#");
        hexButton = new JButton("Hex");
        hexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Color color = Color.decode(hexTextField.getText());
                    rTextField.setText(color.getRed() + "");
                    gTextField.setText(color.getGreen() + "");
                    bTextField.setText(color.getBlue() + "");
                    paint.setColor(color);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Not a valid Hex Value",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        rTextField = new JTextField(5);
        gTextField = new JTextField(5);
        bTextField = new JTextField(5);
        rgbButton = new JButton("RGB");
        rgbButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String rString = rTextField.getText();
                    String gString = gTextField.getText();
                    String bString = bTextField.getText();
                    int r;
                    int g;
                    int b;
                    if (rString.equals("")) {
                        r = 0;
                    } else {
                        r = Integer.parseInt(rString);
                    }

                    if (gString.equals("")) {
                        g = 0;
                    } else {
                        g = Integer.parseInt(gString);
                    }

                    if (bString.equals("")) {
                        b = 0;
                    } else {
                        b = Integer.parseInt(bString);
                    }

                    Color color = new Color(r, g, b);
                    hexTextField.setText(String.format("#%02x%02x%02x", r, g, b));
                    rTextField.setText(r + "");
                    gTextField.setText(g + "");
                    bTextField.setText(b + "");
                    paint.setColor(color);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Not a valid RGB Value",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JPanel panel2 = new JPanel();
        panel2.add(hexTextField);
        panel2.add(hexButton);
        panel2.add(rTextField);
        panel2.add(gTextField);
        panel2.add(bTextField);
        panel2.add(rgbButton);
        content.add(panel2, BorderLayout.SOUTH);
    }


    public void clear() {
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        colorCanvas = Color.WHITE;
        graphics2D.setPaint(Color.black);
        colorPen = Color.BLACK;
        repaint();
    }

    public void fill() {
        graphics2D.setPaint(colorPen);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        colorCanvas = colorPen;
        graphics2D.setPaint(Color.black);
        colorPen = Color.BLACK;
        repaint();
    }

    public void erase() {
        graphics2D.setPaint(colorCanvas);
        colorPen = colorCanvas;
    }

    public void setColor(Color color) {
        graphics2D.setPaint(color);
        colorPen = color;
    }

    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);

            graphics2D = (Graphics2D) image.getGraphics();

            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            graphics2D.setPaint(Color.white);
            graphics2D.fillRect(0, 0, getSize().width, getSize().height);
            graphics2D.setPaint(Color.black);
            graphics2D.setStroke(new BasicStroke(5));
            repaint();
        }
        g.drawImage(image, 0, 0, null);
    }

    public void draw(int size) {
        graphics2D.setStroke(new BasicStroke(size));
    }

}

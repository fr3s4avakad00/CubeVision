import javax.swing.*;//used for lables, and dropDowns
import java.awt.*;//Font, Color, Image
import java.awt.event.*;//actionListener, & event

class menu extends JFrame implements ActionListener{

    private Component text;
    private JButton Menu;
    private JButton Instructions;
    private JButton Definitions;
    private JButton Exit;

    public menu(){
        setBounds(0, 0, 400, 400);
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(52, 140, 194));
        setLocationRelativeTo(null);

        text = new JLabel("CubeVision");
        text.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        text.setBounds(150, 10, 500, 30);
        add(text);

        Menu = new JButton("Press TO Start");
        Menu.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        Menu.setBounds(100, 240, 200, 60);
        Menu.addActionListener((ActionListener) this);
        add(Menu);

        Instructions = new JButton("Instructions");
        Instructions.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        Instructions.setBounds(100, 100, 200, 50);
        Instructions.addActionListener((ActionListener) this);
        add(Instructions);
        
        Definitions = new JButton("Definitions");
        Definitions.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        Definitions.setBounds(100, 170, 200, 50);
        Definitions.addActionListener((ActionListener) this);
        add(Definitions);

        Exit = new JButton("Exit");
        Exit.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
        Exit.setBounds(150, 310, 100, 30);
        Exit.addActionListener((ActionListener) this);
        add(Exit);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == Menu){
        CubeGame2 game = new CubeGame2();
        this.dispose();
      }

      if (e.getSource() == Instructions){
        JOptionPane.showMessageDialog(null, "1. Start the test by clicking on \"Start Test\" and select the cube that appears different in color from the others.\n" + //
                        "2. Follow the prompts on each screen to identify colors or contrasts by clicking on the correct cube.\n" + //
                        "3. After completing the test, review your color vision results and any recommendations provided.\n" + //
                        "4. If you want to learn about different vision problems, click on \"Definitions\" in the main menu.");
      }

      if (e.getSource() == Definitions){
        JOptionPane.showMessageDialog(null, "1. Green-Red Color Blindness\n" + //
                        "- Deuteranopia: Complete inability to see green tones.\n" + //
                        "- Deuteranomaly: Reduced ability to see green tones.\n" + //
                        "\n" + //
                        "2. Red-Green Color Blindness\n" + //
                        "- Protanopia: Complete inability to see red tones.\n" + //
                        "- Protanomaly: Reduced ability to see red tones.\n" + //
                        "\n" + //
                        "3. Blue-Yellow Color Blindness\n" + //
                        "- Tritanopia: Complete inability to see blue tones.\n" + //
                        "- Tritanomaly: Reduced ability to see blue tones.\n" + //
                        "\n" + //
                        "4. Monochromacy\n" + //
                        "- Monochromacy: Inability to see any color, seeing only shades of gray.");
      }

      if (e.getSource() == Exit){
        System.exit(0);
      }

    }   
}
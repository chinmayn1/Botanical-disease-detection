package www.ascox.in;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MainClass extends JPanel {

  public MainClass() {
    JRadioButton radMarriedYes = new JRadioButton("Yes?", true);
    JRadioButton radMarriedNo = new JRadioButton("No?", false);
    JRadioButton radGolfYes = new JRadioButton("Yes?", false);
    JRadioButton radGolfNo = new JRadioButton("No?", true);

    ButtonGroup radioGroup1 = new ButtonGroup();
    ButtonGroup radioGroup2 = new ButtonGroup();

    setLayout(null);

    add(radMarriedYes);
    add(radMarriedNo);
    add(radGolfYes);
    add(radGolfNo);

    radioGroup1.add(radMarriedYes);
    radioGroup1.add(radMarriedNo);
    radioGroup2.add(radGolfYes);
    radioGroup2.add(radGolfNo);

    radMarriedYes.setBounds(30, 50, 50, 20);
    radMarriedNo.setBounds(30, 80, 50, 20);

    radGolfYes.setBounds(150, 50, 50, 20);
    radGolfNo.setBounds(150, 80, 50, 20);

  }

 /* public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.getContentPane().add(new MainClass());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 200);
    frame.setVisible(true);
  }*/
}
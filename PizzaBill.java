import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;

public class PizzaBill{
  private JTextArea billingArea;
  private JLabel logo2;
  private String bill;
  private int invoiceNo;

  public PizzaBill(String bill) {
    //generating invoice number
    Random invoice = new Random();
    invoiceNo = invoice.nextInt(1000);

    JFrame frame2 = new JFrame ("Your Bill - Have a nice day :)");
    frame2.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame2.setVisible (true);

    //construct components
    this.bill = bill;

    //Bill
    billingArea = new JTextArea ();
    billingArea.setLineWrap(true);
    billingArea.setWrapStyleWord(true);
    billingArea.setEditable(false);

    //logo
    logo2 = new JLabel ();
    logo2.setIcon(new ImageIcon("C:\\Users\\Aman Agrawal\\Desktop\\college material\\sem3\\JavaFiles\\practical_9_10\\OIP.jpg"));

    //adjust size and set layout
    frame2.setSize(440, 425);
    frame2.setLayout (null);
    frame2.setResizable(false);

    //add components
    frame2.add (billingArea);
    frame2.add (logo2);

    //set component bounds
    billingArea.setBounds (5, 150, 415, 235);
    logo2.setBounds (51, 10, 365, 150);
    billingArea.setText("\t### PIZZA HUT ###" + "\n\nBill No: " + invoiceNo + this.bill);

    JFrame f = new JFrame();
    JOptionPane.showMessageDialog(f, "Here is your Bill, Have a nice day", "PIZZA HUT", JOptionPane.INFORMATION_MESSAGE);
  }
}

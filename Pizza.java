import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
//extends JPanel
public class Pizza implements ActionListener  {
  private JLabel logo;
  private JLabel lab1;
  private JLabel lab2;
  private JTextField address;
  private JTextField customerName;
  private JLabel labPizza8;
  private JLabel labPizza1;
  private JLabel labPizza2;
  private JLabel labPizza3;
  private JLabel labPizza4;
  private JRadioButton regularMoz;
  private JRadioButton largeMoz;
  private JRadioButton regularCorn;
  private JRadioButton largeCorn;
  private JRadioButton regularPan;
  private JRadioButton largePan;
  private JRadioButton regularCap;
  private JRadioButton largeCap;
  private JLabel labPizza6;
  private JLabel labPizza5;
  private JTextField qPan;
  private JTextField qCap;
  private JTextField qCorn;
  private JTextField qMoz;
  private JLabel labPizza7;
  private JComboBox itMoz;
  private JComboBox itCorn;
  private JComboBox itPan;
  private JComboBox itCap;
  private JButton generate;
  private JButton clear;
  private ButtonGroup mozRad;
  private ButtonGroup panRad;
  private ButtonGroup capRad;
  private ButtonGroup cornRad;

    private boolean larCap = false, larMoz = false, larPan = false, larCorn = false, regPan = false, regCorn = false, regCap = false, regMoz = false;
    private String customer_name, customer_address, topMoz, topCap, topCorn, topPan, orderMoz = "", orderPan = "", orderCap = "", orderCorn = "";
    protected String bill;
    private int quantMoz, quantCap, quantPan, quantCorn;
    private double total = 0, totalMoz = 0, totalPan = 0, totalCorn = 0, totalCap = 0;
    private char flag = 'a';

    public Pizza() {
        //Making the Frame
        JFrame frame = new JFrame ("Pizza Ordering System");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setVisible (true);
        frame.setResizable(false);

        //construct preComponents
        String itMozItems[] = {"None", "Mushrooms", "Jalapeno", "Olives"};
        String itCornItems[] = {"None", "Mushrooms", "Spinach", "Paneer"};
        String itPanItems[] = {"None", "Mushrooms", "Jalapeno", "Onions"};
        String itCapItems[] = {"None", "Mushrooms", "Corn", "Onion"};

        //construct components
        logo = new JLabel();
        logo.setIcon(new ImageIcon("C:\\Users\\Aman Agrawal\\Desktop\\college material\\sem3\\JavaFiles\\practical_9_10\\images.jpg"));
        lab1 = new JLabel ("Customer Name :");
        lab2 = new JLabel ("Address :");
        address = new JTextField ();
        customerName = new JTextField ();
        labPizza8 = new JLabel ("           MENU");
        labPizza1 = new JLabel ("Mozzarella Pizza");
        labPizza2 = new JLabel ("Corn Pizza");
        labPizza3 = new JLabel ("Paneer Pizza");
        labPizza4 = new JLabel ("Capsicum Pizza");
        regularMoz = new JRadioButton ("Regular Rs.100");
        largeMoz = new JRadioButton ("Large Rs.200");
        regularCorn = new JRadioButton ("Regular Rs.100");
        largeCorn = new JRadioButton ("Large Rs.200");
        regularPan = new JRadioButton ("Regular Rs.120");
        largePan = new JRadioButton ("Large Rs.240");
        regularCap = new JRadioButton ("Regular Rs.150");
        largeCap = new JRadioButton ("Large Rs.260");
        labPizza6 = new JLabel ("Enter Quantity:");
        labPizza5 = new JLabel ("Choose Crust Size");
        qPan = new JTextField ("0");
        qCap = new JTextField ("0");
        qCorn = new JTextField ("0");
        qMoz = new JTextField ("0");
        labPizza7 = new JLabel ("Select Extra Toppings:");
        itMoz = new JComboBox (itMozItems);
        itCorn = new JComboBox (itCornItems);
        itPan = new JComboBox (itPanItems);
        itCap = new JComboBox (itCapItems);
        generate = new JButton ("Generate Bill");
        clear = new JButton ("Clear");

        //adjust size and set layout
        frame.setSize(667, 585);
        frame.setLayout (null);

        //adding button groups
        mozRad = new ButtonGroup();
        panRad = new ButtonGroup();
        capRad = new ButtonGroup();
        cornRad = new ButtonGroup();
        mozRad.add(regularMoz);
        mozRad.add(largeMoz);
        panRad.add(regularPan);
        panRad.add(largePan);
        capRad.add(regularCap);
        capRad.add(largeCap);
        cornRad.add(regularCorn);
        cornRad.add(largeCorn);

        //add components
        frame.add (logo);
        frame.add (lab1);
        frame.add (lab2);
        frame.add (address);
        frame.add (customerName);
        frame.add (labPizza8);
        frame.add (labPizza1);
        frame.add (labPizza2);
        frame.add (labPizza3);
        frame.add (labPizza4);
        frame.add (regularMoz);
        frame.add (largeMoz);
        frame.add (regularCorn);
        frame.add (largeCorn);
        frame.add (regularPan);
        frame.add (largePan);
        frame.add (regularCap);
        frame.add (largeCap);
        frame.add (labPizza6);
        frame.add (labPizza5);
        frame.add (qPan);
        frame.add (qCap);
        frame.add (qCorn);
        frame.add (qMoz);
        frame.add (labPizza7);
        frame.add (itMoz);
        frame.add (itCorn);
        frame.add (itPan);
        frame.add (itCap);
        frame.add (generate);
        frame.add (clear);

        //set component bounds
        logo.setBounds (145, 30, 395, 130);
        lab1.setBounds (35, 195, 105, 30);
        lab2.setBounds (35, 240, 65, 25);
        address.setBounds (105, 240, 270, 25);
        customerName.setBounds (150, 200, 225, 25);
        labPizza8.setBounds (295, 280, 100, 25);
        labPizza1.setBounds (35, 345, 100, 25);
        labPizza2.setBounds (35, 380, 100, 25);
        labPizza3.setBounds (35, 415, 115, 25);
        labPizza4.setBounds (35, 450, 100, 25);
        regularMoz.setBounds (145, 345, 115, 25);
        largeMoz.setBounds (260, 345, 100, 25);
        regularCorn.setBounds (145, 380, 115, 25);
        largeCorn.setBounds (260, 380, 100, 25);
        regularPan.setBounds (145, 415, 115, 25);
        largePan.setBounds (260, 415, 100, 25);
        regularCap.setBounds (145, 450, 115, 25);
        largeCap.setBounds (260, 450, 100, 25);
        labPizza6.setBounds (365, 315, 100, 25);
        labPizza5.setBounds (155, 315, 110, 25);
        qPan.setBounds (365, 415, 100, 25);
        qCap.setBounds (365, 450, 100, 25);
        qCorn.setBounds (365, 380, 100, 25);
        qMoz.setBounds (365, 345, 100, 25);
        labPizza7.setBounds (495, 315, 128, 25);
        itMoz.setBounds (500, 345, 100, 25);
        itCorn.setBounds (500, 380, 100, 25);
        itPan.setBounds (500, 415, 100, 25);
        itCap.setBounds (500, 450, 100, 25);
        generate.setBounds (90, 495, 115, 25);
        clear.setBounds (215, 495, 100, 25);

        //adding action listener
        generate.addActionListener(this);
        clear.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
      //RadioButtons

      if(regularCap.isSelected())
      {
        regCap = true;
        flag = 'b';
      }
      if(largeCap.isSelected())
      {
        larCap = true;
        flag = 'b';
      }
      if(regularMoz.isSelected())
      {
        regMoz = true;
        flag = 'b';
      }
      if(largeMoz.isSelected())
      {
        larMoz = true;
        flag = 'b';
      }
      if(regularPan.isSelected())
      {
        regPan = true;
        flag = 'b';
      }
      if(largePan.isSelected())
      {
        larPan = true;
        flag = 'b';
      }
      if(regularCorn.isSelected())
      {
        regCorn = true;
        flag = 'b';
      }
      if(largeCorn.isSelected())
      {
        larCorn = true;
        flag = 'b';
      }
      if(flag != 'b'){
        JFrame f = new JFrame();
        JOptionPane.showMessageDialog(f, "Please select a Pizza!", "PIZZA HUT", JOptionPane.ERROR_MESSAGE);
        return;
      }

      if (e.getSource() == generate){
        //customerName Address
        customer_name = customerName.getText();
        if (customer_name.equals("")){
          JFrame f = new JFrame();
          JOptionPane.showMessageDialog(f, "Please enter Customer Name!", "PIZZA HUT", JOptionPane.ERROR_MESSAGE);
          return;
        }
        customer_address = address.getText();
        if (customer_address.equals("")){
          JFrame f = new JFrame();
          JOptionPane.showMessageDialog(f, "Please enter Customer Address!", "PIZZA HUT", JOptionPane.ERROR_MESSAGE);
          return;
        }

        //Quantity
        if (regMoz || larMoz){
          if (isNumeric(qMoz.getText())){
            quantMoz = Integer.parseInt(qMoz.getText());
            topMoz = (String) itMoz.getItemAt(itMoz.getSelectedIndex());
          }else{
            quantityErrorBox();
          }
        }
        if (regCap || larCap){
          if (isNumeric(qCap.getText())){
            quantCap = Integer.parseInt(qCap.getText());
            topCap = (String) itCap.getItemAt(itCap.getSelectedIndex());
          }else{
            quantityErrorBox();
          }
        }
        if (regPan || larPan){
          if (isNumeric(qPan.getText())){
            quantPan = Integer.parseInt(qPan.getText());
            topPan = (String) itPan.getItemAt(itPan.getSelectedIndex());
          }else{
            quantityErrorBox();
          }
        }
        if (regCorn || larCorn){
          if (isNumeric(qCorn.getText())){
            quantCorn = Integer.parseInt(qCorn.getText());
            topCorn = (String) itCorn.getItemAt(itCorn.getSelectedIndex());
          }else{
            quantityErrorBox();
          }
        }

        //Billing
        if (regMoz){
          totalMoz += 100;
          totalMoz *= quantMoz;
          if (topMoz.equals("None")){
            orderMoz = "Regular Mozzarella Pizza Rs.100 x " + quantMoz + "  -- total = Rs." + totalMoz + "\n";
          }
          else{
            orderMoz = "Regular Mozzarella Pizza with " + topMoz + " Rs.100 x " + quantMoz + "  -- total = Rs." + totalMoz + "\n";
          }
        }
        if (larMoz){
          totalMoz += 200;
          totalMoz *= quantMoz;
          if (topMoz.equals("None")){
            orderMoz = "Large Mozzarella Pizza Rs.200 x " + quantMoz + "  -- total = Rs." + totalMoz + "\n";
          }
          else{
            orderMoz = "Large Mozzarella Pizza with " + topMoz + " Rs.200 x " + quantMoz + "  -- total = Rs." + totalMoz + "\n";
          }
        }
        if (regCap){
          totalCap += 150;
          totalCap *= quantCap;
          if (topCap.equals("None")){
            orderCap = "Regular Capsicum Pizza Rs.150 x " + quantCap + "  -- total = Rs." + totalCap + "\n";
          }
          else{
            orderCap = "Regular Capsicum Pizza with " + topCap + " Rs.150 x " + quantCap + "  -- total = Rs." + totalCap + "\n";
          }
        }
        if (larCap){
          totalCap += 260;
          totalCap *= quantCap;
          if (topCap.equals("None")){
            orderCap = "Large Capsicum Pizza Rs.260 x " + quantCap + "  -- total = Rs." + totalCap + "\n";
          }
          else{
            orderCap = "Large Capsicum Pizza with " + topCap + " Rs.260 x " + quantCap + "  -- total = Rs." + totalCap + "\n";
          }
        }
        if (regCorn){
          totalCorn += 100;
          totalCorn *= quantCorn;
          if (topCorn.equals("None")){
            orderCorn = "Regular Corn Pizza Rs.100 x " + quantCorn + "  -- total = Rs." + totalCorn + "\n";
          }
          else{
            orderCorn = "Regular Corn Pizza with " + topCorn + " Rs.100 x " + quantCorn + "  -- total = Rs." + totalCorn + "\n";
          }
        }
        if (larCorn){
          totalCorn += 200;
          totalCorn *= quantCorn;
          if (topCorn.equals("None")){
            orderCorn = "Large Corn Pizza Rs.200 x " + quantCorn + "  -- total = Rs." + totalCorn + "\n";
          }
          else{
            orderCorn = "Large Corn Pizza with " + topCorn + " Rs.200 x " + quantCorn + "  -- total = Rs." + totalCorn + "\n";
          }
        }
        if (regPan){
          totalPan += 120;
          totalPan *= quantPan;
          if (topPan.equals("None")){
            orderPan = "Regular Paneer Pizza Rs.120 x " + quantPan + "  -- total = Rs." + totalPan + "\n";
          }
          else{
            orderPan = "Regular Paneer Pizza with " + topPan + " Rs.120 x " + quantPan + "  -- total = Rs." + totalPan + "\n";
          }
        }
        if (larPan){
          totalPan += 240;
          totalPan *= quantPan;
          if (topPan.equals("None")){
            orderPan = "Large Paneer Pizza Rs.240 x " + quantPan + "  -- total = Rs." + totalPan + "\n";
          }
          else{
            orderPan = "Large Paneer Pizza with " + topPan + " Rs.240 x " + quantPan + "  -- total = Rs." + totalPan + "\n";
          }
        }
        total = totalCap + totalMoz + totalPan + totalCorn;

        //creating text for billing
        String bill = "\n\nCustomer Name: " + customer_name  + "\nCustomer Address: " + customer_address + "\n\nYour Order:\n" + orderCap + orderMoz + orderPan + orderCorn + "\nTotal Amount to be paid: Rs." + total;

        //connecting Billing and passing data to window
        PizzaBill newBill = new PizzaBill(bill);
      }

      if (e.getSource() == clear){
        cleanup();
      }
    }

    public void cleanup(){
      mozRad.clearSelection();
      panRad.clearSelection();
      cornRad.clearSelection();
      capRad.clearSelection();
      qMoz.setText("0");
      qCap.setText("0");
      qCorn.setText("0");
      qPan.setText("0");
      customerName.setText("");
      address.setText("");
      itMoz.setSelectedItem("None");
      itCap.setSelectedItem("None");
      itCorn.setSelectedItem("None");
      itPan.setSelectedItem("None");
      quantCap = 0;
      quantMoz = 0;
      quantPan = 0;
      quantCorn = 0;
      regCap = false;
      regMoz = false;
      regPan = false;
      regCorn = false;
      larCap = false;
      larMoz = false;
      larPan = false;
      larCorn = false;
      topPan = "";
      topCap = "";
      topMoz = "";
      topCorn = "";
      total = 0;
      totalCap = 0;
      totalMoz = 0;
      totalPan = 0;
      totalCorn = 0;
      flag = 'a';
      JFrame f = new JFrame();
      JOptionPane.showMessageDialog(f, "Screen cleared!", "PIZZA HUT", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean isNumeric(String input){
      int i;
      if (input.charAt(0) == '0'){
        return false;
      }
      for (i = 0; i < input.length(); i++)
      {
        if (!Character.isDigit(input.charAt(i)))
        {
          return false;
        }
      }
      return true;
    }

    public void quantityErrorBox(){
      JFrame f = new JFrame();
      JOptionPane.showMessageDialog(f, "Please enter a number in quantity!", "PIZZA HUT", JOptionPane.ERROR_MESSAGE);
      return;
    }

    public static void main (String[] args) {
      new Pizza();
    }
}

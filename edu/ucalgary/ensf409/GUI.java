package edu.ucalgary.ensf409;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class GUI{
    private static int hamperCount;
    private static ArrayList<HamperGUI> hampersGUIArray = new ArrayList<>();
    private static Order order;
    static boolean validOrder = false;
    static JFrame mainFrame = new JFrame("Testing");
    static JPanel mainPanel = new JPanel();
    static JLabel hamperLabel = new JLabel("Number of Hampers: 0");

    public static void main(String[] args) {

        // Beginning of code for mainFrame
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.getContentPane().setLayout(new FlowLayout());
        
        // Panel containing everything
        mainPanel.setLayout(new GridLayout(0,1));

        // New hamper button and label
        JPanel hamperCountPanel = new JPanel();
        JButton hamperButton = new JButton("New Hamper");
        hamperCountPanel.add(hamperButton);
        hamperCountPanel.add(hamperLabel);
        mainFrame.add(hamperCountPanel);

        JScrollPane scrPane = new JScrollPane(mainPanel);
        scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        scrPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
        scrPane.setPreferredSize(new Dimension(500,600));
        mainFrame.getContentPane().add(scrPane);

        // Listener event for Button press, create a new hamper panel
        // Within the hamper panel, add sub-panels for each client type.
        hamperButton.addActionListener(hamperActionEvent -> {
            hamperCount++;
            hamperLabel.setText("Number of Hampers: " + hamperCount);
            HamperGUI newHamper = new HamperGUI(hamperCount);
            mainPanel.add(newHamper.getPanel());
            hampersGUIArray.add(newHamper);
        });

        JPanel submitOrderPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton submitOrderButton = new JButton("Submit Order");
        submitOrderPanel.add(submitOrderButton);
        JLabel successLabel = new JLabel();
        submitOrderPanel.add(successLabel);

        submitOrderButton.addActionListener(submitOrderActionEvent -> {
            if (validOrder){
                validOrder = false;
            }
            else {
                validOrder = true;
            }
            // ArrayList<Hamper> tempHamperArray = new ArrayList<Hamper>();
            // for (HamperGUI currHamper : hampersGUIArray){
            //     tempHamperArray.add(new Hamper(currHamper.getMaleAdultsCount(), currHamper.getFemaleAdultsCount(), currHamper.getChildUnder8Count(), currHamper.getChildOver8Count(), 1));
            // }
            // order = new Order(tempHamperArray);
            // validOrder = order.validateOrder();
            
            if (validOrder){
                successLabel.setText("Success! Order is valid");
            }
            else {
                successLabel.setText("Error! Order is invalid");
            }
        });

        mainFrame.add(submitOrderPanel);
     
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainFrame.setSize(500,750);
        mainFrame.setVisible(true);
    }
    public static ArrayList<HamperGUI> getHamperGUI(){
        return hampersGUIArray;
    }

    public static JPanel getMainPanel(){
        return mainPanel;
    }

    public static void removeHamperGUI(HamperGUI hamper){
        hampersGUIArray.remove(hamper);
    }

    public static void decrementCount(){
        hamperCount--;
    }

    public static void updateCountText(){
        hamperLabel.setText("Number of hampers: " + hamperCount);
    }
}

class HamperGUI extends Frame{
    private int maleAdultsCount;
    private int femaleAdultsCount;
    private int childUnder8Count;
    private int childOver8Count;
    private int quantity = 1;
    private JPanel newHamperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    public HamperGUI (int hamperCount) {
        // New Hamper Panel
        newHamperPanel.setLayout(new GridLayout(7,1));
        JLabel hamperNumber = new JLabel("Hamper #" + hamperCount);
        newHamperPanel.add(hamperNumber);

        // Male adults sub-panel
        JPanel maleAdultsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel maleAdultsLabel = new JLabel("Number of Male Adults: ");
        JLabel maleAdultsCountLabel = new JLabel("" + maleAdultsCount);
        JButton maleAdultsDecrement = new JButton("-");
        JButton maleAdultsIncrement = new JButton("+");
        maleAdultsPanel.add(maleAdultsLabel);
        maleAdultsPanel.add(maleAdultsDecrement);
        maleAdultsPanel.add(maleAdultsCountLabel);
        maleAdultsPanel.add(maleAdultsIncrement);

        maleAdultsIncrement.addActionListener(maleAdultsActionEvent -> {
            maleAdultsCount++;
            maleAdultsCountLabel.setText("" + maleAdultsCount);
        });

        maleAdultsDecrement.addActionListener(maleAdultsActionEvent -> {
            if (maleAdultsCount > 0){
                maleAdultsCount--;
            }
            maleAdultsCountLabel.setText("" + maleAdultsCount);
        });

        // Female adults sub-panel
        JPanel femaleAdultsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel femaleAdultsLabel = new JLabel("Number of Female Adults: ");
        JLabel femaleAdultsCountLabel = new JLabel("" + femaleAdultsCount);
        JButton femaleAdultsDecrement = new JButton("-");
        JButton femaleAdultsIncrement = new JButton("+");
        femaleAdultsPanel.add(femaleAdultsLabel);
        femaleAdultsPanel.add(femaleAdultsDecrement);
        femaleAdultsPanel.add(femaleAdultsCountLabel);
        femaleAdultsPanel.add(femaleAdultsIncrement);

        femaleAdultsIncrement.addActionListener(femaleAdultsActionEvent -> {
            femaleAdultsCount++;
            femaleAdultsCountLabel.setText("" + femaleAdultsCount);
        });

        femaleAdultsDecrement.addActionListener(femaleAdultsActionEvent -> {
            if (femaleAdultsCount > 0){
                femaleAdultsCount--;
            }
            femaleAdultsCountLabel.setText("" + femaleAdultsCount);
        });

        // Child under 8 sub-panel
        JPanel childUnder8Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel childUnder8Label = new JLabel("Number of Childen under 8: ");
        JLabel childUnder8CountLabel = new JLabel("" + childUnder8Count);
        JButton childUnder8Decrement = new JButton("-");
        JButton childUnder8Increment = new JButton("+");
        childUnder8Panel.add(childUnder8Label);
        childUnder8Panel.add(childUnder8Decrement);
        childUnder8Panel.add(childUnder8CountLabel);
        childUnder8Panel.add(childUnder8Increment);

        childUnder8Increment.addActionListener(childUnder8ActionEvent -> {
            childUnder8Count++;
            childUnder8CountLabel.setText("" + childUnder8Count);
        });

        childUnder8Decrement.addActionListener(childUnder8ActionEvent -> {
            if (childUnder8Count > 0){
                childUnder8Count--;
            }
            childUnder8CountLabel.setText("" + childUnder8Count);
        });

        // Child over 8 sub-panel
        JPanel childOver8Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel childOver8Label = new JLabel("Number of Children over 8: ");
        JLabel childOver8CountLabel = new JLabel("" + childOver8Count);
        JButton childOver8Decrement = new JButton("-");
        JButton childOver8Increment = new JButton("+");
        childOver8Panel.add(childOver8Label);
        childOver8Panel.add(childOver8Decrement);
        childOver8Panel.add(childOver8CountLabel);
        childOver8Panel.add(childOver8Increment);

        childOver8Increment.addActionListener(childOver8ActionEvent -> {
            childOver8Count++;
            childOver8CountLabel.setText("" + childOver8Count);
        });

        childOver8Decrement.addActionListener(childOver8ActionEvent -> {
            if (childOver8Count > 0){
                childOver8Count--;
            }
            childOver8CountLabel.setText("" + childOver8Count);
        });

        //Quantity sub-panel
        JPanel quantityPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel quantityLabel = new JLabel("Quantity: ");
        JLabel quantityCountLabel = new JLabel("" + quantity);
        JButton quantityDecrement = new JButton("-");
        JButton quantityIncrement = new JButton("+");
        quantityPanel.add(quantityLabel);
        quantityPanel.add(quantityDecrement);
        quantityPanel.add(quantityCountLabel);
        quantityPanel.add(quantityIncrement);

        quantityIncrement.addActionListener(quantityActionEvent -> {
            quantity++;
            quantityCountLabel.setText("" + quantity);
        });

        quantityDecrement.addActionListener(quantityActionEvent -> {
            if (quantity > 1){  
                quantity--;
            }
            quantityCountLabel.setText("" + quantity);
        });

        JButton deleteHamperButton = new JButton("Delete Hamper");
        deleteHamperButton.addActionListener(deleteHamperActionEvent -> {
            GUI.getMainPanel().remove(this.newHamperPanel);
            GUI.decrementCount();
            GUI.updateCountText();
            GUI.removeHamperGUI(this);
            GUI.getMainPanel().revalidate();
            GUI.getMainPanel().repaint();
        });

        newHamperPanel.add(maleAdultsPanel);
        newHamperPanel.add(femaleAdultsPanel);
        newHamperPanel.add(childUnder8Panel);
        newHamperPanel.add(childOver8Panel);
        newHamperPanel.add(quantityPanel);
        newHamperPanel.add(deleteHamperButton);
        newHamperPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public JPanel getPanel(){
        return this.newHamperPanel;
    }

    public int getMaleAdultsCount(){
        return this.maleAdultsCount;
    }

    public int getFemaleAdultsCount(){
        return this.femaleAdultsCount;
    }

    public int getChildUnder8Count(){
        return this.childUnder8Count;
    }

    public int getChildOver8Count(){
        return this.childOver8Count;
    }
}
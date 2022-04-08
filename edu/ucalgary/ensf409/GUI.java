package edu.ucalgary.ensf409;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class GUI{
    private static int hamperCount;
    private static ArrayList<HamperGUI> hampers = new ArrayList<>();
    
    public static void main(String[] args) {

        // Beginning of code for mainFrame
        JFrame mainFrame = new JFrame("Testing");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.getContentPane().setLayout(new FlowLayout());
        
        // Panel containing everything
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0,1));
        JScrollPane scrPane = new JScrollPane(mainPanel);
        scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        scrPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
        scrPane.setPreferredSize(new Dimension(500,500));
        mainFrame.getContentPane().add(scrPane);

        // Beginning of code for the Hamper Panel
        JPanel hamperCountPanel = new JPanel();
        JButton hamperButton = new JButton("New Hamper");
        JLabel hamperLabel = new JLabel("Number of Hampers: " + hamperCount);
        hamperCountPanel.add(hamperButton);
        hamperCountPanel.add(hamperLabel);
        mainFrame.add(hamperCountPanel);
        /* mainFrame.getContentPane().add(mainPanel); */

        // Listener event for Button press, create a new hamper panel
        // Within the hamper panel, add sub-panels for each client type.
        hamperButton.addActionListener(hamperActionEvent -> {
            hamperCount++;
            hamperLabel.setText("Number of Hampers: " + hamperCount);
            HamperGUI newHamper = new HamperGUI();
            mainPanel.add(newHamper.getPanel());
            hampers.add(newHamper);
        });

        // Submit order button -> iterate through gui hampers, create Hamper for each gui hamper and add to arraylist of actual hampers
        // then create Order and pass in arraylist. Then call call validateOrder on new Order object

            
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainFrame.setSize(500,750);
        mainFrame.setVisible(true);


    }
}

class HamperGUI extends Frame{
    private int maleAdultsCount;
    private int femaleAdultsCount;
    private int childUnder8Count;
    private int childOver8Count;
    private JPanel newHamperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    public HamperGUI () {
        // New Hamper Panel 
        newHamperPanel.setLayout(new GridLayout(4,1));

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

        newHamperPanel.add(maleAdultsPanel);
        newHamperPanel.add(femaleAdultsPanel);
        newHamperPanel.add(childUnder8Panel);
        newHamperPanel.add(childOver8Panel);
        newHamperPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public JPanel getPanel(){
        return this.newHamperPanel;
    }
}
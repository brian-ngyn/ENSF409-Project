package edu.ucalgary.ensf409;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI{
    private static int hamperCount;
    private static ArrayList<HamperGUI> hampersGUIArray = new ArrayList<>();
    private static Order order;
    static int validOrder = 0;
    static JFrame mainFrame = new JFrame("Food Bank Hamper Creator");
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
        scrPane.setPreferredSize(new Dimension(475,600));
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
            ArrayList<Hamper> tempHamperArray = new ArrayList<Hamper>();
            if (hampersGUIArray.isEmpty()){
                validOrder = 0;
                successLabel.setText("Error! Order is invalid, you did not add a hamper");
            }
            else {
                for (HamperGUI currHamper : hampersGUIArray){
                    if (currHamper.getMaleAdultsCount() == 0 && currHamper.getFemaleAdultsCount() == 0 && currHamper.getChildOver8Count() == 0 && currHamper.getChildUnder8Count() == 0){
                        validOrder = 0;
                        successLabel.setText("Error! Order is invalid, one of the hampers has no clients");
                        return;
                    }
                    else {
                        tempHamperArray.add(new Hamper(currHamper.getMaleAdultsCount(), currHamper.getFemaleAdultsCount(), currHamper.getChildOver8Count(), currHamper.getChildUnder8Count(), currHamper.getQuantity()));
                    }
                }
                if (tempHamperArray.isEmpty()){
                    validOrder = 0;
                    successLabel.setText("Error! Order is invalid, one of the hampers has no clients");
                }
                else {
                    order = new Order(tempHamperArray);
                    validOrder = order.validateOrder();

                    if (validOrder == 1){
                        successLabel.setText("Success! Order is valid");
                        JOptionPane.showMessageDialog(null, order.getHamperForm());
                        for (HamperGUI currHamperGUI : hampersGUIArray){
                            mainPanel.remove(currHamperGUI.getPanel());
                        }
                        hamperCount = 0;
                        updateCountText();
                        hampersGUIArray.clear();
                        mainPanel.revalidate();
                        mainPanel.repaint();
                    }
                    else if (validOrder == -1){
                        successLabel.setText("Error! Not enough whole grains to fullfill the order");
                    }
                    else if (validOrder == -2){
                        successLabel.setText("Error! Not enough fruits/veggies to fullfill the order");
                    }
                    else if (validOrder == -3){
                        successLabel.setText("Error! Not enough protein to fullfill the order");
                    }
                    else if (validOrder == -4){
                        successLabel.setText("Error! Not enough other nutrition to fullfill the order");
                    }
                }
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
        for (int i = 0; i < hampersGUIArray.size(); i++){
            hampersGUIArray.get(i).getHamperNumber().setText("Hamper # " + (i + 1));
        }
    }

    public static void decrementCount(){
        hamperCount--;
    }

    public static void updateCountText(){
        hamperLabel.setText("Number of hampers: " + hamperCount);
    }
}
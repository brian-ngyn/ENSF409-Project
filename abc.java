import javax.swing.*;
import java.awt.*;

class abc{
    private static int hamperCount;
    private static int maleAdultsCount;
    private static int femaleAdultsCount;
    private static int childUnder8Count;
    private static int childOver8Count;
    public static void main(String[] args) {

        // Beginning of code for mainFrame
        JFrame mainFrame = new JFrame("Testing");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        // Beginning of code for the Hamper Panel
        JPanel hamperCountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton hamperButton = new JButton("New Hamper");
        JLabel hamperLabel = new JLabel("Number of Hampers: " + hamperCount);
        hamperCountPanel.add(hamperButton);
        hamperCountPanel.add(hamperLabel);
        mainFrame.getContentPane().add(hamperCountPanel);

        // Listener event for Button press, create a new hamper panel
        // Within the hamper panel, add sub-panels for each client type.
        
        hamperButton.addActionListener(hamperActionEvent -> {
            hamperCount++;
            hamperLabel.setText("Number of Hampers: " + hamperCount);
            // New Hamper Panel 
            JPanel newHamperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
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
                maleAdultsCount--;
                maleAdultsCountLabel.setText("" + maleAdultsCount);
            });

            // Female adults sub-panel
            JPanel femaleAdultsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel femaleAdultsLabel = new JLabel("Number of Female Adults: " + femaleAdultsCount);
            femaleAdultsPanel.add(femaleAdultsLabel);

            // Child under 8 sub-panel
            JPanel childUnder8Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel childUnder8Label = new JLabel("Number of Childen under 8: " + childUnder8Count);
            childUnder8Panel.add(childUnder8Label);

            // Child over 8 sub-panel
            JPanel childOver8Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel childOver8Label = new JLabel("Number of Children over 8:" + childOver8Count);
            childOver8Panel.add(childOver8Label);

            newHamperPanel.add(maleAdultsPanel);
            newHamperPanel.add(femaleAdultsPanel);
            newHamperPanel.add(childUnder8Panel);
            newHamperPanel.add(childOver8Panel);
            newHamperPanel.setBorder(BorderFactory.createLineBorder(Color.black));
            mainFrame.getContentPane().add(newHamperPanel);
        });

            
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainFrame.setSize(500,500);
        mainFrame.setVisible(true);


    }
}
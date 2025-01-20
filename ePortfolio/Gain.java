
//By: Harishan Thilakanathan (1274198)
//Date: Friday, November 29, 2024
//Purpose: This is the Gain Class file. It is used for the gain panel

//Assignemnt 3 for CIS*2430

//----------------------------------------------------------------------------------------------------- 
package ePortfolio;


//All imports needed
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;



/**
* this is the gain class
* 
* 
*/
public class Gain extends JPanel implements ActionListener {


    //All the variables needed
    private JComboBox investmentList;

    /**
    * text field
    */
    private JTextField totalGainF;

    /**
    * text area
    */
    private JTextArea messageA;

    private Portfolio portfolio;
    
  
    /**
    * constructor for Gain
    * @param portfolio instance of Portfolio
    */
    public Gain(Portfolio portfolio) {

        this.portfolio = portfolio;

        // Initialize the panel
        setLayout(new BorderLayout());

        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel titleP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        
        JLabel titleLabel = new JLabel("Getting total gain");
        //titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        //set font, font name, font sizze
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));  
        titleP.add(titleLabel);
        add(titleP, BorderLayout.NORTH);


        //WEST------------------------------------
        
        //JPanel westRegion = new JPanel();
        //westRegion.setLayout(new BoxLayout(westRegion, BoxLayout.Y_AXIS));
        JPanel westRegion = new JPanel(new GridLayout(2, 2, 0, 0)); 

        westRegion.setPreferredSize(new Dimension(200, 270));

        
        //LABEL 1 - Symbol------------------------------------
    
        JPanel totalGainP = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10)); 
        totalGainP.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0)); 

        JLabel totalGainL = new JLabel("Total gain");
        totalGainL.setFont(new Font("Arial", Font.PLAIN, 17));  


        //text box field
        //totalGainF = new JTextField(10);

        //totalGainP.add(totalGainL);

        //totalGainP.add(totalGainF);

        totalGainF = new JTextField(10);

        //totalGainF.setText("Test Value");

        //double totalGain = 0;

        //totalGain = portfolio.getGainInvestment();
     
        //totalGainF.setText(String.format("%.2f", totalGain));

        totalGainF.setEditable(false);

        totalGainP.add(totalGainL);

        totalGainP.add(totalGainF);

        //------------------------------------

        add(westRegion, BorderLayout.CENTER);


        westRegion.add(totalGainP);
        westRegion.add(Box.createVerticalStrut(0));  

      
        //westRegion.setBackground(Color.BLUE);

        add(westRegion, BorderLayout.CENTER);


        //SOUTH------------------------------------

        //creating south panel to see where the borders are
        JPanel southPanel = new JPanel(); 
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        //southPanel.setBackground(Color.GREEN);

        // Set a border with padding above
        southPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));  

        // Set the preferred size of the panel if necessary
        southPanel.setPreferredSize(new Dimension(200, 270));


        JLabel messageS = new JLabel("Individual gains   ");
        messageS.setFont(new Font("Arial", Font.PLAIN, 17));

        //mkae sure it is aligned to the left  
        southPanel.setLayout(new FlowLayout(FlowLayout.LEFT));


        //useing JTextArea
        messageA = new JTextArea(50, 500);
        messageA.setEditable(false);  
        messageA.setLineWrap(false);   
        messageA.setWrapStyleWord(false);
 
 
        JScrollPane scrollPane = new JScrollPane(messageA);
        scrollPane.setPreferredSize(new Dimension(550, 190));
 
        //southPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
 
        southPanel.add(messageS);
 
        southPanel.add(scrollPane);
 
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
 

        // Add the south panel to the layout (BorderLayout.SOUTH)
        add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
    
    }


    /**
     * 
     * this is used to get gain
     * @return totalGainF for total gain
    */
    public JTextField getTotalGain(){

        return totalGainF;

    }

    /**
     * this is used in the Welcome Screen file, when the menu option is clicked, it will set the gain
     * 
     * @param totalGain the total gain
    */
    public void gain(double totalGain){

        totalGainF.setText(String.format("%.2f", totalGain));

    }
    
    /**
     * this is for the indvidual gain
     * 
     * @return messageA the message
     * 
    */
    public JTextArea getIndGain(){
        return messageA;
    }

    /**
     * this is also for induvidal gain
     * 
     * @param totalIndGain the individual gain
     * 
    */
    public void gainInv(double totalIndGain){

        messageA.setText(String.format("%.2f", totalIndGain));

    }

   

     /**
     * this is for when the button is clicked
     * 
     * 
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Implement any action handling if needed

        
    }

  

} //End of Gain class

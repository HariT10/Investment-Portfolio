//By: Harishan Thilakanathan (1274198)
//Date: Friday, November 29, 2024
//Purpose: This is the Sell Class file. It is used for the sell frame

//Assignemnt 3 for CIS*2430

//----------------------------------------------------------------------------------------------------- 
package ePortfolio;


//All imports used 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

import javax.swing.*;


/**
 * This is the Sell class 
 * 
*/
public class Sell extends JPanel implements ActionListener {

    //All the varaibles used 

    /**
    * for combo box
    */
    private JComboBox investmentList;

    /**
    * text fieled
    */
    private JTextField symbolF;

    /**
    * text fieled
    */
    private JTextField nameF;

    /**
    * text field
    */
    private JTextField quantityF;

    /**
    * text field 
    */
    private JTextField priceF;

    /**
    * message
    */
    private JTextArea messageA;

    /**
    * button
    */
    private JButton resetButton;

    /**
    * button
    */ 
    private JButton sellButton;

    /**
    * isntance of Portfolio
    */
    private Portfolio portfolio;
    

    /**
    * constructor for sell
    * @param portfolio isntance of Portfolio
    */
    public Sell(Portfolio portfolio) {


        this.portfolio = portfolio;

        // Initialize the panel
        setLayout(new BorderLayout());

        JPanel titleP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        //this is for the top left
        //creating new label
        //LABEL 1
        JLabel titleLabel = new JLabel("Selling an investment");
        //titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        //set font, font name, font sizze
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));  
        titleP.add(titleLabel);
        add(titleP, BorderLayout.NORTH);


        //WEST------------------------------------
        
        //JPanel westRegion = new JPanel();
        //westRegion.setLayout(new BoxLayout(westRegion, BoxLayout.Y_AXIS));
        JPanel westRegion = new JPanel(new GridLayout(10, 2, 0, 0)); 


        //LABEL 1 - Symbol-------------------------
    
        
        JPanel symbolP = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0)); 
        symbolP.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));  

        JLabel symbolL = new JLabel("Symbol");
        symbolL.setFont(new Font("Arial", Font.PLAIN, 17));  

        //text box field
        symbolF = new JTextField(10);

        symbolP.add(symbolL);

        symbolP.add(symbolF);

        //-----------------------------


        //LABEL 2 - Quantity-------------------------

        //for the panel
        JPanel quantityP = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0)); 
        quantityP.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 

        //for the label
        JLabel quantityL = new JLabel("Quantity");
        quantityL.setFont(new Font("Arial", Font.PLAIN, 17));  


        //text box field
        quantityF = new JTextField(10);

        quantityP.add(quantityL);

        quantityP.add(quantityF);


        //-----------------------------


        //LABEL 3 - Price-------------------------

        //for the panel
        JPanel priceP = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0)); 
        priceP.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 
        
        //for the label
        JLabel priceL = new JLabel("Price   ");
        priceL.setFont(new Font("Arial", Font.PLAIN, 17)); 
        
        //priceP.setPreferredSize(new Dimension(2000,4000));

        //priceP.setBackground(Color.BLUE);


        //text box field
        priceF = new JTextField(10);

        priceP.add(priceL);

        priceP.add(priceF);

        //-----------------------------


        add(westRegion, BorderLayout.CENTER);

        //add symbol panel
        westRegion.add(symbolP);
        westRegion.add(Box.createVerticalStrut(10));  

        //add quantity panel
        westRegion.add(quantityP);
        westRegion.add(Box.createVerticalStrut(0));  

        //add price panel
        westRegion.add(priceP);
        westRegion.add(Box.createVerticalStrut(0)); 

        //westRegion.setBackground(Color.BLUE);

        add(westRegion, BorderLayout.CENTER);



        //EAST------------------------------------

        //using border layout
        JPanel eastRegion = new JPanel(new BorderLayout());

        //set east region to redd
        eastRegion.setBackground(Color.RED);

        //the two buttons needed for this frame, reset and sell
        JButton resetButton = new JButton("Reset");
        JButton sellButton = new JButton("Sell");

        //panel for the buttons
        JPanel buttonP = new JPanel();  
        buttonP.setLayout(new BoxLayout(buttonP, BoxLayout.Y_AXIS));  

        //size
        resetButton.setPreferredSize(new Dimension(100,40));

        //size
        sellButton.setPreferredSize(new Dimension(100,40));

        //add
        buttonP.add(resetButton);
        buttonP.add(Box.createVerticalStrut(20));
        buttonP.add(sellButton);

        eastRegion.add(buttonP, BorderLayout.CENTER);

        //set size of the east region
        eastRegion.setPreferredSize(new Dimension(200, 400));  

        //add east region
        add(eastRegion, BorderLayout.EAST);


        //IF BUTTON is clicked 
        sellButton.addActionListener(this);
        resetButton.addActionListener(this);



        //SOUTH------------------------------------

        //south panel 
        JPanel southPanel = new JPanel(); 
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        //southPanel.setBackground(Color.GREEN);

        // size for the panel, tried with both because it did not work
        southPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));  

        // size for the panel 
        southPanel.setPreferredSize(new Dimension(200, 170));

        //new label
        JLabel messageS = new JLabel("Messages   ");
        messageS.setFont(new Font("Arial", Font.PLAIN, 17));

        //mkae sure it is aligned to the left  
        southPanel.setLayout(new FlowLayout(FlowLayout.LEFT));


        //useing JTextArea, this is what displays the messages
        messageA = new JTextArea(50, 500);
        messageA.setEditable(false);  
        //messageA.setLineWrap(false);   
        //messageA.setWrapStyleWord(false);

        //for the scroll
        JScrollPane scrollPane = new JScrollPane(messageA);
        scrollPane.setPreferredSize(new Dimension(550, 120));

        //southPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        southPanel.add(messageS);
        southPanel.add(scrollPane);

        //horizontal and vertical scroll
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        // Add the south panel to the layout (BorderLayout.SOUTH)
        add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
    
    }

     /**
     * using this to help with the clearing of panel, this will be called in the WelcomeScreen file
     * @return messageA the message
     * 
    */
    public JTextArea getMessageA(){

        return messageA;

    }
   


    /**
     * this is for when the button is clicked, this is basically simialr to the one in buy, thats why not many comments
     * 
     * 
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Implement any action handling if needed


        String action = e.getActionCommand();

        //All the varaibles needed 
        String type;
        String symbol;
        String name;
        String quantity;
        String price;
        int parseQuantity;
        double parsePrice;

        //If the sell button is clicked 
        if(action.equals("Sell")){


            //https://stackoverflow.com/questions/9103226/getting-user-input-by-jtextfield-in-java
            //type = (String) investmentList.getSelectedItem();
            symbol = symbolF.getText();
            //name = nameF.getText();
            quantity = quantityF.getText();
            price = priceF.getText();


            symbolF.setText("");   
            //nameF.setText("");    
            quantityF.setText(""); 
            priceF.setText("");

            //check if empty
            if(symbol.isEmpty() || quantity.isEmpty() || price.isEmpty()){
                messageA.append("\nERROR! Please DO NOT SKIP ANY FIELDS! TRY AGAIN!");
            }
            else{

                //try and catch block
                try{
                    parseQuantity = Integer.parseInt(quantity);
                    parsePrice = Double.parseDouble(price);

                    portfolio.sellInvestment(symbol, parseQuantity, parsePrice, messageA);

                    symbolF.setText("");   
                    nameF.setText("");    
                    quantityF.setText(""); 
                    priceF.setText("");

                } catch (NumberFormatException eh){

                    messageA.append("ERROR! Please try again!");

                }


            }


        }

        //if the reset button is clicked
        if(action.equals("Reset")){


            symbolF.setText("");   
            //nameF.setText("");    
            quantityF.setText(""); 
            priceF.setText("");


        }

     
    }

  
} //End of Sell class

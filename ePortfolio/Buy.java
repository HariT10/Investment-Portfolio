//By: Harishan Thilakanathan (1274198)
//Date: Friday, November 29, 2024
//Purpose: This is the Buy class file. Used for the buy frame. 

//Assignemnt 3 for CIS*2430

//----------------------------------------------------------------------------------------------------- 
package ePortfolio;


//Imports Used

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

import javax.swing.*;


/**
 * This is the Buy class 
 * 
*/
public class Buy extends JPanel implements ActionListener {

    //All the varaibles needed
    private JComboBox investmentList;

    /**
    * menu item
    */
    private JTextField symbolF;

    /**
    * name text field
    */
    private JTextField nameF;

    /**
    * quantitty text field
    */
    private JTextField quantityF;

    /**
    * price text field
    */
    private JTextField priceF;

    /**
    * message text field
    */
    private JTextArea messageA;

    /**
    * reset text field
    */
    private JButton resetButton; 

    /**
    * buy button
    */
    private JButton buyButton;

    /**
    * instance of portfolio
    */
    private Portfolio portfolio;



    /**
    * constructor for buy
    */
    public Buy(Portfolio portfolio) {

        this.portfolio = portfolio;

        // Initialize the panel
        setLayout(new BorderLayout());

        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel titleP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
      
        JLabel titleLabel = new JLabel("Buying an investment");
        //titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        //set font, font name, font sizze
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));  
        titleP.add(titleLabel);
        add(titleP, BorderLayout.NORTH);


        //WEST------------------------------------

        //Using grid layout to control the west side
        JPanel westRegion = new JPanel(new GridLayout(10, 2, 0, 0)); 


        //LABEL 1 - Type--------------------

        JPanel typeP = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0)); 
        typeP.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));  
        JLabel typeL = new JLabel("Type   ");
        typeL.setFont(new Font("Arial", Font.PLAIN, 17)); 
        
        typeL.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));  


        //combo box for the type
        String[] investmentType = {"stock" , "mutual fund"};

        investmentList = new JComboBox<>(investmentType);

        investmentList.setPreferredSize(new Dimension(200,50));

        investmentList.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));  


        typeP.setPreferredSize(new Dimension(250, 100));  


        typeP.add(typeL);

        typeP.add(investmentList);


        //-------------------------

        
        //LABEL 2 - Symbol--------------------
        JPanel symbolP = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0)); 
        symbolP.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 

        JLabel symbolL = new JLabel("Symbol");
        symbolL.setFont(new Font("Arial", Font.PLAIN, 17));  


        //text box field
        symbolF = new JTextField(10);

        symbolP.add(symbolL);

        symbolP.add(symbolF);


        //--------------------


        //LABEL 3 - Name--------------------
        
        JPanel nameP = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0)); 
        nameP.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 
        JLabel nameL = new JLabel("Name  ");
        nameL.setFont(new Font("Arial", Font.PLAIN, 17));
        //text box field
        nameF = new JTextField(20);

        nameP.add(nameL);

        nameP.add(nameF);

        //--------------------

        //LABEL 4 - Quantity--------------------

        JPanel quantityP = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0)); 
        quantityP.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));  
        JLabel quantityL = new JLabel("Quantity");
        quantityL.setFont(new Font("Arial", Font.PLAIN, 17));  


        //text box field
        quantityF = new JTextField(10);

        quantityP.add(quantityL);

        quantityP.add(quantityF);


        //--------------------


        //LABEL 5 - Price--------------------

        JPanel priceP = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0)); 
        priceP.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));  // Set insets to 0
        JLabel priceL = new JLabel("Price   ");
        priceL.setFont(new Font("Arial", Font.PLAIN, 17));  


        //text box field
        priceF = new JTextField(10);

        priceP.add(priceL);

        priceP.add(priceF);

        //--------------------

        //adding the west region
        add(westRegion, BorderLayout.CENTER);

        //adding type
        westRegion.add(typeP);
        westRegion.add(Box.createVerticalStrut(0)); 

        //adding symbol
        westRegion.add(symbolP);
        westRegion.add(Box.createVerticalStrut(0));  

        //adding name
        westRegion.add(nameP);
        westRegion.add(Box.createVerticalStrut(0));  

        //adding quantity
        westRegion.add(quantityP);
        westRegion.add(Box.createVerticalStrut(0));  

        //adding price
        westRegion.add(priceP);
        westRegion.add(Box.createVerticalStrut(10)); 

        //westRegion.setBackground(Color.BLUE);

        add(westRegion, BorderLayout.CENTER);



        // EAST------------------------------------


        //Now trying to control the East side
        JPanel eastRegion = new JPanel(new BorderLayout());

        //set east region to redd
        //eastRegion.setBackground(Color.RED);

        //the two buttons needed
        JButton resetButton = new JButton("Reset");
        JButton buyButton = new JButton("Buy");


        JPanel buttonP = new JPanel();  
        buttonP.setLayout(new BoxLayout(buttonP, BoxLayout.Y_AXIS));  


        resetButton.setPreferredSize(new Dimension(100,40));

        buyButton.setPreferredSize(new Dimension(100,40));

        //add
        buttonP.add(resetButton);
        buttonP.add(Box.createVerticalStrut(20));
        buttonP.add(buyButton);

        eastRegion.add(buttonP, BorderLayout.CENTER);

        //set size of the east region
        eastRegion.setPreferredSize(new Dimension(200, 400));  


        //add east region
        add(eastRegion, BorderLayout.EAST);


        //IF BUTTON is clicked 
        buyButton.addActionListener(this);
        resetButton.addActionListener(this);




        //SOUTH------------------------------------

        //Now controlling the South side

        //creating south panel to see where the borders are
        JPanel southPanel = new JPanel(); 
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        //southPanel.setBackground(Color.GREEN);

        // Set a border with padding above
        southPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));  

        // Set the preferred size of the panel if necessary
        southPanel.setPreferredSize(new Dimension(200, 170));


        JLabel messageS = new JLabel("Messages   ");
        messageS.setFont(new Font("Arial", Font.PLAIN, 17));

        //mkae sure it is aligned to the left  
        southPanel.setLayout(new FlowLayout(FlowLayout.LEFT));


        //useing JTextArea
        messageA = new JTextArea(50, 500);
        messageA.setEditable(false);  
        //messageA.setLineWrap(false);   
        //messageA.setWrapStyleWord(false);


        JScrollPane scrollPane = new JScrollPane(messageA);
        scrollPane.setPreferredSize(new Dimension(550, 120));

        //southPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        southPanel.add(messageS);
        southPanel.add(scrollPane);

        //this part will add the verticall and horizaontal scroll
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        // Add the south panel to the layout (BorderLayout.SOUTH)
        add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
    
    }


    /**
     * using this to help with the clearing of panel, this will be called in the WelcomeScreen file
     * 
     * 
    */
    public JTextArea getMessageA(){

        return messageA;

    }



    /**
     * this is for when the button is clicked
     * 
     * 
    */
    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();


        System.out.println("testing: " + action);


        //All the varaibles needed
        String type;
        String symbol;
        String name;
        String quantity;
        String price;
        int parseQuantity;
        double parsePrice;

        //If the buy button is pressed
        if(action.equals("Buy")){

            
            //https://stackoverflow.com/questions/9103226/getting-user-input-by-jtextfield-in-java
            
            //basically getting the information user entered
            type = (String) investmentList.getSelectedItem();
            symbol = symbolF.getText();
            name = nameF.getText();
            quantity = quantityF.getText();
            price = priceF.getText();


            //checking to make sure that noting is empty
            if(symbol.isEmpty() || name.isEmpty() || quantity.isEmpty() || price.isEmpty()){

                messageA.append("\nERROR! Please DO NOT SKIP ANY FIELDS! TRY AGAIN!");

            }
            //if nothing is empty than move 
            else{

                //this is in case a number is not entered for quantity and price
                try{

                    parseQuantity = Integer.parseInt(quantity);
                    parsePrice = Double.parseDouble(price);

                    //call the buyInvestment function whihc is in my Portfolio file
                    portfolio.buyInvestment(type, symbol, name, parseQuantity, parsePrice, messageA);

                    //clear all the bopxes
                    symbolF.setText("");   
                    nameF.setText("");    
                    quantityF.setText(""); 
                    priceF.setText("");


                } catch (NumberFormatException eh){

                    messageA.append("ERROR! Please try again!");

                }


            }

        }

        //If the reset button is pressed
        if(action.equals("Reset")){

            symbolF.setText("");   
            nameF.setText("");    
            quantityF.setText(""); 
            priceF.setText("");


        }
  
    }

  
} //End of Buy class

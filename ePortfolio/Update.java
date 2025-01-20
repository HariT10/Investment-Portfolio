
//By: Harishan Thilakanathan (1274198)
//Date: Friday, November 29, 2024
//Purpose: This is the Update Class file. It is used for the update panel

//Assignemnt 3 for CIS*2430

//----------------------------------------------------------------------------------------------------- 

package ePortfolio;

//imports needed
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

import javax.swing.*;


/**
 * This is the Update class 
 * 
*/
public class Update extends JPanel implements ActionListener {


    //All the variables needed
    private JComboBox investmentList;
    /**
    * text field
    */
    private JTextField symbolF;

    /**
    * text field

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
    * tetx area
    */
    private JTextArea messageA;

    /**
    * instance of Portfolio
    */
    private Portfolio portfolio;
    

    /**
    * constructor for update
    * @param portfolio instance
    */
    public Update(Portfolio portfolio) {

        this.portfolio = portfolio;

        // Initialize the panel
        setLayout(new BorderLayout());

        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel titleP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JLabel titleLabel = new JLabel("Updating investments");
        //titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        //set font, font name, font sizze
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));  
        titleP.add(titleLabel);
        add(titleP, BorderLayout.NORTH);


        //WEST------------------------------------

        //JPanel westRegion = new JPanel();
        //westRegion.setLayout(new BoxLayout(westRegion, BoxLayout.Y_AXIS));
        JPanel westRegion = new JPanel(new GridLayout(10, 2, 0, 0)); 

        
        //LABEL 1 - Symbol------------------------------------
    
    
        JPanel symbolP = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0)); 
        symbolP.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0)); 

        JLabel symbolL = new JLabel("Symbol");
        symbolL.setFont(new Font("Arial", Font.PLAIN, 17));  


        //text box field
        symbolF = new JTextField(10);

        symbolF.setEditable(false);

        symbolP.add(symbolL);

        symbolP.add(symbolF);

        //------------------------------------


        //LABEL 2 - Quantity------------------------------------

        JPanel nameP = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0)); 
        nameP.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));  
        JLabel nameL = new JLabel("Name  ");
        nameL.setFont(new Font("Arial", Font.PLAIN, 17));

        //text box field
        nameF = new JTextField(20);

        nameF.setEditable(false);

        nameP.add(nameL);

        nameP.add(nameF);

        //------------------------------------


        //LABEL 3 - Price------------------------------------

        JPanel priceP = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0)); 
        priceP.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));  
        JLabel priceL = new JLabel("Price   ");
        priceL.setFont(new Font("Arial", Font.PLAIN, 17)); 
        
        //priceP.setPreferredSize(new Dimension(2000,4000));


        //priceP.setBackground(Color.BLUE);

        //text box field
        priceF = new JTextField(10);

        priceP.add(priceL);

        priceP.add(priceF);

        //------------------------------------

        add(westRegion, BorderLayout.CENTER);

        westRegion.add(symbolP);
        westRegion.add(Box.createVerticalStrut(10));  

        westRegion.add(nameP);
        westRegion.add(Box.createVerticalStrut(0));  

        westRegion.add(priceP);

        westRegion.add(Box.createVerticalStrut(0)); 

        //westRegion.setBackground(Color.BLUE);

        add(westRegion, BorderLayout.CENTER);



        //EAST------------------------------------

        JPanel eastRegion = new JPanel(new BorderLayout());

        //set east region to redd
        //eastRegion.setBackground(Color.RED);

        //all the buttons needed for this frame

        JButton prevButton = new JButton("Prev");

        JButton nextButton = new JButton("Next");

        JButton saveButton = new JButton("Save");

        //button panel
        JPanel buttonP = new JPanel();  
        buttonP.setLayout(new BoxLayout(buttonP, BoxLayout.Y_AXIS));  

        prevButton.setPreferredSize(new Dimension(100,40));

        nextButton.setPreferredSize(new Dimension(100,40));

        //add
        buttonP.add(prevButton);
        buttonP.add(Box.createVerticalStrut(20));
        buttonP.add(nextButton);
        buttonP.add(Box.createVerticalStrut(20));

        buttonP.add(saveButton);

        eastRegion.add(buttonP, BorderLayout.CENTER);

        //set size of the east region
        eastRegion.setPreferredSize(new Dimension(200, 400));  


        //add east region
        add(eastRegion, BorderLayout.EAST);


        //IF BUTTON is clicked 
        prevButton.addActionListener(this);
        nextButton.addActionListener(this);
        saveButton.addActionListener(this);


       //SOUTH------------------------------------

        //creating south panel to see where the borders are
        JPanel southPanel = new JPanel(); 
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        //southPanel.setBackground(Color.GREEN);

        // Set a border with padding above
        southPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));  

        // Set the preferred size of the panel if necessary
        southPanel.setPreferredSize(new Dimension(200, 170));


        JLabel messageS = new JLabel("Messages  ");
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

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add the south panel to the layout (BorderLayout.SOUTH)
        add(southPanel, BorderLayout.SOUTH);


        setVisible(true);
    
    }

    /**
     * get updated symbol
     * 
     * @return symbolF.getText() for symbol
     */
    public String getSymbolUpdate(){

        return symbolF.getText();

    }
 
    /**
     * get updated name
     * 
     * @return nameF.getText() for name
     */
    public String getNameUpdate(){

        return nameF.getText();

    }

    /**
     * get uodataed price
     * 
     * @return 0 if it is is empty
     */
    public double getPriceUpdate(){
        String price = priceF.getText();

        //Double.parseDouble(priceF.getText());

        //try and catch block
        try{

            return Double.parseDouble(price);

        } catch(NumberFormatException e){

            //if the price is empty
            if(price.isEmpty()){

                return 0;

            }
            
            return 0;

        }

    }


   

     /*
     * this is for when the button is clicked
     * 
     * 
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Implement any action handling if needed

        String action = e.getActionCommand();

        System.out.println("test: " + action);

        //Varaibles needed
        String symbol;
        String name;
        int quantity;
        double price;

        //if the button "Prev" is clicked
        if(action.equals("Prev")){

            //https://stackoverflow.com/questions/9103226/getting-user-input-by-jtextfield-in-java
            //type = (String) investmentList.getSelectedItem();
            symbol = symbolF.getText();
            //name = nameF.getText();
            quantity = Integer.parseInt(quantityF.getText());
            price = Double.parseDouble(priceF.getText());

            name = nameF.getText();

            portfolio.updateInvestment(symbol, name, price, messageA);

            symbolF.setText("");   
            //nameF.setText("");    
            quantityF.setText(""); 
            priceF.setText("");


        }

        //if the button "Next" is clicked
        if(action.equals("Next")){


            symbolF.setText("");   
            //nameF.setText("");    
            quantityF.setText(""); 
            priceF.setText("");

        }

        //if the button "save" is clicked
        if(action.equals("Save")){


            symbolF.setText("");   
            //nameF.setText("");    
            quantityF.setText(""); 
            priceF.setText("");

        }

    
    }


} //End of Update class

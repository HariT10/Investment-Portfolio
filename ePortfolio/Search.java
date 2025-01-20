//By: Harishan Thilakanathan (1274198)
//Date: Friday, November 29, 2024
//Purpose: This is the Search Class file. It is used for the search panel

//Assignemnt 3 for CIS*2430

//----------------------------------------------------------------------------------------------------- 
package ePortfolio;


//All Imports needed
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;



/**
* this is the Search class
* 
* 
*/
public class Search extends JPanel implements ActionListener {


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
    private JTextField lowPriceF;

    /**
    * text field
    */
    private JTextField highPriceF;

    /**
    * text field
    */
    private JTextArea messageA;

    /**
    * instacne of Portfolio
    */
    private Portfolio portfolio;




    /**
    * constructor for search
    * @param portfolio instance of Portfolio
    */
    public Search(Portfolio portfolio) {

        this.portfolio = portfolio;

        // Initialize the panel
        setLayout(new BorderLayout());

        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel titleP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        //this is for the top left
        //creating new label
        //LABEL 1
        JLabel titleLabel = new JLabel("Searching investments");
        //titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        //set font, font name, font sizze
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));  
        titleP.add(titleLabel);
        add(titleP, BorderLayout.NORTH);


        //WEST ------------------------------------

        //JPanel westRegion = new JPanel();
        //westRegion.setLayout(new BoxLayout(westRegion, BoxLayout.Y_AXIS));
        JPanel westRegion = new JPanel(new GridLayout(10, 2, 0, 0)); 


        //LABEL 1 - Symbol------------------------------------
        JPanel symbolP = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0)); 
        symbolP.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 

        JLabel symbolL = new JLabel("Symbol");
        symbolL.setFont(new Font("Arial", Font.PLAIN, 17));  


        //text box field
        symbolF = new JTextField(10);

        symbolP.add(symbolL);

        symbolP.add(symbolF);


        //LABEL 2 - Name kEYWORD------------------------------------
        
        JPanel nameP = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0)); 
        nameP.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        
        //"Name Keyword" did not fit so I jsut made it to "KeyWord"
        JLabel nameL = new JLabel("Keywords");
        nameL.setFont(new Font("Arial", Font.PLAIN, 17));

        //text box field
        nameF = new JTextField(20);

        nameP.add(nameL);

        nameP.add(nameF);

        //nameP.setBackground(Color.BLUE);

        //------------------------------------


        //LABEL 3 - Quantity------------------------------------

        JPanel lowPriceP = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0)); 
        lowPriceP.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 
        
        
        JLabel lowPriceL = new JLabel("Low Price");
        lowPriceL.setFont(new Font("Arial", Font.PLAIN, 17));  

        //text box field
        lowPriceF = new JTextField(10);
        lowPriceF.setText("");

        lowPriceP.add(lowPriceL);

        lowPriceP.add(lowPriceF);

        //quantityP.setBackground(Color.RED);


        //LABEL 4 - Price------------------------------------

        JPanel highPriceP = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0)); 
        highPriceP.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));  
        JLabel highPriceL = new JLabel("High Price  ");
        highPriceL.setFont(new Font("Arial", Font.PLAIN, 17));  


        //text box field
        highPriceF = new JTextField(10);

        highPriceP.add(highPriceL);

        highPriceP.add(highPriceF);

        //priceP.setBackground(Color.ORANGE);

        //------------------------------------

        add(westRegion, BorderLayout.CENTER);


        westRegion.add(symbolP);
        westRegion.add(Box.createVerticalStrut(0));  


        westRegion.add(nameP);
        westRegion.add(Box.createVerticalStrut(0));  


        westRegion.add(lowPriceP);
        westRegion.add(Box.createVerticalStrut(0));  


        westRegion.add(highPriceP);

        westRegion.add(Box.createVerticalStrut(10)); 

        //westRegion.setBackground(Color.YELLOW);

        add(westRegion, BorderLayout.CENTER);



        // EAST------------------------------------

        JPanel eastRegion = new JPanel(new BorderLayout());

        //set east region to redd
        //eastRegion.setBackground(Color.RED);

   
        JButton resetButton = new JButton("Reset");
        JButton buyButton = new JButton("Search");

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

        //creating south panel to see where the borders are
        JPanel southPanel = new JPanel(); 
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        //southPanel.setBackground(Color.GREEN);

        // Set a border with padding above
        southPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));  

        // Set the preferred size of the panel if necessary
        southPanel.setPreferredSize(new Dimension(200, 170));


        JLabel messageS = new JLabel("Search Results   ");
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
     * using this to help with the clearing of panel, this will be called in the WelcomeScreen file
     * 
     * @return messageA
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
        // Implement any action handling if needed

        String action = e.getActionCommand();

        System.out.println("test: " + action);


        //String type;

        String symbol = "";

        String name = "";

        String lowPrice = "";

        String highPrice = "";

        double lowPriceConverted;

        double highPriceConverted;

        if(action.equals("Search")){

            //https://stackoverflow.com/questions/9103226/getting-user-input-by-jtextfield-in-java
            symbol = symbolF.getText().trim();
            name = nameF.getText().trim();

            lowPrice = lowPriceF.getText().trim();
            highPrice = highPriceF.getText().trim();

    

            portfolio.searchInvestments(symbol, name, lowPrice, highPrice, messageA);

            symbolF.setText("");   
            nameF.setText("");    
            lowPriceF.setText(""); 
            highPriceF.setText("");


        }

        if(action.equals("Reset")){

            symbolF.setText("");   
            nameF.setText("");    
            lowPriceF.setText(""); 
            highPriceF.setText("");

        }

    
        
    }

  

} //End of Search class

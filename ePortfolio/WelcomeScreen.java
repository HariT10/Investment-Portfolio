//By: Harishan Thilakanathan (1274198)
//Date: Friday, November 29, 2024
//Purpose: This is the WelcomeScreen class, which is basically the panel for the interface, and also the menu at the top

//Assignemnt 3 for CIS*2430

//----------------------------------------------------------------------------------------------------- 

package ePortfolio;


//imports needed

import java.awt.BorderLayout;
import java.awt.CardLayout;

import java.awt.Component;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



/**
 * This is the start of the WelcomeScreen Class
 * 
 */
public class WelcomeScreen extends JFrame implements ActionListener{


    //All the variables needed throughout this class
    private JMenuBar menuBar;
    /**
    * menu item
    */
    private JMenu fileMenu;

    /**
    * menu item
    */
    private JMenuItem homeMenu;
    /**
    * menu item
    */
    private JMenuItem buyMenu;

    /**
    * menu item
    */
    private JMenuItem sellMenu;

    /**
    * menu item
    */
    private JMenuItem updateMenu;

    /**
    * menu item
    */
    private JMenuItem gainMenu;

    /**
    * menu item
    */
    private JMenuItem searchMenu;

    /**
    * menu item
    */
    private JMenuItem quitMenu;

    /**
    * instance of the Portfolio class
    */
    private Portfolio portfolio;

    /**
    * message area
    */
    private JTextArea messageA;

    /**
    * welcome panel
    */
    private JPanel welcome;

    /**
    * for card layout
    */
    private CardLayout cardLayout;

    /**
    * instance of the Gain class
    */
    private Gain gainP;

    /**
    * instance of the Search class
    */
    private Search searchP;

    /**
    * instance of the Update class
    */
    private Update updateP;

    /**
    * instance of the Sell class
    */
    private Sell sellP;

    /**
    * instance of the Buy class
    */
    private Buy buyP;



    /**
    * constructor for welcome screen
    * @param portfolio instance of Portfolio
    */
    public WelcomeScreen(Portfolio portfolio){

        this.portfolio = portfolio;

        //set up everything for the frame
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("ePortfolio - A3");
        setLayout(new BorderLayout());


        //https://coderanch.com/t/609745/java/CardLayout-show-method
        //using cardlayout
        welcome = new JPanel( new CardLayout());
        cardLayout = (CardLayout) welcome.getLayout();
        
        //creating the home panel
        JPanel homeP = home();

        welcome.add(homeP, "Home");
 
        //Buy
        buyP = new Buy(portfolio);
        welcome.add(buyP, "Buy");

        //Sell
        sellP = new Sell(portfolio);
        welcome.add(sellP, "Sell");

        //Sell
        updateP = new Update(portfolio);
        welcome.add(updateP, "Update");

        //Gain
        gainP = new Gain(portfolio);
        welcome.add(gainP, "Gain");

        //Search
        searchP = new Search(portfolio);
        welcome.add(searchP, "Search");

        //Quit
        Quit quitP = new Quit();
        welcome.add(quitP,"Quit");


        cardLayout.show(welcome, "Home");

        add(welcome, BorderLayout.CENTER);

        //This is used for the drop down menu at the top of the screen
        menuBar = new JMenuBar();
        fileMenu = new JMenu("Commands");
        homeMenu = new JMenuItem("Home");
        buyMenu = new JMenuItem("Buy");
        sellMenu = new JMenuItem("Sell");
        updateMenu = new JMenuItem("Update");
        gainMenu = new JMenuItem("Gain");
        searchMenu = new JMenuItem("Search");
        quitMenu = new JMenuItem("Quit");

        //add to menu
        fileMenu.add(homeMenu);
        fileMenu.add(buyMenu);
        fileMenu.add(sellMenu);
        fileMenu.add(updateMenu);
        fileMenu.add(gainMenu);
        fileMenu.add(searchMenu);
        fileMenu.add(quitMenu);
        menuBar.add(fileMenu);


        setJMenuBar(menuBar);


        //https://www.youtube.com/watch?v=ocb3x0TeoUwhttps://www.youtube.com/watch?v=ocb3x0TeoUw
        homeMenu.addActionListener(this);
        buyMenu.addActionListener(this);
        sellMenu.addActionListener(this);
        updateMenu.addActionListener(this);
        gainMenu.addActionListener(this);
        searchMenu.addActionListener(this);
        quitMenu.addActionListener(this);

        //makes it visible
        setVisible(true);


    }


    //This function has the layout for the home panel
    /**
     * funciton for home panel
     * @return middleV
     */
    private JPanel home(){

         //https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html
        //"Register User" Text--------------------------

        //Vertical
        JPanel middleV = new JPanel();
        middleV.setLayout(new BoxLayout(middleV, BoxLayout.Y_AXIS));

        //main title on the home screen
        JLabel text1 = new JLabel("\nWelcome to ePortfolio");

        //Horizontal
        JPanel middleH = new JPanel();
        middleH.setLayout(new BoxLayout(middleH, BoxLayout.X_AXIS));

        middleH.add(Box.createRigidArea(new Dimension(50,0)));


        //Adding to the panel
        middleH.add(text1);

        middleH.add(Box.createRigidArea(new Dimension(340,0)));

        middleV.add(Box.createRigidArea(new Dimension(0,100)));

        middleV.add(middleH);

        middleV.add(Box.createRigidArea(new Dimension(0,40)));


        //the text on the inital interface aka home screen
        JLabel text2 = new JLabel("<html>Choose a command from the “Commands” menu to buy or sell<br>" + 
                        "an investment, update prices for all investments, get gain for the<br>" + 
                        "portfolio, search for relevant investments, or quit the program.");


        //this aligns it to the leftside
        text2.setAlignmentX(Component.LEFT_ALIGNMENT);


        //created a panel for text 2 
        JPanel middleH2 = new JPanel();
        middleH2.setLayout(new BoxLayout(middleH2, BoxLayout.X_AXIS));

        middleH2.add(Box.createRigidArea(new Dimension(80,0)));

        middleH2.add(text2);

        middleH2.add(Box.createRigidArea(new Dimension(20,0)));

        middleV.add(Box.createRigidArea(new Dimension(0,1)));
        
        middleV.add(middleH2);
                
        middleV.add(Box.createRigidArea(new Dimension(0,1)));
                
        //add 
        add(middleV, BorderLayout.CENTER);

    
        //setVisible(true);
        return middleV;

    }


    /**
     * This function is for the button actions
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        // Get the source of the event
        //Object source = e.getSource();
        String action = e.getActionCommand();

        /* 
        // Switch between panels based on the menu item clicked
        if (source == buyMenu) {
            cardLayout.show(welcome, "Buy");
        } else if (source == homeMenu) {
            cardLayout.show(welcome, "Home");
        }
        */


        cardLayout = (CardLayout) welcome.getLayout();

        if(action.equals("Home")){

            cardLayout.show(welcome, "Home");

        }

        //when the buy menu option is clicked
        else if(action.equals("Buy")){

            buyP.getMessageA().setText("");

            cardLayout.show(welcome, "Buy");

        }

        //when the sell menu option is clicked
        else if(action.equals("Sell")){

            sellP.getMessageA().setText("");

            cardLayout.show(welcome, "Sell");

        }

        //when the update menu option is clicked
        else if(action.equals("Update")){

            String symbol = updateP.getSymbolUpdate();
            String name = updateP.getNameUpdate();
            double price = updateP.getPriceUpdate();

            
            if(price < 0){

                messageA.append("Error");

            }
            else{

                portfolio.updateInvestment(symbol, name, price, messageA);


            }
            
            cardLayout.show(welcome, "Update");
            

        }

        //when the gain menu option is clicked
        else if(action.equals("Gain")){

            double totalGain = portfolio.getGainInvestment();

            System.out.println("TEST: " + totalGain);

            double totalInvGain = portfolio.getIndInvestment();

            //JTextField totalGainF = gainP.getTotalGain();
            //totalGainF.setText(String.format("%.2f", totalGain));

            //System.out.println("TESTING: " + totalGainF.getText());

            gainP.gain(totalGain);
            gainP.gainInv(totalInvGain);

            cardLayout.show(welcome, "Gain");
        
        }

        //when the search menu option is clicked
        else if(action.equals("Search")){

            searchP.getMessageA().setText("");

            cardLayout.show(welcome, "Search");

        }

        //when the quit menu option is clicked, the program will end
        else if(action.equals("Quit")){

            cardLayout.show(welcome, "Quit");
            System.exit(0);
        }

    }


    /**
     * This is the main
     * @param args main
     */
    public static void main(String[] args){

        Portfolio portfolio = new Portfolio();

        new WelcomeScreen(portfolio);


    }

    
} //End of WelcomeScreen class

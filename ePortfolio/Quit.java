//By: Harishan Thilakanathan (1274198)
//Date: Friday, November 29, 2024
//Purpose: This is the Quit Class file. It is used for the quit panel, which exits everything

//Assignemnt 3 for CIS*2430

//----------------------------------------------------------------------------------------------------- 
package ePortfolio;

//All imports needed
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

import javax.swing.*;



/**
* this is the Quit class
* 

*/
public class Quit extends JPanel implements ActionListener {

    //System.exit(0);



    /**
    * constructor for quit
    */
    public Quit() {


         // Initialize the panel
         setLayout(new BorderLayout());

         //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
 
         JPanel titleP = new JPanel(new FlowLayout(FlowLayout.LEFT));
         

         JLabel titleLabel = new JLabel("Quit");
         //titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
         //set font, font name, font sizze
         titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));  
         titleP.add(titleLabel);
         add(titleP, BorderLayout.NORTH);   

    }

    /**
     * for when button is pressed, not needed here
     * 
     * 
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

} //End of Quit class
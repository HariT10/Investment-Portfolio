//By: Harishan Thilakanathan (1274198)
//Date: Friday, November 29, 2024
//Purpose: This is the Mutual Fund class

//Assignment 3 for CIS*2430

//----------------------------------------------------------------

package ePortfolio;

/**
 * Start of Mutual Fund class
 * 
 */
public class MutualFund extends Investment{

    //All variables here 
    //symbol, name, quantity, price, bookValue of the stock
    private String sSymbol;
    private String nName;

    private int qQuantity;

    private double pPrice;

    private double bBookValue;



    /**
     * This is the constructor for the Mutual Fund class
     * 
     * @param symbol Represents the Mutual Fund Symbol.
     * @param name represents the Mutual Fund Name
     * @param quantity represents the Mutual Fund Quantity
     * @param price represents the Mutual Fund Price
     * @param bookValue represents the Mutual Fund BookValue
     */
    public MutualFund(String symbol, String name, int quantity, double price, double bookValue){

        super(symbol, name, quantity, price, bookValue);

        this.sSymbol = symbol;
        this.nName = name;
        this.qQuantity = quantity;
        this.pPrice = price;

        this.bBookValue = bookValue(quantity, price);

    }


    @Override
    public String toString(){

        return "type = mutual fund" + " , symbol = " + getSymbol() + " , name = " + getName() + " , quantity = " + getQuantity() + " , price = " + getPrice() + " , bookValue = " + getBookValue();

    }


    //this is because bookValue is calcualted differently for mutual fund and stock, followed this from the lab example
    @Override
    public double bookValue(int quantity, double price){


        double bookMFund = quantity * price;

        return bookMFund;


    }

    

    //set - mutator methods
    // allows to change the values of a objects instance variable in a controlled manner <- from notes
    //https://runestone.academy/ns/books/published/csjava/Unit6-Writing-Classes/topic-6-5-mutator-methods.html


    /**
     * set - Mutator Method
     * 
     * @param sSymbol Represents the symbol
     */
    public void setSymbol(String sSymbol){

        this.sSymbol = sSymbol;

    }


    /**
     * set - Mutator Method
     * 
     * @param nName Represents the name
     */
    public void setName(String nName){

        this.nName = nName;

    }


    /**
     * set - Mutator MethodS
     * 
     * @param qQuantity Represents the quantity
     */
    public void setQuantity(int qQuantity){

        this.qQuantity = qQuantity;

    }


    /**
     * set - Mutator Method
     * 
     * @param pPrice Represents the price 
     */
    public void setPrice(double pPrice){

        this.pPrice = pPrice;

    }


    /**
     * set - Mutator Method
     * 
     * @param bBookValue Represents the bookValue
     */
    public void setBookValue(double bBookValue){

        this.bBookValue = bBookValue;
    }


    /**
     * get - Accessor Method
     * the symbol of the stock, ex. AAPL
     * 
     * @return sSymbol
     */
    public String getSymbol(){

        return sSymbol;

    }


    /**
     * get - Accessor Method
     * 
     * the naeme of the stock, ex. Apple Inc.
     * @return nName
     */
    public String getName(){

        return nName;

    }

    
    /**
     * get - Accessor Method
     * 
     * the quantity of stocks bought, ex. 500 shares 
     * @return qQuantity
     */
    public int getQuantity(){

        return qQuantity;

    }



    /**
     * get - Accessor Method
     * 
     * the price too buy, price per share. ex, $110.08
     * @return pPrice
     */
    public double getPrice(){

        return pPrice;

    }

    

    /**
     * get - Accessor Method
     * 
     * //the total value of stocks currentlty owned. ex, $55,049.99 ----> 500 x 110.08 = 55,049.99
     * @return bBookValue
     */
    public double getBookValue(){

        return bBookValue;

    }


   


    
} //End of class MutualFund

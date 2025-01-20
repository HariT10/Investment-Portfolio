//By: Harishan Thilakanathan (1274198)
//Date: Friday, November 29, 2024
//Purpose: This is the Stock class

//Assignment 3 for CIS*2430

//----------------------------------------------------------------


package ePortfolio;

/**
 * Start of Stock class
 * 
 */
public class Stock extends Investment{

    //All variables here 
    //symbol, name, quantity, price, bookValue of the stock
    private String sSymbol;
    private String nName;

    private int qQuantity;

    private double pPrice;

    private double bBookValue;

    private double commision = 9.99;


    /**
     * This is the constructor for the Stock class
     * 
     * @param symbol represents the Stock Symbol
     * @param name represents the Stock Name 
     * @param quantity represents the Stock Quantity
     * @param price represents the Stock Price
     * @param bookValue represents the Stock BookValue
     */
    public Stock(String symbol, String name, int quantity, double price, double bookValue){

        super(symbol, name, quantity, price, bookValue);

        this.sSymbol = symbol;
        this.nName = name;
        this.qQuantity = quantity;
        this.pPrice = price;

        this.bBookValue = bookValue(quantity, price);

        //this.bBookValue = quantity * price + commision;


    }


    @Override
    public String toString(){

        return "type = stock" + " , symbol = " + getSymbol() + " , name = " + getName() + " , quantity = " + getQuantity() + " , price = " + getPrice() + " , bookValue = " + getBookValue();

    }


    //this is because bookValue is calcualted differently for mutual fund and stock, followed this from the lab example
    @Override
    public double bookValue(int quantity, double price){


        double bookS = quantity * price + commision;

        return bookS;

    }


    //set - mutator methods
    // allows to change the values of a objects instance variable in a controlled manner <- from notes
    //https://runestone.academy/ns/books/published/csjava/Unit6-Writing-Classes/topic-6-5-mutator-methods.html


    /**
     * set - Mutator Method
     * allows to change the values of a objects instance variable in a controlled manner, from notes
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
     * set - Mutator Method
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
     * @param bBookValue Represents the bookvalue
     */
    public void setBookValue(double bBookValue){

        this.bBookValue = bBookValue;
    }


    /**
     * get - Accessor Method
     * 
     * the symbol of the stock, ex. AAPL
     * @return sSymbol
     */
    public String getSymbol(){

        return sSymbol;

    }

    
    /**
     * get - Accessor Method
     * 
     * the name of the stock, ex. Apple Inc.
     * @return nName
     */
    public String getName(){

        return nName;

    }

    
    /**
     * get - Accessor Methods
     * 
     * the quantity of stocks bought, ex. 500 shares 
     * @return qQuantity
     */
    public int getQuantity(){

        return qQuantity;

    }

    

    /**
     * get - Accessor Methods
     * 
     * the price too buy, price per share. ex, $110.08
     * @return pPrice
     */
    public double getPrice(){

        return pPrice;

    }


    /**
     * get - Accessor Methods
     * 
     * the total value of stocks currentlty owned. ex, $55,049.99 ----> 500 x 110.08 = 55,049.99
     * @return bBookBalue
     */
    public double getBookValue(){

        return bBookValue;

    }

    
} //End of class Stock

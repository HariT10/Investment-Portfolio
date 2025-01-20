//By: Harishan Thilakanathan (1274198)
//Date: Friday, November 29, 2024
//Purpose: This is the Investment Class

//Assignment 3 for CIS*2430

//----------------------------------------------------------------
package ePortfolio;


/**
 * Abstract class Investment which has two subclass Stock and Mutual Fund
 */
public abstract class Investment {

    //ArrayList<Investment> investment = new ArrayList<>();

    //All varaibles here, protected allows subclasses to accses
    /**
     * protected variable for investment symbol
     */
    protected String investmentSymbol;

    /**
     * protected varaible for investment name
     */
    protected String investmentName;


    /**
     * protected varaible for investment quantity
     */
    protected int investmentQuantity;

    /**
     * protected varaible for investment price
     */
    protected double investmentPrice;


    /**
     * protected varaible for investment symbol
     */
    protected double investmentBookValue;

    /**
     * protected varaible for investment symbol
     */
    protected boolean bookValueChecker = false;


    /**
     * This is the constructor for the Mutual Fund class
     * 
     * @param symbol Represents the Investment Symbol.
     * @param name represents the Investment Name
     * @param quantity represents the Mutual Fund Quantity
     * @param price represents the Mutual Fund Price
     * @param bookValue represents the Mutual Fund BookValue
     */
    public Investment(String symbol, String name, int quantity, double price, double bookValue){

        this.investmentSymbol = symbol;
        this.investmentName = name;
        this.investmentQuantity = quantity;
        this.investmentPrice = price;

        //for the bookvalue, the function will be called since it is different caluclations for stock and mutual fund
        this.investmentBookValue = bookValue(quantity, price);

    }


    //this is from the lab example that was done during the lab
    /**
     * toString method, using this to print contents to the text file
     * this funciton is being overidden in the stock and mutual fund sub classes because of the type difference
     * 
     * 
     */
    public String toString(){

        return ",symbol = " + getSymbol() + ", name = " + getName() + ", quantity = " + getQuantity() + ", price = " + getPrice() + ", bookValue = " + getBookValue();

    }


    /**
     * this fucntion is being overidden in the respected class (Stock and Mutual Fund) because of the different calculations for bookvalue
     *
     * @param quanitity to store the quantity
     * @param price to store the price
     * @return bookS or bookMFund
     */
    public abstract double bookValue(int quanitity, double price);


    /**
     * set - Mutator Method
     * 
     * @param bBookValue Represents the bookvalue
     */
    public void setBookValue(double bBookValue){

        this.investmentBookValue = bBookValue;
    }
   

    /**
     * set - Mutator Method 
     * 
     * @param iSymbol Represents the symbol
     */
    public void setSymbol(String iSymbol){

        this.investmentSymbol = iSymbol;

    }


    /**
     * set - Mutator Method
     * 
     * @param iName Represents the name
     */
    public void setName(String iName){

        this.investmentName = iName;

    }


    /**
     * set - Mutator Method
     * 
     * @param iQuantity Represents the name
     */
    public void setQuantity(int iQuantity){

        this.investmentQuantity = iQuantity;

    }


    /**
     * set - Mutator Method
     * 
     * @param iPrice Represents the name
     */
    public void setPrice(double iPrice){

        this.investmentPrice = iPrice;

    }




    /**
     * get - Accessor Method
     * 
     * the symbol of the stock, ex. AAPL
     * @return investmentSymbol
     */
    public String getSymbol(){

        return investmentSymbol;

    }



    /**
     * get - Accessor Method
     * 
     * the symbol of the stock, ex. AAPL
     * @return investmentBookValue
     */
    public double getBookValue(){

        return investmentBookValue;

    }


    /**
     * get - Accessor Method
     * 
     * the symbol of the stock, ex. AAPL
     * @return investmentQuantity
     */
    public int getQuantity(){

        return investmentQuantity;

    }



    /**
     * get - Accessor Method
     * 
     * the symbol of the stock, ex. AAPL
     * @return investmentPrice
     */
    public double getPrice(){

        return investmentPrice;

    }


    /**
     * get - Accessor Method
     * 
     * the symbol of the stock, ex. AAPL
     * @return investmentPrice
     */
    public String getName(){

        return investmentName;

    }


}
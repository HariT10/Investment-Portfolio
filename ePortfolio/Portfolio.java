//By: Harishan Thilakanathan (1274198)
//Date: Friday, November 29, 2024
//Purpose: This is the Portfolio class.

//Assignemnt 3 for CIS*2430

//----------------------------------------------------------------------------------------------------- 

package ePortfolio; 

//Imports needed 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * This is the start of the Portfolio Class
 * This class has my main functions such as buy, sell, update, getGain, and search
 */
public class Portfolio {


    //The ONE ArrayList called Investment
    private ArrayList<Investment> investment = new ArrayList<>();

    //The HashMap called keywordSearch
    HashMap<String, ArrayList<Integer>> keywordSearch = new HashMap<>();


    private JTextArea messageA;
    private JTextField symbolF, nameF, quantityF, priceF;

    private Update update;


    //constructor
    public Portfolio(){

        this.update = new Update(this);

    }
    

    /**
     * 
     * //Start of Main Function 
     * 
     * @param args The main argument
     */
    public static void main(String[] args){


        //store the file name in a variable that I can use in the fucntion 
        //the filename will be entered in the command line using quotes 
        String fileName = args[0];

        //System.out.println("Test: " + fileName);

        Portfolio portfolio = new Portfolio();

        //save the contents in the text file to the list
        //portfolio.saveTextFileToList(fileName);

        
        //Choice selected by user from the menu options 
        String myChoice = "";

        //THIS IS NOT NEEDED ANYMORE(but I kept here)
        while(true){

            //All the menu options, from 1-9
            System.out.println(" ");
            System.out.println("-------------Portfolio------------------");
            System.out.println("(1) Buy (Enter 'Buy')");
            System.out.println("(2) Sell (Enter 'Sell')");
            System.out.println("(3) Update (Enter 'Update')");
            System.out.println("(4) Gain (Enter 'Gain')");
            System.out.println("(5) Search (Enter 'Search')");
            System.out.println("(6) Quit (Enter 'Quit')");
            System.out.println("----------------------------------------");
            System.out.println(" ");

            //Ask user to enter choice
            System.out.println(" ");
            System.out.println("Enter Your Choice Please: ");
            Scanner inputScanner = new Scanner(System.in);
            myChoice = inputScanner.next();
            System.out.println(" ");


            // (1) - User can either buy a Stock or a Mutual Fund 
            if(myChoice.equalsIgnoreCase("Buy")){
  

                //portfolio.buyInvestment();
                
         
                
            } //End of choice 1 
 

            // (2) - Users can either sell their Stock or Mutual Fund
            if(myChoice.equalsIgnoreCase("Sell")){


                //portfolio.sellInvestment();



            } //End of choice 2 
            


            // (3) - Users can update the prices of either all their Stocks or all their Mutual Funds 
            if(myChoice.equalsIgnoreCase("Update")){

            
                //portfolio.updateInvestment();


            } //End of choice 3


            // (4) - Users will be displayed with their total gain from both Stocks and Mutual Funds 
            if(myChoice.equalsIgnoreCase("Gain")){

                //Variables
                double totalGain = 0;

                //portfolio.getGainTotal();
                //stockGain = portfolio.getGainStock();
                //mutualFundGain = portfolio.getGainMutualFund();


                totalGain = portfolio.getGainInvestment();


                //totalGain = stockGain + mutualFundGain;
            

                //https://javarush.com/en/groups/posts/en.2773.rounding-numbers-in-java - used this to help me out
                String format = String.format("%.2f", totalGain);
                System.out.println("\nThe Gain of all the investments is: " + format);
  

            }
            

            // (5) - The system will search for investments in Stock and Mutual Funds based on Symbol, Name Keyword, and Price
            if(myChoice.equalsIgnoreCase("Search")){


                //portfolio.search();
                //portfolio.searchInvestments();


            } //End of choice 5



            //(6) - Quit Program, but also save the contents to a text file
            if(myChoice.equalsIgnoreCase("Quit") && !myChoice.equalsIgnoreCase("Q")){

                //save contents to the text file before exiting the program
                //portfolio.saveToTextFile(fileName);

                //exit the program 
                //System.exit(0);

            }


        } //end of while loop


    } //End of Main Function




    /**
     * Helper function to check if the symbol exists in either stock or mutual fund
     * 
     * @param symbolChecker which checks if the symbol already exists in Stock or Mutual Fund investments 
     * @return "existsStock" if it exists in Stock investments, or "existsMutualFund" if it exists in Mutual Fund investments, or "doesNotExist" if it does not exist in either investments
     */
    public String checker(String symbolChecker){

        //System.out.println("T1");  

        //counters used for checking

        //checker1 represetns mutual fund
        int checker1 = 0;
        //checker2 represents stock
        int checker2 = 0;


        //for loop to iterate through the Investment array lsit 
        for(Investment invest : investment){

            //checks if invest object is instance of Mutual Fund 
            if(invest instanceof MutualFund){

                //System.out.println("T3");

                //if it is, than increment checker1 varaible which represetns mutual funds
                checker1++;
                //then break
                break;

            }

        }

        //System.out.println("T4");

        //for loop to iterate through the Investment array lsit 
        for(Investment invest : investment){

            //checks if invest object is instance of Stock
            if(invest instanceof Stock){

                //System.out.println("T6");

                //if it is, than increment checker2 varaible which represetns stocks
                checker2++;
                //then break
                break;

            }

        }

        //System.out.println("T7");

        //All the different cases are below--

        //if both mutual fund and stock are empty
        if(checker1 == 0 && checker2 == 0){

            //System.out.println("T7");

            return "doesNotExist";

        }


        //mutual fund and stock is not empty 
        if(checker1 == 1 && checker2 == 1){

            //System.out.println("T80");


            //For loop that goes through the stock ArrayList
            for(Investment invest : investment){

                //System.out.println("T90");

                if(invest instanceof Stock){

                    //System.out.println("T91");
                    //if symbol already exists, then we only need to change the quantity
                    if(invest.getSymbol().equalsIgnoreCase(symbolChecker)){

                        //System.out.println("T9");
                        //the symbol already exists in stock ArrayList
                        return "existsStock";

                    }

                }


                if(invest instanceof MutualFund){

                    //if symbol already exists, then we only need to change the quantity
                    if(invest.getSymbol().equalsIgnoreCase(symbolChecker)){

                        //the symbol exists in the mutual fund ArrayList
                        return "existsMutualFund";

                    }

                }

            }

            //does not exsits in either stock or mutual fund 
            return "doesNotExist";

        }


        //if mutual fund is not empty and stock is empty
        if(checker1 == 1 && checker2 == 0){

            //For loop that goes through the stock ArrayList
            for(Investment invest : investment){

                if(invest instanceof MutualFund){

                    //if symbol already exists, then we only need to change the quantity
                    if(invest.getSymbol().equalsIgnoreCase(symbolChecker)){

                        //the symbol already exists in stock ArrayList
                        return "existsMutualFund";

                    }
                }

            }

            return "doesNotExist";

        }

        //System.out.println("T10");

        //if mutual fund is empty and stock is not empty 
        if(checker1 == 0 && checker2 == 1){

            //System.out.println("T11");

            //For loop that goes through the stock ArrayList
            for(Investment invest : investment){

                //System.out.println("T12");

                if(invest instanceof Stock){

                    //if symbol already exists, then we only need to change the quantity
                    if(invest.getSymbol().equalsIgnoreCase(symbolChecker)){

                        //the symbol already exists in stock ArrayList
                        return "existsStock";

                    }
                }

            }

            return "doesNotExist";

        }



        return "doesNotExist";


    } //End of helper function called checker()



    /**
     * Function to buy and investment (either stock or mutual fund), that will be stored in the Investment array list
     * 
     * @param typeOfInvestment investment type
     * @param symbol the symbol
     * @param name the name
     * @param quantity the quantity
     * @param price the price
     * @param messageA the messgae area
     */
    public void buyInvestment(String typeOfInvestment, String symbol, String name, int quantity, double price, JTextArea messageA){

        System.out.println("TESTING: " + typeOfInvestment);

        Scanner scanner = new Scanner(System.in);

        //Variable that will hold the type of investment the user would like to buy
        //String typeOfInvestment;

        while(true){

            System.out.println("TESTING2");


            //if the user entered "Stock" or "S" ignoring the lower/upper cases
            if(typeOfInvestment.equalsIgnoreCase("Stock") || typeOfInvestment.equalsIgnoreCase("S")){

                break;

            }

            //if the user entered "Mutual Fund" or "M" ignoring the lower/upper cases
            if(typeOfInvestment.equalsIgnoreCase("Mutual Fund") || typeOfInvestment.equalsIgnoreCase("M")){

                break;

            }

            //if the user entered "Back" or "B" ignoring the lower/upper cases
            if(typeOfInvestment.equalsIgnoreCase("Back") || typeOfInvestment.equalsIgnoreCase("B")){

                //portfolio.back();
                //break;
                
            }

        } //end of while loop


        //Variable
        //String symbol;


        while(true){

            //System.out.println("SYmbol: " + symbol); 
 

            //store the result of checker() into check
            String check = checker(symbol);
            System.out.println("Checker result: " + check);  

            //System.out.println("tEST100"); 

            System.out.println("TESTING1");


            //if the user entered "Stock" or "S" ignoring the lower/upper cases
            if(typeOfInvestment.equalsIgnoreCase("stock") || typeOfInvestment.equalsIgnoreCase("S")){

                //if check equals to "existsMutualFund"
                if(check.equals("existsMutualFund")){

                    System.out.println("TESTING5");


                    //System.out.println(" ");
                    //System.out.println("\nERROR! This symbol already exsists in Mutual Fund Investements! Please Try Again!");
                    //System.out.println(" ");

                    messageA.append("\n");

                    messageA.append("\nERROR! This symbol already exsists in Mutual Fund Investements! Please Try Again!");

                    //System.exit(0);
                    symbolF.setText("");   // Clear symbol field
                    nameF.setText("");     // Clear name field
                    quantityF.setText(""); // Clear quantity field
                    priceF.setText("");    // Clear price field
                    
                }
    
                //if check equals to "existsStock"
                if(check.equals("existsStock")){
                    System.out.println("TESTING6");

                    break;
                }
    
                //if check equals to "doesNotExist"
                if(check.equals("doesNotExist")){
                    System.out.println("TESTING7");

                    break;
                }

            } 


            //if the user entered "Mutual Fund" or "M" ignoring the lower/upper cases
            if(typeOfInvestment.equalsIgnoreCase("mutual fund") || typeOfInvestment.equalsIgnoreCase("M")){

                //if check equals to "existsStock"
                if(check.equals("existsStock")){

                    System.out.println("TESTING 100");
                    //System.out.println("ERROR! This symbol already exsists in Stock Investements! Please Try Again!");
                    //System.out.println(" ");

                    messageA.append("\n");

                    messageA.append("ERROR! This symbol already exsists in Stock Investements! Please Try Again!");
                    symbolF.setText("");   // Clear symbol field
                    nameF.setText("");     // Clear name field
                    quantityF.setText(""); // Clear quantity field
                    priceF.setText("");    // Clear price field

                }
    
                //if check equals to "existsMutualFund"
                if(check.equals("existsMutualFund")){
                    break;
                }
    
                //if check equals to "doesNotExist"
                if(check.equals("doesNotExist")){
                    break;
                }

            }

        } //end of while loop



        //checker's I used to identify the different cases, similar to what I did in A1
        boolean checker = false;
        boolean secondChecker = false;


        //Case 1 - When there is no other stock or mutual fund in the ArrayList, enter the if statement 
        if(investment.isEmpty()){

            //if the user entered "Stock" or "S" ignoring the lower/upper cases
            if(typeOfInvestment.equalsIgnoreCase("stock") || typeOfInvestment.equalsIgnoreCase("S")){


                //secondChecker will change from false to true, meaning it will not enter the next if statement
                secondChecker = true;

                //Ask user to enter the stock name
                //System.out.println(" ");
                //System.out.println("Please Enter the Name of the Stock You Would Like to Buy: ");
                //System.out.println(" ");
                //name = scanner.nextLine();

                //int quantity;

                while(true){

                    try{

                        //Ask user to enter the stock quanity (amount of shares they would like to buy)
                        //System.out.println(" ");
                        //System.out.println("Please Enter the Quantity (shares) of the Stock you Would Like to Buy: ");
                        //System.out.println(" ");
                        //quantity = scanner.nextInt();

                        if(0 < quantity){
                            break;
                            
                        }else{
                            messageA.append("Error, Please Enter a Valid Quantity!");
                            System.out.println("Error, Please Enter a Valid Quantity!");
                        }


                    } catch(InputMismatchException e){
                        System.out.println("Error, Please Enter a Valid Quantity!");
                        scanner.nextLine();
                    }
                
                } //end of while loop
            

                //Ask user to enter the stock price, which is the price of one share 
                //System.out.println(" ");
                //System.out.println("Please Enter the Stock Price (DO NOT ENTER DOLLAR SIGN): ");
                //System.out.println(" ");
                //double price = scanner.nextDouble();

                double bookValue = (price * quantity) + 9.99;

                //add to the arraylist using Stock subclass
                investment.add(new Stock(symbol, name, quantity, price, bookValue));
               

                //Update HashMap Index-----------------------------

                //switch to lower case as per instrucitons
                name.toLowerCase();
                
                //store the user given name into keywordName, it can be multiple words
                String[] keywordName = name.split(" ");
                

                //need to find a number that represetns the position of the investment 
                //investmentPostion will be used to add the index/postion to the arraylist
                int investmentPostion = investment.size() - 1;
                //int investmentPostion = 0;

                //int position = investmentPostion++;

                //System.out.println("TESTING: " + Arrays.toString(keywordName));

                ArrayList<Integer> positions;
                
                //iterate through the keywordName array
                for(String key : keywordName){

                    //check if keywords (name) is in the map, this I learned from the slide deck
                    if(keywordSearch.containsKey(key)){

                        //stores the values/postions from the corresponding name in the hashmap into positions variable
                        positions = keywordSearch.get(key);

                    }
                    //if the key word is not contained in the hashmap
                    else{

                        //than create and add a new arraylist and assign it to postions varaible
                        positions = new ArrayList<Integer>();

                    }

                    //keywordSearch.put(name, 5);

                    //add the position to the arraylist to keep track of indexes
                    positions.add(investmentPostion);

                    //store the key(name) and the index assioted with the name into the hashmap
                    keywordSearch.put(key, positions);

                    //System.out.println(keywordSearch);

                    //investmentPostion++;

                }
                

                //Finished Updating HashMap Index-----------------------

        
                for(Investment invest : investment){

                    invest.getBookValue();
                    
                }

                String format = String.format("%.2f", bookValue);
                System.out.println(" ");
                System.out.printf("The BookValue Is: $" + format);
                System.out.println(" ");

                messageA.append("\n");

                messageA.append("\nSymbol: " + symbol);
                messageA.append("\nName: " + name);
                messageA.append("\nQuantity: " + quantity);
                messageA.append("\nPrice: " + price);
                messageA.append("\nThe BookValue Is: $" + format);


            
            } //end of buy stock

            //if the user entered "Mutual Fund" or "M" ignoring the lower/upper cases
            if(typeOfInvestment.equalsIgnoreCase("Mutual Fund") || typeOfInvestment.equalsIgnoreCase("M")){

                secondChecker = true;

                //Ask user to enter the stock name
                //System.out.println(" ");
                //System.out.println("Please Enter the Name of the Mutual Fund You Would Like to Buy: ");
                //System.out.println(" ");
                //String name = scanner.nextLine();


                //Ask user to enter the stock quanity (amount of shares they would like to buy)
                //System.out.println(" ");
                //System.out.println("Please Enter the Quantity of the Mutual Fund you Would Like to Buy: ");
                //System.out.println(" ");
                //quantity = scanner.nextInt();

                //Ask user to enter the stock price, which is the price of one share 
                //System.out.println(" ");
                //System.out.println("Please Enter the Mutual Fund Price (DO NOT ENTER DOLLAR SIGN): ");
                //System.out.println(" ");
                //double price = scanner.nextDouble();

                double bookValue = price * quantity;

                investment.add(new MutualFund(symbol, name, quantity, price, bookValue));


                //Update HashMap Index-----------------------------

                //switch to lower case as per instrucitons
                name.toLowerCase();
                
                //store the user given name into keywordName, it can be multiple words
                String[] keywordName = name.split(" ");
                

                //need to find a number that represetns the position of the investment 
                //investmentPostion will be used to add the index/postion to the arraylist
                int investmentPostion = investment.size() - 1;
                //int investmentPostion = 0;

                //int position = investmentPostion++;

                //System.out.println("TESTING: " + Arrays.toString(keywordName));

                ArrayList<Integer> positions;
                
                //iterate through the keywordName array
                for(String key : keywordName){

                    //check if keywords (name) is in the map, this I learned from the slide deck
                    if(keywordSearch.containsKey(key)){

                        //stores the values/postions from the corresponding name in the hashmap into positions variable
                        positions = keywordSearch.get(key);

                    }

                    //if the key word is not contained in the hashmap
                    else{

                        //than create and add a new arraylist and assign it to postions varaible
                        positions = new ArrayList<Integer>();

                    }

                    //keywordSearch.put(name, 5);

                    //add the position to the arraylist to keep track of indexes
                    positions.add(investmentPostion);

                    //store the key(name) and the index assioted with the name into the hashmap
                    keywordSearch.put(key, positions);

                    System.out.println(keywordSearch);

                    //investmentPostion++;

                }
                
                //Finished Updating HashMap Index-----------------------

                for(Investment invest : investment){

                
                    //bookValueTotal = bookValueTotal + testingM.getBookValue();
                
                    invest.getBookValue();
                    
                }
            
                String format = String.format("%.2f", bookValue);
                System.out.println(" ");
                System.out.printf("The BookValue Is: $" + format);
                System.out.println(" ");

                messageA.append("\n");

                messageA.append("\nSymbol: " + symbol);
                messageA.append("\nName: " + name);
                messageA.append("\nQuantity: " + quantity);
                messageA.append("\nPrice: " + price);
                
                messageA.append("\nThe BookValue Is: $" + format);


            }


        }


        //Adding shares to a stock or mutual fund that is already in the list, than enter the if statement 
        if(secondChecker == false){

            //if the user entered "Stock" or "S" ignoring the lower/upper cases
            if(typeOfInvestment.equalsIgnoreCase("stock") || typeOfInvestment.equalsIgnoreCase("S")){

                // Will not enter for loop if the arraylist is empty, so when user enters stock
                // for first time, the program will end without entering for loop
                for (Investment invest : investment) {

                    if(invest instanceof Stock){

                        // if symbol already exsists, then we only need to change the quantity
                        if (invest.getSymbol().equalsIgnoreCase(symbol)) {

                            // checker will change from false to true, this means it won't enter the next if
                            // statement
                            checker = true;

                            //int newQuantity;

                            // Ask user to enter the stock quanity (amount of shares they would like to buy)
                            //System.out.println(" ");
                            //System.out.println("Please Enter the Quantity (Shares) you Would Like to Add to the Current Stock: ");
                            //System.out.println(" ");
                            //newQuantity = scanner.nextInt();

                            // Ask user to enter the price you would like to buy each share at
                            //System.out.println(" ");
                            //System.out.println("Please Enter the Price you Would Like to Buy Each Share At (DO NOT ENTER DOLLAR SIGN): ");
                            //System.out.println(" ");
                            //double buyPrice = scanner.nextDouble();

                            // sets the new value
                            // the new quantity for that stock will be new plus old/current quantity

                            invest.setQuantity(quantity + invest.getQuantity());

                            invest.setPrice(price);

                            // test.setBookValue(bookValueTotal);

                            // double bookValueTotal = 0;

                            double bookValue = (price * quantity) + 9.99;

                            // System.out.println("The bookValue TEST is: " + bookValue);

                            double bookValueTotal = invest.getBookValue() + bookValue;

                            invest.setBookValue(bookValueTotal);

                            String format = String.format("%.2f", invest.getBookValue());
                            System.out.println(" ");
                            System.out.printf("The BookValue Is: $" + format);
                            System.out.println(" ");

                            System.out.println("\nThe New Quantity Is " + invest.getQuantity());

                            messageA.append("\n");

                            messageA.append("\nThe BookValue Is: $" + format);

                            messageA.append("\nThe New Quantity Is " + invest.getQuantity());
                            
                        

                            break;

                        }


                    }

                    

                }

            }


            //if the user entered "Mutual Fund" or "M" ignoring the lower/upper cases
            if(typeOfInvestment.equalsIgnoreCase("Mutual Fund") || typeOfInvestment.equalsIgnoreCase("M")){


                //will not enter for loop if the arraylist is empty, so when user enters stock for first time, the program will end without entering for loop
                for(Investment invest : investment){

                    if(invest instanceof MutualFund){

                        //if symbol already exsists, then we only need to change the quantity
                        if(invest.getSymbol().equalsIgnoreCase(symbol)){

                            checker = true;

                            //System.out.printf("The bookValueTotal IS: " + test.getBookValue());


                            //Ask user to enter the stock quanity (amount of shares they would like to buy)
                            //System.out.println(" ");
                            //System.out.println("Please Enter the Quantity you Would Like to Add to the Current Mutual Fund: ");
                            //System.out.println(" ");
                            //int newQuantity = scanner.nextInt();
                            
                            //Ask user to enter the price you would like to buy each share at
                            //System.out.println(" ");
                            //System.out.println("Please Enter the Price you Would Like to Buy Each Share At (DO NOT ENTER DOLLAR SIGN): ");
                            //System.out.println(" ");
                            //double buyPrice = scanner.nextDouble();
                            
                            //sets the new value
                            //the new quantity for that stock will be new plus old/current quantity

                            invest.setQuantity(quantity + invest.getQuantity());
                            
                            invest.setPrice(price);

                            //test.setBookValue(bookValueTotal);

                            //double bookValueTotal = 0;

                
                            double bookValue = (price * quantity);


                            double bookValueTotal = invest.getBookValue() + bookValue;
                    
                            
                            invest.setBookValue(bookValueTotal);


                            String format = String.format("%.2f", invest.getBookValue());
                            System.out.println(" ");
                            System.out.printf("The BookValue Is: $" + format);
                            System.out.println(" ");
                            
                            System.out.println("\nThe new quantity is " + invest.getQuantity());

                            messageA.append("\n");

                            messageA.append(" ");


                            messageA.append("T\nhe BookValue Is: $" + format);

                            messageA.append("\nThe New Quantity Is " + invest.getQuantity());

                            messageA.append(" ");



                            break;
                    
                        }

                    }

                }

            }
        

            //Adding a new stock that is not in the list, enter if the checker is false meaning the other if statements did not pass the case 
            if(checker == false){

                //if the user entered "Stock" or "S" ignoring the lower/upper cases
                if(typeOfInvestment.equalsIgnoreCase("Stock") || typeOfInvestment.equalsIgnoreCase("S")){

                    //int quantity;

                    System.out.println(" ");
                    System.out.println("Stock is Not Found in The Current System. You Can Now Proceed to Buy the Stock!");
                    System.out.println(" ");

            
                    //System.out.println(" ");
                    //System.out.println("Please Enter the Name of the Stock you Would Like to Buy: ");
                    //System.out.println(" ");
                    //String name = scanner.nextLine();
            
            
                    //Ask user to enter the stock quanity (amount of shares they would like to buy)
                    //System.out.println(" ");
                    //System.out.println("Please Enter the Quantity of the Stock you Would Like to Buy: ");
                    //System.out.println(" ");
                    //quantity = scanner.nextInt();


                    //Ask user to enter the stock price, which is the price of one share 
                    //System.out.println(" ");
                    //System.out.println("Please Enter the Price you Would Like to Buy Each Share At (DO NOT ENTER DOLLAR SIGN): ");
                    //System.out.println(" ");
                    //double price = scanner.nextDouble();

                    double bookValue = (price * quantity) + 9.99;
            
                    investment.add(new Stock(symbol, name, quantity, price, bookValue));
        
                    //this is calcualted automatically
                    //Ask user to enter the stock symbol
                    //System.out.println(" ");

                    // HashMap<String, ArrayList<Integer>> keywordSearch = new HashMap<>();

                    //int investmentPostion = 0;

                    //Update HashMap Index-----------------------

                    //switch to lower case as per instrucitons
                    name.toLowerCase();
                    
                    //store the user given name into keywordName, it can be multiple words
                    String[] keywordName = name.split(" ");
                    

                    //need to find a number that represetns the postion of the investment 
                    int investmentPostion = investment.size() - 1;
                    //int investmentPostion = 0;

                    //int position = investmentPostion++;

                    //System.out.println("TESTING: " + Arrays.toString(keywordName)); 

                    ArrayList<Integer> positions;
                    
                    //iterate through the keywordName array
                    for(String key : keywordName){

                        //check if keywords (name) is in the map, this I learned from the slide deck
                        if(keywordSearch.containsKey(key)){

                            //stores the values/postions from the corresponding name in the hashmap into positions variable
                            positions = keywordSearch.get(key);

                        }

                        //if it is not contained in the hashmap
                        else{

                            //than create and add a new arraylist and assign it to postions varaible
                            positions = new ArrayList<Integer>();

                        }

                        //keywordSearch.put(name, 5);

                        //add the position to the arraylist to keep track of indexes
                        positions.add(investmentPostion);

                        //store the key(name) and the index assioted with the name into the hashmap
                        keywordSearch.put(key, positions);


                        //System.out.println(keywordSearch);

                        //investmentPostion++;

                    }
                

                    //Finished Updating HashMap Index-----------------------

    
            
                    for(Investment invest : investment){
            
                        //bookValueTotal += testing.getBookValue();

                        //bookValueTotal = testing.getBookValue() + bookValueTotal;

                        invest.getBookValue();
        
                    }

                    String format = String.format("%.2f", bookValue);
                    System.out.println(" ");
                    System.out.printf("The BookValue Is: $" + format);
                    System.out.println(" ");

                    messageA.append("\n");


                    messageA.append("\nSymbol: " + symbol);
                    messageA.append("\nName: " + name);
                    messageA.append("\nQuantity: " + quantity);
                    messageA.append("\nPrice: " + price);

                    messageA.append("\nThe BookValue Is: $" + format);

                    
                }

                //if the user entered "Mutual Fund" or "M" ignoring the lower/upper cases
                if(typeOfInvestment.equalsIgnoreCase("Mutual Fund") || typeOfInvestment.equalsIgnoreCase("M")){


                    System.out.println(" ");
                    System.out.println("Mutual Fund Not Found in The Current System. You Can Now Proceed to Buy the Mutual Fund!");
                    System.out.println(" ");

                    messageA.append("\n");
                    messageA.append("Mutual Fund Not Found in The Current System. You Can Now Proceed to Buy the Mutual Fund!");
                    messageA.append("\n");
    
        
                   // System.out.println(" ");
                    //System.out.println("Please Enter the Name of the Mutual Fund you Would Like to Buy: ");
                    //System.out.println(" ");
                    //String name = scanner.nextLine();
        
        
                    //Ask user to enter the stock quanity (amount of shares they would like to buy)
                    //System.out.println(" ");
                    //System.out.println("Please Enter the Quantity of the Mutual Fund you Would Like to Buy: ");
                    //System.out.println(" ");
                    //int quantity = scanner.nextInt();
        
                    //Ask user to enter the stock price, which is the price of one share 
                    //System.out.println(" ");
                    //System.out.println("Please Enter the Mutual Fund Price (DO NOT ENTER DOLLAR SIGN): ");
                    //System.out.println(" ");
                    //double price = scanner.nextDouble();
    
                    double bookValue = price * quantity;
        
                    investment.add(new MutualFund(symbol, name, quantity, price, bookValue));


                    //Update HashMap Index-----------------------

                    //switch to lower case as per instrucitons
                    name.toLowerCase();
                    
                    //store the user given name into keywordName, it can be multiple words
                    String[] keywordName = name.split(" ");
                    

                    //need to find a number that represetns the postion of the investment 
                    int investmentPostion = investment.size() - 1;
                    //int investmentPostion = 0;

                    //int position = investmentPostion++;

                    //System.out.println("TESTING: " + Arrays.toString(keywordName));

                    ArrayList<Integer> positions;

                    
                    //iterate through the keywordName array
                    for(String key : keywordName){

                        //check if keywords (name) is in the map, this I learned from the slide deck
                        if(keywordSearch.containsKey(key)){

                            //stores the values/postions from the corresponding name in the hashmap into positions variable
                            positions = keywordSearch.get(key);

                        }

                        //if it is not contained in the hashmap
                        else{

                            //than create and add a new arraylist and assign it to postions varaible
                            positions = new ArrayList<Integer>();

                        }

                        //keywordSearch.put(name, 5);

                        //add the position to the arraylist to keep track of indexes
                        positions.add(investmentPostion);

                        //store the key(name) and the index assioted with the name into the hashmap
                        keywordSearch.put(key, positions);

                        //System.out.println(keywordSearch);

                        //investmentPostion++;


                    }
                

                    //Finished Updating HashMap Index-----------------------
      
        
                    for(Investment invest : investment){
    
    
                        invest.getBookValue();
    
                    }
    

                    String format = String.format("%.2f", bookValue);
                    System.out.println(" ");
                    System.out.printf("The BookValue Is: $" + format);
                    System.out.println(" ");

                    messageA.append("\n");


                    messageA.append("\nSymbol: " + symbol);
                    messageA.append("\nName: " + name);
                    messageA.append("\nQuantity: " + quantity);
                    messageA.append("\nPrice: " + price);

                    messageA.append("\nThe BookValue Is: $" + format);



                }

            }

            
        }


    } //End of buyInvestment function



    /**
     * to check if tyhe if selling full or partial
     * 
     * @param quanitity the quantiy
     * @param symbol the symbol
     * @return quant
     */

    public int quantChecker(int quanitity, String symbol){

        for(Investment invest : investment){


            if(invest.getSymbol().equals(symbol)){

                if(invest instanceof Stock){

                    Stock stock = (Stock) invest;

                    int quant = stock.getQuantity();

                    return quant;

                }

                if(invest instanceof MutualFund){

                    MutualFund mutualFund = (MutualFund) invest;

                    int quant = mutualFund.getQuantity();

                    return quant;


                }

            }

        }


        return 0;


    }





    /**
     * Function to sell an investment (either stock or mutual fund) from the Investment array list
     * 
     * @param symbol the symbol
     * @param quantity the quantity
     * @param price the price
     * @param messageA the message area
     * 
     */
    public void sellInvestment(String symbol, int quantity, double price, JTextArea messageA){


        Scanner scanner = new Scanner(System.in);
        //String symbol;

        //String typeOfInvestmentSelling;


        String typeOfInvestmentSelling = checker(symbol);
        System.out.println("Checker result: " + typeOfInvestmentSelling); 


        String sellingType= "";
        int quantChecker = quantChecker(quantity, symbol);

        

            if(quantChecker == quantity){

                System.out.println("fully");

                sellingType = "fully";

            }
            else if(quantChecker != quantity){

                System.out.println("Partially");

                sellingType = "Partially";

            }


        //if the user entered "Stock" or "S" ignoring the lower/upper cases
        if(typeOfInvestmentSelling.equalsIgnoreCase("existsStock")){


            //If user wants to PARTIALLY Sell the Stock
            if(sellingType.equalsIgnoreCase("Partially") || sellingType.equalsIgnoreCase("P")){

                for(Investment invest : investment){

                        //Selling is only possible if the the available quantity is greater or equal to the requested selling quantity
                        if(invest.getQuantity() >= quantity){

                            int newQuantity = invest.getQuantity() - quantity;

                            //double newPrice = test.getPrice() - sellPrice;
                            invest.setPrice(price);

                            //payment 
                            double payment = (quantity * price) - 9.99;

                            //remining quanitity
                            int remainingQuantity = newQuantity;


                            double bookValueRemaining = invest.getBookValue() * ((double)(newQuantity / (double)invest.getQuantity()));


                            double bookValueSold = invest.getBookValue() - bookValueRemaining;
                            

                            double gain = payment - bookValueSold;

                            invest.setQuantity(remainingQuantity);
                            invest.setBookValue(bookValueRemaining);


                            String formatPayment = String.format("%.2f", payment);
                            String formatRemainingBookValue = String.format("%.2f", invest.getBookValue());
                            String formatBookValueSold = String.format("%.2f", bookValueSold);
                            String formatGain = String.format("%.2f", gain);


                            System.out.println(" ");
                            System.out.println("\nPayment is: $" + formatPayment);
                            System.out.println("\nRemaining Quantity: " + invest.getQuantity());
                            System.out.printf("\nYour Book Value remaining is: $" + formatRemainingBookValue);
                            System.out.printf("\nYour Book Value Sold is: $" + formatBookValueSold);
                            System.out.printf("\nYour Gain is: $" + formatGain);
                            System.out.println(" ");

                            messageA.append(" ");
                            messageA.append("\nPayment is: $" + formatPayment);
                            messageA.append("\nRemaining Quantity: " + invest.getQuantity());
                            messageA.append("\nYour Book Value remaining is: $" + formatRemainingBookValue);
                            messageA.append("\nYour Book Value Sold is: $" + formatBookValueSold);
                            messageA.append("\nYour Gain is: $" + formatGain);
                            messageA.append(" ");
                            break;

                        }

                        else{

                            System.out.println("Can't sell the shares you dont have!");

                        }

        
        
                }

            }

            int postionRemove = 0;

            //If user wants to FULLY sell the stock 
            if(sellingType.equalsIgnoreCase("Fully") || sellingType.equalsIgnoreCase("F")){

                for(Investment invest : investment){

                    if(invest.getSymbol().equalsIgnoreCase(symbol)){

                        //System.out.println(" ");
                        //System.out.println("What is The Stock Price to Sell At (DO NOT ENTER DOLLAR SIGN): ");
                        //System.out.println(" ");
                        //double sellPrice = scanner.nextDouble();

                        double payment = invest.getQuantity() * price - 9.99;


                        double gain = payment - invest.getBookValue();

                        String formatPayment = String.format("%.2f", payment);
                        String formatGain = String.format("%.2f", gain);
                    
                        System.out.printf("\nPayment: $" + formatPayment);
                        System.out.printf("\nGain: $" + formatGain);

                        messageA.append("\n");
                        messageA.append("\nPayment: $" + formatPayment);
                        messageA.append("\nGain: $" + formatGain);
                        messageA.append("\n");


                        //postionRemove = investment.indexOf(invest);
                        
                        investment.remove(invest);

                        break;

                    }

                    else{
                        System.out.println("This symbol does not exsits");
                    }


                }

            }


            //Update Index for Selling------------------------------

            //clear the hashmap so all the keyowrds including the ones from the deleted investment will be gone
            keywordSearch.clear();


            int investmentPostion =  0;

            //Update HashMap Index-----------------------------

            for(Investment invest : investment){

                //switch to lower case as per instrucitons
                String name = invest.getName().toLowerCase();
                
                //store the user given name into keywordName, it can be multiple words
                String[] keywordName = name.split(" ");
                
                //int position = investmentPostion++;

                //System.out.println("TESTING: " + Arrays.toString(keywordName));

                ArrayList<Integer> positions;
                
                for(String key : keywordName){

                    //check if keywords (name) is in the map, this I learned from the slide deck
                    if(keywordSearch.containsKey(key)){

                        positions = keywordSearch.get(key);

                    }

                    //if it is not contained in the map
                    else{

                        //than create and add a new 
                        positions = new ArrayList<Integer>();

                    }

                    //keywordSearch.put(name, 5);

                    //add the position to the arraylist to keep track of indexes
                    positions.add(investmentPostion);

                    //store the key(name) and the index assioted with the name into the hashmap
                    keywordSearch.put(key, positions);

                    //System.out.println(keywordSearch);

                }

                investmentPostion++;

            }
            //End of Updating Index for Selling------------------------------

        }



        //if the user entered "Mutual Fund" or "M" ignoring the lower/upper cases
        if(typeOfInvestmentSelling.equalsIgnoreCase("existsMutualFund")){


            //If user wants to PARTIALY sell the Mutual Fund
            if(sellingType.equalsIgnoreCase("Partially") || sellingType.equalsIgnoreCase("P")){

                for(Investment invest : investment){

                    //selling is only possible if the the available quantity is greater or equal to the requested selling quantity
                        if(invest.getQuantity() >= quantity){

                            int newQuantity = invest.getQuantity() - quantity;

                            double payment = (quantity * price) - 45.00;


                            //remining quanitity
                            int remainingQuantity = newQuantity;


                            double bookValueRemaining = invest.getBookValue() * ((double)(newQuantity / (double)invest.getQuantity()));


                            double bookValueSold = invest.getBookValue() - bookValueRemaining;
                            //test.setBookValue(bookValueRemaining);

                            double gain = payment - bookValueSold;

                            invest.setQuantity(remainingQuantity);
                            invest.setBookValue(bookValueRemaining);
                            invest.setPrice(price);



                            String formatPayment = String.format("%.2f", payment);
                            String formatRemainingBookValue = String.format("%.2f", invest.getBookValue());
                            String formatBookValueSold = String.format("%.2f", bookValueSold);
                            String formatGain = String.format("%.2f", gain);


                            System.out.println("\nPayment is: $" + formatPayment);
                            System.out.println("\nRemaining Quantity: " + invest.getQuantity());
                            System.out.printf("\nYour Book Value remaining is: $" + formatRemainingBookValue);
                            System.out.printf("\nYour Book Value Sold is: $" + formatBookValueSold);
                            System.out.printf("\nYour Gain is: $" + formatGain);

                            messageA.append(" ");
                            messageA.append("\nPayment is: $" + formatPayment);
                            messageA.append("\nRemaining Quantity: " + invest.getQuantity());
                            messageA.append("\nYour Book Value remaining is: $" + formatRemainingBookValue);
                            messageA.append("\nYour Book Value Sold is: $" + formatBookValueSold);
                            messageA.append("\nYour Gain is: $" + formatGain);
                            messageA.append(" ");

                            break;

                        }
                        else{
                            System.out.println("Can't sell the shares you dont have!");

                        }

        
                    
                 
        
                }

            }

            int postionRemove = 0;

            //If user wants to FULLY sell the Mutual Fund
            if(sellingType.equalsIgnoreCase("Fully") || sellingType.equalsIgnoreCase("F")){

                for(Investment invest : investment){

                    if(invest.getSymbol().equalsIgnoreCase(symbol)){

                        //System.out.println(" ");
                        //System.out.println("What is the Mutual Fund Price to Sell At: ");
                        //System.out.println(" ");
                        //double sellPrice = scanner.nextDouble();

                        double payment = (invest.getQuantity() * price) - 45.00;

                        double gain = payment - invest.getBookValue();

                    
                        System.out.printf("\nPayment: " + payment);
                        System.out.printf("\nGain: " + gain);

                        messageA.append("\n");
                        messageA.append("\nPayment: " + payment);
                        messageA.append("\nGain: " + gain);
                        messageA.append("\n");


                        System.out.println("TESTING1");

                        postionRemove = investment.indexOf(invest);

                        System.out.println("TESTING2");
                        
                        investment.remove(invest);

                        System.out.println("TESTING4");

                        break;

                    }

                    else{
                        System.out.println("This Symbol does not Exist!");
                    }



                }

            }


            //Update Index for Selling------------------------------

            keywordSearch.clear();

            int investmentPostion =  0;

            //Update HashMap Index-----------------------------

            for(Investment invest : investment){

                //switch to lower case as per instrucitons
                String name = invest.getName().toLowerCase();
                
                //store the user given name into keywordName, it can be multiple words
                String[] keywordName = name.split(" ");
                

                //need to find a number that represetns the postion of the investment 
                //int investmentPostion = investment.size() - 1;

                //int position = investmentPostion++;

                //System.out.println("TESTING: " + Arrays.toString(keywordName));

                ArrayList<Integer> positions;
                
                for(String key : keywordName){

                    //check if keywords (name) is in the map, this I learned from the slide deck
                    if(keywordSearch.containsKey(key)){

                        positions = keywordSearch.get(key);

                    }

                    //if it is not contained in the map
                    else{

                        //than create and add a new 
                        positions = new ArrayList<Integer>();

                    }


                    //keywordSearch.put(name, 5);

                    //add the position to the arraylist to keep track of indexes
                    positions.add(investmentPostion);

                    //store the key(name) and the index assioted with the name into the hashmap
                    keywordSearch.put(key, positions);

                    //System.out.println(keywordSearch);


                } //end of for loop

                investmentPostion++;

            
            //End of Updating Index for Selling------------------------------
            }

        } 

    } //End of sellInvestment function 



    //---------------------------------------------------------------------------------------------------------------------------------------------------- 
    /**
     * 
     * (3) - Users can update the prices of either all their Stocks or all their Mutual Funds, this function will update all prices of choosen investment
     * @param symbol the symbol
     * @param name the name
     * @param price the price
     * @param messageA the message area
     */
    public void updateInvestment(String symbol, String name, double price, JTextArea messageA){


        Scanner scanner = new Scanner(System.in);

        String typeOfInvestmentUpdating;

        
        //if the user entered "Stock" or "S" ignoring the lower/upper cases
        //if(typeOfInvestmentUpdating.equalsIgnoreCase("Stock") || typeOfInvestmentUpdating.equalsIgnoreCase("S")){


            for(Investment invest : investment){

                if(invest instanceof Stock){

                    //String formatPrice = String.format("%.2f", invest.getPrice());
                    //String formatBookValue = String.format("%.2f", invest.getBookValue());
                    
                    if(invest.getSymbol().equalsIgnoreCase(symbol)){


                        //new price
                        invest.setPrice(price);

                        priceF.setText(String.format("%.2f", invest.getBookValue()));

                        //BookValue will NOT Change 
                        //String formatNewBookValue = String.format("%.2f", invest.getBookValue());
                    
                        return;

                    }

                }

                if(invest instanceof MutualFund){


                    if(invest.getSymbol().equalsIgnoreCase(symbol)){


                        //new price
                        invest.setPrice(price);

                        priceF.setText(String.format("%.2f", invest.getBookValue()));


                        //BookValue will NOT Change 
                        //String formatNewBookValue = String.format("%.2f", invest.getBookValue());
                    
                        return;

                    }


                }


                
    
            }

        



    } //End of update investment function



    // -------------------------------------------------------------------------- 
    /**
     * (4) - Function to calculate total gain from all Investments. Users will be displayed with their total gain from both Stocks and Mutual Funds - Total calculation will be done in main 
     * 
     * @return gain
     */ 
    public double getGainInvestment(){

        double investmentGain = 0;

        for(Investment invest : investment){

            if(invest instanceof Stock){

                //double payment = test.getQuantity() * sellPrice - 9.99;
                double payment = (invest.getQuantity() * invest.getPrice()) - 9.99;

                //System.out.printf("\nPayment: " + payment);

                double gain = payment - invest.getBookValue();


                investmentGain = investmentGain + gain;

            }


            if(invest instanceof MutualFund){


                //double payment = test.getQuantity() * sellPrice - 9.99;
                double payment = (invest.getQuantity() * invest.getPrice()) - 45.00;

                double gain = payment - invest.getBookValue();
                        
                investmentGain = investmentGain + gain;
                
            }

        }

        return investmentGain;


    } //End of getGainInvestment


    /**
     * this is to find the indivudal gain
     * 
     * @return indvidual gain
    */
    public double getIndInvestment(){

        double investmentGain = 0;

        for(Investment invest : investment){

            if(invest instanceof Stock){

                //double payment = test.getQuantity() * sellPrice - 9.99;
                double payment = (invest.getQuantity() * invest.getPrice()) - 9.99;

                //System.out.printf("\nPayment: " + payment);

                double gain = payment - invest.getBookValue();


                investmentGain = investmentGain + gain;

                return investmentGain;

            }


            if(invest instanceof MutualFund){


                //double payment = test.getQuantity() * sellPrice - 9.99;
                double payment = (invest.getQuantity() * invest.getPrice()) - 45.00;

                double gain = payment - invest.getBookValue();
                        
                investmentGain = investmentGain + gain;

                System.out.println("Individual Gain: " + investmentGain);

                return investmentGain;
                
            }

        }


        return 0;

    }



    /**
     * Function to search for an investment in the array list, via symbol, keyword, or price
     * 
     * @param searchSymbol the symbol to search
     * @param searchKeyword the name keyword
     * @param priceLow the low price
     * @param priceHigh the high price
     * @param messageA the message area
     * 
     */
    public void searchInvestments(String searchSymbol, String searchKeyword, String priceLow, String priceHigh, JTextArea messageA){

        System.out.println("TESTING");


        Scanner scanner = new Scanner(System.in);

        //Ask User to Enter Symbol of the Investment they would Like to Search for (They can leave this field empty)
        //System.out.println(" ");
        //System.out.println("Please Enter the Symbol of the Investment you Would Like to Search For: ");
        //System.out.println(" ");
       //String searchSymbol = scanner.nextLine();

        int symbolTest = 0;

        //Checking to see if the user entered something for the field or left it empty
        if(searchSymbol.isEmpty() || searchSymbol == null){

            //If field is empty, the "symbolTest" counter will stay at 0
            //symbolTest = 0;

        }

        //If the entered something than, the counter will increment and be 1
        else{

            symbolTest++;
            
        }

        System.out.println("SYMBOL: " + symbolTest);


        //System.out.println(" ");
        //System.out.println("Please Enter the Name of the Investment you Would Like to Search For(Enter Correct Case(Lower/Higher): ");
        //System.out.println(" ");
        //String searchKeyword = scanner.nextLine();

        
        int keywordTest = 0;

        //Checking to see if the user entered something for the field or left it empty
        if(searchKeyword.isEmpty() || searchKeyword == null){

            //If field is empty, the "keywordTest" counter will stay at 0
            //keywordTest = 0;

        }

        //If the entered something than, the counter will increment and be 1
        else{

            keywordTest++;
            
        }


        System.out.println("keyowrd TESTING: " + keywordTest);

        
       


        //the price entered by user 
        String searchPrice;

        //the lower price, so in 10-20 the 10 would be stored in this variable, for 10- the 10 would be stored, and for -10 Double.MIN_VALUE will be stored 
        double priceL = 0;

        //the higher price
        double priceH = 0;
       

        while(true){


            //Case 1 - Just a regular number, so like 10, 100, 20.00, 21.55, 1000.00, etc
            //just one digit to search for with no range, so like "10","11","10.00","500"
            //a 10 will just be [10], but a 10.5 would be [10]+(\\.[5]+)?
            if(priceLow.matches("[0-9]+(\\.[0-9]+)?") && priceHigh.matches("[0-9]+(\\.[0-9]+)?")){
        

                priceL = Double.parseDouble(priceLow);
                priceH = Double.parseDouble(priceHigh);

                if(priceL == priceH){

                    priceL = priceH;

                    break;

                }
                else if(priceL < priceH){

                    break;

                }

                //both are same
                //priceL = priceH;
                
                //priceLow = Double.parseDouble(priceLow);
                //priceHigh = priceLow;
                //System.out.println("The price match is: " + price);

                break;

            }


            //Case 2 - The digit or higher, so like 10-, 1000-, 2-, 2.55-, 5.43-, etc
            //The digit or higher values
            //a 10- will just be [10]+(\\.[]+)?-
            if(priceLow.matches("[0-9]+(\\.[0-9]+)?-") && priceHigh.matches("[0-9]+(\\.[0-9]+)?-")){


                String[] tokens = priceLow.split("-");
                //String[] tokens = priceLow.split("-");

                
                //store the number in priceL
                priceL = Double.parseDouble(tokens[0].trim());

                //1.7976931348623157E308, this is the largest possible double value in Java
                priceH = Double.MAX_VALUE;

                //System.out.println("Search for prices at or greater than  " + priceHigh);

                break;
               
            }

            //Case 3 - The digit or lower, so like -10, -1000, -2, -3.55, etc
            //the digit or lower values, -10
            if(priceLow.matches("-[0-9]+(\\.[0-9]+)?") && priceHigh.matches("-[0-9]+(\\.[0-9]+)?")){

                String[] tokens = priceLow.split("-");

                //4.9E-324, this is the lowest non negative value in Java 
                priceL = Double.MIN_VALUE;

                //store the number in priceH
                priceH = Double.parseDouble(tokens[1].trim());
                
                break;
            }
            

            break;
        
        }

        System.out.println("TESTING2");


        //TESTING PURPOSES
        //System.out.println("\nPrice Low: " + priceL);
        //System.out.print("\nPrice High: " + priceH);

        int priceTestLow = 0;

        //Checking to see if the user entered something for the field or left it empty
        if(priceL == 0.0){

            //If field is empty, the "priceTest" counter will stay at 0
            //keywordTest = 0;

        }
        
        //If the entered something than, the counter will increment and be 1
        else{

            priceTestLow++;
            
        }

        int priceTestHigh = 0;
        //Checking to see if the user entered something for the field or left it empty
        if(priceH == 0.0){

            //If field is empty, the "priceTest" counter will stay at 0
            //keywordTest = 0;

        }
        
        //If the entered something than, the counter will increment and be 1
        else{

            priceTestHigh++;
            
        }

        System.out.println("low price: " + priceTestLow);
        System.out.println("high price: " + priceTestHigh);



        //int caseChecker = 0;


        //For loop that goes through the Stock Investments ArrayLists
        for(Investment invest : investment){

            System.out.println("TESTING3");

            //Case 1 - If all the fields were entered
            if(symbolTest != 0 && keywordTest != 0 && priceTestLow != 0 && priceTestHigh != 0){

                System.out.println("TESTING4");


                List<Integer> positions = keywordSearch.getOrDefault(searchKeyword, new ArrayList<>());

                //System.out.println("Postion: " + positions);

                //System.out.println("Positions'" + searchKeyword + "': " + positions);

                for(int postion : positions){

                    //System.out.println("Position: " + postion);

                    System.out.println("TESTING5");

                    //System.out.println("TEST3");

                    Investment invests = investment.get(postion);

                    //System.out.println("Investmen: " + investment);

                    //if user entered name is found in the system
                    if(invest.getName().contains(searchKeyword)){
                        System.out.println("TESTING6");

                        //if the assosiated user entered symbol matches the one in the system
                        if(invest.getSymbol().equalsIgnoreCase(searchSymbol)){
                            System.out.println("TESTING7");

                            // Case 4.1 - If the price enetered was a single digit, like '10', '11', '100',
                            // '10.51', etc
                            if (priceL == priceH) {

                                System.out.println("TESTING8");

                                //if the price matches the price in the system than the Investment can be printed 
                                if (invest.getPrice() == priceL) {

                                    System.out.println(" ");
                                    System.out.println("\nName: " + invest.getName());
                                    System.out.println("\nSymbol: " + invest.getSymbol());
                                    System.out.printf("\nPrice: $" + invest.getPrice());
                                    System.out.printf("\nQuantity: " + invest.getQuantity());
                                    System.out.printf("\nBookValue: $" + invest.getBookValue());
                                    System.out.println(" ");

                                    messageA.append("\n");
                                    messageA.append("\nName: " + invest.getName());
                                    messageA.append("\nSymbol: " + invest.getSymbol());
                                    messageA.append("\nPrice: $" + invest.getPrice());
                                    messageA.append("\nQuantity: " + invest.getQuantity());
                                    messageA.append("\nBookValue: $" + invest.getBookValue());
                                    messageA.append("\n");

                                }
                            }

                            // Case 4.2 - when the highest is priceH, so like 10-, 20-
                            if (priceH == Double.MAX_VALUE) {

                                if (invest.getPrice() >= priceL) {

                                    System.out.println(" ");
                                    System.out.println("\nName: " + invest.getName());
                                    System.out.println("\nSymbol: " + invest.getSymbol());
                                    System.out.printf("\nPrice: $" + invest.getPrice());
                                    System.out.printf("\nQuantity: " + invest.getQuantity());
                                    System.out.printf("\nBookValue: $" + invest.getBookValue());
                                    //System.out.println(" jj");

                                    messageA.append("\n");
                                    messageA.append("\nName: " + invest.getName());
                                    messageA.append("\nSymbol: " + invest.getSymbol());
                                    messageA.append("\nPrice: $" + invest.getPrice());
                                    messageA.append("\nQuantity: " + invest.getQuantity());
                                    messageA.append("\nBookValue: $" + invest.getBookValue());
                                    messageA.append("\n");

                                }

                            }

                            // Case 4.3, so like -10, -20.50, -1000
                            if (priceL == Double.MIN_VALUE) {

                                if (invest.getPrice() <= priceH) {

                                    System.out.println(" ");
                                    System.out.println("\nName: " + invest.getName());
                                    System.out.println("\nSymbol: " + invest.getSymbol());
                                    System.out.printf("\nPrice: $" + invest.getPrice());
                                    System.out.printf("\nQuantity: " + invest.getQuantity());
                                    System.out.printf("\nBookvalue: $" + invest.getBookValue());
                                    //System.out.println(" bb");

                                    messageA.append("\n");
                                    messageA.append("\nName: " + invest.getName());
                                    messageA.append("\nSymbol: " + invest.getSymbol());
                                    messageA.append("\nPrice: $" + invest.getPrice());
                                    messageA.append("\nQuantity: " + invest.getQuantity());
                                    messageA.append("\nBookValue: $" + invest.getBookValue());
                                    messageA.append("\n");

                                }

                            }


                            // Case 4.4 - So like 10-20, 30.55-45.55, etc
                            if (priceL <= priceH) {

                                if (invest.getPrice() >= priceL && invest.getPrice() <= priceH) {

                                    System.out.println(" ");
                                    System.out.println("\nName: " + invest.getName());
                                    System.out.println("\nSymbol: " + invest.getSymbol());
                                    System.out.printf("\nPrice: $" + invest.getPrice());
                                    System.out.printf("\nQuantity: " + invest.getQuantity());
                                    System.out.printf("\nBookValue: $" + invest.getBookValue());
                                    //System.out.println(" late");

                                    messageA.append("\n");
                                    messageA.append("\nName: " + invest.getName());
                                    messageA.append("\nSymbol: " + invest.getSymbol());
                                    messageA.append("\nPrice: $" + invest.getPrice());
                                    messageA.append("\nQuantity: " + invest.getQuantity());
                                    messageA.append("\nBookValue: $" + invest.getBookValue());
                                    messageA.append("\n");

                                }

                            }

                
                            
        
                        }
                   

                    }

                

        


                }
            

            } //End of Case 1



            //Case 2 - If user entered nothing, and skipped all the fields, we need to print all the investments
            if(symbolTest == 0 && keywordTest == 0 && priceTestLow == 0 && priceTestHigh == 0){

                System.out.println(" ");
                System.out.println("\nYou Skipped All Fields! (All Investments were printed)");
                System.out.println("--------------------------------------------");
                System.out.println("Name: " + invest.getName());
                System.out.println("Symbol: " + invest.getSymbol());
                System.out.printf("Price: $" + invest.getPrice());
                System.out.printf("\nQuantity: " + invest.getQuantity());
                System.out.printf("\nBookValue: $" + invest.getBookValue());
                System.out.println(" ");
                System.out.println("--------------------------------------------");

                messageA.append("\n");
                messageA.append("\nYou Skipped All Fields! (All Investments were printed)");
                messageA.append("\n--------------------------------------------");
                messageA.append("\nName: " + invest.getName());
                messageA.append("\nSymbol: " + invest.getSymbol());
                messageA.append("\nPrice: $" + invest.getPrice());
                messageA.append("\nQuantity: " + invest.getQuantity());
                messageA.append("\nBookValue: $" + invest.getBookValue());
                messageA.append(" ");
                messageA.append("\n--------------------------------------------");
    
            } //End of Case 2



            //Case 3 - If a symbol was entered, and nothing else was entered 
            if(symbolTest != 0 && keywordTest == 0 && priceTestLow == 0 && priceTestHigh == 0){

                if(invest.getSymbol().equalsIgnoreCase(searchSymbol)){

                    System.out.println(" ");
                    System.out.println("\nOnly a Symbol Was Searched For!");
                    System.out.println("--------------------------------------------");
                    System.out.println("Name: " + invest.getName());
                    System.out.println("Symbol: " + invest.getSymbol());
                    System.out.printf("Price: $" + invest.getPrice());
                    System.out.printf("\nQuantity: " + invest.getQuantity());
                    System.out.printf("\nBookValue: $" + invest.getBookValue());
                    System.out.println(" ");
                    System.out.println("--------------------------------------------");

                    messageA.append("\n");
                    messageA.append("\n--------------------------------------------");
                    messageA.append("\nOnly a Symbol Was Searched For!");
                    messageA.append("\nName: " + invest.getName());
                    messageA.append("\nSymbol: " + invest.getSymbol());
                    messageA.append("\nPrice: $" + invest.getPrice());
                    messageA.append("\nQuantity: " + invest.getQuantity());
                    messageA.append("\nBookValue: $" + invest.getBookValue());
                    messageA.append(" ");
                    messageA.append("\n--------------------------------------------");
                    messageA.append("\n");


                }

            } //End of Case 3

            //System.out.println("TEST");


            //name stored in searchKeyword


            //Case 4 - If only a name keyword was entered, and nothing else was entered 
            if(symbolTest == 0 && keywordTest != 0 && priceTestLow == 0 && priceTestHigh == 0){
                //System.out.println("TEST2");

                //https://www.geeksforgeeks.org/hashmap-getordefaultkey-defaultvalue-method-in-java-with-examples/
                //returns the value in the HashMap that matches the user entered keyword
                List<Integer> positions = keywordSearch.getOrDefault(searchKeyword, new ArrayList<>());

                //System.out.println("Postion: " + positions);

                //System.out.println("Positions'" + searchKeyword + "': " + positions);


                for(int postion : positions){

                    //System.out.println("Position: " + postion);


                    //System.out.println("TEST3");

                    Investment invests = investment.get(postion);

                    //System.out.println("Investmen: " + investment);

                    if(invest.getName().equalsIgnoreCase(searchKeyword)){

                        //System.out.println("TEST4");

                        System.out.println(" ");
                        System.out.println("\nName: " + invests.getName());
                        System.out.println("\nSymbol: " + invests.getSymbol());
                        System.out.printf("\nPrice: $" + invests.getPrice());
                        System.out.printf("\nQuantity: " + invests.getQuantity());
                        System.out.printf("\nBookValue: $" + invests.getBookValue());
                        System.out.println(" ");

                        messageA.append("\n");
                        messageA.append("\n--------------------------------------------");
                        messageA.append("\nName: " + invest.getName());
                        messageA.append("\nSymbol: " + invest.getSymbol());
                        messageA.append("\nPrice: $" + invest.getPrice());
                        messageA.append("\nQuantity: " + invest.getQuantity());
                        messageA.append("\nBookValue: $" + invest.getBookValue());
                        messageA.append(" ");
                        messageA.append("\n--------------------------------------------");
                        messageA.append("\n");
        
                    }



                }

                

            } //End of Case 4


            //Case 5 - If only a price was entered, and nothing else was entered 
            if(symbolTest == 0 && keywordTest == 0 && priceTestLow != 0 && priceTestHigh != 0){

                //Case 5.1 - If the price enetered was a single digit, like '10', '11', '100', '10.51', etc
                if(priceL == priceH){

                    if(invest.getPrice() == priceL){

                        System.out.println(" ");
                        System.out.println("\nName: " + invest.getName());
                        System.out.println("\nSymbol: " + invest.getSymbol());
                        System.out.printf("\nPrice: $" + invest.getPrice());
                        System.out.printf("\nQuantity: " + invest.getQuantity());
                        System.out.printf("\nBookValue: $" + invest.getBookValue());
                        System.out.println(" ");

                        messageA.append("\n");
                        messageA.append("\nName: " + invest.getName());
                        messageA.append("\nSymbol: " + invest.getSymbol());
                        messageA.append("\nPrice: $" + invest.getPrice());
                        messageA.append("\nQuantity: " + invest.getQuantity());
                        messageA.append("\nBookValue: $" + invest.getBookValue());
                        messageA.append("\n");
        
                    }
                }

                //Case 5.2 
                if(priceH == Double.MAX_VALUE){

                    if(invest.getPrice() >= priceL){

                        System.out.println(" ");
                        System.out.println("\nName: " + invest.getName());
                        System.out.println("\nSymbol: " + invest.getSymbol());
                        System.out.printf("\nPrice: $" + invest.getPrice());
                        System.out.printf("\nQuantity: " + invest.getQuantity());
                        System.out.printf("\nBookValue: $" + invest.getBookValue());
                        //System.out.println(" jj");

                        messageA.append("\n");
                        messageA.append("\nName: " + invest.getName());
                        messageA.append("\nSymbol: " + invest.getSymbol());
                        messageA.append("\nPrice: $" + invest.getPrice());
                        messageA.append("\nQuantity: " + invest.getQuantity());
                        messageA.append("\nBookValue: $" + invest.getBookValue());
                        messageA.append("\n");


                    }

                }

                //Case 5.3  
                if(priceL == Double.MIN_VALUE){

                    if(invest.getPrice() <= priceH){

                        System.out.println(" ");
                        System.out.println("\nName: " + invest.getName());
                        System.out.println("\nSymbol: " + invest.getSymbol());
                        System.out.printf("\nPrice: $" + invest.getPrice());
                        System.out.printf("\nQuantity: " + invest.getQuantity());
                        System.out.printf("\nBookvalue: $" + invest.getBookValue());
                        //System.out.println(" bb");


                        messageA.append("\n");
                        messageA.append("\nName: " + invest.getName());
                        messageA.append("\nSymbol: " + invest.getSymbol());
                        messageA.append("\nPrice: $" + invest.getPrice());
                        messageA.append("\nQuantity: " + invest.getQuantity());
                        messageA.append("\nBookValue: $" + invest.getBookValue());
                        messageA.append("\n");


                    }

                }

                //Case 5.4  
                if(priceL <= priceH ){

                    if(invest.getPrice() >= priceL && invest.getPrice() <= priceH){

                        System.out.println(" ");
                        System.out.println("\nName: " + invest.getName());
                        System.out.println("\nSymbol: " + invest.getSymbol());
                        System.out.printf("\nPrice: $" + invest.getPrice());
                        System.out.printf("\nQuantity: " + invest.getQuantity());
                        System.out.printf("\nBookValue: $" + invest.getBookValue());
                        //System.out.println(" late");

                        messageA.append("\n");
                        messageA.append("\nName: " + invest.getName());
                        messageA.append("\nSymbol: " + invest.getSymbol());
                        messageA.append("\nPrice: $" + invest.getPrice());
                        messageA.append("\nQuantity: " + invest.getQuantity());
                        messageA.append("\nBookValue: $" + invest.getBookValue());
                        messageA.append("\n");


                    }

                }


                
            } //End of Case 5

            

            //Case 6 - If a symbol and name keyowrd were entered but no price
            if(symbolTest != 0 && keywordTest != 0 && priceTestLow == 0 && priceTestHigh == 0){


                List<Integer> positions = keywordSearch.getOrDefault(searchKeyword, new ArrayList<>());

                //System.out.println("Postion: " + positions);

                //System.out.println("Positions'" + searchKeyword + "': " + positions);


                for(int postion : positions){

                    //System.out.println("Position: " + postion);


                    //System.out.println("TEST3");

                    Investment invests = investment.get(postion);

                    //System.out.println("investmen: " + investment);


                    //System.out.println("\nNAME: " + test.getName());
                    //System.out.println("\nSYMBOL: " + test.getSymbol()); 

                    if(invest.getSymbol().equalsIgnoreCase(searchSymbol)){

                        System.out.println(" ");
                        System.out.println("\nName: " + invest.getName());
                        System.out.println("\nSymbol: " + invest.getSymbol()); 
                        System.out.printf("\nPrice: $" + invest.getPrice());
                        System.out.printf("\nQuantity: " + invest.getQuantity());
                        System.out.printf("\nBookValue: $" + invest.getBookValue());
                        System.out.println(" ");

                        messageA.append("\n");
                        messageA.append("\n--------------------------------------------");
                        messageA.append("\nName: " + invest.getName());
                        messageA.append("\nSymbol: " + invest.getSymbol());
                        messageA.append("\nPrice: $" + invest.getPrice());
                        messageA.append("\nQuantity: " + invest.getQuantity());
                        messageA.append("\nBookValue: $" + invest.getBookValue());
                        messageA.append(" ");
                        messageA.append("\n--------------------------------------------");
                        messageA.append("\n");

    
                    }    

                }

            } //End of Case 6


            //Case 7 - If a symbol and price were entered but keyword was not entered
            if(symbolTest != 0 && keywordTest == 0 && priceTestLow != 0 && priceTestHigh != 0){

                //System.out.println("CHECKING 2");


                if(invest.getSymbol().equalsIgnoreCase(searchSymbol)){

                    //System.out.println("\nNAME: " + test.getName());
                    //System.out.println("\nSYMBOL: " + test.getSymbol());


                    //Case 7.1 - If the price enetered was a single digit, like '10', '11', '100', '10.51', etc
                    if(priceL == priceH){

                        if(invest.getPrice() == priceL){

                            System.out.println(" ");
                            System.out.println("\nName: " + invest.getName());
                            System.out.println("\nSymbol: " + invest.getSymbol());
                            System.out.printf("\nPrice: $" + invest.getPrice());
                            System.out.printf("\nQuantity: " + invest.getQuantity());
                            System.out.printf("\nBookValue: $" + invest.getBookValue());
                            System.out.println(" ");


                            messageA.append("\n");
                            messageA.append("\nName: " + invest.getName());
                            messageA.append("\nSymbol: " + invest.getSymbol());
                            messageA.append("\nPrice: $" + invest.getPrice());
                            messageA.append("\nQuantity: " + invest.getQuantity());
                            messageA.append("\nBookValue: $" + invest.getBookValue());
                            messageA.append("\n");
            
                        }
                    }

                    //Case 7.2
                    if(priceH == Double.MAX_VALUE){

                        if(invest.getPrice() >= priceL){

                            System.out.println(" ");
                            System.out.println("\nName: " + invest.getName());
                            System.out.println("\nSymbol: " + invest.getSymbol());
                            System.out.printf("\nPrice: $" + invest.getPrice());
                            System.out.printf("\nQuantity: " + invest.getQuantity());
                            System.out.printf("\nBookValue: $" + invest.getBookValue());
                            //System.out.println(" jj");


                            messageA.append("\n");
                            messageA.append("\nName: " + invest.getName());
                            messageA.append("\nSymbol: " + invest.getSymbol());
                            messageA.append("\nPrice: $" + invest.getPrice());
                            messageA.append("\nQuantity: " + invest.getQuantity());
                            messageA.append("\nBookValue: $" + invest.getBookValue());
                            messageA.append("\n");


                        }

                    }

                    //Case 7.3
                    if(priceL == Double.MIN_VALUE){

                        if(invest.getPrice() <= priceH){

                            System.out.println(" ");
                            System.out.println("\nName: " + invest.getName());
                            System.out.println("\nSymbol: " + invest.getSymbol());
                            System.out.printf("\nPrice: $" + invest.getPrice());
                            System.out.printf("\nQuantity: " + invest.getQuantity());
                            System.out.printf("\nBookvalue: $" + invest.getBookValue());
                            //System.out.println(" bb");

                            messageA.append("\n");
                            messageA.append("\nName: " + invest.getName());
                            messageA.append("\nSymbol: " + invest.getSymbol());
                            messageA.append("\nPrice: $" + invest.getPrice());
                            messageA.append("\nQuantity: " + invest.getQuantity());
                            messageA.append("\nBookValue: $" + invest.getBookValue());
                            messageA.append("\n");

                        }

                    }

                    //Case 7.4
                    if(priceL <= priceH ){

                        if(invest.getPrice() >= priceL && invest.getPrice() <= priceH){

                            System.out.println(" ");
                            System.out.println("\nName: " + invest.getName());
                            System.out.println("\nSymbol: " + invest.getSymbol());
                            System.out.printf("\nPrice: $" + invest.getPrice());
                            System.out.printf("\nQuantity: " + invest.getQuantity());
                            System.out.printf("\nBookValue: $" + invest.getBookValue());
                            //System.out.println(" late");

                            messageA.append("\n");
                            messageA.append("\nName: " + invest.getName());
                            messageA.append("\nSymbol: " + invest.getSymbol());
                            messageA.append("\nPrice: $" + invest.getPrice());
                            messageA.append("\nQuantity: " + invest.getQuantity());
                            messageA.append("\nBookValue: $" + invest.getBookValue());
                            messageA.append("\n");


                        }

                    }

                    

                }


            } //End of Case 7

            
            //Case 8 - If keyword name and price were entered but no symbol
            if(symbolTest == 0 && keywordTest != 0 && priceTestLow != 0 && priceTestHigh != 0){

                List<Integer> positions = keywordSearch.getOrDefault(searchKeyword, new ArrayList<>());

                //System.out.println("Postion: " + positions);

                //System.out.println("Positions'" + searchKeyword + "': " + positions);


                for(int postion : positions){

                    //System.out.println("Position: " + postion);


                    //System.out.println("TEST3");

                    Investment invests = investment.get(postion);

                    //System.out.println("investmen: " + investment);

                    //Case 8.1 - If the price enetered was a single digit, like '10', '11', '100', '10.51', etc
                    if(priceL == priceH){

                        if(invest.getPrice() == priceL){

                            System.out.println(" ");
                            System.out.println("\nName: " + invest.getName());
                            System.out.println("\nSymbol: " + invest.getSymbol());
                            System.out.printf("\nPrice: $" + invest.getPrice());
                            System.out.printf("\nQuantity: " + invest.getQuantity());
                            System.out.printf("\nBookValue: $" + invest.getBookValue());
                            System.out.println(" ");

                            messageA.append("\n");
                            messageA.append("\n--------------------------------------------");
                            messageA.append("\nName: " + invest.getName());
                            messageA.append("\nSymbol: " + invest.getSymbol());
                            messageA.append("\nPrice: $" + invest.getPrice());
                            messageA.append("\nQuantity: " + invest.getQuantity());
                            messageA.append("\nBookValue: $" + invest.getBookValue());
                            messageA.append(" ");
                            messageA.append("\n--------------------------------------------");
                            messageA.append("\n");
            
                        }

                    }

                    //Case 8.2
                    if(priceH == Double.MAX_VALUE){

                        if(invest.getPrice() >= priceL){

                            System.out.println(" ");
                            System.out.println("\nName: " + invest.getName());
                            System.out.println("\nSymbol: " + invest.getSymbol());
                            System.out.printf("\nPrice: $" + invest.getPrice());
                            System.out.printf("\nQuantity: " + invest.getQuantity());
                            System.out.printf("\nBookValue: $" + invest.getBookValue());
                            //System.out.println(" jj");


                            messageA.append("\n");
                            messageA.append("\nName: " + invest.getName());
                            messageA.append("\nSymbol: " + invest.getSymbol());
                            messageA.append("\nPrice: $" + invest.getPrice());
                            messageA.append("\nQuantity: " + invest.getQuantity());
                            messageA.append("\nBookValue: $" + invest.getBookValue());
                            messageA.append("\n");


                        }

                    }

                    //Case 8.3
                    if(priceL == Double.MIN_VALUE){

                        if(invest.getPrice() <= priceH){

                            System.out.println(" ");
                            System.out.println("\nName: " + invest.getName());
                            System.out.println("\nSymbol: " + invest.getSymbol());
                            System.out.printf("\nPrice: $" + invest.getPrice());
                            System.out.printf("\nQuantity: " + invest.getQuantity());
                            System.out.printf("\nBookvalue: $" + invest.getBookValue());
                            //System.out.println(" bb");


                            messageA.append("\n");
                            messageA.append("\nName: " + invest.getName());
                            messageA.append("\nSymbol: " + invest.getSymbol());
                            messageA.append("\nPrice: $" + invest.getPrice());
                            messageA.append("\nQuantity: " + invest.getQuantity());
                            messageA.append("\nBookValue: $" + invest.getBookValue());
                            messageA.append("\n");

                        }

                    }

                    //Case 8.4
                    if(priceL <= priceH ){

                        if(invest.getPrice() >= priceL && invest.getPrice() <= priceH){

                            System.out.println(" ");
                            System.out.println("\nName: " + invest.getName());
                            System.out.println("\nSymbol: " + invest.getSymbol());
                            System.out.printf("\nPrice: $" + invest.getPrice());
                            System.out.printf("\nQuantity: " + invest.getQuantity());
                            System.out.printf("\nBookValue: $" + invest.getBookValue());
                            //System.out.println(" late");

                            messageA.append("\n");
                            messageA.append("\nName: " + invest.getName());
                            messageA.append("\nSymbol: " + invest.getSymbol());
                            messageA.append("\nPrice: $" + invest.getPrice());
                            messageA.append("\nQuantity: " + invest.getQuantity());
                            messageA.append("\nBookValue: $" + invest.getBookValue());
                            messageA.append("\n");



                        }

                    }


                   

                }

            } //End of Case 8


        } //End of Stock ArrayList for loop


    } //End of searchInvestments 

    
} //End of class Portfolio.java

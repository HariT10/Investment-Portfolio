# Investment-Portfolio
//By: Harishan Thilakanathan (1274198)
//Date: Friday, November 29, 2024
//Purpose: README also including my Test Plan

//------------------------------------------------------------------------------------------------------------------------------------- 

                                                    
                                                          README  


NOTE: While running the program, there still may be things printing in the terminal. This is is because I left a lot of things from A2.
      Please don't mind the terminal, the frame is working fine. Update does not work.
      Also, for search most of the cases work. Also when entering symbol please use the correct capitilization.
      Thanks.                               


HOW TO RUN THE PROGRAM?

All the files needed are: <- Located in the ePortfolio folder, which is in the folder called "hthilaka_a3"

Portfolio.java
Investment.java
Stock.java
MutualFund.java
WelcomeScreen.java
Buy.java
Sell.java
Update.java
Gain.java
Search.java
Quit.java

Step One: cd hthilaka_a3

Step Two: ePortfolio/*.java

Step Three: ePortfolio.WelcomeScreen

After this the frame should open, allowing you to use the application




(1) The General Problem you Are Trying to Solve?

The problem I am trying to solve is that I am helping investors keep track and maintain their portfolio of investments. Investors can 
have various different investments from Stocks to Mutual Funds, so it is important that they stay organized. Through my program they 
will be able to buy or sell Stocks and Mutual Funds. They will also be able to update prices as the market prices change. They can 
also search for any investments that they may want to see from Stocks to Mutual Funds. Lastly, they can view the total gains of their 
portfolio whether thats in the positives or even in the negatives. We are also helping the user save their portfolio to a text file. Using the text
file they can also load the contents back into the program when they come back. This was they wont lose any of there work. The latest update is a 
user interface added to enhance user experience.


(2) What are the assumptions and limitations of your solution?


Assumptions:

- I assumed that total gains were different for Stock and Mutual Fund, but it is actually the total of the whole investment

- I assumed that the BookValue was one value for every stock or mutual fund bought, but it is actually specfic towards the investment.
So every different Stock and Mutual Funds have different BookValues and they DO NOT add up. 

- At the start I assumed that we were supposed to have ervything in one file, but later I figured out that mutiple files is better

- I assumed that I did not have to make that many changes to the backend of my code. This was not true, because I still had to change things
so it mactched with the GUI


Limitations:

- Some limitations I had was with the search method, at first I did not know how to deal with all the prices users can enter, like 10, 10-, -10
 and 10-20. But after some digging and learning I figured it out. 

- Another limiation I had was with the hashmap. More specfically, the upgrading the index for buy and sell was difficult. But using the slides, google
and mor research, I figured it out. 

- Another limitation I had was also with the search method, but I could not figure it out. Basically, I had 4 different cases for all the different prices
 users can enter. So for example, 10-, -10, 10, 10-20. When user would enter something in the price field, I would have if statemetents that would 
 trigger if it meant one of my 4 cases. The problem was it would trigger one case (if statment) and print that investment, but it would also trigger another 
 case. I feel like I can fix this with a checker like True/False, but I just don't have enough time to go through it. So I would say the search meethod and
 time was my limitations. I also would have commented more if I had more time. 

 - Another limitation I had was that I was not that much familiar with using GUI, so I was having trouble

 - I could not finish the Update frame. I left it to the end thinking it would not be difficult to implment, but I just could not figure it out. 

 - Time was a limiation, this is because I did not have much time to work on this assignment. 



(3) How can a user build and test your program (also called the user guide)?

I have a test plan below going through my program. Users can run and test different features with the help of my Test Plan. 



(4) How is the program tested for correctness (i.e., the test plan should be part of the README file)?

I made sure to test the program for correctness when creating the Test Plan. I went through different cases of the program allowed evrything, but
I also made sure to go through things that may cause the program to output an error message and ask user to re-enter. 



(5) What possible improvements could be done if you were to do it again or have extra time
available?

There are many improvements I would do if I were to do it again or have extra time. I would add more user valadiation and more checks accross 
my whole program. This is so users do not click on anything by accident and crash the program. For example writing a letter in a field where 
the program is asking you for a number. I would make sure that even if a letter was entered that it would ask the user to re-enter. Another improvement 
I would make to my code is make it more optimal. What I mean by optimal is that, I feel like there are shorter ways code some of the methods. 
Like the search method I have a for loop that looks through the Stock ArrayList and I have another for loop that looks through the Mutual Fund ArrayList. 
This is a lot of repetitve of code. If I had more time I would figure out how to make it shorter by putting both in one. Lastly, I should have started earlier. 
This is because I feel this assignment has a lot of little details that I needed to take into consideration. I think I took into consideration most of 
the details but I feel like I may have missed some. I also could have commented more, if I managed my time properly. I also could of improved my search fucntion. 
If I had more time I would have done more debugging to improve the fucntion for all cases. Overall, these are what I would do 
if I could do it again or had more time.


                                                                TEST PLAN: (NEW)

HOW TO RUN THE PROGRAM?

All the files needed are: <- Located in the ePortfolio folder, which is in the folder called "hthilaka_a3"

Portfolio.java
Investment.java
Stock.java
MutualFund.java
WelcomeScreen.java
Buy.java
Sell.java
Update.java
Gain.java
Search.java
Quit.java

Step One: cd hthilaka_a3

Step Two: ePortfolio/*.java

Step Three: ePortfolio.WelcomeScreen

After this the frame should open, allowing you to use the application


Home:

This is where you will see the home screen, with opening messages. To go to other frames click "Commands" at the top left of the screen.

You will have 7 menu options:

Home
Buy
Sell
Update
Gain
Search
Quit


Buy:

Buy frame will give you the opportunity to buy an investment (stock or mutual fund). You must need to enter all the fileds.
You have the option to reset or buy.
After you buy, a summary of the purchase will be shown in the messages box at the bottom of the screen.

Sell:

Sell frame will give you the opportunity to sell astock or mutual fund. You must need to enter all the fileds.
You have the option to reset or buy.
After you sell, a summary of the sold shares will be shown in the messages box at the bottom of the screen. Whether thats a partial sale or fulls sale.


Update:

This frame lets you update the price of any exsisting investment.


Gain:

This frame will show you the total gain of all the investments.

It will also show the indvidiual gains of your purchases. 


Search:

This frame is to search any existing investment in your portfolio. 
You have the option to search by symbol, name keywords, low price and high price. 
You can fill and leave empty any of the fields. BUT, I recommend that you please fill the price fields. 

If your search was succesful than the results will be shown in the "Search Results" box palced at the bottom of the frame. 

Quit:

By clicking on "Quit" the program will end, and the screen will close. 







                                                            TEST PLAN: (OLD)


Main:

My main is located at the top of my Portfolio.java file. All my Buy, Sell, Update, getGain, and Search fucntions are below the main function. Along with this I have 
Investement class, Stock class, and Mutual Fund class all in seperate files.

The difference for this assignemnt is that, instead of two array lists, now there is only one arraylist. Also, now there is file input and output. So when user quits the program
all the content in the arraylists will be sent to the text file (name inputed by user in the command line). 

It will be written to the text file in this format --

type = stock , symbol = hj , name = hari thilak , quantity = 9 , price = 9.0 , bookValue = 90.99
type = mutual fund , symbol = aa , name = apple , quantity = 5 , price = 20.0 , bookValue = 100.0


Running The Program:

javac ePortfolio/*.java 

jar cvfe Portfolio.jar ePortfolio.Portfolio ePortfolio/*.class

java -jar Portfolio.jar "testing.txt"

Those are the three commands to run this program. The improtant thing to note is that you need to provide a text file.
In my example I provided "testing.txt", and make sure the text file is in quotes. 

If you do not provide a text file than the program will not run. 


HashMap:

To help show how the hasp map works with buying and selling:

If I load this into the program
type = stock , symbol = hj , name = hari thilak , quantity = 9 , price = 9.0 , bookValue = 90.99
type = mutual fund , symbol = aa , name = apple , quantity = 5 , price = 20.0 , bookValue = 100.0

The hash map will save it like this {hari=[0], apple=[1], thilak=[0]}

Than if I buy another stock with the name "nike hari", the hash map will look like this

{hari=[0, 2], apple=[1], nike=[2], thilak=[0]}

Than if I sell the stock with the name "hari thilak", the hash map will look like this 

{hari=[1], apple=[0], nike=[1]}


Buy:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

My buy method is in two parts. First in the main menu the user would have to select Buy, by typing "Buy", "buy".
After this they will be given the option of selecting if they want to buy a stock or mutual fund, they also have an option to go back to the main menu.
The user will need to type either 'Stock' for Stock OR for Mutual Fund enter 'Mutual Fund' OR 'Back' to go back to Main Menu:. You will have to type one of the options. 

If user selects the Stock option: ----------------------------------------------------------------------------------------------------------------


Case 1: Buying a new stock --------------------------------------------------------

        Please Enter the Stock Symbol you would like to buy: AA
        Please Enter the Name of the Stock You Would Like to Buy: Apple
        Please Enter the Quantity (shares) of the Stock you Would Like to Buy: 10
        Please Enter the Stock Price: 50

    Output: The BookValue Is: 509.99 



Case 2: Adding Quantity to the already exsisting stock --------------------------------------------------------

        Please Enter the Stock Symbol you would like to buy: AA
        Please Enter the quantity you would like to add to the current stock: 30
        Please Enter the price you would like to buy each share at: 20

    Output: The BookValue Is: 1119.98
            The New Quantity Is 40



Case 3: Buying another stock --------------------------------------------------------

        Please Enter the Stock Symbol you would like to buy: NKE
        Please Enter the Name of the Stock you would like to buy: Nike
        Please Enter the quantity of the stock you would like to buy: 30
        Please Enter the Stock Price: 100

    Output: The BookValue Is: 3009.99 

    As you can see the BookValue is calculated seperatley for each specific stock. 




Case 4: Buying a Stock with the same symbol of one that already exists in Mutual Funds--------------------------------------------------------

        Please Enter the Stock Symbol you Would Like to Buy: ADS

        Output: ERROR! This symbol already exsists in Mutual Fund Investements! Please Try Again!


        As you can see, since "ADS" already exists in Mutual Funds list, it did not let me buy it as a stock. I would need to enter a new symbol. 



If user selects the Mutual Fund option: ----------------------------------------------------------------------------------------------------------------



Case 1: Buying a new Mutual Fund --------------------------------------------------------

        Please Enter the Mutual Fund Symbol You Would Like to Buy: ADS
        Please Enter the Name of the Mutual Fund You Would Like to Buy: Adidas
        Please Enter the Quantity of the Mutual Fund you Would Like to Buy: 40
        Please Enter the Mutual Fund Price: 120

        Output: The BookValue Is: $4800.00 



Case 2: Buying a new Mutual Fund that already exists in Stocks --------------------------------------------------------

        Please Enter the Mutual Fund Symbol You Would Like to Buy: NKE
        
        Output: ERROR! This symbol already exsists in Stock Investements! Please Try Again!

        As you can see when I try to buy a symbol that already exists in the Stocks list, it will give me an error message, and ask me to try again. 






Sell:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

The sell method is in two parts. First in the main menu the user would have to select Sell, by typing "Sell", "sell". After this they will be given 
the option of selecting if they want to sell a stock or mutual fund, there is also an option to go back to the main menu.
The user will need to type either 'Stock' for Stock OR for Mutual Fund enter 'Mutual Fund' OR 'Back' to go back to Main Menu:. You will have to type one 
of the options. 

After this the user will be asked to enter a symbol of the stock/mutual fund they would like to sell. After the user types the symbol they would like to sell, the key selling 
feautre will show up. That is it will ask the user if they want to sell the stock/mutual fund partially or fully. Partially means they can select the amount of shares they would 
like to sell at a selected price. Fully means they will sell all the shares of that stock at a selected price. Selling fully means the stock/mutual fund will be permenatly
removed from the portfolio. 


If user selects the Stock option: ----------------------------------------------------------------------------------------------------------------



Case 1: Selling partial shares of the stock

        Please Enter the Stock Symbol you Would Like to Sell: NKE
        Would You Like to Sell the Stock Partially or Fully?
        Enter 'P'/'p' for partially OR 'F'/'f' for fully: Partially

        Output:  NKE Has 30 Shares Currently

        What is the Quantity (shares) you Would Like to Sell? 20

        What is The Stock Price to Sell At (DO NOT ENTER DOLLAR SIGN): 150

        Output: Payment is: $2990.01

                Remaining Quantity: 10

                Your Book Value remaining is: $1003.33
                Your Book Value Sold is: $2006.66
                Your Gain is: $983.35



Case 2: Selling full shares of a stock

        Please Enter the Stock Symbol you Would Like to Sell: NKE

        Would You Like to Sell the Stock Partially or Fully?
        Enter 'P'/'p' for partially OR 'F'/'f' for fully: Fully

        What is The Stock Price to Sell At (DO NOT ENTER DOLLAR SIGN): 130

        Output: Payment: $1290.01
                Gain: $286.68 



Case 3: Selling a stock that does not exist

        Please Enter the Stock Symbol you Would Like to Sell: NKE

        Output: ERROR! This symbol DOES NOT exsists in Stock Investements! Please Try Again!


        I will not be showing Selling Mutual Funds cases becuase it is similar to selling Stocks



Update:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

If user selects the update option. They will be be asked if they want to update all their stocks or all their mutual funds. If they select stocks, than they wull be 
asked to change the price of all their stock investments.

Case 1: Updating stock prices 

        Would You Like to Update Prices on All Your Stock Investments or Mutual Fund Investments?
        Enter 'Stock' for Stock OR for Mutual Fund enter 'Mutual Fund' OR 'Back' to go back to Main Menu: Stock

        ---------------------------
        Stock Symbol: AA

        Stock Name: Apple

        PRICE: $50.00
        Quantity: 10
        BookValue: $509.99
        ---------------------------

        Please Enter the New Price: 70

        -----------UPDATED PRICE-----------

        Stock Symbol: AA

        Stock Name: Apple

        PRICE: $70.00
        Quantity: 10
        BookValue: $509.99
        ------------------------------------


        Note: Here it just asked me for one stock, but if you have more stocks it will ask you to change the price of them all. 
              Similar will happen if you selected "Mutual Fund"




Get Gain:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Gain will simpily calculate the total gain of the whole portfolio, which will include both Stock and Mutual Fund. 

Case 1: Buying a stock and mutual fund than viewing the total Gain 


        Please Enter the Stock Symbol you Would Like to Buy: AA
        Please Enter the Name of the Stock You Would Like to Buy: Apple
        Please Enter the Quantity (shares) of the Stock you Would Like to Buy: 10
        Please Enter the Stock Price (DO NOT ENTER DOLLAR SIGN): 10

        Please Enter the Mutual Fund Symbol You Would Like to Buy: BI
        Please Enter the Name of the Mutual Fund You Would Like to Buy: Bike
        Please Enter the Quantity of the Mutual Fund you Would Like to Buy: 10
        Please Enter the Mutual Fund Price (DO NOT ENTER DOLLAR SIGN): 10

        The Gain of all the investments is: -64.98


Search Investment:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

For search users will have 3 fields to fill out in order for the program to search for the Stock or Mutual Fund. Symbol, name keyword, and price range.
The user can skip to enter one, two, or even all the fields. 

Something new about the search function is that we will be implementing the hashmap to search for the suer given keyword. This makes the search more effecient. 


Case 1: If all the fields were entered   <- Uses HashMap

Case 2: If user entered nothing, and skipped all the fields, we need to print all the investments

Case 3: If a symbol was entered, and nothing else was entered 

Case 4: If only a name keyword was entered, and nothing else was entered    <- Uses HashMap


Case 5: If only a price was entered, and nothing else was entered       

Case 6: If a symbol and name keyowrd were entered but no price     <- Uses HashMap


Case 7: If a symbol and price were entered but keyword was not entered


Case 8: If keyword name and price were entered but no symbol   <- Uses HashMap


These are all the cases I came up for both Stock and Mutual Fund. For each case my program will use the fields entered to search and find the 
most similar investment to the search results. 



End Program------------------------------------------

# SalesTaxProblem

Makkajai Dev challenge task - Omar Iqbal Kantroo

Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt.
Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.

When I purchase items I receive a receipt which lists the name of all the items and their price (including tax),
finishing with the total cost of the items, and the total amounts of sales taxes paid. The rounding rules for sales tax are that for a tax rate
of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.

Write an application that prints out the receipt details for these shopping baskets...

INPUT:
Input 1:

1 book at 12.49
1 music CD at 14.99
1 chocolate bar at 0.85

Input 2:

1 imported box of chocolates at 10.00
1 imported bottle of perfume at 47.50

Input 3:

1 imported bottle of perfume at 27.99
1 bottle of perfume at 18.99
1 packet of headache pills at 9.75
1 box of imported chocolates at 11.25

OUTPUT
Output 1:

1 book : 12.49
1 music CD: 16.49
1 chocolate bar: 0.85
Sales Taxes: 1.50
Total: 29.83

Output 2:

1 imported box of chocolates: 10.50
1 imported bottle of perfume: 54.65
Sales Taxes: 7.65
Total: 65.15

Output 3:

1 imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 9.75
1 imported box of chocolates: 11.85
Sales Taxes: 6.70
Total: 74.68

Introduction
This program is written by Omar Iqbal Kantroo as Makkajai sample problem

How to Run

Complile from Main.java and run the compliled code with input files in the root directory.

Complile by javac Main.java
Run by java Main

Input through console

Enter each item as : {quantity} {name with imported keyword if applicable} at {price}

Each item in above format is written one item in one line
Press ENTER and go to next line to enter another item
To end the prompt, go to new line and write end and press ENTER

Assumptions
The input text file follows the following syntax:
1 book at 12.49
qty, name, "at", price

Product Quantity is a positive integer
Price is a positive number
Items to be excluded from the goods sales tax (10%) is included in a text file called exclusions.txt placed in the input folder.
Imported items have the word imported in them.

Here is a overview of the program

Main Class

    main()

Receipt Class

    ArrayList<Product> items

    Receipt()
    addItems()
    fetchReceiptOutputLines()

Product Class

    String name
    Category category
    boolean isImported
    float basePrice
    int qty


    Product()
    createProduct()
    createProductCategory()

IO Class

    takeLinesFromIO()
    printLines()

Rounder Class

    TaxCalculator calculator

    Rounder()
    calculate()

BaseTaxCalculator Class

    Product product

    BaseTaxCalculator()
    getProduct()
    calculate()

SalesTaxCalculator Class

    TaxCalculator calculator

    SalesTaxCalculator()
    getProduct()
    calculate()

ImportTaxCalculator Class

    TaxCalculator calculator

    ImportTaxCalculator()
    getProduct()
    calculate()

SalesTaxCalculator Interface

    calculate()
    getProduct()

enum Category

    BOOK, FOOD, MEDICAL, OTHER

Product GeneralUtil

    createProductsFromLines()

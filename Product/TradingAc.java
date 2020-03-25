//package financialplanner;

public class TradingAc
{
    // instance variable
    private String name;
    private double salesRevenue;
    private double costOfGoodsSold;
    private double quantity;
    private double price;
    private double openingStock;
    private double purchases;
    private double closingStock;
    private double grossProfit;

    // 2 constructors
    public TradingAc()
    {
        name = null;
        salesRevenue = 0;
        costOfGoodsSold = 0;
        quantity = 0;
        price = 0;
        openingStock = 0;
        purchases = 0;
        closingStock = 0;
        grossProfit = 0;
    }
    
    public TradingAc(String name, double salesRevenue, double costOfGoodsSold, 
            double quantity, double price, double openingStock, double purchases, 
            double closingStock, double grossProfit)
    {
        this.name = name;
        this.salesRevenue = salesRevenue;
        this.costOfGoodsSold = costOfGoodsSold;
        this.quantity = quantity;
        this.price = price;
        this.openingStock = openingStock;
        this.purchases = purchases;
        this.closingStock = closingStock;
        this.grossProfit = grossProfit;
    }

    // mutators + accessors
    public String getName()
    {
        return name;
    }

    public void setName(String name)    
    {
        this.name = name;
    }
    
    public double getSalesRevenue()
    {
        return salesRevenue;
    }

    public void setSalesRevenue(double salesRevenue)
    {
        this.salesRevenue = salesRevenue;
    }

    public double getCostOfGoodsSold()
    {
        return costOfGoodsSold;
    }

    public void setCostOfGoodsSold(double costOfGoodsSold)
    {
        this.costOfGoodsSold = costOfGoodsSold;
    }

    public double getQuantity()
    {
        return quantity;
    }

    public void setQuantity(double quantity)
    {
        this.quantity = quantity;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public double getOpeningStock()
    {
        return openingStock;
    }

    public void setOpeningStock(double openingStock)
    {
        this.openingStock = openingStock;
    }

    public double getPurchases()
    {
        return purchases;
    }

    public void setPurchases(double purchases)
    {
        this.purchases = purchases;
    }

    public double getClosingStock()
    {
        return closingStock;
    }

    public void setClosingStock(double closingStock)
    {
        this.closingStock = closingStock;
    }
    
    public double getGrossProfit()
    {
        return grossProfit;
    }

    public void setGrossProfit(double grossProfit)
    {
        this.grossProfit = grossProfit;
    }
    
    // calculator methods
    public double calculateSalesRevenue()
    {
        double sR = getQuantity() * getPrice(); 
        return sR;
    }
    
    public double calculateCostOfGoodsSold()
    {
        double cogs = getOpeningStock()+getPurchases()-getClosingStock();
        return cogs;
    }
    
    public double calculateGrossProfit()
    {
        double gP = getSalesRevenue() - getCostOfGoodsSold();
        return gP;
    }    
}
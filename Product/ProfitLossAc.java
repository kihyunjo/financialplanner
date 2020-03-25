//package financialplanner;

public class ProfitLossAc
{
    // instance variable
    private double expenses;
    private double netProfitBefore;
    private double rent;
    private double electricity;
    private double water;
    private double internet;
    private double insurance;
    private double salary;
    private double interest;
    private double tax;
    private double netProfitBfTax;
    private double netProfitAfter;

    // 2 constructors
    public ProfitLossAc()
    {
        expenses = 0;
        netProfitBefore = 0;
        rent = 0;
        electricity = 0;
        water = 0;
        internet = 0;
        insurance = 0;
        salary = 0;
        interest = 0;
        tax = 0;
        netProfitBfTax = 0;
        netProfitAfter = 0;
    }

    public ProfitLossAc(double expenses, double netProfitBefore, double rent,
            double electricity, double water, double internet, double insurance,
            double salary, double interest, double tax, double netProfitBfTax,
            double netProfitAfter)
    {
        this.expenses = expenses;
        this.netProfitBefore = netProfitBefore;
        this.rent = rent;
        this.electricity = electricity;
        this.water = water;
        this.internet = internet;
        this.insurance = insurance;
        this.salary = salary;
        this.interest = interest;
        this.tax = tax;
        this.netProfitBfTax = netProfitBfTax;
        this.netProfitAfter = netProfitAfter;
        
    }

    // mutators + accessors
    public double getExpenses()
    {
        return expenses;
    }

    public void setExpenses(double expenses)
    {
        this.expenses = expenses;
    }

    public double getNetProfitBefore()
    {
        return netProfitBefore;
    }

    public void setNetProfitBefore(double netProfitBefore)
    {
        this.netProfitBefore = netProfitBefore;
    }

    public double getRent()
    {
        return rent;
    }

    public void setRent(double rent)
    {
        this.rent = rent;
    }

    public double getElectricity()
    {
        return electricity;
    }

    public void setElectricity(double electricity)
    {
        this.electricity = electricity;
    }

    public double getWater()
    {
        return water;
    }

    public void setWater(double water)
    {
        this.water = water;
    }

    public double getInternet()
    {
        return internet;
    }

    public void setInternet(double internet)
    {
        this.internet = internet;
    }

    public double getInsurance()
    {
        return insurance;
    }

    public void setInsurance(double insurance)
    {
        this.insurance = insurance;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public double getInterest()
    {
        return interest;
    }

    public void setInterest(double interest)
    {
        this.interest = interest;
    }

    public double getTax()
    {
        return tax;
    }

    public void setTax(double tax)
    {
        this.tax = tax;
    }

    public double getNetProfitBfTax()
    {
        return netProfitBfTax;
    }

    public void setNetProfitBfTax(double netProfitBfTax)
    {
        this.netProfitBfTax = netProfitBfTax;
    }

    public double getNetProfitAfter()
    {
        return netProfitAfter;
    }

    public void setNetProfitAfter(double netProfitAfter)
    {
        this.netProfitAfter = netProfitAfter;
    }
    
    // calculator methods
    public double calculateExpenses()
    {
        double expense = getRent() + getElectricity() + getWater() 
                + getInternet() + getInsurance() + getSalary();
        return expense;
    }
    
    public void addExpense(double exp)
    {
        setExpenses(getExpenses() + exp);
    }
    
    public double calculateNetProfitBefore(double gP)
    {
        double netProfit = gP - getExpenses();
        return netProfit;
    }
    
    public double calculateNetProfitBfTax()
    {
        double netProfit = getNetProfitBefore() - getInterest();
        return netProfit;
    }
    
    public double calculateNetProfitAfter()
    {
        double netProfit = getNetProfitBfTax() - getTax();
        return netProfit;
    }
    
    public double calculateTax(int sup, int rate)
    {
        double t = (double) sup + (getNetProfitBfTax() * rate/100);
        return t;
    }
}
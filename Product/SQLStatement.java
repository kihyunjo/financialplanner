//package financialplanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLStatement
{
    private AccessDb financialObj = new AccessDb("FinancialAccount");
    private AccessDb taxObj = new AccessDb("Tax");
    private TradingAc tradingObj;
    private ProfitLossAc profitObj;
    private ResultSet rs = null;
    private int status;
    private String dbQuery;
    private PreparedStatement s;

    private Connection financialConn = financialObj.getDbConn();
    private Connection taxConn = taxObj.getDbConn();
    
    double sr;
        double gp;
        double np;
        double cogs;

    // Database: Tax
    public int getRate(ProfitLossAc x) throws SQLException
    {
        profitObj = x;
        int rate = 0;
        double np = profitObj.getNetProfitBfTax();

        dbQuery = "SELECT Rate FROM TaxRange " + "WHERE Minimum <= ? " + "AND Maximum > ?";
        s = taxConn.prepareStatement(dbQuery);
        s.setDouble(1, np);
        s.setDouble(2, np);
        rs = s.executeQuery();
        while (rs.next())
        {
            rate = rs.getInt("Rate");
        }
        return rate;
    }
    
    public int getSupplementary(ProfitLossAc x) throws SQLException
    {
        profitObj = x;
        int rate = 0;
        int supplementary = 0;
        double np = profitObj.getNetProfitBfTax();

        dbQuery = "SELECT Supplementary FROM TaxRange " + "WHERE Minimum <= ? " + "AND Maximum > ?";
        s = taxConn.prepareStatement(dbQuery);
        s.setDouble(1, np);
        s.setDouble(2, np);
        rs = s.executeQuery();
        while (rs.next())
        {
            supplementary = rs.getInt("Supplementary");
        }
        return supplementary;
    }
    
    
    // Database: FinancialAccount 
    public void insertIncomeStatement(TradingAc x, ProfitLossAc y)
    {
        tradingObj = x;
        profitObj = y;

        dbQuery = "INSERT INTO IncomeStatement "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try
        {
            s = financialConn.prepareStatement(dbQuery);
            s.setString(1, tradingObj.getName());
            s.setDouble(2, tradingObj.getSalesRevenue());
            s.setDouble(3, tradingObj.getCostOfGoodsSold());
            s.setDouble(4, tradingObj.getGrossProfit());
            s.setDouble(5, profitObj.getExpenses());
            s.setDouble(6, profitObj.getNetProfitBefore());
            s.setDouble(7, profitObj.getInterest());
            s.setDouble(8, profitObj.getNetProfitBfTax());
            s.setDouble(9, profitObj.getTax());
            s.setDouble(10, profitObj.getNetProfitAfter());
            status = s.executeUpdate();
        } catch (Exception ee)
        {
            String warning = "Error Inserting into Table of Database";
            ErrorFrame errObj = new ErrorFrame(warning);
        }
    }
    
    public Boolean checkingName(String pName) throws SQLException
    {
        double revenue = 0.0;

        dbQuery = "SELECT SalesRevenue FROM IncomeStatement WHERE CompanyName = ?";
        s = financialConn.prepareStatement(dbQuery);
        s.setString(1, pName);
        rs = s.executeQuery();
        while (rs.next())
        {
            revenue = rs.getDouble("SalesRevenue");
        }

        return revenue != 0.0;
    }
    
    public double[] getValues(String pName) throws SQLException
    {
        double[] doubleArray = new double[9];
        dbQuery = "SELECT SalesRevenue, CostOfGoodSold, GrossProfit, Expenses,"
                + "NetProfitBefore, Interest, NetProfitBeforeTax, Tax, "
                + "NetProfitAfterInterestAndTax FROM IncomeStatement " + "WHERE CompanyName = ?";
        
        s = financialConn.prepareStatement(dbQuery);
        s.setString(1, pName);
        rs = s.executeQuery();

        while (rs.next())
        {
            doubleArray[0] = rs.getDouble("SalesRevenue");
            doubleArray[1] = rs.getDouble("CostOfGoodSold");
            doubleArray[2] = rs.getDouble("GrossProfit");
            doubleArray[3] = rs.getDouble("Expenses");
            doubleArray[4] = rs.getDouble("NetProfitBefore");
            doubleArray[5] = rs.getDouble("Interest");
            doubleArray[6] = rs.getDouble("NetProfitBeforeTax");
            doubleArray[7] = rs.getDouble("Tax");
            doubleArray[8] = rs.getDouble("NetProfitAfterInterestAndTax");
        }
        
        return doubleArray;
    }
    
    public double getGpm(String pName) throws SQLException
    {
        double gpm;

        dbQuery = "SELECT SalesRevenue, GrossProfit FROM IncomeStatement "
                + "WHERE CompanyName = ?";

        s = financialConn.prepareStatement(dbQuery);
        s.setString(1, pName);
        rs = s.executeQuery();
        while (rs.next())
        {
            sr = rs.getDouble("SalesRevenue");
            gp = rs.getDouble("GrossProfit");
        }
        gpm = gp / sr * 100;
        return gpm;
    }

    //getNpm
    public double getNpm(String pName) throws SQLException
    {
        double npm;

        dbQuery = "SELECT SalesRevenue, NetProfitBefore FROM IncomeStatement "
                + "WHERE CompanyName = ?";
        s = financialConn.prepareStatement(dbQuery);
        s.setString(1, pName);
        rs = s.executeQuery();
        while (rs.next())
        {
            sr = rs.getDouble("SalesRevenue");
            np = rs.getDouble("NetProfitBefore");
        }
        npm = np / sr * 100;
        return npm;
    }

    //getRevenueValue
    public double getRevenueValue(String pName, double ideal) throws SQLException
    {
        double rv;
        String dbQuery;
        ResultSet rs;

        dbQuery = "SELECT CostOfGoodSold FROM IncomeStatement WHERE CompanyName = ?";
        PreparedStatement s = financialConn.prepareStatement(dbQuery);
        s.setString(1, pName);
        rs = s.executeQuery();
        while (rs.next())
        {
            cogs = rs.getDouble("CostOfGoodSold");
        }
        rv = ((100 * cogs) / (100 - ideal)) - sr;
        return rv;
    }

    //getCostValue
    public double getCostValue(double ideal)
    {
        double cv;
        cv = cogs - ((sr * (100 - ideal)) / 100);
        return cv;
    }

    //getExpenseValue
    public double getExpenseValue(String pName, double ideal) throws SQLException
    {
        double ev;
        double e = 0.0;

        dbQuery = "SELECT Expenses FROM IncomeStatement WHERE CompanyName = ?";
        s = financialConn.prepareStatement(dbQuery);
        s.setString(1, pName);
        rs = s.executeQuery();
        while (rs.next())
        {
            e = rs.getDouble("Expenses");
        }
        ev = e - (((100.0 * gp) - (sr * ideal)) / 100.0);
        return ev;
    }
}
//package financialplanner;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InstallDb
{
    public static void main(String[] args)
    {
        //Declaration
        String IncomeStatementTbl;
        String TaxRangeTbl;
        
        AccessDb objDb = new AccessDb();
        
        //Create Db & tables
        objDb.createDb("FinancialAccount");
        IncomeStatementTbl = "CREATE TABLE IncomeStatement ( " 
                + "CompanyName varchar(30), " 
                + "SalesRevenue double, " 
                + "CostOfGoodSold double, " 
                + "GrossProfit double, " 
                + "Expenses double," 
                + "NetProfitBefore double," 
                + "Interest double," 
                + "NetProfitBeforeTax double," 
                + "Tax double," 
                + "NetProfitAfterInterestAndTax double" 
                + " )";
        System.out.println(IncomeStatementTbl);
        objDb.createTable(IncomeStatementTbl, "FinancialAccount");
        
        
        objDb.createDb("Tax");
        TaxRangeTbl = "CREATE TABLE TaxRange ( "
                + "Rate int, " 
                + "Supplementary int, "
                + "Minimum int, " 
                + "Maximum int" 
                + " )";
        System.out.println(TaxRangeTbl);
        objDb.createTable(TaxRangeTbl, "Tax");
        
        // Insertion into TaxRange
        int status;
        String dbQuery;
        PreparedStatement s;
        AccessDb taxObj = new AccessDb("Tax");
        Connection taxConn = taxObj.getDbConn();

        dbQuery = "INSERT INTO TaxRange "
                + "VALUES (?, ?, ?, ?)";
        try
        {
            s = taxConn.prepareStatement(dbQuery);
            s.setInt(1, 15);
            s.setInt(2, 0);
            s.setInt(3, 0);
            s.setInt(4, 50000);
            status = s.executeUpdate();
            s.setInt(1, 25);
            s.setInt(2, 7500);
            s.setInt(3, 50000);
            s.setInt(4, 75000);
            status = s.executeUpdate();
            s.setInt(1, 34);
            s.setInt(2, 13750);
            s.setInt(3, 75000);
            s.setInt(4, 100000);
            status = s.executeUpdate();
            s.setInt(1, 39);
            s.setInt(2, 22250);
            s.setInt(3, 100000);
            s.setInt(4, 335000);
            status = s.executeUpdate();
            s.setInt(1, 34);
            s.setInt(2, 113900);
            s.setInt(3, 335000);
            s.setInt(4, 10000000);
            status = s.executeUpdate();
            s.setInt(1, 35);
            s.setInt(2, 3400000);
            s.setInt(3, 10000000);
            s.setInt(4, 15000000);
            status = s.executeUpdate();
            s.setInt(1, 38);
            s.setInt(2, 5150000);
            s.setInt(3, 15000000);
            s.setInt(4, 18333333);
            status = s.executeUpdate();
            s.setInt(1, 35);
            s.setInt(2, 0);
            s.setInt(3, 18333333);
            s.setInt(4, 0);
            status = s.executeUpdate();
        } catch (Exception ee)
        {
            String warning = "Error Inserting into Table of Database";
            ErrorFrame errObj = new ErrorFrame(warning);
        }
    }
}
//package financialplanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccessDb {

    //declaration
    private String dbName;
    private Object[][] data;
    private Connection dbConn;
    
    //constructor with parameter
    public AccessDb (String dbName)
    {
        this.dbName = dbName;
        this.data = null;
        setDbConn();
    }
    
    //constructor without parameter
    public AccessDb() {
        this.dbName ="";
        this.dbConn=null;
    }

    //accessor for dbName
    public String getDbName() {
        return dbName;
    }

    //mutator for dbName
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
    
    //accessor for data
    public Object[][] getData(String tableName, String[] tableHeaders) {
        int columnCount = tableHeaders.length;
        ResultSet rs = null;
        Statement s = null;
        String dbQuery = "SELECT * FROM " + tableName;
        ArrayList<ArrayList<String>> dataList = new ArrayList<>();

        try{
            s = this.dbConn.createStatement();
            rs = s.executeQuery(dbQuery);
            while(rs.next()){
                ArrayList<String> row = new ArrayList<>();
                for(int i=0; i<columnCount; i++)
                {
                    row.add(rs.getString(tableHeaders[i]));
                }
                dataList.add(row);
            }
            this.data = new Object[dataList.size()][columnCount];
            for (int i=0; i<dataList.size(); i++){
                ArrayList<String> row;
                row = dataList.get(i);
                for (int j=0; j<columnCount; j++){
                    this.data[i][j] = row.get(j);
                }
            }
        }catch(Exception e){
            String warning = "Getting data error";
            ErrorFrame errObj = new ErrorFrame(warning);
        }
        return this.data;
    }
    
    //mutator for data
    private void setData(Object[][] data){
        this.data = data;
    }
    
    //accessor for dbConn
    public Connection getDbConn() {
        return this.dbConn;
    }

    //mutator for dbConn
    public void setDbConn() {
        String connectionURL = "jdbc:derby:" + this.dbName;
        this.dbConn = null;
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            this.dbConn = DriverManager.getConnection(connectionURL);
        }
        catch (SQLException err)
        {
            String warning = "SQL Connection error";
            ErrorFrame errObj = new ErrorFrame(warning);
        } 
        catch (ClassNotFoundException ex)
        {
            String warning = "Class for Name not found";
            ErrorFrame errObj = new ErrorFrame(warning);
        }
    }
   
    //closeDbConn
    public void closeDbConn()
    {
        try
        {
            this.dbConn.close();
        }
        catch (Exception err)
        {
            String warning = "DB closing error";
            ErrorFrame errObj = new ErrorFrame(warning);
        }
    }
    
    //createDb
    public void createDb(String newDbName)
    {
        this.dbName = newDbName;
        String connectionURL = "jdbc:derby:" + this.dbName + ";create = true";
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println(this.dbName);
            this.dbConn = DriverManager.getConnection(connectionURL);
            System.out.println("New database created.");
            this.dbConn.close();
        }
        catch (Exception err)
        {
            String warning = "DB creation error";
            ErrorFrame errObj = new ErrorFrame(warning);
        }
    }
    
    //createTable
    public void createTable(String newTable, String dbName)
    {
        Statement s;
        setDbName(dbName);
        setDbConn();
        try
        {
            s = this.dbConn.createStatement();
            s.execute(newTable);
            System.out.println("New table created.");
            this.dbConn.close();
        }
        catch (SQLException err)
        {
            String warning = "Table creation error";
            ErrorFrame errObj = new ErrorFrame(warning);
        }
    }
}
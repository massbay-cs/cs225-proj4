package EMS_Database.impl;

import EMS_Database.DoesNotExistException;
import EMS_Database.InitDB;
import static EMS_Database.InitDB.debugLog;
import EMS_Database.InputIncome;
import EMS_Database.Interface_BudgetData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;

/**
 *
 * @author mike
 */
public class Income_Table extends InitDB implements Interface_BudgetData {
    private String tableName = "INCOME";
    
    //SPECIAL FUNCTIONS    
    @Override
    public int nextValidUID() {
	int newUID = 0;
	try {

	    PreparedStatement idQueryStmt = dbConnection.prepareStatement("SELECT * FROM INCOME");
	    ResultSet rs = idQueryStmt.executeQuery();

	    while (rs.next()) {
		newUID = rs.getInt("UID");
		//System.out.println(newUID);
	    }
	    return (newUID + 1);

	} catch (SQLException sqle) {
	    sqle.printStackTrace();
	    System.exit(1);
	}
	return newUID; // should not be zero
    }

    @Override
    public String queryEntireTable() {
	StringBuilder returnQuery = new StringBuilder();
	try {
	    PreparedStatement idQueryStmt = dbConnection.prepareStatement("SELECT * FROM INCOME");
	    ResultSet rs = idQueryStmt.executeQuery();

	    while (rs.next()) {
		returnQuery.append(rs.getInt("UID"));
		returnQuery.append(",");
		returnQuery.append(rs.getString("DESCRIPTION"));
		returnQuery.append(",");
		returnQuery.append(rs.getString("DATE"));
		returnQuery.append(",");
		returnQuery.append(rs.getDouble("VALUE"));
		returnQuery.append("\n");
	    }

	} catch (SQLException sqle) {
	    sqle.printStackTrace();
	    System.exit(1);
	}

	return returnQuery.toString();
    }

    @Override
    public void removeBudgetItem(int uid) throws DoesNotExistException {
	String table = "INCOME";
	//checking for existance of that uid
	boolean exists = false;
	for (int validID : currentUIDList(table)) {
	    if (validID == uid) {
		exists = true;
		break;
	    }
	}
	//what to do if that uid does not exist
	if (exists == false) {
	    debugLog.log(Level.WARNING, "UID={0} does not exist in {1} table. Error occurred while calling removeEvent", new Object[]{uid, table});
	    throw new DoesNotExistException("check debug log. " + table + " table error.");
	}
	
	try {
	    PreparedStatement idQueryStmt = dbConnection.prepareStatement("DELETE FROM "+table+" WHERE UID=?");
	    idQueryStmt.setInt(1, uid);
	    idQueryStmt.executeUpdate();

	} catch (SQLException sqle) {
	    System.err.println(sqle.getMessage());
	    System.err.println("Deleting stuff from "+table+" is dangerous...");
	}	
    }

    public int insertBudgetItem(InputIncome input) {
	int newUID = nextValidUID();
	try {
	    //Creating Statement
	    PreparedStatement AddAddressStmt = dbConnection.prepareStatement("INSERT INTO INCOME VALUES(?,?,?,?)");
	    AddAddressStmt.setInt(1, newUID);
	    AddAddressStmt.setString(2, input.getDescription());
	    AddAddressStmt.setTimestamp(3, input.getDate());
	    AddAddressStmt.setDouble(4, input.getValue());
	    //Execute Statement
	    AddAddressStmt.executeUpdate();

	   
	} catch (SQLException sqle) {
	    System.err.println(sqle.getMessage());
	} finally {
	    return newUID;
	}
    }

    @Override
    public double total() {
	double returnQuery = 0.0;
	try {
	    PreparedStatement idQueryStmt = dbConnection.prepareStatement("SELECT * FROM INCOME");
	    ResultSet rs = idQueryStmt.executeQuery();
	    while (rs.next()) {
		returnQuery += rs.getDouble("VALUE");
	    }
	    return returnQuery;

	} catch (SQLException sqle) {
	    sqle.printStackTrace();
	    System.exit(1);
	}
	return returnQuery;
    }

    //GETTERS
    @Override
    public String getDescription(int uid) throws DoesNotExistException {
	return getDBString("DESCRIPTION",tableName,uid);
    }

    @Override
    public double getValue(int uid) throws DoesNotExistException {
	return getDBDouble("VALUE",tableName,uid);
    }

    @Override
    public Timestamp getDate(int uid) throws DoesNotExistException {
	return getDBTimestamp("DATE",tableName,uid);
    }
    
            
    //SETTERS
    @Override
    public void setDescription(int uid, String description) throws DoesNotExistException {
	setDBString("DESCRIPTION",tableName,uid,description);
    }

    @Override
    public void setValue(int uid, double value) throws DoesNotExistException {
	setDBDouble("VALUE",tableName,uid,value);
    }

    @Override
    public void setDate(int uid, Timestamp date) throws DoesNotExistException {
	setDBTimestamp("DATE",tableName,uid,date);
    }        

}

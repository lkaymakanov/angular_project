package generatetableutils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;





class TableMeta {
	

	
	public static Table  getTableMetaData(Connection con, String table){
		if(con == null || table == null)  return null;
		Table tb = new Table();
		try{
			Statement st = null ;
			ResultSet rs = null;
			String primaryKey = "";
			
			//data base meta data
			DatabaseMetaData meta =  con.getMetaData();
			
			//db Name = PostgreSQL, Oracle
			String dbName = meta.getDatabaseProductName();
			//Application.Log("DBName = " + dbName);
			
			//IMPORTANT
			//the table must be in upper case for oracle to get Primary key!!!!!!!!!!!!!!!!!
			rs =  con.getMetaData().getPrimaryKeys(null, null, dbName.equals("Oracle") ? table.toUpperCase(): table.toLowerCase());
			
			
			//get primary keys
		    while (rs.next()) {
		      primaryKey = rs.getString("COLUMN_NAME");
		      //Application.Log("getPrimaryKeys(): columnName=" + primaryKey);
		    }
			
		    //string to execute
		    String sql = " select * from (select a.*, ROW_NUMBER() OVER (ORDER BY (select 0 )) rnum from "+
		    		" ( "+ "select * from  "+ table.toLowerCase() + ")" + 
		    		" a ) b where rnum  >= 0 and rnum <= 1 ";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			//get resultset metadata
			ResultSetMetaData metaData = rs.getMetaData();
	
			int rowCount = metaData.getColumnCount();
	
	
			tb.setTableName(table);
			for (int i = 0; i < rowCount; i++) {
				if(!metaData.getColumnName(i + 1).toLowerCase().equals("rnum"))
					tb.addColumn(new TableColumn(
						metaData.getColumnName(i + 1).toLowerCase(), 
						metaData.getColumnDisplaySize(i + 1), 
						metaData.getColumnType(i+1), 
						metaData.getColumnTypeName(i + 1),
						metaData.getPrecision(i+1), 
						primaryKey.toLowerCase().equals(metaData.getColumnName(i + 1).toLowerCase())));
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}

		return tb;
	}
	
	public static List<String>  enumTablesPg(Connection conn) throws SQLException{
		//get tables from public
		PreparedStatement st = conn.prepareStatement(" select schemaname, tablename, tableowner  from pg_tables where  schemaname = 'public' order by tablename ");
		st.execute();
		ResultSet rs = 	st.getResultSet();
		
		List<String> tables = new ArrayList<String>(); 
		
		while(rs.next()){
			System.out.println(rs.getString("tablename"));
			tables.add(rs.getString("tablename"));
		}
		
		return tables;
		
	}
	
	//enumerate data tables
	public static void enumTables(Connection conn){
		
		
	/*	TABLE_CAT String => table catalog (may be null) 
		TABLE_SCHEM String => table schema (may be null) 
		TABLE_NAME String => table name 
		TABLE_TYPE String => table type. Typical types are "TABLE", "VIEW", "SYSTEM TABLE", "GLOBAL TEMPORARY", "LOCAL TEMPORARY", "ALIAS", "SYNONYM". 
		REMARKS String => explanatory comment on the table 
		TYPE_CAT String => the types catalog (may be null) 
		TYPE_SCHEM String => the types schema (may be null) 
		TYPE_NAME String => type name (may be null) 
		SELF_REFERENCING_COL_NAME String => name of the designated "identifier" column of a typed table (may be null) 
		REF_GENERATION String */
		
		if(conn == null)  {UtilFun.Log("Connection param in getTables is null "); return;}
		
		DatabaseMetaData md;
		try {
			md = conn.getMetaData();
			
			String types  [] = {"table"};
		
		    ResultSet rs = md.getTables(null, "public", "%", types);
		    while (rs.next()) {
		    	if(!rs.getString(3).startsWith("BIN$"));
		    	{
		    	
				      DbTableProperties tProp = new DbTableProperties();
				      
				      tProp.setTABLE_CAT(rs.getString(1));
				      tProp.setTABLE_SCHEM(rs.getString(2));
				      tProp.setTABLE_NAME(rs.getString(3));
				      tProp.setTABLE_TYPE(rs.getString(4));
				      tProp.setREMARKS(rs.getString(5));
				      //tProp.setTYPE_CAT(rs.getString(6));
				      //tProp.setTYPE_SCHEM(rs.getString(7));
				      //tProp.setTYPE_NAME(rs.getString(8));
				      //tProp.setSELF_REFERENCING_COL_NAME(rs.getString(9));
				      //tProp.setREF_GENERATION(rs.getString(10));
				      
				      System.out.println(tProp.getTABLE_NAME());
		    	}
		    }  
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			UtilFun.Log("Exeception occurred in getTables method...\n" + e.getMessage()); 
		}
	    
	}

		
}

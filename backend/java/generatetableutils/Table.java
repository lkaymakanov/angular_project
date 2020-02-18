package generatetableutils;

import java.util.ArrayList;
import java.util.List;

class Table {
	private String tableName;
	List<TableColumn>  columns = new ArrayList<TableColumn>();
	private boolean primarykey = false;
	TableColumn primaryKey;
	
	public void addColumn(TableColumn tc){
		if(columns == null) columns = new ArrayList<TableColumn>();
		if(tc.isPrimarykey()) {
			primarykey = true;
			primaryKey = tc;
		}
		columns.add(tc);
	}
	
	
	public List<TableColumn> getColumns(){
		return columns;
	}

	public boolean isPrimarykey() {
		return primarykey;
	}

	public TableColumn getPrimaryKey() {
		return primaryKey;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public String getColumnsForSelect(){
		String s = "";
		for(int i = 0; i < getColumns().size();i++){
			TableColumn c =  getColumns().get(i);
			
			//column names string
			s += (i > 0 ? Syntax.COMMA : "") + c.getColumnName();
		}
		return s;
	}
	
}

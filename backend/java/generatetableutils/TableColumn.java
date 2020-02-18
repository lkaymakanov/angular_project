package generatetableutils;

class TableColumn {

	private String columnName ;
	private int columnSize;
	private int columnType;
	private int columnPrecision;
	private String columnTypeStr;
	private boolean primarykey=false;
	
	
	public TableColumn(String cName, int cSize, int cType, String cTypeStr, int precision, boolean primarykey){
		columnName = cName;
		columnSize = cSize;
		columnType = cType;
		columnTypeStr = cTypeStr;
		columnPrecision = precision; 
		this.primarykey = primarykey;
	}


	public String getColumnName() {
		return columnName;
	}


	public int getColumnSize() {
		return columnSize;
	}


	public int getColumnType() {
		return columnType;
	}

	public int getColumnPrecision() {
		return columnPrecision;
	}


	public String getColumnTypeStr() {
		return columnTypeStr;
	}


	public boolean isPrimarykey() {
		return primarykey;
	}
	
	

}

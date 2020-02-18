package generatetableutils;

class DbTableProperties {

	private String TABLE_CAT = "";
	private String TABLE_SCHEM = "";
	private String TABLE_NAME = "";
	private String TABLE_TYPE = ""; //String => table type. Typical types are "TABLE", "VIEW", "SYSTEM TABLE", "GLOBAL TEMPORARY", "LOCAL TEMPORARY", "ALIAS", "SYNONYM". 
	private String REMARKS = "";// String => explanatory comment on the table 
	private String TYPE_CAT = ""; //String => the types catalog (may be null) 
	private String TYPE_SCHEM = ""; //String => the types schema (may be null) 
	private String TYPE_NAME = ""; //String => type name (may be null) 
	private String SELF_REFERENCING_COL_NAME = ""; //String => name of the designated "identifier" column of a typed table (may be null) 
	private String REF_GENERATION = ""; //String => specifies 
	
	
	
	
	
	
	
	
	public String getTABLE_CAT() {
		return TABLE_CAT;
	}
	public void setTABLE_CAT(String tABLECAT) {
		TABLE_CAT = tABLECAT;
	}
	public String getTABLE_SCHEM() {
		return TABLE_SCHEM;
	}
	public void setTABLE_SCHEM(String tABLESCHEM) {
		TABLE_SCHEM = tABLESCHEM;
	}
	public String getTABLE_NAME() {
		return TABLE_NAME;
	}
	public void setTABLE_NAME(String tABLENAME) {
		TABLE_NAME = tABLENAME;
	}
	public String getTABLE_TYPE() {
		return TABLE_TYPE;
	}
	public void setTABLE_TYPE(String tABLETYPE) {
		TABLE_TYPE = tABLETYPE;
	}
	public String getREMARKS() {
		return REMARKS;
	}
	public void setREMARKS(String rEMARKS) {
		REMARKS = rEMARKS;
	}
	public String getTYPE_CAT() {
		return TYPE_CAT;
	}
	public void setTYPE_CAT(String tYPECAT) {
		TYPE_CAT = tYPECAT;
	}
	public String getTYPE_SCHEM() {
		return TYPE_SCHEM;
	}
	public void setTYPE_SCHEM(String tYPESCHEM) {
		TYPE_SCHEM = tYPESCHEM;
	}
	public String getTYPE_NAME() {
		return TYPE_NAME;
	}
	public void setTYPE_NAME(String tYPENAME) {
		TYPE_NAME = tYPENAME;
	}
	public String getSELF_REFERENCING_COL_NAME() {
		return SELF_REFERENCING_COL_NAME;
	}
	public void setSELF_REFERENCING_COL_NAME(String sELFREFERENCINGCOLNAME) {
		SELF_REFERENCING_COL_NAME = sELFREFERENCINGCOLNAME;
	}
	public String getREF_GENERATION() {
		return REF_GENERATION;
	}
	public void setREF_GENERATION(String rEFGENERATION) {
		REF_GENERATION = rEFGENERATION;
	}
	
	
	
}

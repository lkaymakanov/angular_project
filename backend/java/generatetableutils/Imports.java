package generatetableutils;

class Imports {

	public static final String IMPORT_BIGDECIMAL = "import java.math.BigDecimal; \n";
	public static final String IMPORT_DATE = "import java.sql.Date; \n";
	public static final String IMPORT_TIME = "import java.sql.Time; \n";
	public static final String IMPORT_TIMESTAMP = "import java.sql.Timestamp;\n";
	public static final String IMPORT_JAVA_SQL_TYPES = "import java.sql.Types;\n";
	public static final String IMPORT_JAVA_LIST = "import java.util.List; \n";
	public static final String IMPORT_JAVA_SQL =  "import java.sql.*; \n";
	public static final String IMPORT_JAVAUTIL_DATE = "import java.util.Date; \n";	
	public static final String IMPORT_NET_JAVA_UTIL = "import net.is_bg.ltf.util.DateUtil;\n";
	
	//project imports
	public static final String IMPORT_UPDATE_STATEMENT = "import net.is_bg.ltf.db.common.UpdateSqlStatement;\n";
	public static final String IMPORT_ABSTRACT_MODEL = "import net.is_bg.ltf.AbstractModel; \n";
	
	public static String getImports(){
		return IMPORT_BIGDECIMAL+
		       IMPORT_DATE+
		       IMPORT_TIME+
		       IMPORT_TIMESTAMP+
		       IMPORT_JAVA_SQL_TYPES+
		       IMPORT_JAVA_LIST +
			   IMPORT_JAVA_SQL;
	}
}

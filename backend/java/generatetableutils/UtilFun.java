package generatetableutils;
import java.sql.Types;


class UtilFun {

	private static boolean log = true;
	
	//calculate indent by index
	public static String indent(int ind){
		String indent = "";
		for(int i = 0; i < ind; i++){
			indent+=Syntax.INDENT;
		}
		return indent;
	}
	
	//make first letter upper
	public static String MakeFirstUpper(String st){
		if (st == null || st.length() == 0) return null;
		String upper = st.toUpperCase().substring(0, 1);
		st = st.substring(1);
		return upper + st;
	}
	
	//remove '_' from string
	public static String RemoveUnderscore(String st){
		  if (st == null || st.length() == 0) return null;
		  return st.replace("_", "");
	}
	
	
	//get string keyWord for type in DB
	public static  String getStringOfType(int type, int precision){
		
		String ret = "";
		switch(type){
			case Types.NUMERIC:
				//check precision
				if(precision == 0) ret = VarTypes.LONG;
				else ret = VarTypes.BIGDECIMAL;
				break;
			case Types.INTEGER:
				ret = VarTypes.LONG;
				break;
			case Types.DATE:
				ret = VarTypes.DATE;
				break;
			case Types.VARCHAR:
				ret = VarTypes.STRING;
				break;
			case Types.CHAR:
				ret = VarTypes.STRING;
				break;
			case Types.TIMESTAMP:
				//ret = VarTypes.TIMESTAMP;
				ret = VarTypes.DATE;  // use date instead
				break;
			default:
				ret = VarTypes.STRING;
		}
		return ret;
	}
	
	
	//get string keyWord for type in DB
	public static  String getJsStringTypeOfType(int type, int precision){
			String ret = "";
			switch(type){
				case Types.NUMERIC:
					//check precision
					if(precision == 0) ret = JsVarTypes.NUMBER;
					else ret = JsVarTypes.NUMBER;
					break;
				case Types.INTEGER:
					ret = JsVarTypes.NUMBER;
					break;
				case Types.DATE:
					ret = JsVarTypes.DATE;
					break;
				case Types.VARCHAR:
					ret = JsVarTypes.STRING;
					break;
				case Types.CHAR:
					ret = JsVarTypes.STRING;
					break;
				case Types.TIMESTAMP:
					//ret = VarTypes.TIMESTAMP;
					ret = JsVarTypes.DATE;  // use date instead
					break;
				default:
					ret = VarTypes.STRING;
			}
			return ret;
	}
	
	//get string test param
	public static  String getTesParam(int type, int precision){
		String ret = "";
		switch(type){
			case Types.NUMERIC:
				//check precision
				if(precision == 0) ret = "-1";
				else ret = "new BigDecimal(-1.0)";
				break;
			case Types.DATE:
				ret = "new Date()";
				break;
			case Types.VARCHAR:
				ret = Syntax.QUATATION_MARK+ "testString" + Syntax.QUATATION_MARK;
				break;
			case Types.TIMESTAMP:
				//ret = VarTypes.TIMESTAMP;
				ret = "new Date()";  // use date instead
				break;
			case Types.CHAR:
				ret = Syntax.QUATATION_MARK+ "testString" + Syntax.QUATATION_MARK;
				break;
			case Types.INTEGER:
				ret = "-1";
				break;
				
			default:
				ret = null;
		}
		return ret;
	}	
	
	public static String comment(String s) {
		return  comment(s, "");
	}
	
	public static String comment(String s, String comment) {
		return  "/**" + Syntax.NEWLINE + s  + "*/" + Syntax.NEWLINE;
	}
	
	public static void Log(String s){
		if(log) System.out.println(s);
	}

}

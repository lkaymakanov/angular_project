package generatetableutils;

import java.util.ArrayList;
import java.util.List;


class Var {
	protected int type;
	protected String name;
	protected int precision;  
	
	//the class name of variable if it's a class variable
	protected String varClassName = "";
	private boolean classVar =  false;    //true if it's class variable else primitive
	private boolean primaryKey = false; 

	//list with variables contained by that variable
	protected List<Var> vars = new ArrayList<Var>();
	
	
	//set if class extend another class
	protected Var extendedVar;        
	
	public  Var(){
		
	}
	
	
	public Var(int type, String name, int precision) {
		// TODO Auto-generated constructor stub
		this.type = type;
		this.name = name;
		this.precision = precision;
		createSetterName();
		createGetterName();
	}
	
	
	public Var(int type, String name, int precision, String className,boolean isclass) {
		// TODO Auto-generated constructor stub
		this.type = type;
		this.name = name;
		this.precision = precision;
		createSetterName();
		createGetterName();
		varClassName = className;
		classVar = isclass;
	}
	
	public Var(int type, String name, int precision, String className, boolean isclass, boolean primaryKey) {
		this.type = type;
		this.name = name;
		this.precision = precision;
		createSetterName();
		createGetterName();
		varClassName = className;
		classVar = isclass;
		this.primaryKey = primaryKey;
	}

	
	private String createSetterName(){
		return  "set" + UtilFun.MakeFirstUpper(getName());
	}
	
	private String createGetterName(){
		return  "get" + UtilFun.MakeFirstUpper(getName());
	}
	
	
	
	public String invokeSetter(String objName, String param){
		return objName + Syntax.DOT + createSetterName() + Syntax.BRACEOPEN + param + Syntax.BRACECLOSE;
	}
	

	public String invokeGetter(String objName){
		return objName + Syntax.DOT + createGetterName() + Syntax.BRACEOPEN +  Syntax.BRACECLOSE;
	}
	
	
	/**Creates a setter to be printed to Output .java file*/
	private String createPrintSetter(int indentIndx){
		//modifier , type , name
		String indent = indent(indentIndx);
		String prototype = indent + KeyWords.PUBLIC + KeyWords.VOID + createSetterName()+ Syntax.BRACEOPEN +  UtilFun.getStringOfType(type, precision) + getName() + Syntax.BRACECLOSE;
		String body = Syntax.BEGIN_BLOCK + Syntax.NEWLINE + 
				indent + indent + KeyWords.THIS + Syntax.DOT + getName()+ Syntax.EQUALS + getName()+ Syntax.SEMICOLON_NEWLN +
			indent + Syntax.END_BLOCK;
		
		return  prototype + body;
	}
	
	
	
	
	
	
	/**Creates a getter to be printed to Output .java file*/
	public String createPrintGetter(int indentIndx){
		String indent = indent(indentIndx);
		//modifier , type , name
		String prototype = indent + KeyWords.PUBLIC + UtilFun.getStringOfType(type, precision) + createGetterName() + Syntax.BRACEOPEN + Syntax.BRACECLOSE;
		String body =
			Syntax.BEGIN_BLOCK + Syntax.NEWLINE + 
			indent + indent + KeyWords.RETURN + getName()+ Syntax.SEMICOLON + Syntax.NEWLINE+
			indent +Syntax.END_BLOCK;
		;
		return  prototype + body;
	}
	
	
	


	/**the declaration of variable */
	public String getVarDecl(int indentInd) {
		return  indent(indentInd) + KeyWords.PRIVATE + getTypeStr() + Syntax.SPACE  + name + Syntax.SEMICOLON;
	}


	public int getType() {
		return type;
	}


	public String getName() {
		return name;
	}


	public int getPrecision() {
		return precision;
	}
	
	public String getSetter(int identIndx){
		return createPrintSetter(identIndx);
	}
	
	public String getGetter(int identIndx){
		return  createPrintGetter(identIndx);

	}
	
	private String indent(int ind){
		return UtilFun.indent(ind);
	}
	
	public String getClassType(){
		return varClassName;
	}
	
	public String getTypeStr(){
		if(classVar)  return getClassType();
		else return UtilFun.getStringOfType(type, precision);
	}

	public boolean isClassVar() {
		return classVar;
	}

	public boolean isPrimaryKey() {
		return primaryKey;
	}
	
	public String getJsMapping() {
		return getName() + ":" + UtilFun.getJsStringTypeOfType(type, precision);
	}
	
}

package generatetableutils;

import java.util.Hashtable;
import java.util.Map;

class Templates {
	
	public final static String selectTemplate = 
			" ${modelpackage}\n"+
			" \n"+
			" import java.sql.ResultSet;\n"+
			" import java.sql.SQLException;\n"+
			" import net.is_bg.ltf.db.common.paging.SelectPagingSqlStatement;\n"+
			" \n"+
			" public class ${model}  extends SelectPagingSqlStatement<${type}>{\n"+
			
			" 	\n"+
			" private long id = 0;\n"+
			
			" 	private  ${type}Select() {\n"+
			" 		\n"+
			" 	}\n"+
			" 	\n"+
			" 	\n"+
			" 	private  ${type}Select(long id) {\n"+
			" 		this.id = id;\n"+
			" 		\n"+
			" 	}\n"+
			" 	\n"+
			" 	public static ${type}Select getSelect() {\n"+
			" 		return new ${type}Select();\n"+
			" 	}\n"+
			" 	\n"+
			" 	public static ${type}Select getIdSelecct(long id) {\n"+
			" 		return new  ${type}Select(id);\n"+
			" 	}\n"+
			" 	\n"+
			" 	public static ${type}Select getPageSelect(int pageNumber, int delta) {\n"+
			" 		${type}Select sel = new ${type}Select();\n"+
			" 		sel.setRows((pageNumber-1)*delta+1, pageNumber*delta );\n"+
			" 		return sel;\n"+
			" 	}\n"+

			
			
			" 	\n"+
			" 	@Override\n"+
			" 	protected String getSqlString() {\n"+
			" 		String sql = \" select   ${cols} from ${table} \";\n"+   
			"       sql+= (id > 0 ? \" where ${id} = \" + id : \"\"); \n"+
			" 		return super.rtnSqlString(sql);\n"+
			" 	}\n"+
			" 	\n"+
			" 	@Override\n"+
			" 	protected void retrieveResult(ResultSet rs) throws SQLException {\n"+
			" 		//\n"+
			" 		while(rs.next()) {\n"+
			" 			${type} model = new ${type}();\n"+
			" 			${res}\n"+
			" 			result.add(model);\n"+
			" 		}\n"+
			" 	}\n"+
			" }\n";
	
	
	private static final String serviceTemplate=
		"${modelpackage}\n"+
		" \n"+
		" import java.util.List;\n"+
		" import net.is_bg.ltf.db.common.DBConfig;\n"+
		" import net.is_bg.ltf.db.common.DBExecutor;\n"+
		" \n"+
		" public class ${type}Service  {\n"+
		" 	private DBExecutor ex = new DBExecutor(DBConfig.getConnectionFactory());\n"+
		" 	\n"+
		" 	public ${type} find(Long id) {\n"+
		" 		${type}Select db = ${type}Select.getIdSelecct(id);\n"+
		" 		ex.execute(db);\n"+
		" 		return  db.getResult().isEmpty() ? null : db.getResult().get(0); \n"+
		" 	}\n"+
		" \n"+
		" 	public Long delete(Long id) {\n"+
		" 		${type}Delete db  = new ${type}Delete(id);\n"+
		" 		ex.execute(db);\n"+
		" 		return id;\n"+
		" 	}\n"+
		" \n"+
		" 	public ${type} create(${type} obj) {\n"+
		" 		${type}Insert db = new ${type}Insert(obj);\n"+
		" 		ex.execute(db);\n"+
		" 		return obj;\n"+
		" 	}\n"+
		" \n"+
		" 	public ${type} update(${type} obj, Long id) {\n"+
		" 		${type}Update db = new ${type}Update(obj);\n"+
		" 		ex.execute(db);\n"+
		" 		return obj;\n"+
		" 	}\n"+
		" \n"+
		" 	public List<${type}> list(int page, int delta) {\n"+
		"       if(page <=0) page = 1; \n" +
		" 		${type}Select db = ${type}Select.getPageSelect(page, delta);\n"+
		" 		ex.execute(db);\n"+
		" 		return db.getResult();\n"+
		" 	}\n"+
		" }\n";


	
	private final static String ctrlTemplate = " ${modelpackage}\n"+
			" \n"+
			" import java.util.List;\n"+
			" import org.springframework.web.bind.annotation.GetMapping;\n"+
			" import org.springframework.web.bind.annotation.PostMapping;\n"+
			" import org.springframework.web.bind.annotation.RestController;\n"+
			" import ${appconstpackage}.AppConstants;\n"+
			" import controller.IController;\n"+
			" \n"+
			" \n"+
			" @RestController\n"+
			" public class ${type}Controller implements IController<${type}> {\n"+
			" \n"+
			" 	private static final String MAIN_PATH = \"/${table}\";\n"+
			" 	private static final ${type}Service service = new ${type}Service();\n"+
			" 	\n"+
			" 	\n"+
			" 	@GetMapping(MAIN_PATH + AppConstants.ID_PATH_PARAM)\n"+
			" 	public ${type} find( Long id) {\n"+
			" 		//System.out.println(\"Entered in find...\");\n"+
			" 		return service.find(id);\n"+
			" 	}\n"+
			" \n"+
			" 	@PostMapping(MAIN_PATH + AppConstants.DELETE_SUB_PATH + AppConstants.ID_PATH_PARAM)\n"+
			" 	public Long delete( Long id) {\n"+
			" 		//System.out.println(\"Entered in delete...\");\n"+
			" 		return service.delete(id);\n"+
			" 	}\n"+
			" \n"+
			" 	@PostMapping(MAIN_PATH + AppConstants.CREATE_SUB_PATH)\n"+
			" 	public ${type} create(${type} obj) {\n"+
			" 		service.create(obj);\n"+
			" 		//System.out.println(\"Entered in create...\");\n"+
			" 		return obj;\n"+
			" 	}\n"+
			" \n"+
			" 	@PostMapping(MAIN_PATH + AppConstants.UPDATE_SUB_PATH + AppConstants.ID_PATH_PARAM)\n"+
			" 	public ${type} update(${type} obj, Long id) {\n"+
			" 		//System.out.println(\"entered in update\");\n"+
			" 		service.update(obj, id);\n"+
			" 		return obj;\n"+
			" 	}\n"+
			" \n"+
			" 	@GetMapping(MAIN_PATH)\n"+
			" 	public List<${type}> list(int page, int delta) {\n"+
			" 		//System.out.println(\"entered in list...\");\n"+
			" 		return service.list(page, delta);\n"+
			" 	}\n"+
			" }\n";

	
	public static enum TEMPLATES {
		SELECT_TEMPLATE(selectTemplate) {
			@Override
			Map<String, String> getEmptyParamMap() {
				Map<String, String> m = new Hashtable<String, String>();
				m.put("${model}", "");
				m.put("${cols}", "");
				m.put("${type}", "");
				m.put("${table}", "");
				m.put("${id}", "");
				m.put("${modelpackage}", "");
				m.put("${res}", "");
				return m;
			}
		},
		
		SERVICE_TEMPLATE(serviceTemplate){
			@Override
			Map<String, String> getEmptyParamMap() {
				Map<String, String> m = new Hashtable<String, String>();
				m.put("${type}", "");
				m.put("${modelpackage}", "");
				return m;
			}
		},
		CONTROLLER_TEMPLATE(ctrlTemplate){
			Map<String, String> getEmptyParamMap() {
				Map<String, String> m = new Hashtable<String, String>();
				m.put("${type}", "");
				m.put("${table}", "");
				m.put("${modelpackage}", "");
				return m;
			}
		};
		
		TEMPLATES(String src){
			this.src = src;
		}
		String src = "";
		public  String getSrc(){
			return src;
		}
		
		public String fillTemplate(Map<String, String> m) {
			String s= src;
			for(String k :m.keySet()) {
				s = s.replace(k, m.get(k));
			}
			return s;
		}
		
	    abstract 	Map<String, String> getEmptyParamMap();
		
	}
	

}

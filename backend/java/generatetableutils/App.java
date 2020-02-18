
package generatetableutils;

import java.sql.SQLException;

import com.example.demo.InitDb;

import net.is_bg.ltf.db.common.ConnectionProperties;
import net.is_bg.ltf.db.common.impl.DataSourceConnectionFactoryDrManager;
//import net.is_bg.ltf.test.businessmodels.normativi.person.PersonService;




class App {

	
	//drivers 
	private final static String ORCL_DRIVER = "oracle.jdbc.OracleDriver";
	private final static String PGR_DRIVER  = "org.postgresql.Driver";
	
	//data bases url's
	

	//data base connections
	public static ConnectionProperties [] dBases = {

		new ConnectionProperties(PGR_DRIVER, "jdbc:postgresql://localhost:5432/soft", "postgres", "012345", "") ,                //0
		
	};
	
	static ConnectionProperties pr = dBases[0];
	
	public static ConnectionProperties getConnectionProp(){
		return pr;
	}
	


	
	
	
	
	
	//get connection to DB
    public void init() throws SQLException {
    	 String saveDir = "net\\is_bg\\ltf\\businessmodels\\softuni";  //"folder directory";
    	 DataSourceConnectionFactoryDrManager factory = new DataSourceConnectionFactoryDrManager(getConnectionProp());
    	 InitDb.initDb();
    	 // List<?> l =  new PersonService().list(1);
    	 //System.out.println(l);
    	 //CitySelect.getPageSelect(4, 100);
    	 //new Cit.list(1);
    	 //List<String> tables =  TableMeta.enumTablesPg(factory.getConnection());
    	 
    	 
    	 /*
    	 //new DbModelClasses(TableMeta.getTableMetaData(factory.getConnection(), "stuff"), true).save(saveDir);
    	 //new DbModelClasses(TableMeta.getTableMetaData(factory.getConnection(), "user_data"), true).save(saveDir);
    	 /*new DbModelClasses(TableMeta.getTableMetaData(factory.getConnection(), "user_order"), true).save(saveDir);
    	 new DbModelClasses(TableMeta.getTableMetaData(factory.getConnection(), "employee"), true).save(saveDir);
    	 new DbModelClasses(TableMeta.getTableMetaData(factory.getConnection(), "payment"), true).save(saveDir);
    	 new DbModelClasses(TableMeta.getTableMetaData(factory.getConnection(), "service"), true).save(saveDir);
    	 new DbModelClasses(TableMeta.getTableMetaData(factory.getConnection(), "service_group"), true).save(saveDir);
    	 new DbModelClasses(TableMeta.getTableMetaData(factory.getConnection(), "offer"), true).save(saveDir);*/
    	 
    	 //new DbModelClasses(TableMeta.getTableMetaData(factory.getConnection(), "promotion"), true).save(saveDir);
    	// new DbModelClasses(TableMeta.getTableMetaData(factory.getConnection(), "reservation"), true).save(saveDir);
    	// new DbModelClasses(TableMeta.getTableMetaData(factory.getConnection(), "payment"), true).save(saveDir);
    	 //new DbModelClasses(TableMeta.getTableMetaData(factory.getConnection(), "stuff"), true).save(saveDir);
    	 //new DbModelClasses(TableMeta.getTableMetaData(factory.getConnection(), "stuff"), true).save(saveDir);
    	
    }
	
	
	
	public static void main(String [] args) throws SQLException{
		
		App app = new App();
		app.init();
	
	
	}
}

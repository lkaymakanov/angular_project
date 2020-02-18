
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
	
	private final static String URL_PGR_BRC = "digest:jdbc:postgresql://10.240.110.120:5432/brc";
	private final static String URL_PGR_MDT = "digest:jdbc:postgresql://10.240.44.129:5432/mdt";
	private final static String URL_ORC_SF_129 = "jdbc:oracle:thin:@10.240.44.129:1521:ORCL";
	private final static String URL_ORC_SF_146 = "jdbc:oracle:thin:@10.240.44.146:1521:orcl";
	private final static String URL_LOCAL = "jdbc:oracle:thin:@localhost:1521:ltf";
	
	private final static String URL_PGR_149 = "digest:jdbc:postgresql://10.240.44.149:5432/bnk4";
	private final static String URL_PGR_LOCLHOST = "digest:jdbc:postgresql://localhost:5432/pdv";
	private final static String URL_PDV = "jdbc:postgresql://10.240.110.70:5432/pdv";
	private final static String URL_TETVEN = "digest:jdbc:postgresql://10.240.110.93:5432/teteven";
	
	
	private final static String URL_IUIS = "jdbc:postgresql://10.240.110.90:5432/iuis";
	//data base connections
	public static ConnectionProperties [] dBases = {
		new ConnectionProperties(ORCL_DRIVER, URL_ORC_SF_129, "brc", "brc", "orlc_brc_129"),  //0
		new ConnectionProperties(ORCL_DRIVER, URL_ORC_SF_129, "krp", "krp", "orlc_krp_129"),  //1
		new ConnectionProperties(ORCL_DRIVER, URL_ORC_SF_146, "brc", "brc", "orlc_brc_146"),  //2
		new ConnectionProperties(ORCL_DRIVER, URL_ORC_SF_146, "sdk", "sdk", "orlc_sdk_146"),  //3
		new ConnectionProperties(PGR_DRIVER, URL_PGR_BRC, "mdt", "mdt", "pgr_brc_129"),       //4
		new ConnectionProperties(ORCL_DRIVER, URL_LOCAL, "brc", "brc", "pgr_brc_129") ,       //5
		new ConnectionProperties(ORCL_DRIVER, URL_PGR_MDT, "mdt", "mdt", "pgr_mdt_129"),       //6
		
		new ConnectionProperties(PGR_DRIVER, URL_PGR_149, "bnk", "Bnk12345", "pgr_bnk_149") , //7  bankq 149 postgre
		new ConnectionProperties(PGR_DRIVER, URL_PGR_LOCLHOST, "postgres", "012345", "localhost_pgr"),  //8
		new ConnectionProperties(PGR_DRIVER, URL_PDV, "pdv", "pdv", "plovdivtest"),  //9
		new ConnectionProperties(PGR_DRIVER, URL_TETVEN, "teteven", "12345", "teteven93"),  //10
		new ConnectionProperties(PGR_DRIVER, URL_IUIS, "iuis", "iuis", "") ,      //11
		new ConnectionProperties(PGR_DRIVER, URL_IUIS, "iuis", "iuis", "") ,      //12
		new ConnectionProperties(PGR_DRIVER, "jdbc:postgresql://mig29.is-bg.net:5432/sozopol", "sofia2013", "12345", "") ,      //13
		new ConnectionProperties(PGR_DRIVER, "jdbc:postgresql://localhost:5432/soft", "postgres", "012345", "") ,                //14
		
	};
	
	static ConnectionProperties pr = dBases[14];
	
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

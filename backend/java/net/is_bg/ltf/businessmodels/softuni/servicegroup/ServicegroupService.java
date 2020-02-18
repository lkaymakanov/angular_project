package  net.is_bg.ltf.businessmodels.softuni.servicegroup;

 
 import java.util.List;
 import net.is_bg.ltf.db.common.DBConfig;
 import net.is_bg.ltf.db.common.DBExecutor;
 
 public class ServicegroupService  {
 	private DBExecutor ex = new DBExecutor(DBConfig.getConnectionFactory());
 	
 	public Servicegroup find(Long id) {
 		ServicegroupSelect db = ServicegroupSelect.getIdSelecct(id);
 		ex.execute(db);
 		return  db.getResult().isEmpty() ? null : db.getResult().get(0); 
 	}
 
 	public Long delete(Long id) {
 		ServicegroupDelete db  = new ServicegroupDelete(id);
 		ex.execute(db);
 		return id;
 	}
 
 	public Servicegroup create(Servicegroup obj) {
 		ServicegroupInsert db = new ServicegroupInsert(obj);
 		ex.execute(db);
 		return obj;
 	}
 
 	public Servicegroup update(Servicegroup obj, Long id) {
 		ServicegroupUpdate db = new ServicegroupUpdate(obj);
 		ex.execute(db);
 		return obj;
 	}
 
 	public List<Servicegroup> list(int page, int delta) {
       if(page <=0) page = 1; 
 		ServicegroupSelect db = ServicegroupSelect.getPageSelect(page, delta);
 		ex.execute(db);
 		return db.getResult();
 	}
 }

package  net.is_bg.ltf.businessmodels.softuni.service;

 
 import java.util.List;
 import net.is_bg.ltf.db.common.DBConfig;
 import net.is_bg.ltf.db.common.DBExecutor;
 
 public class ServiceService  {
 	private DBExecutor ex = new DBExecutor(DBConfig.getConnectionFactory());
 	
 	public Service find(Long id) {
 		ServiceSelect db = ServiceSelect.getIdSelecct(id);
 		ex.execute(db);
 		return  db.getResult().isEmpty() ? null : db.getResult().get(0); 
 	}
 
 	public Long delete(Long id) {
 		ServiceDelete db  = new ServiceDelete(id);
 		ex.execute(db);
 		return id;
 	}
 
 	public Service create(Service obj) {
 		ServiceInsert db = new ServiceInsert(obj);
 		ex.execute(db);
 		return obj;
 	}
 
 	public Service update(Service obj, Long id) {
 		ServiceUpdate db = new ServiceUpdate(obj);
 		ex.execute(db);
 		return obj;
 	}
 
 	public List<Service> list(int page, int delta) {
       if(page <=0) page = 1; 
 		ServiceSelect db = ServiceSelect.getPageSelect(page, delta);
 		ex.execute(db);
 		return db.getResult();
 	}
 	
 	public List<Service> forGroup(long groupid){
 		//if(page <=0) page = 1; 
 		ServiceSelect db = ServiceSelect.getGroupSelect(groupid);
 		ex.execute(db);
 		return db.getResult();
 	}
 }

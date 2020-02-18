package  net.is_bg.ltf.businessmodels.softuni.userorder;

 
 import java.util.List;
 import net.is_bg.ltf.db.common.DBConfig;
 import net.is_bg.ltf.db.common.DBExecutor;
 
 public class UserorderService  {
 	private DBExecutor ex = new DBExecutor(DBConfig.getConnectionFactory());
 	
 	public Userorder find(Long id) {
 		UserorderSelect db = UserorderSelect.getIdSelecct(id);
 		ex.execute(db);
 		return  db.getResult().isEmpty() ? null : db.getResult().get(0); 
 	}
 
 	public Long delete(Long id) {
 		UserorderDelete db  = new UserorderDelete(id);
 		ex.execute(db);
 		return id;
 	}
 
 	public Userorder create(Userorder obj) {
 		UserorderInsert db = new UserorderInsert(obj);
 		ex.execute(db);
 		return obj;
 	}
 
 	public Userorder update(Userorder obj, Long id) {
 		UserorderUpdate db = new UserorderUpdate(obj);
 		ex.execute(db);
 		return obj;
 	}
 
 	public List<Userorder> list(int page, int delta) {
       if(page <=0) page = 1; 
 		UserorderSelect db = UserorderSelect.getPageSelect(page, delta);
 		ex.execute(db);
 		return db.getResult();
 	}
 }

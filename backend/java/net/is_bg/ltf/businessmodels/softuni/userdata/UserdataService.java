package  net.is_bg.ltf.businessmodels.softuni.userdata;

 
 import java.util.List;

import net.is_bg.ltf.businessmodels.softuni.users.UsersSelect;
import net.is_bg.ltf.db.common.DBConfig;
 import net.is_bg.ltf.db.common.DBExecutor;
 
 public class UserdataService  {
 	private DBExecutor ex = new DBExecutor(DBConfig.getConnectionFactory());
 	
 	public Userdata find(Long id) {
 		UserdataSelect db = UserdataSelect.getIdSelecct(id);
 		ex.execute(db);
 		return  db.getResult().isEmpty() ? null : db.getResult().get(0); 
 	}
 
 	public Long delete(Long id) {
 		UserdataDelete db  = new UserdataDelete(id);
 		ex.execute(db);
 		return id;
 	}
 
 	public Userdata create(Userdata obj) {
 		UserdataInsert db = new UserdataInsert(obj);
 		ex.execute(db);
 		return obj;
 	}
 
 	public Userdata update(Userdata obj, Long id) {
 		UserdataUpdate db = new UserdataUpdate(obj);
 		ex.execute(db);
 		return obj;
 	}
 
 	public List<Userdata> list(int page, int delta) {
       if(page <=0) page = 1; 
 		UserdataSelect db = UserdataSelect.getPageSelect(page, delta);
 		ex.execute(db);
 		return db.getResult();
 	}
 	
 	
 	public Userdata login(String email, String pass) {
 		UserdataSelect sel = UserdataSelect.getUserPassSelect(email, pass);
 		ex.execute(sel);
 		return sel.getResult().size() >  0 ? sel.getResult().get(0) : null ;
 	}
 }

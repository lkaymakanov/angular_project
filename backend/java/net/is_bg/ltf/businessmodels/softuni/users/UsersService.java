package  net.is_bg.ltf.businessmodels.softuni.users;

 
 import java.util.List;
 import net.is_bg.ltf.db.common.DBConfig;
 import net.is_bg.ltf.db.common.DBExecutor;
 
 public class UsersService  {
 	private DBExecutor ex = new DBExecutor(DBConfig.getConnectionFactory());
 	
 	public Users find(Long id) {
 		UsersSelect db = UsersSelect.getIdSelecct(id);
 		ex.execute(db);
 		return  db.getResult().isEmpty() ? null : db.getResult().get(0); 
 	}
 
 	public Long delete(Long id) {
 		UsersDelete db  = new UsersDelete(id);
 		ex.execute(db);
 		return id;
 	}
 
 	public Users create(Users obj) {
 		UsersInsert db = new UsersInsert(obj);
 		ex.execute(db);
 		return obj;
 	}
 
 	public Users update(Users obj, Long id) {
 		UsersUpdate db = new UsersUpdate(obj);
 		ex.execute(db);
 		return obj;
 	}
 
 	public List<Users> list(int page, int delta) {
       if(page <=0) page = 1; 
 		UsersSelect db = UsersSelect.getPageSelect(page, delta);
 		ex.execute(db);
 		return db.getResult();
 	}
 	
 	public boolean login(String email, String pass) {
 		UsersSelect sel = UsersSelect.getUserPassSelect(email, pass);
 		ex.execute(sel);
 		return sel.getResult().size() >0;
 	}
 }

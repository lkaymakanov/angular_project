package  net.is_bg.ltf.businessmodels.softuni.stuff;

 
 import java.util.List;
 import net.is_bg.ltf.db.common.DBConfig;
 import net.is_bg.ltf.db.common.DBExecutor;
 
 public class StuffService  {
 	private DBExecutor ex = new DBExecutor(DBConfig.getConnectionFactory());
 	
 	public Stuff find(Long id) {
 		StuffSelect db = StuffSelect.getIdSelecct(id);
 		ex.execute(db);
 		return  db.getResult().isEmpty() ? null : db.getResult().get(0); 
 	}
 
 	public Long delete(Long id) {
 		StuffDelete db  = new StuffDelete(id);
 		ex.execute(db);
 		return id;
 	}
 
 	public Stuff create(Stuff obj) {
 		StuffInsert db = new StuffInsert(obj);
 		ex.execute(db);
 		return obj;
 	}
 
 	public Stuff update(Stuff obj, Long id) {
 		StuffUpdate db = new StuffUpdate(obj);
 		ex.execute(db);
 		return obj;
 	}
 
 	public List<Stuff> list(int page, int delta) {
       if(page <=0) page = 1; 
 		StuffSelect db = StuffSelect.getPageSelect(page, delta);
 		ex.execute(db);
 		return db.getResult();
 	}
 }

package  net.is_bg.ltf.businessmodels.softuni.promotion;

 
 import java.util.List;
 import net.is_bg.ltf.db.common.DBConfig;
 import net.is_bg.ltf.db.common.DBExecutor;
 
 public class PromotionService  {
 	private DBExecutor ex = new DBExecutor(DBConfig.getConnectionFactory());
 	
 	public Promotion find(Long id) {
 		PromotionSelect db = PromotionSelect.getIdSelecct(id);
 		ex.execute(db);
 		return  db.getResult().isEmpty() ? null : db.getResult().get(0); 
 	}
 
 	public Long delete(Long id) {
 		PromotionDelete db  = new PromotionDelete(id);
 		ex.execute(db);
 		return id;
 	}
 
 	public Promotion create(Promotion obj) {
 		PromotionInsert db = new PromotionInsert(obj);
 		ex.execute(db);
 		return obj;
 	}
 
 	public Promotion update(Promotion obj, Long id) {
 		PromotionUpdate db = new PromotionUpdate(obj);
 		ex.execute(db);
 		return obj;
 	}
 
 	public List<Promotion> list(int page, int delta) {
       if(page <=0) page = 1; 
 		PromotionSelect db = PromotionSelect.getPageSelect(page, delta);
 		ex.execute(db);
 		return db.getResult();
 	}
 }

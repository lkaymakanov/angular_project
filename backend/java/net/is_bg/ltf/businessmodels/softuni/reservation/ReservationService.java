package  net.is_bg.ltf.businessmodels.softuni.reservation;

 
 import java.util.ArrayList;
import java.util.List;
 import net.is_bg.ltf.db.common.DBConfig;
 import net.is_bg.ltf.db.common.DBExecutor;
 
 public class ReservationService  {
 	private DBExecutor ex = new DBExecutor(DBConfig.getConnectionFactory());
 	
 	public Reservation find(Long id) {
 		ReservationSelect db = ReservationSelect.getIdSelecct(id);
 		ex.execute(db);
 		return  db.getResult().isEmpty() ? null : db.getResult().get(0); 
 	}
 
 	public Long delete(Long id) {
 		ReservationDelete db  = new ReservationDelete(id);
 		ex.execute(db);
 		return id;
 	}
 
 	public Reservation create(Reservation obj) {
 		ReservationInsert db = new ReservationInsert(obj);
 		ex.execute(db);
 		return obj;
 	}
 
 	public Reservation update(Reservation obj, Long id) {
 		ReservationUpdate db = new ReservationUpdate(obj);
 		ex.execute(db);
 		return obj;
 	}
 
 	public List<Reservation> list(int page, int delta) {
       if(page <=0) page = 1; 
 		ReservationSelect db = ReservationSelect.getPageSelect(page, delta);
 		ex.execute(db);
 		return db.getResult();
 	}
 	
 	
 	public List<Reservation> forUser(long userId) {
        if(userId <=0) return new ArrayList<Reservation>();
  		ReservationSelect db = ReservationSelect.getSelectForUser(userId);
  		ex.execute(db);
  		return db.getResult();
  	}

	public List<Reservation> unpaidforUser(Long userId) {
		 if(userId <=0) return new ArrayList<Reservation>();
  		ReservationSelect db = ReservationSelect.getUnpaidSelectForUser(userId);
  		ex.execute(db);
  		return db.getResult();
	}
 }

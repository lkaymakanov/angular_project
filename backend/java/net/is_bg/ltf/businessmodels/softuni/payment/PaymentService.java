package  net.is_bg.ltf.businessmodels.softuni.payment;

 
 import java.util.ArrayList;
import java.util.List;
 import net.is_bg.ltf.db.common.DBConfig;
 import net.is_bg.ltf.db.common.DBExecutor;
 
 public class PaymentService  {
 	private DBExecutor ex = new DBExecutor(DBConfig.getConnectionFactory());
 	
 	public Payment find(Long id) {
 		PaymentSelect db = PaymentSelect.getIdSelecct(id);
 		ex.execute(db);
 		return  db.getResult().isEmpty() ? null : db.getResult().get(0); 
 	}
 
 	public Long delete(Long id) {
 		PaymentDelete db  = new PaymentDelete(id);
 		ex.execute(db);
 		return id;
 	}
 
 	public Payment create(Payment obj) {
 		PaymentInsert db = new PaymentInsert(obj);
 		ex.execute(db);
 		return obj;
 	}
 
 	public Payment update(Payment obj, Long id) {
 		PaymentUpdate db = new PaymentUpdate(obj);
 		ex.execute(db);
 		return obj;
 	}
 
 	public List<Payment> list(int page, int delta) {
       if(page <=0) page = 1; 
 		PaymentSelect db = PaymentSelect.getPageSelect(page, delta);
 		ex.execute(db);
 		return db.getResult();
 	}

	public List<Payment> forUser(Long userId) {
		if(userId <=0) return new ArrayList<Payment>(); 
	 	PaymentSelect db = PaymentSelect.getUserPaymentSelect(userId);
	 	ex.execute(db);
	 	return db.getResult();
	}
 }

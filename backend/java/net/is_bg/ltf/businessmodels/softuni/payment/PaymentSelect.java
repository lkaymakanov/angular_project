 package  net.is_bg.ltf.businessmodels.softuni.payment;

 
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import net.is_bg.ltf.db.common.paging.SelectPagingSqlStatement;
 
 public class PaymentSelect  extends SelectPagingSqlStatement<Payment>{
 	
 private long id = 0;
 	private  PaymentSelect() {
 		
 	}
 	
 	
 	private  PaymentSelect(long id) {
 		this.id = id;
 		
 	}
 	
 	public static PaymentSelect getSelect() {
 		return new PaymentSelect();
 	}
 	
 	public static PaymentSelect getIdSelecct(long id) {
 		return new  PaymentSelect(id);
 	}
 	
 	public static PaymentSelect getPageSelect(int pageNumber, int delta) {
 		PaymentSelect sel = new PaymentSelect();
 		sel.setRows((pageNumber-1)*delta+1, pageNumber*delta );
 		return sel;
 	}
 	
 	@Override
 	protected String getSqlString() {
 		String sql = " select   payment_id,reservation_id,paytime,sum,pay_card_id from payment ";
       sql+= (id > 0 ? " where payment_id = " + id : ""); 
 		return super.rtnSqlString(sql);
 	}
 	
 	@Override
 	protected void retrieveResult(ResultSet rs) throws SQLException {
 		//
 		while(rs.next()) {
 			Payment model = new Payment();
 					model.setId(rs.getLong ("payment_id"));
		model.setReservationid(rs.getLong ("reservation_id"));
		model.setPaytime(rs.getDate ("paytime"));
		model.setSum(rs.getBigDecimal ("sum"));
		model.setPaycardid(rs.getLong ("pay_card_id"));

 			result.add(model);
 		}
 	}
 }

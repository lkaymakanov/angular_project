 package  net.is_bg.ltf.businessmodels.softuni.reservation;

 
 import java.sql.ResultSet;
 import java.sql.SQLException;

import net.is_bg.ltf.businessmodels.softuni.service.Service;
import net.is_bg.ltf.db.common.paging.SelectPagingSqlStatement;
 
 public class ReservationSelect  extends SelectPagingSqlStatement<Reservation>{
 	
    private long id = 0;
    private long userId = 0;
 	private  ReservationSelect() {
 		
 	}
 	
 	
 	private  ReservationSelect(long id) {
 		this.id = id;
 		
 	}
 	
 	public static ReservationSelect getSelect() {
 		return new ReservationSelect();
 	}
 	
 	public static ReservationSelect getIdSelecct(long id) {
 		return new  ReservationSelect(id);
 	}
 	
 	
 	
 	public static ReservationSelect getPageSelect(int pageNumber, int delta) {
 		ReservationSelect sel = new ReservationSelect();
 		sel.setRows((pageNumber-1)*delta+1, pageNumber*delta );
 		return sel;
 	}
 	
 	public static ReservationSelect getSelectForUser(long userId) {
 		ReservationSelect sl = new ReservationSelect(0);
 		sl.userId = userId;
 		return  sl;
 	}
 	
 	@Override
 	protected String getSqlString() {
 		String sql = " select   reservation_id,reservation_date,r.service_id,user_id,"
 				+ "  reservationfor, s.name, s.price"
 				+ "    from reservation r "+
 				   " join service s on s.service_id = r.service_id   ";
        sql+= (id > 0 ? " where reservation_id = " + id : ""); 
 		return super.rtnSqlString(sql);
 	}
 	
 	@Override
 	protected void retrieveResult(ResultSet rs) throws SQLException {
 		//
 		while(rs.next()) {
 			Reservation model = new Reservation();
 			model.setId(rs.getLong ("reservation_id"));
 			model.setReservationdate(rs.getDate ("reservation_date"));
 			Service s = model.getProcedure();
 			s.setName(rs.getString("name"));
 			s.setPrice(rs.getBigDecimal("price"));
 			//model.setServiceid(rs.getBigDecimal ("service_id"));
 			model.setUserid(rs.getBigDecimal ("user_id"));
 			model.setReservationfor(rs.getDate ("reservationfor"));

 			result.add(model);
 		}
 	}
 }

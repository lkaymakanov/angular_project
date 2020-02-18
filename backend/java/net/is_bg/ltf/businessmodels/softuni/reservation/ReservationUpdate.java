//This file is generated by LAK GenerateUtils...
package  net.is_bg.ltf.businessmodels.softuni.reservation;


import java.sql.*; 
import net.is_bg.ltf.db.common.UpdateSqlStatement;
import java.util.Date; 

import net.is_bg.ltf.util.DateUtil;



public class ReservationUpdate extends UpdateSqlStatement{


	private Reservation model;


	public ReservationUpdate(Reservation model ){
		this.model = model ;
	}


	@Override 
	protected String getSqlString() {
		 String sql = "";
		 sql += 		" update reservation set  "+
 		",reservation_date = ? "+
		",service_id = ? "+
		",user_id = ? "+
		",reservationfor = ? "+
		" where reservation_id = ?  ";		return  sql ;
	}


	@Override 
	protected void setParameters(PreparedStatement prStmt) throws SQLException  {
		bindVarData.setDate (DateUtil.toSQLDate(model.getReservationdate()));
		bindVarData.setLong (model.getProcedure().getId());
		bindVarData.setBigDecimal (model.getUserid());
		bindVarData.setDate (DateUtil.toSQLDate(model.getReservationfor()));
		bindVarData.setLong (model.getId());
		bindVarData.setParameters(prStmt);
	}
}

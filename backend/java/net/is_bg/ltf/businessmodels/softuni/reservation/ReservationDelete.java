//This file is generated by LAK GenerateUtils...
package  net.is_bg.ltf.businessmodels.softuni.reservation;


import java.sql.*; 
import net.is_bg.ltf.db.common.UpdateSqlStatement;
import java.util.Date; 

import net.is_bg.ltf.util.DateUtil;



public class ReservationDelete extends UpdateSqlStatement{


	private Reservation model;


	public ReservationDelete(Reservation model ){
		this.model = model ;
	}

	public ReservationDelete( long id ){
		this.model =  new Reservation();
		this.model.setId(id);
	}


	@Override 
	protected String getSqlString() {
		 String sql = "";
		 sql += " delete from reservation where reservation_id = ?  ";		return  sql ;
	}


	@Override 
	protected void setParameters(PreparedStatement prStmt) throws SQLException  {
		bindVarData.setLong (model.getId());
		bindVarData.setParameters(prStmt);
	}
}

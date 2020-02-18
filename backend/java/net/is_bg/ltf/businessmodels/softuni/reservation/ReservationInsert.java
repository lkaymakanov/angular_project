//This file is generated by LAK GenerateUtils...
package  net.is_bg.ltf.businessmodels.softuni.reservation;


import java.sql.*; 
import net.is_bg.ltf.db.common.UpdateSqlStatement;
import java.util.Date; 

import net.is_bg.ltf.util.DateUtil;



public class ReservationInsert extends UpdateSqlStatement{


	private Reservation model;


	public ReservationInsert(Reservation model ){
		this.model = model ;
	}


	@Override 
	protected String getSqlString() {
		 String sql = "";
		 sql += " insert into reservation (reservation_id,reservation_date,service_id,user_id,reservationfor) values (";

			if (model.getId() >  0) sql += " ?  ";
			else  sql +=  " snextval('s_reservation')";

		 sql+= ",?,?,?,?) ";
		return  sql ;
	}


	@Override 
	protected void setParameters(PreparedStatement prStmt) throws SQLException  {
		if (model.getId() >  0)		bindVarData.setLong (model.getId());
		bindVarData.setDate (DateUtil.toSQLDate(model.getReservationdate()));
		bindVarData.setLong (model.getProcedure().getId());
		bindVarData.setBigDecimal (model.getUserid());
		bindVarData.setDate (DateUtil.toSQLDate(model.getReservationfor()));
		bindVarData.setParameters(prStmt);
	}
}

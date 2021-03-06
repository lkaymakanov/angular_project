//This file is generated by LAK GenerateUtils...
package  net.is_bg.ltf.businessmodels.softuni.service;


import java.sql.*; 
import net.is_bg.ltf.db.common.UpdateSqlStatement;
import java.util.Date; 

import net.is_bg.ltf.util.DateUtil;



public class ServiceInsert extends UpdateSqlStatement{


	private Service model;


	public ServiceInsert(Service model ){
		this.model = model ;
	}


	@Override 
	protected String getSqlString() {
		 String sql = "";
		 sql += " insert into service (service_id,name,service_group_id,price) values (";

			if (model.getId() >  0) sql += " ?  ";
			else  sql +=  " snextval('s_service')";

		 sql+= ",?,?,?) ";
		return  sql ;
	}


	@Override 
	protected void setParameters(PreparedStatement prStmt) throws SQLException  {
		if (model.getId() >  0)		bindVarData.setLong (model.getId());
		bindVarData.setString (model.getName());
		bindVarData.setLong (model.getServicegroupid());
		bindVarData.setBigDecimal (model.getPrice());
		bindVarData.setParameters(prStmt);
	}
}

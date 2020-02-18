//This file is generated by LAK GenerateUtils...
package  net.is_bg.ltf.businessmodels.softuni.service;


import java.sql.*; 
import net.is_bg.ltf.db.common.UpdateSqlStatement;
import java.util.Date; 

import net.is_bg.ltf.util.DateUtil;



public class ServiceUpdate extends UpdateSqlStatement{


	private Service model;


	public ServiceUpdate(Service model ){
		this.model = model ;
	}


	@Override 
	protected String getSqlString() {
		 String sql = "";
		 sql += 		" update service set  "+
 		",name = ? "+
		",service_group_id = ? "+
		",price = ? "+
		" where service_id = ?  ";		return  sql ;
	}


	@Override 
	protected void setParameters(PreparedStatement prStmt) throws SQLException  {
		bindVarData.setString (model.getName());
		bindVarData.setLong (model.getServicegroupid());
		bindVarData.setBigDecimal (model.getPrice());
		bindVarData.setLong (model.getId());
		bindVarData.setParameters(prStmt);
	}
}

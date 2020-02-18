//This file is generated by LAK GenerateUtils...
package  net.is_bg.ltf.businessmodels.softuni.servicegroup;


import java.sql.*; 
import net.is_bg.ltf.db.common.UpdateSqlStatement;
import java.util.Date; 

import net.is_bg.ltf.util.DateUtil;



public class ServicegroupUpdate extends UpdateSqlStatement{


	private Servicegroup model;


	public ServicegroupUpdate(Servicegroup model ){
		this.model = model ;
	}


	@Override 
	protected String getSqlString() {
		 String sql = "";
		 sql += 		" update service_group set  "+
 		",service_group_name = ? "+
		" where service_group_id = ?  ";		return  sql ;
	}


	@Override 
	protected void setParameters(PreparedStatement prStmt) throws SQLException  {
		bindVarData.setString (model.getServicegroupname());
		bindVarData.setLong (model.getId());
		bindVarData.setParameters(prStmt);
	}
}

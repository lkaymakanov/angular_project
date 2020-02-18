//This file is generated by LAK GenerateUtils...
package  net.is_bg.ltf.businessmodels.softuni.stuff;


import java.sql.*; 
import net.is_bg.ltf.db.common.UpdateSqlStatement;
import java.util.Date; 

import net.is_bg.ltf.util.DateUtil;



public class StuffUpdate extends UpdateSqlStatement{


	private Stuff model;


	public StuffUpdate(Stuff model ){
		this.model = model ;
	}


	@Override 
	protected String getSqlString() {
		 String sql = "";
		 sql += 		" update stuff set  "+
 		",name = ? "+
		",phone = ? "+
		",image = ? "+
		",description = ? "+
		",user_id = ? "+
		",work_hours = ? "+
		",likes = ? "+
		",dislikes = ? "+
		" where stuff_id = ?  ";		return  sql ;
	}


	@Override 
	protected void setParameters(PreparedStatement prStmt) throws SQLException  {
		bindVarData.setString (model.getName());
		bindVarData.setString (model.getPhone());
		bindVarData.setString (model.getImage());
		bindVarData.setString (model.getDescription());
		bindVarData.setLong (model.getUserid());
		bindVarData.setString (model.getWorkhours());
		bindVarData.setLong (model.getLikes());
		bindVarData.setLong (model.getDislikes());
		bindVarData.setLong (model.getId());
		bindVarData.setParameters(prStmt);
	}
}
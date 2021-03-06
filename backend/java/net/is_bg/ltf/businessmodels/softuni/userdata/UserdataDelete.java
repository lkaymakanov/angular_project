//This file is generated by LAK GenerateUtils...
package  net.is_bg.ltf.businessmodels.softuni.userdata;


import java.sql.*; 
import net.is_bg.ltf.db.common.UpdateSqlStatement;
import java.util.Date; 

import net.is_bg.ltf.util.DateUtil;



public class UserdataDelete extends UpdateSqlStatement{


	private Userdata model;


	public UserdataDelete(Userdata model ){
		this.model = model ;
	}

	public UserdataDelete( long id ){
		this.model =  new Userdata();
		this.model.setId(id);
	}


	@Override 
	protected String getSqlString() {
		 String sql = "";
		 sql += " delete from user_data where user_id = ?  ";		return  sql ;
	}


	@Override 
	protected void setParameters(PreparedStatement prStmt) throws SQLException  {
		bindVarData.setLong (model.getId());
		bindVarData.setParameters(prStmt);
	}
}

//This file is generated by LAK GenerateUtils...
package  net.is_bg.ltf.businessmodels.softuni.promotion;


import java.sql.*; 
import net.is_bg.ltf.db.common.UpdateSqlStatement;
import java.util.Date; 

import net.is_bg.ltf.util.DateUtil;



public class PromotionUpdate extends UpdateSqlStatement{


	private Promotion model;


	public PromotionUpdate(Promotion model ){
		this.model = model ;
	}


	@Override 
	protected String getSqlString() {
		 String sql = "";
		 sql += 		" update promotion set  "+
 		",expire_date = ? "+
		",service_id = ? "+
		",discount = ? "+
		" where promotion_id = ?  ";		return  sql ;
	}


	@Override 
	protected void setParameters(PreparedStatement prStmt) throws SQLException  {
		bindVarData.setDate (DateUtil.toSQLDate(model.getExpiredate()));
		bindVarData.setLong (model.getProcedure().getId());
		bindVarData.setLong (model.getDicscount());
		bindVarData.setLong (model.getId());
		bindVarData.setParameters(prStmt);
	}
}

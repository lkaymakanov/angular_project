 package  net.is_bg.ltf.businessmodels.softuni.userdata;

 
 import java.sql.ResultSet;
 import java.sql.SQLException;

import net.is_bg.ltf.db.common.paging.SelectPagingSqlStatement;
import net.is_bg.ltf.jwt.Sha512;
 
 public class UserdataSelect  extends SelectPagingSqlStatement<Userdata>{
 	
 private long id = 0;
 private String email, pass;
 	private  UserdataSelect() {
 		
 	}
 	
 	
 	private  UserdataSelect(long id) {
 		this.id = id;
 		
 	}
 	
 	public static UserdataSelect getSelect() {
 		return new UserdataSelect();
 	}
 	
 	public static UserdataSelect getIdSelecct(long id) {
 		return new  UserdataSelect(id);
 	}
 	
 	public static UserdataSelect getPageSelect(int pageNumber, int delta) {
 		UserdataSelect sel = new UserdataSelect();
 		sel.setRows((pageNumber-1)*delta+1, pageNumber*delta );
 		return sel;
 	}
 	
 	public static UserdataSelect getUserPassSelect(String email, String pass) {
 		UserdataSelect sel = new UserdataSelect();
 		sel.pass = pass;
 		sel.email = email;
 		return sel;
 	}
 	
 	@Override
 	protected String getSqlString() {
 		String sql = " select   user_id,username,email,created_date,password,image from user_data where 1=1 ";
        if(email!=null && pass!=null) {
			sql+= " and email = ? "  + " and password = ? " ;
			bindVarData.setString(email); bindVarData.setString(new Sha512().digest(pass)) ;
		}
        sql+= (id > 0 ? " and user_id = " + id : ""); 
		return super.rtnSqlString(sql);
 	}
 	
 	@Override
 	protected void retrieveResult(ResultSet rs) throws SQLException {
 		//
 		while(rs.next()) {
 			Userdata model = new Userdata();
 					model.setId(rs.getLong ("user_id"));
		model.setUsername(rs.getString ("username"));
		model.setEmail(rs.getString ("email"));
		model.setCreateddate(rs.getDate ("created_date"));
		model.setPassword(rs.getString ("password"));
		model.setImage(rs.getString ("image"));

 			result.add(model);
 		}
 	}
 }

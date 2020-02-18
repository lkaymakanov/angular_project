 package  net.is_bg.ltf.businessmodels.softuni.userorder;

 
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import net.is_bg.ltf.db.common.paging.SelectPagingSqlStatement;
 
 public class UserorderSelect  extends SelectPagingSqlStatement<Userorder>{
 	
 private long id = 0;
 	private  UserorderSelect() {
 		
 	}
 	
 	
 	private  UserorderSelect(long id) {
 		this.id = id;
 		
 	}
 	
 	public static UserorderSelect getSelect() {
 		return new UserorderSelect();
 	}
 	
 	public static UserorderSelect getIdSelecct(long id) {
 		return new  UserorderSelect(id);
 	}
 	
 	public static UserorderSelect getPageSelect(int pageNumber, int delta) {
 		UserorderSelect sel = new UserorderSelect();
 		sel.setRows((pageNumber-1)*delta+1, pageNumber*delta );
 		return sel;
 	}
 	
 	@Override
 	protected String getSqlString() {
 		String sql = " select   order_id,user_id,service_id,order_time from user_order ";
       sql+= (id > 0 ? " where order_id = " + id : ""); 
 		return super.rtnSqlString(sql);
 	}
 	
 	@Override
 	protected void retrieveResult(ResultSet rs) throws SQLException {
 		//
 		while(rs.next()) {
 			Userorder model = new Userorder();
 					model.setId(rs.getLong ("order_id"));
		model.setUserid(rs.getLong ("user_id"));
		model.setServiceid(rs.getLong ("service_id"));
		model.setOrdertime(rs.getDate ("order_time"));

 			result.add(model);
 		}
 	}
 }

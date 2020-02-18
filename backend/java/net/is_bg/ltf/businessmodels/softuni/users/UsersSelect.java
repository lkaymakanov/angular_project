 package  net.is_bg.ltf.businessmodels.softuni.users;

 
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import net.is_bg.ltf.db.common.paging.SelectPagingSqlStatement;
import net.is_bg.ltf.jwt.Sha512;
 
 public class UsersSelect  extends SelectPagingSqlStatement<Users>{
 	
    private long id = 0;
    private String email;
    private String pass;
 	private  UsersSelect() {
 		
 	}
 	
 	
 	private  UsersSelect(long id) {
 		this.id = id;
 		
 	}
 	
 	public static UsersSelect getSelect() {
 		return new UsersSelect();
 	}
 	
 	public static UsersSelect getIdSelecct(long id) {
 		return new  UsersSelect(id);
 	}
 	
 	public static UsersSelect getPageSelect(int pageNumber, int delta) {
 		UsersSelect sel = new UsersSelect();
 		sel.setRows((pageNumber-1)*delta+1, pageNumber*delta );
 		return sel;
 	}
 	
 	public static UsersSelect getUserPassSelect(String email, String pass) {
 		UsersSelect sel = new UsersSelect();
 		sel.pass = pass;
 		sel.email = email;
 		return sel;
 	}
 	
 	
 	@Override
 	protected String getSqlString() {
 		String sql = " select   user_id,username,fullname,email,end_date,created_date,password,image,skin from users  where 1=1 ";
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
 			Users model = new Users();
 					model.setId(rs.getLong ("user_id"));
		model.setUsername(rs.getString ("username"));
		model.setFullname(rs.getString ("fullname"));
		model.setEmail(rs.getString ("email"));
		model.setEnddate(rs.getDate ("end_date"));
		model.setCreateddate(rs.getDate ("created_date"));
		model.setPassword(rs.getString ("password"));
		model.setImage(rs.getString ("image"));
		model.setSkin(rs.getString ("skin"));

 			result.add(model);
 		}
 	}
 }

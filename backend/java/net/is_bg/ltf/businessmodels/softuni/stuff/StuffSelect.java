 package  net.is_bg.ltf.businessmodels.softuni.stuff;

 
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import net.is_bg.ltf.db.common.paging.SelectPagingSqlStatement;
 
 public class StuffSelect  extends SelectPagingSqlStatement<Stuff>{
 	
 private long id = 0;
 	private  StuffSelect() {
 		
 	}
 	
 	
 	private  StuffSelect(long id) {
 		this.id = id;
 		
 	}
 	
 	public static StuffSelect getSelect() {
 		return new StuffSelect();
 	}
 	
 	public static StuffSelect getIdSelecct(long id) {
 		return new  StuffSelect(id);
 	}
 	
 	public static StuffSelect getPageSelect(int pageNumber, int delta) {
 		StuffSelect sel = new StuffSelect();
 		sel.setRows((pageNumber-1)*delta+1, pageNumber*delta );
 		return sel;
 	}
 	
 	@Override
 	protected String getSqlString() {
 		String sql = " select   stuff_id,name,phone,image,description,user_id,work_hours,likes,dislikes from stuff ";
       sql+= (id > 0 ? " where stuff_id = " + id : ""); 
 		return super.rtnSqlString(sql);
 	}
 	
 	@Override
 	protected void retrieveResult(ResultSet rs) throws SQLException {
 		//
 		while(rs.next()) {
 			Stuff model = new Stuff();
 					model.setId(rs.getLong ("stuff_id"));
		model.setName(rs.getString ("name"));
		model.setPhone(rs.getString ("phone"));
		model.setImage(rs.getString ("image"));
		model.setDescription(rs.getString ("description"));
		model.setUserid(rs.getLong ("user_id"));
		model.setWorkhours(rs.getString ("work_hours"));
		model.setLikes(rs.getLong ("likes"));
		model.setDislikes(rs.getLong ("dislikes"));

 			result.add(model);
 		}
 	}
 }

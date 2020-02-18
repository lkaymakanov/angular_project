 package  net.is_bg.ltf.businessmodels.softuni.servicegroup;

 
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import net.is_bg.ltf.db.common.paging.SelectPagingSqlStatement;
 
 public class ServicegroupSelect  extends SelectPagingSqlStatement<Servicegroup>{
 	
 private long id = 0;
 	private  ServicegroupSelect() {
 		
 	}
 	
 	
 	private  ServicegroupSelect(long id) {
 		this.id = id;
 		
 	}
 	
 	public static ServicegroupSelect getSelect() {
 		return new ServicegroupSelect();
 	}
 	
 	public static ServicegroupSelect getIdSelecct(long id) {
 		return new  ServicegroupSelect(id);
 	}
 	
 	public static ServicegroupSelect getPageSelect(int pageNumber, int delta) {
 		ServicegroupSelect sel = new ServicegroupSelect();
 		sel.setRows((pageNumber-1)*delta+1, pageNumber*delta );
 		return sel;
 	}
 	
 	@Override
 	protected String getSqlString() {
 		String sql = " select   service_group_id,service_group_name from service_group ";
       sql+= (id > 0 ? " where service_group_id = " + id : ""); 
 		return super.rtnSqlString(sql);
 	}
 	
 	@Override
 	protected void retrieveResult(ResultSet rs) throws SQLException {
 		//
 		while(rs.next()) {
 			Servicegroup model = new Servicegroup();
 					model.setId(rs.getLong ("service_group_id"));
		model.setServicegroupname(rs.getString ("service_group_name"));

 			result.add(model);
 		}
 	}
 }

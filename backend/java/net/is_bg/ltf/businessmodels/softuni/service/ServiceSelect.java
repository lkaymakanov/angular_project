 package  net.is_bg.ltf.businessmodels.softuni.service;

 import java.sql.ResultSet;
 import java.sql.SQLException;
 import net.is_bg.ltf.db.common.paging.SelectPagingSqlStatement;
 
    public class ServiceSelect  extends SelectPagingSqlStatement<Service>{
 	
    private long id = 0;
    private long groupId = 0;
    private String name;
 	private  ServiceSelect() {
 		
 	}
 	
 	
 	private  ServiceSelect(long id) {
 		this.id = id;
 		
 	}
 	
 	public static ServiceSelect getSelect() {
 		return new ServiceSelect();
 	}
 	
 	public static ServiceSelect getIdSelecct(long id) {
 		return new  ServiceSelect(id);
 	}
 	
 	public static ServiceSelect getPageSelect(int pageNumber, int delta) {
 		ServiceSelect sel = new ServiceSelect();
 		sel.setRows((pageNumber-1)*delta+1, pageNumber*delta );
 		return sel;
 	}
 	
 	@Override
 	protected String getSqlString() {
 		String sql = " select   service_id,name,service_group_id,price from service where 1=1";
        sql+= (id > 0 ? " and service_id = " + id : ""); 
        if(groupId > 0) { sql+=" and service_group_id = ? "; bindVarData.setLong(groupId); }
        if(name !=null) {sql += " and upper(name) like '%" + name.toUpperCase() + "%'";}
 		return super.rtnSqlString(sql);
 	}
 	
 	@Override
 	protected void retrieveResult(ResultSet rs) throws SQLException {
 		//
 		while(rs.next()) {
 			Service model = new Service();
 					model.setId(rs.getLong ("service_id"));
		model.setName(rs.getString ("name"));
		model.setServicegroupid(rs.getLong ("service_group_id"));
		model.setPrice(rs.getBigDecimal ("price"));

 			result.add(model);
 		}
 	}


	public static ServiceSelect getGroupSelect(long groupid) {
		ServiceSelect s = new  ServiceSelect();
		s.groupId = groupid;
		return s;
	}


	public static ServiceSelect getNameSelect(String name) {
		ServiceSelect s = new  ServiceSelect();
		s.name = name;
		return s;
	}
 }

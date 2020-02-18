 package  net.is_bg.ltf.businessmodels.softuni.promotion;

 
 import java.sql.ResultSet;
 import java.sql.SQLException;

import net.is_bg.ltf.businessmodels.softuni.service.Service;
import net.is_bg.ltf.db.common.paging.SelectPagingSqlStatement;
 
 public class PromotionSelect  extends SelectPagingSqlStatement<Promotion>{
 	
 private long id = 0;
 	private  PromotionSelect() {
 		
 	}
 	
 	
 	private  PromotionSelect(long id) {
 		this.id = id;
 		
 	}
 	
 	public static PromotionSelect getSelect() {
 		return new PromotionSelect();
 	}
 	
 	public static PromotionSelect getIdSelecct(long id) {
 		return new  PromotionSelect(id);
 	}
 	
 	public static PromotionSelect getPageSelect(int pageNumber, int delta) {
 		PromotionSelect sel = new PromotionSelect();
 		sel.setRows((pageNumber-1)*delta+1, pageNumber*delta );
 		return sel;
 	}
 	
 	@Override
 	protected String getSqlString() {
 		String sql = " select   promotion_id,expire_date,s.service_id, p.discount, s.name, s.price from promotion p "
 				+ " join service s on s.service_id = p.service_id  ";
       sql+= (id > 0 ? " where promotion_id = " + id : ""); 
 		return super.rtnSqlString(sql);
 	}
 	
 	@Override
 	protected void retrieveResult(ResultSet rs) throws SQLException {
 		//
 		while(rs.next()) {
 			Promotion model = new Promotion();
 					model.setId(rs.getLong ("promotion_id"));
					model.setExpiredate(rs.getDate ("expire_date"));
					Service p  = model.getProcedure();
					p.setId(rs.getLong ("service_id"));
					model.setDicscount(rs.getLong ("discount"));
					p.setPrice(rs.getBigDecimal("price"));
					p.setName(rs.getString("name"));

 			result.add(model);
 		}
 	}
 }

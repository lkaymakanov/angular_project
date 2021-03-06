//This file is generated by LAK GenerateUtils...
package  net.is_bg.ltf.businessmodels.softuni.promotion;
import java.util.Date;

import net.is_bg.ltf.AbstractModel;
import net.is_bg.ltf.businessmodels.softuni.service.Service; 
/**
export interface  IPromotion{
	id:number,
	expiredate:Date ,
	serviceid:number,
	dicscount:number
}
*/
public class Promotion extends AbstractModel{


//member variables...
	private Date  expiredate;
	private Service  procedure = new Service();
	private long  dicscount;


//getters & setters
	public Date getExpiredate(){
		return expiredate;
	}
	public void setExpiredate(Date expiredate){
		this.expiredate = expiredate;
	}
	public Service getProcedure() {
		return procedure;
	}
	
	public void setProcedure(Service procedure) {
		this.procedure = procedure;
	}
	public long getDicscount(){
		return dicscount;
	}
	public void setDicscount(long dicscount){
		this.dicscount = dicscount;
	}
}
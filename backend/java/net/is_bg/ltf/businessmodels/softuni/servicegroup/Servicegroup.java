//This file is generated by LAK GenerateUtils...
package  net.is_bg.ltf.businessmodels.softuni.servicegroup;
import java.sql.*; 
import java.math.BigDecimal; 
import net.is_bg.ltf.AbstractModel; 
import java.util.Date; 
/**
export interface  IServicegroup{
	id:number,
	servicegroupname:string
}
*/
public class Servicegroup extends AbstractModel{


//member variables...
	private String  servicegroupname;


//getters & setters
	public String getServicegroupname(){
		return servicegroupname;
	}
	public void setServicegroupname(String servicegroupname){
		this.servicegroupname = servicegroupname;
	}
}
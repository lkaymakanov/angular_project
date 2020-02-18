//This file is generated by LAK GenerateUtils...
package  net.is_bg.ltf.businessmodels.softuni.reservation;
import java.sql.*; 
import java.math.BigDecimal; 
import net.is_bg.ltf.AbstractModel;
import net.is_bg.ltf.businessmodels.softuni.service.Service;

import java.util.Date; 
/**
export interface  IReservation{
	id:number,
	reservationdate:Date ,
	serviceid:number,
	userid:number,
	reservationfor:Date 
}
*/
public class Reservation extends AbstractModel{


//member variables...
	private Date  reservationdate;
	private Service  procedure = new Service();
	private BigDecimal  userid;
	private Date  reservationfor;

	public void setProcedure(Service procedure) {
		this.procedure = procedure;
	}
	
	public Service getProcedure() {
		return procedure;
	}

//getters & setters
	public Date getReservationdate(){
		return reservationdate;
	}
	public void setReservationdate(Date reservationdate){
		this.reservationdate = reservationdate;
	}
	
	public BigDecimal getUserid(){
		return userid;
	}
	public void setUserid(BigDecimal userid){
		this.userid = userid;
	}
	public Date getReservationfor(){
		return reservationfor;
	}
	public void setReservationfor(Date reservationfor){
		this.reservationfor = reservationfor;
	}
}
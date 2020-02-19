import { IProcedure } from './IProcedure';


export interface  IReservation{
	id:number,
	reservationdate:Date ,
	procedure:IProcedure,
	userid:number,
	reservationfor:Date 
}


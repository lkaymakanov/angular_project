import { IProcedure } from './IProcedure';

/***Promotions interface*/
export interface  IPromotion{
	id:number,              //primary key
	expiredate:Date ,       //date to which promotion is valid
	procedure:IProcedure,   //the procedure that is promoted
	dicscount:number        //the discount
}
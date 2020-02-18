import { IProcedure } from './IProcedure';

/***promotions interface*/
export interface  IPromotion{
	id:number,
	expiredate:Date ,
	procedure:IProcedure,
	dicscount:number
}
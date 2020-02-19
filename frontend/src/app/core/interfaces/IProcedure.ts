
/***Interface for saloon procedure types */
export interface  IProcedure{
	id:number,               //primary key
	name:string,             //pricedure name
	servicegroupid:number,   //the id of the group that procedure belongs to!
	price:number             //the price of procedure
}
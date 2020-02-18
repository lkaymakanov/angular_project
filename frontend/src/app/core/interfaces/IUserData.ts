
/**The data of registered user */
export interface  IUserdata{
	id:number,              //pk
	username:string,        //user name that is initialized to user mail when created
	email:string,           //user mail
	createddate:Date ,      //date on which user is created
	password:string,        //sha 512 of user pass
	image:string            //user image if any
}
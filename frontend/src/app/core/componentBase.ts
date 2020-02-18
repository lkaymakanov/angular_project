import { UserService } from '../user.service';
import { IUserdata } from './interfaces/IUserData';
import { IUserMailPass } from './interfaces/IUserMailPass';
import { environment } from 'src/environments/environment';

export class ComponentBase {

    constructor(private userService:UserService){

    }
    get isLogged() { return this.userService.isLogged; }

    get isDebug(){
        return environment.debug;
    }
  
    get curUser():IUserdata{
        let u : IUserdata = this.userService.curUser;
      // console.log( u);
       return u;
    }
}
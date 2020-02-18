import { UserService } from '../user.service';
import { IUserdata } from './interfaces/IUserData';
import { IUserMailPass } from './interfaces/IUserMailPass';
import { environment } from 'src/environments/environment';


/**Base component that each component extends!! */
export class ComponentBase {

    constructor(private userService:UserService){

    }
    /**returns true if user is logged... */
    get isLogged() { return this.userService.isLogged; }

    /**Returns true if debug flag is set in environment! 
     * Used to show debug  data & messages in templates if set! */
    get isDebug(){
        return environment.debug;
    }
  
    /**Retrieves the currently looged user... */
    get curUser():IUserdata{
        let u : IUserdata = this.userService.curUser;
      // console.log( u);
       return u;
    }
}

import { Injectable, Renderer2 } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { tap, shareReplay } from 'rxjs/operators';

import { environment } from 'src/environments/environment';
import { IUserdata } from './core/interfaces/IUserData';
import { IUserMailPass } from './core/interfaces/IUserMailPass';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  
  private  main : string = '/user_data';
  private apiEndPoint : string = environment.apiEndPoint;
  

  /**Sub pahts for create update & delete operations... */
	 // create  :'/create';
	 //update  : '/update';
	 //delete  : '/delete';
	 debug: true

  //currently looged user
  currentUser: IUserdata;

  //get the main path for user request to server API
  private getMainPath(){
    return this.apiEndPoint + this.main;
  }

  get isLogged() { return !!this.currentUser; }

  //check if user is authenticated - hot observable
  authCompleted$ = this.http.post(this.getMainPath() +'/auth', '').pipe(shareReplay(1));

  //return currebtly looged user
  get curUser():IUserdata{
    return this.currentUser;
  }

  /**Sets the current user from hot observable */
  constructor(private http: HttpClient) {
    this.authCompleted$.subscribe((user: IUserdata) => {
      this.currentUser = user;
    }, () => {
      this.currentUser = null;
    });
  }

  //login
  login(email: string, password: string) {
    let ep = this.getMainPath() + '/login';
    console.log(ep);
    let mailpass : IUserMailPass = {email: email, pass:password};
    return this.http.post(ep, mailpass).pipe(tap((user: IUserdata) => {
      this.currentUser = user;
    }));
  }

  //register
  register(email: string, password: string) {
    let mailpass : IUserMailPass = {email: email, pass:password};
    return this.http.post(this.getMainPath() + '/register', mailpass);
  }

  //logout
  logoutUser( onSuccess?: () => any)   {
    let path = this.getMainPath() + '/logout';
    console.log(path);

    return this.http.post(path, '').subscribe((el)=>{
      this.currentUser = null;
      if(!!onSuccess) onSuccess();
    }
    )
  }



  //change the user password
  changePass( pass:string):Observable<IUserdata>{
    let path = this.getMainPath() + '/changepass/' + this.currentUser.id;
    console.log(path);
    return this.http.post<IUserdata>(path, pass);
  }
 

}

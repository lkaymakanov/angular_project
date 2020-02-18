import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { IUserdata } from '../core/interfaces/IUserData';
import { UserService } from '../user.service';
import { ComponentBase } from '../core/componentBase';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent extends ComponentBase implements OnInit {

  emailRegex = new RegExp('[a-zA-Z0-9.-_]{6,}@abv.bg');
  loginError=null;

  get isLoginErr(){
    return this.loginError!=null;
  }

  get loginErr(){
    return this.loginError;
  }
  
  constructor(
    private userSer: UserService,
    private router: Router
  ) { super(userSer);}


  /*
  onfocusInputTxt(x){x.style.background = "#bcbcbc"; x.style.color = 'white';}
  onblurInputTxt(x){x.style.background = "white"; x.style.color = 'black';}
*/
  ngOnInit() {
  }

  handleLogin({email, password}:{email: string, password: string }) {
    this.loginError = null;
    this.userSer.login(email, password).subscribe(() => {
      //navigate to user profile
      this.router.navigate(['/user/profile']);
    }, (el)=>{
      //process error
      this.loginError = 'Invalid User / Password!'
    });
  }
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { IUserdata } from '../core/interfaces/IUserData';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  emailRegex = new RegExp('[a-zA-Z0-9.-_]{6,}@abv.bg');
  loginError=null;

  get loginErr(){
    return this.loginError;
  }

  get isLogged(){
     return  this.userService.isLogged;
  }

  get curUser():IUserdata{
    return this.userService.curUser;
  }

  constructor(
    private userService: UserService,
    private router: Router
  ) { }


  onfocusInputTxt(x){x.style.background = "#bcbcbc"; x.style.color = 'white';}
  onblurInputTxt(x){x.style.background = "white"; x.style.color = 'black';}

  ngOnInit() {
  }

  handleLogin({email, password}:{email: string, password: string }) {
    this.userService.login(email, password).subscribe(() => {
      //navigate to home
      this.router.navigate(['/user/profile']);
    }, (el)=>{
      //process error
      this.loginError = 'Invalid User / Password!'
    });
  }
}

import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ComponentBase } from '../core/componentBase';
import { UserService } from '../user.service';
import { IUserMailPass } from '../core/interfaces/IUserMailPass';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent extends ComponentBase  implements OnInit {


  registerErr=null;

  get isRegErr(){
    return this.registerErr!=null;
  }

  get regErr(){
    return this.registerErr;
  }

  constructor(
     private userSer:UserService,
     private router: Router) {
    super(userSer);
   }

  ngOnInit() {
    
  }

  register(formVal : {email: string, passwords: { password: string, rePassword: string } }){
    let emailpass : IUserMailPass = {email:formVal.email, pass:formVal.passwords.password};
    this.userSer.register(emailpass).subscribe(
      ()=>{
        this.router.navigate(['/home']);
      },()=>{
        this.registerErr ='Registration Failed..'
      }
    );
    //this.userService.register()
  }




}

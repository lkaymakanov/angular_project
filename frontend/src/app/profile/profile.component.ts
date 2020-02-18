import { Component, OnInit } from '@angular/core';
import { ComponentBase } from '../core/componentBase';
import { UserService } from '../user.service';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent extends ComponentBase implements OnInit {


  changepass:boolean=false;

  constructor(private ser:UserService, 
    private router:Router) {
    super(ser)
   }

  

  ngOnInit() {

  }



  btnConfirmPass(formval: {password:string, repassword:string}){
    console.log(formval.password);
    this.ser.changePass(formval.password).subscribe(
      (el)=>{
        //navigate to login after sucessfull pass change!!!
        this.ser.logoutUser(()=>
          {this.router.navigate(['/login'], );}
        );
      },()=>{
        //error
      }
    )
  }

}

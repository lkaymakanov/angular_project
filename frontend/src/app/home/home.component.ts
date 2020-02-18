import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { IUserdata } from '../core/interfaces/IUserData';
import { UserService } from '../user.service';
import { ComponentBase } from '../core/componentBase';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent extends ComponentBase implements OnInit {
  constructor(
    private user: UserService,
    private router: Router
  ) { super(user) }

  ngOnInit(){

  }
}

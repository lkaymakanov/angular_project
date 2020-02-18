import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/user.service';


@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent implements OnInit {


  get isLogged() { return this.userService.isLogged; }

  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  logout() {
    console.log('Entered in log out');
    this.userService.logoutUser();
    this.router.navigate(['']);
  }
}
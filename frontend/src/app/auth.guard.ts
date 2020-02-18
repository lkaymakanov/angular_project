import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

import { map, catchError } from 'rxjs/operators';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
   constructor(private userService : UserService){

   }

  canActivate(
    route: ActivatedRouteSnapshot, 
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

      const shouldBeLogged = route.data.isLogged;
      console.log('shoud be logged = '+ shouldBeLogged);
      const isLogged = this.userService.isLogged;
      //console.log('is logged:'+isLogged);
      if (!this.userService.isLogged) {
        //console.log('user service islogged..='+this.userService.isLogged);
        return this.userService.authCompleted$.pipe(map(user => !!user), catchError(err => [false]));
        //return shouldBeLogged === isLogged;
      }
      return true;
    }
}

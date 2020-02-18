import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { IReservation } from './core/interfaces/IReservation';
import { Observable } from 'rxjs';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {



  private main:string = '/reservation';
   

  private getMainPath(){
    return environment.apiEndPoint + this.main;
  }

  constructor(private http:HttpClient ) { 

  }

  loadReserVations (userId: number):Observable<IReservation[]>{
    return this.http.get<IReservation[]>(this.getMainPath() + '/user/' +userId);
  }




}

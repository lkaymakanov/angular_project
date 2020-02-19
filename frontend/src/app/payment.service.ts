import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IPayment } from './core/interfaces/IPayment';
import { IReservation } from './core/interfaces/IReservation';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  
  constructor(private http:HttpClient ) { 

  }

  private main:string = '/payment';
   

  private getMainPath(){
    return environment.apiEndPoint + this.main;
  }

  /**confirm payment */
  confirmPayment(p : IPayment):Observable<any> {
    console.log('entered in confirm payment...' + p)
    return this.http.post<Observable<any>>(this.getMainPath() + '/create', p);
  }

  

  /**load payments for user  */
  loadPayments(userId:number):Observable<IPayment[]>{
    return this.http.get<IPayment[]>(this.getMainPath()+'/user/'+userId);
  }
  
}

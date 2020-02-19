import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IPayment } from './core/interfaces/IPayment';
import { IReservation } from './core/interfaces/IReservation';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  
  constructor() { }

  confirmPayment(p : IPayment):Observable<any> {
    //throw new Error("Method not implemented.");
    console.log('entered in confirm payment...' + p)
    return null;
  }

  loadPayments():Observable<IPayment>{
    return null;
  }
  
}

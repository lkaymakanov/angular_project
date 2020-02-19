import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { ReservationService } from '../reservation.service';
import { PaymentService } from '../payment.service';
import { IReservation } from '../core/interfaces/IReservation';
import { Observable } from 'rxjs';
import { ComponentBase } from '../core/componentBase';
import { IPayment } from '../core/interfaces/IPayment';

@Component({
  selector: 'app-payments',
  templateUrl: './payments.component.html',
  styleUrls: ['./payments.component.scss']
})
export class PaymentsComponent extends ComponentBase implements OnInit {


  //load unpaid reservation
  unpaidReservations$: Observable<IReservation[]>;
  selReservationToPay : IReservation;
  display:string;
  

  constructor(private userSer:UserService, 
    private resService:ReservationService, 
    private payservice:PaymentService) {
      super(userSer);
      this.display = 'none';
  }
  ngOnInit() {
    
    this.display = 'none';
    this.loadUnpaidReservations();
  }


  loadUnpaidReservations() {
    this.unpaidReservations$ = this.resService.loadUnpaidReservations(this.curUser.id);
  }


  //select procedure for reservation
  selectReservation(reservation : IReservation ){
     this.selReservationToPay = reservation;
  }

  //show panel for new reservation
  makePayment(){
    this.display = 'block';
   
  }

  cancelPayment(){
    this.display = 'none';
    this.selReservationToPay = null;
    //console.log('cancelPayment...');
  }

  

  /**confirm payment */
  confirmPayment(formValue : {cardTypeId: string, cardNo:string}){
    //submit form
    console.log(formValue);
    
    let newPayment:IPayment = {id:0, paycardid:+(formValue.cardNo), paytime:new Date(), sum:this.selReservationToPay.procedure.price, reservationid:this.selReservationToPay.id};  
    console.log(formValue);

    this.payservice.confirmPayment(newPayment)
    .subscribe(
      (el)=>{
        this.display = 'none';
        this.selReservationToPay = null;
      }
    );
  
    //refesh unpaid reservations
    this.loadUnpaidReservations();
    
  }




}

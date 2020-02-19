import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { ReservationService } from '../reservation.service';
import { ComponentBase } from '../core/componentBase';
import { UserService } from '../user.service';
import { IReservation } from '../core/interfaces/IReservation';
import { Observable, fromEvent } from 'rxjs';
import { IProcedure } from '../core/interfaces/IProcedure';
import { map, startWith, debounceTime } from 'rxjs/operators';
import { ProcedureService } from '../procedure.service';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.scss']
})
export class ReservationsComponent extends ComponentBase  implements OnInit {

  
  reservations$: Observable<IReservation[]>;
  newResrvation : IReservation;
  //showNewReservation:boolean;  //show / hide new reservation panel
  selprocedure: IProcedure;    //the selected procedure fromm search box
  procedures$ : Observable<IProcedure[]>;   //the observable containig filterred procedures
  

  //the search procedure input field
  @ViewChild("inpitSearch", {static:true}) input: ElementRef;
  display:string;

  constructor( private userSer:UserService, 
    private resService:ReservationService, 
    private procService:ProcedureService) {
      
    super(userSer);
    this.display = 'none';
  }
  


  ngOnInit() {
    //retrieve current user reservations
    this.loadReservations();

    //add event listener for search procedure for resrvation input field
    const terms$ = fromEvent<any>(this.input.nativeElement, 'keyup').pipe(
      debounceTime(300),
      map(event => event.target.value),
    ).subscribe(
      (el)=>{
        //load procedures to select for reservation
        this.procedures$ = this.procService.loadProcByName((el as string));
      }
    );
  }

  //select procedure for reservation
  selectProc(proc : IProcedure ){
     this.selprocedure = proc;
     
  }

  //show panel for new reservation
  makeReservation(){
    this.display = 'block';
   
  }

  cancelReservation(){
    this.display = 'none';
   
  }

  //load my reservations
  loadReservations(){
    this.reservations$ =  this.resService.loadReserVations(this.curUser.id);
  }

  /**confirm new reservation */
  confirmReservation(){
    //submit reservation
    let p:IProcedure ={id:this.selprocedure.id,name:this.selprocedure.name,price:0,servicegroupid: this.selprocedure.servicegroupid};
    let r: IReservation= {id:0, procedure:p, reservationdate:new Date(), reservationfor : new Date(),userid:this.curUser.id };
    this.resService.makeReservation(r).subscribe(
      (el)=>{
        this.display = 'none';
        this.selectProc = null;
      
      }
    );
  
    //refesh my reservations
    this.loadReservations();
     
  }






}

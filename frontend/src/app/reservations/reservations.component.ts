import { Component, OnInit } from '@angular/core';
import { ReservationService } from '../reservation.service';
import { ComponentBase } from '../core/componentBase';
import { UserService } from '../user.service';
import { IReservation } from '../core/interfaces/IReservation';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.scss']
})
export class ReservationsComponent extends ComponentBase  implements OnInit {

  
  reservations: IReservation[];

  constructor( private userSer:UserService, private resService:ReservationService) {
    super(userSer);
  }
  


  ngOnInit() {
    this.resService.loadReserVations(this.curUser.id).subscribe(
      (el)=>{
        this.reservations = el;
      },()=>{
        
      }
    )
  }

}

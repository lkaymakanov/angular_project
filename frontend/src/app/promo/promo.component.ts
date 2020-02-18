import { Component, OnInit } from '@angular/core';
import { ComponentBase } from '../core/componentBase';
import { UserService } from '../user.service';
import { PromoService } from '../promo.service';
import { IPromotion } from '../core/interfaces/IPromotion';

@Component({
  selector: 'app-promo',
  templateUrl: './promo.component.html',
  styleUrls: ['./promo.component.scss']
})
export class PromoComponent extends ComponentBase implements OnInit {

  promotions : IPromotion[];

  constructor(private uservice : UserService,
    private promoService:PromoService) {
    super(uservice);
   }

  calcPrice( promo:IPromotion){
    return promo.procedure.price - ((promo.dicscount/100)*promo.procedure.price);
  }


  isExpired(promo:IPromotion){
    return promo.expiredate < new Date();
  }

  

  ngOnInit() {
    //load promotions
    this.promoService.loadPromotions().subscribe(
      (el)=>{
        this.promotions = el;
      },()=>{
        this.promotions = null;
      }
    )

  }

}

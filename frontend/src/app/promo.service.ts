import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { IPromotion } from './core/interfaces/IPromotion';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PromoService {

  private main:string = '/promotion';
   

  private getMainPath(){
    return environment.apiEndPoint + this.main;
  }

  constructor(private http:HttpClient ) { 

  }

  loadPromotions ():Observable<IPromotion[]>{
    return this.http.get<IPromotion[]>(this.getMainPath());
  }
}

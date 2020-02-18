import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IStuff } from './core/interfaces/IStuff';


//loads the stuff working in saloon
@Injectable({
  providedIn: 'root'
})
export class StuffService {

  private main:string = '/stuff';
   

  private getMainPath(){
    return environment.apiEndPoint + this.main;
  }

  constructor(private http:HttpClient ) { 

  }

  loadStuff ():Observable<IStuff[]>{
    return this.http.get<IStuff[]>(this.getMainPath());
  }

}

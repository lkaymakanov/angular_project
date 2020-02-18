import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { IProcdeureGroup } from './core/interfaces/IProcedureGroup';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProceduregroupService {

  constructor(private http:HttpClient) { }

  private main:string = '/service_group';
   

  private getMainPath(){
    return environment.apiEndPoint + this.main;
  }
 
  //loads groups of procedures in the saloon
  loadProcedureGroups ():Observable<IProcdeureGroup[]>{
    return this.http.get<IProcdeureGroup[]>(this.getMainPath());
  }



 


}

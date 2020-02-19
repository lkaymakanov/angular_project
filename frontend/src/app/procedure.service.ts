import { Injectable, Input } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { IProcdeureGroup } from './core/interfaces/IProcedureGroup';
import { Observable } from 'rxjs';
import { IProcedure } from './core/interfaces/IProcedure';

@Injectable({
  providedIn: 'root'
})
//service that loads saloon procedures
export class ProcedureService {
  

  private main:string = '/service';
 

  private getMainPath(){
    return environment.apiEndPoint + this.main;
  }
  constructor(private http:HttpClient) {}
 
  
  /**Load procedure fo procdeure group */
  loadProcForGroup(groupid:number) :Observable<IProcedure[]>{
    let path = this.getMainPath();
    path = path +'/group/'+ groupid ;
    return this.http.get<IProcedure[]>(path);
  }
  

  /**search procedure by proc name... */
  loadProcByName(procname: string):Observable<IProcedure[]>{
    //throw new Error("Method not implemented.");
    let path = this.getMainPath();
    path = path +'/selectByName?name='+ procname ;
    return this.http.get<IProcedure[]>(path);
  }

}

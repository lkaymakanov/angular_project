import { HttpInterceptor, HttpEvent, HttpHandler, HttpRequest, HttpHeaders } from "@angular/common/http";
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
export class Appinterceptor implements HttpInterceptor{
    
        intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>>{


           console.log('enterd in interceptor url = ' + req.url)
           return next.handle(req.clone({withCredentials:true}));
         }

}
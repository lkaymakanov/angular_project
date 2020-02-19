import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { StuffService } from '../stuff.service';
import { IStuff } from '../core/interfaces/IStuff';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-stuff',
  templateUrl: './stuff.component.html',
  styleUrls: ['./stuff.component.scss']
})
export class StuffComponent implements OnInit {

  //stuff to be loaded
  stuff$ : Observable< IStuff[]>;


  constructor(private stuffserivce:StuffService) {

  }

  /**add prefix to each stuff image */
  imageUrl(s:IStuff){
    return 'assets/stuff/'+s.image;
  }

  
  ngOnInit() { 
   //load stuff 
    this.stuff$ = this.stuffserivce.loadStuff();
    
  }

}

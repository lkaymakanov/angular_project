import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { StuffService } from '../stuff.service';
import { IStuff } from '../core/interfaces/IStuff';

@Component({
  selector: 'app-stuff',
  templateUrl: './stuff.component.html',
  styleUrls: ['./stuff.component.scss']
})
export class StuffComponent implements OnInit {

  //stuff to be loaded
  stuff : IStuff[];


  constructor(private stuffserivce:StuffService) {

  }

  /**add prefix to each stuff image */
  imageUrl(s:IStuff){
    return 'assets/stuff/'+s.image;
  }

  
  ngOnInit() {
    //console.log('entered in load stuff');

    //load stuff 
    this.stuffserivce.loadStuff().subscribe(
        (el)=>{
        this.stuff = el;
      },()=>{
        this.stuff = null;
      }
    );
    
  }

}

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-gallery',
  templateUrl: './gallery.component.html',
  styleUrls: ['./gallery.component.scss']
})
export class GalleryComponent implements OnInit {

  images: {imgsrc:string, imgdesc: string}[];
  private parentFolder:string = '../../assets/saloon/';
 

  constructor() {
    this.images = [
      {imgsrc:'sal-1.png', imgdesc :''},
      {imgsrc:'sal-2.png', imgdesc :''},
      {imgsrc:'sal-3.jpg', imgdesc :''},
      {imgsrc:'sal-4.jpg', imgdesc :''},
      {imgsrc:'sal-5.jfif', imgdesc :''},
      {imgsrc:'sal-6.jfif', imgdesc :''},
      {imgsrc:'sal-7.jfif', imgdesc :''},
      {imgsrc:'sal-8.jfif', imgdesc :''},
      {imgsrc:'sal-9.jfif', imgdesc :''},
      {imgsrc:'sal-10.jfif', imgdesc :''}
    ]
   }

  ngOnInit() {
    //forEach(element => console.log(element));
    this.images.forEach(
      (el)=>{
        el.imgsrc = this.parentFolder + el.imgsrc;
      }
    );
    //console.log(this.modimages);
  }



 
 
}

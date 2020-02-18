import { Component, OnInit } from '@angular/core';
import { ProceduregroupService } from '../proceduregroup.service';
import { IProcdeureGroup } from '../core/interfaces/IProcedureGroup';

@Component({
  selector: 'app-saloonprocgroup',
  templateUrl: './saloonprocgroup.component.html',
  styleUrls: ['./saloonprocgroup.component.scss']
})
export class SaloonprocgroupComponent implements OnInit {

  procGroups:IProcdeureGroup[];

  constructor(private service : ProceduregroupService) { }
  
  
  ngOnInit() {
    //load the procedure groups
    this.service.loadProcedureGroups().subscribe(
      (el)=>{
        this.procGroups = el;
      },()=>{
        this.procGroups = null;
      }
    );
  }

}

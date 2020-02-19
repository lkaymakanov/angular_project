import { Component, OnInit } from '@angular/core';
import { ProceduregroupService } from '../proceduregroup.service';
import { IProcdeureGroup } from '../core/interfaces/IProcedureGroup';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-saloonprocgroup',
  templateUrl: './saloonprocgroup.component.html',
  styleUrls: ['./saloonprocgroup.component.scss']
})
export class SaloonprocgroupComponent implements OnInit {

  procGroups$: Observable< IProcdeureGroup[]>;
  constructor(private service : ProceduregroupService) { }
  
  ngOnInit() {
    //load the procedure groups
    this.procGroups$= this.service.loadProcedureGroups();
  }

}

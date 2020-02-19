import { Component, OnInit, Input } from '@angular/core';
import { ProcedureService } from '../procedure.service';
import { IProcdeureGroup } from '../core/interfaces/IProcedureGroup';
import { IProcedure } from '../core/interfaces/IProcedure';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-saloonproc',
  templateUrl: './saloonproc.component.html',
  styleUrls: ['./saloonproc.component.scss']
})
export class SaloonprocComponent implements OnInit {


  constructor(private service:ProcedureService) { }

  @Input('group') group : IProcdeureGroup;
  procedures$:Observable<IProcedure[]>;
  
  
  ngOnInit() {
    this.procedures$ = this.service.loadProcForGroup(this.group.id);
  }
}

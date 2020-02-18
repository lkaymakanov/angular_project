import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SaloonprocgroupComponent } from './saloonprocgroup.component';

describe('SaloonprocgroupComponent', () => {
  let component: SaloonprocgroupComponent;
  let fixture: ComponentFixture<SaloonprocgroupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SaloonprocgroupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SaloonprocgroupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

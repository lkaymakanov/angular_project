import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SaloonprocComponent } from './saloonproc.component';

describe('SaloonprocComponent', () => {
  let component: SaloonprocComponent;
  let fixture: ComponentFixture<SaloonprocComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SaloonprocComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SaloonprocComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

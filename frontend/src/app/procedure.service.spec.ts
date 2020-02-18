import { TestBed } from '@angular/core/testing';

import { ProcedureService } from './procedure.service';

describe('ProcedureService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ProcedureService = TestBed.get(ProcedureService);
    expect(service).toBeTruthy();
  });
});

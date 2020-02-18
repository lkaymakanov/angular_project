import { TestBed } from '@angular/core/testing';

import { ProceduregroupService } from './proceduregroup.service';

describe('ProceduregroupService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ProceduregroupService = TestBed.get(ProceduregroupService);
    expect(service).toBeTruthy();
  });
});

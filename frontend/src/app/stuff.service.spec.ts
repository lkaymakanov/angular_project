import { TestBed } from '@angular/core/testing';

import { StuffService } from './stuff.service';

describe('StuffService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: StuffService = TestBed.get(StuffService);
    expect(service).toBeTruthy();
  });
});

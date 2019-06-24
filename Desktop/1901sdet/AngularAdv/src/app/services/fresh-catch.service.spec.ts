import { TestBed } from '@angular/core/testing';

import { FreshCatchService } from './fresh-catch.service';

describe('FreshCatchService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FreshCatchService = TestBed.get(FreshCatchService);
    expect(service).toBeTruthy();
  });
});

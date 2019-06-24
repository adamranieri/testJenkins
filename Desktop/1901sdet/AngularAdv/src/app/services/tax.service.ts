import { Injectable } from '@angular/core';
import { entree } from '../models/entree';

@Injectable({
  providedIn: 'root'
})
export class TaxService {

  constructor() { 

  }

  calculateTax(meal:entree){

    return meal.price * .05;

  };

}

import { Component, OnInit } from '@angular/core';
import { entree } from 'src/app/models/entree';
import { TaxService } from 'src/app/services/tax.service';
import { Observable } from 'rxjs';
import { FreshCatchService } from 'src/app/services/fresh-catch.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(private taxservice:TaxService, private fcs:FreshCatchService) { }

  ngOnInit() {
  }

  crab:entree = new entree("King Crab", 55);
  lobster:entree = new entree("Lobster Meatballs",28);
  salad:entree = new entree("Mango Shrimp Salad",15);
  freshfood:Observable<entree> = this.fcs.getRecentCatches();



  meals:Array<entree> = [this.crab,this.lobster,this.salad];

  recentcatches:entree;

  showTax(){
    console.log(this.taxservice.calculateTax(this.crab));
  }

  showFreshOptions(){
    this.freshfood.subscribe(
    // function to execute when the observable recieves information
    // sucessfully
    (response)=>{
      console.log(response);
      this.recentcatches= response;
    }
    , 
    // function to execute when the observable recieves incorrect/faulty information
    (response)=>{console.log("Sorry it failed")}
    // optional third function for what to do when the call is complete
    )
  }


}

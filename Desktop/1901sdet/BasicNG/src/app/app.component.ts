import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  hello :string = "Hello My name is adam";

  espn :string= "http://www.espn.com/";

  cheer :string ="Lets go Gators";

  showparagraph :boolean = false;

  money :number = 90;

  ray :Array<string> =["Ness","Ryu","Ken","Roy","Ike" ] 

   sayHello() {
    console.log("Hello Everyone")
  }

}

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { BioComponent } from './components/bio/bio.component';
import { MenuComponent } from './components/menu/menu.component';
import { TaxService } from './services/tax.service';
import { FreshCatchService } from './services/fresh-catch.service';

@NgModule({
  declarations: [
    AppComponent,
    BioComponent,
    MenuComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [TaxService,FreshCatchService],
  bootstrap: [AppComponent]
})
export class AppModule { }

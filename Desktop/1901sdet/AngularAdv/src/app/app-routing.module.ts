import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BioComponent } from './components/bio/bio.component'
import { MenuComponent } from './components/menu/menu.component';


const routes: Routes = [

  {path : 'bio', component : BioComponent},
  {path : 'menu', component : MenuComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

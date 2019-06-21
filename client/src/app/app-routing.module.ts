import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FlightListComponent } from "./flight-list/flight-list.component";
import {FlightCreateComponent} from "./flight-create/flight-create.component";
import {FlightEditComponent} from "./flight-edit/flight-edit.component";
import {TouristListComponent} from "./tourist-list/tourist-list.component";
import {TouristCreateComponent} from "./tourist-create/tourist-create.component";
import {TouristEditComponent} from "./tourist-edit/tourist-edit.component";
import {TouristFlightsListComponent} from "./tourist-flights-list/tourist-flights-list.component";
import {TouristFlightAddComponent} from "./tourist-flight-add/tourist-flight-add.component";
const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'flights'},
  {path: 'flights', component: FlightListComponent},
  {path: 'create-flight', component: FlightCreateComponent},
  {path: 'edit-flight/:id', component: FlightEditComponent},
  {path: 'tourists', component: TouristListComponent},
  {path: 'create-tourist', component: TouristCreateComponent},
  {path: 'edit-tourist/:id', component: TouristEditComponent},
  {path: 'tourist-flights/:id', component: TouristFlightsListComponent},
  {path: 'add-tourist-flight/:id', component: TouristFlightAddComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

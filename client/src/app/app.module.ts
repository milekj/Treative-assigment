import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from  '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FlightListComponent } from './flight-list/flight-list.component';
import { FlightCreateComponent } from './flight-create/flight-create.component';
import {FormsModule} from "@angular/forms";
import {MatButtonModule, MatFormFieldModule, MatInputModule, MatRippleModule} from "@angular/material";
import { FlightEditComponent } from './flight-edit/flight-edit.component';
import { TouristCreateComponent } from './tourist-create/tourist-create.component';
import { TouristEditComponent } from './tourist-edit/tourist-edit.component';
import { TouristListComponent } from './tourist-list/tourist-list.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { TouristFlightsListComponent } from './tourist-flights-list/tourist-flights-list.component';
import { TouristFlightAddComponent } from './tourist-flight-add/tourist-flight-add.component';
import { FlightTouristsListComponent } from './flight-tourists-list/flight-tourists-list.component';
import { FlightTouristAddComponent } from './flight-tourist-add/flight-tourist-add.component';

@NgModule({
  declarations: [
    AppComponent,
    FlightListComponent,
    FlightCreateComponent,
    FlightEditComponent,
    TouristCreateComponent,
    TouristEditComponent,
    TouristListComponent,
    TouristFlightsListComponent,
    TouristFlightAddComponent,
    FlightTouristsListComponent,
    FlightTouristAddComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatRippleModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

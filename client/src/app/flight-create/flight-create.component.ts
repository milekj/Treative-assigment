import {Component, Input, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { FlightService } from "../services/flight.service";

@Component({
  selector: 'app-flight-create',
  templateUrl: '../flight-create-edit.component.html',
  styleUrls: ['./flight-create.component.css']
})
export class FlightCreateComponent implements OnInit {
  @Input() flight = {
    departureDateTime: '',
    arrivalDateTime: '',
    placesNumber: '',
    ticketPrice: ''
  };
  @Input() isCreated = true;
  @Input() today = new Date().toISOString();
  constructor(public flightService: FlightService, public router: Router) { }

  ngOnInit() {
  }
  createFlight() {
    this.flightService.create(this.flight).subscribe((data: {}) => {
      this.router.navigate(['/flights'])
    })
  }

}

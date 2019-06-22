import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FlightService} from "../services/flight.service";

@Component({
  selector: 'app-tourist-flight-add',
  templateUrl: '../flight-list.component.html',
  styleUrls: ['./tourist-flight-add.component.css']
})
export class TouristFlightAddComponent implements OnInit {
  @Input() id = this.actRoute.snapshot.params['id'];
  @Input() mode = 'tourist-add';
  Flights: any = [];
  constructor(public flightService: FlightService, public actRoute: ActivatedRoute, public router: Router) { }

  ngOnInit() {
    this.loadFlights()
  }

  loadFlights() {
    return this.flightService.getAll()
      .subscribe((data: {}) => {this.Flights = data;},
        error => alert("Could not load flights. The flight or the tourist does not exist."))
  }

  addTouristFlight(flightId) {
    this.flightService.addToTourist(flightId, this.id)
      .subscribe((data: {}) => {this.router.navigate([`/tourist-flights/${this.id}`]);},
        error => alert("Could not add the flight. " +
          "Possibly there is not enough places or the tourist is already added"))
  }
}

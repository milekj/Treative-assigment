import { Component, OnInit } from '@angular/core';
import { FlightService } from "../services/flight.service";

@Component({
  selector: 'app-flight-list',
  templateUrl: './flight-list.component.html',
  styleUrls: ['./flight-list.component.css']
})
export class FlightListComponent implements OnInit {
  Flights: any = [];
  constructor(private flightService: FlightService) { }

  ngOnInit() {
    this.loadFlights()
  }

  loadFlights() {
    return this.flightService.getAll()
      .subscribe((data: {}) => {
        this.Flights = data;
      })
  }

  deleteFlight(id) {
    if (window.confirm("Are you sure you want to delete flight with id" + id)) {
      this.flightService.delete(id).subscribe((data: {}) => {
        this.loadFlights()
      })
    }
  }

}

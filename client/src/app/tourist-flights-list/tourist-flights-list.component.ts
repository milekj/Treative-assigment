import {Component, Input, OnInit} from '@angular/core';
import {TouristService} from "../services/tourist.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-tourist-flights-list',
  templateUrl: '../flight-list.component.html',
  styleUrls: ['./tourist-flights-list.component.css']
})
export class TouristFlightsListComponent implements OnInit {
  @Input() id = this.actRoute.snapshot.params['id'];
  @Input() mode = 'tourist';
  Flights: any = [];
  constructor(public touristService: TouristService, public actRoute: ActivatedRoute, public router: Router) { }

  ngOnInit() {
    this.loadTouristFlights()
  }

  loadTouristFlights() {
    return this.touristService.getFlights(this.id)
      .subscribe((data: {}) => {this.Flights = data;},
        error => alert("Could not load flights. The tourist probably does not exist."))
  }

  deleteTouristFlight(flightId) {
    if (window.confirm("Are you sure you want to delete the flight from the tourist's list?")) {
      this.touristService.deleteFlight(this.id, flightId)
        .subscribe((data: {}) => {
          this.loadTouristFlights()
        })
    }
  }

}

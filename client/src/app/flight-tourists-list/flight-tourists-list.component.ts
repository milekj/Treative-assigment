import {Component, Input, OnInit} from '@angular/core';
import {TouristService} from "../services/tourist.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FlightService} from "../services/flight.service";

@Component({
  selector: 'app-flight-tourists-list',
  templateUrl: '../tourist-list.component.html',
  styleUrls: ['./flight-tourists-list.component.css']
})
export class FlightTouristsListComponent implements OnInit {
  @Input() id = this.actRoute.snapshot.params['id'];
  @Input() mode = 'flight';
  Tourists: any = [];
  constructor(public touristService: TouristService,
              public flightService: FlightService,
              public actRoute: ActivatedRoute,
              public router: Router) { }

  ngOnInit() {
    this.loadFlightTourists()
  }

  loadFlightTourists() {
    return this.flightService.getTourists(this.id)
      .subscribe((data: {}) => {this.Tourists = data;},
        error => alert("Could not load tourists. The flight probably does not exist."))
  }

  deleteFlightTourist(touristId) {
    if (window.confirm("Are you sure you want to delete the tourist from the flight's list?")) {
      this.touristService.deleteFlight(touristId, this.id)
        .subscribe((data: {}) => {
          this.loadFlightTourists()
        })
    }
  }

}

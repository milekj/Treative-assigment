import {Component, Input, OnInit} from '@angular/core';
import {FlightService} from "../services/flight.service";
import {ActivatedRoute, Router} from "@angular/router";
import {TouristService} from "../services/tourist.service";

@Component({
  selector: 'app-flight-tourist-add',
  templateUrl: '../tourist-list.component.html',
  styleUrls: ['./flight-tourist-add.component.css']
})
export class FlightTouristAddComponent implements OnInit {
  @Input() id = this.actRoute.snapshot.params['id'];
  @Input() mode = 'flight-add';
  Tourists: any = [];
  constructor(public flightService: FlightService,
              public touristService: TouristService,
              public actRoute: ActivatedRoute,
              public router: Router) { }

  ngOnInit() {
    this.loadTourists()
  }

  loadTourists() {
    return this.touristService.getAll()
      .subscribe((data: {}) => {this.Tourists = data;},
        error => alert("Could not load tourists. The flight or the tourist does not exist."))
  }

  addFlightTourist(touristId) {
    this.flightService.addToTourist(this.id, touristId)
      .subscribe((data: {}) => {this.router.navigate([`/flight-tourists/${this.id}`]);},
        error => alert("Could not add flight. " +
          "Possibly there is not enough places or the tourist is already added"))
  }

}

import {Component, Input, OnInit} from '@angular/core';
import { FlightService} from "../services/flight.service";
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-flight-edit',
  templateUrl: '../flight-create-edit.component.html',
  styleUrls: ['./flight-edit.component.css']
})
export class FlightEditComponent implements OnInit {
  @Input() isCreated = false;
  id = this.actRoute.snapshot.params['id'];
  flight: any = {};

  constructor(public flightService: FlightService, public actRoute: ActivatedRoute, public router: Router) { }

  ngOnInit() {
     this.flightService.getById(this.id).subscribe((data: {}) => {
       delete data['id'];
       delete data['touristsIds'];
       this.flight = data
     })
  }

  editFlight() {
    this.flightService.update(this.id, this.flight).subscribe((data: {}) => {
      this.router.navigate(['/flights'])
    })
  }

}

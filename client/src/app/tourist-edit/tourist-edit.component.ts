import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {TouristService} from "../services/tourist.service";

@Component({
  selector: 'app-tourist-edit',
  templateUrl: '../tourist-create-edit.component.html',
  styleUrls: ['./tourist-edit.component.css']
})
export class TouristEditComponent implements OnInit {
  @Input() isCreated = false;
  @Input() today = new Date().toISOString();
  id = this.actRoute.snapshot.params['id'];
  tourist: any = {};

  constructor(public touristService: TouristService, public actRoute: ActivatedRoute, public router: Router) { }

  ngOnInit() {
    this.touristService.getById(this.id).subscribe((data: {}) => {
      delete data['id'];
      delete data['flightsIds'];
      this.tourist = data
    })
  }

  editTourist() {
    this.touristService.update(this.id, this.tourist).subscribe((data: {}) => {
      this.router.navigate(['/tourists'])
    })
  }

}

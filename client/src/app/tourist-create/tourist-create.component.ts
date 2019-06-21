import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {TouristService} from "../services/tourist.service";

@Component({
  selector: 'app-tourist-create',
  templateUrl: '../tourist-create-edit.component.html',
  styleUrls: ['./tourist-create.component.css']
})
export class TouristCreateComponent implements OnInit {
  @Input() tourist = {
    firstName: '',
    lastName: '',
    gender: 'FEMALE',
    country: '',
    dateOfBirth: '',
    notes: ''
  };
  @Input() isCreated = true;
  @Input() today = new Date().toISOString();

  constructor(public touristService: TouristService, public router: Router) { }

  ngOnInit() {
  }

  createTourist() {
    console.log(this.tourist);
    this.touristService.create(this.tourist).subscribe((data: {}) => {
      this.router.navigate(['/tourists'])
    })
  }

}

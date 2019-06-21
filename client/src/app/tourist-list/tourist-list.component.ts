import {Component, Input, OnInit} from '@angular/core';
import {TouristService} from "../services/tourist.service";

@Component({
  selector: 'app-tourist-list',
  templateUrl: '../tourist-list.component.html',
  styleUrls: ['./tourist-list.component.css']
})
export class TouristListComponent implements OnInit {
  @Input() mode = 'plain';
  Tourists: any = [];
  constructor(private touristService: TouristService) { }

  ngOnInit() {
    this.loadTourists()
  }

  loadTourists() {
    return this.touristService.getAll()
      .subscribe((data: {}) => {
        this.Tourists = data;
      })
  }

  deleteTourist(id) {
    if (window.confirm("Are you sure you want to delete the tourist with id " + id)) {
      this.touristService.delete(id).subscribe((data: {}) => {
        this.loadTourists()
      })
    }
  }

}

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tourist-list',
  templateUrl: './tourist-list.component.html',
  styleUrls: ['./tourist-list.component.css']
})
export class TouristListComponent implements OnInit {
  Tourists: any = [];
  constructor() { }

  ngOnInit() {
  }

}

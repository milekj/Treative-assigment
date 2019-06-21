import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {FlightResponse} from "../model/flight-response";
import {TouristResponse} from "../model/tourist-response";

@Injectable({
  providedIn: 'root'
})
export class TouristService {
  apiURL = 'http://localhost:8080/api';

  constructor(public httpClient:  HttpClient) { }

  getAll(): Observable<TouristResponse> {
    return this.httpClient.get<TouristResponse>(`${this.apiURL}/tourists`)
      .pipe()
  }

  getById(id: number): Observable<TouristResponse> {
    return this.httpClient.get<TouristResponse>(`${this.apiURL}/tourists/${id}`)
      .pipe()
  }

  create(touristRequest): Observable<TouristResponse> {
    return this.httpClient.post<TouristResponse>(`${this.apiURL}/tourists`, touristRequest)
      .pipe()
  }

  update(id, touristRequest): Observable<{}> {
    return this.httpClient.put(`${this.apiURL}/tourists/${id}`, touristRequest)
      .pipe()
  }

  delete(id): Observable<{}> {
    return this.httpClient.delete(`${this.apiURL}/flights/${id}`)
      .pipe()
  }
}

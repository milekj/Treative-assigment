import { Injectable } from '@angular/core';
import { HttpClient } from  '@angular/common/http';
import {Observable} from "rxjs";
import {FlightResponse} from "../model/flight-response";
import {TouristResponse} from "../model/tourist-response";

@Injectable({
  providedIn: 'root'
})
export class FlightService {
  apiURL = 'http://localhost:8080/api/flights';

  constructor(public httpClient:  HttpClient) { }

  getAll(): Observable<FlightResponse> {
    return this.httpClient.get<FlightResponse>(`${this.apiURL}`)
      .pipe()
  }

  getById(id: number): Observable<FlightResponse> {
    return this.httpClient.get<FlightResponse>(`${this.apiURL}/${id}`)
      .pipe()
  }

  getTourists(id: number): Observable<TouristResponse> {
    return this.httpClient.get<TouristResponse>(`${this.apiURL}/${id}/tourists`)
      .pipe()
  }

  create(flight): Observable<FlightResponse> {
    return this.httpClient.post<FlightResponse>(`${this.apiURL}`, flight)
      .pipe()
  }

  update(id, flight): Observable<{}> {
    return this.httpClient.put(`${this.apiURL}/${id}`, flight)
      .pipe()
  }

  delete(id): Observable<{}> {
    return this.httpClient.delete(`${this.apiURL}/${id}`)
      .pipe()
  }

  addToTourist(flightId, touristId): Observable<{}> {
    return this.httpClient.post(`${this.apiURL}/${flightId}/tourists/${touristId}`, null)
      .pipe()
  }
}

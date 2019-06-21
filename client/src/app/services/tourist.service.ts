import { Injectable } from '@angular/core';
import { HttpClient } from  '@angular/common/http';
import {Observable} from "rxjs";
import {TouristResponse} from "../model/tourist-response";
import {FlightResponse} from "../model/flight-response";

@Injectable({
  providedIn: 'root'
})
export class TouristService {
  apiURL = 'http://localhost:8080/api/tourists';

  constructor(public httpClient:  HttpClient) { }

  getAll(): Observable<TouristResponse> {
    return this.httpClient.get<TouristResponse>(`${this.apiURL}`)
      .pipe()
  }

  getById(id: number): Observable<TouristResponse> {
    return this.httpClient.get<TouristResponse>(`${this.apiURL}/${id}`)
      .pipe()
  }

  getFlights(id: number): Observable<FlightResponse> {
    return this.httpClient.get<FlightResponse>(`${this.apiURL}/${id}/flights`)
      .pipe()
  }

  create(tourist): Observable<TouristResponse> {
    return this.httpClient.post<TouristResponse>(`${this.apiURL}`, tourist)
      .pipe()
  }

  update(id, tourist): Observable<{}> {
    return this.httpClient.put(`${this.apiURL}/${id}`, tourist)
      .pipe()
  }

  delete(id): Observable<{}> {
    return this.httpClient.delete(`${this.apiURL}/${id}`)
      .pipe()
  }

  deleteFlight(touristId, flightId): Observable<{}> {
    return this.httpClient.delete(`${this.apiURL}/${touristId}/flights/${flightId}`)
      .pipe()
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from  '@angular/common/http';
import {Observable} from "rxjs";
import {FlightResponse} from "../model/flight-response";

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

  create(flightRequest): Observable<FlightResponse> {
    return this.httpClient.post<FlightResponse>(`${this.apiURL}`, flightRequest)
      .pipe()
  }

  update(id, flightRequest): Observable<{}> {
    return this.httpClient.put(`${this.apiURL}/${id}`, flightRequest)
      .pipe()
  }

  delete(id): Observable<{}> {
    return this.httpClient.delete(`${this.apiURL}${id}`)
      .pipe()
  }
}

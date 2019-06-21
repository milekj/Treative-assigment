export class TouristResponse {
  id: number;
  firstName: string;
  lastName: string;
  gender: 'MALE' | 'FEMALE';
  country: string;
  notes: string;
  dateOfBirth: Date;
  flightsIds : number[];
}

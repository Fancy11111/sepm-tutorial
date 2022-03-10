import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Dog } from "../dto/dog";

const baseUri = environment.backendUrl + "/dogs";

@Injectable({
  providedIn: "root",
})
export class DogService {
  constructor(private http: HttpClient) {}

  /**
   * Get all dogs stored in the system
   *
   * @return observable list of found dogs.
   */
  getAll(): Observable<Dog[]> {
    return this.http.get<Dog[]>(baseUri);
  }

  create(dog: Dog): Observable<Dog> {
    return this.http.post<Dog>(baseUri, dog);
  }
}

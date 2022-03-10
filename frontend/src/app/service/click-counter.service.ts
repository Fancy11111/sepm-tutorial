import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root",
})
export class ClickCounterService {
  counter = 0;
  constructor() {}

  clicked() {
    this.counter++;
    console.log(this.counter);
  }
}

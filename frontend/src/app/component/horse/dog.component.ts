import { Component, OnInit } from "@angular/core";
import { Dog } from "../../dto/dog";
import { DogService } from "src/app/service/dog.service";

@Component({
  selector: "app-dog",
  templateUrl: "./dog.component.html",
  styleUrls: ["./dog.component.scss"],
})
export class DogComponent implements OnInit {
  search = false;
  dogs: Dog[];
  error: string = null;

  constructor(private service: DogService) {}

  ngOnInit(): void {
    this.reloadDogs();
  }

  reloadDogs() {
    this.service.getAll().subscribe({
      next: (data) => {
        console.log("received dogs", data);
        this.dogs = data;
      },
      error: (error) => {
        console.error("Error fetching dogs", error.message);
        this.showError("Could not fetch dogs: " + error.message);
      },
    });
  }

  public vanishError(): void {
    this.error = null;
  }

  private showError(msg: string) {
    this.error = msg;
  }
}

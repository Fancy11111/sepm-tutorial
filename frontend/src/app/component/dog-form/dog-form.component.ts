import { Component, OnInit } from "@angular/core";
import { FormBuilder, Validators } from "@angular/forms";
import { ActivatedRoute } from "@angular/router";
import { ClickCounterService } from "src/app/service/click-counter.service";
import { DogService } from "src/app/service/dog.service";

@Component({
  selector: "app-dog-form",
  templateUrl: "./dog-form.component.html",
  styleUrls: ["./dog-form.component.scss"],
})
export class DogFormComponent implements OnInit {
  dogForm = this.fb.group({
    name: ["", Validators.required],
    description: [""],
    gender: ["FEMALE"],
    birthdate: [{ year: 2022, month: 3, day: 10 }],
  });

  constructor(private fb: FormBuilder, private service: DogService) {}

  ngOnInit(): void {}

  submit() {
    this.service
      .create({
        ...this.dogForm.value,
        birthdate: new Date(
          this.dogForm.value.birthdate.year,
          this.dogForm.value.birthdate.month - 1,
          this.dogForm.value.birthdate.day
        ),
      })
      .subscribe({
        next: (dog) => {
          console.log(dog);
        },
      });
  }

  get name() {
    return this.dogForm.get("name");
  }
}

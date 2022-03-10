import { Component, Input, OnInit } from "@angular/core";

@Component({
  selector: "app-child-component",
  templateUrl: "./child-component.component.html",
  styleUrls: ["./child-component.component.scss"],
})
export class ChildComponentComponent implements OnInit {
  @Input() name: string;

  constructor() {}

  ngOnInit(): void {}
}

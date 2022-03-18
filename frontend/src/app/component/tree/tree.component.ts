import { Component, OnInit } from "@angular/core";
import { DogNode } from "src/app/dto/node";

@Component({
  selector: "app-tree",
  templateUrl: "./tree.component.html",
  styleUrls: ["./tree.component.scss"],
})
export class TreeComponent implements OnInit {
  tree: DogNode = {
    value: {
      name: "Root",
    },
    mother: {
      value: {
        name: "Mother",
      },
      mother: {
        value: { name: "Grandmother Mother" },
      },
      father: {
        value: {
          name: "Grandfather Mother",
        },
      },
    },
    father: {
      value: {
        name: "Father",
      },
      mother: {
        value: {
          name: "Grandmother Father",
        },
      },
      father: {
        value: {
          name: "Grandfather Father",
        },
      },
    },
  };

  constructor() {}

  ngOnInit(): void {}
}

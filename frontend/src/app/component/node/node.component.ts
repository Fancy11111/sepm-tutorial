import { Component, Input, OnInit } from "@angular/core";
import { DogNode } from "src/app/dto/node";

@Component({
  selector: "app-node",
  templateUrl: "./node.component.html",
  styleUrls: ["./node.component.scss"],
})
export class NodeComponent implements OnInit {
  @Input() node: DogNode;

  displayChildren: boolean = false;

  constructor() {}

  ngOnInit(): void {}
}

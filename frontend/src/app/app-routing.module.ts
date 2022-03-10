import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { DogFormComponent } from "./component/dog-form/dog-form.component";
import { DogComponent } from "./component/horse/dog.component";

const routes: Routes = [
  { path: "", redirectTo: "dog", pathMatch: "full" },
  { path: "dog", component: DogComponent },
  { path: "dog-form", component: DogFormComponent },
  { path: "**", redirectTo: "dog" },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { HeaderComponent } from "./component/header/header.component";
import { HttpClientModule } from "@angular/common/http";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { DogComponent } from "./component/horse/dog.component";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { DogFormComponent } from "./component/dog-form/dog-form.component";
import { ChildComponentComponent } from "./component/child-component/child-component.component";
import { TreeComponent } from './component/tree/tree.component';
import { NodeComponent } from './component/node/node.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    DogComponent,
    DogFormComponent,
    ChildComponentComponent,
    TreeComponent,
    NodeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}

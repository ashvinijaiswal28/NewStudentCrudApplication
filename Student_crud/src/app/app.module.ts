import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PostStudentComponent } from './components/post-student/post-student.component';
import { GetAllStudentsComponent } from './components/get-all-students/get-all-students.component';
import { UpdateStudentsComponent } from './components/update-students/update-students.component';
import { HttpClientModule } from "@angular/common/http";
import { ReactiveFormsModule, FormsModule } from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    PostStudentComponent,
    GetAllStudentsComponent,
    UpdateStudentsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
console.log("Äshvini");
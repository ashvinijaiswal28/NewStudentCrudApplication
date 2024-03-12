import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PostStudentComponent } from './components/post-student/post-student.component';
import { GetAllStudentsComponent } from './components/get-all-students/get-all-students.component';
import { UpdateStudentsComponent } from './components/update-students/update-students.component';

const routes: Routes = [
  { path: "students", component: PostStudentComponent },
  { path: "", component: GetAllStudentsComponent },
  { path: "students/:id", component: UpdateStudentsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

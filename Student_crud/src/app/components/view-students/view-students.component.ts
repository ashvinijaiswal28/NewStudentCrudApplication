import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from 'src/app/Service/student.service';

@Component({
  selector: 'app-view-students',
  templateUrl: './view-students.component.html',
  styleUrls: ['./view-students.component.scss']
})
export class ViewStudentsComponent implements OnInit {
  viewStudentForm!:FormGroup;
  id:Number=this.activatedRoutes.snapshot.params['id']
  students: any[] = [];

  constructor(private activatedRoutes:ActivatedRoute,private Service:StudentService,private fb:FormBuilder,private router:Router) { }

  ngOnInit(): void {
    this.initializeForm();
      this.getAllStudentInformation();
  }

  initializeForm(): void {
    this.viewStudentForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      age: ['', Validators.required],
      contact: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      department: this.fb.group({
        departmentName: [{ value: '', disabled: false }] 
      }),
      course: this.fb.group({
        courseName: [{ value: '', disabled: true }] 
      })
    });
  }

  getAllStudentInformation() {
      this.Service.getStudentById(this.id).subscribe((data: any) => {
          // this.students = data;
          this.viewStudentForm.patchValue(data);
      });

}
}

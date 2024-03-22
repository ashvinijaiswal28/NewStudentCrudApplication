import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { StudentService } from 'src/app/Service/student.service';

@Component({
  selector: 'app-post-student',
  templateUrl: './post-student.component.html',
  styleUrls: ['./post-student.component.scss']
})
export class PostStudentComponent {
postStudentForm!:FormGroup ;
  constructor(private studentService: StudentService,private fb:FormBuilder,private router:Router) { }

  ngOnInit(): void {
    this.postStudentForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      age: ['', Validators.required],
      contact: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      department: ['', Validators.required],
      course: ['', Validators.required]
    });
  }

  get firstName() {
    return this.postStudentForm.get('firstName');
  }

  get lastName() {
    return this.postStudentForm.get('lastName');
  }

  get email() {
    return this.postStudentForm.get('email');
  }

  get department() {
    return this.postStudentForm.get('department');
  }

  get course() {
    return this.postStudentForm.get('course');
  }
  get age() {
    return this.postStudentForm.get('age');
  }
  get contact() {
  
    return this.postStudentForm.get('contact')


  }



   postStudent(){
    let json = {
      
      student : {
        firstName: this.firstName?.value,
        lastName:this.lastName?.value,
        email:this.email?.value,
        age:this.age?.value,
        contact:this.contact?.value,
        department : {
          departmentName : this.department?.value},
          course : { courseName : this.course?.value},
      },
    }
    
   
      this.studentService.postStudent(json).subscribe((res) => {
        console.log(res);
        this.router.navigateByUrl("");
      });
  }
}


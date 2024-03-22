import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from 'src/app/Service/student.service';

@Component({
  selector: 'app-update-students',
  templateUrl: './update-students.component.html',
  styleUrls: ['./update-students.component.scss']
})
export class UpdateStudentsComponent implements OnInit {
  updateStudentForm!: FormGroup;
  id: number = this.activatedRoutes.snapshot.params['id'];

  constructor(
    private activatedRoutes: ActivatedRoute,
    private service: StudentService,
    private fb: FormBuilder,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.initializeForm();
    this.getStudentById();
  }

  initializeForm(): void {
    this.updateStudentForm = this.fb.group({
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

  getStudentById(): void {
    this.service.getStudentById(this.id).subscribe((res: any) => {
      console.log(res);
      this.updateStudentForm.patchValue(res);
    });
  }

  get firstName() {
    return this.updateStudentForm.get('firstName');
  }

  get lastName() {
    return this.updateStudentForm.get('lastName');
  }

  get email() {
    return this.updateStudentForm.get('email');
  }

  get department() {
    return this.updateStudentForm.get('department');
  }

  get course() {
    return this.updateStudentForm.get('course');
  }

  get age() {
    return this.updateStudentForm.get('age');
  }

  get contact() {
    return this.updateStudentForm.get('contact');
  }

  
  updateStudent(): void {
    const formData = this.updateStudentForm.value;
    let json = {
      student: {
        firstName: this.firstName?.value,
        lastName: this.lastName?.value,
        email: this.email?.value,
        age: this.age?.value,
        contact: this.contact?.value,
        department: {
          departmentName: this.department?.value.departmentName
        },
        course: {
          courseName: this.course?.value.courseName
        }
      }
    };

    this.service.updateStudent(this.id, json).subscribe((res) => {
      console.log(res);
      this.router.navigateByUrl("");
    });
  }
}

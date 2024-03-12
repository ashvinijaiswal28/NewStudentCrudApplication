import { Component, OnInit } from '@angular/core';
import { Form, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from 'src/app/Service/student.service';

@Component({
  selector: 'app-update-students',
  templateUrl: './update-students.component.html',
  styleUrls: ['./update-students.component.css']
})
export class UpdateStudentsComponent implements OnInit {
  updateStudentForm!:FormGroup;
id:Number=this.activatedRoutes.snapshot.params['id']
  constructor(private activatedRoutes:ActivatedRoute,private Service:StudentService,private fb:FormBuilder,private router:Router) { }

  ngOnInit() {
    this.getStudentById();
    this.updateStudentForm=this.fb.group({
      firstName:[null,Validators.required],
      lastName:[null,Validators.required],
      email:[null,[Validators.required,Validators.email]]
    })
  }
  getStudentById(){
    this.Service.getStudentById(this.id).subscribe((res)=>{
      console.log(res);
      this.updateStudentForm.patchValue(res);
      
    });

  }
  updateStudent(){
    this.Service.updateStudent(this.id,this.updateStudentForm.value).subscribe((res)=>{
      console.log(res);
      this.router.navigateByUrl("");
    })
  }

}

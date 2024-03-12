import { Component, OnInit } from '@angular/core';
import { StudentService } from 'src/app/Service/student.service';

@Component({
  selector: 'app-get-all-students',
  templateUrl: './get-all-students.component.html',
  styleUrls: ['./get-all-students.component.css']
})
export class GetAllStudentsComponent  {
students:any=[];
  constructor(private Service:StudentService) { }

  ngOnInit(){
    this.getAllStudents();
  }
  getAllStudents(){
    this.Service.getAllStudents().subscribe((res)=>{
      console.log(res);
      this.students=res;
    })
   

    
  }
  deleteStudent(id:Number){
 console.log(id);
 this.Service.deleteStudent(id).subscribe((res)=>{
  console.log(res);
  this.getAllStudents();
 });
  

}
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudentService } from 'src/app/Service/student.service';

@Component({
  selector: 'app-get-all-students',
  templateUrl: './get-all-students.component.html',
  styleUrls: ['./get-all-students.component.scss']
})
export class GetAllStudentsComponent {
  studentsWrapper: any = [];
  
  constructor(private Service: StudentService,private router: Router) { }

  ngOnInit() {
    this.getAllStudents();  
  }
  
  
  getAllStudents() {
    this.Service.getAllStudents().subscribe((res) => {
      console.log(res);
      this.studentsWrapper = res;
    });
  }
  deleteStudent(id: Number) {
    console.log(id);
    this.Service.deleteStudent(id).subscribe((res) => {
      console.log(res);
      this.getAllStudents();
    });
  }
  goToSearchPage() {
    this.router.navigate(['/search']);
  }


}


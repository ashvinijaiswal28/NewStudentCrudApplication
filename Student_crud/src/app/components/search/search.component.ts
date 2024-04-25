import { Component, OnInit } from '@angular/core';
import { StudentService } from 'src/app/Service/student.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {
  selectedFirstName!: string;
  selectedDepartment!: string;
  firstName: string | undefined;
  firstNames: string[] = [];
  students: any[] = [];
  Service: any;
  departments: string[] = [];

  constructor(private studentService: StudentService) { }

  ngOnInit(): void {
    this.getDepartmentData(); 
  }

  getDepartmentData(){
    const fiql = "type=department";
    this.studentService.getDepartmentMasterData(fiql).subscribe((data: any[]) => {
      this.departments = data.map(item => item.name);
    });
  }

  // searchStudents(): void {
  //   const fiql = `firstName=${this.selectedFirstName}`;
  //   this.studentService.getStudentsByFirstName(fiql)
  //     .subscribe((students: any[]) => {
  //       this.students = students;
  //     });
  // }

  searchStudents(): void {
    let firstNameParam = this.selectedFirstName ? this.selectedFirstName : null;
    let departmentParam = this.selectedDepartment ? this.selectedDepartment : null;
    const fiql = `firstName=${firstNameParam}&department=${departmentParam}`;
    this.studentService.getStudentsByDepartmentAndFirstName(fiql)
      .subscribe((students: any[]) => {
        this.students = students;
      });
  }

  getDepartments(): void {
    this.studentService.getAllDepartments()
      .subscribe(departments => this.departments = departments);
  }
}
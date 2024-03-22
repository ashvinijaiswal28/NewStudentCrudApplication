import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class StudentService {
  public BASIC_URL = ["http://localhost:8080/"];


  constructor(private http: HttpClient) { }

  postStudent(json: any): Observable<any> {
    return this.http.post(this.BASIC_URL + "api/create", json);
  }

  getAllStudents(): Observable<any> {
    return this.http.get(this.BASIC_URL + "api/getStudentList");
  }
  deleteStudent(id: Number): Observable<any> {
    return this.http.delete(this.BASIC_URL + "api/deleteStudent/" + id);
  }

  getStudentById(id: Number): Observable<any> {
    return this.http.get(this.BASIC_URL + "api/getStudentByID/" + id);
  }

  updateStudent(id: Number, student: any): Observable<any> {
    return this.http.put(this.BASIC_URL + "api/updateStudentByID/" + id, student);
  }
  
  getAllStudentInformation(id: Number): Observable<any> {
    return this.http.get(this.BASIC_URL + "api/getStudentInfo/" + id);
  }
}

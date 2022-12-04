import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import {
  HttpClient,
  HttpHeaders,
  HttpParams,
  HttpRequest,
} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) {}
  
  public loginUser(lgUser: any): Observable<any> {
    return this.http.post<any>(`${this.apiServerUrl}/user/login`, lgUser);
  }
  
  public createSchedule(schedule: any): Observable<any> {
    return this.http.post<any>(`${this.apiServerUrl}/schedule/create`, schedule);
  }
  public getScheduleByDepId(id: any): Observable<any> {
    return this.http.get<any>(
      `${this.apiServerUrl}/schedule/get-by-depId/` + id
    );
  }
  public createNotify(notify: any): Observable<any> {
    return this.http.post<any>(`${this.apiServerUrl}/notify/create`, notify);
  }
  public getNotifyById(id: any): Observable<any> {
    return this.http.get<any>(
      `${this.apiServerUrl}/notify/get-by-nameId/` + id
    );
  }
  public createDepartment(notify: any): Observable<any> {
    return this.http.post<any>(`${this.apiServerUrl}/department/create`, notify);
  }

  public getDepartmentById(id: any): Observable<any> {
    return this.http.get<any>(
      `${this.apiServerUrl}/department/get-by-nameId/` + id
    );
  }

  public disableSchedule(id: any): Observable<any> {
    return this.http.get<any>(
      `${this.apiServerUrl}/schedule/disable/` + id
    );
  }

  public disableNotify(id: any): Observable<any> {
    return this.http.get<any>(
      `${this.apiServerUrl}/notify/disable/` + id
    );
  }
}

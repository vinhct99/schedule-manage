import { UserService } from './../../service/userService/user.service';
import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-schedule-manager-user',
  templateUrl: './schedule-manager-user.component.html',
  styleUrls: ['./schedule-manager-user.component.css']
})
export class ScheduleManagerUserComponent implements OnInit{
  
  constructor(private uerServie: UserService) { }
  
  ngOnInit(): void {
    this.getAll();
  }
  
  lstSchedule: any;

  schedule = {
    id:localStorage.getItem('id'),
    createdBy: localStorage.getItem('userName'),
    scheduleDesc: '',
    userId:localStorage.getItem('userId'),
    deptId:localStorage.getItem('deptId'),

  };

  onSubmit() {
      this.uerServie.createSchedule(this.schedule).subscribe(
        (response: any) => {
          console.log(response)
          this.getAll();
        },
      );
  }


  public getAll() {
    let res = this.uerServie.getScheduleByDepId(localStorage.getItem('deptId'));
    res.subscribe((total) => {
      this.lstSchedule = total['data']
    });
  }

  public disable(id: any) {
    let res = this.uerServie.disableSchedule(id).subscribe(
      (response: any) => {
        console.log(response)
        this.getAll();
      },
    );
}


}

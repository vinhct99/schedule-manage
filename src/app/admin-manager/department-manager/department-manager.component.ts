import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ConfirmationService, MessageService, PrimeNGConfig } from 'primeng/api';
import { UserService } from 'src/app/service/userService/user.service';

@Component({
  selector: 'app-department-manager',
  templateUrl: './department-manager.component.html',
  styleUrls: ['./department-manager.component.css']
})
export class DepartmentManagerComponent implements OnInit{
  ngOnInit(): void {
    this.getAll();
  }
  lstDepartment: any;
 
  constructor(private uerServie: UserService,  private router: Router,private confirmationService: ConfirmationService,
    private messageService: MessageService,
    private primengConfig: PrimeNGConfig) { }
    department = {
      id:localStorage.getItem('id'),
      createdBy: localStorage.getItem('userName'),
      departmentName: '',
      userId:localStorage.getItem('userId'),
    
    };
   
    onSubmit() {
      this.uerServie.createDepartment(this.department).subscribe(
        (response: any) => {
          console.log(response)
        },
      );

  }
  public getAll() {
    let res = this.uerServie.getDepartmentById(localStorage.getItem('userId'));
    res.subscribe((total) => {
      this.lstDepartment = total['data']
    });
  }
}

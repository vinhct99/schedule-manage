import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ConfirmationService, MessageService, PrimeNGConfig } from 'primeng/api';
import { UserService } from 'src/app/service/userService/user.service';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit{
  ngOnInit(): void {

  }
  fullName:any
  userName:any
  passWord:any
  email:any
  phoneNumber:any
  isValidFormSubmitted = false;
  constructor(private uerServie: UserService,  private router: Router,private confirmationService: ConfirmationService,
    private messageService: MessageService,
    private primengConfig: PrimeNGConfig) { }
    
    back_userManage() {
      this.router.navigate(['/user-manager-admin']);
    }
    public onFormSubmit(createUserForm: NgForm): void {
      this.isValidFormSubmitted = false;
      if (createUserForm.valid) {
        document.getElementById('sign-up')?.click();
        this.uerServie.loginUser(createUserForm.value).subscribe(
          (response: any) => {
            console.log(response['data']['userName']);
            localStorage.clear();
            localStorage.setItem('userName', response['data']['userName'])
            localStorage.setItem('fullName', response['data']['fullName']);
            localStorage.setItem('deptId', response['data']['deptId']);
            localStorage.setItem('role', response['data']['role']);
            console.log(localStorage.getItem('userName'));
            this.router.navigate(['/home']);
            this.messageService.add({
              severity: 'info',
              summary: 'Thành công',
              detail: 'thành công',
            });
  
          },
          (error: HttpErrorResponse) => {
            this.messageService.add({
              severity: 'error',
              summary: 'Thất bại',
              detail: 'Thất bại',
            });
            createUserForm.resetForm();
          }
        );
      }
    }
}

import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../service/userService/user.service';
import {
  ConfirmationService,
  MessageService,
  PrimeNGConfig,
} from 'primeng/api';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit  {
  userName: any;
  passWord: any;
  PassWordPattern = "^(?=.*?[a-z])(?=.*?[0-9]).{6,}$";
  // NamePattern = "^(?=.*?[a-z])(?=.*?[0-9]).{6,}$";
  isValidFormSubmitted = false;
  ngOnInit(): void {

  }
  
  constructor(private uerServie: UserService,  private router: Router,private confirmationService: ConfirmationService,
    private messageService: MessageService,) { }
    confirm(event: Event) {
      this.confirmationService.confirm({
        target: event.target as EventTarget,
  
        accept: () => {
          this.messageService.add({
            severity: 'info',
            summary: 'Confirmed',
            detail: 'You have accepted',
          });
        },
        reject: () => {
  
        },
      });
    }
  login = true;

  
  public onFormSubmit(loginForm: NgForm): void {
    this.isValidFormSubmitted = false;
    if (loginForm.valid) {
      document.getElementById('sign-up')?.click();
      this.uerServie.loginUser(loginForm.value).subscribe(
        (response: any) => {
          console.log(response['data']['userName']);
          localStorage.clear();
          localStorage.setItem('userName', response['data']['userName'])
          localStorage.setItem('fullName', response['data']['fullName']);
          localStorage.setItem('deptId', response['data']['deptId']);
          localStorage.setItem('role', response['data']['role']);
          localStorage.setItem('userId', response['data']['id']);
          console.log(localStorage.getItem('userName'));
          this.router.navigate(['/schedule-manager-user']);
          this.messageService.add({
            severity: 'info',
            summary: 'Thành công',
            detail: 'Đăng nhập thành công',
          });

        },
        (error: HttpErrorResponse) => {
          this.messageService.add({
            severity: 'error',
            summary: 'Đăng nhập thất bại',
            detail: 'Bạn sai tện hoặc mật khẩu',
          });
          loginForm.resetForm();
        }
      );
    }
    else{}
  }


}

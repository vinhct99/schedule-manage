
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../service/userService/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent  implements OnInit{
  
  
  userLogin ={
    userName: localStorage.getItem('userName'),
  }
  
  ngOnInit(): void {

  }
  constructor(private router:Router, private userServie: UserService,){
    this.checkLogin();
    if(localStorage.getItem('userName') != null){
      this.userLogin.userName = localStorage.getItem('userName');

    }
   
  }
  user_login() {
    this.router.navigate(['/login']);
  }
  view_cq(){
    this.router.navigate(['/schedule-manager-admin']);
  }
  view_pb(){
    this.router.navigate(['/schedule-manager-user']);
  }
  view_notify(){
    this.router.navigate(['/notify-manager']);
  }
  login = true;
  logout = false;
  user_logout() {
    this.login = true;
    this.logout = false;
    localStorage.clear();
    this.router.navigate(['']);

  }

  checkLogin() {
    if (localStorage.getItem('userName') != null){
      this.login = false;
      this.logout = true;
    } else {
      this.login = true;
      this.logout = false;
    }
  }
 
  routerAdmin(){
    this.router.navigate(['admin/manage']);
  }
  test_manage() {
    this.router.navigate(['/manage']);
 
  }

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/userService/user.service';

@Component({
  selector: 'app-user-manager-admin',
  templateUrl: './user-manager-admin.component.html',
  styleUrls: ['./user-manager-admin.component.css']
})
export class UserManagerAdminComponent implements OnInit{
  ngOnInit(): void {

  }
  constructor(private router:Router, private userServie: UserService,){
    
  }
  create_user() {
    this.router.navigate(['/create-user']);
  }
}

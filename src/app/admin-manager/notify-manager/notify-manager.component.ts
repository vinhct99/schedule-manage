import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/userService/user.service';

@Component({
  selector: 'app-notify-manager',
  templateUrl: './notify-manager.component.html',
  styleUrls: ['./notify-manager.component.css']
})
export class NotifyManagerComponent  implements OnInit{

  constructor(private router:Router,private uerServie: UserService) { }
  
  ngOnInit(): void {
    this.getAll();
  }
  lstNotify: any;
  view_notify(){
    this.router.navigate(['/notify-manager']);
  }
  notify = {
    id:localStorage.getItem('id'),
    createdBy: localStorage.getItem('userName'),
    notifyContent: '',
    userId:localStorage.getItem('userId'),
  
  };

  onSubmit() {
    this.uerServie.createNotify(this.notify).subscribe(
      (response: any) => {
        console.log(response)
        this.getAll();
      },
    );
}

public getAll() {
  let res = this.uerServie.getNotifyById(localStorage.getItem('userId'));
  res.subscribe((total) => {
    this.lstNotify = total['data']
  });
}

public disable(id: any) {
  let res = this.uerServie.disableNotify(id).subscribe(
    (response: any) => {
      console.log(response)
      this.getAll();
    },
  );
}

}

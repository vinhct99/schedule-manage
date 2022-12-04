import { NotifyManagerComponent } from './admin-manager/notify-manager/notify-manager.component';
import { FeComponent } from './fe/fe.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { InfoAdminComponent } from './admin-manager/info-admin/info-admin.component';
import { InfoUserComponent } from './user-manager/info-user/info-user.component';
import { ScheduleManagerAdminComponent } from './admin-manager/schedule-manager-admin/schedule-manager-admin.component';
import { UserManagerAdminComponent } from './admin-manager/user-manager-admin/user-manager-admin.component';
import { CreateUserComponent } from './admin-manager/create-user/create-user.component';
import { DepartmentManagerComponent } from './admin-manager/department-manager/department-manager.component';
import { ScheduleDepartmentManagerComponent } from './admin-manager/schedule-department-manager/schedule-department-manager.component';
import { ScheduleManagerUserComponent } from './user-manager/schedule-manager-user/schedule-manager-user.component';



const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {
    path: 'home',
    component: FeComponent,
    children: [{ path: '', component: HomeComponent }],
  },
  


  { path: 'login', component: LoginComponent},
  {path:'info-admin', component: InfoAdminComponent},
  {path:'info-user', component: InfoUserComponent},
  {path:'user-manager-admin', component: UserManagerAdminComponent},
  {path:'schedule-manager-admin',component:ScheduleManagerAdminComponent},
  { path: 'create-user', component: CreateUserComponent},
  {path:'department-manager',component:DepartmentManagerComponent},
  {path:'notify-manager',component:NotifyManagerComponent},
  {path:'schedule-department',component:ScheduleDepartmentManagerComponent},
  {path:'schedule-manager-user',component:ScheduleManagerUserComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes, { onSameUrlNavigation: 'reload' })],
  exports: [RouterModule]
})

export class AppRoutingModule { }

export const routingComponent = [
  LoginComponent,
  HomeComponent  
];

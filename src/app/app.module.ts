import { NotifyManagerComponent } from './admin-manager/notify-manager/notify-manager.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule,ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ConfirmationService, MessageService } from "primeng/api";
import { ConfirmPopupModule } from "primeng/confirmpopup";
import { AppRoutingModule, routingComponent } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { FeComponent } from './fe/fe.component';
import {HomeComponent} from './home/home.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {MessagesModule} from 'primeng/messages';
import { InfoAdminComponent } from './admin-manager/info-admin/info-admin.component';
import { DepartmentManagerComponent } from './admin-manager/department-manager/department-manager.component';
import { InfoUserComponent } from './user-manager/info-user/info-user.component';
import { ScheduleManagerUserComponent } from './user-manager/schedule-manager-user/schedule-manager-user.component';
import { UserManagerAdminComponent } from './admin-manager/user-manager-admin/user-manager-admin.component';
import { CreateUserComponent } from './admin-manager/create-user/create-user.component';
import {ToastModule} from 'primeng/toast';
import { ScheduleManagerAdminComponent } from './admin-manager/schedule-manager-admin/schedule-manager-admin.component';
import { ScheduleDepartmentManagerComponent } from './admin-manager/schedule-department-manager/schedule-department-manager.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    FeComponent,
    HomeComponent,
    routingComponent,
    InfoAdminComponent,
    InfoUserComponent,
    DepartmentManagerComponent,
    ScheduleManagerUserComponent,
    UserManagerAdminComponent,
    CreateUserComponent,
    NotifyManagerComponent,
    ScheduleManagerAdminComponent,
    ScheduleDepartmentManagerComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule,
    ConfirmPopupModule,
    MessagesModule,
    ToastModule,
  ],
  providers: [ConfirmationService, MessageService],
  bootstrap: [AppComponent]
})
export class AppModule { }

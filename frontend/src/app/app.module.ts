import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { Appinterceptor } from './app.interceptor';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { RegisterComponent } from './register/register.component';
import { CoreModule } from './core/core.module';
import { NavigationComponent } from './core/navigation/navigation.component';
import { FormsModule } from '@angular/forms';
import { SaloonprocComponent } from './saloonproc/saloonproc.component';
import { StuffComponent } from './stuff/stuff.component';
import { SaloonprocgroupComponent } from './saloonprocgroup/saloonprocgroup.component';
import { PaymentsComponent } from './payments/payments.component';
import { ReservationsComponent } from './reservations/reservations.component';
import { ProfileComponent } from './profile/profile.component';
import { PromoComponent } from './promo/promo.component';
import { ContactComponent } from './contact/contact.component';
import { GalleryComponent } from './gallery/gallery.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    NotfoundComponent,
    RegisterComponent,
    SaloonprocComponent,
    StuffComponent,
    SaloonprocgroupComponent,
    PaymentsComponent,
    ReservationsComponent,
    ProfileComponent,
    PromoComponent,
    ContactComponent,
    GalleryComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AppRoutingModule,
    CoreModule,
    FormsModule
  ],
  providers: [{
    provide : HTTP_INTERCEPTORS,
    useClass:Appinterceptor,
    multi:true
  }
 ],
  bootstrap: [AppComponent, NavigationComponent]
})
export class AppModule { }

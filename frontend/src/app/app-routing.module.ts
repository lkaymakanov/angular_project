import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { NotfoundComponent } from './notfound/notfound.component'
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuard } from './auth.guard';
import { StuffComponent } from './stuff/stuff.component';
import { SaloonprocComponent } from './saloonproc/saloonproc.component';
import { ReservationsComponent } from './reservations/reservations.component';
import { PaymentsComponent } from './payments/payments.component';
import { ProfileComponent } from './profile/profile.component';
import { PromoComponent } from './promo/promo.component';
import { ContactComponent } from './contact/contact.component';


const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo :'home',
    //component: HomeComponent
  },
  {
    path: 'home',
    //pathMatch: '',
    component: HomeComponent
  },
  {
    path: 'login',
    component: LoginComponent,
   /* canActivate: [AuthGuard],
    data: {
      isLogged: false
    }*/
  },
  {
    path: 'register',
    component: RegisterComponent,
    /*canActivate: [AuthGuard],
    data: {
      isLogged: false
    }*/
  },

  {
    path: 'stuff',
    component: StuffComponent
  },

  //saloon procdures component
  {
    path: 'saloon',
    component : SaloonprocComponent
  },

  {
    path: 'promotions',
    component : PromoComponent
  },
  {
    path: 'contact',
    component : ContactComponent
  },

  {
    path : 'user',
    canActivate: [AuthGuard],
    children:[
      {
         path:'reservations', 
         component:ReservationsComponent,
         canActivate: [AuthGuard]
      },
      {
        path:'payments',
        component: PaymentsComponent,
        canActivate: [AuthGuard]
      },
      {
        path:'profile',
        component : ProfileComponent,
        canActivate: [AuthGuard]

      }
    ]
  },

  {
    path: '**',
    component: NotfoundComponent
  }
];

export const AppRoutingModule = RouterModule.forRoot(routes);

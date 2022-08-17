import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { RouterModule } from '@angular/router';
import { Navbar2Component } from './navbar2/navbar2.component';

@NgModule({
    declarations: [
      NavbarComponent,
      FooterComponent,
      Navbar2Component
    ],
    imports: [
      CommonModule,
      RouterModule
    ],
    exports:[
      NavbarComponent,
      FooterComponent,
      Navbar2Component
    ]
  })
  export class TemplateModule { }
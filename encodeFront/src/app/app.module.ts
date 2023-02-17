import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import {RouterOutlet} from "@angular/router";
import { SubscriberComponent } from './components/subscriber/subscriber.component';
import {HttpClientModule} from "@angular/common/http";
import {ReactiveFormsModule} from "@angular/forms";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    SubscriberComponent
  ],
  imports: [
    BrowserModule,
    RouterOutlet,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

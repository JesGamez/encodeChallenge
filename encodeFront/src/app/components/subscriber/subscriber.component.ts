import {Component, OnInit} from '@angular/core';
import {SubscriberModel} from "../../model/subscriber-model";
import {SubscriberService} from "../../service/subscriber.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-subscriber',
  templateUrl: './subscriber.component.html',
  styleUrls: ['./subscriber.component.sass']
})
export class SubscriberComponent implements OnInit{

  listSubscribers: SubscriberModel [] = [];
  formSubscriber: FormGroup = new FormGroup({});
  isUpdate: boolean = false;
  submitted = false;

  constructor(private subscriberService: SubscriberService) { }

  ngOnInit(): void {
    this.list();
    this.formSubscriber = new FormGroup({
      telefono: new FormControl(''),
      direccion: new FormControl(''),
      numeroDocumento: new FormControl(''),
      email: new FormControl(''),
      nombreUsuario: new FormControl(''),
      idSuscriptor: new FormControl(''),
      nombre: new FormControl('',Validators.required),
      apellido: new FormControl(''),
      tipoDocumento: new FormControl(''),
      password: new FormControl('')
    });
  }

  get f(){return this.formSubscriber.controls;}

  onSubmit(){
    this.submitted = true;
    if (this.formSubscriber.invalid){
      return;
    }
  }

  list(){
    this.subscriberService.getSubscribers().subscribe(resp => {
      if (resp){
        this.listSubscribers = resp;
      }
    });
  }

  save(){
    this.subscriberService.saveSubscriber(this.formSubscriber.value).subscribe(resp =>{
      if(resp){
        this.list();
        this.formSubscriber.reset();
      }
    });
  }

  update(){
    this.subscriberService.updateSubscriber(this.formSubscriber.value).subscribe(resp =>{
      if(resp){
        this.list();
        this.formSubscriber.reset();
      }
    });
  }

  delete(id: any){
    this.subscriberService.deleteSubscriber(id).subscribe(resp =>{
      if(resp){
        this.list();
      }
    });
  }

  newSubscriber(){
    this.isUpdate = false;
    this.formSubscriber.reset();
  }

  selectItem(item: any){
    this.isUpdate = true;
    this.formSubscriber.controls['idSuscriptor'].setValue(item.idSuscriptor);
    this.formSubscriber.controls['nombre'].setValue(item.nombre);
    this.formSubscriber.controls['apellido'].setValue(item.apellido);
    this.formSubscriber.controls['nombreUsuario'].setValue(item.nombreUsuario);
    this.formSubscriber.controls['password'].setValue(item.password);
    this.formSubscriber.controls['telefono'].setValue(item.telefono);
    this.formSubscriber.controls['direccion'].setValue(item.direccion);
    this.formSubscriber.controls['numeroDocumento'].setValue(item.numeroDocumento);
    this.formSubscriber.controls['email'].setValue(item.email);
    this.formSubscriber.controls['tipoDocumento'].setValue(item.tipoDocumento);

  }


}

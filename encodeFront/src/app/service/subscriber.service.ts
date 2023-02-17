import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable, Subscriber} from "rxjs";
import {SubscriberModel} from "../model/subscriber-model";

@Injectable({
  providedIn: 'root'
})
export class SubscriberService {

  constructor(private httpClient: HttpClient) {

  }

  getSubscribers(): Observable<SubscriberModel[]>{
    return this.httpClient.get<SubscriberModel[]>('http://localhost:9000/api/subscriber' + '/list').pipe(map(res => res));
  }

  saveSubscriber(request: any): Observable<any>{
    return this.httpClient.post<any>('http://localhost:9000/api/subscriber' + '/save', request).pipe(map(res => res));
  }

  updateSubscriber(request: any): Observable<any>{
    return this.httpClient.post<any>('http://localhost:9000/api/subscriber' + '/update', request).pipe(map(res => res));
  }

  deleteSubscriber(id: number): Observable<any>{
    return this.httpClient.get<any>('http://localhost:9000/api/subscriber' + '/delete/' + id).pipe(map(res => res));
  }


}

import { Injectable } from '@angular/core';
import {Observable} from "rxjs/internal/Observable";
import {catchError, tap} from "rxjs/operators";
import {Hero} from "./hero";

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  messages: string[] = [];

  constructor() { }

  add(message:string) {
    this.messages.push(message);
  }

  clear() {
    this.messages = [];
  }
}

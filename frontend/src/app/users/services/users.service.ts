import { Injectable } from '@angular/core';
import { User } from '../model/user';
import { HttpClient } from '@angular/common/http'
import { delay, first, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private readonly PATH = '/api/users/'

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<User[]>(this.PATH)
    .pipe(
      first(),
      delay(2000),
      tap(users => console.log(users))
      ); 
  }
}

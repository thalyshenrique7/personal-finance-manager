import { Component, OnInit } from '@angular/core';

import { User } from '../model/user';
import { UsersService } from '../services/users.service';
import { Observable, catchError, of } from 'rxjs';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})

export class UsersComponent implements OnInit {

  users$: Observable<User[]>;
  displayedColumns = ['firstName', 'lastName', 'age', 'cpf', 'wallet'];

  constructor(private usersService: UsersService){

    this.users$ = this.usersService.list()
      .pipe(
        catchError(error => {
          console.log(error);
          return of([])
        })
      );
  }

  ngOnInit(): void {
    
  }

}

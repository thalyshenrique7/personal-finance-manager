import { Component, OnInit } from '@angular/core';

import { User } from '../model/user';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: User[] = [];
  displayedColumns = ['name'];

  constructor(){

  }

  ngOnInit(): void {
    
  }

}

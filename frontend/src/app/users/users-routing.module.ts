import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [

  // Carregamento com Lazy Loading (Automaticamente o Angular carrega o 'users')

  { path: '', pathMatch: 'full', redirectTo: 'users' },
  { path: 'users', loadChildren: () => import('./users.module').then(m => m.UsersModule) }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsersRoutingModule { }

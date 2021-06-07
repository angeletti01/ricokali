import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent} from './component/home/home.component';
import { AddComponent} from './component/add/add.component';
import { ListComponent} from './component/list/list.component';

const routes: Routes = [
  {path:'', component : HomeComponent},
  {path:'add', component : AddComponent},
  {path:'list', component : ListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

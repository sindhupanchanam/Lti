import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddCustomerComponent } from './components/add-customer/add-customer.component';
import { CustomerDetailsComponent } from './components/customer-details/customer-details.component';
import { GetByIdComponent } from './components/get-by-id/get-by-id.component';
import { UpdateCustomerComponent } from './components/update-customer/update-customer.component';

const routes: Routes = [{ path: '', redirectTo: 'customer-producer', pathMatch: 'full' },
{ path: 'getCustomerDetails', component: CustomerDetailsComponent },
{ path: 'create', component: AddCustomerComponent },
{path: 'updateCustomer', component: UpdateCustomerComponent },
{path: 'findByid', component: GetByIdComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Product } from '../model/product';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  //variables for each endpoint in the backend controller
  private addProductUrl: string;
  private listProductUrl: string;

  //All of our endpoints listed in the InventoryController.java file within the backend design
  constructor(private http: HttpClient)
  {
    this.addProductUrl = 'http://localhost:8080/inventory/new';
    this.listProductUrl = 'http://localhost:8080/inventory/all';
  }
  
  public create(product: Product)
  {
    return this.http.post<Product>(this.addProductUrl, product);
  }

  public findAll(): Observable<Product[]>
  {
    return this.http.get<Product[]> (this.listProductUrl);
  }  
}
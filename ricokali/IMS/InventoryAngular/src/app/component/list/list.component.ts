import { Component, OnInit } from '@angular/core';
import{Product} from 'src/app/model/product';
import{ProductService} from 'src/app/service/product.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  product: Product[] = [];
  constructor(private productService : ProductService) { }

  ngOnInit(): void {
    this.productService.findAll().subscribe(data =>
      {
        this.product = data;
      })
  }

}

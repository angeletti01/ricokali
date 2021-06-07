import { Component, OnInit } from '@angular/core';
import{ ActivatedRoute, Router} from '@angular/router';
import{Product} from 'src/app/model/product';
import{ProductService} from 'src/app/service/product.service';


@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent {

  product: Product;

  constructor(private route: ActivatedRoute, 
    private router: Router, 
    private productService: ProductService,
    
    ) 
    {
      this.product = new Product(0,"",0);
     }

     onSubmit()
     {
       this.productService.create(this.product).subscribe(result => this.goToProductList());
       console.log("Product Added to Database");
       this.router.navigate(['/add']);
      
     }

     goToProductList()
     {
       this.router.navigate(['/add']);
     }

  

}

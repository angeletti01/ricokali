export class Product 
{
    product_id: number;
    product_name: string;
    quantity: number;

    constructor(product_id:number, product_name:string, quantity:number)
    {
        this.product_id = product_id;
        this.product_name = product_name;
        this.quantity = quantity;
    }
}

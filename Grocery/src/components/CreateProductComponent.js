import React, { Component } from 'react'
import ProductService from '../services/ProductService.js';

class CreateProductComponent extends Component {
    constructor (props) {
        super(props)

        this.state = {
            
            productName: '',
            productAmount: '',
            productDescription: '',
            availability: ''
            
        }

        this.changeProductNameHandler = this.changeProductNameHandler.bind(this);
        this.changeProductAmountHandler = this.changeProductAmountHandler.bind(this);
        this.changeProductDescriptionHandler = this.changeProductDescriptionHandler.bind(this);
         this.changeAvailabilityHandler = this.changeAvailabilityHandler.bind(this);
        this.saveProduct = this.saveProduct.bind(this);
    }
    // componentDidMount(){
        
    //     if(this.state.productName === '_add'){
    //         return
    //     }else{
    //         ProductService.getProductByName(this.state.product).then( (res) =>{
    //             let product = res.data;
    //             this.setState({productName: product.productName,
    //                 productAmount: product.productAmount,
    //                 productDescription: product.productDescription,
    //                 availability: product.availability
    //             });
    //         });
    //     }
    // }
    saveProduct = (p) => {
        p.preventDefault();
        let product = {productName: this.state.productName, productAmount: this.state.productAmount, productDescription: this.state.productDescription, availability: this.state.availability};
        console.log('product => ' + JSON.stringify(product));
        console.log(this.state.productName);
        
            ProductService.createProduct(product).then(res =>{
                this.props.history.push('/products');
            });
        
    }

    changeProductNameHandler= (event) => {
        this.setState({productName: event.target.value});
    }
    changeProductAmountHandler= (event) => {
        this.setState({productAmount: event.target.value});
    }
    changeProductDescriptionHandler= (event) => {
        this.setState({productDescription: event.target.value});
    }
    changeProductDescriptionHandler= (event) => {
        this.setState({productDescription: event.target.value});
    }
    changeAvailabilityHandler= (event) => {
        //console.log(event.target.value);
        this.setState({availability: event.target.value});
        //console.log(this.state.availability);
    }
    cancel(){
        this.props.history.push('/products');
    }

    // getTitle(){
    //     if(this.state.product === '_add'){
    //         return <h3 className="text-center">Add Product</h3>
    //     }else{
    //         return <h3 className="text-center">Add Product</h3>
    //     }
    // }
    render(){
        return (
            <div>
                <br></br>
                    <div className="container">
                        <div className="row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                               <h1> Add Product </h1>
                                <div className = "card-body">
                                    <form onSubmit={this.saveProduct}>

                                        <div className = "form-group">
                                            <label> Product Name: </label>
                                            <input placeholder="Product Name" name="productName" className="form-control"
                                                value={this.state.productName} onChange={this.changeProductNameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Product Amount: </label>
                                            <input placeholder="Product Amount" name="productAmount" className="form-control"
                                                value={this.state.productAmount} onChange={this.changeProductAmountHandler}/>
                                        </div>
                                         <div className = "form-group">
                                            <label> Product Description: </label>
                                            <input placeholder="Product Description" name="productDescription" className="form-control"
                                                value={this.state.productDescription} onChange={this.changeProductDescriptionHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Availability: </label>
                                            <input placeholder="Availability" name="availability" className="form-control"
                                                value={this.state.availability} onChange={this.changeAvailabilityHandler}/>
                                        </div>

                                        <button type="submit" className ="btn btn-success" >Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
        )
    }
}
export default CreateProductComponent
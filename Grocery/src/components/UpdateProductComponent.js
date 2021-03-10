import React, { Component } from 'react'
import ProductService from '../services/ProductService';

class UpdateProductComponent extends Component {
    constructor(props){
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
        this.updateProduct = this.updateProduct.bind(this);
    }
    componentDidMount(){
        ProductService.getProductByName(this.props.match.params.productName).then(res => {
            console.log(res.data);
            this.setState({productName :res.data.productName, productAmount : res.data.productAmount, productDescription : res.data.productDescription, availability : res.data.availability});
        });
    }
    updateProduct = (p) => {
        p.preventDefault();
        let product = {productName: this.state.productName, productAmount: this.state.productAmount, productDescription: this.state.productDescription, availability: this.state.availability};
        console.log('product => ' + JSON.stringify(product));
        console.log('productName => ' +JSON.stringify(this.state.productName));
        ProductService.updateProduct(product).then(res => {
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
    changeAvailabilityHandler= (event) => {
        this.setState({availability: event.target.value});
    }
    cancel(){
        this.props.history.push('/products');
    }
    render(){
        return (
            <div>
                <br></br>
                    <div className = "container">
                        <div className = "row">
                            <div className="card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Product</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Product Name: </label>
                                            <input placeholder="Product Name" name="productName" className="form-control"
                                                value={this.state.productName} onChange={this.changeProductNameHandler} disabled/>
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

                                        <button className="btn btn-success" onClick={this.updateProduct}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "5px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        )
    }
}
    export default UpdateProductComponent
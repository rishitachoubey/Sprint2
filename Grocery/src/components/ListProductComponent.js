import React, { Component } from 'react'
import ProductService from '../services/ProductService'


class ListProductComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            products: []
        }
        this.addProduct = this.addProduct.bind(this);
       // this.editProduct = this.editProduct.bind(this);
        this.deleteProduct = this.deleteProduct.bind(this);
    }
    deleteProduct(productName){
        ProductService.deleteProduct(productName).then(res => {
            this.setState({product: this.state.product.filter(product => product.productName !== productName)});
        });
    }
    viewProduct(productName){
        this.props.history.push(`/view-product/${productName}`);
    }
    editProduct(productName){
        this.props.history.push(`/update-product/${productName}`);
    }

    componentDidMount(){
        ProductService.getProducts().then((res) => {
            this.setState({ products: res.data});
        });
    }

    addProduct(){
        this.props.history.push('/add-product/_add');
    }
    render(){
        return (
            <div>
                <h2 className="text-center">Products List</h2>
                <div className = "row">
                    <button className="btn btn-primary" onClick={this.addProduct}> Add Product</button>
                </div>
                <br></br>
                <div className = "row">
                    <table className = "table table-striped table-bordered">

                        <thead>
                            <tr>
                                <th> Product Name </th>
                                <th> Product Amount </th>
                                <th> Product Description </th>
                                <th> Avaliability </th>
                                <th> Actions </th>  
                               
                            </tr>
                        </thead>

                        <tbody>
                            {
                                this.state.products.map(
                                    product =>
                                    <tr key = {product.id}>
                                        <td> {product.productName} </td>
                                        <td> {product.productAmount} </td>
                                        <td> {product.productDescription} </td>
                                        <td> {product.availability} </td>
                                        <td>
                                            <button onClick={ () => this.editProduct(product.productName)} className="btn btn-info">Update </button>
                                           
                                            <button style={{marginLeft: "10px"}} onClick={ () => this.viewProduct(product.productName)} className="btn btn-info">View </button>
                                            
                                        </td>
                                    </tr>
                                )
                            }
                     </tbody>
                </table>
             </div>
         </div>
        )
    }
}

export default ListProductComponent

import React, { Component } from 'react'
import ProductService from '../services/ProductService'

class ViewProductComponent extends Component {
    constuctor(props) {
        // super(props)

        this.state = {
            productName: this.props.match.params.product,
            product: {}
        }
    }

    componentDidMount(){
        ProductService.getProductByName(this.state.productName).then( res => {
            this.setState({product: res.data});
        })
    }
    render(){
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Product Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Product Name: </label>
                            <div> {this.state.product.productName }</div>
                        </div>
                        <div className = "row">
                            <label> Product Amount: </label>
                            <div> {this.state.product.productPrice }</div>
                        </div>
                        <div className = "row">
                            <label> Product Description: </label>
                            <div> {this.state.product.productDescription }</div>
                        </div>
                        <div className = "row">
                            <label> Availability: </label>
                            <div> {this.state.product.availability }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewProductComponent
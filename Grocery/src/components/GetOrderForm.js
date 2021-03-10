import React, { Component } from 'react'
import {BrowserRouter as Router,Route,Link ,NavLink} 
from "react-router-dom";
import axios from "axios";
class GetOrderForm extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
            order:[]
        }
        this.viewOrder= this.viewOrder.bind(this);
        this.editOrder= this.editOrder.bind(this);
        this.deleteOrder=this.deleteOrder.bind(this);
    }
    viewOrder(id) {
        this.props.history.push(`/GetOrderById/${id}`);
      }
      editOrder(id) {
        this.props.history.push(`/UpdateOrder/${id}`);
        
      }
      deleteOrder(id) {
        this.props.history.push(`/DeleteOrder/${id}`);
      }
    componentDidMount() {
     axios.get(
            "http://localhost:8080/getAllOrders")
          .then((result) => {
            this.setState({
              order: result.data,
            });
          });
      }
      cancel(){
        this.props.history.push('/Home');
    }
    
    render() {
        var OrderList=this.state.order.map((order,index)=>{
            return(  
                <tr>
                    <td> {order.id} </td>
                    <td> {order.name} </td>
                    <td> {order.phonenumber} </td>  
                    <td> {order.address} </td>
                    <td> {order.orderdescription} </td>
                    <td> {order.orderprice} </td> 
                    <td>
            <button
              onClick={() => this.editOrder(order.id)}
              className="btn btn-success"
            >Update</button></td>
            <td>
            <button
              style={{ marginLeft: "10px" }}
              onClick={() => this.viewOrder(order.id)}
              className="btn btn-warning">View</button>
              {/* <UpdateOrderForm/> */}
          </td>
          <td>
            <button
              style={{ marginLeft: "10px" }}
              onClick={() => this.deleteOrder(order.id)}
              className="btn btn-danger">Delete</button>
              {/* <UpdateOrderForm/> */}
          </td>
                </tr>
        )});
        return (
            <div className="viewdiv">
            <br></br>
            <div className = "card col-md-5 offset-md-3">
                <h3 className = "text-center"> View Order Details</h3>
                <div className = "card-body">
                <table class="table table-bordered">
                <thead >
                    <tr>
                    <th>ID</th>
                    <th>CustomerName</th>
                    <th>phoneNumber</th>
                    <th>Address</th>
                    <th>orderDescription</th>
                    <th>orderPrice</th>
                    <th>View</th>
                    <th>Delete</th>
                    </tr>
                 </thead>
                 <tbody>
                     {OrderList}
                     </tbody>
            </table>
                </div>
                <button type="button" onClick={() => this.cancel()} className="btn btn-Info buttons"> Back </button>
            </div>
            
        </div>
        )
    }
}

export default GetOrderForm



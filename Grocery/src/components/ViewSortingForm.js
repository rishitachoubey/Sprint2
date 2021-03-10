import React, { Component } from 'react'
import {BrowserRouter as Router,Route,Link ,NavLink} 
from "react-router-dom";
import axios from 'axios';
import DeleteOrder from './DeleteOrder';
const sortTypes = {
  up: {
    class: "sort-up",
    fn: (a, b) => a.id - b.id,
  },
  down: {
    class: "sort-down",
    fn: (a, b) => b.id - a.id,
  },
  default: {
    class: "sort",
    fn: (a, b) => a,
  },
};
//  const sortTypes1 = {
//   up: {
//     class: "sort-up",
//     fn: (a, b) => a.name - b.name,
//   },
//   down: {
//     class: "sort-down",
//     fn: (a, b) => b.stock - a.stock,
//   },
//   default: {
//     class: "sort",
//     fn: (a, b) => a,
//   },
// };
 class ViewSortingForm extends Component {
     constructor(props) {
         super(props)
     
         this.state = {
              order:[],
              currentSort: "default",
     };
     
     this.updateOrder= this.updateOrder.bind(this);
     this.deleteOrder=this.deleteOrder.bind(this);
     
   }
   
  updateOrder(id) {
    this.props.history.push(`/UpdateOrderForm/${id}`);
    
  }
  deleteOrder(id) {
    this.props.history.push(`/DeleteOrder/${id}`);
  }
  cancel(){
    this.props.history.push('/Home');
}
redirect(){
  this.props.history.push('/sampleFormById');
}
componentDidMount() {
    axios.get(
           "http://localhost:8080/api/viewallOrder")
         .then((result) => {
           this.setState({
             order: result.data,
           });
         });
     }
    onSortChange = () => {
      const { currentSort } = this.state;
      let nextSort;
      if (currentSort === "down") nextSort = "up";
      else if (currentSort === "up") nextSort = "default";
      else if (currentSort === "default") nextSort = "down";
      this.setState({
        currentSort: nextSort,
      });
    };
    render() {
      const { currentSort } = this.state;
        var orderList=this.state.order.sort(sortTypes[currentSort].fn).map((order,index)=>{
        return (
            <tr>
                    <td  className={`fas fa-${sortTypes[currentSort].class}`}> {order.order_id} </td>
                    <td> {order.customerName} </td>
                    <td> {order.phoneNumber} </td>  
                    <td> {order.address} </td>
                    <td> {order.orderDescription} </td>
                    <td> {order.orderPrice} </td> 
                    <td>
            <button
              onClick={() => this.updateOrder(order.order_id)}
              className="btn btn-success">Update</button></td>
            
          <td>
            <button
  
              onClick={() => this.deleteOrder(order.order_id)}
              className="btn btn-danger ml-2">Delete</button>
          </td>
            </tr>)});
            return(
                <div>
                <div>
                    <h3 className = "text-center"> View Order Details</h3>
                    <button type="button" onClick={() => this.redirect()} className="btn btn-info ml-2 float-right mb-2" > viewOrderById</button>
                    <div>
                    <table className="table">
                    <thead>
                    <tr>
                    <th>
                    {" "}
                   order_id
                   <div class="black" onClick={this.onSortChange}>
                                <span class="glyphicon glyphicon-triangle-top"></span>
                                <span class="glyphicon glyphicon-triangle-bottom"></span>
                                  </div>
                            
                  </th>
                  
                    <th>CustomerName</th>
                    <th>phoneNumber</th>
                    <th>Address</th>
                    <th>OrderDescription</th>
                    <th>OrderPrice</th>
                    <th>Update</th>
                    
                    <th>Delete</th>
                    </tr>
                     </thead>
                     <tbody>
                
                     {orderList}   
                       </tbody>
                       </table>
                       </div>
                <button type="button" onClick={() => this.cancel()} className="btn btn-Info buttons"> Back </button>

                
                
            </div>
            </div>

        );
    }
    }


export default ViewSortingForm
import React, { Component } from 'react'
import axios from "axios";
 class GetOrderById extends Component {
    state = {
        orders: {}
      };
     componentDidMount() {
        axios
          .get(
            `http://localhost:8080/api/viewallOrder/${this.props.match.params.id}`
          )
          .then((result) => {
            this.setState({orders:result.data});
            console.log(result.data.orders)
          });
          
         
      }
      homePage = (event) => {
        this.props.history.push("/Home");
      };
     
    render() {
        return (
            <div className="viewdiv2 card-body" >
              <br/>
              <h3>
                <span style={{ color: "white",padding:"150px"}}>View Order Details</span>
              </h3>
              <div>
                <div className="row" class="col-sm">
                  <table className="table table-striped table-bordered style">
                    <thead style={{color:"white"}}>
                      <tr>
                        <td>
                          <h4 style={{textAlign:'right'}}>Order_Id:</h4>
                        </td>
                        <th>
                          <h4>{this.state.orders.id}</h4>
                        </th>
                      </tr>
                      <tr>
                        <td>
                          <h4 style={{textAlign:'right'}}>CustomerName:</h4>
                        </td>
                        <th>
                          <h4>{this.state.orders.name}</h4>
                        </th>
                      </tr>
                      <tr>
                        <td>
                          <h4 style={{textAlign:'right'}}>phone Number:</h4>
                        </td>
                        <th>
                          <h4>{this.state.orders.phonenumber}</h4>
                        </th>
                      </tr>
                      <tr>
                        <td>
                          <h4 style={{textAlign:'right'}}>Address</h4>
                        </td>
                        <th>
                          <h4>{this.state.orders.address}</h4>
                        </th>
                      </tr>
                      <tr>
                        <td>
                          <h4 style={{textAlign:'right'}}>orderDescription</h4>
                        </td>
                        <th>
                          <h4>{this.state.orders.orderdescription}</h4>
                        </th>
                      </tr>
                      <tr>
                        <td>
                          <h4 style={{textAlign:'right'}}>orderPrice</h4>
                        </td>
                        <th>
                          <h4>{this.state.orders.orderprice}</h4>
                        </th>
                      </tr>
                    </thead>
                  </table>
                </div>
               
              </div>
              <div>
            <button type="button" onClick={() => this.homePage()} className="btn btn-Info buttons"> Back </button>
            </div>
            </div>
            
          );

 }
}

export default GetOrderById

import React, { Component } from 'react'
import axios from "axios";
import GetOrderForm  from "./GetOrderForm"
import Service from './Service';
const initialState={
    order_id:"",
    customerName:"",
    phoneNumber:"",
    address:"",
    orderDescription:"",
    orderPrice:"",
    nameerror:"",
    
    orders:{}
}

 class UpdateCustomerForm extends Component {
    constructor(props) {
        super(props)
    
        this.state = initialState;
        this.changeorder_idHandler=this.changeorder_idHandler.bind(this);
        this.changecustomerNameHandler=this.changecustomerNameHandler.bind(this);
         this.changephoneNumberHandler=this.changephoneNumberHandler.bind(this);
         this.changeaddressHandler=this.changeaddressHandler.bind(this);
         this.changeorderDescriptionHandler=this.changeorderDescriptionHandler.bind(this);
         this.changeorderPriceHandler=this.changeorderPriceHandler.bind(this);
    
    }
    componentDidMount() {
    }
         changeorder_idHandler= (event) => {
            this.setState({
                order_id:event.target.value,
            })
        }
    changecustomerNameHandler= (event) => {
        this.setState({
            customerName:event.target.value,
        })
    }
    changephoneNumberHandler= (event) => {
        this.setState({
            phoneNumber:event.target.value,
        })
    }
    changeaddressHandler= (event) => {
        this.setState({
            address:event.target.value,
        })
    }
    changeorderDescriptionHandler= (event) => {
        this.setState({
            orderDescription:event.target.value,
        })
    }
    changeorderPriceHandler= (event) => {
        this.setState({
            orderPrice:event.target.value,
        })
    }
    validate = () =>{
        let nameerror="";

        let flag=true;
        
         if(this.state.customerName.length == 0 || this.state.customerName == ""){
             nameerror = " customer name should not be empty";
         }
 
         if(nameerror){
             this.setState({nameerror});
             flag=false;
         }

 
         
         return flag;
     }
      handlesubmit=event=>
      {
          const isvalid=this.validate();
          event.preventDefault();
          if(isvalid){
              alert("success")
           
            this.setState(initialState);

            let order = {
                order_id:this.state.order_id,
                customerName: this.state.customerName,
               phoneNumber: this.state.phoneNumber,
                address: this.state.address,
                orderDescription:this.state.orderDescription,
                orderPrice:this.state.orderPrice
                
              };  
              console.log(order) 
              axios.put("http://localhost:8080/api/UpdateOrder",order)
              .then((responseData)=>{
                this.props.history.push('/ViewSortingForm');
              console.log(" Data Added "+responseData.data)}
              )
              .catch((errorData)=>{console.log("error while adding data")})
            }   
           
              // redirect you to Home component after adding user
             
           
            else{
                console.log("error");
            }

        }
        
      homePage = (event) => {
        this.props.history.push("/Home");
      }
    
   render() 
   {
       return (
           <div className="div">
               <br></br>
                  <div className = "container">
                  
                       <div className = "row">
                           <div className = "card col-md-4 offset-md-3 offset-md-2">
                               {
                                 <h4 className="h3">Update Order Details</h4>
                               }
                               <div className = "card-body">
                                   <form className="form" >
                                   <div className = "form-group">
                                   <label class="control-label col-sm-2" for="order_id">order_id:</label>
                                          <input placeholder="Enter the order_id" id="order_id" name="order_id" className="form-control" 
                                              value={this.state.order_id} onChange={this.changeorder_idHandler} />
                                      </div>

                                    <div className = "form-group">
                                    <label class="control-label col-sm-2" for="customerName">customerName:</label>
                                           <input placeholder="Enter the customer name" id="customerName" name="customerName" className="form-control" 
                                               value={this.state.customerName} onChange={this.changecustomerNameHandler} />
                                       </div>
                                       <div style={{color: "red"}}>{this.state.nameerror}</div> 


                                       <div className = "form-group">
                                    <label class="control-label col-sm-2" for="phoneNumber">phoneNumber:</label>
                                           <input placeholder="Enter the phoneNumber" id="phoneNumber" name="phoneNumber" className="form-control" 
                                               value={this.state.phoneNumber} onChange={this.changephoneNumberHandler} />
                                       </div>
                                       


                                       <div className = "form-group">
                                           <label class="control-label col-sm-2" for="address">Address:</label>
                                           <input placeholder="Enter the address" id="address" name="address" className="form-control" 
                                               value={this.state.address} onChange={this.changeaddressHandler}/>
                                       </div>
                                       


                                       <div className = "form-group">
                                       <label class="control-label col-sm-2" for="orderDescription">orderDescription:</label>
                                           <input placeholder="Enter the description" id="oorderDescription"name="orderDescription" className="form-control" 
                                               value={this.state.orderDescription} onChange={this.changeorderDescriptionHandler}/>
                                       </div>
                                       
                             

                                       <div className = "form-group">
                                       <label class="control-label col-sm-2" for="orderPrice">orderPriec:</label>  
                                           <input placeholder="Enter the price" id="orderPrice" name="orderPrice" className="form-control" 
                                               value={this.state.orderPrice} onChange={this.changeorderPriceHandler}/>
                                       </div>
                                      
 
                                       <button type="button"  className="btn btn-success" style={{marginLeft: "100px"}} onClick={this.handlesubmit}  >Update</button>
                                       <button className="btn btn-danger" style={{marginLeft: "10px"}} onClick={this.homePage}>Cancel</button>
                                   </form>
                               </div>
                           </div>
                       </div>

                  </div>
           </div>
       );
   }
}
export default UpdateCustomerForm

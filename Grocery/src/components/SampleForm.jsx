import React from "react";
import axios from "axios";
 const initialState={

        address: "",
        customerName: "",
        orderDescription: "",
        orderPrice: "",
        phoneNumber: "",

            nameerror:"",
            addresserror:"",

}
const namevalidator=/^[a-zA-Z]+$/;
const addressvalidator=/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
class SampleForm extends React.Component {
    constructor(props) {
        super(props)
    
        this.state = initialState;
        this.changecustomerNameHandler=this.changecustomerNameHandler.bind(this);
        this.changephoneNumberHandler=this.changephoneNumberHandler.bind(this);
        this.changeaddressHandler=this.changeaddressHandler.bind(this);
        this.changeorderDescriptionHandler=this.changeorderDescriptionHandler.bind(this);
        this.changeorderPriceHandler=this.changeorderPriceHandler.bind(this);
        
    }
   
    changecustomerNameHandler= (event) => {
       this.setState({
           customerName:event.target.value,nameerror:'',
       });
   }
   changephoneNumberHandler= (event) => {
       this.setState({
           phoneNumber:event.target.value,
       });
   }
   changeaddressHandler= (event) => {
       this.setState({
           address:event.target.value,addresserror:'',
       });
   }
   changeorderDescriptionHandler= (event) => {
       this.setState({
           orderDescription:event.target.value,
           
       });
   }
   changeorderPriceHandler= (event) => {
       this.setState({
           orderPrice:event.target.value,
           
       });
   }
   validate = () =>{
    let nameerror="";
    let addresseerror="";
    
    let flag=true;
    
    if(this.state.customerName.length == 0 || this.state.customerName == ""){
       nameerror="name should not be empty"
    }
    else if(!namevalidator.test(this.state.customerName))
    {
        nameerror="name should contain alphabets";
    }
     if(nameerror){
         this.setState({nameerror});
         flag=false;
     }
     

    if(this.state.address.length == 0 || this.state.address == ""){
        addresseerror = "address should not be empty";
    }
    else if(!addressvalidator.test(this.state.address))
    {
        addresseerror="Must contain city and pincode";
    }
    return flag;
   
}
handleSubmit=event=>
      {
          const isvalid=this.validate();
          event.preventDefault();
          if(isvalid){
            
           this.setState(initialState)
            let order = {
            
                customerName: this.state.customerName,
                phoneNumber: this.state.phoneNumber,
                address: this.state.address,
                orderDescription:this.state.orderDescription,
                orderPrice:this.state.orderPrice
              };
              console.log(order);
              axios.post("http://localhost:8080/api/ConfirmOrder",order)
              .then((responseData)=>{
              console.log(" Data Added "+responseData.data)}
              
              )
              .catch((errorData)=>{console.log("error while adding order data")})
              alert("success")
              this.props.history.push("/ViewSortingForm");
        }else{
            console.log("error")
        }
      } 
      homePage = (event) => {
        this.props.history.push("/Home");
      };


    render() {
      return (
  
          <div>
          <form>
          <div className = "form-group">
                                            <label class="control-label col-sm-2" for="customerName">customerName:</label>
                                            <input placeholder="Enter the customer name" id="customerName" name="customerName" className="form-control" 
                                                  value={this.state.customerName} onChange={this.changecustomerNameHandler}/>
                                        </div>
                                        <span style={{color:"red"}}>{this.state.nameerror}</span>
                                        <div className = "form-group">
                                        <label class="control-label col-sm-2" for="phoneNumber">phoneNumber:</label>
                                        <input placeholder="Enter the phone number" id="phoneNumber" name="phoneNumber" className="form-control" 
                                            value={this.state.phoneNumber} onChange={this.changephoneNumberHandler}/>
                                    </div>
                                    
                                    
                                    <button  className="btn btn-success ml-2"  onClick={this.handleSubmit} >Confirm</button>
                                    <button className="btn btn-danger ml-2"  onClick={this.homePage} >Cancel</button>
        </form>
          </div>
    
      );
    }
  }
    export default SampleForm;
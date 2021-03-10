import React from 'react';
//import './SignUp.css';
import PropTypes from 'prop-types';
import {connect} from 'react-redux';
import {registration} from '../actions/userActions';
import classnames from 'classnames';
class SignUp extends React.Component
 
{
 
    constructor()
    {
        super();
        this.state={
            name:"",
            email:"",
            phone:"",
            password:"",
            role:"",
            address:"",
            errors:{
 
            }
        };
        this.onChange=this.onChange.bind(this);
        this.onSubmit=this.onSubmit.bind(this);
        this.handleFormValidation=this.handleFormValidation.bind(this);
 
    }
 
    onChange(e){
        this.setState({[e.target.id]:e.target.value})
 
    }
    handleFormValidation() {
        let nameError = "";
        let emailError = "";
        let passwordError = "";
        let phoneError = "";
        let roleError = "";
        let addressError = "";
 
        if (!this.state.name) {
            nameError = " Name is required";
        }
        else if(!this.state.name.match("[a-zA-Z]{3,20}")){
            nameError = "Enter a valid name";  
        }
         
        if (!this.state.email) {
            emailError = "Email is required";
        }
         else if(!this.state.email.match("^(.+)@(\\S+)$")){
            emailError = "Enter a valid email id";
         }
        
        if (!this.state.password) {
            passwordError = "Password is required";
        }
          else if(!this.state.password.match("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$"))
          {
              passwordError="Enter a valid password";
          }
        if (!this.state.phone){
            phoneError = "Phone is required";
        }
        if (!this.state.role) {
            roleError = "Role is required";
        }
         else if(!this.state.role.match("[a-zA-Z]{3,20}")){
             roleError="Enter a valid role";
         }
        if (!this.state.address) {
            addressError = "Address is required";
        }
        
        if (nameError || passwordError || emailError || phoneError || roleError || addressError) {
            this.setState({ nameError, passwordError, emailError, phoneError, roleError, addressError });
            return false;
        }
        return true;
 
    }
    componentWillReceiveProps(nextProps) {
        if (nextProps.errors) {
            this.setState({ errors: nextProps.errors })
        }
    }
    onSubmit(e){
        e.preventDefault();
        const isValid=this.handleFormValidation();
        if(isValid){
            const newUser={
            name:this.state.name,
            email:this.state.email,
            phone:this.state.phone,
            password:this.state.password,
            role:this.state.role,
            address:this.state.address
 
        };       //console.log(newUser);
        this.props.registration(newUser,this.props.history);
    }
}
 
    render()
    {
        const {errors}=this.state;
        return(   
          <div>
            <div className="SignUp-form">
                <form onSubmit={this.onSubmit}>
            <img className="Signup-img" src="https://www.pngitem.com/pimgs/m/77-771530_customer-icon-png-new-user-registration-icon-transparent.png" alt=""></img>
             <br></br><br></br>
             
            <input type="text" 
             id="name" placeholder="Enter name" value={this.state.name}
            onChange={this.onChange} className={classnames("form-control",
            { "is-invalid": this.state.nameError })}>
            </input>
            <div className="text-danger">{this.state.nameError}</div>
            <br></br>
            <input type="email"  id="email" placeholder="Enter email" value={this.state.email}
            onChange={this.onChange}  className={classnames("form-control",
            { "is-invalid": this.state.emailError })}></input>
            <div className="text-danger">{this.state.emailError}</div>
             <br></br>
             
            <input type="text"
             className={classnames("form-control",{ "is-invalid": this.state.phoneError })} id="phone" placeholder="Enter phone no" value={this.state.phone}
            onChange={this.onChange}></input>
             <div className="text-danger">{this.state.phoneError}</div>
            <br></br>
 
            <input type="password"
             className={classnames("form-control",
             { "is-invalid": this.state.passwordError })}
             id="password" placeholder="Enter Password" value={this.state.password}
            onChange={this.onChange}></input>
            <div className="text-danger">{this.state.passwordError}</div>
            <br></br>
 
            <input type="text" 
            className={classnames("form-control",
            { "is-invalid": this.state.roleError })}
            id="role"
             placeholder="Enter role" value={this.state.role}
            onChange={this.onChange}></input>
            <div className="text-danger">{this.state.roleError}</div>
             <br></br>
            <input type="text" className={classnames("form-control",
            { "is-invalid": this.state.addressError })} 
            id="address" placeholder="Enter address" value={this.state.address}
            onChange={this.onChange}></input>
            <div className="text-danger">{this.state.addressError}</div>
            <br></br>
            <input type="submit" value="SignUp"></input>
            </form>
                                
        </div>
        </div>
        
        );
    }
}
SignUp.propTypes={
    registration: PropTypes.func.isRequired,
    errors:PropTypes.object.isRequired
}
 
const mapStateToProps=state=>({
    errors: state.errors
})
export default connect(mapStateToProps,{registration})(SignUp);
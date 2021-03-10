import React from 'react';
//import './SignUp.css';
import PropTypes from 'prop-types';
import {connect} from  'react-redux';
import {updateUser} from '../actions/userActions';
import classnames from "classnames";
import { Link } from 'react-router-dom';
class ForgotPassword extends React.Component
{
    constructor()
    {
        super()
        this.state={
            name:"",
            email:"",
            phone:"",
            password:"",
            role:"",
            address:"",
        };
        this.onChange=this.onChange.bind(this);
        this.onSubmit=this.onSubmit.bind(this);
    }
    onChange(e){
        this.setState({[e.target.name]:e.target.value})
    }
    onSubmit(e){
        e.preventDefault();
        const newUser= {
            name:this.state.name,
            phone:this.state.phone,
            email:this.state.email,
            address:this.state.address,
            password:this.state.password,
            role:this.state.role
 
        };
        
        this.props.updateUser(newUser,this.props.history);
    }
    render()
    {
    
    return(
        <div>
            <div className="SignUp-form">
                <img className="Signup-img" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfYGalDCoTJuFhkjxgfn8zwlrhc-y0tKu_gg&usqp=CAU" alt=""></img>
                <br></br><br></br><br></br>
                <form onSubmit={this.onSubmit}>
                <input type="text" className="form-control" name="name" value={this.state.name} onChange={this.onChange} placeholder="Enter Name"></input>
                <br></br><br></br>
                <input type="text" className="form-control" name="phone" value={this.state.phone} onChange={this.onChange} placeholder="Enter phone no"></input>
                <br></br><br></br>
                <input type="email" className="form-control" name="email" value={this.state.email} onChange={this.onChange} placeholder="Enter email"></input>
                <br></br><br></br>
                <input type="text" className="form-control" name="role" value={this.state.role}  onChange={this.onChange} placeholder="Enter role"></input>
                <br></br><br></br>
                <input type="text" className="form-control" name="address" value={this.state.address} onChange={this.onChange} placeholder="Enter address"></input>
                <br></br><br></br>
                <input type="password" className="form-control" name="password" value={this.state.password} onChange={this.onChange} placeholder="Enter password"></input>
                <br></br><br></br>
                <input type="submit" value="Submit" ></input>
                </form>
                
            </div>
            </div>
    );
}
 
}
 
ForgotPassword.propTypes = {
updateUser: PropTypes.func.isRequired,
errors:PropTypes.object.isRequired
}
const mapStateToProps = state => ({
errors:state.errors
})
export default connect(mapStateToProps, {updateUser})(ForgotPassword);
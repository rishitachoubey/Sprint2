import React from 'react';
import '../assets/styles/login.css';
import PropTypes from 'prop-types';
import {connect} from 'react-redux';
import {createUser} from '../actions/userActions';
import classnames from 'classnames';
import {Link} from  'react-router-dom';
import ForgotPassword from './ForgotPassword';
 
class Login extends React.Component {
    constructor()
        {
            super()
            this.state={
                email:"",
                password:""
            };
            this.onChange=this.onChange.bind(this);
            this.onSubmit=this.onSubmit.bind(this);
            this.handleValidation=this.handleValidation.bind(this);
        }
        onChange(e){
            this.setState({[e.target.name]:e.target.value})
        }
        handleValidation() {
          
          let emailError = "";
          let passwordError = "";
           
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
          
          if (passwordError || emailError) {
              this.setState({passwordError, emailError });
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
            if(this.handleVlidation()){
              const newUser={
                email: this.state.email,
                password:this.state.password,
              };
 
              this.props.createUser(newUser,this.props.history);
            }
            
 
            }
            
    render(){
        return (
            <div>
                <div className="form-group">
                    <img className="Login-img" src="https://www.w3schools.com/howto/img_avatar2.png" alt=""></img>
                    <br></br><br></br>
                    <form onSubmit={this.login}>
                    <input type="email" className="form-control" name="email"  value={this.state.email} onChange={this.onChange} 
                    className={classnames("form-control",
            { "is-invalid": this.state.emailError })} 
            required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title="Enter correct email" 
            placeholder="Enter email"></input>
            <div className="text-danger">{this.state.emailError}</div>
                    <br></br><br></br>
                    <input type="password"
                    className={classnames("form-control",
                    { "is-invalid": this.state.passwordError })}
                     name="password"  value={this.state.password} onChange={this.onChange} 
                     placeholder="Enter password"></input>
                     <div className="text-danger">{this.state.passwordError}</div>
                    <br></br><br></br>
                    <Link to="User"><input type="submit" value="Submit"></input></Link>
                    </form>
                    <p className="forgot-Password"><Link to="/ForgotPassword" className="Forgot-link">Forgot Password?</Link></p>
                    
                </div>
                </div>
        );
 
        }
    }
 
Login.propTypes={
  createUser: PropTypes.func.isRequired,
  errors:PropTypes.object.isRequired
}
 
const mapStateToProps=state=>({
  errors: state.errors
})
export default connect(mapStateToProps,{createUser})(Login);

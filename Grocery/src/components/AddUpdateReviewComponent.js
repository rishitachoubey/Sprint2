import React from "react";
//import smiley from "../../public/assets/images/smiley.jpg";
import PropTypes from "prop-types";
import {Link} from "react-router-dom";
import {connect} from "react-redux";
import {addReview} from "../actions/reviewActions";

class AddUpdateReviewComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = { 
            rating:null,
            feedback:'',
            product:{
                productId:null,
                productName:"",
                productAmount:null,
                productDescription:"",
                productAvailability:"",
            }
        };
        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    onSubmit = (event) => {
        event.preventDefault();
        let rating = this.state.rating;
        if (rating!="" && !Number(rating)) {
          alert("Rating must be a Number!");
        }
        else if(rating<1||rating>10) {
            alert("Rating must be a Number between 0 and 10!");
        }
        else {
            const newReview = {
                rating:this.state.rating,
                feedback:this.state.feedback,
                product:{
                    productId:this.state.productId,
                    productName:this.state.productName,
                    productAmount:this.state.productAmount,
                    productDescription:this.state.productDescription,
                    productAvailability:this.state.productAvailability,
                }
            }
            this.props.addReview(newReview, this.props.history);
            alert("Thank You for your Valuable Fedback!");
        }     
    }

    onChange = (event) => {
        let nam = event.target.name;
        let val = event.target.value;
        this.setState({[nam]: val});
    }

    render() {
        return (
            <div style={{ background: '#ffd1dc'}}>
            <form onSubmit={this.onSubmit}>
            <section className="view intro-2">
              <div className="mask rgba-stylish-strong h-100 d-flex justify-content-center align-items-center">
                <div className="container">
                  <div className="row">
                    <div className="col-xl-5 col-lg-6 col-md-10 col-sm-12 mx-auto mt-lg-5">
                      <div className="card wow fadeIn" data-wow-delay="0.3s">
                        <div className="card-body">
                            <div className="text-center"><br/>
                                <h3>Add A Review</h3><br/>
                                <h6>Your Feedback will Help us Serve You Better.</h6>  
                                <h6>Kindly take a minute to share your feedback.</h6><br/>
                            </div>
                            <div className="text-center">
                                <img src="../../public/assets/images/smiley.jpg" className="img-responsive" alt="Smiley Feedback" width="320" height ="100"/><br/><br/>
                            </div>
                            <div className="md-form">
                                <i className="fas fa-user prefix white-text"></i>
                                <label htmlFor="orangeForm-name">Rating : </label>
                                <input type="text" id="orangeForm-name" name="rating"
                                    value={this.state.rating} className="form-control" placeholder="Enter Rating"
                                    onChange={this.onChange} /><br/>
                            </div>
                            <div className="md-form">
                                <i className="fas fa-lock prefix white-text"></i>
                                <label htmlFor="orangeForm-pass">Feedback : </label>
                                <input type="feedback" id="orangeForm-pass" name="feedback"
                                    value={this.state.feedback} className="form-control" placeholder="Enter Feedback" 
                                    onChange={this.onChange} /><br/>                               
                            </div>
                            <div className="md-form">
                                <i className="fas fa-lock prefix white-text"></i>
                                <label htmlFor="orangeForm-pass">Product ID : </label>
                                <input type="productId" id="orangeForm-pass" name="productId"
                                    value={this.state.productId} className="form-control" placeholder="Enter Product ID" 
                                    onChange={this.onChange} /><br/>                               
                            </div>
                            <div className="md-form">
                                <i className="fas fa-lock prefix white-text"></i>
                                <label htmlFor="orangeForm-pass">Product Name : </label>
                                <input type="productName" id="orangeForm-pass" name="productName"
                                    value={this.state.productName} className="form-control" placeholder="Enter Product Name" 
                                    onChange={this.onChange} /><br/>                               
                            </div>
                            <div className="md-form">
                                <i className="fas fa-lock prefix white-text"></i>
                                <label htmlFor="orangeForm-pass">Product Amount : </label>
                                <input type="productAmount" id="orangeForm-pass" name="productAmount"
                                    value={this.state.productAmount} className="form-control" placeholder="Enter Product Amount" 
                                    onChange={this.onChange} /><br/>                               
                            </div>
                            <div className="md-form">
                                <i className="fas fa-lock prefix white-text"></i>
                                <label htmlFor="orangeForm-pass">Product Description : </label>
                                <input type="productDescription" id="orangeForm-pass" name="productDescription"
                                    value={this.state.productDescription} className="form-control" placeholder="Enter Product Description" 
                                    onChange={this.onChange} /><br/>                               
                            </div>
                            <div className="md-form">
                                <i className="fas fa-lock prefix white-text"></i>
                                <label htmlFor="orangeForm-pass">Product Availability : </label>
                                <input type="productAvailability" id="orangeForm-pass" name="productAvailability"
                                    value={this.state.productAvailability} className="form-control" placeholder="Enter Product Availability" 
                                    onChange={this.onChange} /><br/>                               
                            </div>
                            <div className="text-center">
                                <br/><button className="btn warning-color btn-success btn-block btn-lg">Add</button>
                                <Link to={`Product`} className="btn warning-color btn-primary btn-block btn-lg"> 
                                    Back 
                                </Link>            
                            </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
        </form>
        {this.state.element}
        <br/><br/>
      </div>      
      );
    }
}

AddUpdateReviewComponent.propTypes = {
    addReview: PropTypes.func.isRequired,
    errors: PropTypes.object.isRequired
}

const mapStateToProps = state => ({
    errors: state.errors
})

export default connect(mapStateToProps, {addReview}) (AddUpdateReviewComponent);
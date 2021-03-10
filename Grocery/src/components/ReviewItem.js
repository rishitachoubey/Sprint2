import React, {Component} from "react";
import PropTypes from "prop-types";
import {connect} from "react-redux";
import {deleteReview} from "../actions/reviewActions";

class ReviewItem extends Component {
    onDeleteClick(review_id){
        this.props.deleteReview(review_id);
    }

    render() {
        const {review} = this.props;
        return (
            <div className="card mb-1 bg-light">
                <div className="card-header text-primary">
                    Product : {review.product.productName} <br/>
                    Review ID : {review.reviewId}
                </div>
                <div className="card-body bg-light">
                    <p className="card-text">Rating : {review.rating} Stars</p>
                    <p className="card-text">Feedback : {review.feedback}</p>
                    <button className="btn btn-danger ml-4" 
                            onClick={this.onDeleteClick.bind(this, review.reviewId)}> 
                                Delete 
                    </button>
                </div>
            </div>
        )
    }
}

ReviewItem.propTypes = {
    deleteReview: PropTypes.func.isRequired
}

export default connect(null, {deleteReview}) (ReviewItem);
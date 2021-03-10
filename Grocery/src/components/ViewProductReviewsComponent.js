import React from "react";
import {connect} from "react-redux";
import PropTypes from "prop-types";
import {getAllReviews} from "../actions/reviewActions";
import ReviewItem from "./ReviewItem";

class ViewProductReviewsComponent extends React.Component {

    componentDidMount() {
        this.props.getAllReviews();
    }

    render(){
        const {reviews} = this.props.reviews

        let ViewProductReviewsAlgorithmContent;
        let listOfProductReviews = [];

        const ViewProductReviewsAlgorithm = reviews => {
            if(reviews.length < 1){
                return(
                    <div className="alert alert-info text-center" role="alert">
                        <br/>
                        No Reviews Available For The Product.
                        <br/><br/>
                    </div>
                )
            } 
            else {
                const individualReview = reviews.map(review => (
                    <ReviewItem key={review.reviewId} review={review}/>
            ));
            
            for(let i=0; i<individualReview.length; i++) {
                if(individualReview[i].props.review.product.productId==1){
                    listOfProductReviews.push(individualReview[i])
                }          
            }

            return(
                <React.Fragment>
                    <div className="text-center" style={{ background: '#ffd1dc'}}>
                        <br/><h3>Reviews Of A Products</h3><br/>
                        {listOfProductReviews}
                    </div>
                    
                </React.Fragment>
            )

          }
        };

        ViewProductReviewsAlgorithmContent = ViewProductReviewsAlgorithm(reviews);

        return(
            <div className="text-center">
                {ViewProductReviewsAlgorithmContent}
            </div>   
        )
    }
}

ViewProductReviewsComponent.propTypes = {
    getAllReviews: PropTypes.func.isRequired,
    reviews: PropTypes.object.isRequired
}

const mapStateToProps = state => ({
    reviews: state.review
});

export default connect(mapStateToProps, {getAllReviews}) (ViewProductReviewsComponent);
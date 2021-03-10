import React from "react";
import {connect} from "react-redux";
import PropTypes from "prop-types";
import {getAllReviews} from "../actions/reviewActions";
import ProductReviewItem from "./ProductReviewItem";

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
                        No Reviews Available For Any Product.
                        <br/><br/>
                    </div>
                );
            } 
            else {
                const individualReview = reviews.map(review => (
                    <ProductReviewItem key={review.reviewId} review={review}/>
            ));
            
            for(let i=0; i<individualReview.length; i++) {
                if(individualReview[i].props.review.product.productId==this.props.product_id){
                    listOfProductReviews.push(individualReview[i]);
                }        
            }
            if(listOfProductReviews.length <= 0) {
                return(
                    <div className="alert alert-info text-center" role="alert">
                        <br/>
                        No Reviews Available For The Product.
                        <br/><br/>
                    </div>
                );
            } 

            return(
                <React.Fragment>
                    <div className="text-center" style={{ background: '#ffd1dc'}}>
                        <h5>Product Reviews</h5>
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
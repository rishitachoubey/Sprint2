import React from "react";
import {connect} from "react-redux";
import PropTypes from "prop-types";
import {getAllReviews} from "../actions/reviewActions";
import ReviewItem from "./ReviewItem";

class ViewAllReviewsComponent extends React.Component {

    componentDidMount() {
        this.props.getAllReviews();
    }

    render(){
        const {reviews} = this.props.reviews

        let ViewAllAlgorithmContent;
        let listOfReviews = [];

        const ViewAllAlgorithm = reviews => {
            if(reviews.length < 1){
                return(
                    <div className="alert alert-info text-center" role="alert">
                        <br/>
                        No Reviews Available For Any Products As Yet.
                        <br/><br/>
                    </div>
                )
            } 
            else {
                const individualReview = reviews.map(review => (
                    <ReviewItem key={review.reviewId} review={review}/>
            ));
            
            for(let i=0; i<individualReview.length; i++) {
                listOfReviews.push(individualReview[i])
            }

            return(
                <React.Fragment>
                    <div className="text-center" style={{ background: '#ffd1dc'}}>
                        <br/><h3>Reviews Of All Products</h3><br/>
                        {listOfReviews}
                    </div>
                    
                </React.Fragment>
            )
          }
        };

        ViewAllAlgorithmContent = ViewAllAlgorithm(reviews);

        return(
            <div className="text-center">
                {ViewAllAlgorithmContent}
            </div>   
        )
    }
}

ViewAllReviewsComponent.propTypes = {
    getAllReviews: PropTypes.func.isRequired,
    reviews: PropTypes.object.isRequired
}

const mapStateToProps = state => ({
    reviews: state.review
});

export default connect(mapStateToProps, {getAllReviews}) (ViewAllReviewsComponent);
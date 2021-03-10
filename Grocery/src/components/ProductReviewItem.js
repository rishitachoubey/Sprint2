import React, {Component} from "react";
import stars from "./imgs/stars.jpg";

class ProductReviewItem extends Component {

    render() {
        const {review} = this.props;
        return (
            <div className="card mb-1 bg-light">
                    <p>
                        <strong>{review.rating}</strong>&nbsp;
                        <img src={stars} className="img-responsive" alt="Stars" width="20" height ="20"/><br/>
                        {review.feedback}
                    </p>          
            </div>
        )
    }
}

export default ProductReviewItem;
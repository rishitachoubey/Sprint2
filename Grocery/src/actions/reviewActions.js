import axios from "axios";
import {GET_REVIEWS, DELETE_REVIEW} from "../actions/types";

export const addReview = (review, history) => async dispatch => {
    await axios.post("http://localhost:8080/api/products/reviews/add", review);
    history.push("/");
};

export const getAllReviews = () => async dispatch => {
    const res = await axios.get("http://localhost:8080/api/products/reviews/all");
    dispatch({
        type:GET_REVIEWS,
        payload:res.data
    })
};

export const deleteReview = review_id => async dispatch => {
    if(
        window.confirm(
            `You Attempted To Delete Review ${review_id}. This Action Cannot Be Undone! Are You Sure You Want To Delete?`
        )
    ) {
        await axios.delete(`http://localhost:8080/api/products/reviews/${review_id}/delete`);
        dispatch({
            type:DELETE_REVIEW,
            payload:review_id
        })
    }
};
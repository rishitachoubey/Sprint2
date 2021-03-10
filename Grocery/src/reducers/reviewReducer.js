import {GET_REVIEWS, DELETE_REVIEW} from "../actions/types";

const initialState = {
    reviews: [],
    review: {}
};

export default function(state=initialState, action){
    switch(action.type){
        case GET_REVIEWS:
            return{
                ...state,
                reviews: action.payload
            };

        case DELETE_REVIEW:
            return{
                ...state,
                reviews: state.reviews.filter(
                    review => review.reviewId !== action.payload
                )
            };
            
        default:
            return state;
    }
}
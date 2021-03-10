import {combineReducers} from "redux";
import errorsReducer from "./errorsReducer";
import reviewReducer from "./reviewReducer";

export default combineReducers({
    // add reducers here
    errors: errorsReducer,
    review: reviewReducer
});
import { createStore } from "redux";

import { combineReducers } from "redux";
import orderReducer from "../reducers/order-reducer";

const reducer = combineReducers({
  orders: orderReducer,
});

export const store = createStore(
  reducer,
  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
);

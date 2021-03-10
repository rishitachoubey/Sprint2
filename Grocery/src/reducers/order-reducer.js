const orderstate = {
  custName: "Rishita",
  orderIdentifier: "ord01",
};

const orderReducer = (orderState = orderstate, action) => {
  switch (action.type) {
    case "ADD_NEW_ITEM":
      return { ...orderState, items: action.payload };
    case "ADD_ORDER_IDENTIFIER":
      return { ...orderState, orderIdentifier: action.payload };
    case "ADD_AMOUNT":
      return { ...orderState, amount: action.payload };
    default:
      return orderState;
  }
};
export default orderReducer;

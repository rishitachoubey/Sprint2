export const addItem = (items) => {
  return {
    type: "ADD_NEW_ITEM",
    payload: items,
  };
};
export const addOrderIdentifier = (identifier) => {
  return {
    type: "ADD_ORDER_IDENTIFIER",
    payload: identifier,
  };
};
export const addAmount = (amount) => {
  return {
    type: "ADD_AMOUNT",
    payload: amount,
  };
};

import React, { useState } from "react";

export const StoreContext = React.createContext({});

export default ({ children }) => {
  const [cart, setCart] = useState({});
  const [itemsState, setItemsState] = useState();

  const store = {
    cart: [cart, setCart],
    itemsState: [itemsState, setItemsState]
  };

  return (
    <StoreContext.Provider value={store}>{children}</StoreContext.Provider>
  );
};

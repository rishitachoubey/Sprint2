import React, { useContext, useState } from "react";
import { useHistory } from "react-router";
import items from "../data/product.json";
import { StoreContext } from "../store/context";
import { useDispatch } from "react-redux";
import { addOrderIdentifier } from "../actions/order-action";
import ViewProductReviewsComponent from "./ViewProductReviewsComponent";
 
export const PlaceOrderComponent = () => {
  const history = useHistory();
  const {
    cart: [cart],
    itemsState: [itemsState, setItemsState],
  } = useContext(StoreContext);
  const dispatch = useDispatch();
 
  // const [ordIden, setOrderIden] = useState();
 
   const onFieldChange = (e) => {
  //   setOrderIden(e.target.value);
  };
  return (
    <div className="p-3">
   
      {/* <input
        type="text"
        className="form-control"
        placeholder="Enter Order Identifier"
        onChange={onFieldChange}
      /> */}
      <div style={{ display: 'flex', justifyContent: 'flex-start' }}>
       <button 
        onClick={() => {
          setItemsState(
            items
              .map(({ id, name, price }) => {
                if (Object.keys(cart).includes(id)) {
                  return {
                    itemName: name,
                    itemPrice: price,
                    itemQuantity: cart[id],
                  };
                }
                return null;
              })
              .filter((item) => item !== null)
          );
          if (Object.keys(cart).length !== 0) {
            history.push("/order-summary");
           // dispatch(addOrderIdentifier(ordIden));
          } else {
            alert("Your Cart is Empty, Please Add Some Items to Proceed");
          }
        }}
        className="btn btn-primary mt-3"
      >
        Checkout
      </button>
      <button className="btn btn-light" ><a href="/ViewAllReviewsComponent">View All Reviews</a></button>
      </div>
      <div className="container-fluid">
        <div className="row">
      {items.map(({ id, price, name, productDescription, image }) => {
        return (
          <div className="col-6">
          <Item
            imageUri={image}
            id={id}
            price={price}
            name={name}
            productDescription={productDescription}
            key={id}
          />
          </div>
        );
      })}
     </div>
     </div>
    </div>
    
  );
};
 
export const Item = ({ id, price, name, productDescription, imageUri }) => {
  const {
    cart: [cart, setCart],
  } = useContext(StoreContext);
  return (
    <div className="card mt-3">
      <div className="card-body d-inline-flex p-2">
 
        <img
          className="img-fluid img-thumbnail"
          src={imageUri}
          width="100px"
          alt="Card image cap"
        />
        <div className="px-3 mr-auto">
          <div className="h4">{name}</div>
          <div>{productDescription}</div>
          <div>Price: {price}</div>
          <div>
            <button
              style={{ width: 30 }}
              className="btn btn-sm btn-outline-primary font-weight-bold"
              onClick={() => {
                console.log("Decrement");
                setCart((prev) => {
                  return !Object.keys(prev).includes(id) || prev[id] === 0
                    ? { ...cart }
                    : { ...cart, [id]: prev[id] - 1 };
                });
              }}
            >
              -
            </button>
            <span className="mx-3">{cart[id] ||0}</span>
            <button
              style={{ width: 30 }}
              className="btn btn-sm btn-outline-primary font-weight-bold"
              onClick={() => {
                console.log("Increment");
                setCart((prev) => {
                  return !Object.keys(prev).includes(id)
                    ? { ...cart, [id]: 1 }
                    : { ...cart, [id]: prev[id] + 1 };
                });
              }}
            >
              +
            </button>
            <button className="btn btn-light" ><a href="/AddUpdateReviewComponent">Add Review</a></button>
            <ViewProductReviewsComponent product_id={id}/>
          </div>
        </div>
      </div>
    </div>
 
  );
};

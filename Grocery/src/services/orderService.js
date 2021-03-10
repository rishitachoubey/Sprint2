import { useSelector } from "react-redux";
import axios from "axios";

export const createOrderService = (orders) => {
  const headers = { "Access-Control-Allow-Origin": "*" };
  console.log(orders);
  axios
    .post("http://localhost:8080/api/orders", orders, headers)
    .then((res) => console.log("Succefully Submitted data"))
    .catch((err) => console.log("Data Submission failed"));
};

export const searchOrderService = (key) => {
   // const headers = { "Access-Control-Allow-Origin": "*" };
    console.log(key);
    axios
      .get(`http://localhost:8080/api/orders/${key}`)
      .then((res) => console.log(res))
  };
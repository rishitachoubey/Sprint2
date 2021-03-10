import axios from "axios";

const ADMIN_API_BASE_URL = "http://localhost:8080/api";
class Service {​​​​​​​
getOrders() {​​​​​​​​
       return axios.get(ADMIN_API_BASE_URL+"/getallOrders");
     }​​​​​​​​
 
addOrder(order){​​​​​​​​
        return axios.post(ADMIN_API_BASE_URL+"/ConfirmOrder",order);
     }​​​​​​​​
UpdateOrder(order){​​​​​​​​
      return axios.put(ADMIN_API_BASE_URL+"/UpdateOrder",order);
   }​​​​​​​​
getOrderById(id){​​​​​​​​
        return axios.get(ADMIN_API_BASE_URL+"/OrderReview/" +id)
    }​​​​​​​​
 
DeleteOrder(id){​​​​​​​​
        return axios.delete(ADMIN_API_BASE_URL+"/CancelOrder/"  +id)
 }​​​​​​​​
OrderReview(id){​​​​​​​​
   return axios.get(ADMIN_API_BASE_URL+"/OrderReview/"  +id)
}​​​​​​​​
 
}​​​​​​​​
 
export default new Service();


import axios from "axios";
const ADMIN_API_BASE_URL = "http://localhost:8080/api";
class AdminService {
    getOrders(){
        return axios.get(ADMIN_API_BASE_URL+"/getallOrders");
    }
    OrderReview(id){
        return axios.get(ADMIN_API_BASE_URL+"/OrderReview/"+id);
    }
}
export default new AdminService();
import axios from 'axios';

const PRODUCT_API_BASE_URL = "http://localhost:8080/products";

class ProductService{

    getProducts(){
        return axios.get("http://localhost:8080/products/allproducts");
    }

    createProduct(product){
        return axios.post("http://localhost:8080/products/SaveProduct", product);
    }
    getProductByName(productName){
        return axios.get(PRODUCT_API_BASE_URL + '/SearchProduct/' + productName);
    }
    updateProduct(product){
        return axios.put(PRODUCT_API_BASE_URL + '/UpdateProduct', product);
    }
    deleteProduct(productName){
        return axios.delete(PRODUCT_API_BASE_URL + '/' + productName);
    }

}

export default new ProductService()
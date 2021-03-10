import "bootstrap/dist/css/bootstrap.min.css";
import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import {Provider} from "react-redux";
import ListProductComponent from './components/ListProductComponent';
import HeaderComponent from './components/HeaderComponent';           
import FooterComponent from './components/FooterComponent';
import { Home } from "./components/Home";
import {store} from "./store/intial-store";
import CreateProductComponent from './components/CreateProductComponent';
import UpdateProductComponent from './components/UpdateProductComponent';
import ViewProductComponent from './components/ViewProductComponent'
import ViewAllReviewsComponent from './components/ViewAllReviewsComponent';
import AddUpdateReviewComponent from './components/AddUpdateReviewComponent'; 
import ViewProductReviewsComponent from './components/ViewProductReviewsComponent';
import { PlaceOrderComponent } from "./components/PlaceOrderComponent";
import { Ordersummary } from "./components/Ordersummary";
import AboutUs from './components/AboutUs';
import Login from './components/Login';
import SignUp from './components/SignUp';
import ForgotPassword from './components/ForgotPassword';
import User from './components/User';
import ContactUs from './components/ContactUs';
import ConfirmOrderForm from './components/ConfirmOrderForm';
import ViewSortingForm from './components/ViewSortingForm';
import SampleFormById from './components/sampleFormById';
function App() {
  return (
    <div className="App">
     <Provider store={store}>
      <Router>

        <HeaderComponent />
        
          <div className="container">
            <Switch>
                
                <Route path = "/products" component = {ListProductComponent}></Route>
                <Route path = "/addProduct" component = {CreateProductComponent}></Route>
                <Route path = "/updateProduct/:productName" component = {UpdateProductComponent}></Route>
                <Route path = "/viewProduct/:id" component = {ViewProductComponent}></Route>
                <Route path="/addUpdateReviewComponent" component={AddUpdateReviewComponent}/>
                <Route path="/viewProductReviewsComponent" component={ViewProductReviewsComponent}/>
                <Route path="/viewAllReviewsComponent" component={ViewAllReviewsComponent}/>
                <Route path="/about" component={AboutUs}/>
                <Route path="/login" component={Login}/>
                <Route path="/signUp" component={SignUp}/>
                <Route path="/forgotPassword" component={ForgotPassword}/>
                <Route path="/user" component={User}/>
                <Route path="/contact" component={ContactUs}/>
                <Route path="/order" component={ConfirmOrderForm}/>
                <Route path="/orderReview" component={ViewSortingForm}/>
                <Route path="/sampleFormById" component={SampleFormById}/>
                <Route path="/home" component={PlaceOrderComponent}/>
                <Route path="/order-summary"><Ordersummary /> </Route>
              
                    </Switch>
                    
          </div>
        <FooterComponent />
        </Router>
        </Provider>
    </div>
  );
}

export default App;

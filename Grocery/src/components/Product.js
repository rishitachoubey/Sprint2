import React from "react";
import ViewProductReviewsComponent from "./ViewProductReviewsComponent";

class Product extends React.Component {
    render(){
        return(
            <div>
                <br/>
                <h3 className="text-center">List of Products</h3><br/>
                <table className="justify-content-center" border="1" cellPadding="20" align="center">
                    <tr style={{ background: '#ffd1dc'}}>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Product Amount</th>
                        <th>Product Description</th>
                        <th>Actions</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>top ramen masala</td>
                        <td>30</td>
                        <td>noodles</td>
                        <td>
                            <button className="btn warning-color btn-block btn-light btn-lg">
                                <h4><a href="/AddUpdateReviewComponent">Add Review</a><br/></h4>
                            </button> <br/>   
                            <ViewProductReviewsComponent product_id="1"/>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>top ramen curry</td>
                        <td>40</td>
                        <td>noodles</td>
                        <td>
                            <button className="btn warning-color btn-block btn-light btn-lg">
                                <h4><a href="/AddUpdateReviewComponent">Add Review</a><br/></h4>
                            </button> <br/>  
                            <ViewProductReviewsComponent product_id="2"/>
                        </td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>top ramen fiery chilli</td>
                        <td>40</td>
                        <td>noodles</td>
                        <td>
                            <button className="btn warning-color btn-block btn-light btn-lg">
                                <h4><a href="/AddUpdateReviewComponent">Add Review</a><br/></h4>
                            </button> <br/>  
                            <ViewProductReviewsComponent product_id="3"/>
                        </td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td>maggie masala</td>
                        <td>20</td>
                        <td>noodles</td>
                        <td>
                            <button className="btn warning-color btn-block btn-light btn-lg">
                                <h4><a href="/AddUpdateReviewComponent">Add Review</a><br/></h4>
                            </button> <br/>  
                            <ViewProductReviewsComponent product_id="4"/>
                        </td>
                    </tr>
                    <tr>
                        <td>5</td>
                        <td>maggie atta</td>
                        <td>25</td>
                        <td>noodles</td>
                        <td>
                            <button className="btn warning-color btn-block btn-light btn-lg">
                                <h4><a href="/AddUpdateReviewComponent">Add Review</a><br/></h4>
                            </button> <br/>  
                            <ViewProductReviewsComponent product_id="5"/>
                        </td>
                    </tr>
                    <tr>
                        <td>6</td>
                        <td>maggie fusion</td>
                        <td>35</td>
                        <td>noodles</td>
                        <td>
                            <button className="btn warning-color btn-block btn-light btn-lg">
                                <h4><a href="/AddUpdateReviewComponent">Add Review</a><br/></h4>
                            </button> <br/>  
                           <ViewProductReviewsComponent product_id="6"/>
                        </td>
                    </tr>
                </table>
            </div>           
        );
    }
}
export default Product;

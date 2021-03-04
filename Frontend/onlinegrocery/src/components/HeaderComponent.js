import "bootstrap/dist/css/bootstrap.min.css";
import React from "react";

class HeaderComponent extends React.Component {
    render() {
        return (
            <div>


                <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                    <a class="navbar-brand" href="#">Grocers</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Place Order</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Your Orders
        </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="#">Search Order</a>
                                    <a class="dropdown-item" href="#">Update Order</a>
                                    <a class="dropdown-item" href="#">Delete Order</a>

                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#">Go to home Page</a>
                                </div>
                            </li>
                        </ul>

                    </div>
                </nav>
            </div>
        );
    }
}
export default HeaderComponent;
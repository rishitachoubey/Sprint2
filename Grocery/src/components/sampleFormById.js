import React, { Component } from "react";
//import Service from "../services/service";
import AdminService from "../services/adminService";

export class SampleFormById extends Component {
  constructor(props) {
    super(props);
    this.state = {
      
        daddress: "",
        dcustomerName: "",
        dorderDescription: "",
        dorderPrice: "",
        dphoneNumber: "",
      order: {},
    };

    this.handleSubmit = this.handleSubmit.bind(this);
    this.IdHandler = this.IdHandler.bind(this);
  }
  IdHandler = (event) => {
    this.setState({ id: event.target.value, idError: "" });
  };
  validate = () => {
    let idError = "";

    if (this.state.id.length == 0 || this.state.id == "") {
      idError = "id should not be empty";
    // } else if (!this.state.email.includes("@gmail.com")) {
    //   emailError = "invalid email";
    // }
    }

    if (idError) {
      this.setState({ idError });
      return false;
    }
    return true;
  };

  handleSubmit = (event) => {
    const isvalid = this.validate();
    event.preventDefault();
    if (isvalid) {
      //
      AdminService.OrderReview(this.state.id).then(
        (result) => {
          this.setState({
           order: result.data,
           daddress: "address :",
           dcustomerName: "customerName :",
           dorderDescription: "orderDescription :",
           dorderPrice: "orderPrice :",
           dphoneNumber: "phoneNumber :",
          });
        },
        (error) => {
          alert("wrong id given.");
        }
      );

      //alert("success")
    } else {
      alert("invalid id");
    }
  };

  cancel() {
    this.props.history.push("/ViewSortingForm");
  }

  render() {
    return (
      <div className="vieworder">
       
        <div className="container">
          <div className="row">
            <div className="col-md-4 mx-auto border border-rounded mt-5">
              <h4 className="text-center mb-3">Order Review</h4>
              <div>
                <form>
                  <div className="form-group">
                    <label class="control-label col-sm-2">OrderId:</label>
                    <input
                      placeholder="Enter the Id"
                      name="Id"
                      className="form-control"
                      value={this.state.id}
                      onChange={this.IdHandler}
                    />
                  </div>
                  <span className="text-danger">{this.state.idError}</span>

                  <button
                    type="button"
                    className="btn btn-success mt-2"
                    onClick={this.handleSubmit}
                  >
                    Submit
                  </button>
                  <button
                    type="button"
                    className="btn btn-danger ml-2 mt-2"
                    onClick={this.cancel.bind(this)}
                  >
                    Cancel
                  </button>
                </form>

                <div className="container">
                  <table>
                    <tr>
                      <td>{this.state.did}</td>
                      <th>{this.state.order.orderId}</th>
                    </tr>
                    <br></br>
                    <tr>
                      <td>{this.state.dcustomerName}</td>
                      <th>{this.state.order.customerName}</th>
                    </tr>
                    <br></br>
                    <tr>
                      <td>{this.state.dorderDescription}</td>
                      <th>{this.state.order.orderDescription}</th>
                    </tr>
                    <br></br>
                    <tr>
                      <td>{this.state.dorderPrice}</td>
                      <th>{this.state.order.orderPrice}</th>
                    </tr>
                    <br></br>
                    <tr>
                      <td>{this.state.daddress}</td>
                      <th>{this.state.order.address}</th>
                    </tr>
                    <br></br>
                    <tr>
                      <td>{this.state.dphoneNumber}</td>
                      <th>{this.state.order.phoneNumber}</th>
                    </tr>
                    <br></br>
        
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default SampleFormById;
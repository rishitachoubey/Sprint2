import React, { Component } from 'react'
import axios from "axios";
class DeleteOrder extends Component {
    state = {};
  componentDidMount() {
    axios
      .delete(
        `http://localhost:8080/api/DeleteOrder/${this.props.match.params.id}`
      )
      .then(
        (result) => {
          alert("Are you sure. Order is deleting.");
          this.props.history.push("/ViewSortingForm");
        },
        (error) => {
          alert("Order is not deleted.");
        }
      );
  }
  render() {
    return <p>Processing...</p>;
  }
}

export default DeleteOrder

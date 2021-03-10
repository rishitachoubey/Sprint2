import React, { Component } from 'react'
import TrackService from '../services/TrackService'
export class Seestatus extends Component {
    constructor(props) {
        super(props)
        this.state = {
            orderId: '',
            track: {},
            answer:''
        }

        this.fetchTrack = this.fetchTrack.bind(this)
     
    }
        

    fetchTrack = (e) => {
        e.preventDefault()
        TrackService.getstatus(this.state.orderId).then((response) => {
            this.setState({ track: response.data, answer: response.status })
            console.log(response.status);
            console.log(response.data);
            
        })
        
    }

  


    render() {
        return (
            <div>
                <div class="view-img">
                    <form method="GET" onSubmit={this.fetchTrack} >
                        <label>
                            <div>
                                <h3 class="text-drk"><b>Enter OrderId</b></h3>
                                <input
                                    name="orderId"
                                    value={this.state.orderId}
                                    className="form-control"
                                    onChange={(event) => { this.setState({ orderId: event.target.value }) }} />

                            </div>


                        </label>
                        <p></p>
                        <p>
                            <button class="btn btn-success" hover opacity="1">View Track</button>
                        </p>
                     </form>
                     


                 <div class="float-sm-center">
                        <div className="card row-lg-12 ">
                            <div className="card-body">
                                
                            <h4 class="text-info"><b>Tracking Status: </b></h4>
                            <table class="table">
                            <th className="text-light bg-dark">STATUS</th>
                            <th className="text-light bg-dark">DATE</th>
                            <tr className="bg-light text-dark">
                                <td>
                                    {this.state.track?.[0]?.trackStatus}</td>
                                   
                                    <td>
                                    {this.state.track?.[0]?.date}
                                    </td>
                                    </tr>
                                    <tr className="bg-light text-dark">
                                <td>
                                    {this.state.track?.[1]?.trackStatus}</td>
                                   
                                    <td>
                                    {this.state.track?.[1]?.date}
                                    </td>
                                    </tr>
                                    <tr className="bg-light text-dark">
                                <td>
                                    {this.state.track?.[2]?.trackStatus}</td>
                                   
                                    <td>
                                    {this.state.track?.[2]?.date}
                                    </td>
                                    </tr>
                                    <tr className="bg-light text-dark">
                                <td>
                                    {this.state.track?.[3]?.trackStatus}</td>
                                   
                                    <td>
                                    {this.state.track?.[3]?.date}
                                    </td>
                                    </tr>
                                    <tr className="bg-light text-dark">
                                <td>
                                    {this.state.track?.[4]?.trackStatus}</td>
                                   
                                    <td>
                                    {this.state.track?.[4]?.date}
                                    </td>
                                    </tr>
                                   

                            </table>
                            </div>
                            </div>

                        </div>
                    </div>
                </div>
           
            
        )
    }
}

export default Seestatus
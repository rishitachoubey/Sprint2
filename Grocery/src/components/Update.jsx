import React, { Component } from 'react'
import TrackService from '../services/TrackService';
import axios from 'axios';

const initialState={

    orderId: "",
    trackId:"2",
    trackStatus: "",
    date:'',
    id:'',
    orderIdError:"",
    dateError:"",
    statusError:""


}

export class Update extends Component {


    constructor(props) {
        super(props)

        this.state = initialState;

    }


  
    changeorderIdHandler = (e) => {
        this.setState({
            orderId: e.target.value
        })
    }
    changeIdHandler = (e) => {
        this.setState({
            id: e.target.value
        })
    }
   
    changedateHandler = (e) => {
        this.setState({
           date: e.target.value
        })
    }
    changetrackStatusHandler = (e) => {
        this.setState({
            trackStatus: e.target.value
        })
    }


    validate = () =>{

        let orderIdError="";
        let dateError="";
        let statusError="";

        console.log("orderID  "+this.state.id);
        if(!this.state.id){
            orderIdError="order id is required";
        }

        if(!this.state.date){
            dateError="Date is required";
        }

        if(!this.state.trackStatus){
            statusError="Track status is required";
        }

        console.log("orderIdError   "+orderIdError);

        if(orderIdError || dateError || statusError){
            this.setState({orderIdError, dateError, statusError});
            return false;
        }

        return true;
    }

        updateTrack=(e)=>{
            e.preventDefault()
            const isValid= this.validate();
            console.log("isValid "+ isValid);
            if(isValid) {
            let answer={    
                orderId:this.state.orderId,
                date: this.state.date,
                trackId:this.state.trackId,
                trackStatus:this.state.trackStatus,
                id:this.state.id
            }
           axios.post("http://localhost:8080/api/track",answer)
           .then(
               res => {
                   
                    alert('Updated successful')
                    this.props.history.push(`/home`)
                   }
                  
           )

           this.setState(initialState);

                }
           
        }
    

    render() {
                return( 
            <div>   
            <center>
                <div className="container-fluid px-1 px-md-5 px-lg-1 px-xl-5 py-6 mx-auto">
                    <div className="card card0 border-0">
                        <div className="row d-flex">
                            <div className="col-lg-6">
                                <div className="card1 pb-5">
                                    <div></div>
                                    <div className="row px-3 justify-content-center mt-4 mb-5 border-line">
                                         <img src="https://i.pinimg.com/originals/e5/07/d7/e507d704d4b6fdcb17116762fcd99acd.gif" className="image" width="400" height="500"></img> 
                                        </div> 
                                </div>
                            </div>
                            <div className="col-lg-6">
                                <div className="card2 card border-0  bg-info px-4 py-5">
                                    <h5 className="  text-dark"> UPDATE TRACKING</h5>
                                    <p className="text-danger">Please Provide tracking details here!!!</p>
                                    <label className="mb-1">
                                        <h5 className="mb-0 text-sm text-light">ORDER ID</h5>
                                    </label>
                                    {this.state.orderIdError ? ( <div style={{color:"red"}}>{this.state.orderIdError}</div> ): null }

                                    <input className="mb-4" type="text" value={this.state.id} name="id" placeholder="Enter orderId" onChange={this.changeIdHandler.bind(this)}></input>
                                    <label className="mb-1">
                                        <h5 className="mb-0 text-sm text-light">DATE OF STATUS(yyyy-mm-dd)</h5>
                                    </label>
                                    {this.state.dateError ? ( <div style={{color:"red"}}>{this.state.dateError}</div> ): null }
                                    <input className="mb-4" type="text" value={this.state.date} name="date" placeholder="Enter date  of status" onChange={this.changedateHandler.bind(this)}></input>
                                    
                                    <label className="mb-1">
                                        <h5 className="mb-0 text-sm text-light">TRACKING STATUS</h5>
                                    </label>
                                    {this.state.statusError ? ( <div style={{color:"red"}}>{this.state.statusError}</div> ): null }
                                    <input className="mb-4" type="text" value={this.state.trackStatus} name="tarckStatus" placeholder="Enter tracking status" onChange={this.changetrackStatusHandler.bind(this)}></input>
                                    
                                   
                                    <div className="row mb-6 px-3"> <a href="/main"><button href="" type="submit" onClick={this.updateTrack} className="btn btn-blue  bg-warning text-center">Update</button> </a></div>

                                </div>
                            </div>
                        </div>
                       
                    </div>
                </div>
            </center>
            </div > )
    }

}
export default Update
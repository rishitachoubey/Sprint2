import React from "react";


class AboutUs extends React.Component {
    render(){
        return(
            <div className = "justify-content-center align-items-center" style={{ background: '#ffd1dc'}}><br/><br/><br/><br/>
                <h2 className="text-center">Grocers</h2>
                <h4 className="text-center">About Us</h4><br/>
                <p className="text-center"> Our mission is to be Earth’s most customer-centric company. <br/> 
                    Grocers is guided by three principles: <br/> 
                    &nbsp; &nbsp; &nbsp; customer obsession rather than competitor focus, <br/>
                    &nbsp; &nbsp; &nbsp; commitment to operational excellence, <br/> 
                    &nbsp; &nbsp; &nbsp; and long-term thinking. <br/> 
                    We sell all sorts of groceries which are deliverabe within 24 Hours. <br/><br/><br/><br/><br/><br/>
                </p>                  
            </div>
        );
    }
}
export default AboutUs;
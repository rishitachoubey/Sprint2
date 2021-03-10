import React from "react";

class Home extends React.Component {
    render(){
        return(
            <div className = "justify-content-center align-items-center"><br/>
                <h2 className="text-center">Welcome To Grocers!</h2>
                <h4 className="text-center">Lets Get Shopping!</h4>
                <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    <img src="https://media1.tenor.com/images/5f4355976d9085a7e57f7e6f6d81df18/tenor.gif?itemid=14132370" 
                         alt="Lets Get Shopping">
                    </img> 
                </p>                  
            </div>
        );
    }
}
export default Home;
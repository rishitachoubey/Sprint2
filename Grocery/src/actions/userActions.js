import axios from 'axios';
import {GET_ERRORS} from "./types"
import User from '../components/User';


export const registration=(user_register,history)=>async dispatch =>{
    try{
        await axios.post("http://localhost:8080/api/users/register",user_register);
        history.push("/");
        dispatch({
            type:GET_ERRORS,
            payload:{}
        })
    }
    catch(error)
    {
        dispatch({
            type:GET_ERRORS,
            payload:error.response.data
        })
    }

    
};


export const createUser=(user,history) => async (dispatch)=>{
    try{
        let email=user.email;
        let password=user.password;
        const res =await axios.get("http://localhost:8080/api/users/"+email+"/"+password);
        console.log(res.body);
        history.push("/User");
    }
    catch(err){
        dispatch({
            type:GET_ERRORS,
            payload:err.respnse.data
        });
    }
};
export const updateUser =(user,history) => async dispatch => {
    try {
        await axios.put("http://localhost:8080/api/users/update",user);
        history.push("/");
        
    } catch (error) {
        
    }
   
};
import axios from 'axios';




class TrackService {

    getstatus(id){
      return axios.get("http://localhost:8080/api/track/"+id);
      
    }
     
  save(track){
    return axios.post("Http://localhost:8080/api/track",track)
  }

}

export default new TrackService()
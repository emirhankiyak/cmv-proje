import axios from "axios";

export default class HaberService{
    getNews(){
        return axios.get("http://localhost:8080/haberler/tumunuGetir");
    }
}
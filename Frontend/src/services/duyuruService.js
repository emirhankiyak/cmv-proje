import axios from "axios";

export default class DuyuruService{
    getNews(){
        return axios.get("http://localhost:8080/duyurular/tumunuGetir");
    }
}
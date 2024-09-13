import axios from 'axios'

const request2 = axios.create({
  baseURL: "https://imdb-api.com/en/API/Top250Movies",
  timeout: 5000
})

export default request2
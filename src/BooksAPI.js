const api = "http://localhost:8082/SpringProject"

// Generate a unique token for storing your bookshelf data on the backend server.
let token = localStorage.token
if (!token)
  token = localStorage.token = Math.random().toString(36).substr(-8)

const headers = {
  'Accept': 'application/json',
  'Authorization': token,
  "Access-Control-Allow-Origin":"*",
  "Access-Control-Allow-Credentials":true
  
}

export const get = (bookID) =>
  fetch(`${api}/book/${bookID}`, { headers })
    .then(res => res.json())
  

export const getAll = () =>
  fetch(`${api}/book`, { headers })
    .then(res => res.json())


export const update = (book, shelf) =>
  fetch(`${api}/book/${book.id}`, {
    method: 'PUT',
    headers: {
      ...headers,
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({ shelf })
  }).then(res => res.json())

/*export const search = (query, maxResults) =>
  fetch(`${api}/book`, {
    method: 'POST',
    headers: {
      ...headers,
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({ query, maxResults })
  }).then(res => res.json())
    .then(data => data.book)*/

export const add = (book) =>
    fetch(`${api}/book/`, {
      method: 'POST',
      headers: {
        ...headers,
        'Content-Type': 'application/json'
      },
     // body: JSON.stringify({ book })
    }).then(res => res.json())
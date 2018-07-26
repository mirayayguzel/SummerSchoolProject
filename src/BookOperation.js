import React from 'react'
import * as BooksAPI from './BooksAPI'


class SearchBook extends React.Component{
    constructor(props){
        super(props)
        
    
        this.state={book:[],book1:{},click:0,find:0}
        
        this.handleChange=this.handleChange.bind(this)
        this.handleClick=this.handleClick.bind(this)
        
    }
    handleChange(event){
        
        this.setState({[event.target.name]:event.target.value})
       
    }
    handleClick(event){
  
        BooksAPI.get(this.state.inputName).then((book)=>{
            
            console.log(book.length)
            this.setState({book1:book})
            this.setState({click:1})
            if(book.title==null){
                console.log("not finded")
                this.setState({find:0})

                
            }else{
                console.log("finded")
                this.setState({find:1})
            }
           
        }
        
     )
        
        
    }
    render(){
        console.log(this.state.book1)
       
        
        return(
            <div>
            <label for="inputName"><b>Book Name</b></label>
            <input name="inputName" type="text" value={this.state.inputName}
            onChange={this.handleChange} 
           />
            
            <button onClick={this.handleClick} >Search</button>
            {(this.state.click==1) ? ((this.state.find!=1)?(
                <p><br/>Book can not find.</p>
                
        ):(<table border="1" >
                    
        <tr><th>Book Name: {this.state.book1.title}</th></tr>
        <tr><th>Book id: {this.state.book1.bookID}</th> </tr>  
        <tr><th>Author Name:  {this.state.book1.publishername}</th> </tr>
        <tr><th>Author id: {this.state.book1.authorID}</th> </tr>
        <tr><th>Available: {this.state.book1.available}</th> </tr>
        <tr><th>Book Name:  {this.state.book1.title} </th></tr>


        </table>)
                   
             ) : (
                    ''
                 )}
           </div>
        )
           
            
           
        
           
            
        
    }

}

class BookApp extends React.Component{
    constructor(props){
        super(props)
    }
    render(){
        return(
            <div>
                <SearchBook/>
             
            </div>
            
        )

    }
}
export default BookApp;

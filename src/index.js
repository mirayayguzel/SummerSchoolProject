import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import BookApp from './BookOperation';

ReactDOM.render(<BookApp />, document.getElementById('root'));
registerServiceWorker();

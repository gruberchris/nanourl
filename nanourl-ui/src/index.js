import React from 'react';
import ReactDOM from 'react-dom';
import 'bootstrap/dist/css/bootstrap.css';
import './index.css';
import App from './app';
import * as serviceWorker from './serviceWorker';
import { ConnectedRouter } from 'react-router-redux';
import { Provider } from 'react-redux';
import { buildStore } from './store';
import { createBrowserHistory } from 'history'

const history = createBrowserHistory();
const store = buildStore();

ReactDOM.render(<Provider store={store}>
    <ConnectedRouter history={history}>
        <App history={history} store={store} />
    </ConnectedRouter>
  </Provider>,
  document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();

import { combineReducers } from 'redux';
import { routerReducer } from 'react-router-redux';

const index = combineReducers({
    router: routerReducer
});
  
export default index;

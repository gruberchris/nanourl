import { applyMiddleware, compose, createStore } from 'redux';

import createSagaMiddleware from 'redux-saga';
import rootReducer from './reducers';
// import sagas from './sagas';

const sagaMiddleware = createSagaMiddleware();

export function buildStore() {
  const middlewares = [sagaMiddleware];

  const store = createStore(
    rootReducer,
    window.__REDUX_DEVTOOLS_EXTENSION__ &&
      window.__REDUX_DEVTOOLS_EXTENSION__(),
    compose(applyMiddleware(...middlewares))
  );

  // sagaMiddleware.run(sagas);

  return store;
}

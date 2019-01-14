/*
import { all } from 'redux-saga/effects';
import { flatten, map } from 'ramda';
import { watchers as authSagas } from '../components/auth/sagas';

const invoke = (f) => f();
const watchers = [];

Array.prototype.push.call(
    watchers,
    map(invoke, authSagas)
);

export default function* index() {
    yield all(flatten(watchers));
}
*/
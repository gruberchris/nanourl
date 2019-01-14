import React from 'react';
import { Route } from 'react-router-dom';
import { authClient } from './auth';

export const SecuredRoute = (props) => {
    const { component: Component, path, checkingSession } = props;
    return (
        <Route path={path} render={() => {
            if (checkingSession) return <h3 className="text-center">Validating session...</h3>;
            if (!authClient.isAuthenticated()) {
                authClient.login();
                return <div></div>;
            }
            return <Component />
        }} />
    );
}

export default SecuredRoute;
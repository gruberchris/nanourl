import React from 'react';
import PropTypes from 'prop-types';
import { compose } from 'redux';
import { connect } from 'react-redux';
import {
    Route,
    Switch,
    withRouter
} from 'react-router-dom';
import { authClient } from '../components/auth';
import NavBar from './navBar';
import LoginCallback from './loginCallback';
import Home from './home';
import SecuredRoute from '../components/auth/securedRoute';

const ConnectedSwitch = connect((state) => ({ location: state.router.location }))(Switch);

export class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
          checkingSession: true,
        }
      }

    componentWillUnmount() {
        this.store.unsubscribe();
    }

    async componentDidMount() {
        if (this.props.location.pathname === '/callback') {
          this.setState({checkingSession:false});
          return;
        }
        try {
          await authClient.silentAuth();
          this.forceUpdate();
        } catch (err) {
          if (err.error !== 'login_required') console.log(err.error);
        }
        this.setState({checkingSession:false});
      }

    render() {
        return (
            <div>
                <NavBar />
                <ConnectedSwitch>
                    <Route path="/callback" component={LoginCallback} />
                    <SecuredRoute path="/" component={Home} />
                </ConnectedSwitch>
            </div>
        );
    }
}

App.propTypes = {
    history: PropTypes.object.isRequired
};

export const mapStateToProps = (state) => {
    return {
        location: state.router.location
    };
};

export const mapDispatchToProps = () => {
    return {};
};

const connector = connect(mapStateToProps, mapDispatchToProps);

export default compose(withRouter, connector)(App);
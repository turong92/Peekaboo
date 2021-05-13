import React, { Component, PropTypes } from 'react'; 
const propTypes = { };
const defaultProps = { };
class test extends Component { 
    constructor(props) { 
        super(props)
    }
    render() {
        return(
            <div>test</div>
        );
    }
}
test.propTypes = propTypes;
test.defaultProps = defaultProps
export default test;
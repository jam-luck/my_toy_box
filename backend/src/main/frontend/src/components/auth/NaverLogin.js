import PropTypes from 'prop-types';

import NaverLogin from 'react-naver-login';
import { snsPayloadParser } from '../util/common';

const Naver = (props) => {
  const clientId = process.env.REACT_APP_NAVER || '';
  console.log(clientId);
  const success = payload => {
    props.success(snsPayloadParser.NAVER(payload));
  };

  const fail = payload => {
    props.fail(payload);
  };

  if (!clientId) return <>.env의 REACT_APP_NAVER을 확인해주세요.</>

  return (
    // <></>
    <NaverLogin
      clientId={clientId}
      callbackUrl={`http://localhost:3000${window.location.pathname}`}
      onSuccess={success}
      onFailure={() => fail}
      render={renderProps => (
        <button onClick={renderProps.onClick} >Naver Login</button>
      )}
    ></NaverLogin>
  );
};

Naver.propTypes = {
  success: PropTypes.func.isRequired,
  fail: PropTypes.func.isRequired,
};

export default Naver
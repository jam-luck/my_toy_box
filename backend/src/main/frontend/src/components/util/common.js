export const snsPayloadParser = {
    NAVER: (payload) => ({
      id: payload.id,
      email: payload.email,
      platform: 'naver',
    })
  };
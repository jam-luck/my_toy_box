export const snsPayloadParser = {
    NAVER: (payload) => ({
      id: payload.id,
      name: payload.name,
      gender: payload.gender,
      email: payload.email,
      platform: 'naver',
    })
  };
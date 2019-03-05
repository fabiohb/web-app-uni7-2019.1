class LoginService {
  constructor() {
    this.axios = axios.create({
      baseURL: 'api/login',
    });
  }

  login(cpf, senha) {
    var data = { cpf: cpf, senha: senha };
    return this.axios.post('', data)
      .then(response => {
        sessionStorage.authtoken = response.headers.authorization;
        return Promise.resolve(response);
      })
      .catch(error => {
        console.error('[ERROR: LoginService]\n', error);
        return Promise.reject(error);
      });
  }
}

var loginService = new LoginService();
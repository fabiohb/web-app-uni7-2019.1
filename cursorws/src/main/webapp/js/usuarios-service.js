class UsuariosService {
  constructor() {
    this.axios = axios.create({ baseURL: 'api/usuarios' });
    
    this.axios.interceptors.request.use(
      (config) => {
        config.headers['Authorization'] = sessionStorage.authtoken;
        return config;
      },
      (error) => {
        return Promise.reject(error);
      }
    );
    
    this.axios.interceptors.response.use(
      (response) => {
        sessionStorage.authtoken = response.headers.authorization;
        return Promise.resolve(response);
      },
      (error) => {
        if (error.response.status == 403) {
          window.location = 'login.html';
          return error;
        } else {
          return Promise.reject(error);
        }
      }
    );
  }

  request(method, url, data) {
    return this.axios[method](url, data)
      .then(response => {
        return response.data;
      })
      .catch(error => {
        console.error(
                  '[ERROR: UsuariosService] ' + method + ' ' + url, error);
        return Promise.reject(error);
      });
  }

  selecionar(id) {
    return this.request('get', '/' + id); 
  }

  selecionarTodos() { 
    return this.request('get');
  }
  
  inserir(usuario) {
    return this.request('post', '', usuario);
  }
  
  atualizar(usuario) {
    return this.request('put', '/' + usuario.id, usuario);
  }
  
  excluir(id) {
    return this.request('delete', '/' + id);
  }
}

var usuariosService = new UsuariosService();
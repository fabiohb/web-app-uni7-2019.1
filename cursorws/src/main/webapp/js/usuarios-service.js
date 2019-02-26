class UsuariosService {
  constructor() {
    this.axios = axios.create({ baseURL: 'api/usuarios' });
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
}

var usuariosService = new UsuariosService();
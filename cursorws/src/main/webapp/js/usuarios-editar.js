var router = new VueRouter({ mode: 'history', routes: [] });

var app = new Vue({
  router,

  el: '#app',

  data: {
    mensagem: {},
    usuario: {
      id: null,
      cpf: null,
      nome: null,
      email: null,
      data: null,
      senha: null,
    },
    erros: {
      cpf: null,
      nome: null,
      email: null,
      data: null,
      senha: null,
    }
  },
  methods: {
    modoEdicao(){
      return this.usuario.id ? true : false;
    },

    inserir() {
      this.limparMensagem();
      usuariosService.inserir(this.usuario)
        .then(id => {
          this.usuario.id = id;
          this.exibirMensagem('success', 
            'Usuário com id = ' + id + ' criado com sucesso.');
        })
        .catch(error => {
          this.tratarErro(error);
        });
    },
    
    tratarErro(error) {
        switch (error.response.status) {
        default:
            this.exibirMensagem('error', 'Erro inesperado.');
            break;
        }
    },
    
    exibirMensagem(tipo, texto) {
        this.mensagem = { tipo, texto, exibir: true };
    },

    limparMensagem() {
      this.mensagem = { tipo: 'info', texto: '', exibir: false };
    },

  }
});
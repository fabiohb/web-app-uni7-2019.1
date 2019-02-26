var app = new Vue({
  el: '#app',

  data: {
    mensagem: {},
    headers: [
      { text: 'CPF', sortable: true, value: 'cpf' },
      { text: 'Nome', sortable: true, value: 'nome' },
      { text: 'E-mail', sortable: true, value: 'email' },
      { text: 'Data Nascimento', sortable: true, value: 'data' },
    ],
    usuarios: [],
  },

  mounted() {
    this.carregar();
  },
  
  methods: {
    carregar() {
      this.limparMensagem();
      usuariosService.selecionarTodos()
        .then(usuarios => {
          this.usuarios = usuarios;
        })
        .catch(error => {
          this.usuarios = [];
          this.exibirMensagem('error', 'Erro inesperado.');
        });
    },

    exibirMensagem(tipo, texto) {
      this.mensagem = { tipo, texto, exibir: true };
    },

    limparMensagem() {
      this.mensagem = { tipo: 'info', texto: '', exibir: false };
    },
  }
});
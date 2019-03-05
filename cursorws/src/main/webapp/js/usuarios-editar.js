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
  
  mounted() {
    this.usuario.id = this.$route.query.id;
    this.carregar();
  },
  
  methods: {
    modoEdicao() {
      return this.usuario.id ? true : false;
    },

    carregar() {
      if (this.modoEdicao()) {
        usuariosService.selecionar(this.usuario.id)
          .then(usuario => {
            console.log(usuario);
            this.usuario = usuario;
          })
          .catch(error => {
            this.tratarErro(error);
          });
      }
    },

    inserir() {
      this.limparErros();
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
    
    atualizar() {
      this.limparErros();
      this.limparMensagem();
      usuariosService.atualizar(this.usuario)
        .then(data => {
          this.exibirMensagem('success', 'Usuário atualizado com sucesso.');
        })
        .catch(error => {
          this.tratarErro(error);
        });
    },

    excluir() {
      this.limparMensagem();
      usuariosService.excluir(this.usuario.id)
       .then(data => {
         this.usuario = {id: null, cpf: null, nome: null,
                         email: null, data: null, senha: null};
         this.exibirMensagem('success', 'Usuário excluído com sucesso.');
       })
       .catch(error => {
         this.tratarErro(error);
       });
    },
    
    tratarErro(error) {
      switch (error.response.status) {
      case 422: // Unprocessable Entity
        let validacoes = error.response.data;
        for (let erro in this.erros) {
          for (let index in validacoes) {
            if (erro === validacoes[index].propriedade) {
              this.erros[erro] = validacoes[index].mensagem;
            }
          }
        }
        this.exibirMensagem('error', 'Verifique erros no formulário!');
        break;
      case 404: //  Not found
          this.exibirMensagem('error', 
            'O registro solicitado não foi encontrado!');
          break;
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

    limparErros() {
      this.erros = { cpf:null, nome:null, email:null, data:null, senha:null };
    },
  }
});
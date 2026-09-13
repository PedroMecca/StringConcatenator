## Justificativa técnica

- **Sealed class para rotas**: fecha o conjunto de destinos de navegação em tempo de
  compilação, evitando strings soltas e erros de digitação.
- **Argumento de rota (ida)**: a string atual é necessária para a AddWordScreen
  renderizar seu campo somente leitura — é um dado de entrada da tela, então cabe
  naturalmente como parte da rota.
- **SavedStateHandle (volta)**: a palavra digitada é um resultado produzido pela tela
  filha após a navegação já ter retornado — não existe "retorno" nativo de tela via
  rota em Compose Navigation, e o SavedStateHandle da entrada anterior na pilha é o
  canal oficial para isso, sobrevivendo a recomposição e mudança de configuração.

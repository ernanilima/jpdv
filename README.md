# jPDV
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/ernanilima/jpdv-desktop/blob/master/LICENSE) 

# Sobre o projeto
Aplicação desktop desenvolvida com o objetivo de treinar a linguagem Java.

jPDV foi construído com Java (back-end) e Java Swing (front-end) que utiliza o padrão MVP, aplicação com intuito de simular um PDV de Supermercado.

Esta aplicação usa níveis para validações de acesso, sendo **nível 1 = operador**, **2 = fiscal**, **3 = gerente**.
O banco de dados é gerado automaticamente com algumas informações em SQLite.

A aplicação disponibiliza de:
* Login com validação de nível.
* Abertura de caixa com valor inicial.
* Multiplicação de produto.
* Registro de produto por busca geral ou código de barras.
* Desconto de produto registrado.
* Cancelamento de produto registrado.
* Cancelamento de cupom aberto.
* Totalizar venda.
* Utilização de formar de pagamento para finalizar a venda.
* Exibe troco com base em valor finalizado em dinheiro.
* Exibe dialog para solicitar permissão de outro usuário caso o operador atual não tenha o nível solicitado.


PS: Um mini PDV foi apenas o contexto escolhido por mim já que trabalho a anos com sistemas do tipo, todo o código dentro deste projeto pode ser reutilizado para qualquer projeto

### Informacoes geradas automaticamente
#### Usuários:
<table>
    <tr>
        <td>Código</td>
        <td>Senha</td>
        <td>Nível</td>
    </tr>
    <tr>
        <td>1</td>
        <td>1</td>
        <td>1</td>
    </tr>
    <tr>
        <td>2</td>
        <td>2</td>
        <td>2</td>
    </tr>
    <tr>
        <td>3</td>
        <td>3</td>
        <td>3</td>
    </tr>
    <tr>
        <td>4</td>
        <td>4</td>
        <td>3</td>
    </tr>
</table>

#### Produtos:
<table>
    <tr>
        <td>Cód. Barras</td>
        <td>Preço</td>
    </tr>
    <tr>
        <td>7894</td>
        <td>R$ 45,00</td>
    </tr>
    <tr>
        <td>7895</td>
        <td>R$ 25,00</td>
    </tr>
    <tr>
        <td>7896</td>
        <td>R$ 9,00</td>
    </tr>
</table>

### Teclas de atalho
Tecla      | Função                                             | Observação
-----------|----------------------------------------------------|-----------
`esc`      | Sair                                               | Qualquer janela
`enter`    | Buscar produtos                                    | No campo de código de barras
`q`        | Registra nova quantidade                           | Necessário informar valor no campo código de barras
`↑` ou `↓` | Navegar entre produtos registrados                 | Necessário ter produtos
`-`        | Abre tela para aplicar desconto                    | Usar tecla numérica
`i`        | Abre lista para cancelar produto registrado        | Necessário ter produtos
`y`        | Cancela cupom atual                                | Necessário ter cupom aberto
`t`        | Abre tela para totalizar venda                     | Necessário ter venda em aberto
`F2`       | Seleciona Dinheiro como forma de recebimento       | Tela de totalizar venda
`F3`       | Seleciona Cartao Débito como forma de recebimento  | Tela de totalizar venda
`F4`.      | Seleciona Cartao Crédito como forma de recebimento | Tela de totalizar venda

# Mais
Este projeto faz parte do meu portfólio pessoal, então, ficarei feliz se você puder me fornecer algum feedback sobre o projeto, código, estrutura ou qualquer coisa que você possa relatar que possa me tornar um desenvolvedor melhor!

Contato através do [LinkedIn](https://www.linkedin.com/in/ernanilima)

Email: ernani.tecc@gmail.com

Além disso, você pode usar este projeto como quiser, seja para estudar ou fazer melhorias!

É grátis!

# Tecnologias utilizadas
- Java
- Java Swing
- SQLite
- Maven

## IDE utilizada
- NetBeans ([Site Oficial](https://netbeans.apache.org/download/nb120/nb120.html))

# Como executar o projeto
O projeto possui um arquivo [.jar](https://github.com/ernanilima/jpdv-desktop/blob/master/out/artifacts/jPDV_jar/jPDV.jar) que pode ser executado localmente

## Clonar repositório
Pré-requisitos: Java 8

```bash
git clone https://github.com/ernanilima/jpdv-desktop.git
```

# Autor

Ernani Lima - https://ernanilima.com.br/

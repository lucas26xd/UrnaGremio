# :mask: :coffee: :computer: [Quarentine Project](https://github.com/lucas26xd/Quarentine-Projects)  #5 - Nostalgia 2.0
[![GitHub author](https://img.shields.io/badge/author-lucas26xd-blueviolet?style=flat-square)](https://github.com/lucas26xd)
[![GitHub last commit](https://img.shields.io/github/last-commit/lucas26xd/UrnaGremio?color=blueviolet&style=flat-square)](../../commits/master)
![GitHub repo size](https://img.shields.io/github/repo-size/lucas26xd/UrnaGremio?color=blueviolet&style=flat-square)
[![GitHub license](https://img.shields.io/github/license/lucas26xd/UrnaGremio?color=blueviolet&style=flat-square)](LICENSE)
![GitHub top language](https://img.shields.io/github/languages/top/lucas26xd/UrnaGremio?color=blueviolet&style=flat-square)
![GitHub count language](https://img.shields.io/github/languages/count/lucas26xd/UrnaGremio?color=blueviolet&style=flat-square)
# UrnaGremio
Momento nostálgico, um dos primeiros projetos completos que fiz com um amigo no início do ano de 2014. Trata-se de uma urna para votação de um grêmio estudantil na escola em que estudávamos

### ⚙️ Funcionamento
A tela inicial é controlada por um administrador que, depois de entrar com a senha do sistema,  pode iniciar a urna para votação, bem como analisar resultados parciais e gerar o relatório da votação, o administrador também poderá, se for o caso, zerar o banco de dados para reiniciar uma votoação por exemplo.

Na urna, para votar, o usuário deve utilizar o mouse e clicar e um dos botões referentes a cada chapa ou no botão BRANCO e depois confirmar seu voto. Após a confirmação do voto, é emitido um som para sinalizar ao usuário e ao mesário o fim do voto, neste momento a urna fica bloqueada aguardando o mesário pressionar um botão no Arduino conectado no computador que está rodando a aplicação da urna para liberá-la para a próxima pessoa poder votar. Este funcionamento com Arduino e botão tem o intuito de evitar que um mesmo usuário vote mais de uma vez.

### 🚀 Especificações
Todo código foi construído inteiramente em [Java](https://www.java.com/) usado JFrame para criação das interfaces gráficas. Também foi utilizado um Arduino com um botão conectado na porta digital 3 para desbloqueio da urna a cada voto pelo mesário.
O código do Arduino encontra-se na pasta Botao_Arduino. Abaixo segue o esquemático e funcionamento do circuito no Arduino.
![Esquemático](http://g.recordit.co/67MSi39osP.gif)

## :date: Maio de 2014
Estávamos no Terceiro ano do ensino médio profissionalizante em Redes de Computadores e cheios de vontade de inovar e criar coisas na área de tecnologia.
Na EEEP Marta Maria Giffoni de Sousa.
![Foto Urna](https://eeepmartagiffoni.files.wordpress.com/2014/05/lucas-e-ivan.jpg)

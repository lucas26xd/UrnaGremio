# Quarentine Project #5 - Nostalgia 2.0
## UrnaGremio
Momento nostálgico, um dos primeiros projetos completos que fiz com um amigo no início do ano de 2014. Trata-se de uma urna para votação de um grêmio estudantil na escola em que estudávamos

### Funcionamento
A tela inicial é controlada por um administrador que, depois de entrar com a senha do sistema,  pode iniciar a urna para votação, bem como analisar resultados parciais e gerar o relatório da votação, o administrador também poderá, se for o caso, zerar o banco de dados para reiniciar uma votoação por exemplo.

Na urna, para votar, o usuário deve utilizar o mouse e clicar e um dos botões referentes a cada chapa ou no botão BRANCO e depois confirmar seu voto. Após a confirmação do voto, é emitido um som para sinalizar ao usuário e ao mesário o fim do voto, neste momento a urna fica bloqueada aguardando o mesário pressionar um botão no Arduino conectado no computador que está rodando a aplicação da urna para liberá-la para a próxima pessoa poder votar. Este funcionamento com Arduino e botão tem o intuito de evitar que um mesmo usuário vote mais de uma vez.

### Especificações
Todo código foi construído inteiramente em Java usado JFrame para criação das interfaces gráficas. Também foi utilizado um Arduino com um botão conectado na porta digital 3 para desbloqueio da urna a cada voto pelo mesário.
O código do Arduino encontra-se na pasta Botao_Arduino.

## Maio de 2014
Estávamos no Terceiro ano do ensino médio profissionalizante em Redes de Computadores e cheios de vontade de inovar e criar coisas na área de tecnologia.
Na EEEP Marta Maria Giffoni de Sousa.
![Foto Urna](https://scontent.fqbx1-1.fna.fbcdn.net/v/t1.0-9/10246583_630796147006965_4459809129163711243_n.jpg?_nc_cat=107&_nc_sid=ba80b0&_nc_oc=AQnyF65fbLqk2LNAYpThf3v6gBFsxeriKiF5vygTfoAnW1QDiLFPo3QtT19XSS1JzEo&_nc_ht=scontent.fqbx1-1.fna&oh=8487b9bfb9fe43d610b4611b232e8141&oe=5F16C09A)

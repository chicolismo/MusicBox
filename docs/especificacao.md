<style>
figcaption { margin-top: -4em; text-align: center; font-weight: bold; }
figure { margin: 4em 0 4em 0; }
img { display: block; margin: auto; }
.break { page-break-after: always; }
</style>
# Documentação

## Lista de requisitos funcionais

* O programa deve ser capaz de escolher o nome de um arquivo de texto.
* Tendo um nome de arquivo, o programa deverá ser capaz de lê-lo para
reproduzir a música.
* Além disso, deve ser possível informar o BPM padrão da música como um
argumento.
* O programa deve ser capaz de traduzir os caracteres lidos para as strings necessárias para reproduzir a música, conforme a API do JFugue.

## Lista de requisitos não-funcionais

* Ter bons testes.
* Somente poderá aceitar arquivos `.txt`.

<h2 style="page-break-befor=always">Modo de uso</h2>

Depois abrir o programa, o usuário será apresentado a esta tela:

<figure>
<img width="642" src="./images/main_window.png">
<figcaption>A tela inicial</figcaption>
</figure>

Nela o usuário poderá escolher o `BMP` inicial e abrir um arquivo do tipo `.txt` para ser tocado.

<div class="break"></div>

Quando apertar o botão de `Abrir arquivo` será exibida a tela de seleção de arquivo:

<figure>
<img width="662" src="./images/open_file_dialog.png">
<figcaption>A tela de seleção de arquivo</figcaption>
</figure>

<div class="break"></div>

Caso haja algum erro, será exibida uma mensagem de erro:

<figure>
<img width="749" src="./images/error_message.png">
<figcaption>Mensagem de erro</figcaption>
</figure>

<div class="break"></div>
## Especificação

### Caracteres

Todas as letras serão interpretadas como letras maiúsculas. As vogais incluem as versões com acentos, o `Ç` será interpretado como um `C`. Os caracteres não listados serão ignorados.

| Caractere | Significado | Caractere | Significado |
|:---------:|:-----------:|:---------:|:-----------:|
| A | Lá | B | Si |
| C | Dó | D | Ré |
| E | Mi | F | Fá |
| G | Sol | # | Próxima nota será sustenido |
| ! | Aumenta um pouco o ataque | ; | Diminui um pouco o ataque |
| $ | Aumenta bastante o ataque | % | Diminui bastante o ataque |
| " | Aumenta um pouco a duração | ' | Diminui um pouco a duração |
| O | Aumenta uma oitava | I | Diminui uma oitava |
| 0-9 | Define a nova oitava | ? ou . | Volta para a oitava padrão (5<sup>_a_</sup>) |
| < | Diminui BPM em 10 | { | Diminui BPM em 100 |
| > | Aumenta BPM em 10 | } | Aumenta BPM em 100 |
| Espaço | Silêncio | Nova linha | Pula para o próximo instrumento |


## Diagrama de classes

![Diagrama de classes](./images/diagram.png)
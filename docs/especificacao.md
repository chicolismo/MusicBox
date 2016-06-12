# Documentação

## Lista de requisitos

* O programa de ser capaz de receber o nome de um arquivo de texto.

* Tendo um nome de arquivo, o programa deverá ser capaz de lê-lo para
reproduzir a música.

* Além disso, deve ser possível informar o BPM padrão da música como um
argumento opcional na linha de comando.

* O programa deve ser capaz de traduzir os caracteres lidos para as strings
necessárias para reproduzir a música, conforme a API do JFugue.

## Modo de uso

O programa funciona pela linha de comando, da seguinte maneira:

```
    java -jar programa.jar <arquivo> [<bpm_padrão>]
```

Onde `<arquivo>` é o nome de um arquivo de texto contendo os caracteres que
serão reproduzidos como música (é um argumento obrigatório), e `<bpm_padrão>`
é um argumento opcional (um inteiro) que será usado como o valor de *bpm*
inicial da música. O *bpm* padrão é 120.

## Especificação

### Caracteres

Todas as letras serão interpretadas como letras maiúsculas. As vogais incluem as versões com acentos, o `Ç` será interpretado como um `C`.

| Caractere | Significado |
|:---------:|:-----------:|
| A | Lá |
| B | Si |
| C | Dó |
| D | Ré |
| E | Mi |
| F | Fá |
| G | Sol |
| # | Próxima nota será sustenido |
| ! | Aumenta um pouco o ataque |
| ; | Diminui um pouco o ataque |
| $ | Aumenta bastante o ataque |
| % | Diminui bastante o ataque |
| " | Aumenta um pouco a duração |
| ' | Diminui um pouco a duração |
| O | Aumenta uma oitava |
| I | Diminui uma oitava |
| 0-9 | Define a nova oitava |
| ? ou . | Volta para a oitava padrão (5<sup>_a_</sup>) |
| < | Diminui BPM em 10 |
| > | Aumenta BPM em 10 |
| { | Diminui BPM em 100 |
| } | Aumenta BPM em 100 |
| Espaço | Silêncio |
| Nova linha | Pula para o próximo instrumento |

#### Demais caracteres

Todos os demais caracteres serão ignorados.

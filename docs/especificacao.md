# Especificação

## Modo de uso

O programa funciona pela linha de comando, da seguinte maneira:

```
    java -jar programa.jar <arquivo> [<bpm_padrão>]
```

Onde `<arquivo>` é o nome de um arquivo de texto contendo os caracteres que serão reproduzidos como música (é um argumento obrigatório), e `<bpm_padrão>` é um argumento opcional (um inteiro) que será usado como o valor de *bpm* inicial da música.

## Significado de cada caractere

Todas as letras serão interpretadas como letras maiúsculas.

### Notas

Tanto `A` quanto `E` incluem as versões com acentos.

| Caractere | Significado |
|:---------:|:-----------:|
| A | Lá |
| B | Si |
| C | Dó |
| D | Ré |
| E | Mi |
| F | Fá |
| G | Sol |

### Relacionados às notas

| Caractere | Significado |
|:---------:|:-----------:|
| # | Próxima nota será sustenido |
| ! | Aumenta a força da próxima nota |
| ; | Diminui a força da próxima nota |

### Oitavas

| Caractere | Significado |
|:---------:|:-----------:|
| O | Aumenta uma oitava |
| I | Diminui uma oitava |
| 0-9 | Define a nova oitava |
| ? ou . | Volta para a oitava padrão (5<sup>_a_</sup>) |

### BPM

| Caractere | Significado |
|:---------:|:-----------:|
| < | Diminui BPM em 10 |
| > | Aumenta BPM em 10 |
| { | Diminui BPM em 100 |
| } | Aumenta BPM em 100 |

### Outras

| Caractere | Significado |
|:---------:|:-----------:|
| Espaço | Silêncio |
| Nova linha | Pula para o próximo instrumento |
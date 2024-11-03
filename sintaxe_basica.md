# Guia Completo de Variáveis, Tipos de Dados, Operadores e Controle de Fluxo em Kotlin

![Logo do Kotlin](https://upload.wikimedia.org/wikipedia/commons/7/74/Kotlin_Icon.png)

## Introdução

Kotlin é uma linguagem de programação moderna e concisa que roda na Java Virtual Machine (JVM) e é totalmente interoperável com Java. Desenvolvida pela JetBrains, Kotlin tem ganhado popularidade rapidamente, especialmente no desenvolvimento de aplicativos Android. Este guia aborda conceitos fundamentais de Kotlin, incluindo variáveis, tipos de dados, operadores e controle de fluxo, fornecendo uma base sólida para iniciantes e servindo como material de referência para programadores experientes.

---

## Sumário

1. [Variáveis](#1-variáveis)
   - [Declaração](#declaração)
   - [Tipos (`val` e `var`)](#tipos-val-e-var)
   - [Escopo](#escopo)
   - [Imutabilidade](#imutabilidade)
2. [Tipos de Dados](#2-tipos-de-dados)
   - [Números Inteiros](#números-inteiros)
     - [`Byte`](#byte)
     - [`Short`](#short)
     - [`Int`](#int)
     - [`Long`](#long)
   - [Números de Ponto Flutuante](#números-de-ponto-flutuante)
     - [`Float`](#float)
     - [`Double`](#double)
   - [Caracteres (`Char`)](#caracteres-char)
   - [Strings (`String`)](#strings-string)
   - [Booleanos (`Boolean`)](#booleanos-boolean)
   - [Nulos (`null`)](#nulos-null)
3. [Operadores](#3-operadores)
   - [Operadores Aritméticos](#operadores-aritméticos)
   - [Operadores de Atribuição](#operadores-de-atribuição)
   - [Operadores de Comparação](#operadores-de-comparação)
   - [Operadores Lógicos](#operadores-lógicos)
   - [Operadores Incrementais e Decrementais](#operadores-incrementais-e-decrementais)
4. [Controle de Fluxo](#4-controle-de-fluxo)
   - [Estruturas Condicionais](#estruturas-condicionais)
     - [`if` e `else`](#if-e-else)
     - [`when`](#when)
   - [Loops](#loops)
     - [`for`](#for)
     - [`while`](#while)
     - [`do-while`](#do-while)
   - [Intervalos (Ranges)](#intervalos-ranges)
5. [Conclusão](#5-conclusão)
6. [Referências](#6-referências)

---

## 1. Variáveis

### Declaração

Em Kotlin, variáveis são declaradas usando as palavras-chave `var` ou `val`, seguidas pelo nome da variável e, opcionalmente, o tipo e o valor inicial.

**Sintaxe Geral:**

```kotlin
var nomeVariavel: Tipo = valorInicial
val nomeVariavel: Tipo = valorInicial
```

**Exemplos:**

```kotlin
var idade: Int = 25
val nome: String = "Maria"
```

### Tipos (`val` e `var`)

- **`var`**: Declara uma variável mutável cujo valor pode ser alterado posteriormente.
- **`val`**: Declara uma variável somente leitura (imutável). Uma vez atribuído, o valor não pode ser modificado.

**Exemplo:**

```kotlin
var contador = 1
contador = 2  // Válido

val pi = 3.1415
// pi = 3.14  // Erro: Não é possível reatribuir um val
```

### Escopo

O escopo de uma variável é a região do código onde ela é válida e acessível. Em Kotlin, o escopo é definido por blocos delimitados por chaves `{}`.

**Exemplo:**

```kotlin
fun exemploEscopo() {
    val x = 10  // Variável x está acessível dentro desta função
    if (x > 5) {
        val y = 20  // Variável y está acessível apenas dentro deste bloco if
        println("x = $x, y = $y")
    }
    // println(y)  // Erro: y não está acessível aqui
}
```

### Imutabilidade

Usar `val` para declarar variáveis imutáveis promove um código mais seguro e facilita o raciocínio, especialmente em ambientes concorrentes. Imutabilidade é um conceito importante na programação funcional, e Kotlin incentiva seu uso.

**Exemplo:**

```kotlin
val listaImutavel = listOf(1, 2, 3)
// listaImutavel.add(4)  // Erro: Não é possível adicionar elementos a uma lista imutável

var listaMutavel = mutableListOf(1, 2, 3)
listaMutavel.add(4)  // Válido
```

---

## 2. Tipos de Dados

Kotlin é uma linguagem de tipagem estática, o que significa que o tipo de cada expressão é conhecido em tempo de compilação. A inferência de tipos permite que o compilador determine o tipo da variável automaticamente, mas você pode especificá-lo explicitamente se desejar.

### Números Inteiros

#### `Byte`

- **Tamanho:** 8 bits
- **Intervalo de valores:** -128 a 127

**Exemplo:**

```kotlin
val numeroByte: Byte = 100
```

#### `Short`

- **Tamanho:** 16 bits
- **Intervalo de valores:** -32.768 a 32.767

**Exemplo:**

```kotlin
val numeroShort: Short = 30000
```

#### `Int`

- **Tamanho:** 32 bits
- **Intervalo de valores:** -2.147.483.648 a 2.147.483.647

**Exemplo:**

```kotlin
val numeroInt: Int = 2_000_000
```

#### `Long`

- **Tamanho:** 64 bits
- **Intervalo de valores:** -9.223.372.036.854.775.808 a 9.223.372.036.854.775.807

**Exemplo:**

```kotlin
val numeroLong: Long = 9_000_000_000L  // Sufixo 'L' indica Long
```

### Números de Ponto Flutuante

#### `Float`

- **Tamanho:** 32 bits
- **Precisão:** Aproximadamente 6-7 dígitos decimais
- **Sufixo:** `f` ou `F` (necessário)

**Exemplo:**

```kotlin
val numeroFloat: Float = 3.14f
```

#### `Double`

- **Tamanho:** 64 bits
- **Precisão:** Aproximadamente 15-16 dígitos decimais
- **Sufixo:** Opcional (`d` ou `D`)

**Exemplo:**

```kotlin
val numeroDouble: Double = 3.141592653589793
```

### Caracteres (`Char`)

Representa um único caractere Unicode. Caracteres são declarados entre aspas simples `'`.

**Exemplo:**

```kotlin
val letra: Char = 'A'
val digito: Char = '1'
```

### Strings (`String`)

Representa uma sequência de caracteres. Strings são declaradas entre aspas duplas `"`.

**Exemplo:**

```kotlin
val saudacao: String = "Olá, Kotlin!"
```

#### Interpolação de Strings

Permite inserir o valor de variáveis ou expressões dentro de uma string usando `$`.

**Exemplo:**

```kotlin
val nome = "João"
val mensagem = "Bem-vindo, $nome!"
println(mensagem)  // Saída: Bem-vindo, João!
```

#### Strings Multilinhas

Utiliza aspas triplas `"""` para declarar strings que ocupam várias linhas.

**Exemplo:**

```kotlin
val textoLongo = """
    Kotlin é uma linguagem moderna.
    Suporta programação funcional e orientada a objetos.
""".trimIndent()
```

### Booleanos (`Boolean`)

Representa valores lógicos `true` ou `false`.

**Exemplo:**

```kotlin
val ativo: Boolean = true
val aprovado = false
```

### Nulos (`null`)

Por padrão, tipos em Kotlin não podem ser nulos. Para permitir que uma variável aceite `null`, você deve declarar o tipo com um `?` (tipo nulificável).

**Exemplo:**

```kotlin
val nome: String? = null  // Pode ser nulo
```

#### Operador de Chamada Segura `?.`

Permite acessar propriedades ou métodos de uma variável que pode ser nula sem lançar uma exceção `NullPointerException`.

**Exemplo:**

```kotlin
val tamanho = nome?.length  // Retorna null se 'nome' for null
```

#### Operador Elvis `?:`

Fornece um valor padrão caso a expressão à esquerda seja `null`.

**Exemplo:**

```kotlin
val tamanho = nome?.length ?: 0  // Se 'nome' for null, 'tamanho' será 0
```

---

## 3. Operadores

### Operadores Aritméticos

Usados para realizar operações matemáticas básicas.

| Operador | Descrição         | Exemplo        | Resultado |
|----------|-------------------|----------------|-----------|
| `+`      | Adição            | `5 + 3`        | `8`       |
| `-`      | Subtração         | `5 - 3`        | `2`       |
| `*`      | Multiplicação     | `5 * 3`        | `15`      |
| `/`      | Divisão           | `5 / 2`        | `2`       |
| `%`      | Módulo (resto)    | `5 % 2`        | `1`       |

**Nota:** Em divisão entre inteiros, o resultado é um inteiro (divisão inteira).

**Exemplo:**

```kotlin
val soma = 10 + 5  // 15
val diferenca = 10 - 5  // 5
val produto = 10 * 5  // 50
val quociente = 10 / 3  // 3
val resto = 10 % 3  // 1
```

### Operadores de Atribuição

Permitem atribuir um valor a uma variável.

| Operador | Descrição                        | Exemplo       |
|----------|----------------------------------|---------------|
| `=`      | Atribuição simples               | `a = b`       |
| `+=`     | Adição e atribuição              | `a += b`      |
| `-=`     | Subtração e atribuição           | `a -= b`      |
| `*=`     | Multiplicação e atribuição       | `a *= b`      |
| `/=`     | Divisão e atribuição             | `a /= b`      |
| `%=`     | Módulo e atribuição              | `a %= b`      |

**Exemplo:**

```kotlin
var num = 10
num += 5  // num = num + 5 -> num = 15
```

### Operadores de Comparação

Retornam um valor booleano (`true` ou `false`).

| Operador | Descrição            | Exemplo    | Resultado |
|----------|----------------------|------------|-----------|
| `==`     | Igual a              | `a == b`   | `true` se `a` é igual a `b` |
| `!=`     | Diferente de         | `a != b`   | `true` se `a` não é igual a `b` |
| `>`      | Maior que            | `a > b`    | `true` se `a` é maior que `b` |
| `<`      | Menor que            | `a < b`    | `true` se `a` é menor que `b` |
| `>=`     | Maior ou igual a     | `a >= b`   | `true` se `a` é maior ou igual a `b` |
| `<=`     | Menor ou igual a     | `a <= b`   | `true` se `a` é menor ou igual a `b` |

**Exemplo:**

```kotlin
val a = 5
val b = 10
println(a == b)  // false
println(a < b)   // true
```

### Operadores Lógicos

Usados para combinar expressões booleanas.

| Operador | Descrição        | Exemplo        | Resultado |
|----------|------------------|----------------|-----------|
| `&&`     | E lógico (AND)   | `a && b`       | `true` se ambos forem `true` |
| `\|\|`     | Ou lógico (OR)   | `a \|\| b`       | `true` se pelo menos um for `true` |
| `!`      | Não lógico (NOT) | `!a`           | Inverte o valor de `a` |

**Exemplo:**

```kotlin
val x = true
val y = false
println(x && y)  // false
println(x || y)  // true
println(!x)      // false
```

### Operadores Incrementais e Decrementais

Usados para incrementar ou decrementar o valor de uma variável em 1.

| Operador | Descrição           | Exemplo     |
|----------|---------------------|-------------|
| `++`     | Incremento          | `a++` ou `++a` |
| `--`     | Decremento          | `a--` ou `--a` |

**Pré-incremento e Pós-incremento:**

- **Pré-incremento (`++a`):** Incrementa antes de usar o valor.
- **Pós-incremento (`a++`):** Usa o valor e depois incrementa.

**Exemplo:**

```kotlin
var num = 10
println(++num)  // 11 (incrementa e depois usa)
println(num++)  // 11 (usa e depois incrementa)
println(num)    // 12
```

---

## 4. Controle de Fluxo

### Estruturas Condicionais

#### `if` e `else`

Permitem executar blocos de código com base em condições.

**Sintaxe:**

```kotlin
if (condição) {
    // Bloco executado se condição for verdadeira
} else if (outraCondição) {
    // Bloco executado se outraCondição for verdadeira
} else {
    // Bloco executado se nenhuma condição anterior for verdadeira
}
```

**Exemplo:**

```kotlin
val nota = 85

if (nota >= 90) {
    println("Aprovado com excelência")
} else if (nota >= 70) {
    println("Aprovado")
} else {
    println("Reprovado")
}
```

#### Expressão `if`

Em Kotlin, `if` pode ser usado como expressão, retornando um valor.

**Exemplo:**

```kotlin
val max = if (a > b) a else b
```

#### `when`

Uma alternativa ao `switch` em outras linguagens, mais poderosa e flexível.

**Sintaxe:**

```kotlin
when (expressão) {
    valor1 -> // Bloco executado se expressão == valor1
    valor2 -> // Bloco executado se expressão == valor2
    in intervalo -> // Bloco executado se expressão está no intervalo
    else -> // Bloco executado se nenhuma condição anterior for satisfeita
}
```

**Exemplo:**

```kotlin
val dia = 3
val nomeDia = when (dia) {
    1 -> "Domingo"
    2 -> "Segunda-feira"
    3 -> "Terça-feira"
    4 -> "Quarta-feira"
    5 -> "Quinta-feira"
    6 -> "Sexta-feira"
    7 -> "Sábado"
    else -> "Dia inválido"
}
println(nomeDia)  // Terça-feira
```

**Usando `when` sem argumento:**

```kotlin
when {
    a > b -> println("a é maior que b")
    a == b -> println("a é igual a b")
    else -> println("a é menor que b")
}
```

### Loops

#### `for`

Usado para iterar sobre coleções, intervalos ou sequências.

**Iterando sobre um intervalo:**

```kotlin
for (i in 1..5) {
    println(i)  // Imprime de 1 a 5
}
```

**Iterando sobre uma coleção:**

```kotlin
val itens = listOf("Maçã", "Banana", "Laranja")
for (item in itens) {
    println(item)
}
```

**Com índices:**

```kotlin
for ((indice, valor) in itens.withIndex()) {
    println("Item $indice: $valor")
}
```

**Passo personalizado:**

```kotlin
for (i in 0..10 step 2) {
    println(i)  // Imprime 0, 2, 4, 6, 8, 10
}
```

**Contagem regressiva:**

```kotlin
for (i in 10 downTo 0 step 2) {
    println(i)  // Imprime 10, 8, 6, 4, 2, 0
}
```

#### `while`

Executa um bloco de código enquanto a condição for verdadeira.

**Sintaxe:**

```kotlin
while (condição) {
    // Bloco de código
}
```

**Exemplo:**

```kotlin
var contador = 5
while (contador > 0) {
    println("Contagem: $contador")
    contador--
}
```

#### `do-while`

Semelhante ao `while`, mas garante que o bloco seja executado pelo menos uma vez.

**Sintaxe:**

```kotlin
do {
    // Bloco de código
} while (condição)
```

**Exemplo:**

```kotlin
var contador = 0
do {
    println("Executado pelo menos uma vez")
    contador++
} while (contador < 0)
```

### Intervalos (Ranges)

Intervalos facilitam a criação de sequências de valores.

- **Crescente:** `start..end`
- **Decrescente:** `start downTo end`
- **Exclusivo:** `start until end` (não inclui o valor final)
- **Passo personalizado:** `step`

**Exemplos:**

```kotlin
for (i in 1..5) { /* ... */ }  // 1, 2, 3, 4, 5
for (i in 1 until 5) { /* ... */ }  // 1, 2, 3, 4
for (i in 5 downTo 1) { /* ... */ }  // 5, 4, 3, 2, 1
for (i in 1..10 step 2) { /* ... */ }  // 1, 3, 5, 7, 9
```

**Intervalos de caracteres:**

```kotlin
for (letra in 'a'..'e') {
    println(letra)  // a, b, c, d, e
}
```

---

## 5. Conclusão

Este guia cobriu os conceitos fundamentais de Kotlin relacionados a variáveis, tipos de dados, operadores e controle de fluxo. Com este conhecimento, você está preparado para escrever programas básicos em Kotlin e aprofundar-se em tópicos mais avançados. Pratique escrevendo seu próprio código e experimentando diferentes construções da linguagem para solidificar sua compreensão.

---

## 6. Referências

- [Documentação Oficial do Kotlin](https://kotlinlang.org/docs/home.html)
- [Kotlin Playground](https://play.kotlinlang.org/) - Ambiente online para testar código Kotlin
- [Kotlin Koans](https://play.kotlinlang.org/koans/overview) - Tutoriais interativos para aprender Kotlin

---
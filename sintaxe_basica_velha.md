![Logo do Kotlin](https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/Kotlin_logo.svg/2560px-Kotlin_logo.svg.png)
# Sintaxe básica
Neste guia, vamos apresentar a sintaxe básica da linguagem de programação Kotlin. Os tópicos a serem contemplados nele são os seguintes:
- variáveis - `val` (imutável) e `var` (mutável);
- tipos de dados - `Int`, `Double`, `Boolean`, `String`;
- operadores - operadores aritméticos (`+`, `-`, `*`, `/`, `%`) e operadores de comparação (`==`, `!=`, `<`, `>`, `<=`, `>=`);
- controle de fluxo - `if-else`, `when`, `for`, `while`.

## Considerações iniciais
É importante destacar que este guia pode evoluir conforme as atualizações na linguagem de programação Kotlin. Além disso,
está aberto a sugestões de terceiros, possibilitando alcançar um alto nível de qualidade e aprimorar a compreensão de Kotlin para todos os leitores.

As referências utilizadas para construir este guia estão disponíveis ao final do documento.

Este documento foi desenvolvido pelos seguintes alunos de TSI do IFPB, sob subervisão do professor Gustavo Wagner (2024.1):
1. Ian Ribeiro
2. Lucas Palmeira
3. Renato Bezerra
4. Samuel Merson
5. Yago César 

## 1. Tipos de dados
A linguagem de programação Kotlin possui tipos de dados que contemplam números inteiros, números de ponto flutuante, caracteres, sequências de caracteres, booleanos e nulo. A seguir, há várias seções mostrando como a linguagem Kotlin lida com cada um desses tipos.

### 1.1. Números inteiros
Para lidar com números inteiros em Kotlin, é possível utilizar os seguintes tipos:

- `Byte` - representa números inteiros de 8 bits.
- `Short` - representa números inteiros de 16 bits.
- `Int` - representa números inteiros de 32 bits.
- `Long` - representa números inteiros de 64 bits.

Exemplo de declaração, inicialização e de conversão:

```kotlin
val numeroByte: Byte = 10
val numeroInt: Int = numeroByte.toInt()
```

O Kotlin consegue inferir o tipo de uma variável (*type inference*). Caso uma variável numérica receba um valor inteiro (sem casas decimais), o compilador Kotlin poderá inferir o tipo dela como `Int` ou `Long` a depender do quão grande é o valor. Além disso, o Kotlin permite que você use o caractere `_` para separar os dígitos em números grandes, tornando-os mais legíveis. Isso é puramente para conveniência e não afeta o valor do número. Veja o exemplo a seguir para entender melhor.

```kotlin
val numeroInteiro = 10  // o tipo será Int
val numeroLongo = 1_900_000_000_000 // o tipo será Long
```

Quando se deseja explicitar o tipo de uma variável no código, deve-se adicionar um `:` após o nome da variável e, em seguida, especificar o tipo. Além disso, alguns tipos de dados permitem formas alternativas de declaração. Por exemplo, um número Long pode ser declarado acrescentando-se um `L` ao final do número, como mostra o exemplo abaixo.

```kotlin
val numeroInteiro: Int = 10 // Tipo inteiro
val numeroLongo = 100L // Será do tipo Long, pois o L equivale a acrescentar :Long
```

### 1.2. Números de ponto flutuante
Em Kotlin, é possível usar os seguintes tipos para lidar com números de ponto flutuante:

- `Float` - representa números de ponto flutuante de precisão simples (32 bits).
- `Double` - representa números de ponto flutuante de precisão dupla (64 bits).

A seguir, há um exemplo de declaração, inicialização e de conversão de um número `Float` para `Double`.

```kotlin
val numeroFloat: Float = 3.14f // o sufixo f indica que o número deve ser tratado como float de modo explícito
val numeroDouble: Double = numeroFloat.toDouble()
```

### 1.3. Caractere
O tipo `Char` representa um único caractere Unicode. Assim como na linguagem Java, um caractere é cercado por aspas simples, ou seja, `'`. Portanto, é muito importante diferenciar o uso de `'` (usado para caracteres) do uso de `"` (usado para sequências de caracteres).

Exemplo de declaração e inicialização:

```kotlin
val caractere: Char = 'A'
```

### 1.4. Booleano
Assim como em outras linguagens, o tipo `Boolean` representa valores booleanos `true` (verdadeiro) ou `false` (falso).

Exemplo de declaração e inicialização:

```kotlin
val estahAtivo: Boolean = true
```

### 1.5. Sequências de caracteres (strings)
Sequências de caracteres (`String`) são criadas usando aspas duplas `"`. Não use aspas simples para criar strings, já que estas são usadas para criar caracteres.

Exemplo de declaração e inicialização:

```kotlin
val ola: String = "Hello"
```

#### 1.5.1. Conversão de caractere para string
Para converter um caractere ou um número em uma string, você pode usar o método `toString()`.

```kotlin
val numeroEmString = 42.toString()
val caractereEmString = 'A'.toString()
```

É possível converter outros tipos em string:

```kotlin
val booleanParaString = true.toString()
```

### 1.6. Nulo (null)
O nulo (`null`) é um valor que uma variável pode receber. Para que uma variável possa receber `null`, ela deve ter um símbolo de interrogação após o tipo da variável (`T?`, onde T é um tipo).

Exemplo de declaração e inicialização:

```kotlin
val inteiroOuNulo: Int? = null
```

Em Kotlin, as variáveis podem ser nulas (`null`) se explicitamente declaradas. Como já mencionado anteriormente, indicamos que uma variável pode receber `null` se, ao lado do seu tipo, houver um símbolo de interrogação (`?`), ou seja, `T?` (T é um tipo qualquer).

```kotlin
var stringOuNulo: String? = "Valor"  // Agora, a variável stringOuNulo possui um valor string, mas pode ser nulo em algum momento da execução, já que variáveis criadas usando 'var' são mutáveis
println(stringOuNulo)

stringOuNulo = null
println(stringOuNulo)
```

```kotlin
val numeroOuNulo: Int? = 42
// Depois teste comentando a linha acima e descomentando a linha abaixo
// val numeroOuNulo: Int? = null
val string = numeroOuNulo?.toString() ?: "Valor nulo"  // caso o numeroOuNulo seja null, atribua "Valor nulo" a string.

println(string)
```

Para acessar propriedades ou chamar métodos em variáveis que podem ser nulas de forma segura (*safe calls*), o operador de segurança de chamada (`?.`) pode ser utilizado, evitando uma exceção `NullPointerException` (tentou-se chamar um método em cima de `null`, por exemplo) tão comum na linguagem Java.

```kotlin
val meuNome: String? = "João"
val tamanhoDoMeuNome = meuNome?.length  // só chamo a propriedade 'length' caso 'meuNome' não seja null

println("Meu nome é $meuNome e ele possui $tamanhoDoMeuNome letras.")
```

Além disso, o operador Elvis (`?:`) pode ser usado para fornecer um valor padrão caso a variável seja nula.

```kotlin
val palavra: String? = null
val tamanhoDaPalavra = palavra?.length ?: 0
println(tamanhoDaPalavra)
```

## 2. Tipos de variáveis
Em Kotlin, os dois principais tipos usados para criar uma variável são `val` para valores imutáveis e `var` para valores mutáveis. Veja o exemplo a seguir para entender melhor.

```kotlin
val X = "Sou imutável"  // na prática, o nome dado é "constante"
var y = "Sou mutável"

println(X)
println(y)

y = "Novo valor de y"
println(y)
// descomente as duas linhas abaixo e veja um problema aparecer
//X = "Novo valor de X" // não compila pois X é uma "variável" que não pode ter seu valor modificado
//println(X)
```

```
Sou imutável
Sou mutável
Novo valor de y
```

Além disso, é válido salientar que, assim como em outras linguagens (Java, por exemplo), uma variável não precisa ser inicializada (receber um valor) imediatamente. Entretanto, quando tal variável precisar ser usada, ela deve ser inicializada.

```kotlin
var number: Int
number = 42
println("O número é $number.")
```

Se o resultado da expressão à esquerda do `?:` for `null`, a saída será o valor padrão definido na direita do operador. Caso não seja nula, a saída será o próprio resultado (à esquerda do operador `?:`).

## 3. Interpolação de strings com variáveis
A interpolação de strings em Kotlin permite a inserção de valores de variáveis ou de resultados de expressões dentro de strings. Para isso, utiliza-se a sintaxe `$expressao` para resgatar o valor de uma variável e colocá-lo em uma string ou `${expressao}` para colocar o resultado da expressão em uma string.

```kotlin
val nome = "Gustavo"
val idade = 25
println("Meu nome é $nome e tenho $idade anos.")
```

```
Meu nome é Gustavo e tenho 25 anos.
```

Exemplo que utiliza uma expressão:

```kotlin
val a = 5
val b = 4

println("$a - $b = ${a - b}")
```

```
5 - 4 = 1
```

## 4. Operadores
### 4.1. Operadores aritméticos
Os operadores aritméticos são essenciais para realizar cálculos e manipular dados numéricos em programas. Eles retornam um valor numérico correspondente ao resultado da operação matemática realizada. A seguir, há explicações e exemplos de uso dos operadores aritméticos na linguagem Kotlin.

`+` (adição) - adiciona dois valores e obtém um resultado.

```kotlin
import java.lang.Integer.sum

println(5 + 4) // Somando dois inteiros. Resultado 9
println(9.11 + 4.10) // Somando Double (64 bits). Resultado: ~ 13.21
println(5 + 2.718281828434234f) // Somando inteiro com float (32 bits). Resultado: 7.7182817
// Não é possível somar um Number com String na tentativa de concatenação
println("abc" + "akj") // Concatenação de String. Resultado: abcakj
println(7L + 2L) // Somando Long (64 bits). Resultado: 9
println('a' + 1)  // Somando uma unidade ao caractere 'a' (andando uma posição para frente). Resultado: 'b'
println(sum(4, 5)) // Sem uso do operador, mas importando java.lang.Integer.sum e utilizando função própria. Resultado: 9
```

```
9
13.209999999999999
7.7182817
abcakj
9
b
9
```

`-` (subtração) - subtrai o segundo valor do primeiro e obtém um resultado.

```kotlin
// Operador - (subtração)
println(10 - 20) // Subtraindo inteiros. Resultado: -10
println(5 - 4.11) // Subtraindo inteiro com Double. Resultado: 0.89
println(4.23423423442f - 5L) // Subtraindo float com Long. Resultado: -0.76576567
println('z' - 'a')  // Subtraindo um código de um caractere de outro. Resultado: 25
println('z' - 1)  // Subtraindo uma unidade do caractere 'z' (andando 1 posição para trás). Resultado: 'y'
```

```
-10
0.8899999999999997
-0.76576567
25
y
```

Ao contrário do operador de adição (`+`), o operador de subtração não pode ser utilizado entre strings.

`*` (multiplicação) - multiplica dois valores e obtém o resultado.

```kotlin
println(5 * 5) // Multiplicando dois inteiros. Resultado: 25
// Em Kotlin, não é possível fazer multiplicação de String com Int ~ println("abc" * 5)
// Mas existe a função repeat, que tem um comportamento semelhante a uma multiplicação
val string = "Gustavo"
val multiplicada = string.repeat(3) // Resultado: "GustavoGustavoGustavo"
println(multiplicada)
```

```
25
GustavoGustavoGustavo
```

`/` (divisão) - divide o primeiro valor pelo segundo e obtém o resultado.

```kotlin
println(10 / 2) // Dividindo dois inteiros. Resultado: 5
println(10.0 / 3.0) // Dividindo Double. Resultado: 3.3333333333333335
println(15 / 4.0) // Dividindo inteiro com Double. Resultado: 3.75
```

```
5
3.3333333333333335
3.75
```

`%` (módulo) - retorna o resto da divisão do primeiro valor pelo segundo.

```kotlin
println(10 % 3) // Obtendo o resto da divisão de dois inteiros. Resultado: 1
println(15.5 % 4) // Obtendo o resto da divisão de Double com inteiro. Resultado: 3.5
println(20L % 7L) // Obtendo o resto da divisão de dois Longs. Resultado: 6
```

```
1
3.5
6
```

### 4.2. Operadores de comparação
Os operadores de comparação retornam um valor booleano, ou seja, verdadeiro (`true`) se a condição estabelecida for verdadeira ou falso (`false`) caso contrário. Esses operadores são fundamentais para criar lógica condicional, permitindo tomar decisões com base nas relações entre os valores. A seguir, há explicações e exemplos de uso dos operadores de comparação na linguagem Kotlin.

`==` (igual a) - verifica se dois valores são iguais.

```kotlin
val A = 5
val B = 5
println(A == B) // Verifica se A é igual a B. Resultado: true
```

```
true
```

`!=` (diferente de) - verifica se dois valores são diferentes.

```kotlin
val A = 10
val B = 7
println(A != B) // Verifica se A é diferente de B. Resultado: true
```

```
true
```

`<` (menor que) - verifica se o primeiro valor é menor que o segundo.

```kotlin
val A = 3
val B = 7
println(A < B) // Verifica se A é menor que B. Resultado: true
```

```
true
```

`>` (maior que) - verifica se o primeiro valor é maior que o segundo.

```kotlin
val A = 8
val B = 5
println(A > B) // Verifica se A é maior que B. Resultado: true
```

```
true
```

`<=` (menor ou igual a) - verifica se o primeiro valor é menor ou igual ao segundo.

```kotlin
val A = 5
val B = 5
println(A <= B) // Verifica se A é menor ou igual a B. Resultado: true
```

```
true
```

`>=` (maior ou igual a) - verifica se o primeiro valor é maior ou igual ao segundo.

```kotlin
val A = 8
val B = 5
println(A >= B) // Verifica se A é maior ou igual a B. Resultado: true
```

```
true
```

`!` (negação) - também chamado de *not* (em inglês), tal operador nega um valor booleano.

```kotlin
val estouComSono = true

println(!estouComSono)  // Resultado: false
```

```
false
```

`&&` (e) - também chamado de *and* (em inglês), uma operação usando `&&` só retorna `true` caso ambos os lados da expressão retornem `true` também.

```kotlin
var estouComFome = true
var estouAlegre = true

// estou com fome (true) E estou alegre (true)
println(estouComFome && estouAlegre)  // Resultado: true
estouComFome = false

// estou com fome (false) E estou alegre (true)
println(estouComFome && estouAlegre)  // Resultado: false
// NÃO estou com fome (true) E estou alegre (true)
println(!estouComFome && estouAlegre)  // !false é true. Logo true && true -> true
```

```
true
false
true
```

`||` (ou) - também chamado de *or* (em inglês), uma operação usando `||` retorna `true` quando pelo menos um dos lados da expressão retorna `true`.

```kotlin
var estaChovendo = true
var estaFazendoSol = false

// está chovendo (true) OU está fazendo sol (false)
println(estaChovendo || estaFazendoSol)  // Resultado: true
estaFazendoSol = true
// está chovendo (true) OU está fazendo sol (true)
println(estaChovendo || estaFazendoSol)  // Resultado: true
```

```
true
true
```

`++` (incremento) - incrementa uma unidade no valor onde está sendo chamado.

```kotlin
var a = 5
println(++a) // Incrementando o valor antes da impressão. Resultado: 6
var b = 10
println(b++) // Imprime o valor e depois incrementa. Resultado: 10 (mas o valor de 'b' passa a ser 11)
```

```
6
10
```

`--` (decremento) - decrementa uma unidade do valor onde está sendo chamado.

```kotlin
var a = 8
println(--a) // Decrementando o valor antes da impressão. Resultado: 7
var b = 12
println(b--) // Imprime o valor e depois decrementa. Resultado: 12 (mas o valor de 'b' passa a ser 11) 
```

```
7
12
```

### 4.3. Operadores de atribuição aumentada (augmented assignment)
Assim como em outras linguagens, Kotlin também permite usar operadores de atribuição aumentada. Tais operações consistem de uma atribuição seguida de outra operação. Por exemplo, `a += b` é o mesmo que `a = a + b`. Para entender melhor o uso desse tipo de operador, veja o exemplo seguinte.

```kotlin
var a = 10
a += 5  // a = 10 + 5
println(a)  // 15

a -= 1  // a = 15 - 1
println(a)  // 14

a *= 5  // a = 14 * 5
println(a)  // 70

a /= 5  // a = 70 / 5
println(a)  // 14

a %= 4  // a = 14 % 4
println(a)  // 2
```

```
15
14
70
14
2
```

## 5. Controle de fluxo

### 5.1. Expressões condicionais
A linguagem de programação Kotlin fornece `if`, `else` e `when` para realizar a verificação de expressões condicionais.
Conforme a documentação da linguagem, se você precisar escolher entre usar `if` ou `when`, recomenda-se usar o `when`, já que tal escolha leva a um código mais robusto e seguro.

#### 5.1.1. if-else
O uso da palavra-chave `if` na linguagem Kotlin segue o mesmo padrão observado na linguagem Java.

```kotlin
var x: Int
val teste = true

if (teste) {
   x = 1
} else {
   x = 2
}

println(x)
// 1
```

No Kotlin, há também uma espécie de substituto para o operador ternário visto em outras linguagens (`condicao ? casoVerdadeiro : casoFalso`). Esse “substituto” usa `if` e `else`. Para entender como ele funciona, observe o código abaixo.

```kotlin
val a = 1
val b = 2

println(if (a > b) "Valor de a: $a" else "Valor de b: $b") // Retorna um valor: 2
```

```
Valor de b: 2
```

Há ainda outras maneiras de se usar as expressões condicionais. No trecho de código abaixo, há alguns exemplos de usos do `if`, do `else` e do `else if`.

```kotlin
val a = 2
val b = 3

var maiorValor = a
if (a < b) maiorValor = b

// Utilizando if-else
if (a > b) {
   maiorValor = a
} else {
   maiorValor = b
}

// Utilizando uma expressão if (semelhante ao uso do operador ternário)
maiorValor = if (a > b) a else b

// Você também pode utilizar `else if` em expressões
val tamanhoDaFrase = "Olá, Kotlin!".length
val tipoDaFrase = if (tamanhoDaFrase <= 5) "pequena" else if (tamanhoDaFrase <= 10) "média" else "grande"

println("O maior valor é $maiorValor")
println("A frase é $tipoDaFrase")  // pequena, média ou grande
```

```
O maior valor é 3
A frase é grande
```

Podemos usar blocos `if-else` inclusive para atribuir algum valor a uma variável. No exemplo a seguir, a última expressão é a que representa o valor do bloco, ou seja, o valor a ser inserido na variável.

```kotlin
val a: Int = 15
val b: Int = 10

val maiorValor = if (a > b) {
   println("'a' é maior do que 'b'")
   a // última expressão do bloco if
} else {
   println("'b' é maior ou igual a 'a'")
   b // última expressão do bloco else
}

println("O maior valor é $maiorValor")
```

```
'a' é maior do que 'b'
O maior valor é 15
```

É importante salientar que, caso o `if` esteja sendo usado para retornar seu valor ou atribuí-lo a uma variável, o `else` é obrigatório. Portanto, no caso do código acima, o `else` **deve** estar presente.

#### 5.1.2. when

Além do `if-else`, a linguagem Kotlin também fornece a estrutura condicional `when` para o mapeamento de cadeias de condições. O `when` pode ser pensado como o substituto de um `switch-case` do Java com uma sintaxe mais simplificada.

```kotlin
val x = 2

when (x) {
   1 -> println("x é igual a 1")
   2 -> println("x é igual a 2")
   else -> {
       println("x não é igual a nem 1 e nem a 2")
   }
}
```

```
x é igual a 2
```

O `when` realiza uma operação de correspondência (`==`) sequencialmente em todas as suas condições até achar alguma que seja satisfeita.

As condições de um bloco `when` são tão flexíveis quanto as de um bloco if, podendo fazer match (bater com uma determinada condição) por intervalos, arrays, tipos de classe e até expressões.

```kotlin
val numeros = listOf(1, 2, 3)
val x = 1  // mude este valor para testar as diversas condições do when
when (x) {
    // Comparação simples
    4 -> print("$x == 4")
    
    // Comparação em lista
    in numeros -> println("Eu conheço esse número!")
    
    // Comparação em intervalos
    in 7..14 -> println("$x Está entre 7 e 14!")
    !in 15..20 -> println("$x Não está entre 15 e 20!")
    
    // Comparação por tipo
    is Int -> println("$x é inteiro")
    
    else -> {
       println("$x não se enquadra em nenhuma condição...")
    }
}
```

```
Eu conheço esse número!
```

É possível também combinar condições separando-as com vírgulas (isto é, um comportamento comum a mais de um caso).

```kotlin
val pizza = "Abacaxi"

when (pizza) {
    "Abacaxi", "Barbecue" -> println("Terrível")
    else -> println("Tudo bem")
}
```

```
Terrível
```

Um bloco `when` pode ser usado tanto em uma declaração (bloco de código explícito) quanto em uma expressão (atribuído a uma variável). Quando o `when` é usado como uma declaração, o valor de cada uma de suas condições é desprezado, porém, quando é usado como uma expressão, o valor da primeira condição correspondente será atribuído à variável.

```kotlin
val palavra = "Português"

val saudacao = when(palavra) {
   "Inglês" -> "How are you?"
   "Português" -> "Como vai?"
   "Alemão" -> "Wie geht es dir?"
   else -> "Não sei essa língua ainda :("
}
println(saudacao)
```

```
Como vai?
```

Há algumas condições em que uma condição `else` é obrigatória em um bloco `when`:
- quando o seu argumento é do tipo `Boolean`, `Enum` ou `Sealed` ou seus tipos anuláveis (`Tipo?`, isto é, pode ser nulo);
- suas condições não cobrem todos os valores possíveis para o seu argumento;

```kotlin
enum class HTTPStatus(val code: Int) {
   OK(200),
   NOT_FOUND(404),
   INTERNAL_SERVER_ERROR(500)
}

val code: Int = 404

when (code) {
   HTTPStatus.OK.code ->
       println("Resposta retornou com sucesso")
   HTTPStatus.NOT_FOUND.code ->
       println("Recurso não encontrado")
   HTTPStatus.INTERNAL_SERVER_ERROR.code ->
       println("Erro interno no servidor")
} // Não necessário pois cobre todos os valores possíveis

when (code) {
  HTTPStatus.OK.code ->
     println("Resposta retornou com sucesso")
  else ->
     println("Código desconhecido")
} // Necessário pois não cobre todos os valores possíveis
```

```
Recurso não encontrado
Código desconhecido
```

Uma utilização sensata de um bloco `when` seria para evitar criar uma longa cadeia de `else-if`s.

```kotlin
fun getDayOfWeek(dayNumber: Int): String {
    return when (dayNumber) {
       1 -> "Domingo"
       2 -> "Segunda-feira"
       3 -> "Terça-feira"
       4 -> "Quarta-feira"
       5 -> "Quinta-feira"
       6 -> "Sexta-feira"
       7 -> "Sábado"
       else -> "Número de dia inválido"
   }
}

val dayNumber = 3 // Supondo que tenhamos o número do dia
val dayOfWeek = getDayOfWeek(dayNumber)
println("O dia correspondente ao número $dayNumber é $dayOfWeek")
```

```
O dia correspondente ao número 3 é Terça-feira
```

### 5.2. Intervalos (ranges)
Antes de iniciar os estudos sobre loop, é importante saber como construir intervalos (ranges em inglês). A seguir, há alguns exemplos simples que utilizam um loop `for` e algumas maneiras de se criar diferentes intervalos. O jeito mais comum de criar um intervalo em Kotlin é usando o operador `..`. Por exemplo, `1..4` é equivalente a `1, 2, 3, 4`.

```kotlin
for (i in 1..4) {
   print("$i ")  // 1 2 3 4
}
```

```
1 2 3 4 
```

Para declarar um intervalo que não inclui o último valor (o valor do final), use o operador `..<`. Por exemplo, `1..<4` é equivalente a `1, 2, 3`.

```kotlin
for (i in 1..<4) {
   print("$i ")  // 1 2 3
}
```

```
1 2 3 
```

Para declarar um intervalo em ordem reversa, use `downTo`. Por exemplo, `4 downTo 1` é equivalente a `4, 3, 2, 1`.

```kotlin
for (i in 4 downTo 1) {
   print("$i ")  // 4 3 2 1
}
```

```
4 3 2 1 
```

Para declarar um intervalo que não possui um passo (step) de 1 (isto é, incrementar a cada 1), use `step` e o incremento desejado (de quanto em quanto você quer que seja o incremento). Por exemplo, `1..5 step 2` é equivalente a `1, 3, 5`.

```kotlin
for (i in 1..5 step 2) {
   print("$i ")  // 1 3 5
}
```

```
1 3 5 
```

Podemos ainda utilizar `until` para criar um intervalo que não inclui o último número. Por exemplo, o intervalo `1 until 5` equivale a `1, 2, 3, 4`.

```kotlin
for (i in 1 until 3) {
   println(i)
}
```

```
1
2
```

Também é possível aplicar a mesma lógica de intervalos vista acima para caracteres, ou seja, `Char`:
- `a..d` é equivalente a `'a', 'b', 'c', 'd'`;
- `'z' downTo 's' step 2` é equivalente a `'z', 'x', 'v', 't'`.

```kotlin
for (letra in 'a' .. 'd') {
    print("$letra ")
}
println()

for (letra in 'z' downTo 's' step 2) {
    print("$letra ")
}
```

```
a b c d 
z x v t 
```

### 5.3. Laços de repetição (loops)
As duas estruturas de loop mais comuns na programação são o `for` e o `while`. Use o `for` para iterar sobre um intervalo de valores e realizar uma ação. Use o `while` para continuar com uma ação até que uma determinada condição seja satisfeita.

#### 5.3.1. for
O `for` pode ser utilizado para iterar sobre intervalos como já foi visto nos exemplos acima. Na verdade, um loop `for` itera sobre qualquer coisa que fornece um iterador. Ademais, coleções também podem ser percorridas por loops:

```kotlin
val bolos = listOf("cenoura", "morango", "chocolate")

for (bolo in bolos) {
   println("Que delícia, um bolo de $bolo!")
}
```

```
Que delícia, um bolo de cenoura!
Que delícia, um bolo de morango!
Que delícia, um bolo de chocolate!
```

Podemos utilizar um `for` sem `{}` quando temos apenas um comando para ser executado.

```kotlin
val alimentosEIngredientes = listOf("sal", "trigo", "chocolate", "biscoito")
for (item in alimentosEIngredientes) print("$item ")  // sal trigo chocolate biscoito
```

```
sal trigo chocolate biscoito 
```

No próximo exemplo, a variável de iteração tem seu tipo explicitamente declarado.

```kotlin
val cidades = listOf("João Pessoa", "Campina Grande", "Guarabira", "Areia")

for (cidade: String in cidades) {
    println("Eu moro em $cidade")
}
```

```
Eu moro em João Pessoa
Eu moro em Campina Grande
Eu moro em Guarabira
Eu moro em Areia
```

Como mencionado anteriormente, um `for` itera sobre qualquer coisa que forneça um iterador. Isso significa:
- ter uma função membro (isto é, um método) ou uma função de extensão `iterator()` que retorne um `Iterator<>`;
- ter uma função membro ou uma função de extensão `next()`;
- ter uma função membro ou uma função de extensão `hasNext()` que retorna um `Boolean`.

Aqui, há mais alguns exemplos que usam intervalos.

```kotlin
for (i in 1..3) {
   println(i)
}

for (i in 6 downTo 0 step 2) {
   println(i)
}
```

```
1
2
3
6
4
2
0
```

Caso você queira iterar sobre um array ou uma lista por meio do índice, é possível fazer o seguinte:

```kotlin
val array = arrayOf("a", "b", "c")
for (i in array.indices) {
   println(array[i])
}
// a
// b
// c
```

```
a
b
c
```

É possível também iterar sobre os elementos de uma lista e obter o índice de tal elemento simultaneamente por meio da função de biblioteca `withIndex()`.

```kotlin
val array = arrayOf("a", "b", "c")
for ((indice, valor) in array.withIndex()) {
   println("O elemento no índice $indice é $valor")
}
```

```
O elemento no índice 0 é a
O elemento no índice 1 é b
O elemento no índice 2 é c
```

#### 5.3.2. while
Os loops `while` e `do-while` executam o código presente dentro dos seus blocos continuamente enquanto uma determinada condição estiver sendo satisfeita. A diferença entre eles é o momento em que a condição é verificada:
- O `while` verifica se a condição foi satisfeita e, caso ela tenha sido satisfeita, ele executa as instruções presentes em seu corpo, retornando posteriormente para a verificação da condição.
- O `do-while` executa as instruções presentes em seu corpo e, em seguida, verifica a condição. Caso tal condição seja satisfeita, o loop é repetido. Dessa maneira, as instruções presentes no corpo do `do-while` executam uma vez independentemente da condição.

```kotlin
val idade = 21

do {
   println("Entrou no DO-WHILE!")  // entra aqui uma vez
} while (idade < 21)

while (idade < 21) {
   println("Entrou no WHILE!")  // nunca entra aqui
}
```

```
Entrou no DO-WHILE!
```

Para finalizar, há um simples exemplo de uso de um loop `while` junto de um `iterator`.

```kotlin
val listaDeNomes = listOf("Ian", "Lucas", "Renato", "Samuel", "Yago")
val itListaDeNomes = listaDeNomes.iterator()

while (itListaDeNomes.hasNext()) {  // enquanto tiver um elemento
   println("${itListaDeNomes.next()} disse \"Obrigado pela sua atenção!\"")  // imprima o próximo elemento
}
```

```
Ian disse "Obrigado pela sua atenção!"
Lucas disse "Obrigado pela sua atenção!"
Renato disse "Obrigado pela sua atenção!"
Samuel disse "Obrigado pela sua atenção!"
Yago disse "Obrigado pela sua atenção!"
```


## 6. Prática sobre sintaxe básica
Iremos revisar e fixar melhor alguns assuntos de sintaxe básica de Kotlin durante essa prática.

O código se encontra em `src\main\kotlin\praticas\2-Sintaxe-Basica.kt`

Nela, temos o código de um sistema simples de uma livraria, onde podemos cadastrar, excluir, editar e buscar livros. Contudo, partes do código estão incorretas ou faltando. É aí que você entra ;). Use seus conhecimentos da sintaxe básica do Kotlin para consertar o sistema.

### 6.1. Etapas

1. **Implementar a função listar**: o sistema vem com 4 livros cadastrados, porém, a função para exibi-los está vazia! Implemente a função, cuja assinatura já está presente na linha 53, de modo que ela imprima no console cada livro presente no repositório. Utilize o laço de repetição `for` para percorrer cada índice do repositório de livros e imprimí-los no console. Lembre-se que a sintaxe para acessar um valor de uma lista em Kotlin é `nomeDaLista[índice]`.

   Após implementar o método, rode o programa e chame a opção 5 para testar seu código. Caso ele esteja funcionando, 4 livros devem aparecer no console.

   Um desses livros, o "Livro dos Livros", está imprimindo seu preço incorretamente, 1000000.0 ao invés de 999999.99. Isso ocorre em decorrência do atributo preço ser do tipo `Float`, que não tem precisão suficiente para guardar números com mais de 7 dígitos. Vamos consertar isso no próximo passo.

2. **De `Float` para `Double`**: para resolver nosso problema, vamos alterar o atributo preço da classe `Livro` de `Float` para `Double`. Também precisamos alterar a função `inputPreco()` para que ela retorne `Double` ao invés de `Float`. Por último, na função `main()`, remova os "f" após os números onde os livros estão sendo cadastrados.

   Feito isso, vamos agora cadastrar um livro. Execute o programa e escolha a primeira opção. Quando for pedido o preço, informe um valor negativo. Agora escolha a opção 5 para listar os livros. Perceba que o sistema permitiu o cadastro de um livro com preço negativo, o que nunca deveria acontecer. Vamos consertar isso!

3. **Validando o preço**: adicione à função `inputPreco()` uma validação para que o preço nunca possa ser negativo. Lembre-se de alterar a variável `preco` de `val` para `var`, para que o valor dela possa ser alterado novamente, caso o primeiro número informado seja inválido.

   Feito isso, vamos agora remover um livro. Escolha a segunda opção e digite "Livro dos Livros". Ao listar os livros novamente, podemos confirmar que ele foi deletado. Agora vamos tentar excluir um livro novamente, mas, dessa vez, quando a aplicação pedir para digitar o título, apenas pressione a tecla "enter". Perceba que a mensagem de exclusão foi a mesma, apesar de livro nenhum ter sido excluído.

4. **Validando remoção**: o método `remove`, utilizado em `excluirLivro()`, retorna `true`, caso a remoção tenha ocorrido, ou `false`, caso não. Sabendo disso, use a instrução condicional apropriada para imprimir uma mensagem personalizada caso nenhuma remoção tenha ocorrido.

5. **Implementando `editarLivro()`**: agora, utilizando tudo que você aprendeu, implemente a função `editarLivro()`, onde o usuário deve escolher se gostaria de alterar o `título` ou `preço` do livro, informar o novo valor, e o sistema salvará essa alteração no repositório. Faça as adaptações que julgar necessárias, inclusive na própria classe `Livro`. Por fim, descomente o item 4 do `when` na função `main()` adicionando a chamada à função `editarLivro()` ao mesmo.

   Parabéns, você concluiu a prática :)

## Referências
[Documentação oficial da linguagem Kotlin](https://kotlinlang.org/docs/home.html)
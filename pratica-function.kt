package `kotlin-pdm`

val materiasENotas = mutableMapOf<String, MutableList<Double>>()

/**
 * Adiciona uma disciplina no dicionário mutável,
 * Recebe um array de notas (opcional)
 * Retorna true se conseguiu, false se não.
 */

fun adicionarDisciplina(materia: String, notas: MutableList<Double> = mutableListOf()): Boolean {
    return materiasENotas.put(materia, notas) == null
}

/**
 * Adiciona uma nota à lista de notas de uma determinada matéria;
 * Retorna true se conseguiu adicionar, false se não conseguiu.
 */
fun adicionarNota(materia: String, nota: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]

    return if (notasDaMateria != null) {
        notasDaMateria.add(nota)
        true
    } else {
        false
    }
}

/**
 *Mostra na tela todas as notas presentes em uma matéria, no seguinte formato:
 * Materia: {nome da materia}
 * Nota 1: 5.4 \n
 * Nota 2: 7.8 \n
 * ...
 * Nota n: 10.0 \n
 * \n
 * Média:  {5.4 + 7.8 + ... + 10.0 / n} \n
 */
fun mostrarNotas(materia: String) {
    if (!materiasENotas.containsKey(materia)) {
        println("Materia $materia não encontrada")
    } else {
        val listaNotas = materiasENotas[materia]

        if (listaNotas != null) {
            println("Materia: $materia")
            var cont = 1
            var soma = 0.0
            for (nota in listaNotas) {
                println("Nota ${cont++}: $nota")
                soma += nota
            }
            val media = soma / listaNotas.size
            println("\nMédia: $media\n")
        } else {
            println("Não foi possível mostrar as notas da matéria $materia")
        }
    }
}

/*Retorna a média obtida a partir de uma lista de notas */
fun calcularMedia(notas: List<Double>): Double {
    return if (notas.isEmpty()) 0.0 else notas.sum() / notas.size
}

/**
 *Adiciona várias notas de uma só vez em uma matéria
 * Retorna true se conseguiu adicionar, false se não conseguiu.
 */
fun adicionarVariasNotas(materia: String, vararg notas: Double): Boolean {
    val listaNotas = materiasENotas[materia]

    return if (listaNotas != null) {
        listaNotas.addAll(notas.toList())
        true
    } else {
        false
    }
}

fun main() {
    // 1. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição posicional
    adicionarDisciplina("Matemática", mutableListOf(7.5, 8.0))

    // 2. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição nomeada
    adicionarDisciplina(materia = "História", notas = mutableListOf(6.0, 7.0))

    // 3. adicionarDisciplinas -> altere a função adicionarDisciplinas para que o parâmetro notas possua um valor padrão

    // 4. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, sem atribuir valores a notas
    adicionarDisciplina("Geografia")

    // 5. adicionarNota -> adicione 3 notas para as 3 disciplinas
    adicionarNota("Matemática", 9.0)
    adicionarNota("História", 8.5)
    adicionarNota("Geografia", 7.8)

    // 6. mostrarNotas -> Mostre as notas das 3 disciplinas
    mostrarNotas("Matemática")
    mostrarNotas("História")
    mostrarNotas("Geografia")

    // 7. adicionarDisciplina -> adicione mais 1 disciplina
    adicionarDisciplina("Química")

    // 8. adicionarVariasNotas -> implemente o método adicionarVariasNotas()

    // 9. adicionarVariasNotas -> adicione 3 notas para a disciplina que você acabou de criar
    adicionarVariasNotas("Química", 6.5, 7.3, 8.2)

    // 10. mostrarNotas -> mostre as notas da disciplina que você acabou de criar
    mostrarNotas("Química")

    // 11: calcularMedia -> Implemente a função calcularMedia()
    // FEITO

    // 12: calcularMedia -> calcule a média de 2 disciplinas
    println("Média Matemática: ${calcularMedia(materiasENotas["Matemática"]!!)}")
    println("Média História: ${calcularMedia(materiasENotas["História"]!!)}")

    // 13: mostrarNotas -> altere o mostrarNotas() para que ele mostre também a média das disciplinas

    // 14: mostrarNotas -> mostre as notas de 1 disciplina
    mostrarNotas("Matemática")
}
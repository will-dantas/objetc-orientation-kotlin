import entities.enuns.Nivel

class Usuario (
  val id: Int,
  val nome: String,
  val nivel: Nivel = Nivel.BASICO
)

data class ConteudoEducacional(
  var nome: String,
  val nivel: Nivel,
  val duracao: Int = 60,
)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

  private val inscritos = mutableListOf<Usuario>()

  fun matricular(usuario: Usuario) {
    for (conteudo in conteudos) {
      if (usuario.nivel == conteudo.nivel) {
        val novoUsuario = inscritos.add(usuario)

        novoUsuario.run {
          println("O usuario ${usuario.nome}, foi matriculado na formacao em $nome no nivel ${usuario.nivel}")
        }
      }
    }
  }
}

fun main(args: Array<String>) {
  val conteudos = listOf(
    ConteudoEducacional("Overview Kotlin", Nivel.BASICO, 30),
    ConteudoEducacional("Classes em Kotlin", Nivel.INTERMEDIARIO, 30),
    ConteudoEducacional("Collections em Kotlin", Nivel.DIFICIL,),
  )

  val usuario1 = Usuario(1234, "William Dantas", Nivel.INTERMEDIARIO)
  val usuario2 = Usuario(1234, "Marcos")
  val usuario3 = Usuario(1234, "Bruna", Nivel.DIFICIL)

  Formacao("Bootcamp Kotlin", conteudos).matricular(usuario1)
  Formacao("Bootcamp Kotlin", conteudos).matricular(usuario2)
  Formacao("Bootcamp Kotlin", conteudos).matricular(usuario3)
}
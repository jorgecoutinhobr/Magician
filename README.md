# Estrutura do Projeto

## Models
Localizadas em `src/main/java/com/demo/Models/`.

- [`Aluno`](src/main/java/com/demo/Models/Aluno.java)
- [`GerenciadorDeUsuario`](src/main/java/com/demo/Models/GerenciadorDeUsuario.java)
- [`Busca`](src/main/java/com/demo/Models/Busca.java) 
- [`GerenciadorDeView`](src/main/java/com/demo/Models/GerenciadorDeView.java)
- [`Performance`](src/main/java/com/demo/Models/Performance.java)
- [`Professor`](src/main/java/com/demo/Models/Professor.java)
- [`Usuario`](src/main/java/com/demo/Models/Usuario.java)
- 
## Controllers
Localizados em `src/main/java/com/demo/Controllers/`.

### [`LoginController`](src/main/java/com/demo/Controllers/LoginController.java)

### Alunos/
- [`AlunosController`](src/main/java/com/demo/Controllers/Alunos/AlunosController.java)
- [`ExercitarController`](src/main/java/com/demo/Controllers/Alunos/ExercitarController.java) 
- [`HistoricoController`](src/main/java/com/demo/Controllers/Alunos/HistoricoController.java) 

### Professores/
- [`CriaUsuarioController`](src/main/java/com/demo/Controllers/Professores/CriaUsuarioController.java)
- [`CriarPerguntaController`](src/main/java/com/demo/Controllers/Professores/CriarPerguntaController.java)
- [`ProfessoresController`](src/main/java/com/demo/Controllers/Professores/ProfessoresController.java)
- [`AlteraUsuarioController`](src/main/java/com/demo/Controllers/Professores/AlteraUsuarioController.java)

## Database
Arquivos CSV localizados em `src/main/java/com/demo/Database/`.

- `usuarios.csv`
- `nivel[n].csv`
- `performance.csv`

## Views
Localizadas em `src/main/java/com/demo/Views/`.

- [`Views`](src/main/java/com/demo/Views/Views.java)

## Resources
Localizados em `src/main/resources/com/demo/`.

- `Login.fxml`
- `AlunosMenu.fxml`
- `Exercitar.fxml`
- `Historico.fxml`
- `Professor.fxml`
- `CriaUsuario.fxml`
- `CriaPergunta.fxml`
- `AlteraUsuario.fxml`
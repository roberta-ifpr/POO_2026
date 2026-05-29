public class TestaRecord {
    public static void main(String[] args) {
        Aluno aluno = new Aluno()
        aluno.setNome("Fulano de Tal");
        aluno.setEmail("fulano@ifpr.edu.br");
        System.out.print(aluno.getEmail());

        AlunoRecord alunoRecord = 
          new AlunoRecord("Aluno1","aluno1@ifpr.edu.br");
          System.out.println(alunoRecord.email());
          alunoRecord.email = "novo email";

          
    }
}

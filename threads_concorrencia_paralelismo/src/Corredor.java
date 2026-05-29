public class Corredor extends Thread{

    private String nome;

    public Corredor(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {

        for(int i = 1; i <= 5; i++) {

            System.out.println(nome + " deu passo " + i);

            try {
                Thread.sleep(500);
            } catch(Exception e) {
                e.printStackTrace();
            }

        }

    }

}



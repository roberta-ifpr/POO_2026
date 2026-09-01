import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.*;

public class App {
    public static void main(String[] args) throws Exception {
        //1. endereço da api a ser consumida
        String endereco = "https://dog.ceo/api/breeds/image/random";
        //2. criar um cliente HTTP
        HttpClient cliente = HttpClient.newHttpClient();
        //3. Criar uma Requisicao HTTP - GET
        HttpRequest requisicao = HttpRequest.newBuilder().uri(URI.create(endereco)).GET().build();
        //4. executar a requisicao
        HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
        //5 resposta da API
        System.out.println("Status HTTP: "+resposta.statusCode());
        System.out.println("JSON recebido");

        String json = resposta.body();

        System.out.println(json);

        String imagemURL = json.split("\"message\":\"")[1].split("\"")[0];
        System.out.println(imagemURL);

        //mostrar a imagem numa janela
        Image imagemRedimensionada = new ImageIcon(URI.create(imagemURL).toURL()).getImage()
                                         .getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon imagem = new ImageIcon(imagemRedimensionada);

        JFrame janela = new JFrame("Doguinho aleatório");
        janela.setSize(450,450);
        JLabel label = new JLabel(imagem, SwingConstants.CENTER);
        janela.add(label);
        janela.setVisible(true);

    }
}

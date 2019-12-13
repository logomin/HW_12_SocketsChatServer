import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServer {
    public static void main(String[] args) {
        System.out.println("Ждем подключения...");
        while (true) {
            try (
                    ServerSocket serverSocket1 = new ServerSocket(1025);
                    Socket socket1 = serverSocket1.accept(); // когда кто-то подключится к сокету serverSocket1 программа пойдет дальше
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
            ) {

                System.out.println("Кто-то подключился");
                // Создаем поток для приема сообщений и для их отправки
                //while (true){
                String string1 = bufferedReader.readLine();
                System.out.println("Строка считалась");
                if (string1 == null) break;
                System.out.println(string1);
                bufferedWriter.write("лови обратно " + string1);
                bufferedWriter.flush();
//            }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

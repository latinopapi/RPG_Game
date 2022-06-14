package testing;

import com.project.GamePanel;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static com.project.GamePanel.selectedCharacter;

public class writefile {
    GamePanel gp = new GamePanel();


    public static void main(String[] args) throws IOException {
        writefile w = new writefile();
        w.writeFile1();

    }


    public void writeFile1() throws IOException {


        String name = "certificate_original.html";

        try (PrintWriter out = new PrintWriter(new FileWriter(name, true))) {

            String htmltemplate = "<!DOCTYPE html>\n" +
                    "<html lang=\"de\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>Document</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    Nabil ist besser als Savesta\n" +
                    "    <img src=\"" + "selectedCharacterImageURL" + "\" alt=\"picture\">\n" +
                    "</body>\n" +
                    "</html>";
            out.print(htmltemplate);

        }
    }


}

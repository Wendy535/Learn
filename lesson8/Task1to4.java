package geekBrains.lesson8;

import java.io.*;
import java.nio.Buffer;

public class Task1to4 {

    File text1 = new File("C:\\JavaTests\\Text1.txt");
    File text2 = new File("C:\\JavaTests\\Text2.txt");
    File text3 = new File("C:\\JavaTests\\Text3.txt");
    File text4 = new File("C:\\JavaTests\\Text4.txt");
    File joinText = new File("C:\\JavaTests\\JoinText.txt");

    public static void main(String[] args) {

            String lyrics1 = "I see trees of green\n" +
                    "Red roses too\n" +
                    "I see them bloom\n" +
                    "For me and you\n" +
                    "And I think to myself\n" +
                    "What a wonderful world\n";

            String lyrics2 = "I see skies of blue\n" +
                    "And clouds of white\n" +
                    "The bright blessed day\n" +
                    "The dark sacred night\n" +
                    "And I think to myself\n" +
                    "What a wonderful world\n";

            String lyrics3 = "The colors of the rainbow\n" +
                    "So pretty in the sky\n" +
                    "Are also on the faces\n" +
                    "Of people going by\n" +
                    "I see friends shaking hands\n" +
                    "Saying, \"How do you do?\"\n" +
                    "They're really saying\n" +
                    "\"I love you\"\n";

            String lyrics4 = "I hear babies cry\n" +
                    "I watch them grow\n" +
                    "They'll learn much more\n" +
                    "Than I'll never know\n" +
                    "And I think to myself\n" +
                    "What a wonderful world\n" +
                    "\n" +
                    "Yes, I think to myself\n" +
                    "What a wonderful world\n";

            addTextToFile("C:\\JavaTests\\Text1.txt", lyrics1, false);
            addTextToFile("C:\\JavaTests\\Text2.txt", lyrics2, false);
            addTextToFile("C:\\JavaTests\\Text3.txt", lyrics3,false);
            addTextToFile("C:\\JavaTests\\Text4.txt", lyrics4, false);

            textCompiler("C:\\JavaTests\\Text1.txt", "C:\\JavaTests\\JoinText.txt", true);
            textCompiler("C:\\JavaTests\\Text2.txt", "C:\\JavaTests\\JoinText.txt", true);

        findText("C:\\JavaTests\\Text1.txt", "trees");
        findText("C:\\JavaTests\\Text1.txt", "bloom");
        findText("C:\\JavaTests\\Text1.txt", "metal");

        findWordInDir("C:\\JavaTests", "babies");

    }

    public static void addTextToFile(String file, String text, Boolean cause) {
        try {FileWriter writer = new FileWriter(file, cause);
            writer.write(text);
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void textCompiler(String file1, String file2, Boolean cause){
        try{
            FileReader reader = new FileReader(file1);
            FileWriter writer = new FileWriter(file2, cause);
            int x = reader.read();
            while (x != -1) {
                writer.write(x);
                x = reader.read();
            }
            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void findText(String file, String text) {
        try {
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line;
            int lineCounter = 0;
            int matchCounter = 0;
            while ((line = br.readLine()) != null) {
                lineCounter++;
                if (line.contains(text)) {
                    matchCounter++;
                    System.out.println("the text contains \"" + text + "\" in line " + lineCounter);
                }
            }
            if (matchCounter == 0) {
                System.out.println("The text was not found");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void findWordInDir(String dir, String text) {
        File folder = new File(dir);
        File[] files = folder.listFiles();
        int matchCounter = 0;
        if (files != null) {
            for (File file: files) {
                try {
                    FileReader reader = new FileReader(file);
                    BufferedReader br = new BufferedReader(reader);
                    String line;
                    int lineCounter = 0;
                    while ((line = br.readLine()) != null) {
                        lineCounter++;
                        if (line.contains(text)) {
                            matchCounter++;
                            System.out.println("the text contains \"" + text + "\" in line " + lineCounter + " of file " + file);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (matchCounter == 0) {
            System.out.println("The text was not found");
        }
    }
}

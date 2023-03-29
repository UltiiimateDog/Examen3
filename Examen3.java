package parcial_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class Examen3 {
    private File ListaCSV = new File("C:\\Users\\Alan\\Documents\\UDLAP\\2 Semestre\\POO\\parcial_3\\archive", "emails.csv");

    public void ejecutar()  {
        String currentLine;
        File data = new File("C:\\Users\\Alan\\Documents\\UDLAP\\2 Semestre\\POO\\parcial_3\\archive", "data.txt");
        int[] values = new int[3000];
        String[] names = new String[1];
        for(int i = 0; i < 3000; i++)   {
            values[i] = 0;
        }
        int j = 1;
        if (this.ListaCSV.exists())    {
            try (FileReader fileReader = new FileReader(ListaCSV)) {
                BufferedReader bufReader = new BufferedReader(fileReader);
                currentLine = bufReader.readLine();//Esta linea es la que tiene el encabezado de la tabla
                names = currentLine.split(",");
                while( (currentLine = bufReader.readLine()) != null)   {
                    String[] arregloDeLinea = currentLine.split(",");
                    if (j > 730 && j < 780)    {
                        for(int i = 1; i < 3001; i++)   {
                            values[i-1] += Integer.parseInt(arregloDeLinea[i]);
                        }
                    }
                    if (j > 780)    {
                        break;
                    }
                    j++;
                }
                fileReader.close();
                bufReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            if (data.exists() == false)    {
                try {
                    data.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try (PrintWriter writer = new PrintWriter("C:\\Users\\Alan\\Documents\\UDLAP\\2 Semestre\\POO\\parcial_3\\archive\\" + "data.txt")) {
                for(int i = 0; i < 3000; i++)   {
                    writer.print(names[i+1] + ": ");
                    writer.println(values[i]);
                }
                writer.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

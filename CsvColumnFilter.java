import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CsvColumnFilter {
    public static void main(String[] args)
    {
        String fileToParse = "C:/Users/suraj/OneDrive/Documents/Assignments Dalhousie/Data Managemnet/Case_study/" +
                "time.csv";
        BufferedReader fileReader = null;
        final String DELIMITER = ",";
        try
        {
            String line = "";
            fileReader = new BufferedReader(new FileReader(fileToParse));
            HashMap<String,Integer> timeMap=new HashMap<>();
            List<List<String>> filterList = new ArrayList<>();
            Integer lineNumber=0;
            while ((line = fileReader.readLine()) != null)
            {
                String[] tokens = line.split(DELIMITER);
                if(lineNumber==0){
                }
                else {
                    timeMap.put(tokens[1],Integer.parseInt(tokens[0]));
                }
                if(lineNumber==0){
                    lineNumber++;
                }
            }

            String fileToParse2 = "C:/Users/suraj/OneDrive/Documents/Assignments Dalhousie/Data Managemnet/Case_study/" +
                    "sales_old.csv";
            BufferedReader fileReader2 = null;
            String line2 = "";
            int lineNumber2=0;
            fileReader2 = new BufferedReader(new FileReader(fileToParse2));
            while ((line2 = fileReader2.readLine()) != null)
            {
                String[] tokens = line2.split(DELIMITER);
                if(lineNumber2==0){
                    filterList.add(Arrays.asList(tokens));
                }
                else {
                    tokens[2]=timeMap.get(tokens[1]).toString();
                    filterList.add(Arrays.asList(tokens));
                }
                if(lineNumber2==0){
                    lineNumber2++;
                }

            }
            FileWriter csvWriter = new FileWriter("C:/Users/suraj/OneDrive/Documents/Assignments Dalhousie/Data Managemnet/Case_study/"+
                    "new2.csv");
            for (List<String> rowData : filterList) {
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
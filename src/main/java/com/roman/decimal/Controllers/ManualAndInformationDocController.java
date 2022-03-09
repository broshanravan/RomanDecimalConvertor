package com.roman.decimal.Controllers;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
public class ManualAndInformationDocController {

    @GetMapping("/info")
    public String getManualAndInformation(){

        String information = "";
        File file = new File( "manual.txt");

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String nextLine;
            while ((nextLine = bufferedReader.readLine()) != null)

                // Print the string
                information += nextLine;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return information;
    }

}


package tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput {
  private String name;
  
  public FileOutput(String name) {
    this.name=name;
  }
    
  
  public void toFile(String content) throws InvalidInputException, IOException {
    try { 
      File file = new File(name + ".txt");
      if(file.createNewFile()) {
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();
      } else {
          throw new InvalidInputException("File Already Exists");
        }
    }catch(InvalidInputException e) {
    }catch(IOException q){     
    }
  }
}

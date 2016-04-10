package tools;

import java.util.Map;

public class FormatContent {
  public Map<String, String> map;
  public String output = "";
  
  
  public FormatContent(Map<String, String> map) {
    this.map = map;   
  }
  
  
  public String formatContent() {
    output = "------------------------------"
        + "-----------------------------------------";
    output = output + "\n1. Name of Author:" + "\n        "
            + map.get("Author");
    output = output + "\n2. Number of All Citations:"
            + "\n        " + map.get("NumberCitations");
    output = output + "\n3. Number of i10-index after 2009:"
            + "\n        " + map.get("NumberIndices");
    output = output + "\n4. Title of the first 3 publications:"
            + "\n        1-   " + map.get("FirstThreePub").split(";")[0]
            + "\n        2-   " + map.get("FirstThreePub").split(";")[1]
            + "\n        3-   " + map.get("FirstThreePub").split(";")[2];
    output = output + "\n5. Total paper citation (first 5 papers):"
            + "\n        " + map.get("FirstFiveCitations");
    output = output + "\n6. Total Co-Authors:" 
            + "\n        " +  map.get("NumberCoAuthors");
    return output; 
  }
}

package tools;

public class FormatAllContent {
  String[] content;
  public String formatted = "";
  
  
  public FormatAllContent(String[] content) {
    this.content = content;
  }
  
  
  public String formatAll(){
    for (String contents : content) {
      formatted = formatted + contents +"\n";
    }
    return formatted;
  }
}

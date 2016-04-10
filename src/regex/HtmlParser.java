package regex;

public abstract class HtmlParser {
  protected String html;
  
  public HtmlParser(String html) {
    this.html = html;
  }
  
  
  public abstract String getContent();
  

}

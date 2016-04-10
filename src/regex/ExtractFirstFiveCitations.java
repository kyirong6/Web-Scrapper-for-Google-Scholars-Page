package regex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractFirstFiveCitations extends HtmlParser {

  
  public ExtractFirstFiveCitations(String html) {
    super(html);
  }

  
  @Override
  public String getContent() {
    String rawHTMLString = this.html;
    String reForAuthorExtraction =
        "\"col-citedby\">(.*?)</td>";
    Pattern patternObject = Pattern.compile(reForAuthorExtraction);
    Matcher matcherObject = patternObject.matcher(rawHTMLString);
    ArrayList<String> matches = new ArrayList<String>();
    int counter = 0;
    String num = "";
    while (matcherObject.find() && counter <6) {
      counter++;
      String rawHTML2 = matcherObject.group(1);
      String reForExtraction = "\">(.*?)</a>";
      Pattern patternObject2 = Pattern.compile(reForExtraction);
      Matcher matcherObject2 = patternObject2.matcher(rawHTML2);
      while (matcherObject2.find()) {
        matches.add(matcherObject2.group(1));
      }
    } 
    int i;
    int value = 0;
    for (i=0;i < matches.size(); i++) {
      value = value + Integer.parseInt(matches.get(i));   
    } return num + String.valueOf(value);
  }

}

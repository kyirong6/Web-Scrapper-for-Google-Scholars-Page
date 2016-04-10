package regex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractThreePublications extends HtmlParser {

  
  public ExtractThreePublications(String html) {
    super(html);
  }

  
  @Override
  public String getContent() {
    String rawHTMLString = this.html;
    String reForAuthorExtraction =
        "\"col-title\">(.*?)</td>";
    Pattern patternObject = Pattern.compile(reForAuthorExtraction);
    Matcher matcherObject = patternObject.matcher(rawHTMLString);
    ArrayList<String> matches = new ArrayList<String>();
    int counter = 0;
    String three = "";
    while (matcherObject.find() && counter <4) {
      counter++;
      String rawHTML2 = matcherObject.group();
      String reForExtraction = ">(.*?)\">(.*?)</a>";
      Pattern patternObject2 = Pattern.compile(reForExtraction);
      Matcher matcherObject2 = patternObject2.matcher(rawHTML2);
      while (matcherObject2.find()) {
        matches.add(matcherObject2.group(2));
      }
    } 
    int i;
    for (i=1;i < matches.size(); i++) {
      if (i==3) {
        three = three + matches.get(i);
      } else {
      three = three + matches.get(i) + ";";
      }
    } return three;
  }
}

package regex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractNumberIndices extends HtmlParser {

  
  public ExtractNumberIndices(String html) {
    super(html);
  }

  
  @Override
  public String getContent() {
    String rawHTMLString = this.html;
    String reForAuthorExtraction =
        "<td class=\"cit-borderleft cit-data\">"
            + "(.*?)</td>";
    Pattern patternObject = Pattern.compile(reForAuthorExtraction);
    Matcher matcherObject = patternObject.matcher(rawHTMLString);
    ArrayList<String> matches = new ArrayList<String>();
    while (matcherObject.find()) {
      matches.add(matcherObject.group(1));
    } return matches.get(5);
  }
}

package regex;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractNumberCitations extends HtmlParser {

  public ExtractNumberCitations(String html) {
    super(html);
  }

  @Override
  public String getContent() {
    String rawHTMLString = this.html;
    String reForAuthorExtraction =
        "<td class=\"cit-borderleft cit-data\">(.*?)</td>";
    Pattern patternObject = Pattern.compile(reForAuthorExtraction);
    Matcher matcherObject = patternObject.matcher(rawHTMLString);
    while (matcherObject.find()) {
      return matcherObject.group(1);
    } return "Not Found";
  }

}
package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ExtractAuthor extends HtmlParser {

  public ExtractAuthor(String html) {
    super(html);
  }

  
  @Override
  public String getContent() {
      String rawHTMLString = this.html;
      String reForAuthorExtraction =
          "<span id=\"cit-name-display\" "
              + "class=\"cit-in-place-nohover\">(.*?)</span>";
      Pattern patternObject = Pattern.compile(reForAuthorExtraction);
      Matcher matcherObject = patternObject.matcher(rawHTMLString);
      while (matcherObject.find()) {
        return matcherObject.group(1);
      } return "Not Found";
  } 
}


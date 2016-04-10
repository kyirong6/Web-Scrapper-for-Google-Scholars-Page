package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import driver.MyParser;

public class NumberOfCoAuthors extends HtmlParser {

  
  public NumberOfCoAuthors(String html) {
    super(html);
  }

  
  @Override
  public String getContent() {
    String rawHTMLString = this.html;
    String reForCoAuthors = "Co-authors</div>(.*?)</div>";
    Pattern patternObject = Pattern.compile(reForCoAuthors);
    Matcher matcherObject = patternObject.matcher(rawHTMLString);
    int counter = 1;
    int value = 0;
    while (matcherObject.find() && counter<=1){
      counter++;
      String rawHtml2 = matcherObject.group(1);
      String reForCoAuthors2 = "title=\"(.*?)\">";
      Pattern patternObject2 = Pattern.compile(reForCoAuthors2);
      Matcher matcherObject2 = patternObject2.matcher(rawHtml2);
      int num = 0;
      while (matcherObject2.find()) {
        MyParser.getCoAuthorTree().add(matcherObject2.group(1));
        num++;
        value = num;
      }
    }return Integer.toString(value);
  }
}

package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import driver.MyParser;
import org.apache.commons.lang3.StringEscapeUtils;
public class SortedCoAuthors {
  public String html;
  
  
  public SortedCoAuthors(String html) {
    this.html = html;
  }

  
  public void sortCoAuthors() {
    String rawHTMLString = this.html;
    String reForCoAuthors = "Co-authors</div>(.*?)</div>";
    Pattern patternObject = Pattern.compile(reForCoAuthors);
    Matcher matcherObject = patternObject.matcher(rawHTMLString);
    int counter = 1;
    while (matcherObject.find() && counter<=1){
      counter++;
      String rawHtml2 = matcherObject.group(1);
      String reForCoAuthors2 = "title=\"(.*?)\">";
      Pattern patternObject2 = Pattern.compile(reForCoAuthors2);
      Matcher matcherObject2 = patternObject2.matcher(rawHtml2);
      while (matcherObject2.find()) {
        // Adds each coAuthor to the static Tree which automatically
        // Orders and checks for occurrence
        MyParser.getCoAuthorTree().add(matcherObject2.group(1));
      } 
    }
  }
}

package tools;

import java.util.Collection;

public class FormatSortedCoAuthors {
  public Collection<String> coAuthors;
  public String format = "";
  
  
  public FormatSortedCoAuthors(Collection<String> coAuthors) {
    this.coAuthors = coAuthors;
  }
  
  
  public String format() {
    format = "------------------------------"
        + "-----------------------------------------";
    format = format + "\n7. Co-Author list sorted (Total: "
                 + String.valueOf(coAuthors.size()) + "):";
    for (String authors : coAuthors) {
      format = format + "\n" + authors;
    }
    return format;
  }
}

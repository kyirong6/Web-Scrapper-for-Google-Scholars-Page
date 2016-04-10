//**********************************************************
//Assignment3:
//CDF user_name: c5kyiron
//
//Author: Ngawang Kyirong
//
//
//Honor Code: I pledge that this program represents my own
//program code and that I have coded on my own. I received
//help from no one in designing and debugging my program.
//*********************************************************
package driver;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;


import regex.ExtractAuthor;
import regex.ExtractFirstFiveCitations;
import regex.ExtractNumberCitations;
import regex.ExtractNumberIndices;
import regex.ExtractThreePublications;
import regex.NumberOfCoAuthors;
import regex.SortedCoAuthors;
import tools.ConsoleOutput;
import tools.FileOutput;
import tools.FormatAllContent;
import tools.FormatContent;
import tools.FormatSortedCoAuthors;
import tools.GetHtml;
import tools.InvalidInputException;
  
public class MyParser {
  private static String output = "";
  private static Collection<String> coAuthors = 
      new TreeSet<String>();


/**
* @param args
 * @throws InvalidInputException 
 * @throws IOException 
*/
public static void main(String[] args) throws InvalidInputException, IOException {
  //Checks the arguments
  if ((args.length < 1) || (args.length >2)) {
    throw new InvalidInputException("Invalid Input");
 }
  Initialize(args);
}



  /**
   * Acts as the wheels of the program and uses all the 
   * methods to create the proper file.
  * @param args
  */
  private static void Initialize(String[] args) throws IOException, InvalidInputException {
    // Splits the arguments into a list of string
    String inputFiles[] = args[0].split(",");
    int length = inputFiles.length + 1;
    String[] contents = new String[length];
    int i = 0;
    // Loops over the first argument and envokes the regex
    // methods on each html file.
    for (String inputFile : inputFiles) {
      String html = new GetHtml().getHtml(inputFile);
      contents[i] = new FormatContent(useHtmlParser(html)).formatContent();
      i++;
    }
    contents[i] = new FormatSortedCoAuthors(coAuthors).format();
    output = new FormatAllContent(contents).formatAll();
    // Replaces Occurrences of HTML code for proper character
    output = output.replaceAll("O&#39;", "'");
    //checks to use fileoutput or console output
    if (args.length == 1) {
      new ConsoleOutput().printContent(output);
    } else {
      new FileOutput(args[1]).toFile(output);
      }
    }
  
  
  /**
   * Uses the regex code and adds the values to a map.
  * @param Map
  */
  private static Map<String, String> useHtmlParser(String html) {
    // Create a map and add the values to what every article should have
    // as the key
    Map<String, String> map = new HashMap<String, String>();
    map.put("Author", new ExtractAuthor(html).getContent());
    map.put("FirstFiveCitations", new ExtractFirstFiveCitations(html).getContent());
    map.put("NumberCitations", new ExtractNumberCitations(html).getContent());
    map.put("NumberIndices", new ExtractNumberIndices(html).getContent());
    map.put("FirstThreePub", new ExtractThreePublications(html).getContent());
    map.put("NumberCoAuthors", new NumberOfCoAuthors(html).getContent());
    new SortedCoAuthors(html).sortCoAuthors();
    return map;
  }
  
  
  public static Collection<String> getCoAuthorTree() {
    return coAuthors;
  }
}

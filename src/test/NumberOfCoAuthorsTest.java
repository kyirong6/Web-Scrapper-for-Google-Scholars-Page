package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import regex.ExtractNumberCitations;
import regex.NumberOfCoAuthors;
import tools.GetHtml;

public class NumberOfCoAuthorsTest {
  String html;
  String html2;

 
  @Before
  public void setUp() {
    html = new GetHtml().getHtml("sample1.html");
    html2 = new GetHtml().getHtml("sample2.html");
  }

  

  @Test
  public void testForSample1NumberCoAuthors() {
    assertEquals("15", new NumberOfCoAuthors(html).getContent());
  }
  
  @Test
  public void testForSample2NumberCoAuthors() {
    assertEquals("14", new NumberOfCoAuthors(html2).getContent());
  }

}

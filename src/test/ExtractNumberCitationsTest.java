package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import regex.ExtractFirstFiveCitations;
import regex.ExtractNumberCitations;
import tools.GetHtml;

public class ExtractNumberCitationsTest {
  String html;
  String html2;

 
  @Before
  public void setUp() {
    html = new GetHtml().getHtml("sample1.html");
    html2 = new GetHtml().getHtml("sample2.html");
  }

  

  @Test
  public void testForSample1TotalCitations() {
    assertEquals("437", new ExtractNumberCitations(html).getContent());
  }
  
  @Test
  public void testForSample2TotalCitatons() {
    assertEquals("263", new ExtractNumberCitations(html2).getContent());
  }
}

package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import regex.ExtractAuthor;
import regex.ExtractFirstFiveCitations;
import tools.GetHtml;

public class ExtractFirstFiveCitationsTest {
  String html;
  String html2;

  
  @Before
  public void setUp() {
    html = new GetHtml().getHtml("sample1.html");
    html2 = new GetHtml().getHtml("sample2.html");
  }

  
  
  @Test
  public void testForSample1FirstFiveCitations() {
    assertEquals("239", new ExtractFirstFiveCitations(html).getContent());
  }
  
  @Test
  public void testForSample2FirstFiveCitations() {
    assertEquals("158", new ExtractFirstFiveCitations(html2).getContent());
  }
}

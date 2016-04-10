package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import regex.ExtractAuthor;
import tools.GetHtml;

public class ExtractAuthorTest {
  String html;
  String html2;
  
  
  @Before
  public void setUp() {
    html = new GetHtml().getHtml("sample1.html");
    html2 = new GetHtml().getHtml("sample2.html");
  }

  
  
  @Test
  public void testForSample1AuthorName() {
    assertEquals("Ola Spjuth", new ExtractAuthor(html).getContent());
  }
  
  @Test
  public void testForSample2AuthorName() {
    assertEquals("Yan Xu", new ExtractAuthor(html2).getContent());
  }
}

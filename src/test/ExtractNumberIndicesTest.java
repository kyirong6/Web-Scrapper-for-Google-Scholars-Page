package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import regex.ExtractNumberCitations;
import regex.ExtractNumberIndices;
import tools.GetHtml;

public class ExtractNumberIndicesTest {
  String html;
  String html2;

 
  @Before
  public void setUp() {
    html = new GetHtml().getHtml("sample1.html");
    html2 = new GetHtml().getHtml("sample2.html");
  }

  

  @Test
  public void testForSample1Indices2009() {
    assertEquals("12", new ExtractNumberIndices(html).getContent());
  }
  
  @Test
  public void testForSample2Indices2009() {
    assertEquals("9", new ExtractNumberIndices(html2).getContent());
  }
}

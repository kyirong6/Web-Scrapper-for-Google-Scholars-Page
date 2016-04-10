package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import regex.ExtractNumberIndices;
import regex.ExtractThreePublications;
import tools.GetHtml;

public class ExtractThreePublicationsTest {
  String html;
  String html2;
  String firstThree1;
  String firstThree2;

 
  @Before
  public void setUp() {
    html = new GetHtml().getHtml("sample1.html");
    html2 = new GetHtml().getHtml("sample2.html");
    firstThree1 = "Bioclipse: an open source workbench for chemo-and bioinformatics;"
        + "The LCB data warehouse;XMPP for cloud computing in bioinformatics supporting "
        + "discovery and invocation of asynchronous web services";
    firstThree2 = "Face-tracking as an augmented input in video games: enhancing presence, "
        + "role-playing and control;Art of defense: a collaborative handheld"
        + " augmented reality board game;"
        + "Sociable killers: understanding social relationships in an online "
        + "first-person shooter game";
  }

  

  @Test
  public void testForSample13Publications() {
    assertEquals(firstThree1, new ExtractThreePublications(html).getContent());
  }
  
  @Test
  public void testForSample23Publications() {
    assertEquals(firstThree2, new ExtractThreePublications(html2).getContent());
  }
}

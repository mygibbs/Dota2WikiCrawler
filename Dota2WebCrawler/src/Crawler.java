import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlBody;
import com.gargoylesoftware.htmlunit.html.HtmlBold;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableDataCell;


public class Crawler {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * @throws FailingHttpStatusCodeException 
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		// get webclient
		final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_3_6);
		
		// get main page
		final String mainPage = "http://www.dota2wiki.com";
	    final HtmlPage page = webClient.getPage(mainPage);

	    //get list of all divs
		final List<HtmlAnchor> radiantChamps = (List<HtmlAnchor>) page.getByXPath("/html/body/div[3]/div[3]/div[4]/table[4]/tbody/tr[2]/td/div/table/tbody/tr[3]/td/div/table/tbody/tr[3]/td/div/div/table/tbody/tr/td[2]/div/div/small/a");
		final List<HtmlAnchor> direChamps = (List<HtmlAnchor>) page.getByXPath("/html/body/div[3]/div[3]/div[4]/table[4]/tbody/tr[2]/td/div/table/tbody/tr[3]/td/div/table/tbody/tr[3]/td[2]/div/div/table/tbody/tr/td/div/div/small/a");
	    
	    //print radiant champ names
	    System.out.println("\n\nRadiant Champs");
	    for (HtmlAnchor radiantChamp : radiantChamps) 
	    	System.out.println(radiantChamp.getAttribute("title"));
	    
	    //print dire champ names
	    System.out.println("\n\nDire Champs");
	    for (HtmlAnchor direChamp : direChamps) 
	    	System.out.println(direChamp.getAttribute("title"));
	    
	    // get a champs page
	    final HtmlPage champPage = webClient.getPage(mainPage + radiantChamps.get(0).getAttribute("href"));

	    final HtmlBody testBody = (HtmlBody) champPage.getBody();
	    System.out.println(testBody.asText());
	    
	    //final HtmlBold firstStat = (HtmlBold) champPage.getByXPath("/html/body/div[3]/div[3]/div[4]/table/tbody/tr[4]/td/table/tbody/tr/th/b");
	    final List<HtmlBold> firstStat = (List<HtmlBold>) champPage.getByXPath("/html/body/div[3]/div[3]/div[4]/table/tbody/tr[4]/td/table/tbody/tr/th/b");
	    
	    System.out.println("The first stat is " + firstStat.get(0).asText());
	    
	    //final HtmlTable champInfo = (HtmlTable) champ.getByXPath("//table[@class='infobox']");

    	//System.out.println(champInfo);
	    
	    
	    
	    
	    
	    
	    // get a first champs first stat
	    //@SuppressWarnings("unchecked")
		//final List<?> stats = (List<?>) champ.getByXPath("/html/body/div[3]/div[3]/div[4]/div/table/tbody/tr/td/table/tbody/tr[3]/td[1]");
	    // print stat
	    //for (HtmlTableDataCell stat : stats) 
    	//System.out.println(stats.get(0));
    	
	    
	    //get div which has a 'name' attribute of 'John'
	    //final HtmlDivision champ1 = (HtmlDivision) rows.getByXPath("//div[@name='John']").get(0);

	    webClient.closeAllWindows();
	}

}

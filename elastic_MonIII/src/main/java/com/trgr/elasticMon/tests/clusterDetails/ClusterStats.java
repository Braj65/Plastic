package com.trgr.elasticMon.tests.clusterDetails;

import org.junit.Before;
import org.junit.Test;

import com.trgr.elasticMon.command.ProcessorService;
import com.trgr.elasticMon.pages.DashBoardPage;

public class ClusterStats {
	
	ProcessorService p;
	@Before
	public void preTest(){
		p=new ProcessorService();
		p.run(this);
		//p.props.addFile(this, "DashBoardPage.properties");
	}
	
	@Test
	public void checkStat(){
		p.driver.get("https://webmail.thomsonreuters.com/");
		DashBoardPage dpage=(DashBoardPage) p.pgVisit.getPage(DashBoardPage.class);
		//p.pages.dashPage.lnk_ClusterDetails.sendKeys("Jammy");
		//p.pages.dashPage.lnk_ClusterDetails.submit();
		dpage.btn_TestButton.click();
		
		//p.pages.dashPage.btn_TestButton.click();
	}

}

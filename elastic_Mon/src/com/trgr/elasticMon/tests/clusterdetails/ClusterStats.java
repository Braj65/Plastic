package com.trgr.elasticMon.tests.clusterdetails;

import org.junit.Before;
import org.junit.Test;

import com.trgr.elasticMon.base.command.Processor;

public class ClusterStats {
	Processor p;
	@Before
	public void preTest(){
		p=new Processor();
		p.run(this);
		//p.props.addFile(this, "DashBoardPage.properties");
	}
	
	@Test
	public void checkStat(){
		p.driver.get("https://www.google.co.uk/");
		p.pages.dashPage.lnk_ClusterDetails.sendKeys("Jammy");
		p.pages.dashPage.lnk_ClusterDetails.submit();
	}

}

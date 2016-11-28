package com.trgr.elasticMon.tests.clusterDetails;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.trgr.elasticMon.command.ProcessorService;
import com.trgr.elasticMon.util.testUtils.TestDataAbs;
import com.trgr.elasticMon.util.testUtils.TestDataUtil;

@RunWith(Parameterized.class)
public class NodeStats {
	
	ProcessorService p;	
	public static String className;
	
	public String name;
	public String id;
	
	public NodeStats(String name, String id){
		this.name=name;
		this.id=id;
	}
	
	@Before
	public void setup(){
		p=new ProcessorService();
		p.run(this);
		className=this.getClass().getName();
	}
	
	@Test
	public void test_jam(){
		System.out.println(name+" "+id);
	}
	
	@Parameters
	public static Collection<Object[]> getData(){
		TestDataAbs tu=TestDataUtil.getInstance();
		Object[][] data=tu.getTestData(NodeStats.class.getSimpleName());
		return Arrays.asList(data);		
	}	

}

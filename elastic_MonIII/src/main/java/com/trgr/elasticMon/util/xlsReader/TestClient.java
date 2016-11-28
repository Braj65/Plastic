package com.trgr.elasticMon.util.xlsReader;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestClient {
	
	public String name;
	public String id;
	public String pwd;
	public String state1;
	public String state2;
	public String state3;
	
	public TestClient(String name, String id, String pwd, String state1, String state2, String state3){
		this.name=name;
		this.id=id;
		this.pwd=pwd;
		this.state1=state1;
		this.state2=state2;
		this.state3=state3;
	}
	
	@Test
	public void test_Jam(){
		System.out.print(name+" ");
		System.out.print(id+" ");
		System.out.print(pwd+" ");
		System.out.print(state1+" ");
		System.out.print(state2+" ");
		System.out.print(state3+" ");
		System.out.println();
	}	
	
	@Parameters
	public static Collection<Object[]> dataSupply(){
		XLSX_reader xl=new XLSX_reader("TestScenario1.xlsx");
		Object[][] data=xl.getTestData("RegistrationTest");
		return Arrays.asList(data);
	}
}
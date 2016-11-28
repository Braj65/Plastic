package com.trgr.elasticMon.pages;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ConcreteVisitor extends PageVisitor{
	private EventFiringWebDriver eDriver;
	public ConcreteVisitor(EventFiringWebDriver eDriver){
		this.eDriver=eDriver;
	}
	@Override
	public void visit(PageElement e){
		e.getTargetPage();		
	}

	@Override
	public PageElement getPage(Class T) {
		/*try {
			page=(PageElement) T.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page.initialize(T);*/
		Class pgEle;
		Method m;
		Object obj=null;
		try {
			pgEle=Class.forName(T.getName());
			m=pgEle.getMethod("initialize", EventFiringWebDriver.class, Class.class);
			obj=m.invoke(pgEle.newInstance(), eDriver, T);
		} /*catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException e) {
			e.printStackTrace();
		}*/
		catch(Exception e){
			e.printStackTrace();
		}
		return (PageElement) obj;
		
	}

	/*@Override
	public PageElement getPage(PageElement pageName) {
		return pageName.getTargetPage();	
	}*/
	
	
}

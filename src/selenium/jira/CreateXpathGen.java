package selenium.jira;

import org.openqa.selenium.By;

public class CreateXpathGen {
	
	public static By email = By.xpath(createXpath("//input[@name='{0}']", "harish@gmail.com"));
	
	
	public static String createXpath(String xpathExp, Object ...args) {
		for(int i=0;i<args.length; i++) {
			xpathExp = xpathExp.replace("{"+i+"}", (CharSequence) args[i]);
		}
		return xpathExp;
		
		
	}

	public static void main(String[] args) {
		
		String x1 = createXpath("//input[@name='{0}']","test");
		System.out.println(x1);
		
		String x2 = createXpath("//input[@name='{0}' and @id='{1}']","test","test_123");
		System.out.println(x2);
		
		String x3 = createXpath("//input[@name='{0}' and @id='{1}' and @type = '{2}']","test","test_123","testing");
		System.out.println(x3);
		
		System.out.println(email.toString().substring(email.toString().indexOf("//")));
	}

}

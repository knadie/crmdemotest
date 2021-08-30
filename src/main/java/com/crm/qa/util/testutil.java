package com.crm.qa.util;

import java.io.IOException;

import com.crm.qa.basepage.baseclass;

public class testutil extends baseclass{

		public testutil() throws IOException {
		
	}


		public static long PAGE_LOAD_TIMEOUT=50;
		public static long IMPLICITLY_WAIT=10;
		
	
		public void switchtoframe() {
			driver.switchTo().frame("mainpanel");
			
		}
		
		
		
}

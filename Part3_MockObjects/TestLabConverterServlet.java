import java.text.DecimalFormat;

import junit.framework.*;

import com.mockobjects.servlet.*;

import java.text.DecimalFormat;

public class TestLabConverterServlet extends TestCase {

	public void test_null_parameter() throws Exception {
		TestingLabConverterServlet s = new TestingLabConverterServlet();
		MockHttpServletRequest request = 
				new MockHttpServletRequest();
		MockHttpServletResponse response = 
				new MockHttpServletResponse();

		System.out.println("Testing the null paramater");
		String param = null;
		request.setupAddParameter("farenheitTemperature",param );
		response.setExpectedContentType("text/html");
		s.doGet(request,response);
		response.verify();
		assertEquals("<html><head><title>No Temperature</title>"
				+ "</head><body><h2>Need to enter a temperature!"
				+ "</h2></body></html>\n",
				response.getOutputStreamContents());
	}

	public void test_bad_parameter() throws Exception {
		TestingLabConverterServlet s = new TestingLabConverterServlet();
		MockHttpServletRequest request = 
				new MockHttpServletRequest();
		MockHttpServletResponse response = 
				new MockHttpServletResponse();
		System.out.println("Testing the bad paramater");
		request.setupAddParameter("farenheitTemperature", "boo!");
		response.setExpectedContentType("text/html");
		s.doGet(request,response);
		response.verify();
		assertEquals("<html><head><title>Bad Temperature</title>"
				+ "</head><body><h2>Need to enter a valid temperature!"
			    + "Got a NumberFormatException on " 
				+ "boo!" 
				+ "</h2></body></html>\n",
				response.getOutputStreamContents());
	}
	
	public void test_valid_parameter() throws Exception {
		TestingLabConverterServlet s = new TestingLabConverterServlet();
		MockHttpServletRequest request = 
				new MockHttpServletRequest();
		MockHttpServletResponse response = 
				new MockHttpServletResponse();
		
		System.out.println("Testing the valid paramater");
		Double farTempDouble = null;
		request.setupAddParameter("farenheitTemperature", "80");
	
		farTempDouble = Double.parseDouble("80");
		Double celTempDouble = 100.0*(farTempDouble - 32.0)/180.0;
		DecimalFormat df = new DecimalFormat("#.##");
		String celTemp = df.format(celTempDouble);
		response.setExpectedContentType("text/html");
		String austinTemperature = CityTemperatureServiceProvider.lookup("Austin");
		s.doGet(request,response);
		response.verify();
		assertEquals("<html><head><title>Temperature Converter Result</title>"
				+ "</head><body><h2>80 Farenheit = " + celTemp + " Celsius "
				+ "</h2>\n"
				+ "<p><h3>The temperature in Austin is " + austinTemperature + " degrees Farenheit</h3>\n"
				+ "</body></html>\n",
				response.getOutputStreamContents());
		
	}




}


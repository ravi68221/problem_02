package com.weather.weatherforcast.Controller;

import org.json.JSONException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;



@RestController
@RequestMapping("/forecast")
public class WeatherController {


	public static Client client = null;


	public static Client getClient()
	{
		if(client==null)
		{
			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getProperties().put(ClientConfig.PROPERTY_FOLLOW_REDIRECTS, true);
			client = Client.create(clientConfig);

		}
		return client;
	}

	String url = "http://api.openweathermap.org/data/2.5/weather";
	static String apikey = "387590149947ce8ba12b8edef3adb393";
	static String cod = "us";

@RequestMapping(value = "/zipcode", method = RequestMethod.GET, produces={"application/json"})

	public String getWeatherForcast(@RequestParam("zip") String zipcode) throws JSONException {
		String response = null;
	try {
		WebResource webResource = getClient().resource(url+"?zip="+zipcode +","+cod +"&APPID=" + apikey);
		response = webResource.get(String.class);
		System.out.println("getweather ::"+response);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return response;

}
@RequestMapping("/")
		public String index() {
				return "Greetings from Spring Boot!";
		}
}

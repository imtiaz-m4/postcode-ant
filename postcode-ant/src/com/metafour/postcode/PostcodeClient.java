package com.metafour.postcode;

import com.mobprofs.retrofit.converters.SimpleXmlConverter;

import retrofit.RestAdapter;

public class PostcodeClient {
	private static PostcodeService service;
	private static final String Live_URI = "http://postcode.geom4.net";

	public static PostcodeService getInstance() {
		return getInstance(Live_URI);
	}

	public static PostcodeService getInstance(String host) {
		if (service == null) {
			RestAdapter adapter = new RestAdapter.Builder()
					.setEndpoint(host)
					.setLogLevel(RestAdapter.LogLevel.FULL)
					.setConverter(new SimpleXmlConverter()).build();
			service = adapter.create(PostcodeService.class);
		}
		return service;
	}

}

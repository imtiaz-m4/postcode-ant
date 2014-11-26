package com.metafour.postcode;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Postcode search REST service client interface. <br>
 * Sample REST URL: http://postcode.geom4.net/search/100001/TW106DQ/full
 *
 * @author Imtiaz Rahi
 * @since 18-Nov-2014
 */
public interface PostcodeService {

	@GET("/search/{customer}/{postcode}/full")
	PostcodeSearchRS search(@Path("customer") String client, @Path("postcode") String postcode);

}

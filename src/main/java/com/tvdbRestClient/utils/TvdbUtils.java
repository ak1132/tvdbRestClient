package com.tvdbRestClient.utils;

import com.tvdbRestClient.service.TvdbAuthentication;
import com.tvdbRestClient.service.TvdbEpisodes;
import com.tvdbRestClient.service.TvdbLanguages;
import com.tvdbRestClient.service.TvdbSearch;
import com.tvdbRestClient.service.TvdbSeries;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TvdbUtils {

	public static final String API_HOST = "api.thetvdb.com";
	public static final String URL = " https://" + API_HOST + "/";
	public static final String HEADER_ACCEPT = "Accept";
	public static final String HEADER_ACCEPT_LANGUAGE = "Accept-Language";
	public static final String HEADER_AUTHORIZATION = "Authorization";

	private static OkHttpClient okHttpClient;

	private static Retrofit retrofit;

	public static Retrofit getTvdbRetrofitClient() {
		if (retrofit == null) {
			retrofit = new Retrofit.Builder().baseUrl(TvdbUtils.URL).addConverterFactory(GsonConverterFactory.create())
					.build();
		}
		return retrofit;
	}

	public static OkHttpClient getOkHttpClient(String jsonWebToken) {
		if (okHttpClient == null) {
			OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
					.addNetworkInterceptor(new TvdbInterceptor()).authenticator(new TvdbAuthenticator());
			okHttpClient = okHttpClientBuilder.build();
		}
		return okHttpClient;
	}

	public static TvdbAuthentication authenticate() {
		return getTvdbRetrofitClient().create(TvdbAuthentication.class);
	}

	public static TvdbEpisodes getEpisodes() {
		return getTvdbRetrofitClient().create(TvdbEpisodes.class);
	}

	public static TvdbLanguages getLanguages() {
		return getTvdbRetrofitClient().create(TvdbLanguages.class);
	}

	public static TvdbSearch searchTvdb() {
		return getTvdbRetrofitClient().create(TvdbSearch.class);
	}

	public static TvdbSeries getTvdbSeries() {
		return getTvdbRetrofitClient().create(TvdbSeries.class);
	}

}
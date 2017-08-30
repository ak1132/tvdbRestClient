package com.tvdbRestClient.models.response;

import com.tvdbRestClient.models.request.FullEpisode;

public class EpisodeResponse extends ErrorResponse {

	private FullEpisode data;

	public FullEpisode getData() {
		return data;
	}

	public void setData(FullEpisode data) {
		this.data = data;
	}

}
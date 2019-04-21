package com.ufc.projetoTcc2;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchTracksRequest;
import com.wrapper.spotify.requests.data.tracks.GetTrackRequest;

@Service
public class MusicService {


	private static final String clientId = "440d893768834767afbe6ca4c0363571";
	
	private static final String clientSecret = "13c5e651dfcf49f58c214656bdc0322f";
	
	private static SpotifyApi spotifyApi;
	
	private static ClientCredentialsRequest clientCredentialsRequest;
	
	public MusicService() {
		this.spotifyApi = new SpotifyApi.Builder()
		          .setClientId(clientId)
		          .setClientSecret(clientSecret)
		          .build();
		this.clientCredentialsRequest =  spotifyApi.clientCredentials()
		          .build();
		
		getclientCredentials();
		
	}
 
	
	public Track [] getMusic( String name ) {
		Track [] track = null;
		SearchTracksRequest searchTracksRequest = spotifyApi.searchTracks( name )
				.market( CountryCode.BR )
				.limit( 10 )
				.build();
		try {
		      final Paging<Track> trackPaging = searchTracksRequest.execute();
		      track =  trackPaging.getItems();
		      		      
		    } catch (IOException | SpotifyWebApiException e) {
		      System.out.println("Error: " + e.getMessage());
		    }
		return track;
		
	}
	
	public Track getMusicById(String id) {
		
		GetTrackRequest getTrackRequest = spotifyApi.getTrack( id )
				.market( CountryCode.BR )
				.build();
		  Track track = null;
		try {
		     track = getTrackRequest.execute();

		      return track;
	
		    } catch (IOException | SpotifyWebApiException e) {
		      System.out.println("Error: " + e.getMessage());
		    }
		return track;
	}
	 private void getclientCredentials() {
	    try {
	      final ClientCredentials clientCredentials = clientCredentialsRequest.execute();

	      // Set access token for further "spotifyApi" object usage
	      
	      String token  = clientCredentials.getAccessToken();
	      System.out.println( "Token: "+ token );
	      spotifyApi.setAccessToken( token );

	      System.out.println("Expires in: " + clientCredentials.getExpiresIn());
	    } catch (IOException | SpotifyWebApiException e) {
	      System.out.println("Error: " + e.getMessage());
	    }
	  }
}

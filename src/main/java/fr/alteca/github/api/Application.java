package fr.alteca.github.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import fr.alteca.github.bo.Branche;

public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String args[]) throws URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
		String uriValue = "https://api.github.com/repos/gcrevisy/poc-junit/branches";
		String username = "izerjal";
		String password = "altecaGit21!";
		// ResponseEntity<Branche[]> branches = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity(createHeaders(username, password)), Branche[].class);
		List<Branche> branches = Arrays.asList(restTemplate.getForObject(new URI(uriValue), Branche[].class));

		for (Branche branche : branches) {
			log.info(branche.toString());
			Branche obtainedBranch = restTemplate.getForObject(new URI(uriValue + "/" + branche.getName()), Branche.class);
			log.info(obtainedBranch.toString());
		}
		
		//Commit 1.0
		//Commit 1.1
		//Commit 1.2
		//Commit 1.3
		//Commit 1.4
		
	}

	private static MultiValueMap createHeaders(String username, String password) {
		return new HttpHeaders() {
			{
				String auth = username + ":" + password;
				byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
			}
		};
	}
}

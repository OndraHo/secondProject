package com.example.secondProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;

import org.codehaus.jackson.map.ObjectMapper;


/**
 * @author ondrej.hosek
 */

public class Connector {
	private static String SOURCE_OF_DATA = "https://euvatrates.com/rates.json";
	private static int API_TIMEOUT = 5000;

	public Connector() {
	}

	protected HttpsURLConnection createConnection() throws IOException {
		try {
			URL url = new URL(SOURCE_OF_DATA);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setConnectTimeout(API_TIMEOUT);
			connection.setReadTimeout(API_TIMEOUT);
			connection.setInstanceFollowRedirects(false);
			connection.connect();
			return connection;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new MalformedURLException();
		}
	}

	protected String readData(HttpsURLConnection con) throws IOException {
		Integer status = con.getResponseCode();
		if (status.toString().startsWith("2")) {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
			return content.toString();
		} else
			System.out.println("Invalid response");
		throw new IOException();
	}

}
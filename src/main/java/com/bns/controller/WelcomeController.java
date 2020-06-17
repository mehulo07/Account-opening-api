package com.bns.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class WelcomeController {

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public String getEmployees() {
		return "Welcome!";
	}

	@RequestMapping(value = "/submitap", method = RequestMethod.POST)
	public ResponseEntity<List> submitap(@RequestBody JSONObject billTrackingcr, HttpServletRequest request)
			throws IOException, ParseException, MessagingException {
		HttpSession hs = request.getSession(false);
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode Node = mapper.readTree(billTrackingcr);
		JSONObject jsonObj = new JSONObject();
		jsonObj = billTrackingcr;
		JSONArray ja_data = jsonObj.getJSONArray("data");
		int length = ja_data.size();
		for (int i = 0; i < length; i++) {
			JSONObject jObj = ja_data.getJSONObject(i);
			String id = jObj.optString("businessBuyingGroupId");
//        String id=ja_data.path("businessBuyingGroupId").asText();

			System.out.print(id);
		}

		return new ResponseEntity<>(HttpStatus.CREATED);

	}

}
package com.liferay.training.service.hello.impl;

import com.liferay.training.service.hello.HelloService;

public class HelloServiceImpl implements HelloService {

	
	private int _responseCount;

	/**
	 * Returns a string response
	 */
	@Override
	public String say() {
		return "Hello...";
	}

	@Override
	public String say(String response) {
		String reply = "";

		reply = doResponseDispatch(response);

		return reply;
	}

	private String doResponseDispatch(String response) {
		String reply = "";

		if (response.equalsIgnoreCase("hello")) {
			if (_responseCount == 0) {
				_responseCount += 1;

				reply = doInitiate();
			} else {
				_responseCount = 0;

				reply = doContinue();
			}
		} else {
			reply = "I don't think you'd understand...";
		}

		return reply;
	}

	private String doInitiate() {
		return "It's me...";
	}

	private String doContinue() {
		return "I was wondering if after all these years you'd like to meet";
	}

}

package com.srccode.clas;

import com.srccode.interfaces.Counter;

public class CounterRequest implements Counter {
	@Override
	public String requestCounter(String k) {
		int counter = 0;

		if (k == null) {
			counter++;
		} else {
			counter = Integer.parseInt(k);
			counter++;
		}
		return Integer.toString(counter);
	}

}

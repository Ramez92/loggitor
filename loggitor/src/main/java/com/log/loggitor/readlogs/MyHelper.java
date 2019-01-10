package com.log.loggitor.readlogs;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyHelper {
	

	   /** @return index of pattern in s or -1, if not found */
	public static int indexOf(Pattern pattern, String s) {
	    Matcher matcher = pattern.matcher(s);
	    return matcher.find() ? matcher.start() : -1;
	}

}

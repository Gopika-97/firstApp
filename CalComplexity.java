package spm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalComplexity {
	
	private static final CharSequence fileContent = null;
	int count = 0;
    int count1 = 0;
             
    //Checking for Numerical values
    Pattern pattern = Pattern.compile("\\d+");
    Matcher m = pattern.matcher(fileContent);
    
    while (m.find()) {//Numerical values found
        ++count;
    }

}
}
package angel.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GenerateOrderNum {

	public static long generateOrderNum(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    	Random rand = new Random();
		long result = 100000 + rand.nextInt(900000);
    	Long orderNum= Long.parseLong(sdf.format(new Date(System.currentTimeMillis())))+result;
    	return orderNum;    	
	}
}

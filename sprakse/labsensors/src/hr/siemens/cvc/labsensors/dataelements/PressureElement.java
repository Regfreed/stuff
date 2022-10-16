package hr.siemens.cvc.labsensors.dataelements;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

public class PressureElement extends RandomStringUtils implements DataElementType {
	String elementName;
	static double lastValue;

	@Override
	public MessageType generateType() {
		 int type;
		 Random  br=new Random();
		 type=(int)(br.nextDouble()*100);
		 if(type<11)return MessageType.invalid;
		 else return MessageType.valid;

	}

	@Override
	public String generateData(MessageType mType, String temp) {
		double minTemp;
		double maxTemp;
		double type;
		double a=Double.parseDouble(temp);
		String ret;
		// dovršit treba, na ovaj naèin neèe iæ
		if(lastValue==0){
			minTemp=-10;
			maxTemp=50.0;
		}else{
			minTemp=lastValue-0.1;
			maxTemp=lastValue+0.1;
		}
		if(mType==MessageType.valid){
		
			Random  br=new Random();
			type = minTemp + (maxTemp - minTemp) * br.nextDouble();
			ret=String.valueOf(type);
			
		}else{
			ret=randomAscii(10);
		}
		lastValue=a;
		return ret;
		
	}

}

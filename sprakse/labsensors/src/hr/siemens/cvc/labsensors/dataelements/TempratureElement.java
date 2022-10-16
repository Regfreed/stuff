package hr.siemens.cvc.labsensors.dataelements;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

public class TempratureElement extends RandomStringUtils implements DataElementType{

	String elementName;
	double lastValue;

	// this code generate message which would be sent through one of protocol types to the broker.
	@Override
	public String generateData(MessageType mType) {
		double minTemp;
		double maxTemp;
		double type;
		
		String ret;
		if(lastValue==0.0){
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
		if(mType==MessageType.valid){
		double last=Double.parseDouble(ret);
		lastValue=last;
		}
		return ret;
		
	}
// this code generate valid or invalid message type
	@Override
	public MessageType generateType() {
		 int type;
		 Random  br=new Random();
		 type=(int)(br.nextDouble()*100 + 1);
		 if(type<11)return MessageType.invalid;
		 else return MessageType.valid;

	}
	
	

}

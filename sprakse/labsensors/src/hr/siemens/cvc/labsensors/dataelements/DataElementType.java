package hr.siemens.cvc.labsensors.dataelements;

public interface DataElementType {
	public enum MessageType {
		valid, invalid
	}

	public MessageType generateType();
	
	public String generateData(MessageType mType);


}

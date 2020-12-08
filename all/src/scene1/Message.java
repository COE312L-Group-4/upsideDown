package scene1;

public class Message {
	TCP_Client tcp;
	String topic;
	public String condition;

	
	public Message() {
		this.tcp = null;
		this.topic = "";
		this.condition = "";
	}

	public Message(TCP_Client tcp, String t, String c) {
		this.tcp = tcp;
		topic = t;
		condition = c;
	}

	@Override
	public String toString() {
		return "Message [tcp=" + tcp + ", topic=" + topic + ", condition=" + condition + "]";
	}
	
	

}

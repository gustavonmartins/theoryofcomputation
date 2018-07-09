package common;

public class I_State implements State {
	private String name;
	
	public I_State(String name) {
		this.name=name;
	}
	@Override
	public String getStateName() {
		return name;
	}

}

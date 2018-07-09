package common;

import java.util.ArrayList;

public interface StateManager {
	public void addState(State state);
	public void setInitialState(State state);
	public void addAcceptedState(State state);
	
	public State getCurrentState();
	public void setCurrentState(State state);
	public ArrayList<State> getAcceptedStates();
}

package fda;

import java.util.ArrayList;

public interface StateBasics {
	public void addState(State state);
	public void setInitialState(State state);
	public void addAcceptedState(State state);
	
	public State getCurrentState();
	public void setCurrentState(State state);
	public ArrayList<State> getAcceptedStates();
}

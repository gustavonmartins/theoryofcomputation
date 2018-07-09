package common;

import java.util.ArrayList;

public class I_StateManager implements StateManager {
	private ArrayList<State> states;
	private State initialState;
	private ArrayList<State> acceptedStates;
	private State currentState;
	
	public I_StateManager() {
		states=new ArrayList<State>();
		initialState=null;
		acceptedStates=new ArrayList<State>(); 
		
		currentState=null;
	}
	
	@Override
	public void addState(State state) {
		states.add(state);
		
	}

	@Override
	public void setInitialState(State state) {
		if (!states.contains(state)) {
			System.out.println("Initial state cannot be set for it doesnt belong to machine");
		}
		else {
			initialState=state;
			currentState=initialState;
		}
	}

	@Override
	public void addAcceptedState(State state) {
		
		if (!states.contains(state)) {
			throw new RuntimeException("Accepted state cannot be set for it doesnt belong to machine");
		}
		else {
			acceptedStates.add(state);
		}
	}

	@Override
	public State getCurrentState() {
		return currentState;
	}

	@Override
	public void setCurrentState(State state) {
		currentState=state;
		
	}

	@Override
	public ArrayList<State> getAcceptedStates() {
		return acceptedStates;
	}

}

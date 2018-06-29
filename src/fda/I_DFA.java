package fda;

import java.util.ArrayList;
import java.util.function.BiFunction;

public class I_DFA implements FDA {
	private ArrayList<State> states;
	private State initialState;
	private ArrayList<State> acceptedStates;
	private BiFunction<State, String, State> function;
	
	private State currentState;
	
	public I_DFA() {
		states=new ArrayList<State>();
		initialState=null;
		acceptedStates=new ArrayList<State>(); 
		function=null;
		
		currentState=null;
	}
	
	@Override
	public void addState(State state) {
		states.add(state);
		
	}

	@Override
	public void setInitialState(State state) {
		initialState=state;
		currentState=initialState;
		
	}

	@Override
	public void addAcceptedState(State state) {
		acceptedStates.add(state);
		
	}

	@Override
	public void addTransition(BiFunction<State, String, State> function) {
		this.function=function;
		
	}

	@Override
	public void readSymbol(String symbol) {
		System.out.format("Old state is: %s...",currentState.getStateName());
		System.out.format("Symbol read: %s ",symbol);
		currentState=function.apply(currentState, symbol);
		System.out.format("New state is: %s\n",currentState.getStateName());
	}

}

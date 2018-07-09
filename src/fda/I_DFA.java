package fda;

import java.util.ArrayList;
import java.util.function.BiFunction;

public class I_DFA implements DFA {
	private ArrayList<State> states;
	private State initialState;
	private ArrayList<State> acceptedStates;
	private BiFunction<State, Character, State> function;
	
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
	public void addTransition(BiFunction<State, Character, State> function) {
		this.function=function;
		
	}

	@Override
	public void readSymbol(char symbol) {
		System.out.format("%s -",currentState.getStateName());
		System.out.format(" %s ->",symbol);
		currentState=function.apply(currentState, symbol);
		System.out.format(" %s\n",currentState.getStateName());
	}

	@Override
	public void readAllSymbols(String allSymbols) {
		for (char cs:allSymbols.toCharArray()) {
			readSymbol(cs);
		}
		if (acceptedStates.contains(currentState)) {
			System.out.println("Accepted");
		}
		else {
			System.out.println("Rejected");
		}
		
	}

}

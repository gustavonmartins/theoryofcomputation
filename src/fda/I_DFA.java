package fda;

import java.util.ArrayList;
import java.util.function.BiFunction;

public class I_DFA implements DFA {
	private I_StateBasics stBasics;
	private BiFunction<State, Character, State> function;
	
	
	public I_DFA() {
		stBasics=new I_StateBasics();
		function=null;
	}
	
	@Override
	public void addState(State state) {
		stBasics.addState(state);
		
	}

	@Override
	public void setInitialState(State state) {
		stBasics.setInitialState(state);
	}

	@Override
	public void addAcceptedState(State state) {
		stBasics.addAcceptedState(state);
	}

	@Override
	public void addTransition(BiFunction<State, Character, State> function) {
		this.function=function;
		
	}

	@Override
	public void readSymbol(char symbol) {
		System.out.format("%s -",stBasics.getCurrentState().getStateName());
		System.out.format(" %s ->",symbol);
		stBasics.setCurrentState(function.apply(stBasics.getCurrentState(), symbol));
		System.out.format(" %s\n",stBasics.getCurrentState().getStateName());
	}

	@Override
	public void readAllSymbols(String allSymbols) {
		for (char cs:allSymbols.toCharArray()) {
			readSymbol(cs);
		}
		if (stBasics.getAcceptedStates().contains(stBasics.getCurrentState())) {
			System.out.println("Accepted");
		}
		else {
			System.out.println("Rejected");
		}
		
	}

	@Override
	public State getCurrentState() {
		return stBasics.getCurrentState();
	}

	@Override
	public void setCurrentState(State state) {
		stBasics.setCurrentState(state);
		
	}

	@Override
	public ArrayList<State> getAcceptedStates() {
		return stBasics.getAcceptedStates();
	}

}

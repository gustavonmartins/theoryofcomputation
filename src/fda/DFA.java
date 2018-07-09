package fda;

import java.util.function.BiFunction;

public interface DFA {
	//public void setAlphabet(E alphabet);
	public void addState(State state);
	public void setInitialState(State state);
	public void addAcceptedState(State state);
	public void addTransition(BiFunction<State, Character, State> function);
	
	public void readSymbol(char symbol);
	public void readAllSymbols(String allSymbols);

}

package fda;

import java.util.function.BiFunction;

public interface FDA {
	//public void setAlphabet(E alphabet);
	public void addState(State state);
	public void setInitialState(State state);
	public void addAcceptedState(State state);
	public void addTransition(BiFunction<State, String, State> function);
	
	public void readSymbol(String symbol);

}

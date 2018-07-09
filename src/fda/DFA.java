package fda;

import java.util.function.BiFunction;

import common.State;
import common.StateManager;

public interface DFA extends StateManager{
	//public void setAlphabet(E alphabet);
	public void addTransition(BiFunction<State, Character, State> function);
	
	public void readSymbol(char symbol);
	public void readAllSymbols(String allSymbols);

}

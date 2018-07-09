package fda;

import java.util.function.BiFunction;

public interface DFA extends StateBasics{
	//public void setAlphabet(E alphabet);
	public void addTransition(BiFunction<State, Character, State> function);
	
	public void readSymbol(char symbol);
	public void readAllSymbols(String allSymbols);

}

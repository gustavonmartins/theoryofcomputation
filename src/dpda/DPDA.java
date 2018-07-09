package dpda;

import java.util.ArrayList;

import common.State;
import common.StateManager;
import common.TriFunction;

/*
 * Stack symbols is a set, and transition should be from an element, not set, but Java cant make it otherwise
 * Function returns a state and a sequence of symbols to substitute the just read symbol.
 * The sequence is implemented as an arrraylist
 */
public interface DPDA<StackSymbols extends Enum<StackSymbols>> extends StateManager{
	public void setInitialStackSymbol(StackSymbols symbol);
	public void addTransition(
			TriFunction<State, Character, StackSymbols, Tuple<State, ArrayList<StackSymbols>>> function);
	public StackSymbols peekCurrentStackSymbol();
	public StackSymbols popCurrentStackSymbol();
	public void pushStackSymbol(StackSymbols symbol);
	public void readSymbol(char symbol);
	public void readAllSymbols(String allSymbols);
	
	class Tuple<FST,SND>{
		FST first;
		SND second;
		
		public Tuple(FST first, SND second){
			this.first=first;
			this.second=second;
		}
		public Tuple() {
			this.first=null;
			this.second=null;
		}
		
		public Tuple<FST,SND> build(FST first,SND second) {
			this.first=first;
			this.second=second;
			return this;
		}
		
		public FST fst() {
			return first;
		}
		public SND snd() {
			return second;
		}
	}
}

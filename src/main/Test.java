package main;

import java.util.function.BiFunction;

import common.I_State;
import common.State;
import fda.DFA;
import fda.I_DFA;

public class Test {
	private static DFA machine;

	// Accepts: The set of all strings with three consecutive 0’s
	// Alphabet:  {0, 1}
	public static void main(String[] args) {
		
		machine=new I_DFA();
		
		State s1=new I_State("A");
		State s2=new I_State("B");
		State s3=new I_State("C");
		State s4=new I_State("D");
		State serror=new I_State("Error state");
		
		machine.addState(s1);
		machine.addState(s2);
		machine.addState(s3);
		machine.addState(s4);
		machine.addState(serror);
		
		machine.setInitialState(s1);
		
		machine.addAcceptedState(s4);
		
		BiFunction<State, Character, State> f1= (st,chrctr) -> 
				{
					if (st==s1 && chrctr=='0') {return s2;}
						if (st==s1 && chrctr=='1') {return s1;}
					if (st==s2 && chrctr=='0') {return s3;}
						if (st==s2 && chrctr=='1') {return s1;}
					if (st==s3 && chrctr=='0') {return s4;}
						if (st==s3 && chrctr=='1') {return s1;}
					if (st==s4) {return s4;}
					else {return serror;}
				};
		machine.addTransition(f1);
		

		machine.readAllSymbols("1001001101010010001");
	}

}

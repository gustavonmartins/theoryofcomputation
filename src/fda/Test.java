package fda;

import java.util.function.BiFunction;

public class Test {
	private static FDA machine;

	public static void main(String[] args) {
		
		machine=new I_DFA();
		
		State s1=new I_State("A");
		State s2=new I_State("B");
		State s3=new I_State("C");
		State serror=new I_State("Error state");
		
		machine.addState(s1);
		machine.addState(s2);
		machine.addState(s3);
		
		machine.setInitialState(s1);
		
		machine.addAcceptedState(s3);
		
		BiFunction<State, String, State> f1= (st,str) -> 
				{
					if (st==s1 && str=="0") {return s2;}
					if (st==s2 && str=="1") {return s1;}
					else {return serror;}
				};
		machine.addTransition(f1);
		
		machine.readSymbol("0");
		machine.readSymbol("1");
		machine.readSymbol("2");
		
		System.out.println("Finished");

	}

}

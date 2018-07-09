package main;

import java.util.ArrayList;

import common.I_State;
import common.State;
import common.TriFunction;
import dpda.DPDA;
import dpda.DPDA.Tuple;
import dpda.I_DPDA;
import dpda.TestStackSymbols;

public class Test2 {
	private static DPDA<TestStackSymbols> machine;

	// Accepts: The set of all strings with three consecutive 0’s
	// Alphabet:  {0, 1}
	public static void main(String[] args) {
		
		machine=new I_DPDA();
		
		State s1=new I_State("loading");
		State s2=new I_State("unloading");
		State s3=new I_State("pass!");
		State serror=new I_State("Error state");
		
		machine.addState(s1);
		machine.addState(s2);
		machine.addState(s3);
		machine.addState(serror);
		
		machine.setInitialState(s1);
		machine.setInitialStackSymbol(TestStackSymbols.STACKBOTTOM);
		
		machine.addAcceptedState(s3);
		
		TriFunction<State, Character, TestStackSymbols, Tuple<State, ArrayList<TestStackSymbols>>> f1= (state,character,stackSymbol) -> 
				{
					ArrayList<TestStackSymbols> newSymbols=new ArrayList<TestStackSymbols>();
					Tuple<State, ArrayList<TestStackSymbols>> output = new Tuple<State, ArrayList<TestStackSymbols>>();
					State newState=null;
					if (state==s1 && character=='a') 
						{
						newSymbols.add(stackSymbol);
						newSymbols.add(TestStackSymbols.A);
						newState=s1;
						}
					else if (state==s1 && character=='b') 
						{
						newSymbols.add(stackSymbol);
						newSymbols.add(TestStackSymbols.B);
						newState=s1;
						}
					else if (state==s1 && character=='c') 
					{
						newSymbols.add(stackSymbol);
						newState=s2;
					}
					else if (state==s2 && character=='a' && stackSymbol==TestStackSymbols.A) 
					{
						newState=s2;
					}
					else if (state==s2 && character=='b' && stackSymbol==TestStackSymbols.B) 
					{
						newState=s2;
					}
					else if (state==s2 && character=='$' && stackSymbol==TestStackSymbols.STACKBOTTOM) 
					{
						newState=s3;
					}
					else 
						{
						newState=serror;
						}
					return output.build(newState, newSymbols);
				};
		machine.addTransition(f1);		

		System.out.println("Beginning");
		machine.readAllSymbols("abcba$");
	}

}

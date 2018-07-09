package dpda;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

import common.I_StateManager;
import common.State;
import common.StateManager;
import common.TriFunction;

public class I_DPDA implements DPDA<TestStackSymbols> {
	private StateManager stBasics;
	private Stack<TestStackSymbols> stack;
	private TriFunction<State, Character, TestStackSymbols, Tuple<State,ArrayList<TestStackSymbols>>> function;
	
	public I_DPDA() {
		stBasics=new I_StateManager();
		stack=new Stack<TestStackSymbols>();
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

	@Override
	public void setInitialStackSymbol(TestStackSymbols symbol) {
		stack.add(symbol);
		
	}

	@Override
	public void addTransition(
			TriFunction<State, Character, TestStackSymbols, Tuple<State, ArrayList<TestStackSymbols>>> function) {
		this.function=function;
		
	}

	@Override
	public TestStackSymbols peekCurrentStackSymbol() {
		return stack.peek();
	}

	@Override
	public TestStackSymbols popCurrentStackSymbol() {
		try {return stack.pop();}
		catch (EmptyStackException e) {return null;}
		
	}

	@Override
	public void pushStackSymbol(TestStackSymbols symbol) {
		stack.push(symbol);
		
	}

	@Override
	public void readSymbol(char symbol) {
		System.out.format("Processing %s\n",symbol);
		
		Tuple<State, ArrayList<TestStackSymbols>> fnOut;
		TestStackSymbols currentStackSymol=stack.pop();
		State currentState=stBasics.getCurrentState();
		System.out.format("OLD STATE: %s, STACK: %s",currentState.getStateName(),currentStackSymol);
		if (currentState.getStateName()=="Error state") {
			System.out.println("\nError state -> Rejected");
			System.exit(1);
		}
		
		fnOut=function.apply(currentState, symbol, currentStackSymol);
		stBasics.setCurrentState(fnOut.fst());
		fnOut.snd().forEach(stckSymb->stack.push(stckSymb));
		try {
			System.out.format(" -> NEW STATE: %s, STACK: %s\n",stBasics.getCurrentState().getStateName(),stack.peek());
		}
		catch(EmptyStackException e) {
			System.out.println("Accepted! Stack empty!");
		}
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


}

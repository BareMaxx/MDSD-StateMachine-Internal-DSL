package main.metamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Machine {
	
	private List<State> states = new ArrayList<State>();
	private Integer initialState;
	private Map<String, Integer> variables = new HashMap<>();
	private Integer currentState = 0;
	

	public State addState(State state) {
		this.states.add(state);
		return state;
	}
	
	public List<State> getStates() {
		return this.states;
	}

	public State getInitialState() {
		return this.states.get(initialState);
	}

	public State getState(String string) {
		return this.states.stream().filter(state -> string.equals(state.getName())).findAny().get();
	}
	
	public void addVariable(String name) {
		this.variables.put(name, 0);
		return;
	}
	
	public void addVariable(String name, int value) {
		this.variables.put(name, value);
		return;
	}
	
	public void setVariable(String name, int value) {
		this.variables.put(name, value);
		return;
	}
	
	public State getCurrentState() {
		return this.states.get(this.currentState);
	}
	public void setCurrentState(State state) {
		this.currentState = this.states.indexOf(state);
	}

	public int numberOfIntegers() {
		return this.variables.size();
	}

	public boolean hasInteger(String string) {
		return this.variables.containsKey(string);
	}
	
	public int getInteger(String string) {
		return this.variables.get(string);
	}
	
	public void setInitialState(State state) {
		this.initialState = this.states.indexOf(state);
		
	}
}


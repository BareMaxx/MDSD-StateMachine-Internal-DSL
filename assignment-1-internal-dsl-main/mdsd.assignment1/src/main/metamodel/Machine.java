package main.metamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Machine {
	
	private List<State> states = new ArrayList<State>();
	private State initialState;
	private Map<String, Integer> variables = new HashMap<>();
	
	
	public Machine(List<State> states, State initialState) {
		this.states.addAll(states);
		this.initialState = initialState;
	}

	public List<State> getStates() {
		return this.states;
	}

	public State getInitialState() {
		return this.initialState;
	}

	public State getState(String string) {
		return this.getStates().stream().filter(state -> string.equals(state.getName())).findAny().get();
	}
	
	public void addVariable(String name) {
		if (variables.containsKey(name)) return;
		this.variables.put(name, 0);
		return;
	}
	
	public void addVariable(String name, int value) {
		if (variables.containsKey(name)) return;
		this.variables.put(name, value);
		return;
	}

	public int numberOfIntegers() {
		return this.variables.size();
	}

	public boolean hasInteger(String string) {
		return this.variables.containsKey(string);
	}
}


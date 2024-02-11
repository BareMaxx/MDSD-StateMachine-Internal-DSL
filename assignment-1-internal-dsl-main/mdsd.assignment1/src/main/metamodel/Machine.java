package main.metamodel;

import java.util.ArrayList;
import java.util.List;

public class Machine {
	
	private List<State> states = new ArrayList<State>();
	private State initialState;
	
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

	public int numberOfIntegers() {
		return this.states.size();
	}

	public boolean hasInteger(String string) {
		return this.states.stream().anyMatch(state -> string.equals(state.getName()));
	}
}


package main.metamodel;

import java.util.ArrayList;
import java.util.List;

public class State {
	
	private String name;
	private List<Transition> transitions = new ArrayList<>();
	
	public State(String name, List<Transition> transitions) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public List<Transition> getTransitions() {
		return this.transitions;
	}

	public Transition getTransitionByEvent(String string) {
		return this.transitions.stream().filter(transition -> transition.getEvent().equals(string)).findFirst().get();
	}
}

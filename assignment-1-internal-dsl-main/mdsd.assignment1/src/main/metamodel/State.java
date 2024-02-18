package main.metamodel;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class State {
	
	private String name;
	private List<Transition> transitions = new ArrayList<>();
	
	public State(String name) {
		this.name = name;
	}
	
	public void addTransition(Transition transition) {
		this.transitions.add(transition);
	}

	public String getName() {
		return this.name;
	}

	public List<Transition> getTransitions() {
		return this.transitions;
	}

	public Transition getTransitionByEvent(String string) {
		try {
			return this.transitions.stream().filter(transition -> transition.getEvent().equals(string)).findFirst().get();
		} catch (NoSuchElementException e) {
			return new Transition("null");
		}
		
	}
}

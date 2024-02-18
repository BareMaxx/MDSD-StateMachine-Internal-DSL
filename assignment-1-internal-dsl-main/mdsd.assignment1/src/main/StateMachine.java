package main;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

public class StateMachine {
	
	private Machine machine = new Machine();
	private Transition currentTransition;
	private State currentState;
	
	public Machine build() {
		Machine currentMachine = this.machine;
		this.machine = new Machine();
		return currentMachine;
	}

	public StateMachine state(String string) {
		State state = new State(string);
		this.currentState = this.machine.addState(state);
		return this;
	}

	public StateMachine initial() {
		this.machine.setInitialState(this.currentState);
		return this;
	}

	public StateMachine when(String string) {
		Transition transition = new Transition(string);
		this.currentState.addTransition(transition);
		this.currentTransition = transition;
		return this;
	}

	public StateMachine to(String string) {
		this.currentTransition
		.setTarget(new State(string));
		return this;
	}

	public StateMachine integer(String string) {
		this.machine.addVariable(string);
		return this;
	}

	public StateMachine set(String string, int i) {
		this.currentTransition
		.setOperation("SET")
		.setOperationVariable(string)
		.setOperationValue(i);
		
		return this;
	}

	public StateMachine increment(String string) {
		this.currentTransition
		.setOperation("INCREMENT")
		.setOperationVariable(string);
		
		return this;
	}

	public StateMachine decrement(String string) {
		this.currentTransition
		.setOperation("DECREMENT")
		.setOperationVariable(string);
		return this;
	}

	public StateMachine ifEquals(String string, int i) {
		this.currentTransition
		.setConditional("EQUALS")
		.setConditionalVariable(string)
		.setConditionalValue(i);
		return this;
	}

	public StateMachine ifGreaterThan(String string, int i) {
		this.currentTransition
		.setConditional("GREATER_THAN")
		.setConditionalVariable(string)
		.setConditionalValue(i);
		return this;
	}

	public StateMachine ifLessThan(String string, int i) {
		this.currentTransition
		.setConditional("LESS_THAN")
		.setConditionalVariable(string)
		.setConditionalValue(i);
		return this;
	}

}

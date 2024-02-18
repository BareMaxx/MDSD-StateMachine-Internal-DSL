package main;

import java.util.List;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

public class MachineInterpreter {
	
	private Machine machine;
	
    public void run(Machine m) {
    	this.machine = m;
    	this.machine.setCurrentState(this.machine.getInitialState());
    }

    public State getCurrentState() {
        return this.machine.getCurrentState();
    }

	public void processEvent(String string) {
    	List<Transition> transitions = this.machine.getCurrentState().getTransitions();
    	State currentStateState = this.machine.getCurrentState();
    	transitions = transitions.stream().filter(transition -> transition.getEvent().equals(string)).toList();
    	
    	for(int i = 0; i < transitions.size(); i++) {
    		Transition t = transitions.get(i);
    		if(i > 0 && !this.machine.getCurrentState().getName().equals(currentStateState.getName())) {
    			break;
    		}
			System.out.println("GetCurrentState" + this.machine.getCurrentState().getName());
            boolean continueProcess = false;
            if(!t.getEvent().equals("null")) {
            	if(t.isConditional()) {
                	int machineValue = this.machine.getInteger(t.getConditionVariableName());
                	int operationValue = t.getConditionComparedValue();
                	if(t.isConditionEqual()) {
                		continueProcess = machineValue == operationValue;
                	} else if (t.isConditionGreaterThan()) {
                		continueProcess = machineValue > operationValue;
                	} else if (t.isConditionLessThan()) {
                    	System.out.println("machine"+machineValue);
                    	System.out.println("operation"+operationValue);
                		continueProcess = machineValue < operationValue;
                	}
                } else {
                	continueProcess = true;
                }
                
                if(t.hasOperation() && continueProcess) {
                	System.out.println("continue"+continueProcess);
                	if(t.hasDecrementOperation()) {
                		int value = this.machine.getInteger(t.getOperationVariableName());
                		System.out.println(value);
                		value = value - 1;
                		System.out.println(value);
                		
                		this.machine.setVariable(t.getOperationVariableName(), value);
                	} else if (t.hasIncrementOperation()) {
                		System.out.println("hello");
                		int value = this.machine.getInteger(t.getOperationVariableName());
                		value = value + 1;
                		
                		this.machine.setVariable(t.getOperationVariableName(), value);
                	} else if (t.hasSetOperation()) {
                		this.machine.setVariable(t.getOperationVariableName(), t.getOperationValue());
                	}
                }
                
                System.out.println("Target"+t.getTarget().getName());
                System.out.println(this.machine.getStates());
                if(continueProcess) this.machine.setCurrentState(this.machine.getState(t.getTarget().getName()));
            }
		}
		
    }

    public int getInteger(String string) {
    	int value = 0;
    	if (this.machine.hasInteger(string)) {
    		value = this.machine.getInteger(string);
    	}
        return value;
    }

}

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
                		continueProcess = machineValue < operationValue;
                	}
                } else {
                	continueProcess = true;
                }
                
                if(t.hasOperation() && continueProcess) {
                	if(t.hasDecrementOperation()) {
                		int value = this.machine.getInteger(t.getOperationVariableName());
                		value = value - 1;
                		
                		this.machine.setVariable(t.getOperationVariableName(), value);
                	} else if (t.hasIncrementOperation()) {
                		int value = this.machine.getInteger(t.getOperationVariableName());
                		value = value + 1;
                		
                		this.machine.setVariable(t.getOperationVariableName(), value);
                	} else if (t.hasSetOperation()) {
                		this.machine.setVariable(t.getOperationVariableName(), t.getOperationValue());
                	}
                }
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

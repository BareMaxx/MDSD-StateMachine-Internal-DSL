package main.metamodel;

public class Transition {
	
	private String event;
	private State target;
	private String conditional = "";
	private String conditionalVariable = "";
	private Integer conditionalValue = 0;
	private String operation = "";
	private String operationVariable = "";
	private Integer operationValue = 0;
	private boolean isUsed = false;
	
	public Transition(String event) {
		this.event = event;
	}
	
	public String getEvent() {
		return this.event;
	}
	
	public boolean getIsUsed() {
		return isUsed;
	}
	
	public void setIsUsed() {
		this.isUsed = true;
	}

	public State getTarget() {
		return this.target;
	}
	
	public Transition setTarget(State target) {
		this.target = target;
		return this;
	}
	
	public Transition setOperation(String operation) {
		this.operation = operation;
		return this;
	}
	
	public Transition setOperationVariable(String operationVariable) {
		this.operationVariable = operationVariable;
		return this;
	}
	
	public Transition setOperationValue(Integer value) {
		this.operationValue = value;
		return this;
	}
	
	public Integer getOperationValue() {
		return this.operationValue;
	}
	
	public boolean hasOperation() {
		return !this.operation.equals("");
	}
	
	public boolean hasSetOperation() {
		return this.operation.equals("SET");
	}

	public boolean hasIncrementOperation() {
		return this.operation.equals("INCREMENT");
	}

	public boolean hasDecrementOperation() {
		return this.operation.equals("DECREMENT");
	}

	public String getOperationVariableName() {
		return this.operationVariable;
	}
	
	public Transition setConditional(String conditional) {
		this.conditional = conditional;
		return this;
	}
	
	public Transition setConditionalVariable(String conditionalVariable) {
		this.conditionalVariable = conditionalVariable;
		return this;
	}

	public Transition setConditionalValue(Integer value) {
		this.conditionalValue = value;
		return this;
	}
	
	public boolean isConditional() {
		return this.conditional != "";
	}

	public String getConditionVariableName() {
		return this.conditionalVariable;
	}

	public Integer getConditionComparedValue() {
		return this.conditionalValue;
	}

	public boolean isConditionEqual() {
		return this.conditional.equals("EQUALS");
	}

	public boolean isConditionGreaterThan() {
		return this.conditional.equals("GREATER_THAN");
	}

	public boolean isConditionLessThan() {
		return this.conditional.equals("LESS_THAN");
	}

}

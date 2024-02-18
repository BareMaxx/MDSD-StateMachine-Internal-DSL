package main.metamodel;

public class Transition {
	
	private String event;
	private State target;
	private String conditional = "";
	private String conditionalVariable = "";
	private Integer conditionalValue = 0;
	private String operation = "";
	private String operationVariable = "";
	
	public Transition(String event, State target) {
		this.event = event;
		this.target = target;
	}
	
	public Transition(String event, State target, String conditional, String conditionalVariable, Integer conditionalValue) {
		this(event, target);
		this.conditional = conditional;
		this.conditionalValue = conditionalValue;
		this.conditionalVariable = conditionalVariable;
	}
	
	public Transition(String event, State target, String operation, String operationVariable) {
		this(event, target);
		this.operation = operation;
		this.operationVariable = operationVariable; 
	}
	
	public Transition(String event, State target, String operation, String operationVariable, String conditional, String conditionalVariable, Integer conditionalValue) {
		this(event, target, conditional, conditionalVariable, conditionalValue);
		this.operation = operation;
		this.operationVariable = operationVariable;	
	}
	
	public String getEvent() {
		return this.event;
	}

	public State getTarget() {
		return this.target;
	}

	public boolean hasOperation() {
		return this.operation != "";
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

	public Object getOperationVariableName() {
		return this.operationVariable;
	}

	public boolean isConditional() {
		return this.conditional != "";
	}

	public Object getConditionVariableName() {
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

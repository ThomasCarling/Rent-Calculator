package control.constants;

public enum InputType {
    EDIT("Edit"),
    NEW("New"),
    NA("");
    
    public final String message;
    
    private InputType(String message) {
	this.message = message;
    }
}

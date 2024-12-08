package main.model.exceptions;

public class GUIException extends Exception {

    public GUIException() {
        super();
    }
    public GUIException(String message) {
        super(message);
    }

    public GUIException(String message, Throwable cause) {
        super(message, cause);
    }

    public GUIException(Throwable cause) {
        super(cause);
    }

    public void raiseAlert() {
        System.out.println("Here a pop up showing this message is going to be displayed: " + getMessage());
        //raise alert showing a pop up like
    }

}

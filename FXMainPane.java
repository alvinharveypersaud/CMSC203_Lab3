package Lab2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.event.EventTarget;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	private Button hello, howdy, chinese, clear, exit;
	private Label feedback;
	private TextField textField;
	
	//  declare two HBoxes
	HBox hbox1, hbox2;
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dataManager;
	Insets inset;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		hello = new Button("Hello");
		howdy = new Button("Howdy");
		chinese = new Button("Chinese");
		clear = new Button("clear");
		exit = new Button("exit");
		feedback = new Label("Feedback: ");
		textField = new TextField();
		//  instantiate the HBoxes
		hbox1 = new HBox();
		hbox2 = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		dataManager = new DataManager();
		inset = new Insets(5);
		//  set margins and set alignment of the components
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hbox1.getChildren().addAll(hello, howdy , chinese, clear, exit);
		//  add the buttons to the other HBox
		hbox2.getChildren().addAll(feedback, textField);
		//  add the HBoxes to this FXMainPanel (a VBox)
		this.getChildren().addAll(hbox1, hbox2);
		
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		hbox1.setMargin(hello, inset);
		hbox1.setMargin(howdy, inset);
		hbox1.setMargin(chinese, inset);
		hbox1.setMargin(clear, inset);
		hbox1.setMargin(exit, inset);
		hbox2.setMargin(textField, inset);
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent event)
		{
			EventTarget target = event.getTarget();
			if (target == hello)
			{
				textField.setText(dataManager.getHello());
			}
			else if (target == howdy)
			{
				textField.setText(dataManager.getHowdy());
			}
			else if (target == chinese)
			{
				textField.setText(dataManager.getChinese());
			}
			else if (target == clear)
			{
				textField.setText("");
			}
			else if (target == exit)
			{
				Platform.exit();
				System.exit(0);
			}
		}
	}
}
	

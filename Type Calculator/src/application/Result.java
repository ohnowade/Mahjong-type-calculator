package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import structure.Hand;

public class Result extends Application{
	/**
	 * the hand of cards to be passed in
	 */
	Hand hand;

	public Result(Hand hand) {
		this.hand = hand;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			// the information of the type
			String[] info = hand.calculate();
			
			// vbox containing all information
			VBox infoBox = new VBox();
			
			//if it is a valid type
			if (info.length > 1) {
				// the label showing the total fan value
				Label fanVal = new Label(info[0]);
				// the label showing the detail
				Label detail = new Label(info[1]);
				detail.setStyle("-fx-font: 40px \"KaiTi\";");
				// add the labels to the vbox
				infoBox.getChildren().addAll(fanVal, detail);
				VBox.setMargin(fanVal, new Insets(250, 0, 0, 500));
				VBox.setMargin(detail, new Insets(0, 0, 0, 50));
			}
			// if it is unvalid
			else {
				Label flaw = new Label(info[0]);
				infoBox.getChildren().add(flaw);
				VBox.setMargin(flaw, new Insets(250, 0, 0, 400));
			}
			BorderPane root = new BorderPane();
			root.setCenter(infoBox);
			ScrollPane sp = new ScrollPane();
			sp.setContent(root);
			Scene scene = new Scene(sp,1200,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("结果");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

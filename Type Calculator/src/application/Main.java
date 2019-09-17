package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import structure.Card;
import structure.Color;
import structure.Combo;
import structure.ComboType;
import structure.Hand;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {
	/**
	 * the hand containing all cards
	 */
	private Hand hand = new Hand();

	/**
	 *  the indicator of which combo button is selected
	 */
	private boolean[] selectCombo = new boolean[4];

	/**
	 * the list storing all card-adding images
	 */
	private ArrayList<ImageView> cardImages = new ArrayList<ImageView>();

	@Override
	public void start(Stage primaryStage) {
		try {
			// create label for hand section
			Label handTopic = new Label("手牌");
			// Add the label elements to layout manager and set the structure of the layout
			HBox topicBox = new HBox(handTopic);
			HBox.setMargin(handTopic, new Insets(0, 0, 0, 700));

			// the hand manifest section
			HBox darkBox = new HBox();
			darkBox.setMinHeight(175);
			HBox brightBox = new HBox();
			brightBox.setMinHeight(175);

			// the combo choices section
			HBox comboBox = new HBox();
			// buttons of choices of combo
			Button chowButton = new Button("吃");
			Button pongButton = new Button("碰");
			Button ankongButton = new Button("暗杠");
			Button mingkongButton = new Button("明杠");
			Button[] comboButtons = new Button[4];
			comboButtons[0] = chowButton;
			comboButtons[1] = pongButton;
			comboButtons[2] = ankongButton;
			comboButtons[3] = mingkongButton;
			// set function for all buttons
			for (Button temp : comboButtons) {
				temp.setOnMouseClicked(e -> {
					setComboButton(temp, comboButtons);
					setCheckCardImage();
				});
			}

			// add the buttons to hbox
			comboBox.getChildren().addAll(chowButton, pongButton, ankongButton, mingkongButton);
			// set structure
			comboBox.setSpacing(50);

			// the card choices section
			HBox cardRow1 = new HBox();
			HBox cardRow2 = new HBox();
			HBox cardRow3 = new HBox();
			HBox cardRow4 = new HBox();
			addAllCard(cardRow1, cardRow2, cardRow3, cardRow4, darkBox, brightBox);
			VBox cardVBox = new VBox(cardRow1, cardRow2, cardRow3, cardRow4);
			cardVBox.setSpacing(10);

			// vbox containing all information about card choice
			VBox allHand = new VBox(topicBox, darkBox, brightBox, comboBox, cardVBox);
			// set margin and spacing
			VBox.setMargin(comboBox, new Insets(0, 0, 0, 475));
			VBox.setMargin(cardVBox, new Insets(10, 0, 0, 475));

			// create labels for winning information section
			Label infoTopic = new Label("和牌信息");
			Label colorInfo = new Label("花色");
			Label valueInfo = new Label("数字");
			Label selfInfo = new Label("是否自摸");

			// the two combo boxes that contain choices of information of winning card
			ObservableList<String> colors = FXCollections.observableArrayList();
			colors.add("条");
			colors.add("饼");
			colors.add("万");
			colors.add("字");
			ComboBox<String> colorBox = new ComboBox<String>(colors);
			colorBox.setMinSize(100, 25);
			ObservableList<String> values = FXCollections.observableArrayList();
			values.add("一");
			values.add("二");
			values.add("三");
			values.add("四");
			values.add("五");
			values.add("六");
			values.add("七");
			values.add("八");
			values.add("九");
			ComboBox<String> valueBox = new ComboBox<String>(values);
			valueBox.setMinSize(100, 25);
			colorBox.setOnAction(e -> {
				String selected = colorBox.getSelectionModel().getSelectedItem();
				if (selected != null && selected.equals("字")) {
					ObservableList<String> zis = FXCollections.observableArrayList();
					zis.add("东");
					zis.add("南");
					zis.add("西");
					zis.add("北");
					zis.add("中");
					zis.add("发");
					zis.add("白");
					valueBox.setItems(zis);
				} else {
					valueBox.setItems(values);;
				}
			});


			// the check box for indication of zimo
			CheckBox ziMo = new CheckBox();

			// the button for calculation
			Button calculate = new Button("计算");
			setCalculateButton(calculate, colorBox, valueBox, ziMo);

			// the rows of winning info section
			HBox infoRow2 = new HBox(valueInfo, colorInfo);
			infoRow2.setSpacing(50);
			HBox infoRow3 = new HBox(valueBox, colorBox);
			infoRow3.setSpacing(50);

			// add all nodes to layout manager
			VBox allInfo = new VBox(infoTopic, infoRow2, infoRow3, selfInfo, ziMo, calculate);
			allInfo.setSpacing(50);
			VBox.setMargin(ziMo, new Insets(0, 0, 0, 100));
			VBox.setMargin(calculate, new Insets(0, 0, 0, 50));

			BorderPane root = new BorderPane();
			root.setCenter(allHand);
			root.setRight(allInfo);
			BorderPane.setMargin(allInfo, new Insets(0, 100, 0, 0));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			// Set up the name of the stage and maximize its size
			primaryStage.setTitle("谭氏国标麻将算番器");
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * helps get and show all cards in the dark side
	 * @param darkBox
	 */
	private void getDarkCards(HBox darkBox) {
		darkBox.getChildren().clear();
		// retrieve all dark cards
		ArrayList<Card> cards = hand.getDark(); 
		// traverse through list and process every card
		for (Card temp : cards) {
			// the name of the image view to be shown
			String name = "" + temp.getValue();
			switch (temp.getColor()) {
				case Tiao:
					name += "tiao.png";
					break;
				case Bing:
					name += "bing.png";
					break;
				case Wan:
					name += "wan.png";
					break;
				default:
					name += "zi.png";
			}
			// create the image and imageView
			Image curCard = new Image(name);
			ImageView curCardView = new ImageView(curCard);
			curCardView.setId("" + temp.getValue() + temp.getColor().toString().toLowerCase());
			// adjust the size
			curCardView.setFitWidth(50);
			curCardView.setPreserveRatio(true);
			setRemoveDarkImage(curCardView, darkBox);
			// add the image to the hbox
			darkBox.getChildren().add(curCardView);
		}
	}

	/**
	 * helps get all cards in bright side
	 * @param brightBox
	 */
	private void getBrightCards(HBox brightBox) {
		brightBox.getChildren().clear();
		// retrieve all bright combo
		ArrayList<Combo> cards = hand.getBright();
		// traverse through list and process every combo
		for (Combo temp : cards) {
			// the hbox containing current combo
			HBox curCombo = new HBox();

			// process ankong first
			if (temp.getType() == ComboType.ankong) {
				// the name of the image view to be shown
				String name = "" + temp.getCards().get(0).getValue();
				switch (temp.getCards().get(0).getColor()) {
					case Tiao:
						name += "tiao.png";
						break;
					case Bing:
						name += "bing.png";
						break;
					case Wan:
						name += "wan.png";
						break;
					default:
						name += "zi.png";
				}

				// create the image and imageView
				Image curCard = new Image(name);
				ImageView curCardView = new ImageView(curCard);
				curCardView.setId(name.substring(0, name.indexOf(".")));
				// adjust the size
				curCardView.setFitWidth(50);
				curCardView.setPreserveRatio(true);
				setRemoveBrightImage(curCardView, curCombo, brightBox);
				// add the image to the hbox
				curCombo.getChildren().add(curCardView);

				// add three image of the back of mahjong
				for (int i = 0; i < 3; i++) {
					Image back = new Image("back.png");
					ImageView backView = new ImageView(back);
					backView.setId("ankong");
					// adjust the size
					backView.setFitWidth(50);
					backView.setPreserveRatio(true);
					setRemoveBrightImage(backView, curCombo, brightBox);
					// add the image to the hbox
					curCombo.getChildren().add(backView);
				}
			} else {
				for (Card card : temp.getCards()) {
					// the name of the image view to be shown
					String name = "" + card.getValue();
					switch (card.getColor()) {
						case Tiao:
							name += "tiao.png";
							break;
						case Bing:
							name += "bing.png";
							break;
						case Wan:
							name += "wan.png";
							break;
						default:
							name += "zi.png";
					}

					// create the image and imageView
					Image curCard = new Image(name);
					ImageView curCardView = new ImageView(curCard);
					curCardView.setId(name.substring(0, name.indexOf(".")));
					// adjust the size
					curCardView.setFitWidth(50);
					curCardView.setPreserveRatio(true);
					setRemoveBrightImage(curCardView, curCombo, brightBox);
					// add the image to the hbox
					curCombo.getChildren().add(curCardView);
				}
			}

			// add the combo box to the bright box
			brightBox.getChildren().add(curCombo);
		}

		brightBox.setSpacing(30);
	}


	/**
	 * helps set a combo type when clicked
	 */
	private void setComboButton(Button curCombo, Button[] allButton) {
		if (curCombo.getText().equals("吃")) {
			// change status of being selected of current button
			selectCombo[0] = !selectCombo[0];
			// cancel selection of other buttons
			selectCombo[1] = false;
			selectCombo[2] = false;
			selectCombo[3] = false;
		} else if (curCombo.getText().equals("碰")) {
			// change status of being selected of current button
			selectCombo[1] = !selectCombo[1];
			// cancel selection of other buttons
			selectCombo[0] = false;
			selectCombo[2] = false;
			selectCombo[3] = false;
		} else if (curCombo.getText().equals("暗杠")) {
			// change status of being selected of current button
			selectCombo[2] = !selectCombo[2];
			// cancel selection of other buttons
			selectCombo[1] = false;
			selectCombo[0] = false;
			selectCombo[3] = false;
		} else {
			// change status of being selected of current button
			selectCombo[3] = !selectCombo[3];
			// cancel selection of other buttons
			selectCombo[1] = false;
			selectCombo[2] = false;
			selectCombo[0] = false;
		}

		// set all buttons to correspondent color
		for (int i = 0; i < selectCombo.length; i++) {
			if (selectCombo[i]) {
				allButton[i].setStyle("-fx-background-color: #2D8839;");
			} else {
				allButton[i].setStyle("-fx-background-color: #FFFFFF;");
			}
		}
	}

	private void addAllCard(HBox tiaoRow, HBox bingRow, HBox wanRow, HBox ziRow, HBox darkBox, HBox brightBox) {
		// add all tiao cards
		for (int i = 1; i < 10; i++) {
			// the image for current card
			Image tiao = new Image(i + "tiao.png");
			ImageView tiaoView = new ImageView(tiao);
			tiaoView.setId(i + "tiao");
			setAddCardImage(tiaoView, darkBox, brightBox);
			// adjust the size
			tiaoView.setFitWidth(75);
			tiaoView.setPreserveRatio(true);
			tiaoRow.getChildren().add(tiaoView);
			cardImages.add(tiaoView);
		}
		// add all bing cards
		for (int i = 1; i < 10; i++) {
			// the image for current card
			Image bing = new Image(i + "bing.png");
			ImageView bingView = new ImageView(bing);
			bingView.setId(i + "bing");
			setAddCardImage(bingView, darkBox, brightBox);
			// adjust the size
			bingView.setFitWidth(75);
			bingView.setPreserveRatio(true);
			bingRow.getChildren().add(bingView);
			cardImages.add(bingView);
		}
		// add all wan cards
		for (int i = 1; i < 10; i++) {
			// the image for current card
			Image wan = new Image(i + "wan.png");
			ImageView wanView = new ImageView(wan);
			wanView.setId(i + "wan");
			setAddCardImage(wanView, darkBox, brightBox);
			// adjust the size
			wanView.setFitWidth(75);
			wanView.setPreserveRatio(true);
			wanRow.getChildren().add(wanView);
			cardImages.add(wanView);
		}
		// add all zi cards
		for (int i = 1; i < 8; i++) {
			// the image for current card
			Image zi = new Image(i + "zi.png");
			ImageView ziView = new ImageView(zi);
			ziView.setId(i + "zi");
			setAddCardImage(ziView, darkBox, brightBox);
			// adjust the size
			ziView.setFitWidth(75);
			ziView.setPreserveRatio(true);
			ziRow.getChildren().add(ziView);
			cardImages.add(ziView);
		}

		// set spacing for all rows
		tiaoRow.setSpacing(5);
		bingRow.setSpacing(5);
		wanRow.setSpacing(5);
		ziRow.setSpacing(5);
	}

	/**
	 * helps set up the card image when clicked
	 */
	private void setAddCardImage(ImageView cardView, HBox darkBox, HBox brightBox) {
		cardView.setOnMouseClicked(e -> {
			// the information of which card to be added
			String info = cardView.getId();
			int value = Integer.parseInt(info.substring(0, 1));
			Color color = Color.Zi;
			if (info.substring(1).equals("tiao")) {
				color = Color.Tiao;
			} else if (info.substring(1).equals("bing")) {
				color = Color.Bing;
			} else if (info.substring(1).equals("wan")) {
				color = Color.Wan;
			}

			// check card-selection options
			// if the combo to be added is a flush
			if (selectCombo[0]) {
				Combo chow = new Combo(ComboType.chow);
				if (color != Color.Zi) {
					if (value < 8) {
						chow.addCard(new Card(value, color));
						chow.addCard(new Card(value + 1, color));
						chow.addCard(new Card(value + 2, color));
						hand.addBright(chow);
					} else {
						chow.addCard(new Card(7, color));
						chow.addCard(new Card(8, color));
						chow.addCard(new Card(9, color));
						hand.addBright(chow);
					}
				}
			} 
			// if the combo to be added is a pong
			else if (selectCombo[1]) {
				Combo pong = new Combo(ComboType.pong);
				for (int i = 0; i < 3; i++) {
					pong.addCard(new Card(value, color));
				}
				hand.addBright(pong);
			}
			// if the combo to be added is a ankong
			else if (selectCombo[2]) {
				Combo ankong = new Combo(ComboType.ankong);
				for (int i = 0; i < 4; i++) {
					ankong.addCard(new Card(value, color));
				}
				hand.addBright(ankong);
			}
			// if the combo to be added is a mingkong
			else if (selectCombo[3]) {
				Combo mingkong = new Combo(ComboType.mingkong);
				for (int i = 0; i < 4; i++) {
					mingkong.addCard(new Card(value, color));
				}
				hand.addBright(mingkong);
			}
			// if it is not bright card to be added
			else {
				hand.addDark(new Card(value, color));
			}
			// update dark box and bright box for newly added cards and refresh all images
			getDarkCards(darkBox);
			getBrightCards(brightBox);
			setCheckCardImage();
		});
	}

	private void setCheckCardImage() {
		for (ImageView temp : cardImages) {
			// the card information represented by this view
			String info = temp.getId();
			// the value of this card
			int value = Integer.parseInt(info.substring(0, 1));
			// the color of this card
			Color color = Color.Zi;
			if (info.substring(1).equals("tiao")) {
				color = Color.Tiao;
			} else if (info.substring(1).equals("bing")) {
				color = Color.Bing;
			} else if (info.substring(1).equals("wan")) {
				color = Color.Wan;
			}
			// create an object of this card
			Card card = new Card(value, color);
			// check if the hand is full
			if (hand.checkFull()) {
				temp.setDisable(true);
				ColorAdjust adjust = new ColorAdjust();
				adjust.setBrightness(-0.5);
				temp.setEffect(adjust);
				continue;
			} 
			// check if there could be more cards added to the hand
			// if currently the flush button is pressed
			if (selectCombo[0]) {
				// if the value of the card is less than 8
				if (value < 8) {
					if (3 * hand.getBright().size() + hand.getDark().size() > 11
							|| hand.NumOfCard(card) > 3 
							|| hand.NumOfCard(new Card(value + 1, color)) > 3
							|| hand.NumOfCard(new Card(value + 2, color)) > 3) {
						temp.setDisable(true);
						ColorAdjust adjust = new ColorAdjust();
						adjust.setBrightness(-0.5);
						temp.setEffect(adjust);
						continue;
					}
				} 
				// if the value is 8
				else if (value == 8) {
					if (3 * hand.getBright().size() + hand.getDark().size() > 11
							|| hand.NumOfCard(card) > 3 
							|| hand.NumOfCard(new Card(value - 1, color)) > 3
							|| hand.NumOfCard(new Card(value + 1, color)) > 3) {
						temp.setDisable(true);
						ColorAdjust adjust = new ColorAdjust();
						adjust.setBrightness(-0.5);
						temp.setEffect(adjust);
						continue;
					}
				}
				// if the value is 9
				else {
					if (3 * hand.getBright().size() + hand.getDark().size() > 11
							|| hand.NumOfCard(card) > 3 
							|| hand.NumOfCard(new Card(value - 1, color)) > 3
							|| hand.NumOfCard(new Card(value - 2, color)) > 3) {
						temp.setDisable(true);
						ColorAdjust adjust = new ColorAdjust();
						adjust.setBrightness(-0.5);
						temp.setEffect(adjust);
						continue;
					}
				}
			}
			// if the pong button is selected
			else if (selectCombo[1]) {
				if (3 * hand.getBright().size() + hand.getDark().size() > 11
						|| hand.NumOfCard(card) > 1) {
					temp.setDisable(true);
					ColorAdjust adjust = new ColorAdjust();
					adjust.setBrightness(-0.5);
					temp.setEffect(adjust);
					continue;
				}
			}
			// if the ankong button is selected
			else if (selectCombo[2]) {
				if (3 * hand.getBright().size() + hand.getDark().size() > 11
						|| hand.NumOfCard(card) > 0) {
					temp.setDisable(true);
					ColorAdjust adjust = new ColorAdjust();
					adjust.setBrightness(-0.5);
					temp.setEffect(adjust);
					continue;
				}
			}
			// if the mingkong button is pressed
			else if (selectCombo[3]) {
				if (3 * hand.getBright().size() + hand.getDark().size() > 11
						|| hand.NumOfCard(card) > 0) {
					temp.setDisable(true);
					ColorAdjust adjust = new ColorAdjust();
					adjust.setBrightness(-0.5);
					temp.setEffect(adjust);
					continue;
				}
			}
			// if none of the buttons is pressed
			else {
				if (hand.NumOfCard(card) > 3) {
					temp.setDisable(true);
					ColorAdjust adjust = new ColorAdjust();
					adjust.setBrightness(-0.5);
					temp.setEffect(adjust);
					continue;
				}
			}

			// set the image back to available
			temp.setDisable(false);
			ColorAdjust adjust = new ColorAdjust();
			adjust.setBrightness(0);
			temp.setEffect(adjust);
		}
	}

	/**
	 * set up images when clicked to remove dark cards
	 * @param cardView
	 * @param darkBox
	 */
	private void setRemoveDarkImage(ImageView cardView, HBox darkBox) {
		cardView.setOnMouseClicked(e -> {
			// the information of current card
			String info = cardView.getId();
			// the value of current card
			int value = Integer.parseInt(info.substring(0, 1));
			// the color of current card
			Color color = Color.Zi;
			if (info.substring(1).equals("tiao")) {
				color = Color.Tiao;
			} else if (info.substring(1).equals("bing")) {
				color = Color.Bing;
			} else if (info.substring(1).equals("wan")) {
				color = Color.Wan;
			}
			hand.removeDark(new Card(value, color));
			getDarkCards(darkBox);
			setCheckCardImage();
		});
	}

	/**
	 * set up images when clicked to remove bright cards
	 * @param comboBox
	 * @param brightBox
	 */
	private void setRemoveBrightImage(ImageView cardView, HBox comboBox, HBox brightBox) {
		cardView.setOnMouseClicked(x -> {
			ObservableList<Node> combo = comboBox.getChildren();
			// the information of the beginning card
			String info = combo.get(0).getId();
			// get the information of the beginning card
			int value = Integer.parseInt(info.substring(0, 1));
			Color color = Color.Zi;
			if (info.substring(1).equals("tiao")) {
				color = Color.Tiao;
			} else if (info.substring(1).equals("bing")) {
				color = Color.Bing;
			} else if (info.substring(1).equals("wan")) {
				color = Color.Wan;
			}

			// recognize the type of this combo
			ComboType type = ComboType.chow;
			try {
				// the list storing all values in the combo
				ArrayList<Integer> allVal = new ArrayList<Integer>();
				for (Node temp : combo) {
					allVal.add(Integer.parseInt(temp.getId().substring(0, 1)));
				}
				// check if it's a mingkong
				if (allVal.size() == 4) {
					type = ComboType.mingkong;
				} 
				// check if it's a pong or chow
				else if (allVal.size() == 3){
					if (allVal.get(0) == allVal.get(1)) {
						type = ComboType.pong;
					} else {
						type = ComboType.chow;
					}
				}
			} catch (Exception e) {
				type = ComboType.ankong;
			}

			// remove the combo from hand
			hand.removeBright(new Card(value, color), type);
			getBrightCards(brightBox);
			setCheckCardImage();
		});
	}

	/**
	 * helps set up the calculate button
	 * @param Calculate
	 */
	private void setCalculateButton(Button calculate, ComboBox<String> colorBox, ComboBox<String> valueBox, CheckBox checkZiMo) {
		// set up hover for the button
		calculate.setOnMouseEntered(e -> {
			calculate.setStyle("-fx-background-color: #2D8839;");
		});
		calculate.setOnMouseExited(e -> {
			calculate.setStyle("-fx-background-color: #FFFFFF;");
		});
		// set up action when clicked
		calculate.setOnMouseClicked(e -> {
			// the color of winning card
			String colorInfo = colorBox.getSelectionModel().getSelectedItem();
			if (colorInfo == null) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("无效");
				alert.setHeaderText("未输入和牌信息");
				alert.showAndWait();
			} 
			// if there are not enough cards in hand
			else if (!hand.checkFull()){
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("无效");
				alert.setHeaderText("未输入足够手牌");
				alert.showAndWait();
			}
			// if the cards are enough
			else {
				Color color = Color.Zi;
				if (colorInfo.equals("条")) {
					color = Color.Tiao;
				} else if (colorInfo.equals("饼")) {
					color = Color.Bing;
				} else if (colorInfo.equals("万")) {
					color = Color.Wan;
				} 
				// the value of winning card
				String valueInfo = valueBox.getSelectionModel().getSelectedItem();
				int value = 0;
				if (valueInfo.equals("一") || valueInfo.equals("东")) {
					value = 1;
				} else if (valueInfo.equals("二") || valueInfo.equals("南")) {
					value = 2;
				} else if (valueInfo.equals("三") || valueInfo.equals("西")) {
					value = 3;
				} else if (valueInfo.equals("四") || valueInfo.equals("北")) {
					value = 4;
				} else if (valueInfo.equals("五") || valueInfo.equals("中")) {
					value = 5;
				} else if (valueInfo.equals("六") || valueInfo.equals("发")) {
					value = 6;
				} else if (valueInfo.equals("七") || valueInfo.equals("白")) {
					value = 7;
				} else if (valueInfo.equals("八")) {
					value = 8;
				} else if (valueInfo.equals("九")) {
					value = 9;
				} 
				// set up the winning card
				hand.setWinCard(new Card(value, color));
				// check if the hand is a zimo
				if (checkZiMo.isSelected()) {
					hand.setZiMo(true);
				} else {
					hand.setZiMo(false);
				}
				Stage resultStage = new Stage();
				Result result = new Result(this.hand);
				try {
					result.start(resultStage);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				resultStage.show();
			}
		});
	}


	public static void main(String[] args) {
		launch(args);
	}
}

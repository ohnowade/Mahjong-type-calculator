package structure;

import java.util.*;

public class Hand {
	/**
	 * The dark cards on hand
	 */
	private ArrayList<Card> dark;

	/**
	 * The bright cards on hand
	 */
	private ArrayList<Combo> bright;

	/**
	 * the winning card
	 */
	private Card winCard;
	
	/**
	 * indicator of zimo
	 */
	boolean ziMo;

	public Hand() {
		dark = new ArrayList<Card>();
		bright = new ArrayList<Combo>();
	}

	/**
	 * Add a new card to dark side
	 * @param newCard
	 */
	public void addDark(Card newCard) {
		dark.add(newCard);
		sortDark();
	}

	/**
	 * Add a new combo of cards to the bright side
	 */
	public void addBright(Combo newCombo) {
		ArrayList<Card> cards = (ArrayList<Card>) newCombo.getCards();

		// sort the newly added combo through selection sort
		for (int i = 0; i < cards.size(); i++) {
			// the index of the minimum
			int min = i;
			for (int j = i; j < cards.size() - 1; j++) {
				if (cards.get(j + 1).getValue() < cards.get(j).getValue()) {
					min = j + 1;
				}
			}
			Card temp = cards.get(min);
			cards.set(min, cards.get(i));
			cards.set(i, temp);
		}

		bright.add(newCombo);
		sortBright();
	}
	
	/**
	 * removes a card from dark side
	 */
	public void removeDark(Card card) {
		for (Card temp : dark) {
			if (temp.checkEqual(card)) {
				dark.remove(temp);
				break;
			}
		}
		sortDark();
	}
	
	/**
	 * removes a combo from bright side
	 * @param card
	 * @param type
	 */
	public void removeBright(Card card, ComboType type) {
		for (Combo temp : bright) {
			if (temp.getCards().get(0).checkEqual(card) && temp.getType() == type) {
				bright.remove(temp);
				break;
			}
		}
		sortBright();
	}
	
	/**
	 * returns the number of specific card in hand
	 * @param card
	 */
	public int NumOfCard(Card card) {
		// the number to be returned
		int num = 0;
		// count the number of this card
		// check dark side first
		for (Card temp : dark) {
			if (temp.checkEqual(card))
				num ++;
		}
		// then check bright side
		for (Combo temp : bright) {
			for (Card check : temp.getCards()) {
				if (check.checkEqual(card))
					num++;
			}
		}
		
		return num;
	}
	
	/**
	 * checks if there are enough cards in hand
	 * @return
	 */
	public boolean checkFull() {
		return dark.size() + (3 * bright.size()) == 14;
	}

	/**
	 * sets the winning card
	 * @param card
	 */
	public void setWinCard(Card card) {
		this.winCard = card;
	}
	
	/**
	 * set the hand to be a zi mo
	 */
	public void setZiMo(boolean ziMo) {
		this.ziMo = ziMo;
	}

	/**
	 * Sort the cards in dark side in order
	 */
	public void sortDark() {
		// index for loops
		int index = 0;
		// the positions where each partition of colors of card starts and ends
		int[] partition = new int[Color.values().length + 1];
		partition[0] = 0;

		// Sort all cards in the order of color first
		for (int j = 0; j < Color.values().length; j++) {
			for (int i = index; i < dark.size(); i++) {
				if (dark.get(i).getColor() == Color.values()[j]) {
					Card temp = dark.get(index);
					dark.set(index, dark.get(i));
					dark.set(i, temp);
					index++;
				}
			}
			partition[j + 1] = index;
		}

		// in the case where not all four colors are present, fill the partition array to avoid errors
		for (int i = 1; i < partition.length; i++) {
			if (partition[i] == 0) {
				partition[i] = partition[i - 1];
			}
		}

		// then sort the cards in each partition in the order of value
		for (int j = 0; j < partition.length - 1; j++) {
			for (int i = partition[j]; i < partition[j + 1]; i++) {
				int tempIndex = i;
				while (tempIndex > partition[j] && dark.get(tempIndex).getValue() < dark.get(tempIndex - 1).getValue()) {
					Card temp = dark.get(tempIndex - 1);
					dark.set(tempIndex - 1, dark.get(tempIndex));
					dark.set(tempIndex, temp);
					tempIndex--;
				}
			}
		}
	}

	/**
	 * sort combinations in bright hands in order
	 */
	public void sortBright() {
		// index for sorting
		int index = 0;

		for (int i = 0; i < ComboType.values().length; i++) {
			for (int j = 0; j < bright.size(); j++) {
				if (bright.get(j).getType() == ComboType.values()[i]) {
					Combo temp = bright.get(index);
					bright.set(index, bright.get(j));
					bright.set(j, temp);
					index++;
				}
			}
		}
	}

	/**
	 * retrieve the dark hand
	 * @return
	 */
	public ArrayList<Card> getDark() {
		return this.dark;
	}

	/**
	 * retrieve the bright hand
	 * @return
	 */
	public ArrayList<Combo> getBright() {
		return this.bright;
	}

	/**
	 * This method helps divide all cards into different combo
	 * @return
	 */
	public ArrayList<ArrayList<Combo>> recognizeCombo() {
		// there might multiple combinations, so they should all be stored in a data collection
		ArrayList<ArrayList<Combo>> list = new ArrayList<ArrayList<Combo>>();
		// a list indicating whether a card has been checked for pairs
		ArrayList<Card> checkPair = new ArrayList<Card>();

		for (int i = 0; i < dark.size(); i++) {
			Card curCard = dark.get(i);
			boolean unchecked = true;
			// check if current card has been checked for pairs
			for (Card temp : checkPair) {
				if (temp.checkEqual(curCard))
					unchecked = false;
			}
			if (unchecked) {
				// mark the card as checked for pairs and remove the pair from the hand
				checkPair.add(curCard);
				// a temporary list storing identical cards
				ArrayList<Card> tempIdenticals = findIdentical(curCard, dark);
				if (tempIdenticals.size() > 1) {
					// retrieve the two cards and store them
					Combo pair = new Combo(ComboType.pair);
					pair.addCard(tempIdenticals.get(0));
					pair.addCard(tempIdenticals.get(1));
					// a copy of dark hands
					ArrayList<Card> tempDark = new ArrayList<Card>();
					tempDark.addAll(dark);
					tempDark.remove(tempIdenticals.get(0));
					tempDark.remove(tempIdenticals.get(1));
					// now a pair has been taken out from the temporary hand, and check for combo
					findAllCombo(list, tempDark, new ArrayList<Combo>(), pair);
				}
			}
		}

		// check if the hand is a Seven-Pair
		if (checkSevenPairs()) {
			ArrayList<Combo> sevenPair = new ArrayList<Combo>();
			for (int i = 0; i < dark.size() - 1; i++) {
				Combo curPair = new Combo(ComboType.pair);
				curPair.addCard(dark.get(i));
				curPair.addCard(dark.get(++i));
				sevenPair.add(curPair);
			}
			list.add(sevenPair);
		}
		// check if the hand is a ShiSanYao
		else if (checkThirteenOrphans()) {
			Combo yao = new Combo(ComboType.yao);
			for (Card temp : dark) {
				yao.addCard(temp);
			}
			ArrayList<Combo> shiSanYao = new ArrayList<Combo>();
			shiSanYao.add(yao);
			list.add(shiSanYao);
		} 
		// check if the hand is a QiXingBuKao
		else if (checkIndependentSevenStars()) {
			// the combo storing all the zi cards
			Combo yao = new Combo(ComboType.yao);
			// the combo storing everything else
			Combo other = new Combo(ComboType.bukao);
			// retrieve all the zi cards
			for (Card temp : dark) {
				if (temp.getColor() == Color.Zi) {
					yao.addCard(temp);
				} else {
					other.addCard(temp);
				}
			}
			// the list storing the two combo
			ArrayList<Combo> qiXingBuKao = new ArrayList<Combo>();
			qiXingBuKao.add(other);
			qiXingBuKao.add(yao);
			list.add(qiXingBuKao);
		}
		// if it is not a QiXingBuKao, check QuanBuKao
		else if (checkAllIndependent()) {
			// the combo storing all the zi cards
			Combo yao = new Combo(ComboType.yao);
			// the combo storing everything else
			Combo other = new Combo(ComboType.bukao);
			// retrieve all the zi cards
			for (Card temp : dark) {
				if (temp.getColor() == Color.Zi) {
					yao.addCard(temp);
				} else {
					other.addCard(temp);
				}
			}
			// the list storing the two combo
			ArrayList<Combo> qiXingBuKao = new ArrayList<Combo>();
			qiXingBuKao.add(other);
			qiXingBuKao.add(yao);
			list.add(qiXingBuKao);
		} 
		// check if the hand is a ZuHeLong
		else {
			ArrayList<Combo> combo = new ArrayList<Combo>();
			if (checkComposedDragon(combo)) {
				list.add(combo);
			}
		}

		return list;
	}

	/**
	 * calculate all possible hands and find out the largest one
	 * @return
	 */
	public String[] calculate() {
		// all possible hands
		ArrayList<ArrayList<Combo>> allHand = recognizeCombo();
		
		// check if there is any winning type
		if (allHand.size() == 0) {
			String[] noWin = new String[1];
			noWin[0] = "诈胡  罚200";
			return noWin;
		}
		
		// a calculator object helping calculate the fan type
		Calculator calHelp = new Calculator(allHand.get(0), this.bright, this.winCard, this.ziMo);
		// the hand of the largest fan
		String[] largest = calHelp.run();
		// current hand of all cards
		ArrayList<Combo> allCards = calHelp.getAllCards();
		// find the largest fan
		for (ArrayList<Combo> temp : allHand) {
			// a calculator object helping calculate the fan type
			Calculator cal = new Calculator(temp, this.bright, this.winCard, this.ziMo);
			// calculate fan for current type
			String[] check = cal.run();
			// compare current type to the type of largest fan
			if (Integer.parseInt(check[0]) > Integer.parseInt(largest[0])) {
				largest = check;
				allCards = cal.getAllCards();
			}
		}
		
	  largest[0] += "番";
	  
	  // the array of String to be returned
	  String[] allInfo = new String[3];
	  allInfo[0] = largest[0];
	  allInfo[1] = largest[1];
	  allInfo[2] = allCards.toString();
	  return allInfo;
	}

	/**
	 * helps find all possibilities of combo in the hand when a pair has been taken
	 * @param list
	 * @param darkHand
	 * @param visited
	 * @param combos
	 */
	private void findAllCombo(ArrayList<ArrayList<Combo>> list, ArrayList<Card> darkHand, ArrayList<Combo> combos, Combo pair) {
		// check if all cards have been visited and formed combo
		if (darkHand.size() == 0) {
			// add the pair to the combo list
			combos.add(pair);
			// if so, a winning hand is formed and should be stored in the list
			list.add(combos);
			return;
		}

		// check and get combo for currently first remaining card
		Card curCard = darkHand.get(0);

		// check for pong and kong
		ArrayList<Card> identicals = findIdentical(curCard, darkHand);

		// if there are three identical unvisited cards, then it is a pong
		if (identicals.size() == 3) {
			// copy the combo list and hand cards so they won't be affected in later recursions
			ArrayList<Combo> curCombos = new ArrayList<Combo>();
			curCombos.addAll(combos);
			ArrayList<Card> curHands = new ArrayList<Card>();
			curHands.addAll(darkHand);

			// create a new combo and store it in the copied list
			Combo newCombo = new Combo(ComboType.pong);
			for (int j = 0; j < identicals.size(); j++) {
				newCombo.addCard(identicals.get(j));
				curHands.remove(identicals.get(j));
			}
			curCombos.add(newCombo);
			findAllCombo(list, curHands, curCombos, pair);
		} 

		// there is no chow for zi cards
		if (curCard.getColor() != Color.Zi) {
			// check for chow
			ArrayList<Card> flush = findFlush(curCard, darkHand, new ArrayList<Card>());

			// if there are more than two unvisited card in the flush list, then there could be a chow
			if (flush.size() > 2) {
				// copy the combo list and hand cards so they won't be affected in later recursions
				ArrayList<Combo> curCombos = new ArrayList<Combo>();
				curCombos.addAll(combos);
				ArrayList<Card> curHands = new ArrayList<Card>();
				curHands.addAll(darkHand);

				// create a new combo and store it in the copied list
				Combo newCombo = new Combo(ComboType.chow);
				for (int j = 0; j < 3; j++) {
					newCombo.addCard(flush.get(j));
					curHands.remove(flush.get(j));
				}
				curCombos.add(newCombo);
				findAllCombo(list, curHands, curCombos, pair);
			}
		}
	}

	/**
	 * helps check if the winning hand is of the type Seven Pairs
	 * @return
	 */
	private boolean checkSevenPairs() {
		// if there aren't 14 cards in dark hand, it is impossibly seven pairs
		if (dark.size() < 14)
			return false;

		boolean checkSeven = true;
		for (int i = 0; i < dark.size() - 1; i++) {
			if (dark.get(i).checkEqual(dark.get(i + 1))) {
				i++;
			} else {
				checkSeven = false;
				break;
			}
		}

		return checkSeven;
	}

	/**
	 * helps check if the winning hand is of the type ShiSanYao
	 * @return
	 */
	private boolean checkThirteenOrphans() {
		// check if there are 14 cards in dark hand
		if (dark.size() != 14)
			return false;

		// check if any card with color other than Zi and value besides 1 and 9 is present
		for (int i = 2; i < 9; i++) {
			for (Card temp : dark) {
				if (temp.getColor() != Color.Zi && temp.getValue() == i)
					return false;
			}
		}

		// check if cards of all colors are present
		colorLoop:
			for (int i = 0; i < Color.values().length; i++) {
				for (Card temp : dark) {
					if (temp.getColor() == Color.values()[i]) {
						continue colorLoop;
					}
				}
				// if any of the color is not found, it is not a ShiSanYao
				return false;
			}

		//check if all cards have no more than one other identical card in the hand
		for (Card temp : dark) {
			if (findIdentical(temp, dark).size() > 2)
				return false;
		}

		// check if all kinds of Zi are present
		ZiLoop:
			for (int i = 1; i < 8; i++) {
				for (Card temp : dark) {
					if (temp.getColor() == Color.Zi && temp.getValue() == i) {
						continue ZiLoop;
					}
				}
				// if any one of the Zi card is not found, it is not a ShiSanYao
				return false;
			}

		// if all tests are passed, it is a ShiSanYao
		return true;
	}

	/**
	 * helps check if the hand is a QiXingBuKao
	 */
	private boolean checkIndependentSevenStars() {
		// check if there are 14 cards in dark hands
		if (dark.size() != 14)
			return false;

		// the list of card gotten rid of zi cards
		ArrayList<Card> noZi = new ArrayList<Card>();
		noZi.addAll(dark);
		// check if all kind of Zi cards are present
		outer:
			for (int i = 1; i < 8; i++) {
				for (Card temp : dark) {
					if (temp.getColor() == Color.Zi && temp.getValue() == i) {
						noZi.remove(temp);
						continue outer;
					}
				}
				// if any kind of the zi card is not present, it is not the type
				return false;
			}

		// check if there are Zi cards remaining
		for (Card temp : noZi) {
			if (temp.getColor() == Color.Zi)
				return false;
		}

		// make sure three colors are present
		outer:
			for (int i = 0; i < Color.values().length - 1; i++) {
				for (Card temp : noZi) {
					if (temp.getColor() == Color.values()[i]) {
						// find all independent cards of current card
						ArrayList<Card> independent = findIndependent(temp, noZi);
						// if there are no more than two cards in the list, the hand is unqualified for the type
						if (independent.size() < 2) 
							return false;
						// remove these cards from noZi
						for (Card inTemp : independent) {
							noZi.remove(inTemp);
						}
						// check if there is still any card of current color present
						for (Card checkTemp : noZi) {
							if (checkTemp.getColor() == temp.getColor())
								return false;
						}
						// continue for checking next color
						continue outer;
					}
				}
				// if there is a color that is not found, this is an unqualified hand
				return false;
			}

		// if all tests are passed, return true
		return true;
	}

	/**
	 * check if the hand is a QuanBuKao
	 * @return
	 */
	private boolean checkAllIndependent() {
		// check if there are 14 cards in dark hands
		if (dark.size() != 14)
			return false;

		// the list storing all Zi cards
		ArrayList<Card> allZi = new ArrayList<Card>();
		// the list storing no Zi cards
		ArrayList<Card> noZi = new ArrayList<Card>();
		// traverse through dark hand and categorize cards
		for (Card temp : dark) {
			if (temp.getColor() == Color.Zi) {
				allZi.add(temp);
			} else {
				noZi.add(temp);
			}
		}

		// check if there are identical zi cards present
		for (Card temp : allZi) {
			for (Card check : allZi) {
				if (temp != check) {
					if (temp.checkEqual(check))
						return false;
				}
			}
		}

		// make sure three colors are present
		outer:
			for (int i = 0; i < Color.values().length - 1; i++) {
				for (Card temp : noZi) {
					if (temp.getColor() == Color.values()[i]) {
						// find all independent cards of current card
						ArrayList<Card> independent = findIndependent(temp, noZi);
						// remove these cards from noZi
						for (Card inTemp : independent) {
							noZi.remove(inTemp);
						}
						// check if there is still any card of current color present
						for (Card checkTemp : noZi) {
							if (checkTemp.getColor() == temp.getColor())
								return false;
						}
						// continue for checking next color
						continue outer;
					}
				}
				// if there is a color that is not found, this is an unqualified hand
				return false;
			}

		// if all tests are passed, return true
		return true;
	}

	/**
	 * check if the hand is a ZuHeLong
	 * @return
	 */
	@SuppressWarnings("incomplete-switch")
	private boolean checkComposedDragon(ArrayList<Combo> combo) {
		// a copy of the dark hand
		ArrayList<Card> noIn = new ArrayList<Card>();
		noIn.addAll(dark);
		// check if the independent combo of a color is present
		boolean[] presentCol = new boolean[3];
		// the combo containing all independent combo
		Combo comp = new Combo(ComboType.bukao);

		// make sure all independent combo are present
		outer:
			for (int i = 1; i < 4; i++) {
				// remove all independent combo from the list
				for (Card temp : noIn) {
					if (temp.getValue() == i) {
						ArrayList<Card> ind = findIndependent(temp, noIn);
						// check if the card has at least two independent cards
						if (ind.size() > 2) {
							// the mapped integer of current card's color
							int num = 0;
							// map the integer to the color of the card
							switch (temp.getColor()) {
							case Tiao: num = 0;
							break;
							case Bing: num = 1;
							break;
							case Wan: num = 2;
							}
							// check if the color of independent combo has been present
							if (presentCol[num]) {
								return false;
							} else {
								presentCol[num] = true;
							}
							// if the independent combo of current color was not present, remove the combo from the list 
							for (Card rem : ind) {
								noIn.remove(rem);
								comp.addCard(rem);
							}
							continue outer;
						}
					}
				}
				// if any of the independent combo is not found, the hand is not ZuHeLong
				return false;
			}

		combo.add(comp);

		// then decide if the remaining card could form a normal winning hand
		// if there are only two cards remaining, check if they are a pair
		if (noIn.size() == 2) {
			// check if there is a pair
			ArrayList<Card> pair = findIdentical(noIn.get(0), noIn);
			if (pair.size() == 2) {
				Combo dui = new Combo(ComboType.pair);
				for (Card add : pair) {
					dui.addCard(add);
				}
				// add the pair to the combo list
				combo.add(dui);
				return true;
			} else {
				return false;
			}
		} else {
			for (Card temp : noIn) {
				// the identical cards
				ArrayList<Card> identical = findIdentical(temp, noIn);
				// check if there could be a pong
				if (identical.size() > 2) {
					// the pong combo
					Combo pong = new Combo(ComboType.pong);
					for (Card add : identical) {
						pong.addCard(add);
					}
					// add the combo to the list
					combo.add(pong);
					noIn.removeAll(identical);
					// check if there is a pair
					ArrayList<Card> pair = findIdentical(noIn.get(0), noIn);
					if (pair.size() == 2) {
						Combo dui = new Combo(ComboType.pair);
						for (Card add : pair) {
							dui.addCard(add);
						}
						// add the pair to the combo list
						combo.add(dui);
						return true;
					} else {
						return false;
					}
				}
				// the flushing cards
				ArrayList<Card> flush = findFlush(temp, noIn, new ArrayList<Card>());
				// check if there could be a chow
				if (flush.size() > 2) {
					// the pong combo
					Combo chow = new Combo(ComboType.chow);
					for (Card add : flush) {
						chow.addCard(add);
					}
					// add the combo to the list
					combo.add(chow);
					noIn.removeAll(flush);
					// check if there is a pair
					ArrayList<Card> pair = findIdentical(noIn.get(0), noIn);
					if (pair.size() == 2) {
						Combo dui = new Combo(ComboType.pair);
						for (Card add : pair) {
							dui.addCard(add);
						}
						// add the pair to the combo list
						combo.add(dui);
						return true;
					} else {
						return false;
					}				
				}
			}
		}

		// if the remaining cards cnnot form a winning hand
		return false;
	}

	/**
	 * This helps find identical cards in the hand as the passed in card
	 * @param card
	 * @return
	 */
	private ArrayList<Card> findIdentical(Card card, ArrayList<Card> list) {
		// the list containing all identical cards as the passed in one
		ArrayList<Card> identicals = new ArrayList<Card>();
		// traverse through the dark hands and find all identical cards
		for (int i = 0; i < list.size(); i++) {
			Card curCard = list.get(i);
			if (curCard.checkEqual(card))
				identicals.add(curCard);
		}

		return identicals;
	}

	/**
	 * This helps find all cards that could form a flush as the passed in card
	 * @param card
	 * @param list
	 * @return
	 */
	private ArrayList<Card> findFlush(Card card, ArrayList<Card> list, ArrayList<Card> flush) {
		flush.add(card);
		for (int i = 0; i < list.size(); i++) {
			if (card.checkNext(list.get(i))) {
				return findFlush(list.get(i), list, flush);
			}
		}
		return flush;
	}

	/**
	 * helps find all cards that are 3 different from each other
	 * @return
	 */
	private ArrayList<Card> findIndependent(Card card, ArrayList<Card> list) {
		// the list to be returned
		ArrayList<Card> independent = new ArrayList<Card>();
		// current number to be found
		for (int i = card.getValue(); i < 10; i+=3) {
			for (Card temp : list) {
				if (temp.getColor() == card.getColor()
						&& temp.getValue() == i) {
					independent.add(temp);
					break;
				}
			}
		}
		return independent;
	}

}

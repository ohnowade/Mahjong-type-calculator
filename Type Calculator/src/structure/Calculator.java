package structure;
import java.util.*;

public class Calculator {
	/**
	 * The hand of combinations 
	 */
	private ArrayList<Combo> hand;

	/**
	 * The hand of dark combinations
	 */
	private ArrayList<Combo> dark;

	/**
	 * The hand of bright combinations
	 */
	private ArrayList<Combo> bright;

	/**
	 * the cards that win the hand
	 */
	private Card winCard;

	/**
	 * indicator if the hand is won by Zi Mo
	 */
	private boolean ziMo;

	/**
	 * the constructor taking a hand of cards as argument
	 * @param hand
	 */
	public Calculator(ArrayList<Combo> dark, ArrayList<Combo> bright, Card winCard, boolean ziMo) {
		this.dark = dark;
		this.bright = bright;
		this.winCard = winCard;
		hand = new ArrayList<Combo>();
		hand.addAll(dark);
		hand.addAll(bright);
		this.ziMo = ziMo;
	}

	public String[] run() {
		// the number of fans
		int fan = 0;
		// the winning information
		String info = "";

		// calculate fan number
		if (checkDaSiXi()) {
			fan += 88;
			info += "大四喜+88 ";
		}
		if (checkDaSanYuan()) {
			fan += 88;
			info += "大三元+88 ";
		}	
		if (checkLyuYiSe()) {
			fan += 88;
			info += "绿一色+88 ";
		}	
		if (checkJiuLianBaoDeng()) {
			fan += 88;
			info += "九莲宝灯+88 ";
		}	
		if (checkSiGang()) {
			fan += 88;
			info += "四杠+88 ";
		}	
		if (checkLianQiDui()) {
			fan += 88;
			info += "连七对+88 ";
		}	
		if (checkShiSanYao()) {
			fan += 88;
			info += "十三幺+88 ";
		}
		if (checkQingYaoJiu()) {
			fan += 64;
			info += "清幺九+64 ";
		}
		if (checkXiaoSiXi()) {
			fan += 64;
			info += "小四喜+64 ";
		}
		if (checkXiaoSanYuan()) {
			fan += 64;
			info += "小三元+64 ";
		}
		if (checkZiYiSe()) {
			fan += 64;
			info += "字一色+64 ";
		}
		if (checkSiAnKe()) {
			fan += 64;
			info += "四暗刻+64 ";
		}
		if (checkYiSeShuangLongHui()) {
			fan += 64;
			info += "一色双龙会+64 ";
		}
		if (checkYiSeSiTongShun()) {
			fan += 48;
			info += "一色四同顺+48 ";
		}
		if (checkYiSeSiJieGao()) {
			fan += 48;
			info += "一色四节高+48 ";
		}
		if (checkYiSeSiBuGao()) {
			fan += 32;
			info += "一色四步高+32 ";
		}
		if (checkSanGang()) {
			fan += 32;
			info += "三杠+32 ";
		}
		if (checkHunYaoJiu()) {
			fan += 32;
			info += "混幺九+32 ";
		}
		if (checkQiXiaoDui()) {
			fan += 24;
			info += "七小对+24 ";
		}
		if (checkQiXingBuKao()) {
			fan += 24;
			info += "七星不靠+24 ";
		}
		if (checkQuanShuangKe()) {
			fan += 24;
			info += "全双刻+24 ";
		}
		if (checkQingYiSe()) {
			fan += 24;
			info += "清一色+24 ";
		}
		if (checkYiSeSanTongShun()) {
			fan += 24;
			info += "一色三同顺+24 ";
		}
		if (checkYiSeSanJieGao()) {
			fan += 24;
			info += "一色三节高+24 ";
		}
		if (checkQuanDa()) {
			fan += 24;
			info += "全大+24 ";
		}
		if (checkQuanZhong()) {
			fan += 24;
			info += "全中+24 ";
		}
		if (checkQuanXiao()) {
			fan += 24;
			info += "全小+24 ";
		}
		if (checkQingLong()) {
			fan += 16;
			info += "清龙+16 ";
		}
		if (checkSanSeShuangLongHui()) {
			fan += 16;
			info += "三色双龙会+16 ";
		}
		if (checkYiSeSanBuGao()) {
			fan += 16;
			info += "一色三步高+16 ";
		}
		if (checkQuanDaiWu()) {
			fan += 16;
			info += "全带五+16 ";
		}
		if (checkSanTongKe()) {
			fan += 16;
			info += "三同刻+16 ";
		}
		if (checkSanAnKe()) {
			fan += 16;
			info += "三暗刻+16 ";
		}
		if (checkQuanBuKao()) {
			fan += 12;
			info += "全不靠+12 ";
		}
		if (checkZuHeLong()) {
			fan += 12;
			info += "组合龙+12 ";
		}
		if (checkDaYuWu()) {
			fan += 12;
			info += "大于五+12 ";
		}
		if (checkXiaoYuWu()) {
			fan += 12;
			info += "小于五+12 ";
		}
		if (checkSanFengKe()) {
			fan += 12;
			info += "三风刻+12 ";
		}
		if (checkHuaLong()) {
			fan += 8;
			info += "花龙+8 ";
		}
		if (checkTuiBuDao()) {
			fan += 8;
			info += "推不倒+8 ";
		}
		if (checkSanSeSanTongShun()) {
			fan += 8;
			info += "三色三同顺+8 ";
		}
		if (checkSanSeSanJieGao()) {
			fan += 8;
			info += "三色三节高+8 ";
		}
		if (checkPengPengHu()) {
			fan += 6;
			info += "碰碰胡+6 ";
		}
		if (checkHunYiSe()) {
			fan += 6;
			info += "混一色+6 ";
		}
		if (checkSanSeSanBuGao()) {
			fan += 6;
			info += "三色三步高+6 ";
		}
		if (checkWuMenQi()) {
			fan += 6;
			info += "五门齐+6 ";
		}
		if (checkQuanQiuRen()) {
			fan += 6;
			info += "全求人+6 ";
		}
		if (checkShuangAnGang()) {
			fan += 6;
			info += "双暗杠+6 ";
		}
		if (checkShuangJianKe()) {
			fan += 6;
			info += "双箭刻+6 ";
		}
		if (checkQuanDaiYao()) {
			fan += 4;
			info += "全带幺+4 ";
		}
		if (checkBuQiuRen()) {
			fan += 4;
			info += "不求人+4 ";
		}
		if (checkShuangMingGang()) {
			fan += 4;
			info += "双明杠+4 ";
		}
		if (checkJianKe()) {
			fan += 2;
			info += "箭刻+2 ";
		}
		if (checkMenQianQing()) {
			fan += 2;
			info += "门前清+2 ";
		}
		if (checkPingHu()) {
			fan += 2;
			info += "平和+2 ";
		}
		if (checkSiGuiYi() != 0) {
			for (int i = 0; i < checkSiGuiYi(); i++) {
				fan += 2;
				info += "四归一+2 ";
			}
		}
		if (checkShuangTongKe().size() != 0) {
			for (int i = 0; i < checkShuangTongKe().size() / 2; i++) {
				fan += 2;
				info += "双同刻+2 ";
			}
		}
		if (checkShuangAnKe()) {
			fan += 2;
			info += "双暗刻+2 ";
		}
		if (checkAnGang()) {
			fan += 2;
			info += "暗杠+2 ";
		}
		if (checkDuanYao()) {
			fan += 2;
			info += "断幺+2 ";
		}
		if (checkYiBanGao().size() != 0) {
			for (int i = 0; i < checkYiBanGao().size() / 2; i++) {
				fan += 1;
				info += "一般高+1 ";
			}
		}
		if (checkXiXiangFeng().size() != 0) {
			for (int i = 0; i < checkXiXiangFeng().size() / 2; i++) {
				fan += 1;
				info += "喜相逢+1 ";
			}
		}
		if (checkLianLiu().size() != 0) {
			for (int i = 0; i < checkLianLiu().size() / 2; i++) {
				fan += 1;
				info += "连六+1 ";
			}
		}
		if (checkLaoShaoFu().size() != 0) {
			for (int i = 0; i < checkLaoShaoFu().size() / 2; i++) {
				fan += 1;
				info += "老少副+1 ";
			}
		}
		if (checkYaoJiuKe()) {
			fan += 1;
			info += "幺九刻+1 ";
		}
		if (checkMingGang()) {
			fan += 1;
			info += "明杠+1 ";
		}
		if (checkQueYiMen()) {
			fan += 1;
			info += "缺一门+1 ";
		}
		if (checkWuZi()) {
			fan += 1;
			info += "无字+1 ";
		}
		if (checkBianZhang()) {
			fan += 1;
			info += "边张+1 ";
		}
		if (checkKanZhang()) {
			fan += 1;
			info += "坎张+1 ";
		}
		if (checkDanDiaoJiang()) {
			fan += 1;
			info += "单钓将+1 ";
		}
		if (checkZiMo()) {
			fan += 1;
			info += "自摸+1 ";
		}
		
		// the string array that would be finally returned
		String[] all = new String[2];
		all[0] = "" + fan;
		all[1] = info;
		
		return all;
	}
	
	/**
	 * retrieve current hand
	 * @return
	 */
	public ArrayList<Combo> getAllCards() {
		return hand;
	}

	/**
	 * helps check if all cards in hand are of the same color
	 * @return
	 */
	private boolean checkSameColorHelper() {
		if (hand.size() < 3)
			return false;
		
		for (int i = 0; i < hand.size() - 1; i++) {
			if (hand.get(i).getCards().get(0).getColor() != 
					hand.get(i + 1).getCards().get(0).getColor()) {
				return false;
			}
		}
		// if the first card of every combe has the same color as the one of its next combo, starting from the first combo,
		// all cards are of the same color
		return true;
	}

	/**
	 * count the number of LaoShaoFu in hand
	 * @return
	 */
	private ArrayList<Combo> getLaoShaoFuHelper() {
		// deep copy of hand
		ArrayList<Combo> cards = new ArrayList<Combo>();
		cards.addAll(hand);
		// the list to be returned storing all LaoShaoFu
		ArrayList<Combo> all = new ArrayList<Combo>();

		// traverse through and count the number of LaoShaoFu
		out:
			while (cards.size() > 1) {
				for (Combo temp : cards) {
					if (temp.getType() == ComboType.chow &&
							temp.getCards().get(0).getValue() == 1) {
						for (Combo check : cards) {
							if (check.getType() == ComboType.chow
									&& check.getCards().get(0).getColor() == temp.getCards().get(0).getColor()
									&& check.getCards().get(0).getValue() == 7) {
								all.add(temp);
								all.add(check);
								cards.remove(temp);
								cards.remove(check);
								continue out;
							}
						}
					}
				}
				break out;
			}
		return all;
	}

	///////////////////////////////////////////////////////////////////// 88 Fan ////////////////////////////////////////////////////////////////

	/**
	 * helps check if the hand is a DaSiXi
	 */
	private boolean checkDaSiXi() {
		// check if all four kinds of Feng are present
		outer:
			for (int i = 1; i < 5; i++) {
				for (Combo temp : hand) {
					// exclude pairs
					if (temp.getType() == ComboType.pong 
							|| temp.getType() == ComboType.ankong
							|| temp.getType() == ComboType.mingkong) {
						if (temp.getCards().get(0).checkEqual(new Card(i, Color.Zi))) {
							// if found then start next round of loop right away so that following two lines would not be executed
							continue outer;
						}
					}
				}
				// if any one of the Fengs is not found, the hand is not a DaSiXi
				return false;
			}

	// if all feng pongs are found
	return true;
	}

	/**
	 * check if the hand is a DaSanYuan
	 * @return
	 */
	private boolean checkDaSanYuan() {
		// check if all four kinds of Feng are present
		outer:
			for (int i = 5; i < 8; i++) {
				for (Combo temp : hand) {
					// exclude pairs
					if (temp.getType() == ComboType.pong 
							|| temp.getType() == ComboType.ankong
							|| temp.getType() == ComboType.mingkong) {
						if (temp.getCards().get(0).checkEqual(new Card(i, Color.Zi))) {
							// if found then start next round of loop right away so that following two lines would not be executed
							continue outer;
						}
					}
				}
				// if any one of the Fengs is not found, the hand is not a DaSiXi
				return false;
			}
	// if all feng pongs are found
	return true;
	}

	/**
	 * helps check if the hand is a LyuYiSe
	 * @return
	 */
	private boolean checkLyuYiSe() {
		// run through every card in every combo and check if it is within the range
		for (Combo temp : hand) {
			for (Card card : temp.getCards()) {
				if (!(card.checkEqual(new Card(2, Color.Tiao)) ||
						card.checkEqual(new Card(3, Color.Tiao)) ||
						card.checkEqual(new Card(4, Color.Tiao)) ||
						card.checkEqual(new Card(6, Color.Tiao)) ||
						card.checkEqual(new Card(8, Color.Tiao)) ||
						card.checkEqual(new Card(6, Color.Zi)))) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * checks if the hand is a JiuLianBaoDeng, which requires nothing on the bright side
	 * @return
	 */
	private boolean checkJiuLianBaoDeng() {
		// check if there are any bright cards
		if (bright.size() != 0)
			return false;
		// check if all cards are of the same color
		if (!checkSameColorHelper())
			return false;

		// the necessary cards for a JiuLianBaoDeng
		int[] need = new int[] {1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9};
		// retrieve the value of all cards
		ArrayList<Integer> cardNum = new ArrayList<Integer>();
		for (Combo temp : dark) {
			for (Card card : temp.getCards()) {
				cardNum.add(card.getValue());
			}
		}

		// check if all values are present in dark hand
		for (int temp : need) {
			if (!cardNum.contains(temp)) {
				return false;
			} else {
				cardNum.remove(new Integer(temp));
			}
		}

		// if all tests are passed, it is a JiuLianBaoDeng
		return true;
	}

	/**
	 * helps check if the hand is a siGang, containing four kongs
	 * @return
	 */
	private boolean checkSiGang() {
		// the number of kongs
		int GangNum = 0;

		// traverse through the hand list and count the number of kongs
		for (Combo temp : hand) {
			if (temp.getType() == ComboType.ankong || temp.getType() == ComboType.mingkong)
				GangNum++;
		}

		return GangNum == 4;
	}

	/**
	 * helps check if the hand is composed of seven consecutive pairs
	 * @return
	 */
	private boolean checkLianQiDui() {
		// check if bright is none first
		if (bright.size() != 0)
			return false;
		// check if there are all pairs in dark
		for (Combo temp : dark) {
			if (temp.getType() != ComboType.pair)
				return false;
		}
		// check if every combo has the same color
		if (!checkSameColorHelper())
			return false;

		// find the least value among all cards in the list
		int min = dark.get(0).getCards().get(0).getValue();
		for (Combo temp : dark) {
			int curVal = temp.getCards().get(0).getValue();
			if (curVal < min)
				min = curVal;
		}
		// check if the next six values are all present
		outer:
			for (int i = min + 1; i < min + 7; i ++) {
				for (Combo temp : dark) {
					int curVal = temp.getCards().get(0).getValue();
					if (curVal == i)
						continue outer;
				}
				// if any of the six value is not found, it is not a LianQiDui
				return false;
			}

		// all tests are passed
		return true;
	}

	/**
	 * helps check if the hand is a ShiSanYao. Because it is already checked in hand, only need to recognize a list of
	 * combo with null type here.
	 * @return
	 */
	private boolean checkShiSanYao() {
		return dark.size() == 1 && dark.get(0).getType() == ComboType.yao;
	}

	/////////////////////////////////////////////////////////////////////// 64 Fan ///////////////////////////////////////////////////////////////////

	/**
	 * helps check if the hand is composed of cards with values of only one and nine
	 * @return
	 */
	private boolean checkQingYaoJiu() {
		// if any of the card is a Zi card, the hand is not a QingYaoJiu, or any of the combo is not regular
		for (Combo temp : hand) {
			if (temp.getCards().get(0).getColor() == Color.Zi
					|| temp.getType() == ComboType.chow
					|| temp.getType() == ComboType.bukao
					|| temp.getType() == ComboType.yao)
				return false;
		}

		// traverse through the hand and check if any of the cards has the value other than 1 or 9
		for (Combo temp : hand) {
			if (temp.getCards().get(0).getValue() > 1 && temp.getCards().get(0).getValue() < 9)
				return false;
		}

		// if all cards are of value 1 or 9, it is a QingYaoJiu
		return true;
	}

	/**
	 * helps check if the hand is a XiaoSiXi
	 * @return
	 */
	private boolean checkXiaoSiXi() {
		// Count the number of expected combo
		int num = 0;

		// traverse through hand and look for pongs, kongs and pairs
		for (Combo temp : hand) {
			// check for pair first
			if (temp.getType() == ComboType.pair) {
				if (temp.getCards().get(0).getColor() != Color.Zi
						|| temp.getCards().get(0).getValue() >= 5)
					return false;
			}
			// then count the number of Zi pongs or kongs
			else if (temp.getType() == ComboType.pong || temp.getType() == ComboType.ankong
					|| temp.getType() == ComboType.mingkong) {
				if (temp.getCards().get(0).getColor() == Color.Zi
						&& temp.getCards().get(0).getValue() < 5)
					num++;
			}
		}
		// check if the number is 3
		return num == 3;
	}

	/**
	 * helps check if the hand is a XiaoSanYuan
	 * @return
	 */
	private boolean checkXiaoSanYuan() {
		// count the number of qualified combo
		int num = 0;

		// traverse through hand and look for pongs, kongs and pairs
		for (Combo temp : hand) {
			// check for pair first
			if (temp.getType() == ComboType.pair) {
				if (temp.getCards().get(0).getColor() != Color.Zi
						|| temp.getCards().get(0).getValue() < 5)
					return false;
			}
			// then count the number of Zi pongs or kongs
			else if (temp.getType() == ComboType.pong || temp.getType() == ComboType.ankong
					|| temp.getType() == ComboType.mingkong) {
				if (temp.getCards().get(0).getColor() == Color.Zi
						&& temp.getCards().get(0).getValue() >= 5)
					num++;
			}
		}
		// check if the number is 3
		return num == 2;
	}

	/**
	 * Check if the hand is composed of pure Zi Card
	 * @return
	 */
	private boolean checkZiYiSe() {
		// traverse through the hand and check every combo
		for (Combo temp : hand) {
			// if any of the card is not of the color Zi, it is not a ZiYiSe
			if (temp.getCards().get(0).getColor() != Color.Zi)
				return false;
		}
		// all cards have the color Zi
		return true;
	}

	/**
	 * check if the hand has four dark pongs or kongs in total
	 */
	private boolean checkSiAnKe() {
		// dark hand should be checked for pongs and bright hand should be checked for AnKong
		// the number of qualified combo
		int num = 0;
		// check dark hand first for pongs
		for (Combo temp : dark) {
			if (temp.getType() == ComboType.pong)
				num++;
		}
		// then check bright hand for ankong
		for (Combo temp : bright) {
			if (temp.getType() == ComboType.ankong)
				num++;
		}
		// check if the number is four
		return num == 4;
	}

	/**
	 * check if the hand is composed of two LaoShaoFu with 5 being the pair
	 * @return
	 */
	private boolean checkYiSeShuangLongHui() {
		// check if it's a QingYiSe first
		if (!checkSameColorHelper())
			return false;
		// check if the pair is of value 5
		for (Combo temp : hand) {
			if (temp.getType() == ComboType.pair) {
				if (temp.getCards().get(0).getValue() != 5)
					return false;
			}
		}
		// check for LaoShaoFu
		ArrayList<Combo> all = getLaoShaoFuHelper();
		// check if there are four in total
		if (all.size() != 4)
			return false;
		// check if there two of each kind
		int num = 0;
		// if the number of chow starting from 1 is not 2, the number of another one would not be 2
		for (Combo temp : all) {
			if (temp.getCards().get(0).getValue() == 1)
				num++;
		}
		if (num != 2)
			return false;
		// if all tests passed, it is a valid one
		return true;
	}

	////////////////////////////////////////////////////////////// 48 Fan //////////////////////////////////////////////////////////////////////////////

	/**
	 * helps check if the hand is composed of four identical flushed
	 * @return
	 */
	private boolean checkYiSeSiTongShun() {
		// the list of combo in which the pair is removed
		ArrayList<Combo> noPair = new ArrayList<Combo>();

		// check if all combo, except for the pair, are chow
		for (Combo temp : hand) {
			if (temp.getType() != ComboType.pair) {
				if (temp.getType() != ComboType.chow) {
					return false;
				}
				noPair.add(temp);
			}
		}
		
		// check if it's a seven pair
		if (noPair.size() == 0)
			return false;
		
		// check if all chow combo are identical in terms of values and colors
		for (int i = 0; i < noPair.size() - 1; i++) {
			if (!noPair.get(i).getCards().get(0).checkEqual(noPair.get(i + 1).getCards().get(0)))
				return false;
		}

		// if all tests are passed, return true
		return true;
	}

	private boolean checkYiSeSiJieGao() {
		// the list of combo in which the pair is removed
		ArrayList<Combo> noPair = new ArrayList<Combo>();

		// check if all combo, except for the pair, are pongs or kongs
		for (Combo temp : hand) {
			if (temp.getType() != ComboType.pair) {
				if (temp.getType() != ComboType.pong
						&& temp.getType() != ComboType.ankong
						&& temp.getType() != ComboType.mingkong
						|| temp.getCards().get(0).getColor() == Color.Zi ) {
					return false;
				}
				noPair.add(temp);
			}
		}
		
		// check if it is a seven pair
		if (noPair.size() == 0)
			return false;

		// check if the remaining cards are of the same color
		for (int i = 0; i < noPair.size() - 1; i++) {
			if (noPair.get(i).getCards().get(0).getColor() != 
					noPair.get(i + 1).getCards().get(0).getColor())
				return false;
		}

		// look for the least value
		int min = noPair.get(0).getCards().get(0).getValue();
		for (Combo temp : noPair) {
			int cur = temp.getCards().get(0).getValue();
			if (cur < min) {
				min = cur;
			}
		}

		// check if the four consecutive values are present
		outer:
			for (int i = min; i < min + 4; i++) {
				for (Combo temp : noPair) {
					if (temp.getCards().get(0).getValue() == i) {
						continue outer;
					}
				}
				// if any of the number is not found, this is an unqualified hand
				return false;
			}

		// if all tests are passed, return true
		return true;
	}

	///////////////////////////////////////////////////////////////////// 32 Fan /////////////////////////////////////////////////////////////////////
	/**
	 * check if the hand has four flushes that each one is increaseing by 1 or 2
	 * @return
	 */
	private boolean checkYiSeSiBuGao() {
		// the list of combo in which the pair is removed
		ArrayList<Combo> noPair = new ArrayList<Combo>();

		// check if all combo, except for the pair, are chow
		for (Combo temp : hand) {
			if (temp.getType() != ComboType.pair) {
				if (temp.getType() != ComboType.chow) {
					return false;
				}
				noPair.add(temp);
			}
		}

		// check if it is a seven pair
		if (noPair.size() == 0)
			return false;
		
		// check if the remaining cards are of the same color
		for (int i = 0; i < noPair.size() - 1; i++) {
			if (noPair.get(i).getCards().get(0).getColor() != 
					noPair.get(i + 1).getCards().get(0).getColor())
				return false;
		}

		// look for the least value
		int min = noPair.get(0).getCards().get(0).getValue();
		for (Combo temp : noPair) {
			int cur = temp.getCards().get(0).getValue();
			if (cur < min) {
				min = cur;
			}
		}

		// check if four chows increasing by 1 are present
		boolean increaseBy1 = true;
		outer:
			for (int i = min; i < min + 4; i++) {
				for (Combo temp : noPair) {
					if (temp.getCards().get(0).getValue() == i) {
						continue outer;
					}
				}
				// if any of the number is not found, this is an unqualified hand
				increaseBy1 = false;
				break;
			}

		// if the hand has no four chows increasing by 1, check if there are by 2
		if (!increaseBy1) {
			outer:
				for (int i = min; i < min + 8; i += 2) {
					for (Combo temp : noPair) {
						if (temp.getCards().get(0).getValue() == i) {
							continue outer;
						}
					}
					// if any of the number is not found, this is an unqualified hand
					return false;
				}
		}

		// if all tests are passed, it is a YiSeSiBuGao
		return true;
	}

	/**
	 * helps check if the hand has three kongs
	 * @return
	 */
	private boolean checkSanGang() {
		// exclude higher-level type
		if (checkSiGang())
			return false;

		// the number of kongs
		int num = 0;
		// count the number kongs
		for (Combo temp : bright) {
			if (temp.getType() == ComboType.ankong || temp.getType() == ComboType.mingkong)
				num++;
		}
		return num == 3;
	}

	/**
	 * helps check if the hand only has cards of color Zi or value of 1 or 9
	 * @return
	 */
	private boolean checkHunYaoJiu() {
		// traverse through the hand and check if any of the cards has the value other than 1 or 9
		for (Combo temp : hand) {
			if (temp.getCards().get(0).getColor() != Color.Zi) {
				if (temp.getCards().get(0).getValue() > 1 && temp.getCards().get(0).getValue() < 9) {
					return false;
				}
			}
		}
		// check if there are Zi cards
		boolean ziPresent = false;
		for (Combo temp : hand) {
			if (temp.getCards().get(0).getColor() == Color.Zi) {
				ziPresent = true;
				break;
			}
		}

		return ziPresent;
	}

	/////////////////////////////////////////////////////////////////// 24 Fan ////////////////////////////////////////////////////////////////////////////

	/**
	 * helps check if the hand is composed of seven pairs 
	 * @return
	 */
	private boolean checkQiXiaoDui() {
		// exclude higher-level type
		if (checkLianQiDui() || checkYiSeShuangLongHui())
			return false;

		// check if there are 7 combo in dark
		int comboNum = 0;
		for (int i = 0; i < dark.size(); i++) {
			comboNum++;
		}
		if (comboNum != 7)
			return false;

		// check if there are all pairs in dark
		for (Combo temp : dark) {
			if (temp.getType() != ComboType.pair)
				return false;
		}
		// if there are only pairs, return true
		return true;
	}

	/**
	 * helps check if the hand is a QiXingBuKao
	 * @return
	 */
	private boolean checkQiXingBuKao() {
		return dark.size() == 2 && dark.get(1).getType() == ComboType.yao &&
				dark.get(1).getCards().size() == 7;
	}

	/**
	 * checks if the hand is composed of only pongs or kongs, in all of which the cards are of even values
	 * @return
	 */
	private boolean checkQuanShuangKe() {
		// check, besides the pair, if all combo are pongs
		for (Combo temp : hand) {
			// check if there are any zi cards
			if (temp.getCards().get(0).getColor() == Color.Zi)
				return false;

			if (temp.getType() != ComboType.pair) {
				if (temp.getType() != ComboType.pong
						&& temp.getType() != ComboType.ankong
						&& temp.getType() != ComboType.mingkong)
					return false;
			}
		}
		// check if all cards are of even value
		for (Combo temp : hand) {
			if (temp.getCards().get(0).getValue() % 2 != 0)
				return false;
		}
		// all tests are passed, return true
		return true;
	}

	/**
	 * checks if all cards in hand are of the same color
	 * @return
	 */
	private boolean checkQingYiSe() {
		// exclude higher-level type
		if (checkJiuLianBaoDeng() || checkLianQiDui() || checkZiYiSe()
				|| checkYiSeShuangLongHui())
			return false;

		return checkSameColorHelper();
	}

	/**
	 * check if the hand has three identical flushes
	 * @return
	 */
	private boolean checkYiSeSanTongShun() {
		// exclude higher-level type
		if (checkYiSeSiTongShun() || checkYiSeSiJieGao())
			return false;

		// check every combo in hand, and if there are three identical ones
		for (Combo temp : hand) {
			if (temp.getType() == ComboType.chow) {
				// the number of identical combo
				int num = 0;
				for (Combo check : hand) {
					// if there is an identical combo, increment num
					if (temp.checkEqual(check)) {
						num++;
						// if there are three identical combo, this is a qualified hand
						if (num == 3) {
							return true;
						}
					}
				}
			}
		}
		// if a combo with two other identical combo does not exist, return false
		return false;
	}

	/**
	 * check if the hand contains three pongs, among which the cards are increasing by 1
	 * @return
	 */
	private boolean checkYiSeSanJieGao() {
		// exclude higher-level type
		if (checkYiSeSiTongShun() || checkYiSeSiJieGao())
			return false;

		// the list of all other combo that have the same color as current one
		ArrayList<Combo> sameCol = new ArrayList<Combo>();
		for (Combo temp : hand) {
			if ((temp.getType() == ComboType.pong 
					|| temp.getType() == ComboType.mingkong
					|| temp.getType() == ComboType.ankong) 
					&& temp.getCards().get(0).getColor() != Color.Zi) {
				// the list of all other combo that have the same color as current one
				sameCol = new ArrayList<Combo>();
				// search for combo of same color
				for (Combo check : hand) {
					if (check.getType() == ComboType.pong
							|| check.getType() == ComboType.mingkong
							|| check.getType() == ComboType.ankong) {
						if (temp.getCards().get(0).getColor() == check.getCards().get(0).getColor())
							sameCol.add(check);
					}
				}
				// check if there are at least three qualified combo
				if (sameCol.size() > 2) {
					break;
				}
			}
		}

		// check if there are enough pongs
		if (sameCol.size() < 3)
			return false;

		while (sameCol.size() >= 3) {
			// the minimum combo
			Combo minCom = sameCol.get(0);
			// look for the minimum in the pongs
			int min = sameCol.get(0).getCards().get(0).getValue();
			for (Combo temp : sameCol) {
				int cur = temp.getCards().get(0).getValue();
				if (cur < min) {
					min = cur;
					minCom = temp;
				}
			}

			// the indicator of presence of order
			boolean pres = true;
			// check if the three consecutive values are present
			outer:
				for (int i = min; i < min + 3; i++) {
					for (Combo temp : sameCol) {
						if (temp.getCards().get(0).getValue() == i) {
							continue outer;
						}
					}
					// if any of the number is not found, start over again and begin with the next combo
					pres = false;
					sameCol.remove(minCom);
				}

			// check the result of the test
			if (pres)
				return true;
		}

		//if the order does not exist
		return false;
	}

	/**
	 * checks if the cards are all larger than 6
	 * @return
	 */
	private boolean checkQuanDa() {
		// traverse through all cards, check if any of them is less then 7
		for (Combo temp : hand) {
			if (temp.getType() == ComboType.bukao || temp.getType() == ComboType.yao)
				return false;
			if (temp.getCards().get(0).getValue() < 7
					|| temp.getCards().get(0).getColor() == Color.Zi)
				return false;
		}
		// if all of the cards are larger than 6
		return true;
	}

	/**
	 * checks if the cards are all between 4 and 6
	 * @return
	 */
	private boolean checkQuanZhong() {
		// traverse through all cards, check if any of them is less then 7
		for (Combo temp : hand) {
			if (temp.getType() == ComboType.bukao || temp.getType() == ComboType.yao)
				return false;
			if (temp.getCards().get(0).getColor() == Color.Zi
					|| temp.getCards().get(0).getValue() > 6
					|| temp.getCards().get(0).getValue() < 4)
				return false;
		}
		// if all of the cards are larger than 6
		return true;
	}

	/**
	 * checks if the cards are all less than 4
	 * @return
	 */
	private boolean checkQuanXiao() {
		// traverse through all cards, check if any of them is less then 7
		for (Combo temp : hand) {
			if (temp.getType() == ComboType.bukao || temp.getType() == ComboType.yao)
				return false;
			if (temp.getCards().get(0).getValue() > 3
					|| temp.getCards().get(0).getColor() == Color.Zi)
				return false;
		}
		// if all of the cards are larger than 6
		return true;
	}

	////////////////////////////////////////////////////////////////////////// 16 Fan ////////////////////////////////////////////////////////////////////

	/**
	 * helps check if the hand is contains a QingLong
	 * @return
	 */
	private boolean checkQingLong() {
		// retrieve all flushes
		// the list storing all flushes
		ArrayList<Combo> chows = new ArrayList<Combo>();

		// traverse through the hand, each color and number 1, 4, 7 a time, and check if for any of 
		// the color, all kinds of required chows are present
		outer:
			for (int  i = 0; i < Color.values().length - 1; i++) {
				chows = new ArrayList<Combo>();
				inner:
					for (int j = 1; j < 8; j+=3) {
						for (Combo temp : hand) {
							Card first = temp.getCards().get(0);
							// check if the card is required
							if (temp.getType() == ComboType.chow
									&& first.getColor() == Color.values()[i]
											&& first.getValue() == j) {
								chows.add(temp);
								if (chows.size() == 3) {
									break outer;
								} else {
									continue inner;
								}
							}
						}
					}
			}

		// check if the chows list has three element in it
		return chows.size() == 3;
	}

	/**
	 * helps check if the hand has two LaoShaoFu of two colors, with another color being the pair and of value 5
	 * @return
	 */
	private boolean checkSanSeShuangLongHui() {
		// the list storing all laoshaofu
		ArrayList<Combo> lsf = getLaoShaoFuHelper();
		// check if there are four in total
		if (lsf.size() != 4)
			return false;

		// the list storing laoshaofu starting with 1
		ArrayList<Combo> one = new ArrayList<Combo>();
		// the list storing laoshaofu starting with 9
		ArrayList<Combo> nine = new ArrayList<Combo>();
		for (Combo temp : lsf) {
			if (temp.getCards().get(0).getValue() == 1) {
				one.add(temp);
			} else {
				nine.add(temp);
			}
		}

		// check if the number is right
		if (one.size() != 2 || nine.size() != 2)
			return false;
		// check if two colors are present
		if (one.get(0).getCards().get(0).checkEqual(one.get(1).getCards().get(0))
				|| nine.get(0).getCards().get(0).checkEqual(nine.get(1).getCards().get(0)))
			return false;

		// check if the pair is of value 5 and if its color is the same as those lashaofu
		for (Combo temp : hand) {
			if (temp.getType() == ComboType.pair) {
				// check if the value is 5
				if (temp.getCards().get(0).getValue() != 5
						|| temp.getCards().get(0).getColor() == Color.Zi) {
					return false;
				} else {
					for (Combo check : lsf) {
						// check if the color is only
						if (temp.getCards().get(0).getColor() ==
								check.getCards().get(0).getColor())
							return false;
					}
				}
			}
		}

		// if all tests are passed
		return true;
	}

	/**
	 * helps check if the hand has three chows of the same color that increase by one or two 
	 * @return
	 */
	private boolean checkYiSeSanBuGao() {
		// exclude higher-level type
		if (checkYiSeSiBuGao())
			return false;

		// the list storing flushes of the same color
		ArrayList<Combo> sameCol = new ArrayList<Combo>();
		// traverse through hand and collect all flushes of the same color
		for (Combo temp : hand) {
			if (temp.getType() == ComboType.chow) {
				sameCol = new ArrayList<Combo>();
				// for every flush, find flushes that have the same color
				for (Combo check : hand) {
					if (check.getType() == ComboType.chow &&
							temp.getCards().get(0).getColor() == 
							check.getCards().get(0).getColor()) {
						sameCol.add(check);
					}
				}
				// check if the list has three flushes in it
				if (sameCol.size() >= 3) 
					break;
			}
		}

		// check if there are three flushes in the list
		if (sameCol.size() < 3)
			return false;

		// try starting off with each combo in the list
		while (sameCol.size() >= 3) {
			// the card of the minimum value
			Combo minCom = sameCol.get(0);
			// look for the least value
			int min = sameCol.get(0).getCards().get(0).getValue();
			for (Combo temp : sameCol) {
				int cur = temp.getCards().get(0).getValue();
				if (cur < min) {
					min = cur;
					minCom = temp;
				}
			}

			// check if four chows increasing by 1 are present
			boolean increaseBy1 = true;
			// the indicator of chows increasing by 2
			boolean increaseBy2 = false;
			outer:
				for (int i = min; i < min + 3; i++) {
					for (Combo temp : sameCol) {
						if (temp.getCards().get(0).getValue() == i) {
							continue outer;
						}
					}
					// if any of the number is not found, this is an unqualified hand
					increaseBy1 = false;
					break;
				}

			// if the hand has no four chows increasing by 1, check if there are by 2
			if (!increaseBy1) {
				increaseBy2 = true;
				outer:
					for (int i = min; i < min + 6; i += 2) {
						for (Combo temp : sameCol) {
							if (temp.getCards().get(0).getValue() == i) {
								continue outer;
							}
						}
						// if any of the number is not found, this is an unqualified hand
						increaseBy2 = false;
						// remove the minimum combo from the list and check the rest
						sameCol.remove(minCom);
					}
			} 

			// check if any of the order exists
			if (increaseBy1 || increaseBy2)
				return true;
		}

		// if neither order is present
		return false;
	}

	/**
	 * check if the hand's every combo contains a card of value five
	 * @return
	 */
	private boolean checkQuanDaiWu() {
		// traverse through the hand and check every combo
		outer:
			for (Combo temp : hand) {
				for (Card check : temp.getCards()) {
					if (check.getColor() != Color.Zi && 
							check.getValue() == 5) {
						continue outer;
					}
				}
				// if any of the combo does not have a card of value 5, it is not a QuanDaiWu
				return false;
			}

	// if every combo has a card of value 5
	return true;
	}

	/**
	 * check if the hand contains three pongs of the same value
	 * @return
	 */
	private boolean checkSanTongKe() {
		// the list storing all pongs and kongs in hand
		ArrayList<Combo> allPong = new ArrayList<Combo>();
		// retrieve all pongs and kongs that are not Zi
		for (Combo temp : hand) {
			if (temp.getCards().get(0).getColor() != Color.Zi && 
					(temp.getType() == ComboType.pong || 
					temp.getType() == ComboType.ankong ||
					temp.getType() == ComboType.mingkong))
				allPong.add(temp);
		}

		// for every combo in the list, check the others and check the number of combo of the same value
		for (Combo temp : allPong) {
			// the number of combo of the same value
			int num = 0;
			for (Combo check : allPong) {
				if (temp.getCards().get(0).getValue() == 
						check.getCards().get(0).getValue())
					num++;
			}
			// break the loop if there are enough combo
			if (num >= 3)
				return true;
		}

		// if there are not enough combo
		return false;
	}

	/**
	 * checks if there are three pongs or ankong in the dark side
	 * @return
	 */
	private boolean checkSanAnKe() {
		// exclude higher-level type
		if (checkSiAnKe())
			return false;

		// the number of pongs in the dark side
		int num = 0;
		// count the number of pongs
		for (Combo temp : dark) {
			if (temp.getType() == ComboType.pong)
				num++;
		}
		// count the number of ankong
		for (Combo temp : bright) {
			if (temp.getType() == ComboType.ankong)
				num++;
		}

		// check if the number is 3
		return num == 3;
	}

	///////////////////////////////////////////////////////////////////// 12 Fan ////////////////////////////////////////////////////////////////////////

	/**
	 * helps check if the hand is a QuanBuKao
	 * @return
	 */
	private boolean checkQuanBuKao() {
		// exclude higher-level type
		if (checkQiXingBuKao())
			return false;

		return dark.size() == 2 && dark.get(1).getType() == ComboType.yao &&
				dark.get(1).getCards().size() < 7;
	}

	/**
	 * helps check if the hand is a ZuHeLong
	 * @return
	 */
	private boolean checkZuHeLong() {
		return dark.size() > 1 && dark.get(0).getType() == ComboType.bukao
				&& dark.get(1).getType() != ComboType.yao;
	}

	/**
	 * checks if all combo have cards with value larger than 5
	 * @return
	 */
	private boolean checkDaYuWu() {
		// exclude higher-level type
		if (checkQuanDa())
			return false;

		// check if Zi cards are present in hand first
		for (Combo temp : hand) {
			for (Card card : temp.getCards()) {
				if (card.getColor() == Color.Zi) {
					return false;
				}
				// if it is not a Zi combo, check if it has cards less than or equal to 5
				if (card.getValue() <= 5)
					return false;
			}
		}

		// if all tests are passed
		return true;
	}

	/**
	 * checks if all combo have cards with value less than 5
	 * @return
	 */
	private boolean checkXiaoYuWu() {
		// exclude higher-level type
		if (checkQuanXiao())
			return false;

		// check if Zi cards are present in hand first
		for (Combo temp : hand) {
			for (Card card : temp.getCards()) {
				if (card.getColor() == Color.Zi) {
					return false;
				}
				// if it is not a Zi combo, check if it has cards larger than or equal to 5
				if (card.getValue() >= 5)
					return false;
			}
		}

		// if all tests are passed
		return true;
	}

	/**
	 * check if the hand has three chows of the color Zi
	 * @return
	 */
	private boolean checkSanFengKe() {
		// exclude higher-level type
		if (checkDaSiXi() || checkXiaoSiXi())
			return false;

		// the number of feng pongs
		int num = 0;
		// traverse through hand cards and count the number of Feng pongs
		for (Combo temp : hand) {
			if (temp.getType() == ComboType.pong
					|| temp.getType() == ComboType.ankong
					|| temp.getType() == ComboType.mingkong) {
				if (temp.getCards().get(0).getColor() == Color.Zi &&
						temp.getCards().get(0).getValue() < 5)
					num++;
			}
		}
		// check if the number is 3
		return num == 3;
	}

	///////////////////////////////////////////////////////////////// 8 Fan ///////////////////////////////////////////////////////////////////////////////

	/**
	 * helps check if the hand has three flushes of three colors that are in a row
	 * @return
	 */
	private boolean checkHuaLong() {
		// retrieve all flushes
		// the list storing all flushes
		ArrayList<Combo> chows = new ArrayList<Combo>();
		// traverse through the hand and take out all the chows
		for (Combo temp : hand) {
			if (temp.getType() == ComboType.chow) {
				chows.add(temp);
			}
		}

		// check if flush starting with 147 are present
		outer:
			for (int i = 1; i < 8; i+=3) {
				for (Combo temp : chows) {
					if (temp.getCards().get(0).getValue() == i)
						continue outer;
				}
				// if any of the combo is not present
				return false;
			}

		// check if all three colors are present
		color:
			for (int i = 0; i < Color.values().length - 1; i++) {
				for (Combo temp : chows) {
					if (temp.getCards().get(0).getColor() == Color.values()[i])
						continue color;
				}
				// if any of the color is not present
				return false;
			}

			// if there are duplicate values, check the equality of colors of the two combo that have no duplicate ones
			if (chows.size() > 3) {
				// remove the two combo of the same value
				remove:
					for (Combo temp : chows) {
						for (Combo check : chows) {
							if (temp != check &&
									temp.getCards().get(0).getValue() == check.getCards().get(0).getValue()) {
								chows.remove(temp);
								chows.remove(check);
								break remove;
							}
						}
					}
			// only the two single combo remain
			if (chows.size() < 2)
				return false;
			return chows.get(0).getCards().get(0).getColor() != 
					chows.get(1).getCards().get(0).getColor();
			} else {
				return true;
			}
	}

	/**
	 * checks if the hand has only certain cards whose graph is symmetric
	 * @return
	 */
	private boolean checkTuiBuDao() {
		// the list storing all valid cards
		ArrayList<Card> valid = new ArrayList<Card>();
		valid.add(new Card(1, Color.Bing));
		valid.add(new Card(2, Color.Bing));
		valid.add(new Card(3, Color.Bing));
		valid.add(new Card(4, Color.Bing));
		valid.add(new Card(5, Color.Bing));
		valid.add(new Card(8, Color.Bing));
		valid.add(new Card(9, Color.Bing));
		valid.add(new Card(2, Color.Tiao));
		valid.add(new Card(4, Color.Tiao));
		valid.add(new Card(5, Color.Tiao));
		valid.add(new Card(6, Color.Tiao));
		valid.add(new Card(8, Color.Tiao));
		valid.add(new Card(9, Color.Tiao));
		valid.add(new Card(7, Color.Zi));

		// check every card in hand and see if it is valid 
		for (Combo temp : hand) {
			inner:
				for (Card card : temp.getCards()) {
					for (Card check : valid) {
						if (card.checkEqual(check)) {
							continue inner;
						}
					}
					// if any of the cards is not valid, this is an unqualified hand
					return false;
				}
		}

		// if all cards are valid
		return true;
	}

	/**
	 * helps check if the hand has three flushes of same cards but three colors
	 * @return
	 */
	private boolean checkSanSeSanTongShun() {
		// the list storing three flushes
		ArrayList<Combo> three = new ArrayList<Combo>();

		// traverse through the hand and take out the three flushes
		for (Combo temp : hand) {
			three = new ArrayList<Combo>();
			// if current combo is a flush, traverse through the hand and look for same ones
			if (temp.getType() == ComboType.chow) {
				for (Combo check : hand) {
					if (check.getType() == ComboType.chow && 
							temp.getCards().get(0).getValue() == check.getCards().get(0).getValue()) {
						three.add(check);
					} 
				}
				if (three.size() > 3)
					break;
			}
		}

		// check if there are at least three elements in the list
		if (three.size() < 3)
			return false;

		// check if three colors are present
		outer:
			for (int i = 0; i < Color.values().length - 1; i++) {
				for (Combo temp : three) {
					if (temp.getCards().get(0).getColor() == Color.values()[i]) {
						continue outer;
					}
				}
				// if any of the color is not present
				return false;
			}

		// if all tests are passed
		return true;
	}

	/**
	 * helps check if the hand has three pongs of values increasing by 1 but with three colors
	 * @return
	 */
	private boolean checkSanSeSanJieGao() {
		// the list storing all the pongs
		ArrayList<Combo> pongs = new ArrayList<Combo>();
		// take out all the pongs, except for the zi pongs, in hand
		for (Combo temp : hand) {
			if (temp.getType() == ComboType.pong
					|| temp.getType() == ComboType.ankong
					|| temp.getType() == ComboType.mingkong) {
				if (temp.getCards().get(0).getColor() != Color.Zi) {
					pongs.add(temp);
				}
			}
		}

		// check if there are enough pongs
		if (pongs.size() < 3)
			return false;

		while (pongs.size() > 2) {
			// look for the minimum in the pongs
			Combo minCom = pongs.get(0);
			int min = pongs.get(0).getCards().get(0).getValue();
			for (Combo temp : pongs) {
				int cur = temp.getCards().get(0).getValue();
				if (cur < min) {
					min = cur;
					minCom = temp;
				}
			}

			// indicator of presence of all expected combo
			boolean pres = true;

			// check if the three consecutive values are present and check colors
			outer:
				for (int i = min; i < min + 3; i++) {
					for (Combo temp : pongs) {
						if (temp.getCards().get(0).getValue() == i) {
							continue outer;
						}
					}
					// if any of the expected combo is not present
					pongs.remove(minCom);
					pres = false;
				}

			if (pres)
				break;
		}

		if (pongs.size() <= 2)
			return false;

		// check if three colors are all present in the list
		outer:
			for (int i = 0; i < Color.values().length - 1; i++) {
				for (Combo temp : pongs) {
					if (temp.getCards().get(0).getColor() == Color.values()[i]) {
						continue outer;
					}
				}
				// if any of the color is not present
				return false;
			}

		// if there are duplicate values, check the equality of colors of the two combo that have no duplicate ones
		if (pongs.size() > 3) {
			// remove the two combo of the same value
			remove:
				for (Combo temp : pongs) {
					for (Combo check : pongs) {
						if (temp != check &&
								temp.getCards().get(0).getValue() == check.getCards().get(0).getValue()) {
							pongs.remove(temp);
							pongs.remove(check);
							break remove;
						}
					}
				}
		// only the two single combo remain
		if (pongs.size() < 2)
			return false;
		return pongs.get(0).getCards().get(0).getColor() != 
				pongs.get(1).getCards().get(0).getColor();
		} else {
			return true;
		}
	}

	/**
	 * check if the hand has two anKongs
	 * @return
	 */
	private boolean checkShuangAnGang() {
		// exclude higher-level type
		if (checkSiGang() || checkSanGang())
			return false;

		// the number of ankong
		int num = 0;
		// traverse through bright hand and count the number
		for (Combo temp : bright) {
			if (temp.getType() == ComboType.ankong) {
				num++;
			}
		}
		// check if the number is 2
		return num == 2;
	}

	//////////////////////////////////////////////////////////////////// 6 Fan ////////////////////////////////////////////////////////////////////////////

	/**
	 * checks if hand only has pongs or kongs in it
	 * @return
	 */
	private boolean checkPengPengHu() {
		// exclude higher-level type
		if (checkDaSiXi() || checkQingYaoJiu() || checkLianQiDui() || checkSiGang() || checkZiYiSe() || checkSiAnKe()
				|| checkYiSeSiJieGao() || checkHunYaoJiu() || checkQiXiaoDui() || checkQuanShuangKe())
			return false;

		// traverse through hand and check every combo 
		for (Combo temp : hand) {
			if (temp.getType() == ComboType.chow
					|| temp.getType() == ComboType.bukao
					|| temp.getType() == ComboType.yao)
				return false;
		}
		// if every combo is a pong
		return true;
	}

	/**
	 * check if the hand is composed of only zi cards and cards of another color
	 * @return
	 */
	private boolean checkHunYiSe() {
		// exclude uqualified type
		if (checkDaSiXi() || checkQiXingBuKao() || checkQuanBuKao() || checkZuHeLong())
			return false;
		
		// the list storing all remaining cards when all zi cards are taken out
		ArrayList<Combo> noZi = new ArrayList<Combo>();
		// take out all not zi combo
		for (Combo temp : hand) {
			if (temp.getCards().get(0).getColor() != Color.Zi)
				noZi.add(temp);
		}
		// check if there are any zi cards
		if (noZi.size() == hand.size())
			return false;
		// make sure it is not ZiYiSe
		if (noZi.size() == 0)
			return false;

		// check if the remaining cards are of the same color
		for (int i = 0; i < noZi.size() - 1; i++) {
			if (noZi.get(i).getCards().get(0).getColor() != 
					noZi.get(i + 1).getCards().get(0).getColor()) {
				return false;
			}
		}
		// if the first card of every combe has the same color as the one of its next combo, starting from the first combo,
		// all cards are of the same color
		return true;
	}

	/**
	 * checks if the hand has three chows of three colors and increasing by one
	 * @return
	 */
	private boolean checkSanSeSanBuGao() {
		// the list storing flushes of the same color
		ArrayList<Combo> flushes = new ArrayList<Combo>();
		// traverse through hand and collect all flushes 
		for (Combo temp : hand) {
			if (temp.getType() == ComboType.chow) {
				flushes.add(temp);
			}
		}

		// check if there are three flushes in the list
		if (flushes.size() < 3)
			return false;

		// the indicator of presence of the increasing order
		boolean pres = false;

		// try starting off with each combo in the list
		outer:
			while (flushes.size() >= 3) {
				// the card of the minimum value
				Combo minCom = flushes.get(0);
				// look for the least value
				int min = flushes.get(0).getCards().get(0).getValue();
				for (Combo temp : flushes) {
					int cur = temp.getCards().get(0).getValue();
					if (cur < min) {
						min = cur;
						minCom = temp;
					}
				}

				// check if the order is present
				inner:
					for (int i = min; i < min + 3; i++) {
						for (Combo temp : flushes) {
							if (temp.getCards().get(0).getValue() == i) {
								continue inner;
							}
						}
						// if any of the number is not found, this is an unqualified hand
						flushes.remove(minCom);
						continue outer;
					}

				// when the order is present
				pres = true;
				break;
			} 

		// check if any of the order exists
		if (!pres)
			return false;

		// check if three colors are all present in the list
		color:
			for (int i = 0; i < Color.values().length - 1; i++) {
				for (Combo temp : flushes) {
					if (temp.getCards().get(0).getColor() == Color.values()[i]) {
						continue color;
					}
				}
				// if any of the color is not present
				return false;
			}

		// if there are duplicate values, check the equality of colors of the two combo that have no duplicate ones
		if (flushes.size() > 3) {
			// remove the two combo of the same value
			remove:
				for (Combo temp : flushes) {
					for (Combo check : flushes) {
						if (temp != check &&
								temp.getCards().get(0).getValue() == check.getCards().get(0).getValue()) {
							flushes.remove(temp);
							flushes.remove(check);
							break remove;
						}
					}
				}
		// only the two single combo remain
		if (flushes.size() < 2)
			return false;
		return flushes.get(0).getCards().get(0).getColor() != 
				flushes.get(1).getCards().get(0).getColor();
		} else {
			return true;
		}
	}

	/**
	 * check if the hand has combo of all the colors
	 * @return
	 */
	private boolean checkWuMenQi() {
		// exclude higher-level type
		if (checkShiSanYao() || checkQiXingBuKao() || checkQuanBuKao())
			return false;

		// traverse through every combo and check for first three colors
		outer:
			for (int i = 0; i < Color.values().length - 1; i++) {
				for (Combo temp : hand) {
					if (temp.getCards().get(0).getColor() == Color.values()[i]) {
						continue outer;
					}
				}
				// if any of the first three colors is not found
				return false;
			}

		// check for Feng cards and Jian cards
		// indicator of presence of Feng cards
		boolean feng = false;
		// indicator of presence of Jian cards
		boolean jian = false;
		// traverse through hand and search for feng cards
		for (Combo temp : hand) {
			if (temp.getCards().get(0).getColor() == Color.Zi) {
				if (temp.getCards().get(0).getValue() < 5) {
					feng = true;
				} else {
					jian = true;
				}
			}
		}

		// check the presence
		return feng && jian;
	}

	/**
	 * check if all combo except for the pair are on the bright side
	 * @return
	 */
	private boolean checkQuanQiuRen() {
		// check if there are more than 2 cards in the dark side
		if (dark.size() > 1 || dark.get(0).getType() != ComboType.pair)
			return false;
		// check if there are AnKong
		for (Combo temp : bright) {
			if (temp.getType() == ComboType.ankong)
				return false;
		}
		// all tests are passed
		return !ziMo;
	}

	/**
	 * checks if the hand contains two pongs or kongs of Jian cards 
	 * @return
	 */
	private boolean checkShuangJianKe() {
		// exclude higher-level type
		if (checkDaSanYuan() || checkXiaoSanYuan())
			return false;

		// the number of expected combo
		int num = 0;
		// traverse through hand and count the number of expected combo
		for (Combo temp : hand) {
			if (temp.getType() == ComboType.pong
					|| temp.getType() == ComboType.ankong
					|| temp.getType() == ComboType.mingkong) {
				if (temp.getCards().get(0).getColor() == Color.Zi && 
						temp.getCards().get(0).getValue() > 4) {
					num++;
				}
			}
		}
		// check if the number is 2
		return num == 2;
	}

	///////////////////////////////////////////////////////////////// 4 Fan //////////////////////////////////////////////////////////////////////////////

	/**
	 * check if every combo has a yao card in it
	 * @return
	 */
	private boolean checkQuanDaiYao() {
		// exclude higher-level type
		if (checkQingYaoJiu() || checkZiYiSe() || checkHunYaoJiu())
			return false;

		// traverse through hand and check every combo
		for (Combo temp : hand) {
			if (temp.getType() == ComboType.bukao || temp.getType() == ComboType.yao)
				return false;
			Card card = temp.getCards().get(0);
			// if current combo is a pong, card should be a yao
			if (temp.getType() != ComboType.chow) {
				if (card.getColor() != Color.Zi && card.getValue() != 1 && card.getValue() != 9)
					return false;
			} 
			// if the type is chow, it could only be 1 or 7
			else {
				if (card.getValue() != 1 && card.getValue() != 7) {
					return false;
				}
			}
		}

		// if all tests are passed
		return true;
	}

	/**
	 * checks if the cards are all dark
	 * @return
	 */
	private boolean checkBuQiuRen() {
		// exclude higher-level type
		if (checkQiXiaoDui() || checkQiXingBuKao() || checkQuanBuKao())
			return false;

		// traverse through bright side and make sure only ankongs are present
		for (Combo temp : bright) {
			if (temp.getType() != ComboType.ankong)
				return false;
		}
		// check if its zi mo
		return ziMo;
	}

	/**
	 * check if the hand has 2 mingkongs
	 * @return
	 */
	private boolean checkShuangMingGang() {
		// exclude higher-level type
		if (checkSiGang() || checkSanGang())
			return false;

		// the number of mingkongs
		int num = 0;
		// traverse through bright cards and count
		for (Combo temp : bright) {
			if (temp.getType() == ComboType.mingkong) {
				num++;
			}
		}
		// check if the number is 2
		return num == 2;
	}

	///////////////////////////////////////////////////////////////////////// 2 Fan ////////////////////////////////////////////////////////////////////////
	/**
	 * check if the hand has a pong of color jian
	 * @return
	 */
	private boolean checkJianKe() {
		// exclude higher-level type
		if (checkDaSanYuan() || checkXiaoSanYuan() || checkShuangJianKe())
			return false;

		// traverse through hand and search for jian pong
		for (Combo temp : hand) {
			if (temp.getType() == ComboType.pong
					|| temp.getType() == ComboType.ankong
					|| temp.getType() == ComboType.mingkong) {
				if (temp.getCards().get(0).getColor() == Color.Zi 
						&& temp.getCards().get(0).getValue() > 4)
					return true;
			}
		}
		// if there is not a jian pong or kong
		return false;
	}

	/**
	 * check if there are any cards on the bright side
	 * @return
	 */
	private boolean checkMenQianQing() {
		// exclude higher-level type
		if (checkJiuLianBaoDeng() || checkLianQiDui() || checkShiSanYao() || checkSiAnKe()
				|| checkQiXiaoDui() || checkQiXingBuKao() || checkQuanBuKao() || checkBuQiuRen())
			return false;

		// check if there are combo in the bright side other than ankong
		for (Combo temp : bright) {
			if (temp.getType() != ComboType.ankong) {
				return false;
			}
		}
		return true;
	}

	/**
	 * helps check if the hand is composed of four flushes with a pair and no zi
	 * @return
	 */
	private boolean checkPingHu() {
		// exclude higher-level type
		if (checkLianQiDui() || checkYiSeShuangLongHui() || checkYiSeSiBuGao() || checkSanSeShuangLongHui() 
				|| checkQiXiaoDui())
			return false;

		// check if there are all chows
		for (Combo temp : hand) {
			if (temp.getType() == ComboType.pair) {
				if (temp.getCards().get(0).getColor() == Color.Zi)
					return false;
			} else {
				if (temp.getType() != ComboType.chow) {
					return false;
				}
			}
		}
		// if all combo are chows
		return true;
	}

	/**
	 * check if there are four identical cards in the dark side
	 * @return
	 */
	private int checkSiGuiYi() {
		// the number of qualified combo
		int siGuiYi = 0;

		// exclude higher-level type
		if (checkYiSeSiTongShun())
			return siGuiYi;

		// put all cards in combo in the list
		ArrayList<Card> allCards = new ArrayList<Card>();
		for (Combo combo : dark) {
			for (Card card : combo.getCards()) {
				allCards.add(card);
			}
		}

		outer:
			while (allCards.size() > 4) {
				// the number of identical cards
				int num = 0;

				// to help remove the qualified cards from the list
				Card rem = allCards.get(0);
				// count the number of identical cards
				for (Card temp : allCards) {
					rem = temp;
					num = 0;
					for (Card check : allCards) {
						if (temp.checkEqual(check)) {
							num++;
						}
					}
					// check if the number is four
					if (num == 4) {
						for (int i = 0; i < allCards.size(); i++) {
							if (rem.checkEqual(allCards.get(i))) {
								allCards.remove(i);
								i--;
							}
						}
						siGuiYi++;
						continue outer;
					}
				}
				// if there are no more qualified cards in hand
				return siGuiYi;
			}

		return siGuiYi;
	}

	/**
	 * checks if there are two pongs of the same value
	 * @return
	 */
	private ArrayList<Combo> checkShuangTongKe() {
		// deep copy of hand
		ArrayList<Combo> cards = new ArrayList<Combo>();
		cards.addAll(hand);
		// the list containing all expected pongs
		ArrayList<Combo> tongke = new ArrayList<Combo>();

		// exclude higher-level type
		if (checkSanTongKe())
			return tongke;

		outer:
			while (cards.size() > 1) {
				// traverse through hand and count
				for (Combo temp : cards) {
					if (temp.getType() == ComboType.pong &&
							temp.getCards().get(0).getColor() != Color.Zi) {
						for (Combo check : cards) {
							if (temp != check 
									&& check.getType() == ComboType.pong
									&& temp.getCards().get(0).getValue() == check.getCards().get(0).getValue()
									&& check.getCards().get(0).getColor() != Color.Zi) {
								tongke.add(temp);
								tongke.add(check);
								cards.remove(temp);
								cards.remove(check);
								continue outer;
							}
						}
					}
				}
				break outer;
			}

		return tongke;
	}

	/**
	 * checks if there two dark pongs
	 * @return
	 */
	private boolean checkShuangAnKe() {
		// exclude higher-level type
		if (checkSiAnKe() || checkSanAnKe())
			return false;

		// the number of dark pongs
		int num = 0;
		// traverse through dark side and count
		for (Combo temp : dark) {
			if (temp.getType() == ComboType.pong)
				num++;
		}
		// check if the number is 2
		return num == 2;
	}

	/**
	 * check if there is an ankong
	 * @return
	 */
	private boolean checkAnGang() {
		// exclude higher-level type
		if (checkSiGang() || checkSanGang() || checkShuangAnGang())
			return false;

		// traverse through bright and search for ankong
		for (Combo temp : bright) {
			if (temp.getType() == ComboType.ankong)
				return true;
		}

		// if there are no ankong present
		return false;
	}

	/**
	 * check if the hand has no yao cards in it
	 * @return
	 */
	private boolean checkDuanYao() {
		// exclude higher-level type
		if (checkQuanShuangKe() || checkQuanZhong() || checkQuanDaiWu())
			return false;

		// put all cards in combo in the list
		ArrayList<Card> allCards = new ArrayList<Card>();
		for (Combo combo : hand) {
			for (Card card : combo.getCards()) {
				allCards.add(card);
			}
		}

		// traverse through the list and check if yao cards are present
		for (Card temp : allCards) {
			if (temp.getColor() == Color.Zi) {
				return false;
			} else {
				if (temp.getValue() == 1 || temp.getValue() == 9)
					return false;
			}
		}

		// if no yao cards are present
		return true;
	}

	////////////////////////////////////////////////////////// 1 Fan //////////////////////////////////////////////////////////////////////////////////////

	/**
	 * count the number of two identical flushes in the hand
	 * @return
	 */
	private ArrayList<Combo> checkYiBanGao() {
		// deep copy of hand
		ArrayList<Combo> cards = new ArrayList<Combo>();
		cards.addAll(hand);
		// the list of expected combo to be returned
		ArrayList<Combo> yiBanGao = new ArrayList<Combo>();

		// exclude higher-level type
		if (checkYiSeShuangLongHui() || checkYiSeSiTongShun() || checkYiSeSanTongShun())
			return yiBanGao;

		// keep searching until there are not enough cards in it
		out:
			while (cards.size() > 1) {
				// check every combo in hand 
				for (Combo temp : cards) {
					if (temp.getType() == ComboType.chow) {
						for (Combo check : cards) {
							if (temp != check && temp.checkEqual(check)) {
								yiBanGao.add(temp);
								cards.remove(temp);
								yiBanGao.add(check);
								cards.remove(check);
								continue out;
							}
						}
					}
				}
				break out;
			}
		return yiBanGao;
	}

	/**
	 * count the number of two flushes with the same value but different color in hand
	 * @return
	 */
	private ArrayList<Combo> checkXiXiangFeng() {
		// deep copy of hand
		ArrayList<Combo> cards = new ArrayList<Combo>();
		cards.addAll(hand);
		// the list of expected combo to be returned
		ArrayList<Combo> xiXiangFeng = new ArrayList<Combo>();

		// exclude higher-level type
		if (checkSanSeShuangLongHui() || checkSanSeSanTongShun())
			return xiXiangFeng;

		out:
			while (cards.size() > 1) {
				// traverse through hand and check every combo
				for (Combo temp : cards) {
					if (temp.getType() == ComboType.chow) {
						for (Combo check : cards) {
							if (check.getType() == ComboType.chow
									&& temp.getCards().get(0).getColor() != check.getCards().get(0).getColor() 
									&& temp.getCards().get(0).getValue() == check.getCards().get(0).getValue()) {
								xiXiangFeng.add(temp);
								cards.remove(temp);
								xiXiangFeng.add(check);
								cards.remove(check);
								continue out;
							}
						}
					}
				}
				break out;
			}

		// if none of the combo exists
		return xiXiangFeng;
	}

	/**
	 * count the number of joint flushes in hand 
	 * @return
	 */
	private ArrayList<Combo> checkLianLiu() {
		// deep copy of hand
		ArrayList<Combo> cards = new ArrayList<Combo>();
		cards.addAll(hand);
		// the list of expected combo to be returned
		ArrayList<Combo> lianLiu = new ArrayList<Combo>();

		// exclude higher-level type
		if (checkYiSeSiBuGao() || checkQingLong())
			return lianLiu;

		outer:
			while (cards.size() > 1) {
				for (Combo temp : cards) {
					if (temp.getType() == ComboType.chow) {
						for (Combo check : cards) {
							if (check.getType() == ComboType.chow
									&& check.getCards().get(0).getColor() == temp.getCards().get(0).getColor()
									&& check.getCards().get(0).getValue() == temp.getCards().get(0).getValue() + 3) {
								lianLiu.add(temp);
								lianLiu.add(check);
								cards.remove(temp);
								cards.remove(check);
								continue outer;
							}
						}
					}
				}
				break outer;
			}

		return lianLiu;
	}

	private ArrayList<Combo> checkLaoShaoFu() {
		// exclude higher-level type
		if (checkYiSeShuangLongHui() || checkYiSeSiBuGao() || checkQingLong()
				|| checkSanSeShuangLongHui())
			return new ArrayList<Combo>();

		return getLaoShaoFuHelper();
	}

	/**
	 * check if the hand has a pong or kong of yao
	 * @return
	 */
	private boolean checkYaoJiuKe() {
		// deep copy of hand
		ArrayList<Combo> cards = new ArrayList<Combo>();
		cards.addAll(hand);

		// exclude higher-level type
		if (checkDaSiXi() || checkJiuLianBaoDeng() || checkQingYaoJiu()
				|| checkZiYiSe() || checkHunYaoJiu())
			return false;

		// exclude combo that have been calculated
		if (checkDaSanYuan() || checkShuangJianKe() || checkJianKe()) {
			for (Combo temp : hand) {
				if (temp.getType() == ComboType.pong
						|| temp.getType() == ComboType.mingkong
						|| temp.getType() == ComboType.ankong) {
					if (temp.getCards().get(0).getColor() == Color.Zi
							&& temp.getCards().get(0).getValue() > 4)
						cards.remove(temp);
				}
			}
		}

		// exclude feng combo that have been calculated
		if (checkSanFengKe()) {
			for (Combo temp : hand) {
				if (temp.getType() == ComboType.pong
						|| temp.getType() == ComboType.mingkong
						|| temp.getType() == ComboType.ankong) {
					if (temp.getCards().get(0).getColor() == Color.Zi 
							&& temp.getCards().get(0).getValue() < 5)
						cards.remove(temp);
				}
			}
		}

		// traverse through hand and check if there exists a expected combo
		for (Combo temp : cards) {
			if (temp.getType() == ComboType.ankong
					|| temp.getType() == ComboType.mingkong
					|| temp.getType() == ComboType.pong) {
				if (temp.getCards().get(0).getValue() == 1
						|| temp.getCards().get(0).getValue() == 9
						|| temp.getCards().get(0).getColor() == Color.Zi)
					return true;
			}
		}
		// if none of expected combo is present
		return false;
	}

	/**
	 * check if the hand has a mingkong
	 * @return
	 */
	private boolean checkMingGang() {
		// exclude higher-level type
		if (checkSiGang() || checkSanGang() || checkShuangMingGang())
			return false;

		//traverse through bright side and look for a mingkong
		for (Combo temp : bright) {
			if (temp.getType() == ComboType.mingkong)
				return true;
		}
		return false;
	}

	/**
	 * check if the hand lacks one the first three color
	 * @return
	 */
	private boolean checkQueYiMen() {
		// exclude higher-level type
		if (checkDaSiXi() || checkDaSanYuan() || checkLianQiDui() || checkJiuLianBaoDeng() || checkQingYiSe() || checkTuiBuDao())
			return false;

		// check every color
		outer:
			for (int i = 0; i < Color.values().length - 1; i++) {
				// traverse through hand
				for (Combo temp : hand) {
					if (temp.getType() == ComboType.bukao || temp.getType() == ComboType.yao)
						return false;
					
					if (temp.getCards().get(0).getColor() == Color.values()[i])
						continue outer;
				}
				// if any of the color is absent
				return true;
			}
		// if all color are present
		return false;
	}

	/**
	 * check if the hand has zi cards in it
	 * @return
	 */
	private boolean checkWuZi() {
		// exclude higher-level type
		if (checkQingYaoJiu() || checkLianQiDui() || checkJiuLianBaoDeng() || 
				checkShiSanYao() || checkYiSeShuangLongHui() || checkQuanShuangKe() 
				|| checkQingYiSe() || checkQuanDa() || checkQuanZhong() || checkQuanXiao()
				|| checkSanSeShuangLongHui() || checkQuanDaiWu() || checkDaYuWu() || checkXiaoYuWu()
				|| checkPingHu() || checkDuanYao())
			return false;

		// traverse through hand and check zi cards
		for (Combo temp : hand) {
			if (temp.getCards().get(0).getColor() == Color.Zi)
				return false;
		}
		// if zi cards do not exist
		return true;
	}

	/**
	 * check if the winning card is the edge card of 123 or 789
	 * @return
	 */
	private boolean checkBianZhang() {
		// check if the winning card is the 3 of 123
		if (winCard.getValue() == 3) {
			for (Combo temp : dark) {
				if (temp.getType() == ComboType.chow 
						&& temp.getCards().get(0).getValue() == 1
						&& temp.getCards().get(0).getColor() == winCard.getColor()) {
					// check if 345 exists in dark side
					for (Combo check : dark) {
						if (check.getType() == ComboType.chow 
								&& check.getCards().get(0).getValue() == 3
								&& check.getCards().get(0).getColor() == winCard.getColor())
							return false;
					}
					// if a flush of 345 does not exist
					return true;
				}
			}
			// if a flush of 123 is not present
			return false;
		}

		// check if the winning card is the 7 of 789
		if (winCard.getValue() == 7) {
			for (Combo temp : dark) {
				if (temp.getType() == ComboType.chow 
						&& temp.getCards().get(0).getValue() == 7
						&& temp.getCards().get(0).getColor() == winCard.getColor()) {
					// check if 567 exists in dark side
					for (Combo check : dark) {
						if (check.getType() == ComboType.chow 
								&& check.getCards().get(0).getValue() == 5
								&& check.getCards().get(0).getColor() == winCard.getColor())
							return false;
					}
					// if a flush of 567 does not exist
					return true;
				}
			}
			// if a flush of 789 is not present
			return false;
		}

		// if the winning card is neither 1 or 7
		return false;
	}

	/**
	 * check if the winning card is the middle card of a flush
	 * @return
	 */
	private boolean checkKanZhang() {
		// search for flush staring with the value that is 1 less than the value of the winning card
		for (Combo temp : dark) {
			if (temp.getType() == ComboType.chow
					&& temp.getCards().get(0).getColor() == winCard.getColor()
					&& temp.getCards().get(0).getValue() == winCard.getValue() - 1) {
				// check if there exists flush starting or ending with the winning card
				for (Combo check : dark) {
					if (check.getType() == ComboType.chow) {
						if (check.getCards().get(0).checkEqual(winCard)
								|| check.getCards().get(2).checkEqual(winCard))
							return false;
					}
				}
				// if such combo is not present
				return true;
			}
		}
		// if there is not a combo taking the winning card as the middle one
		return false;
	}

	/**
	 * check if the winning card forms the pair
	 * @return
	 */
	private boolean checkDanDiaoJiang() {
		// exclude higher-level type
		if (checkLianQiDui() || checkQiXiaoDui() || checkQuanQiuRen())
			return false;

		// check if the winning card is in the pair
		for (Combo temp : hand) {
			if (temp.getType() == ComboType.pair)
				return winCard.checkEqual(temp.getCards().get(0));
		}
		return false;
	}

	/**
	 * check if the hand is a zi mo
	 * @return
	 */
	private boolean checkZiMo() {
		// exclude higher-level type
		if (checkBuQiuRen())
			return false;

		return ziMo;
	}
}

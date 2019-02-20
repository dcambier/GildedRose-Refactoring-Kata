package com.gildedrose.goods;

public class SulfurasItem implements GoodsItem {

    /*
     * @see com.gildedrose.goods.GoodsItem#updateQuality()	
     * All items have a SellIn value which denotes the number of days we have to sell the item
	 * All items have a Quality value which denotes how valuable the item is
	 * N/A ****  Rule #0 : At the end of each day our system lowers both values for every item
     * N/A ****  Rule #1 : Once the sell by date has passed, Quality degrades twice as fast (0 regards to Rule ?)
	 * 
	 * N/A ****  Rule #3 : "Aged Brie" actually increases in Quality the older it gets
	 * N/A ****  Rule #6 : "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
	 * 			 Quality increases by 2 when there are 10 days or less 
	 * 			 and by 3 when there are 5 days or less 
	 * 			 but Quality drops to 0 after the concert
	 * 
	 * N/A ****  Rule #2 : The Quality of an item is never negative
	 * N/A ****  Rule #4 : The Quality of an item is never more than 50
	 * 
	 * Rule #5 : "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
     * 
     */
	@Override
	public void updateQuality() {

		/* Rule #5 - Nothing
		 * Just for clarification, an item can never have its Quality increase above 50, however "Sulfuras" is a
		 * legendary item and as such its Quality is 80 and it never alters.
		 */
	}

}

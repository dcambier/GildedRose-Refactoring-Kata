package com.gildedrose.goods;

import com.gildedrose.Item;
import com.gildedrose.utils.GoodsUtils;

public class BackstagePassesItem implements GoodsItem {

    private final Item item;

    public BackstagePassesItem(Item item) {
        this.item = item;
    }
    
    /*
     * @see com.gildedrose.goods.GoodsItem#updateQuality()	
     * All items have a SellIn value which denotes the number of days we have to sell the item
	 * All items have a Quality value which denotes how valuable the item is
	 * Rule #0 : At the end of each day our system lowers both values for every item
     * Rule #1 : Once the sell by date has passed, Quality degrades twice as fast (0 regards to Rule ?)
	 * 
	 * N/A ****  Rule #3 : "Aged Brie" actually increases in Quality the older it gets
	 * Rule #6 : "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
	 * 			 Quality increases by 2 when there are 10 days or less 
	 * 			 and by 3 when there are 5 days or less 
	 * 			 but Quality drops to 0 after the concert
	 * 
	 * Rule #2 : The Quality of an item is never negative
	 * Rule #4 : The Quality of an item is never more than 50
	 * 
	 * N/A **** Rule #5 : "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
     * 
     */
	@Override
	public void updateQuality() {

		//Rule #6 before Rule #0
		if (item.sellIn < 0) {
			item.quality = item.quality - item.quality;
		} else if (item.sellIn < 6) {
			item.quality = GoodsUtils.adjustValueQuality(item.quality, 3);
		} else if (item.sellIn < 11) {
			item.quality = GoodsUtils.adjustValueQuality(item.quality, 2);
		} else {
			item.quality = GoodsUtils.adjustValueQuality(item.quality, 1);
		}
		//Rule #0
		item.sellIn = GoodsUtils.adjustValueSellIn(item.sellIn, -1);
		//Rule #2 + Rule #4
		item.quality = GoodsUtils.checkValueQuality(item.quality);
	}

}

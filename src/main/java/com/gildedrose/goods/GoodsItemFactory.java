package com.gildedrose.goods;

import com.gildedrose.Item;

public class GoodsItemFactory {

	/*
	 * Constants
	 */
    public final static String AGEDBRIE_ITEM  = "Aged Brie";
    public final static String BACKSTAGE_ITEM = "Backstage passes to a TAFKAL80ETC concert";
    public final static String SULFURAS_ITEM  = "Sulfuras, Hand of Ragnaros";
    
    // New Item
    public final static String CONJURED_ITEM  = "Conjured";
	/*
	 * Constructor
	 */
	public GoodsItemFactory(Item item) {
		
	}
	
	public GoodsItem createGoodsItem(Item item) {

		switch (item.name) {
			case AGEDBRIE_ITEM:
				return new AgedBrieItem(item);
			case BACKSTAGE_ITEM:
				return new BackstagePassesItem(item);	
			case SULFURAS_ITEM:
				return new SulfurasItem();		
			case CONJURED_ITEM:
				return new ConjuredItem(item);					
			default:
				return new OtherItem(item);
		}
	}
}

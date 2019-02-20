package com.gildedrose.utils;

public final class GoodsUtils {
	
	public final static int QUALITY_DEGRADES  = 1;
	
	private GoodsUtils() {
	}
	
	public static int adjustValueQuality(int quality, int value) {
		return quality + value;
	}
	
	public static int adjustValueSellIn(int sellIn, int value) {
		return sellIn + value;
	}
	
	public static int checkValueQuality(int quality) {
		
		if(quality > 50) {
			return 50;
		} else if(quality < 0) {
			return 0;
		} else return quality;
		
	}

}

package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    //Once the sell by date has passed, Quality degrades twice as fast
    @Test
    public void sellDatePassed() {
        Item[] items = new Item[] { new Item("Other Item", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality,8);
    }
    //The Quality of an item is never negative
    @Test
    public void qualityNeverNegative() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, -1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality,0);
    }
    //"Aged Brie" actually increases in Quality the older it gets
    @Test
    public void qualityAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 43) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality,44);
    }
    //The Quality of an item is never more than 50
    @Test
    public void qualityNeverMore50() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 51) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality,50);
    }
    //"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    @Test
    public void sulfurasQuality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality == 80);
    }
    @Test
    public void sulfurasSellIn() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].sellIn == 10);
    }
    /*
     * Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
     * Quality drops to 0 after the concert
     */
    @Test
    public void qualityBackstage10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality,22);
    }
    @Test
    public void qualityBackstage5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality,23);
    }
    @Test
    public void qualityConjured() {
        Item[] items = new Item[] { new Item("Conjured", 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality,18);
    }
    @Test
    public void qualityConjured0() {
        Item[] items = new Item[] { new Item("Conjured", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality,16);
    }
	
    

}

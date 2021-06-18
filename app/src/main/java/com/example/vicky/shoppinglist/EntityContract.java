package com.example.vicky.shoppinglist;

public final class EntityContract {

    private EntityContract() {}

    public static class ListEntry {
        public static final String TABLE_NAME = "list_info";
        public static final String LIST_ID = "list_id";
        public static final String ITEM_NAME = "item";
        public static final String COST_PER_UNIT ="cost";
        public static final String QUANTITY = "quantity";

    }
}

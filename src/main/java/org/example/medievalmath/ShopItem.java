package org.example.medievalmath;
public class ShopItem {
        // Instance variables
        private int item_cost;
        private boolean isItem_Owned;
        private String item_name;

       // Constructor
        public ShopItem(int item_cost, boolean isItem_Owned, String item_name) {
            this.item_cost = item_cost;
            this.isItem_Owned = isItem_Owned;
            this.item_name = item_name;
        }

       // get and set method for ShopItem
        public int getItemCost() {
            return this.item_cost;
        }

        public boolean getIsItemOwned() {
            return this.isItem_Owned;
        }

        public String getItemName() {
            return this.item_name;
        }

        public void setItemCost(int item_cost) {
            this.item_cost = item_cost;
        }

        public void setIsItemOwned(boolean isItem_Owned) {
            this.isItem_Owned = isItem_Owned;
        }

        public void setItemName(String item_name) {
            this.item_name = item_name;
        }

       // Method to handle purchasing of the item
        public void purchase() {
            // Implementation to handle item purchase goes here
        }
    }



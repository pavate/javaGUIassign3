package pavate;

public enum Fields {

    ITEM_ID("Inventory ID: "),
    ITEM_NAME("Item Name: "),
    QOH("Qty. On Hand: "),
    ROP("Re-Order Point: "),
    PRICE("Unit Price: ");
    private final String caption;

    /**
     *
     * @param caption
     */
    private Fields(String caption) {
        this.caption=caption;
    }

    String getCaption() {
        return this.caption;
    }

}

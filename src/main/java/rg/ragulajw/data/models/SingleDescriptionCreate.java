package rg.ragulajw.data.models;

import rg.ragulajw.data.domain.Image;

public class SingleDescriptionCreate {
    //private Image image;
    //private String imageRef;
    //private String text;
    private int _column;
    private int placeInColumn;

    public int get_column() {
        return _column;
    }

    public void set_column(int _column) {
        this._column = _column;
    }

    public int getPlaceInColumn() {
        return placeInColumn;
    }

    public void setPlaceInColumn(int placeInColumn) {
        this.placeInColumn = placeInColumn;
    }
}

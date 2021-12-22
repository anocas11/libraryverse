package pt.iade.libraryverse.models.views;

public interface UserBooksStatusView {
    Integer getId();
    Boolean getFavorite();
    Boolean getRead();
    Boolean getReading();
    Boolean getHas();
}

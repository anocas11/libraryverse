package pt.iade.libraryverse.models;

import java.lang.annotation.Inherited;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userbooks")
public class UserBooks 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ub_id") private int id;
    @Column(name="ub_user_id") private int userId;
    @Column(name="ub_book_id") private int bookId;
    @Column(name="ub_favorite") private boolean favorite;
    @Column(name="ub_read") private boolean read; 
    @Column(name="ub_reading") private boolean reading;
    @Column(name="ub_has") private boolean has;

    public UserBooks()
    {
        
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public boolean isFavorite() {
        return favorite;
    }
    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
    public boolean isRead() {
        return read;
    }
    public void setRead(boolean read) {
        this.read = read;
    }
    public boolean isReading() {
        return reading;
    }
    public void setReading(boolean reading) {
        this.reading = reading;
    }
    public boolean isHas() {
        return has;
    }
    public void setHas(boolean has) {
        this.has = has;
    }  

    
}

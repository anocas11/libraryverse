package main.java.pt.iade.libraryverse.models;

import java.lang.annotation.Inherited;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="book_id") private int id;
    @Column(name="book_name") private String name;
    @Column(name="book_date") private String date;
    public Unit() {}
    public int getId() { return id; }

}

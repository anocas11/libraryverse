package main.java.pt.iade.libraryverse.models;

import java.lang.annotation.Inherited;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="cla_id") private int id;
    @Column(name="cla_name") private String name;
    @Column(name="cla_credits") private int credits;
    public Unit() {}
    public int getId() { return id; }

}

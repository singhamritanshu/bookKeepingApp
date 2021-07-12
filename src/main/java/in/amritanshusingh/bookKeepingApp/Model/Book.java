package in.amritanshusingh.bookKeepingApp.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Book {

    private String name;
    private int id;
    private String authorName;
    private int cost;

    public Book(String name, int id, String authorName, int cost) {
        this.name = name;
        this.id = id;
        this.authorName = authorName;
        this.cost = cost;
    }
}
package entity;

import java.util.UUID;

public class Book {
    private String id = UUID.randomUUID().toString();
    private String title;
    private String author;
    private Section section;
    private Integer totalBook;
    private Integer availableBook = getTotalBook();

    public Book() {
    }

    public Book(String title, String author, Section section, Integer totalBook) {
        this.title = title;
        this.author = author;
        this.section = section;
        this.totalBook = totalBook;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Integer getTotalBook() {
        return totalBook;
    }

    public void setTotalBook(Integer totalBook) {
        this.totalBook = totalBook;
    }

    public Integer getAvailableBook() {
        return availableBook;
    }

    public void setAvailableBook(Integer availableBook) {
        this.availableBook = availableBook;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", totalBook=" + totalBook +
                ", availableBook=" + availableBook +
                '}';
    }
}

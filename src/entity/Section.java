package entity;

import entity.enums.SectionState;

import java.util.List;

public class Section {
    private String id;
    private String name;
    private List<Book> books;
    private SectionState status;

    public Section() {
    }

    public Section(String id, String name, List<Book> books, SectionState status) {
        this.id = id;
        this.name = name;
        this.books = books;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public SectionState getStatus() {
        return status;
    }

    public void setStatus(SectionState status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", books=" + books +
                ", status=" + status +
                '}';
    }
}

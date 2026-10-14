package W4.B10_MediaLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class MediaItem {
    protected String id;
    protected String name;

    public MediaItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId()   { return id; }
    public String getName() { return name; }

    public abstract String getInfo();
}

class Book extends MediaItem {
    private String author;
    private int pages;

    public Book(String id, String name, String author, int pages) {
        super(id, name);
        this.author = author;
        this.pages = pages;
    }

    @Override
    public String getInfo() {
        return name + " - " + author + " - " + pages;
    }
}

class DVD extends MediaItem {
    private String director;
    private int duration;

    public DVD(String id, String name, String director, int duration) {
        super(id, name);
        this.director = director;
        this.duration = duration;
    }

    @Override
    public String getInfo() {
        return name + " - " + director + " - " + duration;
    }
}

class LibrarySection<T extends MediaItem> {
    private String sectionName;
    private List<T> items = new ArrayList<>();

    public LibrarySection(String sectionName) {
        this.sectionName = sectionName;
    }

    public void addItem(T item) {
        items.add(item);
    }

    public boolean removeItem(String id) {
        return items.removeIf(item -> item.getId().equals(id));
    }

    public void display() {
        System.out.println(sectionName + ":");
        for (T item : items) {
            System.out.println(item.getInfo());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LibrarySection<Book> bookSection = new LibrarySection<>("Khu vực Sách");
        LibrarySection<DVD> dvdSection = new LibrarySection<>("Khu vực DVD");

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();
            String person = sc.next();
            int number = sc.nextInt();

            if (type.equals("B")) {
                bookSection.addItem(new Book(id, name, person, number));
            } else {
                dvdSection.addItem(new DVD(id, name, person, number));
            }
        }

        bookSection.display();
        System.out.println();
        dvdSection.display();
    }
}

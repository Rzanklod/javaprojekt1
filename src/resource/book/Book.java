package resource.book;

import resource.Resource;

public class Book extends Resource {
    private String author;

    public Book(String title, String publisher, int resourceId,
                String author) {
        super(title, publisher, resourceId);
        this.author = author;
    }

    @Override
    public void print(){
        System.out.println("Title: " + getTitle());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("ResourceId: " + getResourceId());
        System.out.println("Author: " + author);
    }

    public boolean isTheSameBook(Book book1){
        if(book1 == null) return false;
        boolean isSameTitle = getTitle().equals(book1.getTitle());
        boolean isSameAuthor = author.equals(book1.getAuthor());
        return isSameTitle && isSameAuthor;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

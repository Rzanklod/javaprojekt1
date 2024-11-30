package resource.book;

import interfaces.Digital;
import resource.ResourceStatus;

public class EBook extends Book implements Digital {
    private double size;
    public int numberOfDownloads;

    public EBook(String title, String publisher, int resourceId,
                 String author, double size) {
        super(title, publisher, resourceId, author);
        this.size = size;
        setStatus(ResourceStatus.DIGITAL);
    }

    @Override
    public void print(){
        System.out.println("Title: " + getTitle());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("ResourceId: " + getResourceId());
        System.out.println("Author: " + getAuthor());
        System.out.println("Size: " + size);
    }

    @Override
    public void download(){
        numberOfDownloads++;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}

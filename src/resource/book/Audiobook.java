package resource.book;

import interfaces.Digital;
import resource.ResourceStatus;

public class Audiobook extends Book implements Digital {
    private int length;
    private int numberOfDownload;

    public Audiobook(String title, String publisher, int resourceId,
                     String author, int length){
        super(title, publisher, resourceId, author);
        setStatus(ResourceStatus.DIGITAL);
    }

    @Override
    public void print(){
        System.out.println("Title: " + getTitle());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("ResourceId: " + getResourceId());
        System.out.println("Author: " + getAuthor());
        System.out.println("Length: " + length);
    }

    @Override
    public void download(){
        numberOfDownload++;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getNumberOfDownload() {
        return numberOfDownload;
    }

    public void setNumberOfDownload(int numberOfDownload) {
        this.numberOfDownload = numberOfDownload;
    }
}

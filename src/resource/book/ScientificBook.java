package resource.book;

import interfaces.Scientific;

public class ScientificBook extends PaperBook implements Scientific {
    private String domain;

    public ScientificBook(String title, String publisher, int resourceId,
                          String author, int pages, String domain) {
        super(title, publisher, resourceId, author, pages);
        this.domain = domain;
    }

    @Override
    public void print(){
        System.out.println("Title: " + getTitle());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("ResourceId: " + getResourceId());
        System.out.println("Author: " + getAuthor());
        System.out.println("Pages: " + getPages());
        System.out.println("Domain: " + getDomain());
    }

    @Override
    public String getDomain() {
        return domain;
    }

    @Override
    public boolean isTheSameDomain(Scientific res2){
        if(res2 == null) return false;
        return domain.equals(res2.getDomain());
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}

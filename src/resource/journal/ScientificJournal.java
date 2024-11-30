package resource.journal;

import interfaces.Scientific;

import java.time.LocalDate;

public class ScientificJournal extends Journal implements Scientific {
    private String domain;

    public ScientificJournal(String title, String publisher, int resourceId,
                             LocalDate publishDate, String domain) {
        super(title, publisher, resourceId, publishDate);
        this.domain = domain;
    }

    @Override
    public void print(){
        System.out.println("Title: " + getTitle());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("ResourceId: " + getResourceId());
        System.out.println("PublishDate: " + getPublishDate());
        System.out.println("Domain: " + getDomain());
    }

    @Override
    public boolean isTheSameDomain(Scientific res2){
        if(res2 == null) return false;
        return domain.equals(res2.getDomain());
    }

    @Override
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}

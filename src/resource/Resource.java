package resource;

public abstract class Resource {
    private String title;
    private String publisher;
    private int resourceId;
    private ResourceStatus status;

    public Resource(String title, String publisher, int resourceId) {
        this.title = title;
        this.publisher = publisher;
        this.resourceId = resourceId;
        this.status = ResourceStatus.AVAILABLE;
    }

    public void print(){
        System.out.println("Title: " + title);
        System.out.println("Publisher: " + publisher);
        System.out.println("ResourceId: " + resourceId);
        System.out.println("Status: " + status);
    }

    public ResourceStatus getStatus() {
        return this.status;
    }

    public void setStatus(ResourceStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

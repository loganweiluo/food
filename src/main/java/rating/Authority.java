package rating;

/**
 * Created by weiluo on 20/05/15.
 */
public class Authority {
    private String id;
    private String name;

    public Authority(String id, String name) {
        this.id = id;
        this.name = name;
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
}

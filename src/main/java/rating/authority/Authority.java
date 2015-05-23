package rating.authority;

/**
 * Created by weiluo on 20/05/15.
 */

/**
 * A model that represents authority.
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

    public String getName() {
        return name;
    }
}

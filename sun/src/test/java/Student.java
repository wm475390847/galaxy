import lombok.Builder;
import lombok.Getter;

/**
 * @author wangmin
 * @date 2023/8/24 19:14
 */
@Getter
@Builder
public class Student {

    private String id;
    private String name;
    private String sex;

}

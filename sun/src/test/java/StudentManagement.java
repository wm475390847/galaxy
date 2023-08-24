import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author wangmin
 * @date 2023/8/24 19:15
 */
@Slf4j
public class StudentManagement {

    /**
     * 防止多线程的操作使用：CopyOnWriteArrayList
     */
    private static final List<Student> students = new CopyOnWriteArrayList<>();

    public static void addStudent(String id, String name, String sex) {
        Student student = Student.builder().name(name).id(id).sex(sex).build();
        log.info("学号: {}, 姓名: {}, 性别: {}", student.getId(), student.getName(), student.getSex());
        students.add(student);
    }

    public static void deleteStudent(String id) {
        log.info("删除学员: {}", id);
        students.removeIf(student -> student.getId().equals(id));
    }

    public static void main(String[] args) {
        String[][] info = {{"1001", "张三", "男"}, {"1002", "李四", "女"}, {"1003", "王五", "男"}};
        log.info("添加学员信息:");
        Arrays.stream(info).forEach(student -> addStudent(student[0], student[1], student[2]));
        deleteStudent("1001");
        log.info("删除后学员信息:");
        students.forEach(student -> log.info("学号: {}, 姓名: {}, 性别: {}", student.getId(), student.getName(), student.getSex()));
    }
}

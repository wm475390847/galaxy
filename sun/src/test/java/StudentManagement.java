import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author wangmin
 * @date 2023/8/24 19:15
 */
@Slf4j
public class StudentManagement {

    public static void addStudent(String name, String id, String sex) {
        Student student = Student.builder().name(name).id(id).sex(sex).build();
        log.info("学号: {}, 姓名: {}, 性别: {}", student.getId(), student.getName(), student.getSex());
    }

    public static void deleteStudent() {

    }

    public static void main(String[] args) {
        String[][] students = {{"1001", "张三", "男"}, {"1002", "李四", "女"}, {"1003", "王五", "男"}};
        log.info("添加学员信息:");
        Arrays.stream(students).forEach(student -> addStudent(student[0], student[1], student[2]));
    }
}

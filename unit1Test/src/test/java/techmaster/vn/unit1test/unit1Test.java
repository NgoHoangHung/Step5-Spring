package techmaster.vn.unit1test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class unit1Test {

    int[][] a = { { 12, 23 }, { 123, 431, 3 }, { 122, 33, 22, 11, 22, 11 } };

    class MyClass {

        public void doWriter() throws IOException {
            File file = new File("test.txt");
            FileWriter xx = new FileWriter(file);
            try {
                List<String> lines = new ArrayList<>();
                for (int[] row : a) {
                    StringBuilder lineBuilder = new StringBuilder();
                    for (int cell : row) {
                        lineBuilder.append(cell).append(" ");
                    }
                    String line = lineBuilder.toString().trim() + "\n";

                    xx.write(line);
                }
            } finally {
                xx.close();
            }
        }
    }

    @BeforeEach
    void preProcess() throws Exception {
//        MyClass myClass = new MyClass();
//        myClass.doWriter();
    }

    @Test
    public void testItemToFile(@TempDir Path tempDir) throws IOException {
        //đầu tiên, trỏ vào file mà ta sẽ kiểm tra chuỗi truyền vào bằng cách tạo ra một file đệm
        Path file = tempDir.resolve("test.txt");
        //sau đó ta khởi tạo ra file
        Files.createFile(file);
//        tạo ra công cụ ghi dữ liệu vào bộ nhớ đệm
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            //các dòng mà ta ghi vào bộ đệm sẽ được duyệt qua forEach
            for (int[] row : a) {
//                Sử dụng String Builder để tiết kiệm tài nguyên
                StringBuilder lineBuilder = new StringBuilder();
                for (int cell : row) {
//                    nối chuỗi
                    lineBuilder.append(cell).append(" ");
                }
//                cắt khoảng trắng
                String line = lineBuilder.toString().trim() + "\n";

                writer.write(line);
            }
        }
/*
ta có cách viết khác của forEach
        Arrays.stream(a)
                .forEach(row -> {
                    String line = Arrays.stream(row)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(" "))
                            .concat("\n");
                    writer.write(line);
                });
*/


        List<String> expected = Arrays.asList("12 23", "123 431 3", "122 33 22 11 22 11");
        List<String> actual = Files.readAllLines(file);

        assertEquals(expected, actual, "không ổn rồi");

    }
}

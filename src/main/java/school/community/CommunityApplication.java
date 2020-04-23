package school.community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan扫描mapper包中的mapper才可以使用
@MapperScan(basePackages = "school.community.mapper")
@SpringBootApplication
public class CommunityApplication {
	//测试中文
	public static void main(String[] args) {
		SpringApplication.run(CommunityApplication.class, args);
	}

}

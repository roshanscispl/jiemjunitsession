package jiemjunit;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class Test2 {
	@Test
	@Tag("performence")
	void devide_should_throw_exception() {
		// given 
		int i = 10;
		int j  = 0;
		try {
			ClassLoader classLoader = getClass().getClassLoader();

	        URL resource = classLoader.getResource("test1.properties");
	        File l = null;
	        if (resource == null) {
	            throw new IllegalArgumentException("file is not found!");
	        } else {
	           l = new File(resource.getFile());
	        }
			
			Properties p = new Properties();
			p.load(new FileInputStream(l));
		System.out.println(p.getProperty("env"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

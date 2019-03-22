package com.kevin.redis1.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * 执行逆向工程，生成javabean，mapper
 * @author caonanqing
 *
 */
public class MBGTest {
	
	public static void main(String[] args) throws Exception {
		
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		String file = "mybatis/mbg.xml";
		File configFile = new File(file);
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,callback, warnings);
		myBatisGenerator.generate(null);
		
	}

}

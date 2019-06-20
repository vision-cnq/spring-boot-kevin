package com.kevin.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/5/16
 */
public class MysqlGenerator {

    public static void Generator(String[] tableName) {

        String projectPath = System.getProperty("user.dir");

        //============================== 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/spring-boot-kevin/17-spring-boot-mybatis-plus/src/main/java")
                .setActiveRecord(true)// 是否支持 AR
                .setAuthor("caonanqing") //设置作者名字
                .setFileOverride(true) //文件覆盖(全新文件)
                .setIdType(IdType.AUTO)//主键策略
                .setBaseResultMap(true) //SQL 映射文件
                .setBaseColumnList(true)//SQL 片段
                .setOpen(false);
        //============================== 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MARIADB)
                .setUrl("jdbc:mysql://localhost:3306/lastpass")
                .setDriverName("com.mysql.jdbc.Driver")
                .setUsername("root")
                //.setSchemaName("public")
                .setPassword("123456");
        //==============================包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.kevin")//配置父包路径
                .setModuleName("base")//配置业务包路径
                .setMapper("mapper")
                .setEntity("entity")
                .setService("service")
                .setController("controller");
        //.setServiceImpl("service.impl"); 会自动生成 impl，可以不设定
        //============================== 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/spring-boot-kevin/17-spring-boot-mybatis-plus/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        //============================== 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel)//设置命名规则  underline_to_camel 底线变驼峰
                .setColumnNaming(NamingStrategy.underline_to_camel)//设置设置列命名  underline_to_camel 底线变驼峰
                //.setSuperEntityClass("com.maoxs.pojo")//设置继承类
                //.setSuperControllerClass("com.maoxs.controller")//设置继承类
                .setEntityLombokModel(true)//是否加入lombok
                .setInclude(tableName)//设置表名
                //.setSuperEntityColumns("id") //设置超级超级列
                .setControllerMappingHyphenStyle(true)//设置controller映射联字符
                .setTablePrefix(pc.getModuleName() + "_");//表的前缀
        //============================== 生成配置
        AutoGenerator mpg = new AutoGenerator();
        mpg.setCfg(cfg)
                .setTemplate(new TemplateConfig().setXml(null))
                .setGlobalConfig(gc)
                .setDataSource(dsc)
                .setPackageInfo(pc)
                .setStrategy(strategy)
                // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
                .setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
    public static void main(String[] args) {
        //Generator(new String[]{"x", "xx"});
        Generator(new String[]{""});
    }
}
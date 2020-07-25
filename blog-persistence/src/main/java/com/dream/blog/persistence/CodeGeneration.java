package com.dream.blog.persistence;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.HashMap;

/**
 * =======================
 * 类名: CodeGenerator
 * 描述：
 * 作者：dream colors
 * 日期：2020/7/14 1:03
 * 版本：1.0
 * =======================
 **/
public class CodeGeneration {
    //  文件输出路径
    private static final String outputDir = "blog-persistence/src/main";
    //  xml文件生成地址
    private static final String xmlLocation = outputDir + "/resources/mapper";
    //  类文件生成地址
    private static final String classLocation = outputDir + "/java/com/dream/blog";
    //  需要生成的表
    private static final String [] tableNames = {"user","article","article_meta","comment", "setting", "login_log", "operation_log", "exception_log"};


    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        //生成文件的输出目录
        gc.setOutputDir(projectPath + "/" + outputDir);
        //开发人员
        gc.setAuthor("dreams color");
        //是否打开输出目录
        gc.setOpen(true);
        //service 命名方式
        gc.setServiceName("I%sService");
        //service impl 命名方式
        gc.setServiceImplName("%sServiceImpl");
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(false);
        mpg.setGlobalConfig(gc);

        /*
         * 数据源配置
         */
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        // 数据库类型,默认MYSQL
        dataSourceConfig.setDbType(DbType.MYSQL);
        //自定义数据类型转换
        dataSourceConfig.setTypeConvert(new MySqlTypeConvert());
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/tb_blog?characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        mpg.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName("07-mybatis-plus");//父包模块名
        //父包名。// 自定义包路径  如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setParent("com.dream.blog");
        //pc.setController("controller");
        //pc.setService("service");
        //pc.setServiceImpl("service.impl");
        //pc.setXml(outputDir + "/resources/mapper");
        //  自定义文件生成位置
        HashMap<String, String> map = new HashMap<>();
        map.put(ConstVal.CONTROLLER_PATH, classLocation + "/controller");
        map.put(ConstVal.ENTITY_PATH, classLocation + "/entity");
        map.put(ConstVal.MAPPER_PATH, classLocation + "/mapper");
        map.put(ConstVal.SERVICE_PATH, classLocation + "/service");
        map.put(ConstVal.SERVICE_IMPL_PATH, classLocation + "/service/impl");
        map.put(ConstVal.XML_PATH, xmlLocation);
        pc.setPathInfo(map);
        mpg.setPackageInfo(pc);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //自定义继承的Entity类全称，带包名
        //  strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        //【实体】是否为lombok模型（默认 false）
        strategy.setEntityLombokModel(true);
        //生成 @RestController 控制器
        strategy.setRestControllerStyle(false);
        //strategy.setSuperEntityColumns("id");//自定义基础的Entity类，公共字段
        strategy.setControllerMappingHyphenStyle(true);//驼峰转连字符
        //strategy.setTablePrefix("tb_");//表前缀

        strategy.setInclude(tableNames);//需要包含的表名，允许正则表达式

        //strategy.setSuperEntityColumns("id");//自定义基础的Entity类，公共字段
        strategy.setControllerMappingHyphenStyle(true);//驼峰转连字符
        //strategy.setTablePrefix("tb_");//表前缀
        mpg.setStrategy(strategy);
        /*自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称*/
      /*  TemplateConfig tc = new TemplateConfig();
        tc.setService("/templates/service.java.vm");
        tc.setServiceImpl("/templates/serviceImpl.java.vm");
        tc.setEntity("/templates/entity.java.vm");
        tc.setMapper("/templates/mapper.java.vm");
        tc.setController("/templates/controller.java.vm");
        tc.setXml(null);*/
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        //mpg.setTemplate(tc);
        mpg.execute();
    }


}

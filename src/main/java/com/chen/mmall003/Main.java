package com.chen.mmall003;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成器,简化开发
 */
public class Main {

    public static void main(String[] args) {
        //自动生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        //设置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("5846028");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/mmall?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false");
        autoGenerator.setDataSource(dataSourceConfig);

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOpen(true);
        globalConfig.setOutputDir(System.getProperty("user.dir")+"/src/main/java");
        globalConfig.setAuthor("建强");
        globalConfig.setServiceName("%sService");
        autoGenerator.setGlobalConfig(globalConfig);

        //包信息
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.chen.mmall003");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setController("controller");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        autoGenerator.setPackageInfo(packageConfig);

        //生成策略
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel); //下划线转头包，因为数据库的命名带有下划线，我Java中采用驼峰命名法
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        //设置自动填充create_time和update_time
        List<TableFill> list = new ArrayList<>();
        TableFill tableFill1 = new TableFill("create_time", FieldFill.INSERT);
        TableFill tableFill2 = new TableFill("update_time",FieldFill.INSERT_UPDATE);
        list.add(tableFill1);
        list.add(tableFill2);

        strategyConfig.setTableFillList(list);
        autoGenerator.setStrategy(strategyConfig);

        autoGenerator.execute();
    }
}

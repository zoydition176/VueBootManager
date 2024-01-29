package com.example.spb.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

/*
* mbp 代码生成器
* */
public class CodeGenerator {
    public static void main(String[] args) {
        generate();
    }

    private static void generate(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/springboot?serverTimezone=GMT%2b8", "root", "root")
            .globalConfig(builder -> {
                builder.author("nibaba") // 设置作者
                        .enableSwagger() // 开启 swagger 模式
//                        .fileOverride() // 覆盖已生成文件
                        .outputDir("D:\\project\\spb\\src\\main\\java\\"); // 指定输出目录
            })
            /*.dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                if (typeCode == Types.SMALLINT) {
                    // 自定义类型转换
                    return DbColumnType.INTEGER;
                }
                return typeRegistry.getColumnType(metaInfo);

            }))*/
            .packageConfig(builder -> {
                builder.parent("com.example.spb") // 设置父包名
                        .moduleName(null) // 设置父包模块名
                        .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\project\\spb\\src\\main\\resources\\mapper\\")); // 设置mapperXml生成路径
            })
            .strategyConfig(builder -> {
                builder.entityBuilder().enableLombok();
//                builder.mapperBuilder().enableMapperAnnotation().build();
                builder.controllerBuilder().enableHyphenStyle().enableRestStyle();
                builder.addInclude("sys_user") // 设置需要生成的表名
                        .addTablePrefix("t_", "sys_")
                        .entityBuilder().enableLombok().enableFileOverride()
                        .controllerBuilder().enableFileOverride()
                        .mapperBuilder().enableFileOverride()
                        .serviceBuilder().enableFileOverride();
            })
//            .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
            .execute();
    }
}

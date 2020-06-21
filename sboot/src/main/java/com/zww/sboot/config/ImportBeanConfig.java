package com.zww.sboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author zhaoww
 * @since 2020/06/21
 */
@Configuration
@Import(MyImportBeanDefinitionRegistrar.class)
public class ImportBeanConfig {
}

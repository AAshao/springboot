package com.ss.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;


/**
 * 引入类，交给spring容器管理
 *  
 *	@author huanhongzhao
 *	@date 2018年9月9日 上午8:59:53 
 *
 */
public class MyImportSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"com.ss.entity.StudentInfo"};
	}

}

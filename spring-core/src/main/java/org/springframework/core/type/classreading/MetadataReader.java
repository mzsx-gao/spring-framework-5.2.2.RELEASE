/*
 * Copyright 2002-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core.type.classreading;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;

/**
 * 通过 ASM 读取class 元数据信息
 */
public interface MetadataReader {

	/**
	 * 返回class文件的IO资源引用
	 */
	Resource getResource();

	/**
	 * 读取类元数据
	 */
	ClassMetadata getClassMetadata();

	/**
	 * 读取类的完整的注解metadata，包括注解方法的metadata
	 */
	AnnotationMetadata getAnnotationMetadata();

}

/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.elasticspring.cache.config;

import com.google.code.ssm.Cache;
import com.google.code.ssm.spring.SSMCache;
import org.elasticspring.core.support.documentation.RuntimeUse;
import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * @author Alain Sahli
 * @author Agim Emruli
 * @since 1.0
 */
public class SsmCacheFactoryBean extends AbstractFactoryBean<SSMCache> {

	private final Cache cache;
	private final int expiration;
	private boolean allowClear;

	public SsmCacheFactoryBean(Cache cache, int expiration) {
		this.cache = cache;
		this.expiration = expiration;
	}

	@RuntimeUse
	public void setAllowClear(boolean allowClear) {
		this.allowClear = allowClear;
	}

	@Override
	public Class<?> getObjectType() {
		return SSMCache.class;
	}

	@Override
	protected SSMCache createInstance() throws Exception {
		return new SSMCache(this.cache, this.expiration, this.allowClear);
	}
}
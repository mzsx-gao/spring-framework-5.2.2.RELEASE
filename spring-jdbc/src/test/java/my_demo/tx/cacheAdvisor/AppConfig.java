package my_demo.tx.cacheAdvisor;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

//启动缓存功能
@EnableCaching
@ComponentScan
@Configuration
public class AppConfig {

	@Bean
	public FactoryBean<ConcurrentMapCache> mapCache() {
		ConcurrentMapCacheFactoryBean bean = new ConcurrentMapCacheFactoryBean();
		bean.setName("mapCache");
		return bean;
	}

	@Bean
	public CacheManager simpleCacheManager(@Qualifier("mapCache") Cache mapCache) {
		SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
		List<Cache> list = new ArrayList<>();
		list.add(mapCache);
		simpleCacheManager.setCaches(list);
		return simpleCacheManager;
	}
}
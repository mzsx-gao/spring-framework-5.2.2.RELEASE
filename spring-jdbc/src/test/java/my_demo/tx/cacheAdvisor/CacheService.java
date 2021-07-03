package my_demo.tx.cacheAdvisor;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    @Cacheable(value = "mapCache",key = "'gao' + #id")
    public String queryData(String id) {
        System.out.println("======CacheServiceImpl.queryData");
        return "返回值";
    }

    @CachePut(value = "mapCache",key = "'gao' + #id")
    public String putCache(String id) {
        System.out.println("======CacheServiceImpl.queryData");
		return null;
    }

    @Cacheable(value = "mapCache",key = "'gao' + #id")
    public String getCache(String id) {
        return null;
    }

    @CacheEvict(value = "mapCache",key = "'gao' + #id")
    public void delete(String id) {
        System.out.println("=========删除数据");
    }
}
package my_demo.tx.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

	@Async
    public String queryData(String id) {
        System.out.println("======CacheServiceImpl.queryData");
        return "返回值";
    }

	@Scheduled(cron = "0 * * * * ? *")
	public String scheduled(String id) {
		System.out.println("======CacheServiceImpl.queryData");
		return "返回值";
	}
}
package my_demo.aop.autoconfig;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {

	@Override
	public int add(int i, int j) {
		int result = i + j;
		System.out.println("add方法...");
		return result;
	}

	@Override
	public int sub(int i, int j) {
		int result = i - j;
		return result;
	}

	@Override
	public int mul(int i, int j) {
		int result = i * j;
		return result;
	}

	@Override
	public int div(int i, int j) {
		System.out.println("div方法...");
		int result = i / j;
		return result;
	}

}

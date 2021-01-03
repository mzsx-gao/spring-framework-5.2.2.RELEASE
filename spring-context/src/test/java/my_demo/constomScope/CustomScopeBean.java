package my_demo.constomScope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("refreshScope")
public class CustomScopeBean {

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "CustomScopeBean{" +
				"username='" + username + '\'' +
				'}';
	}
}

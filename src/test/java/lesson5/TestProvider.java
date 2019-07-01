package lesson5;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class TestProvider {

    private static TestProvider instance;

    @Getter @Setter
    private WebDriver driver;

    public static TestProvider getInstance() {
        if (instance == null) {
            instance = new TestProvider();
        }
        return instance;
    }
}
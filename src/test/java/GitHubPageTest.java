import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GitHubPageTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl= "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void gitHubEnterpriseShouldHaveHeader(){
        Selenide.open("");
        $(".HeaderMenu-nav").$(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        $("[aria-labelledby='hero-section-brand-heading'").shouldHave(text("The AI-powered developer platform."));
    }
}

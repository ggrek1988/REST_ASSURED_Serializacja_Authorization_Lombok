package github;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AuthTest {

    private static String TOKEN = "YOUR_TOKEN";

    @Test
    public void basicAuth() {
        given()
                .auth()
                //zalecane preemptive()
                .preemptive()
                .basic("username", "password")
                .when()
                .get(" https://api.github.com/users")
                .then()
                .statusCode(HttpStatus.SC_OK);


    }

    @Test
    public void bearerToken() {
        given()
                .header("Authorization", "Bearer " + TOKEN)
                .when()
                .get(" https://api.github.com/users")
                .then()
                .statusCode(HttpStatus.SC_OK);


    }

    @Test
    public void oAuth2() {
        given()
                .auth()
                .oauth2(TOKEN)
                .when()
                .get(" https://api.github.com/users")
                .then()
                .statusCode(HttpStatus.SC_OK);


    }
}

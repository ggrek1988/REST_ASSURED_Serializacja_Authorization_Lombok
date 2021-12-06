package jsonplaceholder;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.assertj.core.api.Assertions.*;

public class PostTest {

    @Test
    public void CreatePost() {

//        JSONObject post = new JSONObject();
//        post.put("userId", "1");
//        post.put("titles", "sunt aut facere repellat provident");
//        post.put("body", "quia et suscipit");

        //SERIALIZACJA stworzenie klasy z metodami getter and setter z pustym konstruktorem
        Post post = new Post();
        post.setUserId(1);
        post.setTitle("aaaaa");
        post.setBody("bbbbb");



        Response response = given()
                //POJO - JSON = serializacja
                .contentType(ContentType.JSON)
                .body(post)
                .when()
                .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertThat(json.getString("title")).isEqualTo(post.getTitle());


    }

    @Test
    public void readPost() {


        Post as = given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")
                //DESERIALIZACJA
                .as(Post.class);



       assertThat(as.getTitle()).isEqualTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");


    }



}

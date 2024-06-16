package testingAPI;

import io.restassured.RestAssured;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTests {

    @BeforeEach
    public  void setUp(){
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    @Order(1)
    @DisplayName("id_1. Проверка GET-запроса  с параметрами (foo1=bar1, foo2=bar2)")
    public void givenRequestQueryParamsWhenGetThenStatusCode200(){
         given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .log().body()
                .assertThat()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    @Order(2)
    @DisplayName("id_2. Проверка POST-запроса (Raw Text)")
    public void givenRequestRawTextWhenPOST_ThenStatusCode200(){
        String requestBody = "{\n" + "    \"test\": \"value\"\n" + "}";
        given()
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .log().body()
                .assertThat()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    @Order(3)
    @DisplayName("id_3. Проверка POST-запроса (Form Data)")
    public void givenRequestFormParamWhenPOST_thenStatusCode200() {
        given()
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .header("Cookie", "sails.sid=s%3AE-IpjOHE62Q1fgqFGgpDWFjEdEd1XV3N.jAQc53dA6naMGXI0hQS610z%2FPZTPIg%2F76wbvFu3rE8E")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .log().body()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/post"));

    }

    @Test
    @Order(4)
    @DisplayName("id_4. Проверка PUT-запроса (raw text)")
    public void givenRequestRawWhenPUT_thenStatusCode200(){
        String requestBody = "This is expected to be sent back as part of response body.";
        given()
                .header("Content-Type", "text/plain")
                .header("Cookie", "sails.sid=s%3AxLkfWw68XUQnvy0SRe30rucvX62EYdAz.aPd04q9zyfNlNJDxZuTozKYjfgT3WTDBI3axZzwm1Qw")
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .log().body()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    @Order(5)
    @DisplayName("id_5. Проверка PATCH-запроса (raw text)")
    public void givenRequestRawWhenPATCH_thenStatusCode200(){
        String requestBody = "This is expected to be sent back as part of response body.";
        given()
                .header("Content-Type", "text/plain")
                .header("Cookie", "sails.sid=s%3AmDjmpAt-PALeXDaNDRD7FXfl-Uwhs6Bg.%2F5RoFTQKJlxwNrgtQzcuH9QPgTp7Lcnc8U2Oe4abTPI")
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .log().body()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    @Order(6)
    @DisplayName("id_6. Проверка DELETE-запроса (raw text)")
    public void givenRequestRawWhenDELETE_thenStatusCode200(){
        String requestBody = "This is expected to be sent back as part of response body.";
        given()
                .header("Content-Type", "text/plain")
                .header("Cookie", "sails.sid=s%3ANYutjjvR03VUTBfdFDOKtHUtyOxZz2fK.2fdYuE5xJ7KQrrTtvUHkw6326VdLQeJ3JweeFfdr5KM")
                .body(requestBody)
                .when()
                .delete("/delete")
                .then()
                .log().body()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }



}

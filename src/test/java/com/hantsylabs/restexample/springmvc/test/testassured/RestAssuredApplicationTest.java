package com.hantsylabs.restexample.springmvc.test.testassured;

import com.hantsylabs.restexample.springmvc.model.PostForm;
import com.hantsylabs.restexample.springmvc.test.WebIntegrationTestBase;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RestAssuredApplicationTest extends WebIntegrationTestBase {


    private static final Logger log = org.slf4j.LoggerFactory.getLogger(RestAssuredApplicationTest.class);

    @Before
    public void beforeTest() {
        super.setup();
        RestAssured.port = port;
    }

    @Test
    public void testDeletePostNotExisted() {
        String location = "/api/posts/1000";

        given()
                .auth().basic(USER_NAME, PASSWORD)
                .contentType(ContentType.JSON)
                .when()
                .delete(location)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void testGetPostNotExisted() {
        String location = "/api/posts/1000";

        given()
                .auth().basic(USER_NAME, PASSWORD)
                .contentType(ContentType.JSON)
                .when()
                .get(location)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void testPostFormInValid() {
        PostForm form = new PostForm();

        given()
                .auth().basic(USER_NAME, PASSWORD)
                .body(form)
                .contentType(ContentType.JSON)
                .when()
                .post("/api/posts")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void testPostCRUD() {
        PostForm form = new PostForm();
        form.setTitle("test title");
        form.setContent("test content");

        Response response = given()
                .auth().basic(USER_NAME, PASSWORD)
                .body(form)
                .contentType(ContentType.JSON)
                .when()
                .post("/api/posts")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .and()
                .header("Location", containsString("/api/posts/"))
                .extract().response();

        String location = response.header("Location");

        log.debug("header location value @" + location);

        given().auth().basic(USER_NAME, PASSWORD)
                .contentType(ContentType.JSON)
                .when()
                .get(location)
                .then()
                .assertThat()
                .body("title", is("test title"))
                .body("content", is("test content"));

        PostForm updateForm = new PostForm();
        updateForm.setTitle("test udpate title");
        updateForm.setContent("test update content");

        given()
                .auth().basic(USER_NAME, PASSWORD)
                .body(updateForm)
                .contentType(ContentType.JSON)
                .when()
                .put(location)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NO_CONTENT);

        given().auth().basic(USER_NAME, PASSWORD)
                .contentType(ContentType.JSON)
                .when()
                .get(location)
                .then()
                .assertThat()
                .body("title", is("test udpate title"))
                .body("content", is("test update content"));

        given()
                .auth().basic(USER_NAME, PASSWORD)
                .contentType(ContentType.JSON)
                .when()
                .delete(location)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NO_CONTENT);

        given().auth().basic(USER_NAME, PASSWORD)
                .contentType(ContentType.JSON)
                .when()
                .get(location)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);

    }

}

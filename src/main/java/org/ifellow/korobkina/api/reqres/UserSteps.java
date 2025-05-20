package org.ifellow.korobkina.api.reqres;

import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.ifellow.korobkina.dto.user.User;
import org.ifellow.korobkina.utils.MapperUtils;

public class UserSteps {
    private static final UserApi userApi = new UserApi();

    public JsonPath getAllUsers() {
        return userApi.getAllUser()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .jsonPath();
    }

    public User createNewUserFromFile(String newName, String job) {
        User newUser = MapperUtils.readFromFile("src/test/resources/reqres/user.json", User.class);
        newUser.setName(newName);
        newUser.setJob(job);
        return userApi.postUser(newUser)
                .statusCode(HttpStatus.SC_CREATED)
                .assertThat()
                .body("name", Matchers.is(newName))
                .body("job", Matchers.is(job))
                .extract()
                .body()
                // .jsonPath();
                .as(User.class);
    }

   /*public JsonPath createNewUser(String name, String job){
        return userApi.postUser(new User(name, job))
                .statusCode(HttpStatus.SC_CREATED)
                .assertThat()
                .body("name", Matchers.is(name))
                .body("job", Matchers.is(job))
                .extract()
                .body()
                .jsonPath();
    }*/
}

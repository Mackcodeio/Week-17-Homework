package com.api.studentinfo;

import com.api.constants.EndPoints;
import com.api.model.StudentPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.List;

import static net.serenitybdd.rest.RestRequests.given;

public class StudentSteps {

    @Step("Create new Student")
    public ValidatableResponse createStudent(String firstName, String lastName, String email, String programme, List<String> courseList){

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName(firstName);
        studentPojo.setLastName(lastName);
        studentPojo.setEmail(email);
        studentPojo.setProgramme(programme);
        studentPojo.setCourses(courseList);

        System.out.println("Student Pojo: "+studentPojo);

        return SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(studentPojo)
                .when()
                .post()
                .then();

    }

    @Step("Getting response by firstName")
    public HashMap<String, Object> getStudentByFirstName(String firstName){
        String a1 = "findAll{it.firstName=='";
        String a2 = "'}.get(0)";

        System.out.println("Equal check "+a1 + firstName + a2);
        return SerenityRest.given()
                .when()
                .get(EndPoints.GET_ALL_STUDENT)
                .then()
                .statusCode(200)
                .extract()
                .path(a1 +firstName+ a2);
    }

    public ValidatableResponse updateStudent(int StudentID,String firstName, String lastname, String email, String programme, List<String> courseList){
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName(firstName);
        studentPojo.setLastName(lastname);
        studentPojo.setEmail(email);
        studentPojo.setProgramme(programme);
        studentPojo.setCourses(courseList);

        return SerenityRest.given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("studentID",StudentID)
                .body(studentPojo)
                .when()
                .put(EndPoints.UPDATE_STUDENT_BY_ID)
                .then()
                .statusCode(200);
    }

    public ValidatableResponse getStudentByID(int studentID){
            return SerenityRest.given()
                    .pathParam("studentID",studentID)
                    .when()
                    .get(EndPoints.GET_SINGLE_STUDENT_BY_ID)
                    .then();

    }

    public void deleteStudentID(int studentID){
        given()
                .header("Content-Type", "application/json")
                .pathParam("studentID",studentID)
                .when()
                .delete(EndPoints.DELETE_STUDENT_BY_ID)
                .then().statusCode(204);
    }
//    @Step("Create new student")
//    public ValidatableResponse createStudent(String firstName, String lastName, String email, String programme, List<String> courseList) {
//
//       /* ArrayList<String> courses= new ArrayList<>();
//        courses.add("selenium");
//        courses.add("Restassured");*/   // pass it during run time
//
//        StudentPojo studentPojo = new StudentPojo();
//        studentPojo.setFirstName(firstName);
//        studentPojo.setLastName(lastName);
//        studentPojo.setEmail(email);
//        studentPojo.setProgramme(programme);
//        studentPojo.setCourses(courseList);
//
//        return SerenityRest.given()
//                .header("Content-Type", "application/json")
//                .body(studentPojo)
//                .when()
//                .post()
//                .then();
//    }
//
//    @Step("Getting response by firstname")
//    public HashMap<String, Object>  getStudentByFirstname(String firstName) {
//
//        String a1 = "findAll{it.firstName=='";
//        String a2 ="'}.get(0)";
//        return SerenityRest. given()
//                .when()
//                .get(EndPoints.GET_ALL_STUDENT)
//                .then()
//                .statusCode(200)
//                .extract()
//                .path(a1 +firstName+ a2);
//    }
//
//    @Step("update student by email, programme")
//    public ValidatableResponse updateStudent(int studentID,String firstName, String lastName, String email, String programme, List<String> courseList) {
//        StudentPojo studentPojo= new StudentPojo();
//        studentPojo.setFirstName(firstName);
//        studentPojo.setLastName(lastName);
//        studentPojo.setEmail(email);
//        studentPojo.setProgramme(programme);
//        studentPojo.setCourses(courseList);
//
//       return SerenityRest. given()
//                .log().all()
//                .header("Content-Type", "application/json")
//                .pathParam("studentID",studentID)
//                .body(studentPojo)
//                .when()
//                .put(EndPoints.UPDATE_STUDENT_BY_ID)
//                .then();
//    }
//
//
//   @ Step("delete student by ID")
//    public ValidatableResponse deleteStudent(int studentID){
//       return SerenityRest. given()
//                .header("Content-Type", "application/json")
//                .pathParam("studentID",studentID)
//                .when()
//                .delete(EndPoints.DELETE_STUDENT_BY_ID)
//                .then();
//
//    }
//
// public ValidatableResponse getStudentByID(int studentID){
//
//     return SerenityRest.given()
//             .pathParam("studentID",studentID)
//             .when()
//             .get(EndPoints.GET_SINGLE_STUDENT_BY_ID)
//             .then()
//             .log().all();
//
// }
//
}

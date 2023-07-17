package com.api.studentinfo;

import com.api.testbase.TestBase;
import com.api.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasValue;


@RunWith(SerenityRunner.class)
public class StudentCURDTestWithSteps extends TestBase {

    static String firstName = "Mahesh" + TestUtils.getRandomValue();
    static String lastName = "Hirpara" + TestUtils.getRandomValue();
    static String email = "mack"+TestUtils.getRandomValue()+"@gmail.com";
    static String programme = "Computer Science";
    static int studentId;

    @Steps
    StudentSteps studentSteps;


    @Title("This will create new student")
    @Test
    public void test001() {

        List<String> courseList = new ArrayList<>();
        courseList.add("java");
        courseList.add("api");
        System.out.println("First Name: "+firstName);
        System.out.println("lastName: "+lastName);
        System.out.println("email: "+email);
        System.out.println("programme: "+programme);
        System.out.println("courseList: "+courseList);


        ValidatableResponse response = studentSteps.createStudent(firstName, lastName, email, programme, courseList);
        response.statusCode(201);
    }

    @Title("This will verify new student")
    @Test
    public void test002(){
        HashMap<String,Object> studentDetails = studentSteps.getStudentByFirstName(firstName);
        Assert.assertThat(studentDetails, hasValue(firstName));
        studentId = (int) studentDetails.get("id");
        System.out.println(studentId);
    }

    @Title("This will update student")
    @Test
    public void test003(){
        firstName =firstName + "MR";
        List<String> courseList = new ArrayList<>();
        courseList.add("Java");
        courseList.add("Api");

        studentSteps.updateStudent(studentId,firstName,lastName,email,programme,courseList);
        System.out.println("Update Recorde Successfully");

        // Verify Record is Update or not
        ValidatableResponse studentDetails = studentSteps.getStudentByID(studentId);
        studentDetails.body("firstName", containsString(firstName));

    }

    @Title("This method delete Student")
    @Test
    public void test004(){
        studentSteps.deleteStudentID(studentId);
        studentSteps.getStudentByID(studentId).statusCode(404);
    }
}

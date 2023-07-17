package com.api.studentinfo;

import com.api.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;


@UseTestDataFrom("src/test/java/resources/testdata/studentinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateStudentDataDrivenTest extends TestBase {

    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private String course1;
    private String course2;

    @Steps
    StudentSteps studentSteps;

    @Test
    public void createMultipleStudents() {
        List<String> courseList = new ArrayList<>();
        courseList.add(course1);
        courseList.add(course2);
        studentSteps.createStudent(firstName, lastName, email, programme, courseList);

    }


}



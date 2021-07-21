package com.example.thebestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.thebestapp.adapter.CategoryAdapter;
import com.example.thebestapp.adapter.CourseAdapter;
import com.example.thebestapp.model.Category;
import com.example.thebestapp.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullCoursesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Games"));
        categoryList.add(new Category(2, "Web"));
        categoryList.add(new Category(3, "Test"));
        categoryList.add(new Category(4, "Test"));
        categoryList.add(new Category(5, "Test"));
        categoryList.add(new Category(6, "Other"));

        setCategoryRecycler(categoryList);


        courseList.add(new Course(1, "java", "Java Developer", "soon", "beginner", "#424345", "Useful info about the course", 3));
        courseList.add(new Course(2, "py", "Python Developer", "soon", "beginner", "#9FA52D", "Useful info about the course", 3));
        courseList.add(new Course(3, "java", "Android Developer", "soon", "beginner", "#424345", "Useful info about the course", 1));

        fullCoursesList.addAll(courseList);
        setCourseRecycler(courseList);

    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    private void setCourseRecycler(List<Course> courseList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

    public static void showCoursesByCategory(int category){
        courseList.clear();
        courseList.addAll(fullCoursesList);
        List<Course> filterCourses = new ArrayList<>();

        for(Course c : courseList) {
            if (c.getCategory() == category) {
                filterCourses.add(c);
            }
        }
        courseList.clear();
        courseList.addAll(filterCourses);

        courseAdapter.notifyDataSetChanged();
    }
}
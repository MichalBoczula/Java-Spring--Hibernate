package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName() {
        //Given
        final TaskList taskList = new TaskList("ToDO", "you have to do this things");

        //When
        taskListDao.save(taskList);
        final List<TaskList> testTaskList = taskListDao.findByListName(taskList.getListName());

        //Then
        assertEquals(1, testTaskList.size());

        //CleanUp
        taskListDao.delete(taskList);
    }
}
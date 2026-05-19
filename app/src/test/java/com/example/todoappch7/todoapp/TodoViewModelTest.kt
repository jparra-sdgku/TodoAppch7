package com.example.todoappch7.todoapp

import com.example.todoappch7.TodoViewModel
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class TodoViewModelTest {
    // The system under test recreated before each test
    private lateinit var viewModel: TodoViewModel

    @Before
    fun setUp(){
        viewModel = TodoViewModel()
    }
    @Test
    fun add_Task_withValidTitle_appearsInList(){
        // Arrange - The setUp() already created and empty ViewModel

        // Act -- Call the function we want to test
        viewModel.addTask("Do exercise")

        // Asser-- Verify the result
        assertEquals(1,viewModel.getTaskCount())
        assertTrue(viewModel.containsTask("Do exercise"))

    }
    // Mini Challenge
    // For add_Task(), the edge case is a blank tittle
    // Teh viewModel should silently ignore it
    @Test
    fun add_Task_whitBlankTitle_isIgnored(){     //"      "

    }


    @Test
    fun add_Task_withEmptyString_isIgnored(){   //""

    }

    @Test
    fun add_Task_tittleIsTrimmed(){    //  "    Do    Exercise   "
        // Leading and trailing spaces should be removed
        viewModel.addTask("  Do Exercise    ")
        assertTrue(viewModel.containsTask("Do Exercise"))
    }

    // REMOVE TASK
    @Test
    fun removeTask_withValidId_removesTask(){
        // Arrange - add a task first so we have something to remove
        viewModel.addTask("Do Exercise")
        val taskId = viewModel.task[0].id

        // Act
        viewModel.removeTask(taskId)

        // Assert
        assertEquals(0,viewModel.getTaskCount())
        assertFalse(viewModel.containsTask("Do Exercise"))
    }

    // Challenge
    @Test
    fun removeTask_withInvalidId_doesNothing(){
        // removing a non-existing id should not crash or affect the list
        viewModel.addTask("Do Exercise")
        viewModel.removeTask(99)
        assertEquals(1,viewModel.getTaskCount())
    }

}












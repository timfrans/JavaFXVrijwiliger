package tests;

import model.Group;
import model.Student;
import org.junit.Test;

import static org.junit.Assert.*;

public class GroupTest {
    @Test
    public void testPickStudent() {
        Group g = new Group();

        Student lowest = g.pickStudent();

        assertEquals(3, lowest.getScore());
    }
}

package csc220;

public class OrderByName implements Order
{
    public boolean comesAfter(Student s1, Student s2)
    {
        return s1.getName().compareTo(s2.getName()) > 0;
    }
    
    public boolean matches(Student s1, Student s2)
    {
        return s1.getName().equals(s2.getName());
    }    
}

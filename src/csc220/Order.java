package csc220;

public interface Order
{
    public boolean comesAfter(Student s1, Student s2);
    
    public boolean matches(Student s1, Student s2);
   
}

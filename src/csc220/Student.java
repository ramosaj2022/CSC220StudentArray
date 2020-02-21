package csc220;

public class Student
{
    private String name;
    private int id;
    private char grade;  //  Only letter grades--no + or -
    
    private static int nextId = 1;
    
    public Student(int id)  //  Creates a "dummy" Student with a specific ID.
    {
        this.id = id;
        this.name = "";
        this.grade = ' ';
    }
    
    public Student(String name, char grade)
    {
        id = nextId;  // Automatically generate a new id for every new Student.
        nextId += 1;
        this.name = name; 
        this.grade = grade;
    }
    
    public int    getId()   {return id;}
    public String getName() {return name;}
    public char   getGrade(){return grade;}
    
    @Override
    public String toString()
    {
        return id + ":" + name + ":" + grade;
    }
    
    public static void sortBy(Student[] arr, Order orderBy)
    {
        for (int size = arr.length; size > 1; size -= 1)
        {
            int maxPosition = indexOfLargestBy(arr, size, orderBy);
            Student tmp = arr[maxPosition];
            arr[maxPosition] = arr[size-1];
            arr[size-1] = tmp;
        }
    }
    
    private static int indexOfLargestBy(Student[] arr, int size, Order orderBy)
    {
        int answer = 0;
        for (int i = 1; i < size; i += 1)
        {
            if (orderBy.comesAfter(arr[i], arr[answer]))
                answer = i;
        }
        return answer;
    }
    
    public static int binarySearchBy(Student[] arr, Student key, Order orderBy)
    {
        int start = 0;
        int end = arr.length - 1;
        
        while (start <= end)
        {
            int middle = ( start + end ) / 2; 
            if (orderBy.matches(arr[middle], key))
                return middle;
            else if (orderBy.comesAfter(arr[middle], key))
                end = middle - 1;
            else 
                start = middle + 1;
        }
        return -1;
    }
    
    public static int indexOfFirstMatchingBy(Student[] arr, Student key,
                                                Order orderBy)
    {
        int answer = binarySearchBy(arr, key, orderBy);
        while (answer > 0 && orderBy.matches(arr[answer-1], key))
            answer -= 1;       
        return answer;
    }
    
}

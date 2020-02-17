package csc220;

public class Student
{
    private String name;
    private int id;
    private char grade;  //  Only letter grades--no + or -
    
    private static int nextId = 1;
    
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
    
    public static void sortByGrade(Student[] arr, OrderBy orderBy)
    {
        for (int size = arr.length; size > 1; size -= 1)
        {
            int maxPosition = indexOfLargestByGrade(arr, size, orderBy);
            Student tmp = arr[maxPosition];
            arr[maxPosition] = arr[size-1];
            arr[size-1] = tmp;
        }
    }
    
    private static int indexOfLargestByGrade(Student[] arr, int size, OrderBy orderBy)
    {
        int answer = 0;
        for (int i = 1; i < size; i += 1)
        {
            if (orderBy.comesAfter(arr[i], arr[answer]))
                answer = i;
        }
        return answer;
    }
    
    public static int binarySearchForGrade(Student[] arr, Student key, OrderBy orderBy)
    {
        int start = 0;
        int end = arr.length - 1;
        
        while (start <= end)
        {
            int middle = ( start + end ) / 2; 
//            if (arr[middle].getGrade() == gradeToFind)
            if (orderBy.matches(arr[middle], key))
                return middle;
//            else if (gradeToFind < arr[middle].getGrade() )
            else if (orderBy.comesAfter(arr[middle], key))
                end = middle - 1;
            else // gradeToFind > arr[middle].getGrade()
                start = middle + 1;
        }
        return -1;
    }
    
    public static int indexOfFirstMatchingGrade(Student[] arr, Student key,
                                                OrderBy orderBy)
    {
        int answer = binarySearchForGrade(arr, key, orderBy);
        //  Create a dummy student object to compare to.
//        while (answer > 0 && arr[answer-1].getGrade() == gradeToFind)
        while (answer > 0 && orderBy.matches(arr[answer-1], key))
            answer -= 1;
        
        return answer;
    }
    
}

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * A program to add, remove, modify or print
 * student names and grades.
*/
public class Gradebook
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        Map<String, String> grades = new HashMap<> ();

        boolean done = false;
        while(!done)
        {
            System.out.println("A)dd R)emove M)odify P)rint Q)uit");
            String input = in.next().toUpperCase();
            if (input.equals("Q"))
            {
                done = true;
            } else if (input.equals("A"))
            {
                System.out.println("What is the name of the student?");
                String name = in.next().toUpperCase();
                
                System.out.println("What is their grade?");
                String grade = in.next().toUpperCase();

                grades.put(name, grade);

            } else if (input.equals("R"))
            {
                System.out.println("Who do you want to remove?");
                String student = in.next().toUpperCase();

                grades.remove(student);


            } else if (input.equals("M"))
            {
                System.out.println("What is the name of the student?");
                String name = in.next().toUpperCase();
                
                System.out.println("What is their new grade?");
                String grade = in.next().toUpperCase();

                grades.put(name, grade);

            } else if (input.equalsIgnoreCase("P"))
            {
                Set<String> keys = grades.keySet();

                for (String key: keys){
                System.out.println("Name: " + key + " Grade: " + grades.get(key)); }

            } else
            {
                done = true;
            }
        }
    }
}

import java.util.LinkedList;
import java.util.Queue;

/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
*/
public class QueueDemo
{
    public static void main(String[] args)
    {
        // Create a print queue of strings (using a linked list)
        Queue<String> jobs = new LinkedList<>();

        // Add some print jobs
        jobs.add("Joe: Expense Report 2023");
        jobs.add("Cathy: Top Secrete Document #5");

        System.out.println("Printing: " + jobs.remove());

        jobs.add("Cathy: Really Top Secrete Document #2");
        jobs.add("Joe: Grocery List");
        jobs.add("Cathy: Can I Get Fired For This?");

        System.out.println("Printing: " + jobs.remove());

        jobs.add("Boss : Cathy's Termination Letter");

        int k = jobs.size();
        for (int i = 0; i<k; i++){
            System.out.println("Printing: " + jobs.remove());
        }

        // Print the rest of the jobs in the queue


    }
}

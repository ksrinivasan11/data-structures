import java.util.LinkedList;
//import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {   
        
        //ListIterator<String> iterator1 = strings.listIterator();
        //ListIterator<String> iterator2 = strings.listIterator(strings.size()-1);
/*
        for (int i = 0; i < strings.size()/2; i++) {
            
            String str1 = iterator1.next();
            
            String str2 = iterator2.previous();
            iterator1.remove();
            iterator2.remove();
            iterator1.add(str2);
            iterator2.add(str1);
            
            System.out.println(strings);
        }
      
        int k = strings.size();
        while (k > 1){
            if (iterator2.hasPrevious())
                iterator2.previous();
            
            

        }
        */

        for (int i = strings.size()-1; i > -1; i--){
            
            String str = strings.get(i);
            strings.remove(i);
            strings.addLast(str);
        }

        // 1234
        // 1243
        // i = 2
        //
    }
}
import java.util.TreeMap;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class MorseCode
{
    private static final char DOT = '.';
    private static final char DASH = '-';

    private static TreeMap<Character, String> codeMap;
    private static TreeNode decodeTree;

    public static void main(String[] args)
    {
        MorseCode.start();  
        System.out.println(MorseCode.encode("Watson come here"));
        BTreePrinter.printNode(decodeTree);
    }

    public static void start()
    {
        codeMap = new TreeMap<Character, String>();
        decodeTree = new TreeNode(' ', null, null);  // autoboxing
        // put a space in the root of the decoding tree

        addSymbol('A', ".-");
        addSymbol('B', "-...");
        addSymbol('C', "-.-.");
        addSymbol('D', "-..");
        addSymbol('E', ".");
        addSymbol('F', "..-.");
        addSymbol('G', "--.");
        addSymbol('H', "....");
        addSymbol('I', "..");
        addSymbol('J', ".---");
        addSymbol('K', "-.-");
        addSymbol('L', ".-..");
        addSymbol('M', "--");
        addSymbol('N', "-.");
        addSymbol('O', "---");
        addSymbol('P', ".--.");
        addSymbol('Q', "--.-");
        addSymbol('R', ".-.");
        addSymbol('S', "...");
        addSymbol('T', "-");
        addSymbol('U', "..-");
        addSymbol('V', "...-");
        addSymbol('W', ".--");
        addSymbol('X', "-..-");
        addSymbol('Y', "-.--");
        addSymbol('Z', "--..");
        addSymbol('0', "-----");
        addSymbol('1', ".----");
        addSymbol('2', "..---");
        addSymbol('3', "...--");
        addSymbol('4', "....-");
        addSymbol('5', ".....");
        addSymbol('6', "-....");
        addSymbol('7', "--...");
        addSymbol('8', "---..");
        addSymbol('9', "----.");
        addSymbol('.', ".-.-.-");
        addSymbol(',', "--..--");
        addSymbol('?', "..--..");
    }

    /**
     * Inserts a letter and its Morse code string into the encoding map
     * and calls treeInsert to insert them into the decoding tree.
     */
    private static void addSymbol(char letter, String code)
    {
        codeMap.put(letter, code);

        treeInsert(letter, code);
    }

    /**
     * Inserts a letter and its Morse code string into the
     * decoding tree.  Each dot-dash string corresponds to a path
     * in the tree from the root to a node: at a "dot" go left, at a "dash" go
     * right.  The node at the end of the path holds the symbol
     * for that code string.
     */
    private static void treeInsert(char letter, String code)
    {
        TreeNode curNode = decodeTree;
        

        for (int i = 0; i < code.length(); i++){
            char current = code.charAt(i);
            if (current == DOT){
                if(curNode.getLeft() == null)
                    curNode.setLeft(new TreeNode(null));
                curNode = curNode.getLeft(); } 
            if (current == DASH) {
                if(curNode.getRight() == null)
                    curNode.setRight(new TreeNode(null));
                curNode = curNode.getRight(); }
            }
            curNode.setValue(letter);
        }   
        

    /**
     * Converts text into a Morse code message.  Adds a space after a dot-dash
     * sequence for each letter.  Other spaces in the text are transferred directly
     * into the encoded message.
     * Returns the encoded message.
     */
    public static String encode(String text)
    {
        StringBuffer morse = new StringBuffer(400);


        text = text.toUpperCase();
        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == ' '){
                morse.append(" "); }

            String code = codeMap.get(text.charAt(i)) + " ";


            morse.append(code); }
                
                
        return morse.toString();
    }

    /**
     * Converts a Morse code message into a text string.  Assumes that dot-dash
     * sequences for each letter are separated by one space.  Additional spaces are
     * transferred directly into text.
     * Returns the plain text message.
     */
    public static String decode(String morse)
    {
        StringBuffer text = new StringBuffer(100);

        TreeNode tempDec = decodeTree;
        char tempCh;
        
        int spaceCount = 0;
        
        for (int i = 0; i<morse.length(); i++){
            if (morse.charAt(i) == ' ')
                spaceCount++;
        }
        //System.out.println(spaceCount);
        
        
        for (int i = 0; i < spaceCount; i++){
            
            String tempString;
            if (morse.indexOf(" ") == -1){
                tempString = morse.substring(0);
                }
            else{
                tempString = morse.substring(0, morse.indexOf(" ")+1);
                morse = morse.substring(morse.indexOf(" ")+1, morse.length());
                System.out.println(tempString); }
                System.out.println(morse);
                
            
            
            int count = 0;
            while (count < tempString.length()){
            
            tempCh = tempString.charAt(count);
            if (tempCh == DOT){
                tempDec = tempDec.getLeft(); }
            if (tempCh == DASH){
                tempDec = tempDec.getRight(); }
            count++;
            }
            text.append(tempDec.getValue());
            tempDec = decodeTree;
        }
             return text.toString();}

        /* 
        if (morse.contains(" ")){
        while (count < morse.length()){
            
            
            String tempWord = morse.substring(0, morse.indexOf(" "));
            for (int i = 0; i < tempWord.length(); i++){
                tempCh = tempWord.charAt(i);
                

                if (tempCh == ' '){
                    text.append(" ");
                    tempDec = decodeTree;}
                if (tempCh == DOT){
                    tempDec = tempDec.getLeft(); }
                if (tempCh == DASH){
                    tempDec = tempDec.getRight(); }
                else{
                    text.append(tempDec.getValue());
                    tempDec = decodeTree;
            }
                } 
            morse = morse.substring(morse.indexOf(' '));
            count++; }}
        else{
            while (count < morse.length()){
            
            for (int i = 0; i < morse.length(); i++){
                tempCh = morse.charAt(i);
                
                if (tempCh == ' '){
                    text.append(" ");
                    tempDec = decodeTree;}

                if (tempCh == DOT){
                    tempDec = tempDec.getLeft(); }
                if (tempCh == DASH){
                    tempDec = tempDec.getRight(); }
                else{
                    text.append(tempDec.getValue());
                    tempDec = decodeTree;
            }
                } 
            count++; }
        }
        return text.toString();}
        
        
        int cnt = 0;
        while (cnt < morse.length()){    // -... .-. ..- ....
            tempCh = morse.charAt(cnt);
            
            if (tempCh == ' '){
                text.append(" "); }
            if (tempCh == DOT){
                tempDec = tempDec.getLeft(); }
            if (tempCh == DASH){
                tempDec = tempDec.getRight(); }
            else{
                text.append(tempDec.getValue());
                tempDec = decodeTree;}
                }

            */
/**
 * BTreePrinter class courtesy of Karen Ge (@karenge1)
 */
class BTreePrinter {

    public static void printNode(TreeNode root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<TreeNode>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.getValue());
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getLeft() != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).getRight() != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.getLeft()), 
            BTreePrinter.maxLevel(node.getRight())) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
}}


/*if (tempCh == ' '){
                return " "; }
            if (tempCh == DOT){
                tempDec = tempDec.getLeft();
                 }
            if (tempCh == DASH){
                tempDec = tempDec.getRight(); }

            text.append(decode(morse.substring(1), tempDec));
        return text.toString();
    }   
    public static String decode(String morse, TreeNode tempDec)
    {
        char tempCh = morse.charAt(0);
        if (tempCh == ' '){
            tempDec = decodeTree;
            return " ";
             }
        if (tempCh == DOT){
            tempDec = tempDec.getLeft();
            }
        if (tempCh == DASH){
            tempDec = tempDec.getRight(); }
        else {
            return tempDec.getValue(); }

        return decode(morse.substring(1), tempDec);
                } */
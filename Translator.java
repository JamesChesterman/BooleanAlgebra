public class Translator {
    //BinaryTree tree;

    public String removeOuterBrackets(String eq){
        if(eq.charAt(0) == '('){
            eq = eq.substring(1, eq.length());
        }
        if(eq.charAt(eq.length()) == ')'){
            eq = eq.substring(0, eq.length()-1);
        }
        return eq;
    }

    public BinaryTree translate(String eq){
        BinaryTree tree = null;
        removeOuterBrackets(eq);
        int insideBrackets = 0;

        for(int i=0; i<eq.length();i++){
            char character = eq.charAt(i);
            if(character == '('){
                insideBrackets += 1;
            }else if(character == ')'){
                insideBrackets -= 1;
            }else if(character == '.' && insideBrackets == 0){
                AndNode and = new AndNode();
                tree = new BinaryTree(and, translate(eq.substring(0, i-1)), translate(eq.substring(i+1, eq.length())));
                //BinaryTree left = translate(eq.substring(0, i-1));
                //BinaryTree right = translate(eq.substring(i+1, eq.length()));
            }else{
                //If it's just an A, B etc.
                LetterNode node = new LetterNode(character);
                tree = new BinaryTree(node, null, null);
            }
        }
        return tree;
    }
    

    public Translator(String eq){
        
    }
}

public class Translator {
    //BinaryTree tree;
    static char[] orderOfExecution = {'+', '.', '¬'};   //Go through and find the +s first. This makes the AND operations be done first.

    public static String removeOuterBrackets(String eq){
        if(eq.length() > 0){
            if(eq.charAt(0) == '(' && eq.charAt(eq.length()-1) == ')'){
                eq = eq.substring(1, eq.length()-1);
            }
        }
        return eq;
    }

    

    public static BinaryTree translate(String eq){
        BinaryTree tree = null;
        eq = Translator.removeOuterBrackets(eq);
        int insideBrackets = 0;
        //First go through for +s, then go through for .s ...
        //Put break outOfLoop; to get here.
        outOfLoop:
        for(int i=0; i<orderOfExecution.length;i++){
            for(int j=0; j<eq.length();j++){
                char character = eq.charAt(j);
                if(character == '('){
                    insideBrackets += 1;
                }else if(character == ')'){
                    insideBrackets -= 1;
                }else if(character == '+' && insideBrackets == 0 && orderOfExecution[i] == '+'){
                    OrNode or = new OrNode();
                    tree = new BinaryTree(or, translate(eq.substring(0, j)), translate(eq.substring(j+1, eq.length())));
                    break outOfLoop;
                }else if(character == '.' && insideBrackets == 0 && orderOfExecution[i] == '.'){
                    AndNode and = new AndNode();
                    tree = new BinaryTree(and, translate(eq.substring(0, j)), translate(eq.substring(j+1, eq.length())));
                    break outOfLoop;
                }else if(character == '¬' && insideBrackets == 0 && orderOfExecution[i] == '¬'){
                    NotNode not = new NotNode();
                    if(eq.charAt(j+1) == '('){
                        //Add the entire part in brackets to the NOT node.
                        //If there's more brackets inside the not brackets, you don't just want to check for the next closing bracket.
                        int insideNotBrackets = 0;
                        int index = j+2;
                        while(insideNotBrackets >=0){
                            char notCharacter = eq.charAt(index);
                            if(notCharacter == '('){
                                insideNotBrackets += 1;
                            }else if(notCharacter == ')'){
                                insideNotBrackets -= 1;
                            }
                            index += 1;
                        }
                        tree = new BinaryTree(not, translate(eq.substring(j+1, index)), null);
                    }else{
                        tree = new BinaryTree(not, translate(eq.substring(j+1,j+2)), null);
                    }
                    break outOfLoop;
                }
                else{
                    //If it's just A,B etc
                    LetterNode node = new LetterNode(character);
                    tree = new BinaryTree(node, null, null);
                }
            }
        }
        
        return tree;
    }

    public Translator(){
        
    }
}

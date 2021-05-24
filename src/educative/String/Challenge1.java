package educative.String;

public class Challenge1 {

    //Reverse the order of words in a given sentence
    public static void reverseArray(char[] sentence, int start, int end){
        int count=0;
        for(int i=start; i<=(start+end)/2; i++){
            char temp = sentence[i];
            sentence[i] = sentence[end-count];
            sentence[end-count]=temp;
            count++;
        }
    }

//    public static void reverseWords (char[] sentence) {
//        for(int i=0; i<sentence.length; i++){
//            System.out.print(sentence[i]);
//        }
//        System.out.println();
//        reverseArray(sentence,0,sentence.length-1);
//        for(int i=0; i<sentence.length; i++){
//            System.out.print(sentence[i]);
//        }
//        System.out.println();
//        int i=0;
//        while(i<sentence.length){
//            int space=i;
//            while(space<sentence.length && sentence[space]!=' '){
//                space++;
//            }
//            reverseArray(sentence,i,space-1);
//            i=space+1;
//        }
//    }
    public static void reverseWords (char[] sentence) {
        reverseArray(sentence,0,sentence.length-1);
        int i=0;
        while(i<sentence.length){
            int space=i;
            while(space<sentence.length && sentence[space]!=' '){
                space++;
            }
            reverseArray(sentence,i,space-1);
            i=space+1;
        }
    }

    public static void main(String[] args) {
        char[] sentence = {'J','a','v','a',' ','l','o','v','e',' ','W','e'};
        reverseWords(sentence);
        for(int i=0; i<sentence.length; i++){
            System.out.print(sentence[i]);
        }
        System.out.println();
    }

}

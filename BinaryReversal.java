import java.util.Arrays;

public class BinaryReversal {
    public static void main(String[] args) {
        // test output:
        System.out.println(BinaryReversal("47"));

    }
    public static String BinaryReversal(String str){
        int s=Integer.parseInt(str);
        String binaryStr=Integer.toBinaryString(s);
        System.out.println("Input number: 47");
        System.out.println("Input Binary value: "+binaryStr);

        int res=Integer.parseInt(reverseStr(binaryStr),2);
        System.out.println("output number: "+res+"\n"+"Output Binary value: ");
        return reverseStr(binaryStr);

    }
    public static String reverseStr(String binaryStr){

        int[] eightBits=new int[8];
        int i=binaryStr.length()-1;
        int j=0;
        while (i>=0){
            eightBits[j]= Character.getNumericValue(binaryStr.charAt(i));
            i--;
            j++;
        }
        StringBuilder sf=new StringBuilder();
        Arrays.stream(eightBits).forEach(sf::append);
        return sf.toString();
    }
}

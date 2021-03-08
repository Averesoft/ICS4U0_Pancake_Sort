/* Jeremy Liang and Krish Patel
 * March 10, 2021
 * Ms. Krasteva
 * Pancake Sort
 * */
import java.util.*;
public class PancakeSort {
    static int current_size;
    static ArrayList<Integer> list = new ArrayList<Integer>();
    static void flip(int end) {
        for (int i = 0; i <= end/2; i++) {
            int temp = list.get(i);
            list.set(i, list.get(end-i));
            list.set(end-i, temp);
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("This program will perform a pancake sort on a list which is a permutation of all the numbers from 1 to N.");
        System.out.println("The program will ask the user to input N for this program.");
        int N = 0;
        boolean exit = false;
        while(!exit) { 
            try {
                System.out.print("What is N?: ");
                String input = sc.nextLine();
                N = Integer.parseInt(input);
                if (N >= 1) {
                    exit = true;
                } else {
                    System.out.println("That is not a valid input!");
                }
            } catch (Exception e) {
                System.out.println("That is not a valid input!");
            }
        }    
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        current_size = N;
        while(current_size > 0) {
            int max = -1, idx = -1;
            for (int i = 0; i < current_size; i++) {
                if (list.get(i) > max) {
                    max = list.get(i);
                    idx = i;
                }
            }
            flip(idx);
            flip(current_size-1);
            System.out.println("Array After " + (N-current_size+1) + " iterations");
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
            current_size--;
        }
    }
}
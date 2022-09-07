import java.util.Scanner;

public class Sub {
    static int n,arr[],count;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of values in total: ");
        n = scanner.nextInt();
        arr = new int[n];
        System.out.println("Enter the values in an array");
        for (int i = 0 ;i < n ; i++)
            arr[i] = scanner.nextInt();
        boolean[] solution = new boolean[n];
        System.out.println("Enter the sum");
        int sum = scanner.nextInt();
        subSet(sum,n-1,solution);
        if (count == 0)
            System.out.println("No solution");
    }

    public static void subSet(int sum,int index , boolean[] solution){
        if (sum == 0)
            printSolution(solution);
        else if (sum < 0 || index < 0) {
            return;
        }
        else{
            boolean[] tempSolution = solution.clone();
            tempSolution[index] = false;
            subSet(sum,index-1,tempSolution);
            tempSolution[index] = true;
            subSet(sum-arr[index],index-1,tempSolution);
        }
    }
    public static void printSolution(boolean[] solution){
        count++;
        System.out.print("Solution : {");
        for (int i = 0 ; i < solution.length ; i++){
            if (solution[i])
                System.out.print(arr[i]+" ");
        }
        System.out.print("}");
        System.out.println();
    }
}

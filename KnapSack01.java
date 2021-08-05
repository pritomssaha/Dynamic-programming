public class Knapsack01 {

    public static void main(String[] args){
        int[] weight={7,4,4};
        int[] price={15,8,8};
        int capacity=10;
        int n=weight.length;

        int[][] values=new int[n+1][capacity+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<values[i].length;j++){
                values[i][j]=-1;
            }
        }

        //bottom-up (iterative)
        int profit_iterative=getmaxprofitbottomup(weight, price, capacity,n);

        int profit=getmaxprofit(weight, price, capacity,n,values );
        System.out.println(profit_iterative);

    }

    private static int getmaxprofitbottomup(int[] weight, int[] price, int capacity, int n) {

        int [][] values=new int[n+1][capacity+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<values[i].length;j++){
                if(i==0 || j==0){
                    values[i][j]=0;
                }
                else{
                    int include=0, exclude=0;
                    if(weight[i-1]<=j){
                        include=price[i-1]+values[i-1][j-weight[i-1]];
                    }
                    exclude=values[i-1][j];
                    values[i][j]=Math.max(include,exclude);
                }

            }
        }

        for(int i=0;i<=n;i++){
            for(int j=0;j<values[i].length;j++) {
                System.out.print(values[i][j]+" ");
            }
            System.out.println();
            }
        return values[n][capacity];

    }

    private static int getmaxprofit(int[] weight, int[] price, int capacity, int n, int[][] values) {

        if(n==0 || capacity==0){
            values[n][capacity]=0;
            return 0;
        }
        if(values[n][capacity]!=-1){
            return values[n][capacity];
        }

        int include=0, exclude=0;

        if(weight[n-1]<=capacity){
            include=price[n-1]+getmaxprofit(weight, price, capacity-weight[n-1], n-1,values);
        }
        exclude=getmaxprofit(weight, price, capacity, n-1, values);

        values[n][capacity]=Math.max(include,exclude);

        return values[n][capacity];


    }
}

public class Solution15 {
    public int gcd(int a, int b) {
        int ketqua=0;
        for (int i =1 ; i<=a ; i++){
            if (a%i==0 && b%i==0){
                ketqua=i;
            }
           
        }
         return ketqua;
        
    }
    public static void main(String[] args) {
        Solution15 solution = new Solution15();
        System.out.println(solution.gcd(10, 20));
    }



    
}
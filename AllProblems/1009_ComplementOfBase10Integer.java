class Solution {
    public int bitwiseComplement(int N) {
        if (N == 0) return 1;
        int comp = 0, k = 0;
        // System.out.println(Integer.toBinaryString(N));
        while (N > 0) {
            comp = comp | ((N & 1) ^ 1) << k;
            N >>= 1;
            k++;
        }
        // System.out.println(Integer.toBinaryString(comp));
        return comp;
    }
}

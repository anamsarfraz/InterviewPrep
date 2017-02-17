class BinomialCoefficient {
        /*public static long binomialCoefficientHelper(int n, int k) {
            if (k == n || k == 1) {
                return n/k;
            }

            return binomialCoefficientHelper(n-1, k) + binomialCoefficientHelper(n-1, k-1);
        }
        */
        public static long binomialCoefficientHelper(int n, int k, long sum) {
            if (k == n || k == 1) {
                return sum;
            }

            return binomialCoefficientHelper(n-1, k-1, (sum+(n-1)/(k-1)))+ binomialCoefficientHelper(n-1, k, (sum+(n-1)/k));
        }

        public static long binomialCoefficient(int n, int k) {
            if (k > n) {
                return 0;
            }
            long sum = (k == n || k == 1) ? n/k : 0;
            return binomialCoefficientHelper(n, k, sum);
        }

	public static void main(String[] args) {
	    int n, k;
	    if (args.length != 2) {
		return;
	    }
	    n = Integer.valueOf(args[0]);
	    k = Integer.valueOf(args[1]);

	    System.out.println(binomialCoefficient(n, k));
        }
}

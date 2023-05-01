class HappyNumbers {
        public boolean isHappy(int n) {
            boolean isHappy = false;
            int sum = 0;
            HashSet set = new HashSet();
            int d = 0;
            int current = 0;
            while (set.add(n) ) {
                sum = 0;
                while (n > 0) {
                    d = n%10;
                    sum += d*d;
                    n = n/10;
                }

                if (sum == 1) return true;
                n = sum;
            }

            return isHappy;
        }
    }
    public boolean isHappy2(int n) {
    Set<Integer> inLoop = new HashSet<Integer>();
    int squareSum,d;
	while (inLoop.add(n)) {
            squareSum = 0;
            while (n > 0) {
            d = n%10;
            squareSum += d*d;
            n /= 10;
            }
            if (squareSum == 1)
            return true;
            else
            n = squareSum;

            }
            return false;
            }
            }

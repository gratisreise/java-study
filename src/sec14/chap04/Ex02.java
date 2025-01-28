package sec14.chap04;

public class Ex02 {

    public static void main(String[] args) {
        //  최대공약수와 최소공배수
        var gcd_12_18 = ArithmeticUtils.gcd(12, 18);
        var lcm_12_18 = ArithmeticUtils.lcm(6, 8);

        //  행렬 연산
        double[][] matrix1 = {{1, 2}, {3, 4}};
        double[][] matrix2 = {{5, 6}, {7, 8}};

        RealMatrix m1 = MatrixUtils.createRealMatrix(matrix1);
        RealMatrix m2 = MatrixUtils.createRealMatrix(matrix2);

        RealMatrix m1Xm2 = m1.multiply(m2);

        //  통계 관련 기능
        double[] values = {1.8, 2.4, 3.7, 4.3, 5.9};
        DescriptiveStatistics stats = new DescriptiveStatistics(values);

        double mean = stats.getMean();
        double sum = stats.getSum();
        double std = stats.getStandardDeviation();

        //  🎓 이 외에도 다양한 수학 관련 고급 기능들 제공E
    }
}

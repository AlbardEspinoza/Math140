
import java.util.Arrays;

public class ComputeGrade {

    public static void main(String[] args) {
        final int[] exams = {64, 73, 78};
        final int[] hw = {40, 40, 40, 50};
        final int[] quizzes = {24, 22, 12, 17, 20, 11, 14, 22, 22, 18, 10, 14, 16, 14, 16, 16};  // 10 quizzes

        // Replace the zeros with your scores
        int[] examScores = {48, 65, 75};
        int[] hwScores = {44, 40, 38, 50};
        int[] quizScores = {22, 21, 9, 17, 15, 5, 7, 11, 13, 15, 8, 14, 16, 14, 14, 14};

        // Compute Exam Points - Method One
        double examPoints = 0.0;
        for (int i = 0; i < exams.length; i++) {
            examPoints += 1.0 * examScores[i] / exams[i]; // add the exam percentages
        }
        examPoints = examPoints / exams.length * 450; // (average of exam percentages)(450)

        double hwPoints = 0.0;
        for (int i = 0; i < hw.length; i++) {
            hwPoints += 1.0 * hwScores[i] / hw[i]; // add the HW percentages
        }
        hwPoints = hwPoints / hw.length * 100; // (average of HW percentages)(100)

        double[] quizPercentages = new double[quizScores.length];
        for (int i = 0; i < quizzes.length; i++) {
            quizPercentages[i] = 1.0 * quizScores[i] / quizzes[i];
        }

        Arrays.sort(quizPercentages); // sort the quizzes by percentage in ascending order

        double quizPoints = 0.0;
        for (int i = 4; i < quizzes.length; i++) {
            quizPoints += quizPercentages[i]; // add the quiz percentages, omit 4 lowest percentages
        }
        quizPoints = quizPoints / (quizzes.length - 4) * 150; //

        System.out.println("Exam points Method I (450 possible): " + examPoints);
        System.out.println("Quiz Points (150 possible): " + quizPoints);
        System.out.println("HW Points (100 possible): " + hwPoints);

        double percentage = (examPoints + hwPoints + quizPoints) / 700;
        System.out.println("Percentage of points Method I :" + percentage * 100);

        // Method II
        // Compute Exam Points - Method two
        double[] examPercentages = new double[examScores.length];
        for (int i = 0; i < exams.length; i++) {
            examPercentages[i] = 1.0 * examScores[i] / exams[i];
        }
        Arrays.sort(examPercentages); // sort the quizzes by percentage
        examPoints = 0.0;
        for (int i = 1; i < exams.length; i++) {   // drop lowest score
            examPoints += examPercentages[i]; // add the exam percentages
        }

        examPoints = examPoints / (exams.length - 1) * 350; // (average of exam percentages)(350)

        System.out.println("\nExam points Method II: (350 possible): " + examPoints);
        System.out.println("Quiz Points (150 possible): " + quizPoints);
        System.out.println("HW Points (100 possible): " + hwPoints);
        percentage = (examPoints + hwPoints + quizPoints) / 600;
        System.out.println("Percentage of points Method II :" + percentage * 100);


    }
}

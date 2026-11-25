/**
 * ข้อกำหนดของ gradeOf(score)
 * 80-100 -> "A"    75-79 -> "B+"
 * 70-74  -> "B"    65-69 -> "C+"
 * 60-64  -> "C"    55-59 -> "D+"
 * 50-54  -> "D"    0-49  -> "F"
 * score < 0 หรือ > 100 -> IllegalArgumentException
 *
 * เวอร์ชันนี้คือหลังขั้น REFACTOR (ทุกเทสต์ GREEN แล้ว)
 */
public class GradeCalculator {

    // คะแนนขั้นต่ำของแต่ละเกรด เรียงจากมากไปน้อย (index ตรงกับ GRADES)
    private static final int[] MIN_SCORES = {80, 75, 70, 65, 60, 55, 50, 0};
    private static final String[] GRADES  = {"A", "B+", "B", "C+", "C", "D+", "D", "F"};

    public String gradeOf(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("score must be between 0 and 100: " + score);
        }
        for (int i = 0; i < MIN_SCORES.length; i++) {
            if (score >= MIN_SCORES[i]) {
                return GRADES[i];
            }
        }
        throw new IllegalStateException("unreachable: score=" + score); // score >= 0 จึงไม่มีทางมาถึงบรรทัดนี้
    }
}

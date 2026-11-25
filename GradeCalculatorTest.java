import org.junit.Test;
import static org.junit.Assert.*;

/** JUnit 4.13.2 — 20 เทสต์ เรียงตามสเต็ป TDD และตรงกับ TC ID ในชีต TestCases */
public class GradeCalculatorTest {

    private final GradeCalculator calc = new GradeCalculator();

    // ---------- รอบ 1: เริ่มที่เกรด A ----------
    @Test public void tc001_score100_isA()      { assertEquals("A",  calc.gradeOf(100)); }
    @Test public void tc002_score80_isA()       { assertEquals("A",  calc.gradeOf(80)); }

    // ---------- รอบ 2: ไล่ขอบล่างทุกช่วงเกรด ----------
    @Test public void tc003_score75_isBplus()   { assertEquals("B+", calc.gradeOf(75)); }
    @Test public void tc004_score70_isB()       { assertEquals("B",  calc.gradeOf(70)); }
    @Test public void tc005_score65_isCplus()   { assertEquals("C+", calc.gradeOf(65)); }
    @Test public void tc006_score60_isC()       { assertEquals("C",  calc.gradeOf(60)); }
    @Test public void tc007_score55_isDplus()   { assertEquals("D+", calc.gradeOf(55)); }
    @Test public void tc008_score50_isD()       { assertEquals("D",  calc.gradeOf(50)); }
    @Test public void tc009_score0_isF()        { assertEquals("F",  calc.gradeOf(0)); }

    // ---------- รอบ 3: รอยต่อขอบบน (ช่วงไม่ทับซ้อน) + ค่ากลางช่วง ----------
    @Test public void tc010_score79_isBplus()   { assertEquals("B+", calc.gradeOf(79)); }
    @Test public void tc011_score49_isF()       { assertEquals("F",  calc.gradeOf(49)); }
    @Test public void tc014_score74_isB()       { assertEquals("B",  calc.gradeOf(74)); }
    @Test public void tc015_score69_isCplus()   { assertEquals("C+", calc.gradeOf(69)); }
    @Test public void tc016_score64_isC()       { assertEquals("C",  calc.gradeOf(64)); }
    @Test public void tc017_score59_isDplus()   { assertEquals("D+", calc.gradeOf(59)); }
    @Test public void tc018_score54_isD()       { assertEquals("D",  calc.gradeOf(54)); }
    @Test public void tc019_score90_isA()       { assertEquals("A",  calc.gradeOf(90)); }
    @Test public void tc020_score25_isF()       { assertEquals("F",  calc.gradeOf(25)); }

    // ---------- รอบ 4: ค่านอกช่วงต้องโยน exception ----------
    @Test(expected = IllegalArgumentException.class)
    public void tc012_scoreMinus1_throws()      { calc.gradeOf(-1); }

    @Test(expected = IllegalArgumentException.class)
    public void tc013_score101_throws()         { calc.gradeOf(101); }
}

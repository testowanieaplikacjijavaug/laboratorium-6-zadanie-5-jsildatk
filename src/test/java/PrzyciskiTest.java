import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.timing.Pause;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrzyciskiTest {
    
    private static final JButtonMatcher B1_MATCHER = JButtonMatcher.withText("przycisk 1");
    
    private static final JButtonMatcher B2_MATCHER = JButtonMatcher.withText("przycisk 2");
    
    private static final JButtonMatcher B3_MATCHER = JButtonMatcher.withText("przycisk 3");
    
    private static final JButtonMatcher B4_MATCHER = JButtonMatcher.withText("przycisk 4");
    
    private static final JButtonMatcher BRESET_MATCHER = JButtonMatcher.withText("RESET");
    
    private Przyciski przyciski;
    
    private FrameFixture window;
    
    @BeforeClass
    public static void setUpOnce() {
        FailOnThreadViolationRepaintManager.install();
    }
    
    @BeforeEach
    public void setUp() {
        przyciski = GuiActionRunner.execute(Przyciski::new);
        window = new FrameFixture(przyciski);
        window.show();
    }
    
    @Test
    public void shouldHaveTitleName() {
        window.requireTitle("Przyciski");
    }
    
    @Test
    public void shouldContain1AfterClickingInB1Button() {
        window.button(B1_MATCHER)
                .click();
        Pause.pause();
        window.textBox()
                .requireText("1");
    }
    
    @Test
    public void shouldContain1AfterClickingInB2Button() {
        window.button(B2_MATCHER)
                .click();
        Pause.pause();
        window.textBox()
                .requireText("1");
    }
    
    @Test
    public void shouldContain1AfterClickingInB3Button() {
        window.button(B3_MATCHER)
                .click();
        Pause.pause();
        window.textBox()
                .requireText("1");
    }
    
    @Test
    public void shouldContain1AfterClickingInB4Button() {
        window.button(B4_MATCHER)
                .click();
        Pause.pause();
        window.textBox()
                .requireText("1");
    }
    
    @Test
    public void shouldContainZeroAfterClickingResetButton() {
        window.button(B1_MATCHER)
                .click();
        window.button(BRESET_MATCHER)
                .click();
        Pause.pause();
        window.textBox()
                .requireText("0");
    }
    
    @Test
    public void shouldContainZeroAfterClickingResetButtonWithInsertedValue() {
        window.textBox()
                .enterText("123412345324534");
        window.button(BRESET_MATCHER)
                .click();
        Pause.pause();
        window.textBox()
                .requireText("0");
    }
    
    @Test
    public void shouldContainZeroAfterClickingResetButtonWithInsertedString() {
        window.textBox()
                .enterText("dfghdfggdfgg");
        window.button(BRESET_MATCHER)
                .click();
        Pause.pause();
        window.textBox()
                .requireText("0");
    }
    
    @Test
    public void shouldContainThreeAfterClickingThreeButtons() {
        window.button(B1_MATCHER)
                .click();
        Pause.pause();
        window.button(B2_MATCHER)
                .click();
        Pause.pause();
        window.button(B3_MATCHER)
                .click();
        Pause.pause();
        window.textBox()
                .requireText("3");
    }
    
    @Test
    public void shouldContainThreeAfterClickingFourButtons() {
        window.button(B1_MATCHER)
                .click();
        Pause.pause();
        window.button(B2_MATCHER)
                .click();
        Pause.pause();
        window.button(B3_MATCHER)
                .click();
        Pause.pause();
        window.button(B4_MATCHER)
                .click();
        Pause.pause();
        window.textBox()
                .requireText("3");
    }
    
    @Test
    public void shouldContainFourAfterClickingFiveButtons() {
        window.button(B1_MATCHER)
                .click();
        Pause.pause();
        window.button(B2_MATCHER)
                .click();
        Pause.pause();
        window.button(B3_MATCHER)
                .click();
        Pause.pause();
        window.button(B4_MATCHER)
                .click();
        Pause.pause();
        window.button(B1_MATCHER)
                .click();
        Pause.pause();
        window.textBox()
                .requireText("4");
    }
    
    @Test
    public void shouldContain10AfterClicking10TimesOneButton() {
        for ( int i = 0; i < 10; i++ ) {
            window.button(B1_MATCHER)
                    .click();
            Pause.pause();
        }
        window.textBox()
                .requireText("10");
    }
    
    @Test
    public void shouldContainZeroAfterClickingResetButtonWithEmptyTextBox() {
        window.button(BRESET_MATCHER)
                .click();
        window.textBox()
                .requireText("0");
    }
    
    @AfterEach
    public void tearDown() {
        window.cleanUp();
        przyciski = null;
    }
    
}
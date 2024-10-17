import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {

	private GradeBook g1;

	@BeforeEach
	void setUp() throws Exception {
		// Initialize GradeBook with a capacity of 5 scores
		g1 = new GradeBook(5);
		g1.addScore(50.0);
		g1.addScore(75.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		// Set GradeBook object to null
		g1 = null;
	}

	@Test
	void testAddScore() {
		// Verify the contents of the scores array using toString
		assertTrue(g1.toString().equals("50.0 75.0 "), "The scores do not match expected values.");
	}

	@Test
	void testSum() {
		// Compare the returned sum to the expected sum
		assertEquals(125.0, g1.sum(), 0.0001, "Sum calculation is incorrect.");
	}

	@Test
	void testMinimum() {
		// Compare the returned minimum to the expected minimum
		assertEquals(50.0, g1.minimum(), 0.001, "Minimum score calculation is incorrect.");
	}

	@Test
	void testFinalScore() {
		// Add additional scores to calculate the final score correctly
		g1.addScore(80.0);
		g1.addScore(90.0);

		// Expected final score = sum(50 + 75 + 80 + 90) - minimum(50) = 295 - 50 = 245
		assertEquals(245.0, g1.finalScore(), 0.001, "Final score calculation is incorrect.");
	}
}
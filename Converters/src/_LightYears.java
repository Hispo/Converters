/**
 * Converter light years to kilometers.
 * @author Edson F
 * @version 1.0
 */

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class _LightYears {

	Scanner input = new Scanner(System.in);

	private float lightYears = 9_461_000_000_000f; // 9 Trillions
	private double result; // Result after conversion
	private double valueLightYears; // User input
	private boolean continueLoop = true;

	/**
	 * Consistent value
	 */
	public void setValueLightYears() {
		valueLightYears = valueLightYears > 0 ? valueLightYears : 1;
	}

	/**
	 * User input validation
	 */
	public void input() {
		do {
			try {
				System.out.print("Enter value in Light-Years: ");
				valueLightYears = input.nextDouble();
				continueLoop = false;

			} catch (InputMismatchException e) {
				System.err.println("Only numbers!");
				input.nextLine();
			} // fim do catch
		} while (continueLoop);
	} // fim do método entrada

	/**
	 * Calculation
	 * 
	 * @return result
	 */
	public double calculationLightYears() {
		return result = lightYears * valueLightYears;
	}

	/**
	 * Result output
	 */
	public void message() {
		System.out.println("The distance is "
				+ NumberFormat.getInstance().format(result) + " kilometers.");
	}
}
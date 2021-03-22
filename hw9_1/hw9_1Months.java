/*
 * LOGOS IT ACADEMY. First Java Core console application
 */

package hw9_1;

import java.util.Scanner;

import ua.lviv.lgs.customException.NoMoneyException;

/**
 * 
 * @author Inna
 * @since Java 1.8
 * @version 1.2 22.03.2021
 *
 */

public class hw9_1Months {

	public enum Seasons {
		WINTER, SPRING, SUMMER, FALL
	}

	public enum Months {
		JANUARY(31, Seasons.WINTER), FEBRUARY(28, Seasons.WINTER), MARCH(31, Seasons.SPRING), APRIL(30, Seasons.SPRING),
		MAY(31, Seasons.SPRING), JUNE(30, Seasons.SUMMER), JULY(31, Seasons.SUMMER), AUGUST(31, Seasons.SUMMER),
		SEPTEMBER(30, Seasons.FALL), OCTOBER(31, Seasons.FALL), NOVEMBER(30, Seasons.FALL),
		DECEMBER(31, Seasons.WINTER);

		private int days;
		private Seasons season;

		private Months(int days, Seasons season) {
			this.days = days;
			this.season = season;
		}

		public int getDays() {
			return days;
		}

		public Seasons getSeason() {
			return season;
		}

	}

	static void menu() {
		System.out.println();
		System.out.println("Натисніть 1, щоб перевірити, чи є такий місяць");
		System.out.println("Натисніть 2, щоб вивести всі місяці з такою ж порою року");
		System.out.println("Натисніть 3, щоб вивести всі місяці, які мають таку саму кількість днів");
		System.out.println("Натисніть 4, щоб вивести на екран всі місяці, які мають меншу кількість днів");
		System.out.println("Натисніть 5, щоб вивести на екран всі місяці, які мають більшу кількість днів");
		System.out.println("Натисніть 6, щоб вивести на екран наступну пору року");
		System.out.println("Натисніть 7, щоб вивести на екран попередню пору року");
		System.out.println("Натисніть 8, щоб вивести на екран всі місяці, які мають парну кількість днів");
		System.out.println("Натисніть 9, щоб вивести на екран всі місяці, які мають непарну кількість днів");
		System.out.println("Натисніть 10, щоб вивести на екран, чи введений з консолі місяць має парну кількість днів");
	}

	public static void main(String[] args) throws IncorrectInputExeption {

		Seasons[] massive = Seasons.values();
		Months[] mas = Months.values();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			menu();
			switch (scanner.next()) {
			// перевірити, чи є такий місяць
			case "1": {
				System.out.println("Enter some month ");
				scanner = new Scanner(System.in);
				String month = scanner.next().toUpperCase();

				boolean flag = isMonthsPresent(mas, month);

				if (flag) {
					System.out.println("Month exists");
				}

				else {
					String message = "Month " + month + " doesn't exist";
					throw new IncorrectInputExeption(message);
				}
				break;
			}
			// вивести всі місяці з такою ж порою року
			case "2": {// треба перевірити, чи така пора року існує, а вже потім вивести місяці цієї
						// пори року
				System.out.println("Enter season ");
				scanner = new Scanner(System.in);
				String seasonScanner = scanner.next().toUpperCase();

				boolean flag = false;

				for (Months m : mas) {
					if (m.getSeason().name().equals(seasonScanner)) {
						flag = true;
					}
				}
				if (flag) {
					Seasons season = Seasons.valueOf(seasonScanner);
					for (Months m : mas) {
						if (m.getSeason().toString().equalsIgnoreCase(seasonScanner)) {
							System.out.print("   " + m);
						}
					}
				}
				if (!flag) {
					String message = "Season " + seasonScanner + " doesn't exist";
					throw new IncorrectInputExeption(message);
				}
				break;
			}
			// вивести всі місяці, які мають таку саму кількість днів
			case "3": {
				System.out.println("Enter some month ");
				scanner = new Scanner(System.in);
				String monthScaner = scanner.next().toUpperCase();

				boolean flag = false;

				for (Months m : mas) {
					if (m.name().equalsIgnoreCase(monthScaner)) {
						flag = true;
					}
				}
				if (flag) {
					Months month = Months.valueOf(monthScaner);
					int days = month.getDays();
					System.out.println(days + " days:");

					for (Months month2 : mas) {
						int days2 = month2.getDays();
						if (days == days2) {
							System.out.print("   " + month2);
						}
					}
				}
				if (!flag) {
					String message = "Month " + monthScaner + " doesn't exist";
					throw new IncorrectInputExeption(message);
				}
				break;
			}
			// вивести всі місяці, які мають меншу кількість днів
			case "4": {
				System.out.println("Enter some month ");
				scanner = new Scanner(System.in);
				String monthScaner = scanner.next().toUpperCase();

				boolean flag = false;

				for (Months m : mas) {
					if (m.name().equalsIgnoreCase(monthScaner)) {
						flag = true;
					}
				}
				if (flag) {
					Months month = Months.valueOf(monthScaner);
					int days = month.getDays();
					System.out.println("has more days then next month(s):");

					for (Months month2 : mas) {
						int days2 = month2.getDays();
						if (days > days2) {
							System.out.print("   " + month2);
						}
					}
				}

				if (!flag) {
					String message = "Month " + monthScaner + " doesn't exist";
					throw new IncorrectInputExeption(message);
				}
				break;
			}
			// вивести на екран всі місяці, які мають більшу кількість днів
			case "5": {
				System.out.println("Enter some month ");
				scanner = new Scanner(System.in);
				String monthScaner = scanner.next().toUpperCase();

				boolean flag = false;

				for (Months m : mas) {
					if (m.name().equalsIgnoreCase(monthScaner)) {
						flag = true;
					}
				}
				if (flag) {
					Months month = Months.valueOf(monthScaner);
					int days = month.getDays();
					System.out.println("has less days then next months:");

					for (Months month2 : mas) {
						int days2 = month2.getDays();
						if (days < days2) {
							System.out.print("   " + month2);
						}
					}
				}
				if (!flag) {
					String message = "Month " + monthScaner + " doesn't exist";
					throw new IncorrectInputExeption(message);
				}
				break;
			}
			// вивести на екран наступну пору року
			case "6": {
				System.out.println("Enter season ");
				scanner = new Scanner(System.in);
				String seasonScanner6 = scanner.next().toUpperCase();

				boolean flag = false;

				for (Seasons s : massive) {
					if (s.name().equals(seasonScanner6)) {
						
						flag = true;
					}
				}
				if (flag) {
					Seasons s2 = Seasons.valueOf(seasonScanner6);
					int ordinal = s2.ordinal();

					if (ordinal == (massive.length - 1)) {
						ordinal = 0;
						System.out.println("The following season is: " + massive[ordinal]);

					} else {
						System.out.println("The following season is: " + massive[ordinal + 1]);
					}
				}
				if (!flag) {
					String message = "Season " + seasonScanner6 + " doesn't exist";
					throw new IncorrectInputExeption(message);
				}
				break;
			}
			// вивести на екран попередню пору року
			case "7": {
				System.out.println("Enter season ");
				scanner = new Scanner(System.in);
				String seasonScanner7 = scanner.next().toUpperCase();

				boolean flag = false;

				for (Seasons s : massive) {
					if (s.name().equals(seasonScanner7)) {
	
						flag = true;
					}
				}
				if (flag) {
					Seasons s2 = Seasons.valueOf(seasonScanner7);
					int ordinal = s2.ordinal();

					if (ordinal == 0) {
						ordinal = (massive.length - 1);
						System.out.println("The previous season is: " + massive[ordinal]);

					} else {
						System.out.println("The previous season is: " + massive[ordinal - 1]);
					}
				}
				if (!flag) {
					String message = "Season " + seasonScanner7 + " doesn't exist";
					throw new IncorrectInputExeption(message);
				}
				break;
			}
			// вивести на екран всі місяці, які мають парну кількість днів
			case "8": {
				System.out.print("These months have an even number of days:");
				for (Months month3 : mas) {
					if (month3.getDays() % 2 == 0) {
						System.out.print("   " + month3);
					}
				}
			}
			// вивести на екран всі місяці, які мають непарну кількість днів
			case "9": {
				System.out.print("These months have an odd number of days:");
				for (Months month4 : mas) {
					if (month4.getDays() % 2 != 0) {
						System.out.print("   " + month4);
					}
				}
			}
			// перевірити, чи є введений з консолі місяць має парну кількість днів
			case "10": {
				System.out.println("Enter some month ");
				scanner = new Scanner(System.in);
				String month = scanner.next().toUpperCase();

				boolean flag = isMonthsPresent(mas, month);

				if (flag) {
					Months m = Months.valueOf(month);
					int days = m.getDays();

					if (days % 2 == 0) {
						System.out.print(m + " has an even number of days");
					} else {
						System.out.print(m + " has an odd number of days");
					}
				}
				if (!flag) {
					String message = "Month " + month + " doesn't exist";
					throw new IncorrectInputExeption(message);
				}
				break;
			}
			}

		}

	}

	/**
	 * Checks if the month exists in enumArray
	 * 
	 * @param mas
	 * @param month
	 * @return boolean expression
	 */

	private static boolean isMonthsPresent(Months[] mas, String month) {
		boolean flag = false;

		for (Months m : mas) {

			if (m.name().equalsIgnoreCase(month)) {
				flag = true;
			}

		}
		return flag;
	}

}

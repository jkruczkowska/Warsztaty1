package pl.coderslab.warsztaty1.zad2lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LottoGame {

	public static void main(String[] args) {
		prize();
	}

	static int[] choosingNumbers() {
		int count = 1;
		String num = "";
		int number = 0;
		int[] arr = new int[6];
		int i = 0;

		try (Scanner sc = new Scanner(System.in)) {
			while (count < 7) {
				System.out.println("Podaj " + count + " liczbę:");
				try {
					num = sc.nextLine();
					number = Integer.parseInt(num);
					while (i < arr.length) {
						if (number > 0 && number < 50) {
							if (!containsNumber(arr, number)) {
								arr[i] = number;
								count++;
								i++;
								break;
							}
							break;
						} else {
							System.out.println("Liczba spoza zakresu");
							break;
						}
					}

				} catch (NumberFormatException e) {
					System.out.println("Nieprawidłowe dane");
				}
			}
		}
		System.out.println("Dziękujemy!");
		Arrays.sort(arr);
		System.out.println("Wybrałeś liczby: " + Arrays.toString(arr));
		System.out.println("Wylosowane liczby: " + Arrays.toString(drawing()));
		return arr;
	}

	static Integer[] drawing() {
		Integer[] arr = new Integer[49];
		Integer[] copyArr = new Integer[6];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		Collections.shuffle(Arrays.asList(arr));
		copyArr = Arrays.copyOf(arr, 6);
		Arrays.sort(copyArr);
		return copyArr;
	}

	static boolean containsNumber(int[] arr, int number) {
		boolean containsNumber = false;
		for (int k : arr) {
			if (k == number) {
				containsNumber = true;
				System.out.println("Ta liczba już była!");
				break;
			}
		}
		return containsNumber;
	}

	static int winnerOrLooser(Integer[] ar, int[] arr) {
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (ar[i] == arr[j]) {
					count++;

				}
			}
		}
		return count;
	}

	static void prize() {
		int howMuch = winnerOrLooser(drawing(), choosingNumbers());
		switch (howMuch) {
		case 1:
			System.out.println("Zgadłeś tylko jedną liczbę :(");
			break;
		case 2:
			System.out.println("Zgadłeś tylko dwie liczby :(");
			break;
		case 3:
			System.out.println("Wygrałeś TRÓJKĘ! :)");
			break;
		case 4:
			System.out.println("Wygrałeś CZWÓRKĘ! :))");
			break;
		case 5:
			System.out.println("Wygrałeś PIĄTKĘ! :)))");
			break;
		case 6:
			System.out.println("Wygrałeś SZÓSTKĘ! :)))))");
			break;
		default:
			System.out.println("Nie zgadłeś ani jednej!!! Lepiej skocz z mostu... o.O");
		}

	}

}

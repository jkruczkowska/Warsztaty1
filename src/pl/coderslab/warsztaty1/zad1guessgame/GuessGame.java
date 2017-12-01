package pl.coderslab.warsztaty1.zad1guessgame;

import java.util.Random;
import java.util.Scanner;

/*Napisz prostą grę w zgadywanie liczb. Komputer musi wylosować liczbę w zakresie od 1 do 100. Następnie:
Zadać pytanie: "Zgadnij liczbę" i pobrać liczbę z klawiatury.
Sprawdzić, czy wprowadzony napis, to rzeczywiście liczba i w razie błędu wyświetlić komunikat "To nie jest liczba", po czym wrócić do pkt. 1
Jeśli liczba podana przez użytkownika jest mniejsza niż wylosowana, wyświetlić komunikat "Za mało!", po czym wrócić do pkt. 1.
Jeśli liczba podana przez użytkownika jest większa niż wylosowana, wyświetlić komunikat "Za dużo!", po czym wrócić do pkt. 1.
Jeśli liczba podana przez użytkownika jest równa wylosowanej, wyświetlić komunikat "Zgadłeś!", po czym zakończyć działanie programu.*/
public class GuessGame {
	public static void main(String[] args) {

		Random rnd = new Random();
		try (Scanner scan = new Scanner(System.in)) {

			int n = rnd.nextInt(100) + 1;
			int num = 0;
			while (num != n){
			try {
				System.out.println("Podaj liczbę:");
				String str = scan.nextLine();
				num = Integer.parseInt(str);
			} catch (NumberFormatException e) {
				System.out.println("Podano złe dane");
				continue;
			}
			if (num > n){
				System.out.println("Za dużo!");
			}
			else if (num < n){
				System.out.println("Za mało!");
			}
			else {
				System.out.println("Zgadłaś!");
			}
			}	
		}
	}

}

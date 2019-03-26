package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Entre com os dados da CONTA:");
			System.out.print("Número da conta: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Nome do cliente: ");
			String holder = sc.nextLine();
			System.out.print("Saldo inicial: R$ ");
			Double balance = sc.nextDouble();
			System.out.print("Limite de saque: R$ ");
			Double withdrawLimit = sc.nextDouble();

			Account account = new Account(number, holder, balance, withdrawLimit);
			System.out.println();
			System.out.print("Entre com o valor do saque: R$ ");
			double amount = sc.nextDouble();

			account.withdraw(amount);
			System.out.print("Novo saldo: R$ " + String.format("%.2f", account.getBalance()));

		} catch (DomainExceptions e) {
			System.out.println("Erro de saque: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}

		sc.close();
	}

}

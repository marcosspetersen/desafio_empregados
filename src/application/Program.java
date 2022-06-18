package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome do departamento: ");
		String departName = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Telefone: ");
		String phone = sc.next();
		
		Address address = new Address(email, phone);
		Department department = new Department(departName, payDay, address);
		
		System.out.print("Quantos funcionários tem o departamento? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Dados do funcionário " + i + ":");
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salário: ");
			double salary = sc.nextDouble();
			
			Employee emp = new Employee(name, salary);
			department.addEmployee(emp);
		}
		
		showReport(department);
		sc.close();

	}
	
	private static void showReport(Department dept) {
		System.out.println();
		System.out.println("FOLHA DE PAGAMENTO: ");
		System.out.printf("Departamento Vendas = R$ %.2f\n", dept.payroll());
		System.out.println("Pagamento realizado no dia " + dept.getPayDay());
		System.out.println("Funcionários: ");
		System.out.print(dept);
		System.out.println("Para dúvidas favor entrar em contato: " + dept.getAddress().getEmail());
	}
}

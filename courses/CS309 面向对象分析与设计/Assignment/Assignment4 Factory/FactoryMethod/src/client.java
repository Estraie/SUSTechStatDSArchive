package FactoryMethod;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class client {
    
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int op = -1;

		List<ITStaff> staffList = new ArrayList<>();

		ITStaffFactoryInterface itManagerFactory = new ITManagerFactory();
		ITStaffFactoryInterface developerFactory = new DeveloperFactory();
		ITStaffFactoryInterface testerFactory = new TesterFactory();
		ITStaffFactoryInterface artDesignerFactory = new ArtDesignerFactory();

		System.out.println("Please input an operation number:"
				+ "\n1: add an IT manager"
				+ "\n2: add an Developer"
				+ "\n3: add an Tester"
				+ "\n4: print all staff by salary order"
				+ "\n5: print all staff by working order"
				+ "\n0: Stop\n");
		do {
			try {
				op = input.nextInt();

				switch (op) {
					case 1:
						staffList.add(itManagerFactory.createITStaff());
						break;
					case 2:
						staffList.add(developerFactory.createITStaff());
						break;
					case 3:
						staffList.add(testerFactory.createITStaff());
						break;
					case 4:
						staffList.add(artDesignerFactory.createITStaff());
						break;
					case 5:
						System.out.println("All information:");
						staffList.stream().sorted(Comparator.comparing(ITStaff::getSalary)).forEach(System.out::println);
						break;
					case 6:
						System.out.println("All name:");
						staffList.stream().sorted(Comparator.comparing(ITStaff::working)).forEach(System.out::println);
						break;
					}
			} catch (InputMismatchException e) {
				System.out.println(e.toString());
				input.nextLine();
			}

		} while (op != 0);
		input.close();
	}
    
}

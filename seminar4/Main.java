package seminar4;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("qwe", 21, 3_000.0);
        Employee employee2 = new Employee("asd", 22, 5_000.0);
        HashTable<Integer, Employee> employeeIntegerHashTable = new HashTable<>();
        employeeIntegerHashTable.add(0, employee2);
        employeeIntegerHashTable.add(1, employee);
        System.out.println(employeeIntegerHashTable.get(1));
        employeeIntegerHashTable.remove(1);
        System.out.println(employeeIntegerHashTable.get(1));
    }
}

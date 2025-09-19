package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: department findByID ====");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println();

        System.out.println("=== TEST 2: department findAll ====");
        List<Department> list = departmentDao.findAll();
        list.forEach(System.out::println);

        System.out.println();

        /* System.out.println("=== TEST 3: department insert ====");
        Department departmentNew = new Department(null, "Acessorios");
        departmentDao.insert(departmentNew);
        System.out.println("Inserted! New id: " + departmentNew.getId());
        */

        System.out.println();

        System.out.println("=== TEST 4: update =======");
        Department dep2 = departmentDao.findById(1);
        dep2.setName("Cosméticos");
        departmentDao.update(dep2);
        System.out.println("Update completed");

        System.out.println();

        System.out.println("=== TEST 5: delete =======");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();
    }
}

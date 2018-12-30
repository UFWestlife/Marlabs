package eCommerce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import eCommerce.Product.Category;


public class eTest {
    public static void main(String[] args) {
        ProductPool productPool = new ProductPool();

        Product P01 = new Product("E01", "iPhoneXs", 999.0f, Category.Electronics);
        Product P02 = new Product("H01", "Desk", 59.99f, Category.Home);
        Product P03 = new Product("C01", "Shirt", 39.99f, Category.Clothes);
        Product P04 = new Product("B01", "Gone With the Wind", 19.99f, Category.Books);
        Product P05 = new Product("F01", "Pizza", 4.99f, Category.Foods);

        for (Category cate : Product.Category.values()) {
            productPool.map.put(cate, new ArrayList<>());
        }

        productPool.map.get(Category.Electronics).add(P01);
        productPool.map.get(Category.Home).add(P02);
        productPool.map.get(Category.Clothes).add(P03);
        productPool.map.get(Category.Books).add(P04);
        productPool.map.get(Category.Foods).add(P05);

        Scanner scanner = new Scanner(System.in);

        System.out.println("------ Welcome to the simple eCommerce System -------");
        System.out.println("There are 5 categories of products here, " +
                "\n  under Electronics, we now have "+productPool.map.get(Category.Electronics).size()+" products;"+
                "\n  under Home, we now have "+productPool.map.get(Category.Home).size()+" products;"+
                "\n  under Clothes, we now have "+productPool.map.get(Category.Clothes).size()+" products;"+
                "\n  under Books, we now have "+productPool.map.get(Category.Books).size()+" products;"+
                "\n  under Foods, we now have "+productPool.map.get(Category.Foods).size()+" products;"
        );

        System.out.println("===== Do you need to insert new Product? (yes/no) =====");
        boolean flag = scanner.next().equals("yes");

        System.out.println(flag);


    }
}

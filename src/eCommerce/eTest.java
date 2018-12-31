package eCommerce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

import eCommerce.Product.Category;



public class eTest {
    static ProductPool productPool = new ProductPool();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {


        int eid = 1;
        int hid = 1;
        int cid = 1;
        int bid = 1;
        int fid = 1;

        Product P01 = new Product("E1", "iPhoneXs", 999.0f, Category.Electronics);
        Product P02 = new Product("H1", "Desk", 59.99f, Category.Home);
        Product P03 = new Product("C1", "Shirt", 39.99f, Category.Clothes);
        Product P04 = new Product("B1", "Gone With the Wind", 19.99f, Category.Books);
        Product P05 = new Product("F1", "Pizza", 4.99f, Category.Foods);

        for (Category cate : Product.Category.values()) {
            productPool.map.put(cate, new ArrayList<>());
        }

        productPool.map.get(Category.Electronics).add(P01);
        productPool.map.get(Category.Home).add(P02);
        productPool.map.get(Category.Clothes).add(P03);
        productPool.map.get(Category.Books).add(P04);
        productPool.map.get(Category.Foods).add(P05);



        System.out.println("===== Welcome to the simple eCommerce System =====");

        int input = start();
        if (input == 3) return;
        boolean isAdmin = input == 1;


        if (isAdmin) {
            System.out.println("-- Do you need to insert new Product? (y/n) --");
            boolean isInsert = scanner.next().equals("y");
            //System.out.println(flag);
            if (isInsert) {
                System.out.println("-- Please select the category of new product:"
                                +"\n    1.Electronics  2.Home  3.Clothes  4.Books  5.Foods "
                );

                Category cate = null;
                int num = scanner.nextInt();

                String tempID = "";
                switch (num) {
                    case(1):
                        cate = Category.Electronics;
                        eid++;
                        tempID = "E"+eid;
                        break;
                    case(2):
                        cate = Category.Home;
                        hid++;
                        tempID = "H"+hid;
                        break;
                    case(3):
                        cate = Category.Clothes;
                        cid++;
                        tempID = "C"+cid;
                        break;
                    case(4):
                        cate = Category.Books;
                        bid++;
                        tempID = "B"+bid;
                        break;
                    case(5):
                        cate = Category.Foods;
                        fid++;
                        tempID = "F"+fid;
                        break;
                    default:
                        cate = Category.General;
                        break;
                }

                System.out.println("-- Please input the name of new product: --");
                String name = scanner.next();

                System.out.println("-- Please input the price of new Product: --");
                float price = scanner.nextFloat();

                Product temp = new Product(tempID, name, price, cate);
                productPool.map.get(cate).add(temp);
                System.out.println("--->> New product:"+tempID+"_"+name+"_"+price+"_"+cate.toString()+" added successfully...");

                Thread.sleep(1000);

            } else {
                // TODO: 12/30/18 If this is a Customer


            }



        }





    }

    private static int start() {
        System.out.println("There are 5 categories of products here, " +
                "\n  under Electronics, we now have "+productPool.map.get(Category.Electronics).size()+" products;"+
                "\n  under Home, we now have "+productPool.map.get(Category.Home).size()+" products;"+
                "\n  under Clothes, we now have "+productPool.map.get(Category.Clothes).size()+" products;"+
                "\n  under Books, we now have "+productPool.map.get(Category.Books).size()+" products;"+
                "\n  under Foods, we now have "+productPool.map.get(Category.Foods).size()+" products;"
        );

        System.out.println("-- Please select your user group: --"
                +"\n-- 1. Administrator    2. Customer --    3.Exit"
        );

        return scanner.nextInt();
    }
}

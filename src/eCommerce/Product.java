package eCommerce;

public class Product {
    private String pid;
    private String name;
    private Float price;
    private Category cate;

    public Product() {
        this.pid = null;
        this.price = null;
        this.name = null;
        this.cate = Category.General;
    }

    public Product(String pid, String name, float price, Category cate) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.cate = cate;
    }

    public Product(String pid, String name, float price) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.cate = Category.General;
    }

    /***** Fields *****/

    public enum Category {
        Electronics("Electronics"), Home("Home"), Clothes("Clothes"),
        Books("Books"), Foods("Foods"), General("General");

        public String cate;

        private Category(String cate) {
            this.cate = cate;
        }

        private String getCate() {
            return cate;
        }
    }


    public String  getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public String getState() {
        return cate.getCate();
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setCate(Category cate) {
        this.cate = cate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", cate=" + cate +
                '}';
    }

}

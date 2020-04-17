package shop.number.one;

import shop.number.one.model.Category;
import shop.number.one.model.Order;
import shop.number.one.model.Storage;
import shop.number.one.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Demo {
    private static final String GREETING_MESSAGE = "Добро пожаловать в спортивный интернет-магазин!";
    private static final String CHOOSE_CATEGORY_USER_MESSAGE = "Выберите категорию из списка:%n";
    private static final String CHOOSE_ITEM_USER_MESSAGE = "Выберите товар:";
    public static final String CHOOSE_CATEGORY_ID_USER_MESSAGE = "Укажите номер категории: ";
    public static final String CHOOSE_ITEM_ID_USER_MESSAGE = "Укажите номер товара [или \"0\", чтобы сформировать заказ]: ";

    private static final Storage STORAGE = new Storage();
    private static final User user = new User(1L, "Роман");

    public static void main(String[] args) throws IOException {
        print(GREETING_MESSAGE);
        print(CHOOSE_CATEGORY_USER_MESSAGE);
        printCategories();
        int categoryId = read(CHOOSE_CATEGORY_ID_USER_MESSAGE);
        Category selectedCategory = categoryById(categoryId);
        printItems(selectedCategory);
        Order order = new Order(1L, user);
        while(true) {
            print(CHOOSE_ITEM_USER_MESSAGE);
            int itemId = read(CHOOSE_ITEM_ID_USER_MESSAGE);
            if (itemId == 0) break;
            order.addItem(STORAGE.getItemByIdFromCategory(selectedCategory, itemId));
        }
        print(order.toString());
    }

    private static void printItems(Category category) {
        STORAGE.itemsByCategory(category).entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .forEach(System.out::println);
    }

    private static void print(String msg) {
        System.out.printf(msg);
    }

    private static void printCategories() {
        Stream.of(Category.values()).forEach(Demo::printCategory);
    }

    private static void printCategory(Category category) {
        System.out.printf("%d: %s%n", category.getId(), category);
    }

    private static int read(String msg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        print(msg);
        return Integer.parseInt(br.readLine());
    }

    private static Category categoryById(int id) {
        switch (id) {
            case 1: return Category.CLOTHES;
            case 2: return Category.INVENTORY;
            case 3: return Category.FOOTWEAR;
            case 4: return Category.CAP;
            default: return null;
        }
    }
}

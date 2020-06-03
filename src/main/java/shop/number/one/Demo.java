package shop.number.one;

import shop.number.one.model.Category;
import shop.number.one.model.Item;
import shop.number.one.model.Order;
import shop.number.one.model.Storage;
import shop.number.one.model.User;
import shop.number.one.services.UserServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

import static shop.number.one.model.InfoStoryProperties.CHOOSE_CATEGORY_ID_USER_MESSAGE;
import static shop.number.one.model.InfoStoryProperties.CHOOSE_CATEGORY_USER_MESSAGE;
import static shop.number.one.model.InfoStoryProperties.CHOOSE_ITEM_ID_USER_MESSAGE;
import static shop.number.one.model.InfoStoryProperties.CHOOSE_ITEM_VALUE_MESSAGE;
import static shop.number.one.model.InfoStoryProperties.GREETING_MESSAGE;
import static shop.number.one.model.InfoStoryProperties.GREETING_USER_BIRTHDAY;
import static shop.number.one.model.InfoStoryProperties.GREETING_USER_EMAIL;
import static shop.number.one.model.InfoStoryProperties.GREETING_USER_INFO;
import static shop.number.one.model.InfoStoryProperties.GREETING_USER_NICKNAME;
import static shop.number.one.model.InfoStoryProperties.GREETING_USER_REGISTRATION;
import static shop.number.one.model.InfoStoryProperties.NOT_GOODS_MESSAGE;
import static shop.number.one.model.InfoStoryProperties.NOT_VALID_CATEGORY_MESSAGE;

public class Demo {
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    private static final Storage STORAGE = new Storage();
    private static final UserServiceImpl USER_SERVICE = new UserServiceImpl();


    public static void main(String[] args) throws IOException, ParseException {

        print(GREETING_MESSAGE);
        print(GREETING_USER_INFO);

        User user = new User(
                readInfoUser(GREETING_USER_NICKNAME),
                readInfoUser(GREETING_USER_EMAIL),
                formatter.parse(readInfoUser(GREETING_USER_BIRTHDAY))
        );
        print(String.format(GREETING_USER_REGISTRATION, USER_SERVICE.save(user).getNickname()));

        Order order = new Order(user);

        print(CHOOSE_CATEGORY_USER_MESSAGE);
        printCategories();

        while (true) {
            int categoryId = read(CHOOSE_CATEGORY_ID_USER_MESSAGE);
            if (shouldOrderBeSubmitted(categoryId)) break;

            Category selectedCategory = categoryById(categoryId);
            if (selectedCategory == null) {
                print(String.format(NOT_VALID_CATEGORY_MESSAGE, categoryId));
                continue;
            }

            while (true) {
                printItems(selectedCategory);
                int itemId = read(CHOOSE_ITEM_ID_USER_MESSAGE);
                if (shouldOrderBeSubmitted(itemId)) break;

                Item itemByIdFromCategory = STORAGE.getItemByIdFromCategory(selectedCategory, itemId);
                int itemCountInDb = STORAGE.getItemValue(selectedCategory, itemByIdFromCategory);
                int itemCountByBucket = read(buildUserMessage(CHOOSE_ITEM_VALUE_MESSAGE, itemCountInDb));

                if (itemCountByBucket <= itemCountInDb && itemCountByBucket > 0) {
                    STORAGE.removeItemFromCategory(selectedCategory, STORAGE.getItemByIdFromCategory(selectedCategory, itemId), itemCountByBucket);
                    order.addItem(itemByIdFromCategory, itemCountByBucket);
                    continue;
                }
                print(buildUserMessage(NOT_GOODS_MESSAGE, itemCountInDb));
            }
            print(CHOOSE_CATEGORY_USER_MESSAGE);
            printCategories();

        }
        print(order.toString());
    }

    private static boolean shouldOrderBeSubmitted(int itemId) {
        return itemId == 0;
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

    private static String buildUserMessage(String template, Object... itemValue) {
        return String.format(template, itemValue);
    }

    private static void printCategory(Category category) {
        System.out.printf("%d: %s%n", category.getId(), category);
    }

    private static int read(String msg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        print(msg);
        return Integer.parseInt(br.readLine());
    }

    private static String readInfoUser(String msg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        print(msg);
        return br.readLine();
    }

    private static void printDebugInfoUser(Object object) {
        System.out.println("#######DEBUG INFO########");
        System.out.println(object);
        System.out.println("#######END OF DEBUG INFO#######%n");
    }

    private static Category categoryById(int id) {
        switch (id) {
            case 1:
                return Category.CLOTHES;
            case 2:
                return Category.INVENTORY;
            case 3:
                return Category.FOOTWEAR;
            case 4:
                return Category.CAP;
            default:
                return null;
        }
    }
}

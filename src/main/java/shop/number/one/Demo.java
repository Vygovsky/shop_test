package shop.number.one;

import shop.number.one.model.Category;
import shop.number.one.model.Item;
import shop.number.one.model.Order;
import shop.number.one.model.User;
import shop.number.one.services.CategoryServiceImpl;
import shop.number.one.services.ItemServiceImpl;
import shop.number.one.services.UserServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
    private static final UserServiceImpl USER_SERVICE = new UserServiceImpl();
    private static final CategoryServiceImpl CATEGORY_SERVICE = new CategoryServiceImpl();
    private static final ItemServiceImpl ITEM_SERVICE = new ItemServiceImpl();


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
            long categoryId = read(CHOOSE_CATEGORY_ID_USER_MESSAGE);
            if (shouldOrderBeSubmitted(categoryId)) break;

            Category selectedCategory = categoryById(categoryId);
            if (selectedCategory == null) {
                print(String.format(NOT_VALID_CATEGORY_MESSAGE, categoryId));
                continue;
            }

            while (true) {
                printItems(selectedCategory);
                long itemId = read(CHOOSE_ITEM_ID_USER_MESSAGE);
                if (shouldOrderBeSubmitted(itemId)) break;

                Item itemByIdFromCategory = ITEM_SERVICE.findById(itemId);
                long itemCountInDb = ITEM_SERVICE.getCount(itemByIdFromCategory.getId());
                int itemCountByBucket = read(buildUserMessage(CHOOSE_ITEM_VALUE_MESSAGE, itemCountInDb));

                if (itemCountByBucket <= itemCountInDb && itemCountByBucket > 0) {
                    ITEM_SERVICE.quantityItemByCategory(itemByIdFromCategory.getId(), itemCountByBucket);
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

    private static boolean shouldOrderBeSubmitted(long itemId) {
        return itemId == 0;
    }

    private static void printItems(Category category) {
        ITEM_SERVICE.itemsByCategory(category).forEach(System.out::println);
    }

    private static void print(String msg) {
        System.out.printf(msg);
    }

    private static void printCategories() {
        CATEGORY_SERVICE.findAll().forEach(Demo::printCategory);
    }

    private static void printCategory(Category category) {
        System.out.printf("%d: %s%n", category.getId(), category.getName());
    }

    private static String buildUserMessage(String template, Object... itemValue) {
        return String.format(template, itemValue);
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

    //fix if to switch
    private static Category categoryById(Long id) {
        if (1L == id) {
            return CATEGORY_SERVICE.findById(id);
        } else if (2L == id) {
            return CATEGORY_SERVICE.findById(id);
        } else if (3L == id) {
            return CATEGORY_SERVICE.findById(id);
        } else if (4L == id) {
            return CATEGORY_SERVICE.findById(id);
        } else {
            return null;
        }
    }
}

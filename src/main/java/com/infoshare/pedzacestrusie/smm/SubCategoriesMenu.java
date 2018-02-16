package com.infoshare.pedzacestrusie.smm;

import java.util.*;

public class SubCategoriesMenu extends Menu {

    private Set<String> categorySet = new TreeSet<>(Arrays.asList("Cat01", "Cat02", "Cat03"));
    String[] subCategoryMenuItems = categorySet.stream().toArray(String[]::new);

    private int idx = 1;
    private String categories;

    public SubCategoriesMenu() {
        String menuContent = createMenuItems(subCategoryMenuItems);
        chooseMenuItems(addExitLineToMenuItems(menuContent));
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    @Override
    protected void chooseMenuItems(String menuDescr) {
        System.out.println(menuDescr);
        while (true) {
            try {
                idx = new Scanner(System.in).nextInt();
                if (idx >= 0 && idx < menuDescr.length()) {
                    checkUserSelection(idx);
                    break;
                }
            } catch (InputMismatchException e) {
                continue;
            }
        }
    }

    @Override
    protected void checkUserSelection(int idx) {
        this.setCategories(subCategoryMenuItems[idx - 1]);
    }
}

package com.infoshare.pedzacestrusie.smm;

import java.util.*;

public class SubCategoriesMenu extends Menu {

    private Set<String> categorySet = new TreeSet<>(Arrays.asList("Cat01", "Cat02", "Cat03"));
    String[] subCategoryMenuItems = categorySet.stream().toArray(String[]::new);

    private int idx = 1;
    private String categories;

    public SubCategoriesMenu() {
        String menuContent = setMenuDescription(subCategoryMenuItems);
//        chooseMenuItems(setExitLineInMenu(menuContent));
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }



    @Override
    protected void checkUserSelection(int idx) {
        this.setCategories(subCategoryMenuItems[idx - 1]);
    }
}

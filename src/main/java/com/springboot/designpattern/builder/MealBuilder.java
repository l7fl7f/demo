package com.springboot.designpattern.builder;

/**
 * 菜单
 */
public class MealBuilder {

    /**
     * 点套餐1
     * @return
     */
    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    /**
     * 点套餐2
     * @return
     */
    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}

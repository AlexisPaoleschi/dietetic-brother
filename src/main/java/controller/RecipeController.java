package controller;

public class RecipeController {

    // private void addFood(Food food) {
    // if (mapFood.containsKey(food)) {
    // mapFood.put(food, mapFood.get(food) + 1);
    // } else {
    // mapFood.put(food, 1);
    // }
    // }
    //
    // private void deleteFood(Food food) {
    // mapFood.remove(food);
    // }
    //
    // private void deleteFoodByString(String foodName) {
    // mapFood.forEach((food, integer) -> {
    // if (food.getFoodName().equals(foodName)) {
    // mapFood.remove(food);
    // }
    // });
    // }
    //
    // private void computeFoodMacroNutrimentQuantity(Map<Food, Integer> mapFood) {
    // double qtyGlu = 0;
    // double qtyLip = 0;
    // double qtyPro = 0;
    //
    // for (Food f : mapFood) {
    // qtyGlu += f.getFoodGlucideRate() * f.getQuantity();
    // qtyLip += f.getFoodLipideRate() * f.getQuantity();
    // qtyPro += f.getFoodProteineRate() * f.getQuantity();
    // }
    //
    // setGlucideQuantity(qtyGlu);
    // setLipideQuantity(qtyLip);
    // setProteineQuantity(qtyPro);
    // }
    //
    // private Map<String, Double> calculateFoodMacroNutrimentQuantityAsRate() {
    // Map<String, Double> mapRate = new HashMap<>();
    // Double recipeWeight = getGlucideQuantity() + getLipideQuantity() + getProteineQuantity();
    // mapRate.put("glucideRate", getGlucideQuantity() / recipeWeight);
    // mapRate.put("lipideRate", getLipideQuantity() / recipeWeight);
    // mapRate.put("proteineRate", getProteineQuantity() / recipeWeight);
    // return mapRate;
    // }
}

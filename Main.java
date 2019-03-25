/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static Pizza findCheapestSpicy() {
        Pizza p = Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream().anyMatch(i -> i.isSpicy()))
                .sorted((Pizza p1, Pizza p2) -> p1.getIngredients().stream().mapToInt(Ingredient::getPrice).sum() - p2.getIngredients().stream().mapToInt(Ingredient::getPrice).sum())
                .findFirst()
                .orElse(null);
        
        return p;
    }

   public static void formatedMenu()
     {
         Arrays.stream(Pizza.values())
                 .forEach(pizza -> System.out.println(pizza.getName()+":"+pizza.getIngredients()+"-"+pizza.getIngredients().stream().mapToInt(Ingredient::getPrice).sum()));
     }
    
    public static List<Pizza> iLikeMeat()
    {
        List<Pizza> p=Arrays.stream(Pizza.values())
                .filter(pizza->pizza.getIngredients().stream().anyMatch(Ingredient::isMeat))
                .sorted((Pizza p1, Pizza p2)->(int) p2.getIngredients().stream().filter(Ingredient::isMeat).count() - (int) p1.getIngredients().stream().filter(Ingredient::isMeat).count())
                .collect(Collectors.toList());
        
        return p;
    }
    
    public static Map<Integer,List<Pizza>> groupByPrice()
    {
        Map<Integer,List<Pizza>> p=Arrays.stream(Pizza.values())
                .collect(Collectors.groupingBy(pizza->pizza.getIngredients().stream().mapToInt(Ingredient::getPrice).sum()));
        
        return p;
    }
    
    public static Pizza findMostExpensiveVegetarian()
    {
        Pizza p = Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream().noneMatch(i -> i.isMeat()))
                .max((Pizza p1, Pizza p2) -> p1.getIngredients().stream().mapToInt(Ingredient::getPrice).sum() - p2.getIngredients().stream().mapToInt(Ingredient::getPrice).sum())
                .orElse(null);
        
        return p;
    }

    public static void main(String[] args) {

       List<Pizza> a=iLikeMeat();
       System.out.print(a);
    }
    
}
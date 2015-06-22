package com.twu.biblioteca;

import com.twu.biblioteca.service.Collection;

import java.util.Scanner;

/**
 * Created by wmartins on 6/18/15.
 */
public class ItemsInteractions {
    static final String ASK_TITLE= "What is the title?";
    Scanner in = new Scanner(System.in);

    public void showInteraction(Collection item){

        System.out.println(ASK_TITLE);

        String name = in.nextLine();

        String itemDetails = item.findItem(name).toString();

        System.out.println(itemDetails);

    }

    public void checkOut(Collection item, String type, User currentUser){

        System.out.println(ASK_TITLE);
        in.nextLine();
        String name = in.nextLine();

        if (!item.isThere(name)) {
            item.checkOut(name, currentUser);
            System.out.println("Thank you! Enjoy the " + type);
        } else{
            System.out.println("That " + type + " is not available");
        }
    }

    public void returnInteraction(Collection item, String type, User libraryUser){

        System.out.println(ItemsInteractions.ASK_TITLE);

        String name = in.nextLine();

        if(item.returnItem(name, libraryUser)){
            System.out.println("Thank you for returning the " + type);
        }
        else {
            System.out.println("That is not a valid " + type + " to return.");
        }
    }
}

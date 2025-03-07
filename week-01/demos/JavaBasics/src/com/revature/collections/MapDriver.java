package com.revature.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapDriver {

    /*
    Maps are a data structure with a key and a value. Typically Keys are unique and there are varying rules about null
    values

    Examples:
    - Dictionary: word -> definition
    - Phonebook: name -> phone number
    - Cipher: letter -> different letter
     */

    public static void main(String[] args){

        // To declare a Map we need the Map interface and an implementing class
        Map<String, String> phonebook = new HashMap<>();

        // Maps don't generally preserve order upon entry

        // Adding some values/contacts to our phonebook
        phonebook.put("Alice", "123-456-7890");
        phonebook.put("Bob", "987-654-3210");
        phonebook.put("Charlie", "123-123-1234");

        // If you want to update something in the map you will need to use the same key
        phonebook.put("Alice", "123-456-5555");

        // Let's look at our phonebook
        System.out.println(phonebook);

        // Get Bob's phonenumber
        System.out.println("Bob's Phone Number: " + phonebook.get("Bob"));

        // Check if a Key exists
        System.out.println("Do we have Stephen's phone number? " + phonebook.containsKey("Stephen"));

        // Remove things by their Key
        phonebook.remove("Charlie");
        System.out.println(phonebook);

        // It's important to note that Maps are not considered part of the Collections Framework because they do not
        // extend Collection or Iterable, HOWEVER, we can still iterate over them if we grab their entryset or keyset
        // An EntrySet is a set of all entries in the Map
        // A KeySet include a set of all the Keys
        for (String name : phonebook.keySet()){
            // Iterate over all the Keys
            System.out.println(name + " -> " + phonebook.get(name));
        }

        // Size, Clear, etc


        // Caesar Cipher Using a map
        // Caesar Cipher is a cipher that uses shifting letters in the alphabet to encode words
        // You could probably solve this problem more dynamically using character values but that's not important
        Map<Character, Character> cipher = new HashMap<>();
        cipher.put('A', 'D');
        cipher.put('B', 'E');
        cipher.put('C', 'F');
        cipher.put('D', 'G');
        cipher.put('E', 'H');
        cipher.put('F', 'I');
        cipher.put('G', 'J');
        cipher.put('H', 'K');
        cipher.put('I', 'L');
        cipher.put('J', 'M');
        cipher.put('K', 'N');
        cipher.put('L', 'O');
        cipher.put('M', 'P');
        cipher.put('N', 'Q');
        cipher.put('O', 'R');
        cipher.put('P', 'S');
        cipher.put('Q', 'T');
        cipher.put('R', 'U');
        cipher.put('S', 'V');
        cipher.put('T', 'W');
        cipher.put('U', 'X');
        cipher.put('V', 'Y');
        cipher.put('W', 'Z');
        cipher.put('X', 'A');
        cipher.put('Y', 'B');
        cipher.put('Z', 'C');

        // All the letters in the alphabet shifted by 3 letters
        // Let's take in some user input
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a message to encode");
        String input = scan.nextLine();
        // Let's convert the string to all caps
        input = input.toUpperCase();

        // If the map contains the letter, then shift it to the encode place and go from them
        String encodedMessage = "";

        for (Character c: input.toCharArray()){
            if (cipher.containsKey(c)){
                encodedMessage += cipher.get(c);
            } else{
                encodedMessage += c;
                // This else block handles things like spaces and number
            }
        }

        System.out.println(encodedMessage);
    }
}

package com.example.thunderdome;

//PestoSandwich

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// This script handles the ThunderBowl features. Currently we only select a random item out of preselected lists so it is quite simple

public class ThunderDome{

    // We declare certain id's which we use as static Integers. By doing this we can use the more understandable "ATTACKER" instead of 1001 when we want to refer to the list of D20 variations that depend on attackers.

    public static final Integer ATTACKER = 1001;
    public static final Integer EVASIVE_ATTACKER = 1002;
    public static final Integer OPPONENTS_TURN = 1003;
    public static final Integer LOW_COUNTER = 1004;
    public static final Integer HIGH_COUNTER = 1005;

    //This rollTable function handles almost all the functionality. We give it the ID of the list we want to roll an item from,
    // it then selects the appropriate case and returns one entry selected at random by the rollDice function.

    public String rollTable(Integer hashmap_id){
        switch(hashmap_id){
            case 1001:
                int roll = rollDice(AttackerMap);
                return "Your opponent rolled a " + String.valueOf(roll) + ": \n\n" + AttackerMap.get(roll);
//            case 1002:
//                roll = rollDice(evasiveAttackerMap);
//                return "Your opponent rolled a " + String.valueOf(roll) + ": \n\n" + evasiveAttackerMap.get(roll);
            case 1003:
                roll = rollDice(opponentsTurnMap);
                return "Your opponent rolled a " + String.valueOf(roll) + ": \n\n" + opponentsTurnMap.get(roll);
            case 1004:
                roll = rollDice(CounterMap);
                return "Your opponent rolled a " + String.valueOf(roll) + ": \n\n" + CounterMap.get(roll);
            case 1005:
//                roll = rollDice(HighCounterMap);
//                return "Your opponent rolled a" + String.valueOf(roll) + ": \n\n" + HighCounterMap.get(roll);
            default:
                return "Map not found";
        }
    }


    // This code returns a diceroll between 1 and the maximum number of entries in the list we are rolling. We could make the maps above any size we want.
    private Integer rollDice(Map map){
        Random r = new Random();
        return r.nextInt(map.size())+1;
    }

    //Below we declare the maps from which we draw information. We could retrieve from an external file but as this is just a mockup they are currently hardcoded.
    //There is an argument to be made that the declaration should be at the top of the script file, however, since the code is so small relative to the size of these declarations
    //I believe this order improves the readability of the code.

    private static Map<Integer, String> AttackerMap;
    static {
        AttackerMap = new HashMap<>();
        AttackerMap.put(1, "Opponent responds! Destroy attacking creature");
        AttackerMap.put(2, "Opponent responds! Destroy attacking creature");
        AttackerMap.put(3, "Creature does not deal combat damage");
        AttackerMap.put(4, "Creature does not deal combat damage");
        AttackerMap.put(5, "Creature does not deal combat damage");
        AttackerMap.put(6, "Creature does not deal combat damage");
        AttackerMap.put(7, "Creature does not deal combat damage");
        AttackerMap.put(8, "If the creature is not evasive, the creature does not deal combat damage");
        AttackerMap.put(9, "If the creature is not evasive, the creature does not deal combat damage");
        AttackerMap.put(10, "If the creature is not evasive, the creature does not deal combat damage");
        AttackerMap.put(11, "Creature deals combat damage");
        AttackerMap.put(12, "Creature deals combat damage");
        AttackerMap.put(13, "Creature deals combat damage");
        AttackerMap.put(14, "Creature deals combat damage");
        AttackerMap.put(15, "Creature deals combat damage");
        AttackerMap.put(16, "Creature deals combat damage");
        AttackerMap.put(17, "Creature deals combat damage");
        AttackerMap.put(18, "Creature deals combat damage");
        AttackerMap.put(19, "Creature deals combat damage");
        AttackerMap.put(20, "Crit! Creature deals twice as much combat damage");
    }

//    private static Map<Integer, String> evasiveAttackerMap;
//    static {
//        evasiveAttackerMap = new HashMap<>();
//        evasiveAttackerMap.put(1, "Opponent responds! Destroy attacking creature");
//        evasiveAttackerMap.put(2, "Opponent responds! Destroy attacking creature");
//        evasiveAttackerMap.put(3, "Creature does not deal combat damage");
//        evasiveAttackerMap.put(4, "Creature does not deal combat damage");
//        evasiveAttackerMap.put(5, "Creature does not deal combat damage");
//        evasiveAttackerMap.put(6, "Creature does not deal combat damage");
//        evasiveAttackerMap.put(7, "Creature deals combat damage");
//        evasiveAttackerMap.put(8, "Creature deals combat damage");
//        evasiveAttackerMap.put(9, "Creature deals combat damage");
//        evasiveAttackerMap.put(10, "Creature deals combat damage");
//        evasiveAttackerMap.put(11, "Creature deals combat damage");
//        evasiveAttackerMap.put(12, "Creature deals combat damage");
//        evasiveAttackerMap.put(13, "Creature deals combat damage");
//        evasiveAttackerMap.put(14, "Creature deals combat damage");
//        evasiveAttackerMap.put(15, "Creature deals combat damage");
//        evasiveAttackerMap.put(16, "Creature deals combat damage");
//        evasiveAttackerMap.put(17, "Creature deals combat damage");
//        evasiveAttackerMap.put(18, "Creature deals combat damage");
//        evasiveAttackerMap.put(19, "Creature deals combat damage");
//        evasiveAttackerMap.put(20, "Crit! Creature deals twice as much combat damage");
//    }

    private static Map<Integer, String> opponentsTurnMap;
    static {
        opponentsTurnMap = new HashMap<>();
        opponentsTurnMap.put(1, "[Spell] Destroy all nonland permanents");
        opponentsTurnMap.put(2, "[Spell] Destroy all creatures");
        opponentsTurnMap.put(3, "[Spell] Destroy all artifacts");
        opponentsTurnMap.put(4, "[Spell] Destroy all enchantments");
        opponentsTurnMap.put(5, "[Spell] Sacrifice highest-power creature and take 2 damage");
        opponentsTurnMap.put(6, "[Spell] Return each commander to command zone");
        opponentsTurnMap.put(7, "[Spell] Destroy your best artifact");
        opponentsTurnMap.put(8, "[Spell] Destroy your best enchantment");
        opponentsTurnMap.put(9, "[Spell] Destroy best non-basic land");
        opponentsTurnMap.put(10, "[Combat] Take 2 combat damage");
        opponentsTurnMap.put(11, "[Combat] Take 3 direct damage");
        opponentsTurnMap.put(12, "[Combat] Take 4 combat damage");
        opponentsTurnMap.put(13, "[Combat] Take 5 direct damage");
        opponentsTurnMap.put(14, "[Combat] Take 6 combat damage");
        opponentsTurnMap.put(15, "[Combat] Take 7 direct damage");
        opponentsTurnMap.put(16, "[Combat] Take 8 combat damage");
        opponentsTurnMap.put(17, "[Combat] Take 9 direct damage");
        opponentsTurnMap.put(18, "[Combat] Take 10 combat damage");
        opponentsTurnMap.put(19, "[Ability] Exile all graveyards");
        opponentsTurnMap.put(20, "[Ability] Draw a card");
    }

    private static Map<Integer, String> CounterMap;
    static {
        CounterMap = new HashMap<>();
        CounterMap.put(1, "Spell resolves");
        CounterMap.put(2, "Spell resolves");
        CounterMap.put(3, "Spell resolves");
        CounterMap.put(4, "Spell resolves");
        CounterMap.put(5, "Spell is countered if it is CMC 7 or higher");
        CounterMap.put(6, "Spell is countered if it is CMC 7 or higher");
        CounterMap.put(7, "Spell is countered if it is CMC 4 or higher");
        CounterMap.put(8, "Spell is countered if it is CMC 4 or higher");
        CounterMap.put(9, "Spell is countered if it is CMC 4 or higher");
        CounterMap.put(10, "Spell is countered");
    }

//    private static Map<Integer, String> HighCounterMap;
//    static {
//        HighCounterMap = new HashMap<>();
//        HighCounterMap.put(1, "Spell resolves");
//        HighCounterMap.put(2, "Spell resolves");
//        HighCounterMap.put(3, "Spell resolves");
//        HighCounterMap.put(4, "Spell resolves");
//        HighCounterMap.put(5, "Spell resolves");
//        HighCounterMap.put(6, "Spell is countered");
//        HighCounterMap.put(7, "Spell is countered");
//        HighCounterMap.put(8, "Spell is countered");
//        HighCounterMap.put(9, "Spell is countered");
//        HighCounterMap.put(10, "Spell is countered");
//    }

    //


}

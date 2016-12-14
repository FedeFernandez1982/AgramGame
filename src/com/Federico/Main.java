package com.Federico;


import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Deck deck = new Deck();
        deck.shuffle();


        Scanner namePLayer = new Scanner(System.in);
        System.out.println("Please introduce the name of the Human Player: ");
        String playerName = namePLayer.nextLine();

        //creating human player
        Player human = new Player();
        human.setName(playerName);
        human.setType("Human");

        //creating computer player
        Player cpu = new Player();
        cpu.setName("HAL 9000");
        cpu.setType("Computer");

        //dealing cards to players
        deck.deal(human);
        deck.deal(cpu);

        String finalGame = "";

        //main loop of the game
        for (int x = 0; x < 6; x++) {

            Card atTable = HumanTurn(human);
            Card atTable2 = CPUTurn(cpu, atTable);



            System.out.println("Computer played " + atTable2);

            if (atTable.getSuit() != atTable2.getSuit()){
                System.out.println("\n" + human.getName() + " Wins the round");
                finalGame = human.getName() + "wins!!!";

            }else if (atTable.getValue() >= atTable2.getValue()){
                System.out.println("\n" + human.getName() + " Wins the round");
                finalGame = human.getName() + "wins!!!";
            }else{
                System.out.println("\n" + cpu.getName() + " Wins the round");
                finalGame = cpu.getName() + " wins!!!";
            }

        }
        System.out.println("\n And the winner of the game of Agram is: " + finalGame);
    }

    //method for the human player turn
    public static Card HumanTurn(Player human) {
        Scanner cardPlayed = new Scanner(System.in);
        System.out.println(human.name + "'s Hand:");
        int cardIndex = 1;
        for (Card c : human.hand) {

            System.out.println(cardIndex + "." + c.toString());
            cardIndex++;
        }

        System.out.println("Pick the card you want to play:");
        int cardi = cardPlayed.nextInt();



        System.out.println(human.name + " played " + human.hand.get(cardi - 1));
        Card HumanCardPlayed = human.hand.get(cardi - 1);
        human.hand.remove(cardi - 1);
        return HumanCardPlayed;

    }
    //method for the cpu turn
    public static Card CPUTurn(Player cpu, Card atTable) {
        Card toPlay = new Card("0", 15);//placeholder card to cycle through the computer hand


        for (Card c : cpu.hand)
        {
            if (c.getSuit().equals(atTable.suit) && c.getValue() < toPlay.getValue())
            {
                toPlay = c;
            }
        }

        // If no cards matched the suit of the round, find the lowest value amongst the cards.
        if (toPlay.getValue() == 15)
        {
            for (Card c : cpu.hand)
            {
                if (c.getValue() < toPlay.getValue())
                {
                    toPlay = c;
                }
            }
        }

        // Remove the card to play from the player's hand.
        cpu.hand.remove(toPlay);
        return toPlay;
    }

}

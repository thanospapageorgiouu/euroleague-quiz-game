package com.ath.euroquiz.managers;

import com.ath.euroquiz.models.Player;
import com.ath.euroquiz.models.Question;

import java.util.ArrayList;

public class GameManager {
    public Player player1 = new Player("Player 1");
    public Player player2 = new Player("Player 2");

    public Player currentPlayer;

    public ArrayList<Question> available_questions;
}

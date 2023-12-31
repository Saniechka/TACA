package main.serverTest;

import main.game.Board;

import java.util.ArrayList;

public class BoardHolder {
    ArrayList<Board> boardArrayList = new ArrayList<Board>();


    public void addBoard(Board board){
        boardArrayList.add(board);
    }

    public Board getBoard(String id){
        for (Board board:
             boardArrayList) {
            if(board.getId().equals(id)) return board;
            else return null;
        }
        return null;
    }

    public boolean removeBoard(Board board){
        return boardArrayList.remove(board);
    }
}

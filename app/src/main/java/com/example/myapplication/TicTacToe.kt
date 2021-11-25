package com.example.myapplication

import java.lang.StringBuilder

class TicTacToe(private val gameBoard: MutableList<String>, private val player1: String, private val player1Sign: String,
                private val player2: String, private val player2Sign: String, private var turn: String) {


    fun startGame(){
        if(turn.equals(player1)){
            readAndUpdatePosition(player1,player1Sign)
            turn = player2
        }else if(turn.equals(player2)){
            readAndUpdatePosition(player2,player2Sign)
            turn = player1
        }

        showBoard()
        val result = checkWinner()

        if(result != null){ // place not empty on board
            if(result.equals("draw")){
                println("match drawn")
                return
            }else{
                println("$result won")
                return
            }
        }
        startGame()
    }

    private fun readAndUpdatePosition(playerName: String, playerSign: String) {
        var isTrue = true
        while(isTrue){
            println("$playerName, enter position between 1-9 to place your sign $playerSign")
            val pos = readLine()
            if(isValidInput(pos)){
                updateBoard(pos?.toInt()?.minus(1)!!, playerSign)
                isTrue = false
            }
        }
    }

    private fun updateBoard(pos: Int, sign: String) {
        when(pos) {
            0 ->{
                gameBoard[0] = sign
            }
            1 ->{
                gameBoard[1] = sign
            }
            2 ->{
                gameBoard[2] = sign
            }
            3 ->{
                gameBoard[3] = sign
            }
            4 ->{
                gameBoard[4] = sign
            }
            5 ->{
                gameBoard[5] = sign
            }
            6 ->{
                gameBoard[6] = sign
            }
            7 ->{
                gameBoard[7] = sign
            }
            8 ->{
                gameBoard[8] = sign
            }
        }
    }

    private fun isValidInput(pos: String?): Boolean {
        try{
            pos?.toInt()?.let {
                return if(it in 1..9){
                    if(!gameBoard.contains(it.toString())){
                        println("Position $it is already used, please use other position")
                        false
                    }else{
                        true
                    }
                }else{
                    println("Please provide valid input position between 1-9")
                    false
                }
            }
            println("Please provide valid input")
            return false
        }catch (e: NumberFormatException){
            println("Please provide valid input position between 1-9")
            return false
        }
    }

    private fun showBoard(){
        print("\t ${gameBoard[0]} \t ${gameBoard[1]} \t ${gameBoard[2]} \n")
        print("\t ${gameBoard[3]} \t ${gameBoard[4]} \t ${gameBoard[5]} \n")
        print("\t ${gameBoard[6]} \t ${gameBoard[7]} \t ${gameBoard[8]} \n")
    }

    private fun checkWinner() : String? {
        var string = StringBuilder()
        for(paths in 0..7){
            when(paths){
                0 -> {
                    string = StringBuilder().append(gameBoard[0]).append(gameBoard[1]).append(gameBoard[2])
                }
                1 -> {
                    string = StringBuilder().append(gameBoard[3]).append(gameBoard[4]).append(gameBoard[5])
                }
                2 -> {
                    string = StringBuilder().append(gameBoard[6]).append(gameBoard[7]).append(gameBoard[8])
                }
                3 -> {
                    string = StringBuilder().append(gameBoard[0]).append(gameBoard[3]).append(gameBoard[6])
                }
                4 -> {
                    string = StringBuilder().append(gameBoard[1]).append(gameBoard[4]).append(gameBoard[7])
                }
                5 -> {
                    string = StringBuilder().append(gameBoard[2]).append(gameBoard[5]).append(gameBoard[8])
                }
                6 -> {
                    string = StringBuilder().append(gameBoard[0]).append(gameBoard[4]).append(gameBoard[8])
                }
                7 -> {
                    string = StringBuilder().append(gameBoard[2]).append(gameBoard[4]).append(gameBoard[6])
                }
            }

            if(string.toString().equals("xxx")){
                if(player1Sign.equals("x")){
                    return player1
                }else{
                    return player2
                }
            }else if(string.toString().equals("000")){
                if(player1Sign.equals("0")){
                    return player1
                }else{
                    return player2
                }
            }
        }

        for(i in 0..8){
            if(gameBoard[i] != "x" && gameBoard[i] != "0"){
                return null
            }
        }
        return "draw"
    }
}
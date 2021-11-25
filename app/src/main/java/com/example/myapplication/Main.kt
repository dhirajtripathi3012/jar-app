package com.example.myapplication

fun main(){

    var player1 : String? = null
    var player2 : String? = null
    val gameBoard : MutableList<String> = arrayListOf()
    var player1Sign : String? = null
    var player2Sign : String? = null
    var turn : String? = null

    var isCorrectName1 = true
    while(isCorrectName1){
        println("Enter Player1 name: ")
        player1 = readLine()

        if(player1?.length !=0){
            isCorrectName1 = false
        }else {
            println("Please provide valid name")
        }
    }

    var isCorrectName2 = true
    while(isCorrectName2){
        println("Enter Player2 name: ")
        player2 = readLine()

        if(player2?.length != 0){
            if(player1.equals(player2)){
                println("Both player name can not be same")
            }else{
                isCorrectName2 = false
            }
        }else{
            println("Please provide valid name")
        }
    }

    for(i in 0..8){
        gameBoard.add(i,(i+1).toString())
    }

    val counter = (1..2).random()
    if(counter == 1){
        println("$player1, you can choose first which sign you want to pick")
        turn = player1
        var isValidInput = true

        while(isValidInput){
            println("Enter your sign")
            val input = readLine()

            if(input?.length == 1 && (input.equals("x") || input.equals("0"))){
                player1Sign = input

                if(input.equals("x")){
                    player2Sign = "0"
                }else{
                    player2Sign = "x"
                }

                isValidInput = false
            }else{
                println("Please enter a valid input from x or 0")
            }
        }
    }else{
        println("$player2, you can choose first which sign you want to pick")
        turn = player2
        var isValidInput = true
        while(isValidInput){
            println("Enter your sign")
            val input = readLine()

            if(input?.length == 1 && (input.equals("x") || input.equals("0"))){
                player2Sign = input

                if(input.equals("x")){
                    player1Sign = "0"
                }else{
                    player1Sign = "x"
                }

                isValidInput = false
            }else{
                println("Please enter a valid input from x or 0")
            }
        }
    }

    val tic = TicTacToe(gameBoard,player1!!,player1Sign!!,player2!!,player2Sign!!,turn!!)
    tic.startGame()
}


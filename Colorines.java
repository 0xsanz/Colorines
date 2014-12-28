/*
 *@author Pablo García Sanz 
*/
import java.util.Scanner;
import java.lang.Math;

public class Colorines{
	
	public static void main(String args[]){
		
		/*Scanner object type to store the value of the column*/
		Scanner column=new Scanner(System.in);
		String tablero[][]=initialBoard(10,6);
		/*Column vector is a vector representing each of the columns*/
		columnVector(tablero);
		printedBoard(tablero);
		/*The Variable LoopControl will have the function to update the main loop*/
		boolean loopControl=true;
		/*Main loop (while)*/
		while(loopControl){
			long colour=colour();
			System.out.println("Nueva pieza: "+colour);
			System.out.println("¿Columna?");
			/*Col is an object of type Scanner will store the value of the column entered by keyboard*/
			int col=column.nextInt();
			/*If the value is 0--->LoopControl = false*/
			if(col==0){
				loopControl=false;
				System.out.println("Ha salido del juego");
			}
			/*If the value is less than 0 or greater than 6 will ask a new value*/
			else if(col<0||col>tablero[0].length){
				do{System.out.println("Columna incorrecta");
				col=column.nextInt();
				}
				while(col<0||col>tablero[0].length);
				/*If the value is 0--->LoopControl = false*/
				if(col==0){
					System.out.println("Ha salido del juego");
					System.exit(0);
				}
				/*introduceColour-->changeColour-->deleteRow-->*/
				else{
				introduceColour(col,tablero,colour);
				changeColour(tablero,col);
				deleteRow(tablero);
				/*If a row is complete:printedBoard-->space--> LoopControl = false*/
				if(completeColumn(tablero)==true){
					columnVector(tablero);
					printedBoard(tablero);
					space();
					System.out.println("El juego ha terminado");
					loopControl=false;
				}
				/*columnVector-->printedBoard-->space*/
				else{
					columnVector(tablero);
					printedBoard(tablero);
					space();
				}
				
				}
				}
			/*Else:introduceColour-->changeColour-->deleteRow*/
			else{
				introduceColour(col,tablero,colour);
				changeColour(tablero,col);
				deleteRow(tablero);
				/*If a column is complete:printedBoard-->space--> LoopControl = false*/
				if(completeColumn(tablero)==true){
					columnVector(tablero);
					printedBoard(tablero);
					space();
					System.out.println("El juego ha terminado");
					loopControl=false;
				}
				/*printedBoard-->space*/
				else{
				columnVector(tablero);
				printedBoard(tablero);
				space();
				}
				}
		}
	}
	public static String[][] initialBoard(int rows, int columns){
		/*Matrix of 10 rows and 6 columns*/
		String matriz[][]=new String[rows][columns];
	
		int i,j;
		for(i=0;i<matriz.length;i++){
			for(j=0;j<matriz[i].length;j++){
				matriz[i][j]="-";
			}
		}
		return matriz;
	}
	public static void printedBoard(String matriz[][]){
		//matriz[i][j]
		int i,j;
		
		for(i=0;i<matriz.length;i++){
			for(j=0;j<matriz[i].length;j++){
				/*printing each of the elements of row i*/
				System.out.print(matriz[i][j]);
				/*Tabulator*/
				System.out.print("\t");
			}
			/*Newline*/
			System.out.println("");		
		}
	
	}
	public static void introduceColour(int column,String matriz[][],long colour){
		/**/
		int i;		
		String piece=Long.toString(colour);
		for(i=matriz.length-1;i>=0;i--){
			if(matriz[i][column-1].equals("-")){
				matriz[i][column-1]=piece;
				i=0;
			}
		}
		
			}
	public static void changeColour(String matriz[][],int column){
		/*This method change the color*/
		int i;
		/*If the position of the row i column j is worth (x) and the position of the row (i-1) j column worth (y)
		 * change (x) in the row position (i) column (j) by (x') and the row position (i-1) column (j) by (x')
		 * if x and y have any of the following conditions*/
		for(i=matriz.length-1;i>0;i--){
			if(matriz[i][column-1].equals("1"))
				if(matriz[i-1][column-1].equals("2")){
					matriz[i][column-1]="3";
					matriz[i-1][column-1]="3";
					i=1;
				}
				else{
					if(matriz[i-1][column-1].equals("4")){
						matriz[i][column-1]="5";
						matriz[i-1][column-1]="5";
						i=1;
						}
					}
			if(matriz[i][column-1].equals("2"))
				if(matriz[i-1][column-1].equals("1")){
					matriz[i][column-1]="3";
					matriz[i-1][column-1]="3";
					i=1;
				}
				else{
					if(matriz[i-1][column-1].equals("4")){
						matriz[i][column-1]="6";
						matriz[i-1][column-1]="6";
						i=1;
						}
					}
			if(matriz[i][column-1].equals("3"))
				if(matriz[i-1][column-1].equals("5")){
					matriz[i][column-1]="1";
					matriz[i-1][column-1]="1";
					i=1;
				}
				else{
					if(matriz[i-1][column-1].equals("6")){
						matriz[i][column-1]="2";
						matriz[i-1][column-1]="2";
						i=1;
						}
					}
			if(matriz[i][column-1].equals("4"))
				if(matriz[i-1][column-1].equals("1")){
					matriz[i][column-1]="5";
					matriz[i-1][column-1]="5";
					i=1;
				}
				else{
					if(matriz[i-1][column-1].equals("2")){
						matriz[i][column-1]="6";
						matriz[i-1][column-1]="6";
						i=1;
						}
					}
			if(matriz[i][column-1].equals("5"))
				if(matriz[i-1][column-1].equals("3")){
					matriz[i][column-1]="1";
					matriz[i-1][column-1]="1";
					i=1;
				}
				else{
					if(matriz[i-1][column-1].equals("6")){
						matriz[i][column-1]="4";
						matriz[i-1][column-1]="4";
						i=1;
						}
					}
			if(matriz[i][column-1].equals("6"))
				if(matriz[i-1][column-1].equals("3")){
					matriz[i][column-1]="2";
					matriz[i-1][column-1]="2";
					i=1;
				}
				else{
					if(matriz[i-1][column-1].equals("5")){
						matriz[i][column-1]="4";
						matriz[i-1][column-1]="4";
						i=1;
						}
					}
			
		}
			
	}	
	public static void deleteRow(String [][]matriz){
		int i,j;
		int a,b;
		int counter;
		/*We are looking for color we have in column 1 an initialize the counter to 0*/
		for(i=0;i<matriz.length;i++){
			String firstColour=matriz[i][0];
			counter=0;
			/*We are looking for the rest of the colours*/
			for(j=0;j<matriz[0].length;j++){
				String restColours=matriz[i][j];
				if(firstColour.equals(restColours)){
					counter++;
				}
			}
			/*If the counter is 6,We began to copy the row up in under*/
			if(counter==matriz[0].length){
				for(a=i;a>0;a--){
					for(b=0;b<matriz[0].length;b++){
						matriz[a][b]=matriz[a-1][b];
					}
				}
			
			}

		}
	
		
		
	}
	public static boolean completeColumn(String [][]matriz){
		/*Check if a column is complete or not*/
		int j;
		boolean checkout=false;
		/*Check if in the 1st row of the matrix there is or not any color*/
		for(j=0;j<matriz[0].length;j++){
			/*If in the 1st row of the matrix is different that "-"--->there is a color and checkout=true*/
			if (matriz[0][j]!="-"){
				j=5;
				checkout=true;
			}
		}
		return checkout;
	}
	public static long colour(){
		/*generates a random number: [1-6]*/
		double number=6*Math.random()+1;
		long color=(long)number;
		return color;
	}
	public static void space(){
		/*Space between each of the boards*/
		System.out.println(" ");
		System.out.println(" ");	
	}
	public static void columnVector(String matriz[][]){

		/*this method is to represent each of the columns of the board: 1   2   3   4   5   6*/
		int i;
		for (i= 1;i<=matriz[0].length; i++) {        
			System.out.print(i + "\t"); /*"\t" is used to print a tabulation*/       
		}
			System.out.println(" ");                  
	}

}


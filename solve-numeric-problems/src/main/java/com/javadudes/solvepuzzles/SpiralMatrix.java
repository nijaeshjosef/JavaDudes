package com.javadudes.solvepuzzles;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SpiralMatrix
{ 
  int[][] inputMatrix;
  int currentLeftIndex = 0;
  int currentRightIndex = 0;
  String currentDirection = "";
  List<Integer> spiralList = new ArrayList<Integer>();
  HashSet<String> matrixElementIndices = new HashSet<String>();
 
  public SpiralMatrix(int[][] inMatrix)
  {
      this.inputMatrix = inMatrix;
     
      System.out.println("INPUT MATRIX");
      for(int i = 0; i < inMatrix.length*4; i++)
          System.out.print("#");
      for(int j=0; j < inMatrix.length; j++)
      {
          System.out.print("\n[ ");
          for(int k=0; k < inMatrix[j].length;k++)
              System.out.print(inMatrix[j][k]+" ");
         
          System.out.print("]");
      }
      System.out.println("");
  }
 
  public String turnRight()
  {
      switch(this.currentDirection)
      {
          case "north":
           this.currentDirection = "east";
           break;
         
          case "east":
           this.currentDirection = "south";
           break;
         
          case "south":
           this.currentDirection = "west";
           break;
         
          case "west":
            this.currentDirection = "north";
           break;
         
          default:
           this.currentDirection = "east";
           break;
      }
     
      return this.currentDirection;
  }
 
  public boolean deadEnd()
  {
      switch(this.currentDirection)
      {
          case "east":
                 if(this.currentRightIndex+1 >= this.inputMatrix[currentLeftIndex].length)
                     return true;
                 else
                      return false;
         
           case "south":
                 if(this.currentLeftIndex+1 >= this.inputMatrix.length)
                     return true;
                 else
                      return false;
         
          case "west":
                 if(this.currentRightIndex-1 < 0)
                     return true;
                 else
                      return false;
         
          case "north":
                 if(this.currentLeftIndex-1 < 0)
                     return true;
                 else
                      return false;
         
          default:
                 if(this.currentRightIndex+1 >= this.inputMatrix[currentLeftIndex].length)
                     return true;
                 else
                      return false;
         
      }
  }
 
  public boolean nonParsedElements()
  {
      switch(this.currentDirection)
      {
          case "east":
            System.out.println(" (Indices List) Index ["+currentLeftIndex+"]["+(currentRightIndex+1)+"] = "+String.valueOf(this.currentLeftIndex)+"~"+String.valueOf((this.currentRightIndex+1)));
            return this.matrixElementIndices.add(String.valueOf(this.currentLeftIndex)+"~"+String.valueOf((this.currentRightIndex+1)));
          case "south":
            System.out.println(" (Indices List) Index ["+(currentLeftIndex+1)+"]["+currentRightIndex+"] = "+String.valueOf(this.currentLeftIndex+1)+"~"+String.valueOf((this.currentRightIndex)));
            return this.matrixElementIndices.add(String.valueOf((this.currentLeftIndex+1))+"~"+String.valueOf(this.currentRightIndex));
          case "west":
            System.out.println(" (Indices List) Index ["+currentLeftIndex+"]["+(currentRightIndex-1)+"] = "+String.valueOf(this.currentLeftIndex)+"~"+String.valueOf((this.currentRightIndex-1)));
            return this.matrixElementIndices.add(String.valueOf((this.currentLeftIndex))+"~"+String.valueOf(this.currentRightIndex-1));
          case "north":
            System.out.println(" (Indices List) Index ["+(currentLeftIndex-1)+"]["+currentRightIndex+"] = "+String.valueOf(this.currentLeftIndex-1)+"~"+String.valueOf((this.currentRightIndex)));
            return this.matrixElementIndices.add(String.valueOf(this.currentLeftIndex-1)+"~"+String.valueOf(this.currentRightIndex));
          default:
            System.out.println(" (Indices List) Index ["+currentLeftIndex+"]["+(currentRightIndex+1)+"] = "+String.valueOf(this.currentLeftIndex)+"~"+String.valueOf((this.currentRightIndex+1)));
            return this.matrixElementIndices.add(String.valueOf(this.currentLeftIndex)+"~"+String.valueOf((this.currentRightIndex+1)));
      }
     
  }
 
  public void parseMatrix()
  {
      int count = 0;
      int iteration = 1;
      System.out.println("\n");
      this.spiralList.add(this.inputMatrix[currentLeftIndex][currentRightIndex]);
      System.out.println("(Spiral List) Index ["+currentLeftIndex+"]["+currentRightIndex+"] = "+this.inputMatrix[currentLeftIndex][currentRightIndex]);       
      this.matrixElementIndices.add(String.valueOf(this.currentLeftIndex)+"~"+String.valueOf((this.currentRightIndex)));
      System.out.println("(Indices List) Index ["+currentLeftIndex+"]["+currentRightIndex+"] = "+String.valueOf(this.currentLeftIndex)+"~"+String.valueOf((this.currentRightIndex)));
     
      do
      {
          System.out.println("\n");
          System.out.println("ROUND [ "+iteration+" ]");
          System.out.println("#########################");
          System.out.println("Count Check : [ "+count+" ]");
          System.out.println("Current Direction : [ "+this.currentDirection+" ]");
          System.out.println("Expecting a Dead End : [ "+deadEnd() +" ]");
         
          if(this.currentDirection.equalsIgnoreCase("") || deadEnd())
          {
              turnRight();
              System.out.println("TOOK A RIGHT TURN !!!");
              System.out.println("Heading : [ "+this.currentDirection+" ]");
          }
         
          boolean nonParsedElement = nonParsedElements();
           System.out.println("Expecting a new element : [ "+nonParsedElement+" ]");
          if(!nonParsedElement)
          {
              turnRight();
              System.out.println("TOOK A RIGHT TURN !!! - [EXPECTING A NEW ELEMENT]");
              System.out.println("Heading : [ "+this.currentDirection+" ]");
          }
         
          if(nonParsedElement)
          {
              count = 0;
              switch(this.currentDirection)
              {
                  case "east":
                      ++this.currentRightIndex;
                      break;
                  case "south":
                      ++this.currentLeftIndex;
                      break;
                  case "west":
                      --this.currentRightIndex;
                      break;
                  case "north":
                      --this.currentLeftIndex;
                      break;
              }
             
              this.spiralList.add(this.inputMatrix[currentLeftIndex][currentRightIndex]);
              System.out.println(" (Spiral List : Element Added ) Index ["+currentLeftIndex+"]["+currentRightIndex+"] = "+this.inputMatrix[currentLeftIndex][currentRightIndex]);
          }
          else
              ++count;
         
          ++iteration;
             
      } while(count < 3);
     
      System.out.print("\nGENERATED SPIRAL LIST [ ");
      for(int spiralElements : this.spiralList)
          System.out.print(spiralElements+" ");
      System.out.println("]");
  }
 
   public static void main(String args[])
  {
  
       int[][] inMatrix = new int[][]{
           {1, 2, 3, 4, 17, 19},
           {5, 6, 7, 8, 20, 21},
           {26, 27, 28, 29, 30, 31},
           {9, 10, 11, 12, 22, 23},
           {13, 14, 15, 16, 24, 25}
       };
     
      SpiralMatrix spiralMatrix = new SpiralMatrix(inMatrix);
      spiralMatrix.parseMatrix();
      
       
  }
}

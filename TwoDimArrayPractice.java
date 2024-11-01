/* TwoDimArrayPractice
 * Students Work with this Java file
 * On Multi-dimensional Arrays
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class TwoDimArrayPractice extends JFrame {
   // GUI components
   private JButton fillValues;
   private JButton printArray;
   private JButton setValues;
   private JButton findMinimum;
   private JButton countFrequency;

   private ButtonHandler bh;

   private static int[][] intArray;
   private final int ROWS = 4;
   private final int COLUMNS = 20;
   private static int current1 = -1;
   private static int current2 = -1;
   private int key;
   private int rowSelected = -1;
   private int columnSelected = -1;
   private BarChart bc;
   private static int counter = 0;

   private static TwoDimArrayPractice app;
   private boolean firstTime = true;

   private Image offscreen;

   public TwoDimArrayPractice() {
      super("Choose your activity");
      Container c = getContentPane();
      c.setLayout(new FlowLayout());

      fillValues = new JButton("Fill Values");
      c.add(fillValues);
      printArray = new JButton("Print Array");
      c.add(printArray);
      setValues = new JButton("Set Values");
      c.add(setValues);
      findMinimum = new JButton("Find Minimum");
      c.add(findMinimum);
      countFrequency = new JButton("Count Frequency");
      c.add(countFrequency);

      bh = new ButtonHandler();
      fillValues.addActionListener(bh);
      printArray.addActionListener(bh);
      setValues.addActionListener(bh);
      findMinimum.addActionListener(bh);
      countFrequency.addActionListener(bh);

      setSize(500, 550);

      intArray = new int[ROWS][COLUMNS];

      // Fill with random numbers between 50 and 80
      Random rand = new Random();
      for (int i = 0; i < intArray.length; i++) {
         for (int j = 0; j < intArray[0].length; j++) {
            intArray[i][j] = rand.nextInt(31) + 50;
         }
      }

      bc = new BarChart(intArray);

      // Print the array values to the console
      System.out.println("Row\tValue");
      for (int i = 0; i < intArray.length; i++) {
         System.out.print(i + "\t");
         for (int j = 0; j < intArray[i].length; j++) {
            System.out.print(intArray[i][j] + " ");
         }
         System.out.println();
      }
      System.out.println();

      setVisible(true);
      offscreen = this.createImage(getSize().width, getSize().height);
   }
   

   // 1. This method has been coded as an example
   /** Fills the array with random numbers between 50 and 80 */
   public void fillValues() {
      Random rand = new Random();
      for (int row = 0; row < intArray.length; row++) {
         System.out.print(row + "\t");
         for (int column = 0; column < intArray[row].length; column++) {
            intArray[row][column] = rand.nextInt(31) + 50;
            animate(row, column);  // Visual feedback
         }
         System.out.println();
      }
   }

   // 2. Method to print the array elements to the console, separated by a space
   public void printArray() {
      for (int row = 0; row < intArray.length; row++) {
         for (int column = 0; column < intArray[row].length; column++) {
            System.out.print(intArray[row][column] + " ");
            animate(row, column);  // For visual feedback
         }
         System.out.println();  // New line after each row
      }
   }

   // 3. Method to set all elements in a specified row to a specified value
   /** Sets all the elements in the specified row to the specified value
    * The instance variable named intArray is the integer array
    * @param value  the value to assign to the element of the row
    * @param row  the row in which to set the elements to value
    */
   public void setValues(int value, int row) {
      // Check if the row is within bounds
      if (row>=0 &&row < intArray.length) {
         // Loop through each column in the specified row
         for (int column = 0; column < intArray[row].length; column++) {
            // Set each element in the row to the specified value
            intArray[row][column] = value;
            // Call animate for visual feedback
            animate(row, column);
         }
      } else {
         System.out.println("Invalid row index: " + row);
      }
   }

   // 4. Method to find the minimum value in the specified column
   /** Finds the minimum value in the specified column
    * The instance variable named intArray is the integer array
    * @param column  the column in which to find the minimum value
    * @return the minimum value in the specified column
    */
   public int findMinimum(int column) {
	      int minValue = Integer.MAX_VALUE;
	      for (int row = 0; row < intArray.length; row++) {
	         if (column < intArray[row].length) {
	            if (intArray[row][column] < minValue) {
	               minValue = intArray[row][column];
	            }
	         }
	      }
	      return minValue;
	   }

  
   // 5. Method to count occurrences of a specified value in the array
   /** Counts the number of times a given value is found in the array
    * The instance variable named intArray is the integer array
    * @param value  the value to count in the array
    * @return the frequency of the given value in the array
    */
   public int countFound(int value) {
      int count = 0; // Initialize the count of occurrences

      // Loop through each row in the array
      for (int row = 0; row < intArray.length; row++) {
         // Loop through each column in the current row
         for (int column = 0; column < intArray[row].length; column++) {
            // Check if the current element matches the specified value
            if (intArray[row][column] == value) {
               count++; // Increment count if a match is found
            }
            // Call animate for visual feedback
            animate(row, column);
         }
      }
      
      // Return the count of occurrences of the specified value
      return count;
   }

   // Main method
   public static void main(String[] args) {
      app = new TwoDimArrayPractice();
      app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   // Animation method
   private void animate(int row, int column) {
      // Add animation implementation here
   }

 

   private class ButtonHandler implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == fillValues) {
	            fillValues();
	        } else if (e.getSource() == printArray) {
	            printArray();
	        } else if (e.getSource() == setValues) {
	            // Prompt the user for the row and value
	            try {
	                int row = Integer.parseInt(JOptionPane.showInputDialog("Enter the row to set values (0 - " + (ROWS - 1) + "):"));
	                int value = Integer.parseInt(JOptionPane.showInputDialog("Enter the value to set for all elements in row " + row + ":"));
	                setValues(value, row);
	            } catch (NumberFormatException ex) {
	                System.out.println("Invalid input.");
	            }
	        } else if (e.getSource() == findMinimum) {
	            // Prompt the user for the column
	            try {
	                int column = Integer.parseInt(JOptionPane.showInputDialog("Enter the column to find the minimum (0 - " + (COLUMNS - 1) + "):"));
	                int minValue = findMinimum(column);
	                JOptionPane.showMessageDialog(null, "Minimum value in column " + column + " is: " + minValue);
	            } catch (NumberFormatException ex) {
	                System.out.println("Invalid input.");
	            }
	        } else if (e.getSource() == countFrequency) {
	            // Prompt the user for the value to count
	            try {
	                int value = Integer.parseInt(JOptionPane.showInputDialog("Enter the value to count in the array:"));
	                int frequency = countFound(value);
	                JOptionPane.showMessageDialog(null, "Value " + value + " found " + frequency + " times in the array.");
	            } catch (NumberFormatException ex) {
	                System.out.println("Invalid input.");
	            }
	        }
	    }
	}
   private class BarChart {
	    private int[][] array;
	    private int barWidth = 20; // Width of each bar
	    private int spacing = 5; // Space between bars

	    // Constructor to initialize with the array
	    public BarChart(int[][] array) {
	        this.array = array;
	    }

	    // Method to draw the bar chart on a Graphics object
	    public void draw(Graphics g) {
	        // Set up some basic configurations
	        int chartHeight = 300; // Arbitrary height for the chart area
	        int maxValue = 80; // Assuming the maximum value in the array for scaling
	        int xOffset = 50; // Offset for x position to start drawing

	        g.setColor(Color.BLACK);
	        g.drawString("Array Bar Chart", xOffset, 20);

	        // Loop through each row and column in the array
	        for (int row = 0; row < array.length; row++) {
	            int yPosition = 40 + (row * (barWidth + spacing)); // Position for each row

	            for (int column = 0; column < array[row].length; column++) {
	                int barHeight = (int) ((double) array[row][column] / maxValue * chartHeight);

	                // Draw each bar
	                g.setColor(Color.BLUE);
	                int xPosition = xOffset + (column * (barWidth + spacing));
	                g.fillRect(xPosition, yPosition - barHeight, barWidth, barHeight);

	                // Optionally, add value labels on top of each bar
	                g.setColor(Color.BLACK);
	                g.drawString(String.valueOf(array[row][column]), xPosition, yPosition - barHeight - 5);
	            }
	        }
	    }
	}
}
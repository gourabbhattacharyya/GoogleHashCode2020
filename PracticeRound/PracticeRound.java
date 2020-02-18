package hashCode;
import java.util.*;
import java.io.*;

public class PracticeRound {
	public static void readHashCodeInputFile(String fileName)
	{
		try
		{
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
		    /*String line = bufferedReader.readLine();
		    while(line != null) {
		        System.out.println(line);
		        line = bufferedReader.readLine();
		    }*/
		    
		    String[] arr1 = bufferedReader.readLine().split(" ");
		    target = Integer.parseInt(arr1[0]);
		    int size = Integer.parseInt(arr1[1]);

		    String[] arr = bufferedReader.readLine().split(" ");
		    num = new int[size];
		    for(int i = 0; i<arr.length; i++)
		    {
		       num[i] = Integer.parseInt(arr[i]);
		    }
		    
		    
		   //close file
		   bufferedReader.close();
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeHashCodeOutputFile(String fileName, List<Integer> res)
	{
		if(res.size() != 0)
		{
			StringBuilder sb = new StringBuilder();
			for(int val : res)
				sb.append(val + " ");
			
	        try {
	            FileWriter fileWriter = new FileWriter(fileName);
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	            bufferedWriter.write(res.size()+"");
	            bufferedWriter.newLine();
	            bufferedWriter.write(sb.toString().trim());

	            //close file
	            bufferedWriter.close();
	        }
	        catch(IOException ex) {
	            System.out.println("Error writing to file '"+ fileName + "'");
	        }
		}
	}
	
	
	public static int[] num;
	public static int target;
	public static int prevSum;
	public static List<Integer> res;
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		String filePath = "C:\\Users\\gbhattacharyya\\Downloads\\";
		String[] inputFileNames = {"a_example.in", "b_small.in", "c_medium.in", "d_quite_big.in", "e_also_big.in"};
		String[] outputFileNames = {"a_example_output.out", "b_small_output.out", "c_medium_output.out", "d_quite_big_output.out", "e_also_big_output.out"};
		
		for(int i = 0;i<inputFileNames.length; i++)
		{
			prevSum = 0;
			res = new ArrayList<>();
			
			//read the content from file
			String fileName = filePath + inputFileNames[i];
			readHashCodeInputFile(fileName);
			
			//call the function with logic
		    getSequence(num, target);
		    
		    //read the content from file
		    fileName = filePath + outputFileNames[i];
		    writeHashCodeOutputFile(fileName, res);
		}
	}


	public static void getSequence(int[] num, int target)
	{
		if(num == null || num.length == 0)
			return;
		
	   List<Integer> list = null;
	   for(int i = num.length - 1; i>=0; i--)
	   {
	       int sum = num[i];
	       list = new ArrayList<>();
	       list.add(i);
	       
	       for(int j = i-1; j>=0; j--)
	       {
	           sum += num[j];
	
	           if(sum <= target)
	           {
	               list.add(j);
	               
	               if(sum > prevSum)
	               {
	                   prevSum = sum;
	                   res = list;
	               }
	           }
	           else
	               sum -= num[j];
	       }
	   }
	   
	   Collections.reverse(res);
	   
	   System.out.println("SUM : "+ prevSum);
	   System.out.println("M : "+ res.size());
	   System.out.println(res);
	   
	   System.out.println();
	   System.out.println();
	}
}

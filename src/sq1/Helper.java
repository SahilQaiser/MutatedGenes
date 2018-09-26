package sq1;

import java.io.*;

public class Helper {
    static int getNumberOfLines(String f)                               //To get Number of Rows for out Matrix
    {
        int lines=0;
        try
            {
               FileReader       input = new FileReader(f);
               LineNumberReader count = new LineNumberReader(input);
               while (count.skip(Long.MAX_VALUE) > 0)
               {
                  // Loop just in case the file is > Long.MAX_VALUE or skip() decides to not read the entire file
               }
               lines = count.getLineNumber();
            } catch(IOException e)
            {
                System.out.println(e);
            }
        
        return lines;
    }
    //Get Row Mean
    static Double[] getRowMean(Double m[][])
    {
        Double mean[]=new Double[m.length-1];
        int j=0;
        for(int i=0; i<m.length-1; i++)
        {
            mean[i]=0.0;
            for(Double cell : m[i]){
                mean[i]=mean[i]+cell;
            }
        }
        return mean;
    }
    //Get A 2d matrix for a File
    static Double[][] getMatrix(String f1) throws IOException
    {
        int i,j=0;
        FileReader fr=new FileReader(f1);
        BufferedReader br = new BufferedReader(fr);
        String line,row[];
        String head=br.readLine();
        row=head.split(",");                                                //To Get Number of Columns
        Double matrix[][]=new Double[getNumberOfLines(f1)-1][row.length-1];
        while((line=br.readLine())!=null){
            row=line.split(",");
            i=1;
            while(i<row.length)
            {
                matrix[j][i-1]=Double.parseDouble(row[i]);
                i++;
            }
            j++;
        }
        return matrix;
    }
    //functions to Print Matrices
    static void printMatrix(Double m[][])           //Print a 2d matrix
    {
        int i;
        for(i=0; i<m.length; i++)
        {
            for(Double j:m[i])
            {
                System.out.print(j+"  ");
            }
            System.out.println();
        }
    }
    static void printMatrix(Double m[])             //Print a 1d matrix
    {
        for(Double j:m)
            {
                System.out.println(j+"  ");
            }
    }
    static void printMatrix(Double m[], Double n[]) //Print 2 1d Matrices as 2 Columns
    {
        for(int i=0; i<m.length; i++)
            {
                System.out.println(m[i]+"\t\t\t"+n[i]);
            }
    }
    static void printMatrixFiltered(Double m[], Double filter) //Print 2 1d Matrices as 2 Columns
    {
        for(int i=0; i<m.length; i++)
            {
                if(m[i]>=filter){
                    System.out.println("Gene "+(i+1)+", FoldChange Value : "+m[i]);
                }
            }
    }
    //Returning Max and Min out of 2
    static Double max(Double a, Double b)
    {
        Double x=(a>b)?(a):(b);
        return x;
    }
    static Double min(Double a, Double b)
    {
        Double x=(a>b)?(b):(a);
        return x;
    }
}

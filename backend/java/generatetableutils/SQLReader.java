package generatetableutils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class SQLReader {
	private String filename;
	private final static char INVERTEDCOMMAS = 34;

	public SQLReader(String afilename){
		this.filename = afilename;
	}

	private String removeFileExtension(){
		String file = filename;
		int indexOfDel = file.indexOf(".");
		return file.substring(0, indexOfDel);
	}
	
	private BufferedReader openInputFile() throws IOException{
		FileReader infile = new FileReader(filename);
		return new BufferedReader(infile); 
	}
	
	private PrintWriter  openOutputFile() throws IOException{
		FileWriter  outputfile  = new FileWriter(removeFileExtension()+ "Output" +".txt");
		return new PrintWriter(outputfile);
 	}
	
	
	public void readInputFile() throws IOException{
		BufferedReader reader = null;
		PrintWriter writer = null;
		try{	
			 reader = openInputFile();
			 writer = openOutputFile();
			 String  line;
			
			    while((line = reader.readLine()) !=null){	
					if(line.trim().equals("")){ continue;}
					line = INVERTEDCOMMAS + " " + line + " " + INVERTEDCOMMAS + "+"; //add space to left and right
					writer.println(line);
 			    }
		
			}finally{
				if(reader != null)reader.close();
				if(writer != null)writer.close();
				//System.out.println("Input file not found...");
			}
		
	}
	

	
	public static void main(String args[]){
		try{
			//String filename =  args[0];
			SQLReader sql = new SQLReader("D:\\sql.sql");
			sql.readInputFile();
			System.out.println(sql.removeFileExtension());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Input file not found...");
		}
		
	
	}
	
}



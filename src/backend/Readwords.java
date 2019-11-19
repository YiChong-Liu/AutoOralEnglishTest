package backend;

import java.io.*;
import java.util.Random;
public class Readwords {
	Random rd=new Random();
	public String readFile(String filePath,int Maxlength,int times) {
		File f=new File(filePath);
		String line="";
		int temp=0;
		
		while(times-->0) {
			try(
					FileReader fr=new FileReader(f);
					BufferedReader br=new BufferedReader(fr);
					)
			{
					int num=rd.nextInt(Maxlength),sub=0;
					while(num==temp||num==0) {
						num=rd.nextInt(Maxlength);
					}
					temp=num;
					String Eachline="0";
					while(Eachline!=null) {
						sub++;
						Eachline=br.readLine();
						if(sub==num)
						{
							line=line+Eachline;
							line=line+"\n";
						}
					}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return line;
	}
	
	public String concludeContent() {
		File f1=new File("");
		String words=f1.getAbsolutePath()+"\\data\\´Ê×é.txt";
		String sentences=f1.getAbsolutePath()+"\\data\\·­Òë.txt";
		
		String all="";
		all=readFile(words,60,4)+readFile(sentences,28,2);
		return all;
	}
}

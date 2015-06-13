import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Ascadac {
	public static boolean filefound=true;
public static String parse(String cascada){
	String casdaca;
	try {
		casdaca = new Scanner(new File(cascada)).useDelimiter("\\Z").next();
	} catch (FileNotFoundException Cascada) {
		filefound=false;
		return null;
	}	
	casdaca=casdaca.replaceAll("&#039;", "'");//for some reason apostrophes show up as &#039 in FB's HTML
	casdaca=casdaca.replaceAll("&quot;", "\"");//fix the quotes
	return casdaca;
}		
private static message[] Casdaca(String[] Casdaca){
	message[] Messages=new message[Casdaca.length];
	String[] animalcracker;//I just ate an animal cracker...
	for (int i=0;i<Messages.length;i++){
		Messages[i]=new message();
		Messages[i].sender=(Casdaca[i].split("</span>"))[0];
		Messages[i].content=(Casdaca[i].split("</span>"))[2].replaceAll("</div></div><p>", "");
		animalcracker=(((Casdaca[i].split("</span>"))[1].replaceAll("<span class=\"meta\">", "")).split(" "));
		Messages[i].month=animalcracker[1];
		Messages[i].day=Integer.parseInt((animalcracker[2]).split(",")[0]);
		Messages[i].year=Integer.parseInt(animalcracker[3]);
		Messages[i].time=animalcracker[5];
	}return Messages;}   //evil face ;}
private static String[] Cascada(String cascada){
	String[] Cascada=cascada.split("<div class=\"message\">");
	for (int casdaca=0;casdaca<Cascada.length;casdaca++){
		Cascada[casdaca]=Cascada[casdaca].replaceAll("<div class=\"message_header\"><span class=\"user\">", "");
		Cascada[casdaca]=(Cascada[casdaca].split("</p>")[0]);}
	String[] Casdaca=new String[(Cascada.length-1)];
	for (int cascada_cascada=0; cascada_cascada<Casdaca.length;cascada_cascada++){
		Casdaca[cascada_cascada]=Cascada[(cascada_cascada+1)];//that was satisfying
	}return Casdaca;}	
public static message[] search(message[] all, int day, String month, int year, String sender, String content){
	message[] temp;
	message[] results;
	int hits=0;
	int load=0;
	if(!(day==0)){
		for (int i=0;i<all.length;i++){
			if (all[i].day==day){
				hits=hits+1;
			}
		}
		temp=new message[hits];
		for (int j=0;j<all.length;j++){
			if(all[j].day==day){
				temp[load]=all[j];
				load++;
			}
		}
		hits=0;
		load=0;
		results=temp;
	}else{
		results=all;
	}
	if(!(month.equals(""))){
		for (int i=0;i<results.length;i++){
			if (results[i].month.equals(month)){
				hits=hits+1;
			}
		}
		temp=new message[hits];
		for (int j=0;j<results.length;j++){
			if(results[j].month.equals(month)){
				temp[load]=results[j];
				load++;
			}
		}
		hits=0;
		load=0;
		results=temp;
	}
	if(!(year==0)){
		for (int i=0;i<results.length;i++){
			if (results[i].year==year){
				hits=hits+1;
			}
		}
		temp=new message[hits];
		for (int j=0;j<results.length;j++){
			if(results[j].year==year){
				temp[load]=results[j];
				load++;
			}
		}
		hits=0;
		load=0;
		results=temp;
	}	
	if(!(sender.equals(""))){
		for (int i=0;i<results.length;i++){
			if (results[i].sender.equals(sender)){
				hits=hits+1;
			}
		}
		temp=new message[hits];
		for (int j=0;j<results.length;j++){
			if(results[j].sender.equals(sender)){
				temp[load]=results[j];
				load++;
			}
		}
		hits=0;
		load=0;
		results=temp;
	}
	if(!(content.equals(""))){
		for (int i=0;i<results.length;i++){
			if (results[i].content.contains(content)){
				hits=hits+1;
			}
		}
		temp=new message[hits];
		for (int j=0;j<results.length;j++){
			if(results[j].content.contains(content)){
				temp[load]=results[j];
				load++;
			}
		}
		hits=0;
		load=0;
		results=temp;
	}
	return results;
}
public static void main(String[] args){
	Scanner scanthis=new Scanner(System.in);
	String input=scanthis.nextLine();
	message[] meh=go(parse(input));
	int day=0;
	String month="April";
	int year=2015;
	String sender="Fini Bichara";
	String content="";
	meh=search(meh, day, month, year, sender, content);
	for (int J=0;J<meh.length;J++){
		System.out.println(meh[J].sender);
		System.out.println(meh[J].content);
		System.out.println(meh[J].month+" "+meh[J].day+" "+meh[J].year);
		System.out.println("###HASHTAG###");
	}
	scanthis.close();
}
public static message[] go(String a){
	message[] all=Casdaca(Cascada(a));
	return all;
}
Ascadac(){
	//dont really need to do anything in the constructor...
}
}

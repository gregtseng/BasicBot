/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author GregTseng
 */
public class Backend {
	private static String ascadac(String cascada){
		String casdaca;
		try {
			casdaca = new Scanner(new File(cascada)).useDelimiter("\\Z").next();
		} catch (FileNotFoundException Cascada) {
			return "";
		}	
		casdaca=casdaca.replaceAll("&#039;", "'");//for some reason apostrophes show up as &#039 in FB's HTML
		casdaca=casdaca.replaceAll("&quot;", "\"");//fix the quotes
		return casdaca;
	}		//I obfuscated the following to avoid having to explain it ;)
private static String juliana(String all){
	String[]jthreads;
	int jconvos=0;
	int load=0;
	String Julianas="";
	String[]threads=all.split("<div class=\"thread\">");
	for(int d=0;d<threads.length;d++){
		if(threads[d].contains("Greg Zeng, Juliana Icke")){
			jconvos=jconvos+1;
		}
	}
	jthreads=new String[jconvos];
	for (int d=0;d<threads.length;d++){
		if(threads[d].contains("Greg Zeng, Juliana Icke")&&!threads[d].contains("Helen Zhao")){
			jthreads[load]=threads[d];
			load=load+1;
		}
	}
	for (int d=0;d<jthreads.length;d++){
	jthreads[d]=jthreads[d].replaceAll("Greg Zeng, Juliana Icke","");
	}
	for (int d=0;d<jthreads.length;d++){
		Julianas=Julianas+jthreads[d];
	}
	return Julianas;
}
public static void main(String[] args){
	Scanner scan=new Scanner(System.in);
	message[] jchats=Ascadac.go(juliana(ascadac(scan.nextLine())));
	//for(int d=0;d<jchats.length;d++){
	//	jchats[d].print();
	//}
	message[] sent=sen(jchats);
	String chat="";
	double max;
	message gnah=new message();
	message[] topten=new message[10];
	int rando;
	int rad;
	int hits=0;
	int load=0;
	message[] janswers;
	System.out.println("Chat:");
	for(int z=0;z<20;z++){
		System.out.println(chat(jchats, "hi"));
	}
	while(true){
		load=0;
		hits=0;
		sent=sen(jchats);
		chat=scan.nextLine();
		max=wordmatch(chat, sent[0].content);
		gnah=sent[0];
		for(int e=0;e<sent.length;e++){
			sent[e].perc=wordmatch(chat, sent[e].content);
		}
		for(int i=0;i<10;i++){
			for(int k=0;k<sent.length;k++){
				if(max<sent[k].perc){
					gnah=sent[k];
					max=sent[k].perc;
					sent[k].perc=-1000000000;
				}
			}
			topten[i]=gnah;
			max=0;	
		}
		for(int h=0;h<topten.length;h++){
		//System.out.println("you said "+topten[h].content);
		}
		rando=(int)(Math.random()*10);
		gnah=topten[rando];
		for(int d=0;d<jchats.length;d++){
			if(gnah.content.equals(jchats[d].content)){
				hits=hits+1;
			}
		}
		//System.out.println("total+ "+hits);
		janswers=new message[hits];
		for(int d=0;d<jchats.length;d++){
			if(jchats[d].content.equals(gnah.content)&&!jchats[d-1].content.equals(null)){
				for(int x=1;x<10;x++){
					if(jchats[d-x].sender.equals("Juliana Icke")){
					janswers[load]=jchats[d-x];
					load=load+1;
					break;
					}
				}
				//System.out.println(janswers[0].content);
			}
		}
		//System.out.println("load"+load);
		for(int d=0;d<janswers.length;d++){
			//System.out.println("Juliana may say "+janswers[d].content);
		}
		rad=(int)(Math.random()*hits);
		System.out.println("BasicBot: "+janswers[rad].content);
	}
	//System.out.println(jchats.length);
	//scan.close();
}
public static double wordmatch(String a, String b){
	int matches=0;
	double percentage;
	String[] awords=a.split(" ");
	for(int c=0;c<awords.length;c++){
		if(b.contains(awords[c])){
			matches=matches+1;
		}
	}
	percentage=10*matches/((b.split(" ")).length);
	if (matches<3){
		int nox=match(a,b);
		percentage=(0-nox);
	}
	return percentage;
}
public static int match(String s, String t) {
    if (s == null || t == null) {
        throw new IllegalArgumentException("Strings must not be null");
    }

    //getLevenshteinDistance
    int n = s.length(); // length of s
    int m = t.length(); // length of t

    if (n == 0) {
        return m;
    } else if (m == 0) {
        return n;
    }

    if (n > m) {
        // swap the input strings to consume less memory
        String tmp = s;
        s = t;
        t = tmp;
        n = m;
        m = t.length();
    }

    int p[] = new int[n+1]; //'previous' cost array, horizontally
    int d[] = new int[n+1]; // cost array, horizontally
    int _d[]; //placeholder to assist in swapping p and d

    // indexes into strings s and t
    int i; // iterates through s
    int j; // iterates through t

    char t_j; // jth character of t

    int cost; // cost

    for (i = 0; i<=n; i++) {
        p[i] = i;
    }

    for (j = 1; j<=m; j++) {
        t_j = t.charAt(j-1);
        d[0] = j;

        for (i=1; i<=n; i++) {
            cost = s.charAt(i-1)==t_j ? 0 : 1;
            // minimum of cell to the left+1, to the top+1, diagonally left and up +cost
            d[i] = Math.min(Math.min(d[i-1]+1, p[i]+1),  p[i-1]+cost);
        }

        // copy current distance counts to 'previous row' distance counts
        _d = p;
        p = d;
        d = _d;
    }

    return p[n];
}
private static message[] sen(message[] all){
	int hits=0;
	int load=0;
	message[] PUREJULIANA;
	for(int d=0;d<all.length;d++){
		if(all[d].sender.equals("Greg Tseng")||all[d].sender.equals("Greg Zeng")){
			hits=hits+1;
		}
	}
	PUREJULIANA=new message[hits];
	for(int d=0;d<all.length;d++){
		if(all[d].sender.equals("Greg Tseng")||all[d].sender.equals("Greg Zeng")){
			PUREJULIANA[load]=all[d];
			load=load+1;
		}
	}
	return PUREJULIANA;
}
public static String chat(message[] jchats, String chat){
	int load=0;
	int hits=0;
	message[] sent=sen(jchats);
	double max=wordmatch(chat, sent[0].content);
	message gnah=sent[0];
	for(int e=0;e<sent.length;e++){
		sent[e].perc=wordmatch(chat, sent[e].content);
	}
	message[] topten=new message[10];
	for(int i=0;i<10;i++){
		for(int k=0;k<sent.length;k++){
			if(max<sent[k].perc){
				gnah=sent[k];
				max=sent[k].perc;
				sent[k].perc=-1000000000;
			}
		}
		topten[i]=gnah;
		max=0;	
	}
	for(int h=0;h<topten.length;h++){
	//System.out.println("you said "+topten[h].content);
	}
	int rando=(int)(Math.random()*10);
	gnah=topten[rando];
	for(int d=0;d<jchats.length;d++){
		if(gnah.content.equals(jchats[d].content)){
			hits=hits+1;
		}
	}
	//System.out.println("total+ "+hits);
	message[] janswers=new message[hits];
	for(int d=0;d<jchats.length;d++){
		if(jchats[d].content.equals(gnah.content)&&!jchats[d-1].content.equals(null)){
			for(int x=1;x<10;x++){
				if(jchats[d-x].sender.equals("Juliana Icke")){
				janswers[load]=jchats[d-x];
				load=load+1;
				break;
				}
			}
			//System.out.println(janswers[0].content);
		}
	}
	//System.out.println("load"+load);
	for(int d=0;d<janswers.length;d++){
		//System.out.println("Juliana may say "+janswers[d].content);
	}
	int rad=(int)(Math.random()*hits);
	return("BasicBot: "+janswers[rad].content);
}
public static message[] zengo(String file){
    	message[] jchats=Ascadac.go(juliana(ascadac(file)));
        return jchats;

}
public static String clean(message[] jchats, String chat){
int load=0;
int hits=0;
chat=chat+" ;)";
message[] sent=sen(jchats);
double max=wordmatch(chat, sent[0].content);
message gnah=sent[0];
for(int e=0;e<sent.length;e++){
	sent[e].perc=wordmatch(chat, sent[e].content);
}
message[] topten=new message[10];
for(int i=0;i<10;i++){
	for(int k=0;k<sent.length;k++){
		if(max<sent[k].perc){
			gnah=sent[k];
			max=sent[k].perc;
			sent[k].perc=-1000000000;
		}
	}
	topten[i]=gnah;
	max=0;	
}
for(int h=0;h<topten.length;h++){
//System.out.println("you said "+topten[h].content);
}
int rando=(int)(Math.random()*10);
gnah=topten[rando];
for(int d=0;d<jchats.length;d++){
	if(gnah.content.equals(jchats[d].content)){
		hits=hits+1;
	}
}
//System.out.println("total+ "+hits);
message[] janswers=new message[hits];
for(int d=0;d<jchats.length;d++){
	if(jchats[d].content.equals(gnah.content)&&!jchats[d-1].content.equals(null)){
		for(int x=1;x<10;x++){
			if(jchats[d-x].sender.equals("Juliana Icke")){
			janswers[load]=jchats[d-x];
			load=load+1;
			break;
			}
		}
		//System.out.println(janswers[0].content);
	}
}
load=0;
hits=0;
for(int d=0;d<janswers.length;d++){
	if(!janswers[d].content.contains("dick")||!janswers[d].content.contains("boob")||!janswers[d].content.contains("vag")||!janswers[d].content.contains("naked")||!janswers[d].content.contains("sex")
	||!janswers[d].content.contains("fuck")||!janswers[d].content.contains("shit")||!janswers[d].content.contains("ass")||!janswers[d].content.contains("boobs")){
		hits=hits+1;
	}
}
message[] clean=new message[hits];
for(int d=0;d<janswers.length;d++){
	if(!janswers[d].content.contains("dick")||!janswers[d].content.contains("boob")||!janswers[d].content.contains("vag")||!janswers[d].content.contains("naked")||!janswers[d].content.contains("sex")
	||!janswers[d].content.contains("fuck")||!janswers[d].content.contains("shit")||!janswers[d].content.contains("ass")||!janswers[d].content.contains("boobs")){
		clean[load]=janswers[d];
                load=load+1;
	}
}
int rad=(int)(Math.random()*clean.length);
if(!(clean[rad].content==null)){
return("BasicBot: "+clean[rad].content);
}else{
return("BasicBot: OMG I can't even right now");
}
}
public static String slutty(message[] jchats, String chat){
	int load=0;
	int hits=0;
	chat=chat+" ;)";
	message[] sent=sen(jchats);
	double max=wordmatch(chat, sent[0].content);
	message gnah=sent[0];
	for(int e=0;e<sent.length;e++){
		sent[e].perc=wordmatch(chat, sent[e].content);
	}
	message[] topten=new message[10];
	for(int i=0;i<10;i++){
		for(int k=0;k<sent.length;k++){
			if(max<sent[k].perc){
				gnah=sent[k];
				max=sent[k].perc;
				sent[k].perc=-1000000000;
			}
		}
		topten[i]=gnah;
		max=0;	
	}
	for(int h=0;h<topten.length;h++){
	//System.out.println("you said "+topten[h].content);
	}
	int rando=(int)(Math.random()*10);
	gnah=topten[rando];
	for(int d=0;d<jchats.length;d++){
		if(gnah.content.equals(jchats[d].content)){
			hits=hits+1;
		}
	}
	//System.out.println("total+ "+hits);
	message[] janswers=new message[hits];
	for(int d=0;d<jchats.length;d++){
		if(jchats[d].content.equals(gnah.content)&&!jchats[d-1].content.equals(null)){
			for(int x=1;x<10;x++){
				if(jchats[d-x].sender.equals("Juliana Icke")){
				janswers[load]=jchats[d-x];
				load=load+1;
				break;
				}
			}
			//System.out.println(janswers[0].content);
		}
	}
	//System.out.println("load"+load);
	for(int d=0;d<janswers.length;d++){
		//System.out.println("Juliana may say "+janswers[d].content);
	}
	int rad=(int)(Math.random()*hits);
	return("BasicBot: "+janswers[rad].content);
}
}

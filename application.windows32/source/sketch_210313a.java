import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sketch_210313a extends PApplet {

 int highlight = 0;
int screen = 0;
int loader = 0;
int bg = 0;
int slider = 50;

public void setup() {
  
  background(0xffd4ebf2);
}

public void draw() {
  if (screen == 0) {
    homeScreen(); 
    
    if ((mouseX>100 && mouseX<700) && (mouseY>150 && mouseY<310)) {
      if (mousePressed) {
        screen = 1;
      }
      highlight = 1;
    } else if ((mouseX>100 && mouseX<700) && (mouseY>310 && mouseY<470)) {
      highlight = 2;
      if (mousePressed) {
        System.exit(0);
      }
    } else {
      highlight = 0;
    }
    
  } else if (screen == 1) {
    database();
  } else if (screen == 2) {
    logs();
    
      for (int i = 0; i < 7; i++) {
        if ((mouseX> 560 && mouseX< 670) &&(mouseY>150 + (50*i) && mouseY< 175+(50*i))) {
          if (mousePressed) {
            screen = 3;
          }
        }
      }
  } else if (screen == 3) {
    results();
    if ((mouseX>78 && mouseX<122) && (mouseY>10 && mouseY<27)) { 
       if (mousePressed) {
        highlight = 0;
        slider = 0;
        screen = 0;
        homeScreen();
        }
    }
  }

}

public void homeScreen() {
  fill(0xffd4ebf2);
  rect (0, 0, 800, 500);
  fill (255);
  String[] words = { "Database", "Exit"};
  textSize(75);
  text("Ecoifier Database", 90, 100);
  
  if (highlight == 0) {
    for (int i = 0; i < 2; i++) {
      noStroke();
      fill(200, 200, 225);
      rect(100, 150 + (i*160), 600, 100, 120);
    }
    textSize(50);
    fill(0);
    text(words[0], 300, 215);
    text(words[1], 360, 375);
  } else if (highlight == 1) {
    fill (200, 200, 255);
    rect(80, 145, 640, 130, 120);
    fill(200, 200, 225);
    rect(100, 310, 600, 100, 120);
    
    textSize(70);
    fill(0);
    text(words[0], 240, 230);
    textSize(50);
    text(words[1], 360, 375);
  } else if (highlight == 2){
    fill (200, 200, 255);
    rect(80, 305, 640, 130, 120);
    fill(200, 200, 225);
    rect(100, 160, 600, 100, 120);


    textSize(50);    
    fill(0);
    text(words[0], 300, 215);
    textSize(70);
    text(words[1], 340, 390);
  }  

}

public void database() {
  loader+=3;
  fill (0xffF5F5DC);
  strokeWeight(0);
  rect(0, 0, 800, 500);
  
  fill(200);
  textSize(50);
  text("Loading...", 300, 180);
  
  stroke (0);
  strokeWeight(5);
  fill (255);
  rect (100, 230, 600, 50);
  
  strokeWeight(0);
  fill (0xffcbffcb);
  rect (103, 233, 151+loader, 45);

  if (loader > 400) {
    screen = 2;
  }
}

public void logs() {
  fill (255);
  bg = 0;
  loader = 0;
  
  String[][] labels = {{"DD5O2A1", "DD5O2A2", "DD5O2A3", "DD5O2A4", "DD5O2A5", "DD5O2A6", "DD5O2A7"},
                       {"2 weeks", "1 month", "4 days", "15 weeks", "3 weeks", "1 day", "6 months"},
                       {"Functional", "Requires work", "Functional", "Functional", "Functional", "Requires work", "Functional"},
                       {"View here", "View here", "View here", "View here", "View here", "View here", "View here", }};
  
  for (int i = 0; i < 501; i++) {
    if (i % 5 == 0) {
      bg++;
    }
    stroke (50,bg,100); 
    line (0, i, 800, i);
  }
  
  stroke (255);
  strokeWeight(5);
  strokeCap(SQUARE);
  
  line(25, 25, 25, 475);
  line(185, 25, 185, 475);
  line(350, 25, 350, 475);
  line(555, 25, 555, 475);
  line(775, 25, 775, 475);
  
  line (23, 25, 777, 25);
  line(23, 125, 777, 125); 
  for (int i = 175; i < 500; i+=50) {
    line (23, i, 777, i);
  }
  
  textSize(30);
  text("Serial #", 35, 115);
  text("Filter Time", 189, 115);
  text("Functionality", 354, 115);
  textSize(26);
  text("View", 640, 90);
  text("Chromatography", 559, 115);
  
  textSize(20);
  for (int i = 0; i<7; i++) {
    text(labels[0][i], 35, 160 + (50*i));
  }
  
   for (int i = 0; i<7; i++) {
    text(labels[1][i], 193, 160 + (50*i));
  }
  
   for (int i = 0; i<7; i++) {
    text(labels[2][i], 358, 160 + (50*i));
  }
  
  fill (0xff48B2EE);
  stroke(0xff48B2EE);
  strokeWeight(0);
  for (int i = 0; i<7; i++) {
    text(labels[3][i], 564, 160 + (50*i));
    line(562, 162 + (50*i), 660, 162 + (50*i));
  }
  
}

public void results() {
  slider-=3;
  noStroke();
  fill (0xff778899);
  ellipse(400, 500+slider, 150, 150);
  fill(0);
  ellipse(400, 500+slider, 100, 100);
  rect(0, 500+slider, 800, 500);

  
  strokeWeight(6);
  fill(0xff6495ED);
  rect (380, 500+slider, 40, 500);
  fill(0xffFDD023);
  rect(395, 500+slider, 10, 500);
  if (slider < -525) {
    fill(0xffB22222);
    arc(200, 250, 150, 150, radians(0), radians(280));
    rect(25, 350, 50, 30);
    fill (0xffbfff00);
    arc(200, 250, 150, 150, radians(280), radians(352));
    rect(25, 400, 50, 30);
    fill (0xffFFC0CB);
    arc(200, 250, 150, 150, radians(352), radians(360));
    rect(25, 450, 50, 30);
    
    fill(255);
    textSize(18);
    text("78% Nitrogen", 80, 370);
    text("22% Oxygen", 80, 420);
    text("0.04% Carbon Dioxide", 80, 470);
    
    textSize(25);
    text("Desirable chromatography", 25, 75);
    
    text("Sample's chromatography", 445, 75);
    fill(0xffB22222);
    arc(600, 250, 150, 150, radians(0), radians(250));
    rect(455, 350, 50, 30);
    fill (0xffbfff00);
    arc(600, 250, 150, 150, radians(250), radians(355));
    rect(455, 400, 50, 30);
    fill (0xffFFC0CB);
    arc(600, 250, 150, 150, radians(355), radians(360));
    rect(455, 450, 50, 30);
    
    fill(255);
    textSize(18);
    text("69% Nitrogen", 510, 370);
    text("29% Oxygen", 510, 420);
    text("2% Carbon Dioxide", 510, 470);
    text("Press HERE to go back to the main menu", 25,25);
   
  } 
}
  public void settings() {  size (800, 500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sketch_210313a" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

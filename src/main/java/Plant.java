import java.util.HashMap;

public class Plant {
	
    String scientificName, commonName;
    int lepsSupported;
    int cost;
    double x, y;
    double imgHeight, imgWidth;
    HashMap<String, String[]> Conditions;
    

    Plant(String n, String s, double a, double b, int w, int d) {
        scientificName = s; 
        commonName = n;
        x = a;
        y = b;
        imgHeight = w;
        imgWidth = d;
    }
}

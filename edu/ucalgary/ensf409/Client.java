package edu.ucalgary.ensf409;

public class Client {
    private final int CLIENTID;
    private final String CLIENTTYPE;
    private final int WHOLEGRAINS;
    private final int PROTEIN;
    private final int FRUITVEGGIES;
    private final int CALORIES;
    private final int OTHER;

    public Client(int clientID, String clientType, int wholeGrains, int protein, int fruitVeggies, int calories, int other) {
        this.CLIENTID = clientID;
        this.CLIENTTYPE = clientType;
        this.WHOLEGRAINS = wholeGrains;
        this.PROTEIN = protein;
        this.FRUITVEGGIES = fruitVeggies;
        this.CALORIES = calories;
        this.OTHER = other;
    }

    public int getCALORIES() {
        return CALORIES;
    }

    public int getWHOLEGRAINS() {
        return WHOLEGRAINS;
    }

    public int getPROTEIN() {
        return PROTEIN;
    }

    public int getFRUITVEGGIES() {
        return FRUITVEGGIES;
    }

    public int getOTHER() {
        return OTHER;
    }

    public String getCLIENTTYPE() {
        return CLIENTTYPE;
    }
}

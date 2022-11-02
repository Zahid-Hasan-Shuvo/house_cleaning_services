import java.util.Scanner;

public class Cleanly {
  Scanner scanner = new Scanner(System.in);

  static String[] types = {"Basic", "Standard", "Premium"};
  static int[] typesWithBasePrice = {500, 1000, 1250};

  static String[] frequencies = {"One Time", "Weekly", "Bi-Weekly", "Monthly"};
  static float[] frequenciesWithDiscount = {0, 0.20f, 0.15f, 0.10f};

  static int[] attachedBathroomsOfEachType = {1, 1, 1};
  static int[] attachedBedroomsOfEachType = {1, 1, 2};

  static int[] perExtraBathroomPriceOfEachType = {300, 500, 600};
  static int[] perExtraBedroomPriceOfEachType = {500, 800, 1000};

  private int typeIdx;
  private int frequencyIdx;
  private int bathroomsCnt;
  private int bedroomsCnt;

  public Cleanly() {
    askForTypeIdx();
    scanner.close();
  }

  public void setTypeIdx(int typeIdx) {
    this.typeIdx = typeIdx;
  }

  public int getTypeIdx() {
    return typeIdx;
  }

  public void setFrequencyIdx(int frequencyIdx) {
    this.frequencyIdx = frequencyIdx;
  }

  public int getFrequencyIdx() {
    return frequencyIdx;
  }

  public void setBathroomsCnt(int bathroomsCnt) {
    this.bathroomsCnt = bathroomsCnt;
  }

  public int getBathroomsCnt() {
    return bathroomsCnt;
  }

  public void setBedroomsCnt(int bedroomsCnt) {
    this.bedroomsCnt = bedroomsCnt;
  }

  public int getBedroomsCnt() {
    return bedroomsCnt;
  }  

  private void askForTypeIdx() {
    System.out.print("What type of cleaning you want? [ ");
    for(int i = 0; i < types.length; i++) {
      System.out.print(i + 1 + ". " + types[i] + " ");
    }
    System.out.print("] >> ");

    int typeIdx = scanner.nextInt();
    setTypeIdx(typeIdx - 1);
    askForFrequencyIdx();
  }

  private void askForFrequencyIdx() {
    System.out.print("In what frequency you will use our service? [ ");
    for(int i = 0; i < frequencies.length; i++) {
      System.out.print(i + 1 + ". " + frequencies[i] + " ");
    }
    System.out.print("] >> ");

    int frequencyIdx = scanner.nextInt();
    setFrequencyIdx(frequencyIdx - 1);
    askForBathroomsCnt();
  }

  private void askForBathroomsCnt() {
    System.out.print("How many bathrooms you have? >> ");

    int bathroomsCnt = scanner.nextInt();
    setBathroomsCnt(bathroomsCnt);
    askForBedroomsCnt();
  }

  private void askForBedroomsCnt() {
    System.out.print("How many bedrooms you have? >> ");

    int bedroomsCnt = scanner.nextInt();
    setBedroomsCnt(bedroomsCnt);
  }

  private float getBillForType() {
    float billForType = typesWithBasePrice[typeIdx];
    return billForType;
  }

  private float getBillForExtraBathrooms() {
    float billForExtraBathrooms = (bathroomsCnt - attachedBathroomsOfEachType[typeIdx]) * perExtraBathroomPriceOfEachType[typeIdx]; 
    return billForExtraBathrooms;
  }

  private float getBillForExtraBedrooms() {
    float billForExtraBedrooms = (bedroomsCnt - attachedBedroomsOfEachType[typeIdx]) * perExtraBedroomPriceOfEachType[typeIdx]; 
    return billForExtraBedrooms;
  }

  private float getTotalBill() {
    float totalBill = getBillForType() + getBillForExtraBathrooms() + getBillForExtraBedrooms();
    return totalBill; 
  }

  public float getTotalBillAfterDiscount() {
    float totalBill = getTotalBill();
    float totalBillAfterDiscount = totalBill - (totalBill * frequenciesWithDiscount[frequencyIdx]);
    return totalBillAfterDiscount;
  }
}

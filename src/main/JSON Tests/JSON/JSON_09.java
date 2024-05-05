package JSON;

public class JSON_09 {
    public static void main(String[] args) {
        int fighterIndex = GSONCreator.getIndex("Name", "Fighter3", 1);
        int tournamentIndex = GSONCreator.getIndex("UserName", "David", 2);
        System.out.println("Fighter JSON: " + fighterIndex);
        System.out.println("Tournament JSON: " + tournamentIndex);
    }
}

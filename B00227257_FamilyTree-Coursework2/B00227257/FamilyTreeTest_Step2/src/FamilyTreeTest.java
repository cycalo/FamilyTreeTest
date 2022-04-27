
public class FamilyTreeTest {

    public static void main(String[] args) {
        String ancestorName = Input.getString("Input the ancestors name: ");
        FamilyTree familyTree = new FamilyTree(ancestorName);
        Integer option;
        do {
            System.out.println("\n");
            System.out.println("1 - Add a Partner");
            System.out.println("2 - Add a Child");
            System.out.println("3 - Display Family Tree");
            System.out.println("4 - Display Family Member");
            System.out.println("0 - To quit");

            option = Input.getInteger("input menu number: ");
            System.out.println("\n");

            switch (option) {

                case 1:
                    try {
                    familyTree.addPartner();
                } catch (FamilyNotFoundException e) {
                    System.out.println("not found");
                }
                break;

                case 2:
                    try {
                    familyTree.addChild();
                } catch (FamilyNotFoundException e) {
                    System.out.println("not found");
                }
                break;

                case 3:
                    System.out.print(familyTree); //display family members including ID
                    break;
                case 4:
                    Integer ID = Input.getInteger("Enter the ID number of the family member to display: ");

                    try {
                        System.out.print(familyTree.getFamilyMember(ID));
                    } catch (FamilyNotFoundException e) {
                        System.out.println("not found");
                    }
                    break;
                default:
                    System.out.println("Invalid Option ");
                    break;
            }
        } while (option != 0);
    }
}
